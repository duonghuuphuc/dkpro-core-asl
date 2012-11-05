/*******************************************************************************
 * Copyright 2012
 * Ubiquitous Knowledge Processing (UKP) Lab
 * Technische Universität Darmstadt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package de.tudarmstadt.ukp.dkpro.core.clearnlp;

import static java.util.Arrays.asList;
import static org.apache.commons.io.IOUtils.closeQuietly;
import static org.apache.uima.util.Level.INFO;
import static org.uimafit.util.JCasUtil.select;
import static org.uimafit.util.JCasUtil.selectCovered;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.internal.util.SymbolTable;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Logger;
import org.springframework.beans.DirectFieldAccessor;
import org.springframework.beans.PropertyAccessor;
import org.uimafit.component.JCasAnnotator_ImplBase;
import org.uimafit.descriptor.ConfigurationParameter;

import com.googlecode.clearnlp.classification.model.StringModel;
import com.googlecode.clearnlp.dependency.AbstractDEPParser;
import com.googlecode.clearnlp.dependency.DEPNode;
import com.googlecode.clearnlp.dependency.DEPTree;
import com.googlecode.clearnlp.engine.EngineGetter;
import com.googlecode.clearnlp.engine.EngineProcess;
import com.googlecode.clearnlp.pos.POSNode;
import de.tudarmstadt.ukp.dkpro.core.api.parameter.ComponentParameters;
import de.tudarmstadt.ukp.dkpro.core.api.resources.CasConfigurableProviderBase;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Sentence;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.tudarmstadt.ukp.dkpro.core.api.syntax.type.dependency.Dependency;

/**
 * Clear parser annotator. 
 * 
 * @author Richard Eckart de Castilho
 */
public class ClearNlpDependencyParser
	extends JCasAnnotator_ImplBase
{
	public static final String PARAM_PRINT_TAGSET = ComponentParameters.PARAM_PRINT_TAGSET;
	@ConfigurationParameter(name = PARAM_PRINT_TAGSET, mandatory = true, defaultValue = "false")
	protected boolean printTagSet;

	public static final String PARAM_LANGUAGE = ComponentParameters.PARAM_LANGUAGE;
	@ConfigurationParameter(name = PARAM_LANGUAGE, mandatory = false)
	protected String language;

	public static final String PARAM_VARIANT = ComponentParameters.PARAM_VARIANT;
	@ConfigurationParameter(name = PARAM_VARIANT, mandatory = false)
	protected String variant;

	public static final String PARAM_MODEL_LOCATION = ComponentParameters.PARAM_MODEL_LOCATION;
	@ConfigurationParameter(name = PARAM_MODEL_LOCATION, mandatory = false)
	protected String modelLocation;

	// Not sure if we'll ever have to use different symbol tables
	public static final String SYMBOL_TABLE = "symbolTableName";
	@ConfigurationParameter(name = SYMBOL_TABLE, mandatory = true, defaultValue = "DEPREL")
	private String symbolTableName;

	private Logger logger;
	private SymbolTable symbolTable;
	private File workingDir;

	private CasConfigurableProviderBase<AbstractDEPParser> parserProvider;
		
	@Override
	public void initialize(UimaContext context)
		throws ResourceInitializationException
	{
		super.initialize(context);

		logger = getContext().getLogger();

		parserProvider = new CasConfigurableProviderBase<AbstractDEPParser>()
		{
			{
				setDefault(VERSION, "20121017.0");
				setDefault(GROUP_ID, "de.tudarmstadt.ukp.dkpro.core");
				setDefault(ARTIFACT_ID,
						"de.tudarmstadt.ukp.dkpro.core.clearnlp-model-parser-${language}-${variant}");
				
				setDefault(LOCATION, "classpath:/de/tudarmstadt/ukp/dkpro/core/clearnlp/lib/" +
						"parser-${language}-${variant}.bin");
				setDefault(VARIANT, "ontonotes");
				
				setOverride(LOCATION, modelLocation);
				setOverride(LANGUAGE, language);
				setOverride(VARIANT, variant);
			}

			@Override
			protected AbstractDEPParser produceResource(URL aUrl)
				throws IOException
			{
				InputStream is = null;
				try {
					is = aUrl.openStream();
					AbstractDEPParser parser = EngineGetter.getDEPParser(is);
					
					if (printTagSet) {
						StringBuilder sb = new StringBuilder();
						try {
							List<String> tagList = new ArrayList<String>();
							
							PropertyAccessor accessor = new DirectFieldAccessor(parser);
							StringModel model = (StringModel) accessor.getPropertyValue("s_model");
							tagList.addAll(asList(model.getLabels()));
							
							Collections.sort(tagList);
							
							sb.append("Model contains [").append(tagList.size()).append("] tags: ");
							
							for (String tag : tagList) {
								sb.append(tag);
								sb.append(" ");
							}
						}
						catch (Exception e) {
							sb.append("Unable to find tagset information.");
						}
						
						getContext().getLogger().log(INFO, sb.toString());
					}
					
					return parser;
				}
				catch (Exception e) {
					throw new IOException(e);
				}
				finally {
					closeQuietly(is);
				}
			}
		};
	}

	/**
	 * @see org.apache.uima.AnalysisComponent.AnalysisComponent#collectionProcessComplete()
	 */
	@Override
	public void collectionProcessComplete()
		throws AnalysisEngineProcessException
	{
		if (workingDir != null && workingDir.isDirectory()) {
			FileUtils.deleteQuietly(workingDir);
		}
	}

	@Override
	public void process(JCas aJCas)
		throws AnalysisEngineProcessException
	{
		parserProvider.configure(aJCas.getCas());

		// Iterate over all sentences
		for (Sentence curSentence : select(aJCas, Sentence.class)) {

			// Generate list of tokens for current sentence
			List<Token> tokens = selectCovered(Token.class, curSentence);

			// Generate input format required by parser
			POSNode[] posNodes = new POSNode[tokens.size()];
			for (int i = 0; i < posNodes.length; i++) {
				Token t = tokens.get(i);
				posNodes[i] = new POSNode(t.getCoveredText(), t.getPos().getPosValue());
				if (t.getLemma() != null) {
					posNodes[i].lemma = t.getLemma().getValue();
				}
			}

			DEPTree depTree = EngineProcess.toDEPTree(posNodes);
			for (int i = 1; i < depTree.size(); i++) {
				depTree.get(i).lemma = tokens.get(i-1).getLemma().getValue();
			}
			
			// Parse sentence
			AbstractDEPParser parser = parserProvider.getResource();
			parser.parse(depTree);
		
			for (int i = 1; i < depTree.size(); i++) {
				DEPNode node = depTree.get(i);

				if (node.hasHead()) {
					if (node.getHead().id == 0) {
						// Skip root relation
						continue;
					}
					
					Dependency dep = new Dependency(aJCas, curSentence.getBegin(),
							curSentence.getEnd());
					dep.setGovernor(tokens.get(node.getHead().id-1)); 
					dep.setDependent(tokens.get(node.id-1));
					dep.setDependencyType(node.getLabel());
					dep.addToIndexes();
				}
			}
		}
	}
}
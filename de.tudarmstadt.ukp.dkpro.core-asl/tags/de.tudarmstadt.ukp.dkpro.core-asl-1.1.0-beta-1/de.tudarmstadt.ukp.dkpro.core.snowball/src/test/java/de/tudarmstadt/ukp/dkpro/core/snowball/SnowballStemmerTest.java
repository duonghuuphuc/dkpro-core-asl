/*******************************************************************************
 * Copyright 2010
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
package de.tudarmstadt.ukp.dkpro.core.snowball;

import static org.junit.Assert.assertTrue;
import static org.uimafit.factory.AnalysisEngineFactory.createPrimitive;
import static org.uimafit.factory.TypeSystemDescriptionFactory.createTypeSystemDescription;
import static org.uimafit.util.JCasUtil.iterate;

import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.jcas.JCas;
import org.junit.Test;
import org.uimafit.factory.JCasBuilder;

import de.tudarmstadt.ukp.dkpro.core.api.featurepath.FeaturePathAnnotatorBase;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Stem;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;

public class SnowballStemmerTest
{
	@Test
	public void testGerman()
		throws Exception
	{
		AnalysisEngine engine = createPrimitive(SnowballStemmer.class,
				createTypeSystemDescription(),
				FeaturePathAnnotatorBase.PARAM_PATHS, new String[] { Token.class.getName() } );

		JCas jcas = engine.newJCas();
		jcas.setDocumentLanguage("de");
		JCasBuilder cb = new JCasBuilder(jcas);
		cb.add("Automobile", Token.class);
		cb.add(" ");
		cb.add("Fenster", Token.class);
		cb.close();

		engine.process(jcas);

		int i = 0;
		for (Stem s : iterate(jcas, Stem.class)) {
			assertTrue(i != 0 || "Automobil".equals(s.getValue()));
			assertTrue(i != 1 || "Fenst".equals(s.getValue()));
			i ++;
		}
	}

	@Test
	public void testEnglish()
		throws Exception
	{
		AnalysisEngine engine = createPrimitive(SnowballStemmer.class,
				createTypeSystemDescription(),
				FeaturePathAnnotatorBase.PARAM_PATHS, new String[] { Token.class.getName() } );

		JCas jcas = engine.newJCas();
		jcas.setDocumentLanguage("en");
		JCasBuilder cb = new JCasBuilder(jcas);
		cb.add("computers", Token.class);
		cb.add(" ");
		cb.add("Computers", Token.class);
		cb.add(" ");
		cb.add("deliberately", Token.class);
		cb.close();

		engine.process(jcas);

		int i = 0;
		for (Stem s : iterate(jcas, Stem.class)) {
			assertTrue(i != 0 || "comput".equals(s.getValue()));
			assertTrue(i != 1 || "Comput".equals(s.getValue()));
			assertTrue(i != 2 || "deliber".equals(s.getValue()));
			i ++;
		}

		i = 0;
		for (Token t : iterate(jcas, Token.class)) {
			assertTrue(i != 0 || "comput".equals(t.getStem().getValue()));
			assertTrue(i != 1 || "Comput".equals(t.getStem().getValue()));
			assertTrue(i != 2 || "deliber".equals(t.getStem().getValue()));
			i ++;
		}
	}
}

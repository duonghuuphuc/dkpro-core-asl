/*******************************************************************************
 * Copyright 2013
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
package de.tudarmstadt.ukp.dkpro.core.morpha;

import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;
import static org.apache.uima.fit.util.JCasUtil.select;

import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.jcas.JCas;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Stem;
import de.tudarmstadt.ukp.dkpro.core.opennlp.OpenNlpPosTagger;
import de.tudarmstadt.ukp.dkpro.core.testing.AssertAnnotations;
import de.tudarmstadt.ukp.dkpro.core.testing.TestRunner;

public class MorphaStemmerTest
{
	@Test
	public void testEnglishNoPos()
		throws Exception
	{
		JCas jcas = runTest("en", false, "We need a very complicated example sentence , which " +
			"contains as many constituents and dependencies as possible .");

        String[] lemmas = new String[] { "We", "need", "a", "very", "complicate", "example",
                "sentence", ",", "which", "contain", "as", "many", "constituent", "and",
                "dependency", "as", "possible", "." };

		AssertAnnotations.assertStem(lemmas, select(jcas, Stem.class));
	}
	
    @Test
    public void testEnglishWithPos()
        throws Exception
    {
        JCas jcas = runTest("en", true, "We need a very complicated example sentence , which " +
            "contains as many constituents and dependencies as possible .");

        String[] lemmas = new String[] { "We", "need", "a", "very", "complicated", "example",
                "sentence", ",", "which", "contain", "as", "many", "constituent", "and",
                "dependency", "as", "possible", "." };

        AssertAnnotations.assertStem(lemmas, select(jcas, Stem.class));
    }
    
	private JCas runTest(String aLanguage, boolean aUsePosTags, String aText)
		throws Exception
	{
        AnalysisEngineDescription engine;
        
        if (aUsePosTags) {
            engine = createEngineDescription(
                    createEngineDescription(OpenNlpPosTagger.class),
                    createEngineDescription(MorphaStemmer.class,
                            MorphaStemmer.PARAM_READ_POS, true));
        }
        else {
            engine = createEngineDescription(
                    createEngineDescription(MorphaStemmer.class));
        }

        return TestRunner.runTest(engine, aLanguage, aText);
	}
	

	@Rule
	public TestName name = new TestName();

	@Before
	public void printSeparator()
	{
		Runtime.getRuntime().gc();
		Runtime.getRuntime().gc();
		Runtime.getRuntime().gc();
		
		System.out.println("\n=== " + name.getMethodName() + " =====================");
	}
}

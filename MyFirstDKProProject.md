<h1>First Programming Steps with DKPro Core</h1>

_by Steven Burrows (2013), Richard Eckart de Castilho (2012),  Erik-Lân Do Dinh (2011), and Michael Matuschek (2009)_



This small tutorial will show you how to build your first small application with DKPro Core, from creating a new project to your first annotated document. Please make sure your environment is properly set up as described [here](UserSetup.md) before you start.

**Note for the impatient: If you want to get into DKPro Core even faster, you can use our [cut and paste recipes](DKProGroovyCookbook.md) with Groovy.**

## Prerequisites ##

This tutorial assumes that you have:

  * Java 7 SDK or higher
  * Eclipse 4.3.x
  * Maven Integration for Eclipse (M2E) plugin installed
  * DKPro Core ASL 1.7.0 or higher

## Create a project ##

**Note:** When adding dependencies, make sure you do not add **SNAPSHOT** versions. We recommend you always use the latest non-SNAPSHOT version.

  * Go to the **Package Explorer** in Eclipse and create new a **Maven Project**. On the first page of the properties dialogue, tick **Create a simple project (skip archetype selection)**.
  * On the next page, you have to choose a **group id** and **artifact id** for your project. Since this is only an experimental setup for playing around, your project should be kept seperate from the actual DKPro stuff. I suggest **de.tudarmstadt.ukp.experiments.xx** as group id and **de.tudarmstadt.ukp.experiments.xx.gettingstarted** as artifact id, where xx would be your initials.
  * Set a parent project which will already configure some aspects of your code (e.g. UTF-8 as source encoding, Java 1.6, etc.). Browse for **de.tudarmstadt.ukp.dkpro.core-asl**, and you should find the **de.tudarmstadt.ukp.dkpro.core-asl** artifact. Make sure you pick the newest version by clicking on the small arrow next to the search result. Leave all other options on default and click **finish**.

**Note**: If Eclipse fails to find the **de.tudarmstadt.ukp.dkpro.core-asl** POM when you search for it, enter the following fields manually:
  * **groupId:** de.tudarmstadt.ukp.dkpro.core
  * **artifactId:** de.tudarmstadt.ukp.dkpro.core-asl
  * **version:** 1.7.0 (or higher)

**Note**: If you do not wish to inherit from the **de.tudarmstadt.ukp.dkpro.core-asl** POM, you need to perform [an extra step](UkpMavenRepository#Configuring_a_project_for_access_to_models.md) to be able to access the models (e.g. parser models, tagger models, etc.) from the public UKP Maven repository.

## Configure the POM ##

  * Now that your project is created, open **pom.xml** from your project's root directory. Jump to the **Dependencies** tab right away and don't worry about the other stuff now. In the **Dependency Management** pane, click **Add...** to browse for the DKPro Core ASL aggregator artifact **de.tudarmstadt.ukp.dkpro.core-asl**. Add it in the latest version, then change the type to **pom** and the scope to **import**. By doing this, you may omit specifying the version when adding dependencies on processing components. Maven will automatically use the right versions for the DKPro version that you have imported.
  * Save the POM now.
  * Now add the actual dependencies for the processing components:
    * **de.tudarmstadt.ukp.dkpro.core.io.text-asl**
    * **de.tudarmstadt.ukp.dkpro.core.tokit-asl**
    * **de.tudarmstadt.ukp.dkpro.core.opennlp-asl**
  * Check that all dependencies have the type **jar** and the scope **compile**.
  * For the JUnit dependency, set the scope to **test**, and leave the default scope for the others. We'll use JUnit later on to test if everything works.
  * Save the POM (Ctrl + S) and let Maven automatically resolve the dependencies.
  * Congratulations, you're all set, now let's jump into it.

**Note**: If Eclipse fails to find the artifacts listed above when you search for it, enter the following fields manually:
  * **groupId:** de.tudarmstadt.ukp.dkpro.core
  * **artifactId:** _dependency name given above_
  * **version:** 1.7.0

## Create your first experiment ##

  * The folder structure for the project has automatically been created. We'll start by writing a test to check if the project is set up properly, so we put our code into **src/test/java**. Create a new package here with the same name as your project, **de.tudarmstadt.ukp.experiments.xx.gettingstarted**.
  * Now create a Java class in this package to finally start coding. I suggest picking a telling name like **InitialProjectRunner**, but it's up to you. Leave the default setting for all other options.
  * Now it's time to finally create the main method.
```
   public static void main(String[] args) throws Exception {
   
   }
```

  * Now we can start processing some documents. We will read files from the file system, we use a **TextReader**, tell it where to find the documents and select a language which language they are in. Add the **import** lines - you know where. I won't mention that from now on.
```
   import org.apache.uima.collection.CollectionReaderDescription;
   import de.tudarmstadt.ukp.dkpro.core.io.text.TextReader;
   import static org.apache.uima.fit.factory.CollectionReaderFactory.*;

   CollectionReaderDescription cr = createReaderDescription(
         TextReader.class,
         TextReader.PARAM_SOURCE_LOCATION, "src/test/resources/",
         TextReader.PARAM_PATTERNS, new String[] { "[+]*.txt" },
         TextReader.PARAM_LANGUAGE, "en");
```
  * Next we want to analyze the documents. For this we need the description of the analysis engines we want to use, and they can be created like this:
```
   import org.apache.uima.analysis_engine.AnalysisEngineDescription;
   import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;
   import static org.apache.uima.fit.factory.AnalysisEngineFactory.*;

   AnalysisEngineDescription seg = createEngineDescription(BreakIteratorSegmenter.class);
```

> This particular analysis engine is responsible for breaking a document into sentences and words (tokens). Now we'll create a description for an engine which annotates the words with their part of speech (e.g. as a verb, noun, etc.):
```
   import de.tudarmstadt.ukp.dkpro.core.opennlp.OpenNlpPosTagger;
   
   AnalysisEngineDescription tagger = createEngineDescription(OpenNlpPosTagger.class);
```
  * Now we want to save our analysis results, so we can actually look at them. For this purpose we use the **CASDumpWriter** to write all the information to a file (output.txt).
```
   import org.apache.uima.fit.component.CasDumpWriter;
   
   AnalysisEngineDescription cc = createEngineDescription(
         CasDumpWriter.class,
         CasDumpWriter.PARAM_OUTPUT_FILE, "target/output.txt");
```
  * Finally, we need to consecutively read the documents, analyses them and then writes the analysis results to a file. Hence, we combine these separate parts into a pipeline:
```
   import static org.apache.uima.fit.pipeline.SimplePipeline.*;

   runPipeline(cr, seg, tagger, cc);
```

> Congratulations, well done! The complete program should look like this:
```
   package de.tudarmstadt.ukp.experiments.xx.gettingstarted;

   import static org.apache.uima.fit.factory.AnalysisEngineFactory.*;
   import static org.apache.uima.fit.factory.CollectionReaderFactory.*;
   import static org.apache.uima.fit.pipeline.SimplePipeline.*;

   import org.apache.uima.analysis_engine.AnalysisEngineDescription;
   import org.apache.uima.collection.CollectionReaderDescription;
   import org.apache.uima.fit.component.CasDumpWriter;

   import de.tudarmstadt.ukp.dkpro.core.io.text.TextReader;
   import de.tudarmstadt.ukp.dkpro.core.opennlp.OpenNlpPosTagger;
   import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;

   public class InitialProjectRunner
   {
      public static void main(String[] args) throws Exception
      {
         CollectionReaderDescription cr = createReaderDescription(
            TextReader.class,
            TextReader.PARAM_SOURCE_LOCATION, "src/test/resources/*.txt",
            TextReader.PARAM_LANGUAGE, "en");
		
         AnalysisEngineDescription seg = createEngineDescription(BreakIteratorSegmenter.class);
	   
         AnalysisEngineDescription tagger = createEngineDescription(OpenNlpPosTagger.class);
	   
         AnalysisEngineDescription cc = createEngineDescription(
            CasDumpWriter.class,
            CasDumpWriter.PARAM_OUTPUT_FILE, "target/output.txt");
	   
         runPipeline(cr, seg, tagger, cc);
      }
   }
```
  * If there are no documents in your specified input folder, the test will fail. Create a text document called **text01.txt** in your **src/test/resources** folder and add the following content:
```
This is a testing file for my pipeline.
```

## Running the pipeline ##
  * To run the test, right-click on the class in the Package Explorer and select **Run As -> Java Application**.
  * Open the target folder in the package explorer.
  * If the test works out fine, your output file _output.txt_ should look something like this:
```
======== CAS 0 begin ==================================

-------- View _InitialView begin ----------------------------------

DocumentMetaData
   sofa: _InitialView
   begin: 0
   end: 39
   language: "en"
   documentTitle: "text01.txt"
   documentId: "text01.txt"
   isLastSegment: false

CAS-Text:
This is a testing file for my pipeline.
[This is a testing file for my pipeline.]
Sentence
   sofa: _InitialView
   begin: 0
   end: 39
[This]
Token
   sofa: _InitialView
   begin: 0
   end: 4
   parent: <null>
   lemma: <null>
   stem: <null>
   pos: ART
      sofa: _InitialView
      begin: 0
      end: 4
      PosValue: "DT"
[This]
ART
   sofa: _InitialView
   begin: 0
   end: 4
   PosValue: "DT"
[is]
V
   sofa: _InitialView
   begin: 5
   end: 7
   PosValue: "VBZ"
[is]
Token
   sofa: _InitialView
   begin: 5
   end: 7
   parent: <null>
   lemma: <null>
   stem: <null>
   pos: V
      sofa: _InitialView
      begin: 5
      end: 7
      PosValue: "VBZ"
[a]
Token
   sofa: _InitialView
   begin: 8
   end: 9
   parent: <null>
   lemma: <null>
   stem: <null>
   pos: ART
      sofa: _InitialView
      begin: 8
      end: 9
      PosValue: "DT"
[a]
ART
   sofa: _InitialView
   begin: 8
   end: 9
   PosValue: "DT"
[testing]
NN
   sofa: _InitialView
   begin: 10
   end: 17
   PosValue: "NN"
[testing]
Token
   sofa: _InitialView
   begin: 10
   end: 17
   parent: <null>
   lemma: <null>
   stem: <null>
   pos: NN
      sofa: _InitialView
      begin: 10
      end: 17
      PosValue: "NN"
[file]
NN
   sofa: _InitialView
   begin: 18
   end: 22
   PosValue: "NN"
[file]
Token
   sofa: _InitialView
   begin: 18
   end: 22
   parent: <null>
   lemma: <null>
   stem: <null>
   pos: NN
      sofa: _InitialView
      begin: 18
      end: 22
      PosValue: "NN"
[for]
PP
   sofa: _InitialView
   begin: 23
   end: 26
   PosValue: "IN"
[for]
Token
   sofa: _InitialView
   begin: 23
   end: 26
   parent: <null>
   lemma: <null>
   stem: <null>
   pos: PP
      sofa: _InitialView
      begin: 23
      end: 26
      PosValue: "IN"
[my]
PR
   sofa: _InitialView
   begin: 27
   end: 29
   PosValue: "PRP$"
[my]
Token
   sofa: _InitialView
   begin: 27
   end: 29
   parent: <null>
   lemma: <null>
   stem: <null>
   pos: PR
      sofa: _InitialView
      begin: 27
      end: 29
      PosValue: "PRP$"
[pipeline]
NN
   sofa: _InitialView
   begin: 30
   end: 38
   PosValue: "NN"
[pipeline]
Token
   sofa: _InitialView
   begin: 30
   end: 38
   parent: <null>
   lemma: <null>
   stem: <null>
   pos: NN
      sofa: _InitialView
      begin: 30
      end: 38
      PosValue: "NN"
[.]
PUNC
   sofa: _InitialView
   begin: 38
   end: 39
   PosValue: "."
[.]
Token
   sofa: _InitialView
   begin: 38
   end: 39
   parent: <null>
   lemma: <null>
   stem: <null>
   pos: PUNC
      sofa: _InitialView
      begin: 38
      end: 39
      PosValue: "."
-------- View _InitialView end ----------------------------------

======== CAS 0 end ==================================
```
> Here you see the different annotations which have been made.

Congratulations, you've built your first simple pipeline, now feel free to modify your program and maybe play with the other annotators that come with DKPro to see how they work.

**Note on quality:** _The_BreakIteratorSegmenter_may segment text in a different manner than the other analysis components expect. If you need high quality and have the possibility to used GPL code, we recommend using the_[StanfordSegmenter](http://dkpro-core-gpl.googlecode.com/svn/de.tudarmstadt.ukp.dkpro.core-gpl/tags/de.tudarmstadt.ukp.dkpro.core-gpl-1.3.0/apidocs/index.html)_from [DKPro Core GPL](http://dkpro-core-gpl.googlecode.com) instead. Add_de.tudarmstadt.ukp.dkpro.core-gpl_with type **pom** and scope **import** to dependency management and_de.tudarmstadt.ukp.dkpro.core.stanfordnlp-gpl
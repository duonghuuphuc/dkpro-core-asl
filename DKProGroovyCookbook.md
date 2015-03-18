<h1>Introduction</h1>

This assumes that you have installed [Groovy](http://groovy.codehaus.org) and that you have the command `groovy` available in your path. On Debian/Ubuntu systems, installing Groovy should be as easy as `apt-get install groovy`.

**Note: An [incompatibility](http://stackoverflow.com/questions/23504261/dkpro-groovy-usage-and-installation-with-uima) has been reported with Groovy version 2.3.0. Please use a 2.1.x or 2.2.x version or even version 2.3.1 or higher. (See also: [GROOVY-6768](http://jira.codehaus.org/browse/GROOVY-6768))**

Copy one of the scripts into a simple text file (e.g. `pipeline`). Make the file executable (e.g. `chmod +x pipeline`). Then run it (e.g. `./pipeline`). The first time this will take quite long because libraries and models are automatically downloaded.

If you encounter problems, please refer to our [Groovy trouble-shooting guide](DKProGroovyTroubleShooting.md).

# Recipes #

  * [NLTK intro examples ported to DKPro Core](GroovyPortedNltkIntroExamples.md)

**Building pipelines:** four different approaches to running a simple part-of-speech pipeline

  * [OpenNLP Part-of-speech tagging pipeline writing to IMS Open Corpus Workbench format](GroovyOpenNlpPosTagWriteCwb.md)
  * [OpenNLP Part-of-speech tagging pipeline using custom writer component](GroovyOpenNlpPosTagWriteCustom.md)
  * [OpenNLP Part-of-speech tagging pipeline with direct access to results](GroovyOpenNlpPosTagAccessDirect.md)
  * [OpenNLP Part-of-speech tagging & parsing without reader](GroovyOpenNlpPosTagNoReader.md)

**Dependency parsing**

  * [MaltParser dependency parsing pipeline with direct access to results](GroovyMaltParserAccessDirect.md)
  * [MaltParser dependency parsing pipeline writing to CONLL format](GroovyMaltParserWriteConll2006.md)

**Mixing components**

  * [Fully mixed pipeline](GroovyFullyMixed.md)

**Conversion between corpus formats**

  * [Convert a corpus at CONLL 2006 format to CONLL 2009](GroovyConvertConll2006To2009.md)

**Normalization**

  * [Normalizing a text with UmlautNormalizer](GroovyUmlautNormalization.md)

**Evaluation**

  * [Script to evaluate segmenters](GroovySegmenterEvaluator.md)

**Other**

  * [Decompounding without a ranker resource](GroovyDecompounding.md)
  * [TreeTagger using manually downloaded executable and model](GroovyTreeTaggerPosTagNoReaderAccessDirect.md)
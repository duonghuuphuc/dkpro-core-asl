<table>
<tr>
<td width='100%' valign='top'>
<p>
<b>News: DKPro Core 1.6.1 released (<a href='ReleaseNotes_1_6_1.md'>release notes</a>)</b>

DKPro Core is a collection of software components for natural language processing (NLP) based on the Apache UIMA framework. This project was initiated by the <a href='http://www.ukp.tu-darmstadt.de/'>Ubiquitous Knowledge Processing Lab</a> (UKP) at the Technische Universität Darmstadt, Germany under the auspices of Prof. Dr. Iryna Gurevych.<br>
</p>

Many powerful and state-of-the-art NLP tools are already freely available in the NLP research community. New and improved tools are being developed and released continuously. The tools cover the whole range of NLP-related processing tasks. DKPro Core provides UIMA components wrapping these tools so they can be used interchangeably in processing pipelines. We also provide several original components. DKPro Core builds heavily on <a href='http://code.google.com/p/uimafit/'>uimaFIT</a> which allows for rapid and easy development of NLP processing pipelines, for wrapping existing tools and for creating original UIMA components.<br>
<br>
This project contains those components of DKPro Core that are licensed under the Apache Software License (ASL) version 2.<br>
Additional components are available in the sister project <a href='http://code.google.com/p/dkpro-core-gpl'>DKPro Core GPL</a>.<br>
<br>
<h4>To get a taste...</h4>

... of the components types included in DKPro Core here is a brief (incomplete) list. Components marked with <b>†</b> are in <a href='http://dkpro-core-gpl.googlecode.com'>DKPro Core GPL</a>, the rest in ASL:<br>
<br>
<ul><li>tokenization/segmentation (BreakIterator, OpenNLP, LanguageTool, Stanford CoreNLP†)<br>
</li><li>compound splitting (Banana Split, JWordSplitter, ASV Toolbox)<br>
</li><li>stemming (Snowball)<br>
</li><li>lemmatization (ClearNLP, TreeTagger)<br>
</li><li>part-of-speech tagging (ClearNLP, TreeTagger, OpenNLP, Mecab, Stanford CoreNLP†)<br>
</li><li>morphological analysis (SFST†)<br>
</li><li>syntactic parsing (OpenNLP, Stanford CoreNLP†, Berkeley Parser†)<br>
</li><li>dependency parsing (ClearNLP, MaltParser, MstParser, Stanford CoreNLP†)<br>
</li><li>coreference resolution (Stanford CoreNLP†)<br>
</li><li>language identification (TextCat)<br>
</li><li>spelling correction (Jazzy)<br>
</li><li>grammar checking (LanugageTool)<br>
</li><li>IO support for various corpus formats (text, NEGRA, CONLL, TEI, TIGER-XML, BNC-XML, XML, PDF, Wikipedia Database, IMS Open Corpus Workbench...)<br>
</li><li><a href='WorkingWithNGrams.md'>Working with n-grams</a>
</li><li>...<a href='http://dkpro-core-asl.googlecode.com/svn/de.tudarmstadt.ukp.dkpro.core-asl/tags/latest-release/apidocs/index.html'>JavaDocs</a> ...<br>
</li><li>... <a href='http://dkpro-core-gpl.googlecode.com/svn/de.tudarmstadt.ukp.dkpro.core-gpl/tags/latest-release/apidocs/index.html'>yet more components under the GPL license</a> ...<br>
</td>
<td valign='top'>
<wiki:gadget url="http://www.ohloh.net/p/487652/widgets/project_factoids_stats.xml" width="400" height="270" border="1"/><br />
<table>
<tr>
<td valign='middle'><wiki:gadget url="http://www.ohloh.net/p/487652/widgets/project_users_logo.xml" height="43" border="0"/><br>
</td>
</tr>
</table>
</td>
</tr>
</table></li></ul>

#### Who is using DKPro Core? ####

  * [Search Google Scholar](http://scholar.google.de/scholar?q=%22DKPro+Core%22) to find publications referring "DKPro Core"
  * [Search Ohloh Code](http://code.ohloh.net/search?s=%22de.tudarmstadt.ukp.dkpro.core%22) to find code referring to "de.tudarmstadt.ukp.dkpro.core"

#### Other DKPro products ####
  * [DKPro Keyphrases](http://code.google.com/p/dkpro-keyphrases/) - keyphrase extraction
  * [DKPro Lab](http://code.google.com/p/dkpro-lab/) - experimental workflows
  * [DKPro Similarity](http://code.google.com/p/dkpro-similarity-asl/) - text similarity
  * [DKPro Spelling](http://code.google.com/p/dkpro-spelling-asl/) - real-world spelling errors
  * [DKPro WSD](http://code.google.com/p/dkpro-wsd/) - word sense disambiguation

#### Using DKPro Core ####

To set up your development environment to use DKPro with Maven, please follow [these instructions](UserSetup.md).

#### Code example ####

```
CollectionReaderDescription reader = createReaderDescription(
  TextReader.class,
  TextReader.PARAM_PATH, "src/test/resources/text",
  TextReader.PARAM_PATTERNS, new String[] { "[+]*.txt", "[-]broken.txt" },
  TextReader.PARAM_LANGUAGE, "en");

AnalysisEngineDescription tokenizer = createEngineDescription(
  BreakIteratorSegmenter.class);

AnalysisEngineDescription nameFinder = createEngineDescription(
  DictionaryAnnotator.class,
  DictionaryAnnotator.PARAM_PHRASE_FILE, "src/test/resources/dictionaries/names.txt",
  DictionaryAnnotator.PARAM_ANNOTATION_TYPE, Name.class);

AnalysisEngineDescription writer = createEngineDescription(
  CasDumpWriter.class,
  CasDumpWriter.PARAM_OUTPUT_FILE, "target/output.txt");

SimplePipeline.runPipeline(reader, tokenizer, nameFinder, writer);
```

The full source code for this example can be found in our [example project](https://dkpro-core-asl.googlecode.com/svn/de.tudarmstadt.ukp.dkpro.core-asl/tags/latest-release/de.tudarmstadt.ukp.dkpro.core.examples-asl).

Not all components are equally well documented and tested. This is being worked on. If you run into problems, please  [tell us](https://groups.google.com/forum/?fromgroups#!forum/dkpro-core-user), so we learn where improvements need to be made.

#### How to cite? ####

**IMPORTANT NOTE FOR RESEARCHERS** - If you use DKPro components in your research and publish about it, please be aware that many of the wrapped third-party components and the models used by them can and should be cited individually. We currently do not provide a comprehensive overview over citable publications and may or may not do so in the future. For the time being we would like to encourage you, to track down citable publications yourself.

Please do consider citing DKPro Core using one of the following references:

  * Eckart de Castilho, R. and Gurevych, I. (2014). **A broad-coverage collection of portable NLP components for building shareable analysis pipelines**. In _Proceedings of the Workshop on Open Infrastructures and Analysis Frameworks for HLT (OIAF4HLT) at COLING 2014_, Dublin, Ireland [(pdf)](https://www.ukp.tu-darmstadt.de/fileadmin/user_upload/Group_UKP/OIAF4HLT2014DKProCore_cameraready.pdf) [(bib)](https://www.ukp.tu-darmstadt.de/publications/details/?no_cache=1&tx_bibtex_pi1%5Bpub_id%5D=TUD-CS-2014-0864#)
  * Eckart de Castilho, R. and Gurevych, I. (2009). **A Flexible Data-Cleansing Approach to Processing User-Generated Discourse**. In _Proceedings of the First French-speaking meeting around the framework Apache UIMA_, online, Nantes, France. ACM. [(pdf)](http://www.ukp.tu-darmstadt.de/fileadmin/user_upload/Group_UKP/publikationen/2009/rmll-uima-fr-2009.pdf) [(bib)](http://www.ukp.tu-darmstadt.de/publications/details/?no_cache=1&tx_bibtex_pi1%5Bpub_id%5D=TUD-CS-2009-0078&type=99&tx_bibtex_pi1%5Bbibtex%5D=yes)
  * Gurevych, I., Mühlhäuser, M., Müller, C., Steimle, J., Weimer, M, and Zesch, T. (2007). **Darmstadt Knowledge Processing Repository Based on UIMA**. In _Proceedings of the First Workshop on Unstructured Information Management Architecture at Biannual Conference of the Society for Computational Linguistics and Language Technology_, online, Tübingen, Germany. [(pdf)](http://www.ukp.tu-darmstadt.de/fileadmin/user_upload/Group_UKP/publikationen/2007/gldv-uima-ukp.pdf) [(bib)](http://www.ukp.tu-darmstadt.de/publications/details/?no_cache=1&tx_bibtex_pi1%5Bpub_id%5D=GurevychEtal2007dkpro0)
  * a simple URL reference, e.g. in a footnote to `http://code.google.com/p/dkpro-core-asl/`.

#### Feedback ####

We would love to know if you use DKPro Core in your work or research. If you like DKPro Core, have questions, comments or just want to tell us that you use DKPro Core, please write us a small post to the [DKPro Core User Group](https://groups.google.com/forum/?fromgroups#!forum/dkpro-core-user).

#### License ####

All components in DKPro Core ASL are licensed under the Apache Software License (ASL) version 2 - but their dependencies may not be:

**IMPORTANT LICENSE NOTE** - It must be pointed out that while the component's source code itself is licensed under the ASL, individual components might make use of third-party libraries or products that are **not** licensed under the ASL, such as LGPL libraries or libraries which are free for research but may not be used in commercial scenarios. Please make sure that you are aware of the third party licenses and respect them.
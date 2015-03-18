DKPro Core ASL 1.4.0 is a major release. It is not expected to be binary backwards compatible with previous versions. This page lists some of the more important changes and caveats regarding this version. For more detailed information on the changes in this version, please refer to the [issue tracker](http://code.google.com/p/dkpro-core-asl/issues/list?can=1&q=label:Milestone-1.4.0&sort=status&colspec=ID%20Type%20Status%20Priority%20Milestone%20Compatible%20Owner%20Summary) or to the Subversion history.

## General ##

  * First release on Maven Central.
  * New infrastructure and parameters for loading models and configuring type mapping.
  * New versioning scheme for models and standardized model artifact names.
  * Changed various parameters in all components to follow a common naming scheme.
  * Added support to print tagset information when a model is loaded in most components
  * Added various new and updated mappings for POS tags (Chinese, English, Estonian, French, German, ...).
  * Added modules to support unit tests and to measure performance
  * Fixed problems with paths containing spaces and paths on Windows systems
  * Added support for POS mapping in various readers
  * Changed types for compound words

## Analysis modules ##

  * Added modules
    * Mecab - part-of-speech tagger for Japanese
    * MaltParser - dependency parser

### CAS transformation module ###

  * Fixed several bugs
  * Improved performance (slightly)

### JWordSplitter integration module ###

  * Changed to current JWordSplitter version

### LanguageTool integration module ###

  * Changed to LanguageTool 1.9
  * Added LanguageToolSegmenter - supports many languages

### OpenNLP integration module ###

  * Added OpenNlpParser
  * Added OpenNlpPosTagger
  * Added OpenNlpSegmenter

### Tokenizer module ###

  * Added TokenMerger component to merge multi-word named entities into a single token

## I/O modules ##

  * Added modules
    * bincas - binary serialization for CAS, much faster than XMI
    * JdbcReader - generic reader for SQL databases
  * Added parameter to escape characters when document ID is used as a file name.
  * Added support for more compression methods in most writers
  * Added support for custom Spring resource loaders, e.g. to support reading from HDFS using Spring Hadoop

### IMS Open Corpus Workbench Support ###

  * Added support compressing using cwb-huffcode and cwb-compress-rdx
  * Added support to write coarse part-of-speech tags (DKPro type names)
  * Added support to better handle WaCky corpora, e.g. to generate document IDs

## PDF support ##

  * Changed to pdfbox 1.7.0
  * Changed to extend ResourceCollectionReaderBase
  * Added parameters to control start and end page
  * Added support for progress information

## Text support ##

  * Added parameter to control extension of written text files

## TEI support ##

  * Added support for Digitale Bibliothek of TextGrid
  * Added support for TEI documents with multiple texts inside.

## Web1t support ##

  * Added option to generate lowercase ngrams (off by default)
  * Added option to generate jweb1t indexed (on by default)
  * Added possibility to write all ngrams to one file by setting threshold to 0 or negative

## Wikipedia support ##

  * Added support for reading a predefined set of revisions with the WikipediaRevisionReader.
  * Improved template cleaning
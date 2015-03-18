We are pleased to announce the release of

**DKPro Core, version 1.5.0 (ASL & GPL)**

a collection of interoperable software components for natural language
processing (NLP) based on the Apache UIMA framework.

  * http://code.google.com/p/dkpro-core-asl
  * http://code.google.com/p/dkpro-core-gpl

The release brings new modules to DKPro Core:

## New API modules ##

  * api.phonetics    - Annotation types for the phonetic level
  * api.semantics    - Annotation types for semantic information (semantic fields and semantic role labelling)

## New I/O modules ##

  * io.conll         - Reader and writer for the CONLL 2006 format
  * io.tcf           - Reader and writer for the CLARIN TCF format
  * io.tgrep         - Writer for TGrep2 corpus files
  * io.tiger         - Reader for the Tiger XML format

## New analysis modules ##

  * commonscodec     - Phonetic transcription based on the Apache Commons Codec library
  * decompounding    - Flexible set of components for decompounding, based on different splitting and ranking algorithms
  * mate-tools       - Wrapper for the mate-tools suite
  * morpha           - Wrapper for the morpha stemmer/lemmatizer
  * mstparser        - Wrapper for the mstparser
  * sfst             - New module for SFST-based morphological analyzers
  * umlautnormalizer - Normalizer for umlauts in German texts (ASL)

Further highlights in this release include:

  * Added support for resolving models from remote repositories at runtime
  * Added @TypeCapabilities annotations declaring which annotations they consume and produce
  * Added auto-generated XML descriptors for UIMA components (via uimafit-maven-plugin)
  * Added support for ClearNLP Semantic Role Labelling
  * Added support for GATE Hepple POS tagger
  * Added support for OpenNLP parser and name finder
  * Upgrade to Apache uimaFIT 2.0.0
  * Upgrade to Apache UIMA 2.4.2
  * Updated to ArkTweet-NLP 0.3.2
  * Upgrade to ClearNLP 1.3.1
  * Upgrade to CoreNLP 3.2.0
  * Upgrade to GATE 7.1
  * Upgrade to jweb1t 1.3.0
  * Upgrade to LanguageTool 2.2
  * Upgrade to Maltparser 1.7.2
  * Upgrade to Mate-Tools anna 3.5
  * Upgrade to OpenNLP 1.5.3

Some modules are no longer maintained and were not considered of use for the general public, e.g. the io.mmax2 module and the io.wsdl module. They have been retired and are not included in this release.

When upgrading, please mind that you should not mix different versions of DKPro Core components in your projects - they may not be compatible with each other.
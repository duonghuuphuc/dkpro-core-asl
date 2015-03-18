We are pleased to announce the release of

**DKPro Core, version 1.8.0 (ASL & GPL)**

a collection of interoperable software components for natural language
processing (NLP) based on the Apache UIMA framework.

  * http://code.google.com/p/dkpro-core-asl
  * http://code.google.com/p/dkpro-core-gpl

## Major improvements ##

  * Improved support for morphological analysis through new MorphologicalFeatures type

## Analysis components ##

  * ...

## Data formats ##

  * ...

Further highlights in this release include:

  * Requires Java 8 ([Issue 369](https://code.google.com/p/dkpro-core-asl/issues/detail?id=369))
  * Upgrade [Apache UIMA](http://uima.apache.org) to version 2.7.0 ([Issue 533](https://code.google.com/p/dkpro-core-asl/issues/detail?id=533))
  * Upgrade [Stanford CoreNLP](http://nlp.stanford.edu/software/corenlp.shtml) to version 3.5.0 ([Issue 508](https://code.google.com/p/dkpro-core-asl/issues/detail?id=508))
  * Support additional [SFST](https://code.google.com/p/cistern/wiki/SFST) models: [SMOR](https://code.google.com/p/cistern/wiki/SMOR)
  * Integration of MateTools SRL

A more detailed overview of the changes in this release can be found [here](https://code.google.com/p/dkpro-core-asl/issues/list?can=1&q=milestone%3D1.8.0&colspec=ID+Type+Status+Priority+DKPro+Module+Milestone+Owner+Summary&cells=tiles).

When upgrading, please mind that you should not mix different versions of DKPro Core components in your projects - they may not be compatible with each other.
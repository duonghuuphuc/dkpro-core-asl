We are pleased to announce the release of

**DKPro Core, version 1.6.1 (ASL & GPL)**

a collection of interoperable software components for natural language processing

(NLP) based on the Apache UIMA framework.

  * http://code.google.com/p/dkpro-core-asl
  * http://code.google.com/p/dkpro-core-gpl

Changed requirements:

  * UIMAJ SDK 2.6.0
  * uimaFIT 2.1.0

Major improvements:

  * Many writers can now write to ZIP files
  * Better support for reading/writing binary CAS formats

Major bug fixes:

  * treetagger - NPE when explicitly specifying a model
  * stanfordnlp - StanfordPosTagger not applying PTB3 escaping


A more detailed overview of the changes in this release can be found [here](https://code.google.com/p/dkpro-core-asl/issues/list?can=1&q=label:Milestone-1.6.1)

When upgrading, please mind that you should not mix different versions of DKPro Core components in your projects - they may not be compatible with each other.
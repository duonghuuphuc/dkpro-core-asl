We are pleased to announce the release of

**DKPro Core, version 1.6.2 (ASL & GPL)**

a collection of interoperable software components for natural language processing

(NLP) based on the Apache UIMA framework.

  * http://code.google.com/p/dkpro-core-asl
  * http://code.google.com/p/dkpro-core-gpl

Bug fixes:

  * io.conll - Conll2006Reader does not support POS-tag mapping
  * io.tcf - Dependencies leak between sentences
  * opennlp - Unable to set model of OpenNlpSegmenter


A more detailed overview of the changes in this release can be found [here](https://code.google.com/p/dkpro-core-asl/issues/list?can=1&q=label:Milestone-1.6.2)

When upgrading, please mind that you should not mix different versions of DKPro Core components in your projects - they may not be compatible with each other.
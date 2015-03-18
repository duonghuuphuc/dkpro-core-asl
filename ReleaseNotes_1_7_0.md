We are pleased to announce the release of

**DKPro Core, version 1.7.0 (ASL & GPL)**

a collection of interoperable software components for natural language
processing (NLP) based on the Apache UIMA framework.

  * http://code.google.com/p/dkpro-core-asl
  * http://code.google.com/p/dkpro-core-gpl

## Analysis components ##

  * hunpos - wrapper for [hunpos](https://code.google.com/p/hunpos/), a HMM pos tagger including models for many languages;
  * langdetect - wrapper for [language-detection](https://code.google.com/p/language-detection/), a language detection tool for java;
  * mallet - wrapper for topic modelling using [MALLET](http://mallet.cs.umass.edu/topics.php);
  * textnormalizer - original components for text normalization, e.g. spelling correction, umlaut normalization, expressive lengthening normalization.

## Data formats ##

  * io.conll - support for CoNLL [2000](http://www.cnts.ua.ac.be/conll2000/chunking/), [2002](http://www.cnts.ua.ac.be/conll2002/ner/), [2009](http://ufal.mff.cuni.cz/conll2009-st/task-description.html) and [2012](http://conll.cemantix.org/2012/data.html) formats;
  * io.ditop - support for [DiTop](http://vimeo.com/91355269) topic model visualization format;
  * io.penntree - support for combined and chunked formats;
  * io.tueppdz - support for [TüPP-D/Z](http://www.sfs.uni-tuebingen.de/ascl/ressourcen/corpora/tuepp-dz.html) format.

Further highlights in this release include:

  * Upgrade to Apache UIMA 2.6.0;
  * Upgrade [LanguageTools](http://languagetool.org) to version 2.7;
  * Upgrade [MaltParser](http://www.maltparser.org) to version 1.8;
  * Upgrade [Stanford CoreNLP](http://nlp.stanford.edu/software/corenlp.shtml)  to version 3.4.1;
  * Support additional [MaltParser](http://www.maltparser.org) models: [Bengali](http://www.isical.ac.in/~utpal/resources.php), [Farsi](http://stp.lingfil.uu.se/~mojgan/UPC.html), [Polish](http://zil.ipipan.waw.pl/Składnica);
  * Support additional [MSTParser](http://sourceforge.net/projects/mstparser/) models: [Croatian](http://nlp.ffzg.hr/resources/models/dependency-parsing/);
  * Support additional [OpenNLP](http://opennlp.apache.org/) models: [Spanish](https://github.com/ixa-ehu/ixa-pipe-pos);
  * Support additional [Stanford CoreNLP](http://nlp.stanford.edu/software/corenlp.shtml) models: Spanish, English caseless, shift-reduce parser models.

A more detailed overview of the changes in this release can be found [here](https://code.google.com/p/dkpro-core-asl/issues/list?can=1&q=milestone%3D1.7.0&colspec=ID+Type+Status+Priority+DKPro+Module+Milestone+Owner+Summary&cells=tiles).

When upgrading, please mind that you should not mix different versions of DKPro Core components in your projects - they may not be compatible with each other.
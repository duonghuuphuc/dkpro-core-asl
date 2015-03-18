# Introduction #

Sometimes we get asked which parser, tagger, etc. is the best and which should be used. We currently do not make any evaluations of the integrated tools. Also, building a pipeline just of the "best" components may not actually yield the best results, because of several reasons:

  * components or models may expect different tokenizations or tagsets
  * components or models may be good for one domain (e.g. news) but not for another (e.g. twitter data)

We recommend that you try various combinations and stick with the one that gives the best result for _your_ data.

# Compatibility of Components #
When selecting components for your pipeline you should make sure that the components are compatible regarding the annotation types they expect or offer.
  * if a component expects an annotation type that is not provided by the preceding component, that may lead to an error or simply to no results
  * if a component (e.g. a reader which adds sentence annotations) provides an annotation that is added again by a subsequent component (e.g. a segmenter), that will result in undefined behaviour of other components when you iterate over the annotation that has been added more than once.

To check whether components are compatible, you can look at the @TypeCapability annotation which is available in most DKPro Core components. Mind that many components can be configured with regards to which types they consume or produce, so the @TypeCapability should be taken as a rough indicator, not as a definitive information. It is also important to note, that the @TypeCapability does say anything about the tagset being consumed or produced by a component. E.g. one if a POS-tagger uses a model that produces POS-tags from the tagset X and a dependency-parser uses a model that requires POS-tags from the tagset Y, then the two models are not semantically compatible - even though the POS-tagger and dependency-parser components are compatible on the level of the type system.

# Particular Settings #

## Dictionaries and other lexical resources ##
If you use components in your pipeline that access dictionaries or other lexical resources, it might be essential to include a Lemmatizer in your pipeline:
Many dictionaries and well-known lexical resources such as WordNet require at minimum a lemma form as a search word in order to return information about that word. For large-scale lexical resources, e.g. for Wiktionary, additional information about POS is very helpful in order to reduce the ambiguity of a given lemma form.

## Lemmatizing multiwords ##
If you use lemma information in your pipeline, you should bear in mind that multiword expressions, in particular discontinuous multiwords, might not be lemmatized as one word (or expression), but rather each multiword part might be lemmatized separately.
In languages such as German, there are verbs with separable particle such as _anfangen_ (_an_ occurs separate from _fangen_ in particular sentence constructions). Therefore - depending on your use case - you might consider postprocessing the output of the lemmatizer in order to get the true lemmas (which you might need, e.g. in order to look up information in a lexical resource).

## Morphologically Rich Languages ##
  * Parsing: Morphologically rich languages (e.g. Czech, German, and Hungarian)  pose a particular challenge to parser components (Tsarfaty et al. 2013).
  * Morphological analysis: for languages with case syncretism (displaying forms that are ambiguous regarding their case, e.g. _Frauen_ in German can be nominative or genitive or dative or accusative), it might be better to leave case underspecified at the morphosyntactic level and leave disambiguation to the components at the syntactic level.  Otherwise errors might be introduced that will then be propagated to the next pipeline component (Seeker and Kuhn 2013).

## Domain-specific and other non-standard data ##
Most components (sentence splitters, POS taggers, parsers ...) are trained on (standard) newspaper text. As a consequence, you might encounter a significant performance drop if you apply the components to domain specific or other non-standard data without adaptation.
  * Tokenizing: adapting the tokenizer to your specific domain is crucial, since tokenizer errors propagate to all subsequent components in the pipeline and worsen their performance. For example, you might adapt your tokenizer to become aware of emoticons or chemical formulae in order to process social media data or text from the biochemical domain.

## Shallow processing and POS tagsets ##
While more advanced semantic processing (e.g. discourse analysis) typically depends on the output of a parser component, there might be settings where you prefer to perform shallow processing (i.e. POS tagging and chunking).

For shallow processing, it might be necessary to become familiar with the original POS tagsets of the POS taggers rather than relying on the uniform, but coarse-grained DKPro Core POS tags (because the original fine-grained POS tags carry more information).

Although many POS taggers in a given language are trained on the same POS tagset (e.g. the Penn TreeBank Tagset for English, the STTS Tagset for German), the individual POS Taggers might output variants of this tagset. You should be aware of the fact that in the DKPro Core version of the tagger, the original POS tagger output possibly has been mapped to a version that is compatible with the corresponding original tagset. (Example)


# Further references #

Here are some further references that might be helpful when deciding which tools to use:

  * Giesbrecht, Eugenie and Evert, Stefan (2009). Part-of-speech tagging - a solved task? An evaluation of POS taggers for the Web as corpus. In I. Alegria, I. Leturia, and S. Sharoff, editors, Proceedings of the 5th Web as Corpus Workshop (WAC5), San Sebastian, Spain. [[PDF](http://purl.org/stefan.evert/PUB/GiesbrechtEvert2009_Tagging.pdf)]
  * Reut Tsarfaty, Djamé Seddah, Sandra Kübler, and Joakim Nivre. 2013. Parsing morphologically rich languages: Introduction to the special issue. Comput. Linguist. 39, 1 (March 2013), 15-22. [[PDF](https://aclweb.org/anthology/J/J13/J13-1003.pdf)]
  * Wolfgang Seeker and Jonas Kuhn. 2013. Morphological and syntactic case in statistical dependency parsing. Comput. Linguist. 39, 1 (March 2013), 23-55. [[PDF](http://aclweb.org/anthology//J/J13/J13-1004.pdf)]
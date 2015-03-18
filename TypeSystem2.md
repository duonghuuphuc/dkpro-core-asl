### Metadata ###

  * DocumentMetaData
  * ~~ProcessorMetaData~~ (cf. [issue 77](https://code.google.com/p/dkpro-core-asl/issues/detail?id=77))

### Segmentation ###

  * Document
  * Heading
  * Paragraph
  * Sentence
  * Token
    * [issue 174](https://code.google.com/p/dkpro-core-asl/issues/detail?id=174): token annotations cannot carry syntactic function
  * StopWord
  * NGram

### Words ###

rename lexmorph -> words

  * Lemma
  * Stem
  * _Decompounding_
    * Split
    * Compound
    * CompoundPart
    * LinkingMorpheme
  * Morpheme (redefine?)

### Phonetics ###

  * PhoneticTranscription

### Syntax ###

  * POS (<- lexmorph) (cf. [issue 25](https://code.google.com/p/dkpro-core-asl/issues/detail?id=25))
    * 12 universal tags (cf. [issue 76](https://code.google.com/p/dkpro-core-asl/issues/detail?id=76))
  * Chunk
    * keep only coarse-grained types (cf. [issue 79](https://code.google.com/p/dkpro-core-asl/issues/detail?id=79))
    * add head information
  * Constituent
    * keep only coarse-grained types (cf. [issue 79](https://code.google.com/p/dkpro-core-asl/issues/detail?id=79))
    * add head information (cf. [issue 117](https://code.google.com/p/dkpro-core-asl/issues/detail?id=117))
  * Dependency
    * keep only coarse-grained types (cf. [issue 79](https://code.google.com/p/dkpro-core-asl/issues/detail?id=79))

### Semantics ###

rename srl -> semantics ([issue 187](https://code.google.com/p/dkpro-core-asl/issues/detail?id=187))

  * SemanticPredicate
  * SemanticArgument
  * SemanticField (new)
  * NamedEntity (<- ner)
    * Keep only Person, Location, Organisation (cf. [issue 78](https://code.google.com/p/dkpro-core-asl/issues/detail?id=78))

### Pragmatics ###

  * _Coreference types_ (<- coref, redefine?)

### Discourse ###
  * add DiscourseRelation
  * add Modality


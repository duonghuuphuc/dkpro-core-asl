| Universal  | DKPro (< 2.0.0) | DKPro (>= 2.0.0) |  	Change | Description  |
|:-----------|:----------------|:-----------------|:---------|:-------------|
| ADJ | ADJ |  ADJ |  no |  adjetives |
| ADV |  ADV |  ADV |  no |  adverbs |
| DET |  ART |  DET |  rename |  determiners |
| NUM |  CARD |  NUM |  rename |  cardinal numbers |
| CONJ |  CONJ |  CONJ |  no |  conjunctions |
| NOUN |  NP, NN, N |  NOUN |  merge |  nouns |
| X |  O |  X |  rename |  other |
| ADP |  PP |  ADP |  rename |  prepositions and postpositions |
| PRON |  PR |  PRON |  rename |  pronouns |
| VERB |  V |  VERB |  rename |  verbs |
| PRT | PRT |  PRT |  no |  particles |
| . |  PUNC |  PUNC |  no |  punctuation  |


Actually we decided to keep the distinction between NN and NP even in 2.0.0, but both should inherit from NOUN to keep the compatibility with the universal pos tags.
DKPro Core ASL 1.3.0 is a major release. It is not expected to be binary backwards compatible with previous versions. This page lists some of the more important changes and caveats regarding this version. For more detailed information on the changes in this version, please refer to the [issue tracker](http://code.google.com/p/dkpro-core-asl/issues/list?can=1&q=label:Milestone-1.3.0&sort=status&colspec=ID%20Type%20Status%20Priority%20Milestone%20Compatible%20Owner%20Summary) or to the Subversion history.

## General ##

  * Fixed several issues with `DocumentMetaData`.
  * Changed features of some DKPro Types so that they start with a lower-case letter. Breaks XMI file compatibility with older DKPro versions.
  * Added new base class `JCasFileWriter_ImplBase`

## Analysis modules ##

### TreeTagger integration ###

  * Upgraded to TT4J 1.0.16 to support chinese model.
  * Works with any model now, even if no mapping is provided.

## I/O modules ##

### British National Corpus Support ###

  * Added `BncReader`.

### IMS Open Corpus Workbench Support ###

  * Added `ImsCwbReader` and `ImsCwbWriter`.
  * `ImsCwbWriter` can use a local CWB installation to directly write the index format.

### NeGra Export Format support ###

  * Can now read version 3 files (TIGER Corpus).
  * Fixed several issues.

## TEI support ##

  * Added `TeiReader` mainly to be able to read text from the TEI version of the Brown Corpus for now.

## Web1t support ##

  * New `Web1TFormatWriter` which uses an external sort mechanism to support larger n-gram models.

## Wikipedia support ##

  * Upgraded to JWPL 0.9.0.
  * Added `WikipediaPageReader`, which reads articles and discussion pages.
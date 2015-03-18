We are pleased to announce the release of

DKPro Core, version 1.6.0 (ASL & GPL)

a collection of interoperable software components for natural language
processing (NLP) based on the Apache UIMA framework.

  * http://code.google.com/p/dkpro-core-asl
  * http://code.google.com/p/dkpro-core-gpl

DKPro Core 1.6.0 requires Java 7.

## New components ##

  * opennlp - OpenNLP chunker component added

## New I/O modules/components ##

  * io.bliki - Reader for Wikipedia
  * io.tiger - Writer for the Tiger XML format (also also supports semantic frame annotations)

Further highlights in this release include:

  * Upgrade to ClearNLP 2.0.2
  * Upgrade to Stanford CoreNLP 3.3.1 including the new CVG models
  * Upgrade to TT4J 1.1.2
  * Upgrade to LanguageTool 2.5

Also, this release supports many additional [models](https://docs.google.com/spreadsheet/pub?key=0ApGcdapz0xSYdHZXZDFSbC1XeTRiWXphdmo4NDBnc1E&single=true&gid=0&output=html) for various
components and brings the usual set of bug fixes and minor
improvements.

A more detailed overview of the changes in this release can be found [here](https://code.google.com/p/dkpro-core-asl/issues/list?can=1&q=label:Milestone-1.6.0)

This release was first planned as a bugfix release for DKPro Core 1.5.0,
but we decided to call it 1.6.0 because it depends on Java 7 now instead
of Java 6.

As Google Code has recently disabled downloads, we do currently not
provide a ZIP file with all DKPro Core JARs for non-Maven users.

When upgrading, please mind that you should not mix different versions
of DKPro Core components in your projects - they may not be compatible
with each other.
<h1>Segmenter Evaluator</h1>

Reads a test suite from an XML file and tries it against several segmenters.

Call with `pipeline <filename>`, e.g. `pipeline testsuite.xml`.

Instead of specifying a filename, it is also possible to use an URL, e.g.:

`pipeline http://dkpro-core-asl.googlecode.com/svn/wiki/DKProSegmentationTestSuite.wiki`

which runs the set of segmentation tests maintained [here](DKProSegmentationTestSuite.md).

```
#!/usr/bin/env groovy
@Grab(group='de.tudarmstadt.ukp.dkpro.core',
      module='de.tudarmstadt.ukp.dkpro.core.tokit-asl',
      version='1.6.1')
import de.tudarmstadt.ukp.dkpro.core.tokit.*

@Grab(group='de.tudarmstadt.ukp.dkpro.core',
      module='de.tudarmstadt.ukp.dkpro.core.opennlp-asl',
      version='1.6.1')
import de.tudarmstadt.ukp.dkpro.core.opennlp.*

@Grab(group='de.tudarmstadt.ukp.dkpro.core',
      module='de.tudarmstadt.ukp.dkpro.core.languagetool-asl',
      version='1.6.1')
import de.tudarmstadt.ukp.dkpro.core.languagetool.*

@Grab(group='de.tudarmstadt.ukp.dkpro.core',
      module='de.tudarmstadt.ukp.dkpro.core.stanfordnlp-gpl',
      version='1.6.1')
import de.tudarmstadt.ukp.dkpro.core.stanfordnlp.*

import static org.apache.commons.lang.exception.ExceptionUtils.*;
import static org.apache.uima.fit.util.JCasUtil.*
import static org.apache.uima.fit.factory.JCasFactory.*
import static org.apache.uima.fit.factory.AnalysisEngineFactory.*
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.*

java.util.logging.LogManager.logManager.reset(); // Disable logging
def testSuite = new XmlSlurper().parse(args[0]) // Load tests
def doc = createJCas() // Create empty reusable document

// These are the segmenters to test
def segmenters = [ BreakIteratorSegmenter, StanfordSegmenter,
  OpenNlpSegmenter, LanguageToolSegmenter ]

def results = [:];
for (def tc : testSuite.tests.test) { // Run tests
  println "=== ${tc.@id} ===\n"

  for (def segmenter : segmenters) { // Test each segmenter in turn
    // Process test input
    doc.reset()
    doc.documentText = tc.input
    doc.documentLanguage = tc.@language

    def output;
    def diag;
    try {
      createEngine(segmenter).process(doc)

      // Construct comparable output
      output = select(doc, Sentence).collect {s ->
        "◀" + selectCovered(Token, s).collect { "⁌${it.coveredText}⁍ " }.join("") + "▶ "
      }.join("")

      // Find output in test suite
      diag = "UNKNOWN"
      for (def possibleOutput : tc.possibleOutputs.possibleOutput) {
        if (output.trim() == possibleOutput.output.text().trim()) {
          diag = possibleOutput.description
          break
        }
      }
    }
    catch(Exception e) {
      diag = "ERROR: " + getRootCauseMessage(e);
      output = "ERROR";
    }

    
    // Print result for individual segmenter
    println "Segmenter : ${segmenter.simpleName}" 
    println "Output    : ${output}"
    println "Result    : ${diag}"
    println ""

    if (results[segmenter] == null) results[segmenter] = [];
    results[segmenter] << diag;
  }
}

// Print results overview
for (def segmenter : segmenters) {
  println "${segmenter.simpleName}"
  println "  GOOD    : ${results[segmenter].grep(~/GOOD.*/).size()}"
  println "  BAD     : ${results[segmenter].grep(~/BAD.*/).size()}"
  println "  ERROR   : ${results[segmenter].grep(~/ERROR.*/).size()}"
  println "  UNKNOWN : ${results[segmenter].grep(~/UNKNOWN.*/).size()}"
}
```

Example test suite:

```
<testSuite>
  <tests>
    <test id="number.version.underspecified" language="en">
      <input>John loves Windows 3.x and DOS.</input>
      <possibleOutputs>
        <possibleOutput>
          <output>◀⁌John⁍ ⁌loves⁍ ⁌Windows⁍ ⁌3⁍ ⁌.⁍ ⁌x⁍ ⁌and⁍ ⁌DOS⁍ ⁌.⁍ ▶</output>
          <description>BAD - version split into multiple tokens</description>
        </possibleOutput>
        <possibleOutput>
          <output>◀⁌John⁍ ⁌loves⁍ ⁌Windows⁍ ⁌3.x⁍ ⁌and⁍ ⁌DOS.⁍ ▶</output>
          <description>BAD - sentence marker is not a separate token</description>
        </possibleOutput>
      </possibleOutputs>
    </test>
  </tests>
</testSuite>
```

Example output:

```
=== number.version.underspecified ===

Segmenter : BreakIteratorSegmenter
Output    : ◀⁌John⁍ ⁌loves⁍ ⁌Windows⁍ ⁌3⁍ ⁌.⁍ ⁌x⁍ ⁌and⁍ ⁌DOS⁍ ⁌.⁍ ▶
Result    : BAD - version split into multiple tokens

Segmenter : StanfordSegmenter
Output    : ◀⁌John⁍ ⁌loves⁍ ⁌Windows⁍ ⁌3⁍ ⁌.⁍ ▶ ◀⁌x⁍ ⁌and⁍ ⁌DOS⁍ ⁌.⁍ ▶
Result    : BAD - version separator misdetected as sentence separator

Segmenter : OpenNlpSegmenter
Output    : ◀⁌John⁍ ⁌loves⁍ ⁌Windows⁍ ⁌3.x⁍ ⁌and⁍ ⁌DOS.⁍ ▶
Result    : BAD - sentence marker is not a separate token

Segmenter : LanguageToolSegmenter
Output    : ◀⁌John⁍ ⁌loves⁍ ⁌Windows⁍ ⁌3⁍ ⁌.⁍ ⁌x⁍ ⁌and⁍ ⁌DOS⁍ ⁌.⁍ ▶
Result    : BAD - version split into multiple tokens
```
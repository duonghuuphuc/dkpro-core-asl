<h1>Convert a corpus at CONLL 2006 format to CONLL 2009</h1>

Reads each CONLL 2006 file from the corpus in the specified folder and writes them to the target folder with CONLL 2009 format.

```
#!/usr/bin/env groovy
@Grab(group='de.tudarmstadt.ukp.dkpro.core', 
      module='de.tudarmstadt.ukp.dkpro.core.io.conll-asl', 
      version='1.7.0')

import static org.apache.uima.fit.factory.AnalysisEngineFactory.*
import static org.apache.uima.fit.factory.CollectionReaderFactory.*
import static org.apache.uima.fit.pipeline.SimplePipeline.*
import de.tudarmstadt.ukp.dkpro.core.io.conll.Conll2006Reader
import de.tudarmstadt.ukp.dkpro.core.io.conll.Conll2009Writer

// Assemble and run pipeline
runPipeline(
  createReaderDescription(Conll2006Reader,
     Conll2006Reader.PARAM_SOURCE_LOCATION, args[0], // first parameter
            Conll2006Reader.PARAM_LANGUAGE, args[1], // second parameter
            Conll2006Reader.PARAM_PATTERNS, "[+]/**/*.conll"),
  createEngineDescription(Conll2009Writer,
     Conll2009Writer.PARAM_TARGET_LOCATION, args[2])) //third parameter
```
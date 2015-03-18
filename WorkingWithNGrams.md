# Annotating n-grams #

If n-grams are required by some downstream component, the `NGramAnnotator` can be used to add `NGram` annotations to the CAS.

# Quickly Creating n-grams from Annotations #

If the n-grams are only needed locally but not by downstream components, it is more efficient to use the `NGramIterable` that returns the n-grams constructed from a certain set of arbitrary annotations without adding them to the CAS.

If you are just interested in the String representation of the n-grams, you can also use `NGramStringIterable`.

```
    String[] tokens = StringUtils.split("This is a simple example sentence .");
    for (String ngram : new NGramStringIterable(tokens, 2, 2)) {
        System.out.println(ngram);
    }
```

# n-gram Frequency Counts #

Many applications require to determine the number of occurrences of a certain n-gram (or phrase) in a collection. DKPro supports that by providing special external resources.

A component that wants to use frequency counts should declare this by specifying an external resource:
```
    public static final String FREQUENCY_COUNT_RESOURCE= "FrequencyProvider";
    @ExternalResource(key = FREQUENCY_COUNT_RESOURCE)
    private FrequencyCountProvider frequencyProvider;
```

The frequency count can then be accessed using:
```
    long freq = frequencyProvider.getFrequency(phrase);
```

The user of this component then just needs to add the resource as a configuration parameter:
```
        AnalysisEngineDescription desc = AnalysisEngineFactory.createPrimitiveDescription(
            Annotator.class,
            Annotator.FREQUENCY_COUNT_RESOURCE, ExternalResourceFactory.createExternalResourceDescription(
                Web1TFrequencyCountResource.class,
                Web1TFrequencyCountResource.PARAM_MIN_NGRAM_LEVEL, "1",
                Web1TFrequencyCountResource.PARAM_MAX_NGRAM_LEVEL, "3",
                Web1TFrequencyCountResource.PARAM_INDEX_PATH, indexPath
            )
        );
```

The `Web1TFrequencyCountResource` in DKPro directly supports the format of the [Google Web1T web size n-gram corpus](http://www.ldc.upenn.edu/Catalog/docs/LDC2006T13/readme.txt).

## Creating Web1T data files ##
You can create your own n-gram frequency count models using the Web1TFormatWriter provided by DKPro.

The following example shows how to create a n-gram model from the [ACL Anthology corpus](http://www.ldc.upenn.edu/Catalog/CatalogEntry.jsp?catalogId=LDC2009T29):
```
public class CreateAclNgrams
{

    private static final String OUTPUT_PATH = "target/ngrams/";
    
    public static void main(String[] args) throws Exception
    {
        
        File aclPath = DKProContext.getContext().getWorkspace("acl_anthology");
        
        CollectionReader reader = createCollectionReader(
                AclAnthologyReader.class,
                ResourceCollectionReaderBase.PARAM_PATH, aclPath.getAbsolutePath(),
                ResourceCollectionReaderBase.PARAM_PATTERNS, new String[] {
                        ResourceCollectionReaderBase.INCLUDE_PREFIX + "**/*.txt" });
 
        AnalysisEngineDescription segmenter = createPrimitiveDescription(
                BreakIteratorSegmenter.class
        );
 
        AnalysisEngineDescription ngramWriter = createPrimitiveDescription(
                Web1TFormatWriter.class,
                Web1TFormatWriter.PARAM_TARGET_LOCATION,  OUTPUT_PATH,
                Web1TFormatWriter.PARAM_INPUT_TYPES, new String[] { Token.class.getName() },
                Web1TFormatWriter.PARAM_MIN_NGRAM_LENGTH, 1,
                Web1TFormatWriter.PARAM_MAX_NGRAM_LENGTH, 3,
                Web1TFormatWriter.PARAM_MIN_FREQUENCY, 2                
        );
        
        SimplePipeline.runPipeline(
                reader,
                segmenter,
                ngramWriter
        );

        // create the necessary indexes
        JWeb1TIndexer indexCreator = new JWeb1TIndexer("target/web1t/", 3);
        indexCreator.create();
    }
}
```
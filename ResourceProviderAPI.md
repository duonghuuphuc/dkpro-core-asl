

# Resources #

The architecture for resources (e.g. parser models, POS tagger models, etc.) in DKPro is still work in progress. However, there are a couple of corner points that have already been established.

  * **REQ-1 - Addressable by URL**: Resources must be addressable using an URL, typically a classpath URL (`classpath:/de/tudarmstadt/.../model.bin`) or a file URL (`file:///home/model.bin`). Remote URLs like HTTP should not be used and may not be supported.
  * **REQ-2 - Maven compatible**: Resources are packaged in JARs and can be downloaded from our Maven repositories (if the license permits).
  * **REQ-3 - Document-sensitive**: A component should dynamically determine at runtime which resource to use based on properties of a processed document, e.g. based on the document language. This may change from one document to the next.
  * **REQ-4 - Overridable**: The user should be able to override the model or provide additional information as to what specific variant of a resource should be used. E.g. if there are two resources for the language `de`, `de-fast` and `de-accurate`, the component could use `de-fast` per default unless the user specifies to use variante `accurate` or specifies a different model altogether.
  * **REQ-5 - Loadable from classpath**: Due to REQ-1, REQ-2, and REQ-3 models must be resolvable from the classpath.
    * `ResourceUtils.resolveLocation(String, Object, UimaContext)`
    * Resource Providers (see below)
    * `PathMatchingResourcePatternResolver`

# Packaging resources as JARs #

Models are usually large and we therefore package them separately from the components that use them. Each model becomes a JAR that is uploaded to our Maven repositories and added as a dependency in the projects that use them.

Often, models are single files, e.g. serialize Java objects that represent a parser model, POS tagger model, etc. The simplest case is that these files are distributed from some website. We use an ANT script then to download the file and package it as a JAR. We defined custom ANT macros like install-model-file that make the process very convenient. The following code shows how we import the custom macros and define two targets, local-maven and separate-jars. The first just sets a property to cause install-model-file to copy the finished JAR into the local Maven repository (~.m2/repository).

The versioning scheme for models is "yyyymmdd.x" where "yyyymmdd" is the date of the last model change (if known) or the date of packaging and "x" is a counter unique per date starting a 0. Please refer to the [[versioning scheme documentation](PackagingResources#Versioning_scheme.md) for more information.

The model building ANT script goes to =src/scripts/build.xml= with the project.

```
<project basedir="../.." default="separate-jars">
  <import>
    <url url="http://dkpro-core-asl.googlecode.com/svn/built-ant-macros/tags/0.6.0/ant-macros.xml"/>
  </import>
	
  <!-- 
      - Output package configuration
    -->
  <property name="outputPackage" value="de/tudarmstadt/ukp/dkpro/core/opennlp/lib"/>

  <target name="local-maven">
    <property name="install-artifact-mode" value="local"/>
    <antcall target="separate-jars"/>
   </target>

  <target name="remote-maven">
    <property name="install-artifact-mode" value="remote"/>
    <antcall target="separate-jars"/>
  </target>
	
  <target name="separate-jars">
    <mkdir dir="target/download"/>
	
    <!-- FILE: models-1.5/en-pos-maxent.bin - - - - - - - - - - - - - - - - - - - - - - - - - - 
      - 2012-06-16 | now        | db2cd70395b9e2e4c6b9957015a10607
      -->
    <get 
      src="http://opennlp.sourceforge.net/models-1.5/en-pos-maxent.bin"
      dest="target/download/en-pos-maxent.bin"
      skipexisting="true"/>
    <install-stub-and-upstream-file 
      file="target/download/en-pos-maxent.bin"
      md5="db2cd70395b9e2e4c6b9957015a10607"
      groupId="de.tudarmstadt.ukp.dkpro.core"
      artifactIdBase="de.tudarmstadt.ukp.dkpro.core.opennlp"
      upstreamVersion="20120616"
      metaDataVersion="1"
      tool="tagger"
      language="en" 
      variant="maxent" 
      extension="bin" >
        <metadata>
          <entry key="pos.tagset" value="ptb"/>
        </metadata>
    </install-model-file>
  </target>
</project>
```

The model file "en-pos-maxent.bin" is downloaded from the OpenNLP website and stored in a local cache directory "target/download/tagger/da-pos-maxent.bin". From there, _install-stub-and-upstream-file_ picks it up and packages it as two JARs, 1) a JAR containing the DKPro Core meta data and a POM referencing the second JAR, 2) a JAR containing the actual model file(s). The JAR file names derive from the _artifactIdBase_, _tool_, _language_, _variant_, _upstreamVersion_ and _metaDataVersion_ parameters. These parameters along with the extension parameter are also used to determine the package name and file name of the model in the JAR. They are determined as follows (mind that dots in the artifactBase turn to slashes, e.g. "de.tud" turns "de/tud":

```
    {artifactIdBase}/lib/{tool}-{language}-{variant}.{extension}
```

The following values are commonly used for **tool**:

  * **token** - tokenizer
  * **sentence** - sentence splitter
  * **lemmatizer** - lemmatizer
  * **tagger** - part-of-speech tagger
  * **morphtagger** - morphological analyzer
  * **ner** - named-entity recognizer
  * **parser** - syntactic or dependency parser
  * **coref** - coreference resolver

The values for **variant** are very tool-dependent. Typically, the variant encodes parameters that were used during the creation of a model, e.g. which machine learning algorithm was used, which parameters it had, and on which data set is has been created.

An md5 sum for the remote file must be specified to make sure we notice if the remote file changes or if the download is corrupt.

The metadata added for the models currently used to store tagset information, which is used to drive the tag-to-DKPro-UIMA-type mapping. The following values are commonly used as keys:

  * **pos.tagset** - part-of-speech tagset (ptb, ctb, stts, ...)
  * **dependency.tagset** - dependency relation labels, aka. syntactic functions (negra, ancora, ...)
  * **constituent.tagset** - constituent labels, aka. syntactic categories (ptb, negra, ...)

# Updating Models #

Whenever one existing model have a new release, it is good to update the build.xml changing the:

  * URL for retrieving the model (if it has changed)
  * The version from the model (the day when the model was created in the _yyyymmdd_ format)

After that, run the ant script with the **local-maven target**, add the jars to your project classpath and check if the existing unit tests work for the up to date model. If they do, then run the script again, this time with the **remote-maven target**. Then, change the versions from the models in the dependency management section from the project's pom file, commit those changes and move these new models from staging into model repository in zoidberg.




# Using Resource Providers #

The `CasConfigurableProviderBase` class provides some support for the above requirements. The following code is taken from the `OpenNlpPosTagger` component. It shows how the POS Tagger model is addressed using a parametrized classpath URL with parameters for language and variant. The `produceResource()` method is called with the URL of the model once it has been located by `CasConfigurableProviderBase`.

_This is an illustrative code example. See [OpenNlpPosTagger](http://code.google.com/p/dkpro-core-asl/source/browse/de.tudarmstadt.ukp.dkpro.core-asl/trunk/de.tudarmstadt.ukp.dkpro.core.opennlp-asl/src/main/java/de/tudarmstadt/ukp/dkpro/core/opennlp/OpenNlpPosTagger.java) for the complete code._

```
modelProvider = new CasConfigurableStreamProviderBase<POSTagger>() {
    {
        // These are the default values
        setDefault(LOCATION, "classpath:/de/tudarmstadt/ukp/dkpro/core/opennlp/lib/" +
                "tagger-${language}-${variant}.bin");
        setDefault(VARIANT, "maxent");
				
        // These are parameters the user may have set on the component, they may be null
        setOverride(LOCATION, modelLocation);
        setOverride(LANGUAGE, language);
        setOverride(VARIANT, variant);
    }
			
    @Override
    protected POSTagger produceResource(InputStream aStream) throws Exception
    {
        POSModel model = new POSModel(aStream);
        return new POSTaggerME(model);
    }
};

// Here the language is picked up from the CAS.
modelProvider.configure(cas);

// Here we get the tagger according to the language, variant and location chosen.
// A new instance is only created if necessary (e.g. if the current CAS has a different
// language than the previous).
POSTagger tagger = modelProvider.getResource();
```

## Mapping Providers ##

The DKPro type system design provides two levels of abstraction on most annotations:

  * a generic annotation type, e.g. `POS` (part of speech) with a feature `value` containing the original tag produced by an analysis component, e.g. TreeTagger
  * a set of high-level types for very common categories, e.g. `N` (noun), `V` (verb), etc.

> DKPro maintains mappings for commonly used tagsets, e.g. in the module `de.tudarmstadt.ukp.dkpro.core.api.lexmorph-asl`. They are named:

```
{language}-{layer}.map
```

The following values are commonly used for **layer**:

  * **pos** - part-of-speech tag mapping

Mapping providers are a convenient way of fetching a mapping between the original tag value and the high-level types.

_This is an illustrative code example. See [OpenNlpPosTagger](http://code.google.com/p/dkpro-core-asl/source/browse/de.tudarmstadt.ukp.dkpro.core-asl/trunk/de.tudarmstadt.ukp.dkpro.core.opennlp-asl/src/main/java/de/tudarmstadt/ukp/dkpro/core/opennlp/OpenNlpPosTagger.java) for the complete code._

```
// General setup of the mapping provider in initialize()
mappingProvider = new MappingProvider();
mappingProvider.setDefault(MappingProvider.LOCATION, "classpath:/de/tudarmstadt/ukp/dkpro/" +
    "core/api/lexmorph/tagset/${language}-pos.map");
mappingProvider.setDefault(MappingProvider.BASE_TYPE, POS.class.getName());
mappingProvider.setOverride(MappingProvider.LOCATION, mappingLocation);
mappingProvider.setOverride(MappingProvider.LANGUAGE, language);

// Document-specific configuration in process()
mappingProvider.configure(cas);

// Resolve an original tag value to a high-level type
Type posTag = mappingProvider.getTagType(tags[i]);
POS posAnno = (POS) cas.createAnnotation(posTag, t.getBegin(), t.getEnd());
```

## Language-dependent default variants ##

It is possible a different default variant needs to be used depending on the language. This
can be configured by placing a properties file in the classpath and setting its location using
`setDefaultVariantsLocation(String)`. The key in the properties is the language and the value is used a default variant. These file should always reside in the `lib`sub-package of a component and use the naming convention:

```
{tool}-default-variants.map
```

_This is an illustrative code example. See [StanfordPosTagger](http://code.google.com/p/dkpro-core-gpl/source/browse/de.tudarmstadt.ukp.dkpro.core-gpl/trunk/de.tudarmstadt.ukp.dkpro.core.stanfordnlp/src/main/java/de/tudarmstadt/ukp/dkpro/core/stanfordnlp/StanfordPosTagger.java) for the complete code._

```
// General setup of the mapping provider in initialize()
mappingProvider.setDefaultVariantsLocation(
    "de/tudarmstadt/ukp/dkpro/core/stanfordnlp/lib/tagger-default-variants.map");
```

The `tagger-default-variants.map` is a Java properties file which defines for each language which variant should be assumed as default.

```
ar=fast
de=fast
en=bidirectional-distsim-wsj-0-18
zh=default
```
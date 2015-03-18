# How to package resources (e.g. models) as Maven Artifacts #

Resources needed by DKPro components (e.g. parser models or POS tagger models) are not packaged with the corresponding analysis components, but as separate JARs, one per language and model variant.

Due to license restrictions, we may not redistribute all of these resources. But, we offer Ant scripts to automatically download the resources and package them as DKPro-compatible JARs. When the license permits, we upload these to our public Maven repository.

If you need a non-redistributable resource (e.g. TreeTagger models) or just want to package the models yourself, here is how you do it.

## build.xml Ant script ##

For those modules where we support packaging resources as JARs, we provide an Ant script called `build.xml` which is located in the corresponding module in the SVN.

`build.xml` is a script that can be run with Apache Ant (version 1.8.x or higher) and requires an internet connection.

You can find this script in the `src/scripts` folder of the module.

Depending on the script, various build targets are supported. Three of them are particularly important: **separate-jars**, **local-maven**, and **remote-maven**:

  * **separate-jars** downloads all resource from the internet, validates them against MD5 checksums and packages them as DKPro-compatible JARs. The JARs are stored to the `target` folder. You can easily update them to an Artifactory Maven repository. Artifactory automatically recognizes their group ID, artifact ID and version. This may not work with other Maven repositories.
  * **local-maven** additionally installs the JARs into your the local Maven repository on your computer. It assumes the default location of the repository at `~/.m2/repository`. If you keep your repository in a different folder, specify it via the _alt.maven.repo.path_ system property.
  * **remote-maven** additionally installs the JARS into a remote Maven repository. The repository to deploy to can be controlled via the system property _alt.maven.repo.url_. If the remote repo also requires authentication, use the system property _alt.maven.repo.id_ to configure the credentials from the `settings.xml` that should be used. An alternative settings file can be configured using  _alt.maven.settings_ . **Note:** this target requires that you have installed [maven-ant-tasks-2.1.3.jar](http://repo1.maven.org/maven2/org/apache/maven/maven-ant-tasks/2.1.3/maven-ant-tasks-2.1.3.jar) in `~/.ant/lib`.

It is recommended to open the `build.xml` file in Eclipse, run the `local-maven`target, and then restart Eclipse. Upon restart, Eclipse should automatically scan your local Maven repository. Thus, T
the new resource JARs should be available in the search dialog when you add dependencies to the POM.


## Example: how to package TreeTagger binaries and models ##

TreeTagger and its models cannot be re-distributed with DKPro Core, you need to download it yourself. For your convenience, we included an Apache Ant script called `build.xml` in the `src/scripts` folder of the TreeTagger module. This script downloads the TreeTagger binaries and models and packages them as artifacts, allowing you to simply add them as dependencies in Maven.

To run the script, you need to have Ant 1.8.x installed and configured in Eclipse. This is already the case with Eclipse 3.7.x. If you use an older Eclipse version, please see the section below on installing Ant in Eclipse.

Now to build the TreeTagger artifacts:

  * Locate the Ant build script (`build.xml`) in the **scripts** directory (`src/scripts`) of the **de.tudarmstadt.ukp.dkpro.core.treetagger** module.
  * Right-click, choose **Run As > External Tools Configurations**. In the **Target** tab, select **local-maven**, run.
  * Read the license in the Ant console and - if you care - accept the license terms.
  * Wait for the build process to finish
  * Restart Eclipse

To use the packaged TreeTagger resources, add them as Maven dependencies to your project (or add them to the classpath if you do not use Maven).

Note that in order to use TreeTagger you must have added at least the JAR with the TreeTagger binaries and one JAR with the model for the language you want to work with. **A model JAR for TreeTagger contains POS tagger and chunker models**.

## Which `build.xml` file to use? The trunk version or a release version? ##

For any given module supporting packaged resources, there is always the `build.xml` in SVN trunk and the ones in previous releases (tags folder) in SVN. Which one should you use?

For TreeTagger, you should always use the version from SVN trunk. Here, it is least likely that the MD5 checksums are outdated and you will always get the latest and greatest version of TreeTagger.

For all other modules (e.g. OpenNLP or StanfordNLP) you should use the `build.xml` for the DKPro Core release version you are using. Thus, if you are working with the latest DKPro Core SNAPSHOT, use the `build.xml` from SVN trunk and if you use DKPro Core 1.3.0, then look in the 1.3.0 tag in SVN.

We do not ship the `build.xml` files in any other way than via SVN.

## Versioning scheme ##

To version our packaged models, we use a date (yyyymmdd) and a counter (x). We use a date, because often no (reliable) upstream version is available. E.g. with the Stanford NLP tools, the same model is sometimes included in different pacakges with different versions (e.g. parser models are included with the CoreNLP package and the parser package). TreeTagger models are not versioned at all. With the OpenNLP version, we are not sure if they are versioned - it seems they are just versioned for compatibility with a particular OpenNLP version (e.g. 1.5.) but have no proper version of their own. If we know it, we use the date when the model was last changed, otherwise we use the date when we first package a new model and update it when we observe a model change.

We include additional metadata with the packaged model (e.g. which tagset is used) and we sometimes want to release packaged models with new metadata, although the upstream model itself has not changed. In such cases, we increment the counter. The counter starts at 0 if a new model is incorporated.

Thus, a model version has the format "yyyymmdd.x".

## MD5 checksum check fails ##

Not all of the resources are properly versioned by their maintainers (in particular TreeTagger binaries and models). We observed that resources changed from one day to the next without any announcement or increase of the version number (if present at all). Thus, we validate all resources against an MD5 checksum stored in the `build.xml` file. This way, we can recognize if a remote resource has been changed. When this happens, we add a note to the `build.xml` file indicating, when we noticed the MD5 changed and update the version of the corresponding resource.

Since we do not test the `build.xml` files every day, you may get an MD5 checksum error when you try to package the resources yourself. If this happens, open the `build.xml` file with a text editor, locate the MD5 checksum that fails, update it and update the version of the corresponding resource. You can also tell us on the [DKPro Core User Group](https://groups.google.com/forum/?fromgroups#!forum/dkpro-core-user) and we will update the `build.xml` file.


## Installing Ant in Eclipse ##

Our `build.xml` scripts require Ant 1.8.x. If you use an older Eclipse version, you may have to manually download and register a recent Ant version:

  * Download the latest Ant binaries from the website and unpack them in a directory of your choice.
  * Start Eclipse and go to **Window > Preferences > Ant > Runtime** and press **Ant Home...**.
  * Select the Ant directory you just unpacked, then confirm.
# Eclipse Setup #

We use the following tools to integrate Maven in Eclipse:

  * [Eclipse](http://eclipse.org/) 3.7 or higher. We recommend the _Eclipse Classic_ distribution, version 4.2 or higher..
  * [m2e](http://m2eclipse.sonatype.org/) 1.0.200.20111228-1245 or higher.
    * available in the Eclipse "Install new software"

### For Windows Users ###

**Note:** On your machine the Java path may be different, e.g. because you are using a localized Windows version it may be `C:\Programme\...` -or- because you may have a Java version other than 1.6.0.01.

  1. Edit your `eclipse.ini` and add/change the following lines (the `-vmargs` line should be present already):
```
-vm
C:/Program Files/Java/jdk1.6.0_01/bin/javaw.exe
-vmargs
```
    * Make sure that the linebreaks are as shown above (the formatting is actually necessary)
  1. Open Eclipse
    * Open the **preferences**
    * Go to **Java -> Installed JREs**
    * Click **Search** and choose your Java directory
    * **Close** the preferences and **re-open** them
    * **Select** _jdk1.6.0\_01_ as your JRE (this should match the entry you added in the eclipse.ini)

# Maven Setup #

**Since version 1.4.0, DKPro Core is available from [Maven Central](http://search.maven.org/#search%7Cga%7C1%7Cde.tudarmstadt.ukp.dkpro).**

If you do not want rely on our automatic download mechanism for models and instead want to add models as dependencies to your Maven POM, it is necessary to configure the [public UKP Maven repository](UkpMavenRepository.md).

**Only if you are using DKPro Core 1.4.0 or older:** If you want to use our pre-packaged models, it is necessary to configure the [public UKP Maven repository](UkpMavenRepository.md).

**Only if you are using DKPro Core 1.3.0 or older:** If you need to use DKPro Core versions 1.3.0 or older, it is necessary to configure the [public UKP Maven repository](UkpMavenRepository.md).
<h1>Introduction</h1>

This assumes that you have installed **[Jython 2.7beta 3](http://www.jython.org)** (higher versions should work as well) and that you have the command `jython` available in your path.

<a href='Hidden comment: 
*Note:* Currently *Jython 2.7beta 1 is incompatible with uimaFIT and therefore with DKPro Core*. Jython uses a custom classloader (!SyspathJavaLoader) to load Java classes used be the scripts. However, this classloader currently does not support classpath scanning because the method findResources() has not been implemented. Get our *[https://public.ukp.informatik.tu-darmstadt.de/dkpro_core/jython.jar fixed Jython 2.7b1+ jar]* and replace the _jython.jar_ file in your Jython installation folder with our file. After this, our recipes should work nicely. (See also: [http://bugs.jython.org/issue1896215 Jython issue 1896215])
'></a>

Additionally, you must have **[jip 0.8.3](https://pypi.python.org/pypi/jip)** (or higher) installed. Jip provides our scripts with the ability to automatically download dependencies from Maven repositories.

Copy one of the scripts into a simple text file (e.g. `pipeline`). Make the file executable (e.g. `chmod +x pipeline`). Then run it (e.g. `./pipeline`). The first time this will take quite long because libraries and models are automatically downloaded.

If you encounter problems, please refer to our [Python trouble-shooting guide](DKProPythonTroubleShooting.md).

# Installation #

## Windows 7 ##

### Basic installation ###

This adds the basic requirements Jython and jip.
  * Download and install the Java SE Development Kit 7 from the [Oracle Java Site](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html)
  * Download the **Jython 2.7beta 3** traditional installer from [here](http://search.maven.org/remotecontent?filepath=org/python/jython-installer/2.7-b3/jython-installer-2.7-b3.jar)
  * Double-click on the **jython-installer-2.7-b3.jar** to start the installer
  * Install with all the default settings. This should install Jython to `C:\jython2.7b3`
  * Download [jip](https://pypi.python.org/pypi/jip) (version 0.8.3 or higher)
  * Unpack `jip-0.8.3.zip ` to `C:\`
  * Open a command line window
    * Go to the jip folder: `cd C:\jip`
    * Install jip: `C:\jython2.7b3\jython setup.py install`
    * Close the window
    * Now you can delete the folder `C:\jip` and the file `jip-0.8.3.zip ` again

### Adding file type associations ###
The following instructions are optional and are **not** required to execute any of the following scripts. These instructions are intended for advanced users, who would like to be able to execute the scripts directly from the command line. If you work for the first time with the command line, you might want to skip this section.

After completing the basic installation (above), the this section covers how to add file type associations. This allows you to run the Jython scripts directly without having to manually invoking the Jython interpreter every time. So instead of invoking a pipeline using

```
C:\jython2.7b3\jython pipeline.jpy C:\example_folder\ en
```

you could simply use

```
pipeline C:\example_folder\ en
```


  * Press the **Start button** and search for **environment variable**
  * In the **Environment variable editor** find **PATHEXT** in the **system variable** section and add `;.JPY` to the end
  * Open a command line window
  * Create a file type association for Jython files: `assoc .jpy=Jython`
  * Create a file type for Jython files: `ftype Jython="C:\jython2.7b3\jython" "%1" %*`

# Recipes #

**Building pipelines:** different approaches to running a simple part-of-speech pipeline

  * [OpenNLP Part-of-speech tagging pipeline with direct access to results](PythonOpenNlpPosTagAccessDirect.md)
  * [OpenNLP Part-of-speech tagging & parsing without reader](PythonOpenNlpPosTagNoReader.md)

**Dependency parsing**

  * [MaltParser dependency parsing pipeline with direct access to results](PythonMaltParserAccessDirect.md)

**Other**

  * [TreeTagger part-of-speech tagging and lemmatizing](PythonTreeTaggerPosLemmaAccessDirect.md)
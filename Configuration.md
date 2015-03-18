# Configuration File #

The data files used by LSR are usually very large. Thus it is not feasible to distributed them within the LSR JARs. It is the users responsibility to install the files locally. LSR uses the environment variable `DKPRO_HOME` to locate the data directory. We will refer to this directory as `DKPRO_HOME` as well. It is suggested that you choose a directory within your home directory, such as `$HOME/dkpro`.

Depending on our operating system, there are different ways to best configure this environment variable.
  * OS X: install the Environment Variable Preference Pane, configure the variable and log in again.
  * Linux: Add the line export `DKPRO_HOME=$HOME/dkpro` to the file `.bashrc` in your home directory and log in again.
  * Windows: Right-click on the "Arbeitsplatz" icon, choose "Eigenschaften". Somewhere there you can set up environment variables.
  * in general: If none of the above works for you, you can always set the environment variable in Eclipse in the run configuration you use to start your program.

# Data Directory Layout #

Within your =DKPRO\_HOME= directory LSR expects the following hierarchy:
```
DIR  | DKPRO_HOME
DIR  |    de.tudarmstadt.ukp.dkpro.lexsemresource.core.ResourceFactory
FILE |     resources.xml     
```

# Example Configuration File #

The `resources.xml` file declares the actual locations of the data. This may be a local directory (absolute or relative to the `resources.xml` file) or a remote location, e.g. a database.

```
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.5.xsd">
	
	<bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
	</bean>
	
	<bean id="wordnet-en" lazy-init="true" class="de.tudarmstadt.ukp.dkpro.lexsemresource.wordnet.WordNetResource">
		<constructor-arg value="${DKPRO_HOME}/wordnet3/wordnet_properties.xml"/>
	</bean>
	
        <bean id="wiktionary-de" lazy-init="true" class="de.tudarmstadt.ukp.dkpro.lexsemresource.wiktionary.WiktionaryResource">
                <constructor-arg value="GERMAN"/>
                <constructor-arg value="${DKPRO_HOME}/dewiktionary-20090129__jwktl-0.12rc1"/>
        </bean>

	<bean id="wikipedia-de" lazy-init="true" class="de.tudarmstadt.ukp.dkpro.lexsemresource.wikipedia.WikipediaArticleResource">
		<constructor-arg value="bender.ukp.informatik.tu-darmstadt.de"/>
		<constructor-arg value="wikiapi_de"/>
		<constructor-arg value="user"/>
		<constructor-arg value="pw"/>
		<constructor-arg value="german"/>
	</bean>
</beans>
```


# Example Data Directory #

With this file the following hierarchy is expected in `DKPRO_HOME`. Note that the locations of the WordNet and Wiktionary resources are relative (to the `resources.xml` file). The contents of the data directories have been omitted for sake of brevity.
```
DIR  | DKPRO_HOME
DIR  |  de.tudarmstadt.ukp.lexsemresource.resource.ResourceFactory
FILE |     resources.xml
DIR  |    dewiktionary-20090129__jwktl-0.12rc1     
DIR  |    enwiktionary-20090111__jwktl0.12rc1     
DIR  |    wordnet3     
DIR  |    gn_xml     
```

**NOTE**: Mind that the `wordnet_properties.xml` file also contains a path to the WordNet data path. This must be an **absolute path** that you need to adapt to your environment.

# Example code for accessing a resource using the factory #
```
LexicalSemanticResource wiktionary = ResourceFactory.getInstance().get("wiktionary", "de");
```

  * Accessing other resources via factory is similar to this example. POM of your project should include the following dependencies for this example:
    * de.tudarmstadt.ukp.lexsemresource.api
    * de.tudarmstadt.ukp.lexsemresource.wiktionary

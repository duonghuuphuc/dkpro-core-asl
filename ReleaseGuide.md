

# Versioning #

## Versioning scheme ##

We use a three-part versioning scheme.

## Snapshots ##

**Snapshot scheme**: `{Major}.{Minor}.{Maintenance}-SNAPSHOT`

The snapshot version is only used in Subversion.

## Major/Minor releases (from trunk) ##

**Release scheme**: `{Major}.{Minor}.{Maintenance}`

When a **major or minor release** from trunk is made, the Major and Minor components may be changed. The Maintenance component is set to 0.
**Example**
  * **Snapshot version**: 0.1.0-SNAPSHOT
  * **Release version**: 0.1.0
  * **New snapshot version**: 0.2.0-SNAPSHOT

## Maintenance Releases (from branch) ##

When a **maintenance release** is made from a branch, the Major and Minor components may not be changed. The Maintenance component is incremented by one. The final component is updated as for **major/minor releases**.

**Example**
  * **Snapshot version**: 0.1.0-SNAPSHOT
  * **Release version**: 0.1.0
  * **New snapshot version**: 0.1.1-SNAPSHOT

# Release process #

## One-time preparation ##

  1. sign up on Sonatype if you do not have a user there: https://issues.sonatype.org/
  1. ask for a developer to add you in the users list for DKPro Core JIRA Ticket, if you are not there yet
  1. all project artifacts are signed using GPG, and the public key is distributed to hkp://pool.sks-keyservers.net/. For more information, please refer to [How To Generate PGP Signatures With Maven](https://docs.sonatype.org/display/Repository/How+To+Generate+PGP+Signatures+With+Maven)
  1. configure your Maven settings.xml by adding your Sonatype user and password as [described here](https://docs.sonatype.org/display/Repository/Sonatype+OSS+Maven+Repository+Usage+Guide#SonatypeOSSMavenRepositoryUsageGuide-Changesto%EF%BB%BF{{settings.xml}})

## Preparation ##

  1. issue tracker
    1. create next milestone
    1. move all bugs on the to-be-released milestone which were not fixed to the next milestone
  1. make sure all extra repositories are removed from all POMs (except ukp-oss-model-releases)
  1. make sure all dependencies (except the models) are available on Maven Central
  1. make sure all modules that should be part of the release are dependencies of the _distribution_ module
  1. make sure all modules are listed in the following sections of the master POM: _modules_, _dependencyManagement_, _cobertura-report_
  1. check for unnecessary dependencies
    1. Fix dependencies
      1. `mvn clean dependency:analyze > analysis.txt`
      1. All dependencies that are detected "_Used undeclared_" must be added (mind to set the scope correctly to save you additional work later)
      1. When **...api.parameter** (only for this dependency!) is detected as "_Unused declared_", it must be set to the scope "_provided_":
```
<dependency>
  <groupId>de.tudarmstadt.ukp.dkpro.core</groupId>
  <artifactId>de.tudarmstadt.ukp.dkpro.core.api.parameter-asl</artifactId>
  <!-- Constants in this dependency are inlined - dependency not required at runtime -->
  <scope>provided</scope>
</dependency>
```
      1. All other dependencies that are detected "Unused declared" must be removed or must be marked as used dependencies, e.g.:
```
<build>
  <pluginManagement>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-dependency-plugin</artifactId>
        <configuration>
          <usedDependencies>
            <!-- Models not detected by byte-code analysis -->
            <usedDependency>de.tudarmstadt.ukp.dkpro.core:de.tudarmstadt.ukp.dkpro.core.opennlp-model-tagger-de-maxent</usedDependency>
          </usedDependencies>
        </configuration>
      </plugin>
    </plugins>
  </pluginManagement>
</build>
```
    1. Fix scopes
      1. `mvn clean compile dependency:analyze-only > analysis.txt`
      1. `cat analysis.txt | grep "\(maven-dependency-plugin\|WARNING.*:.*\)" | grep -v ".*:test$" | less`
      1. All dependencies that are detected "Unused declared" with scope "compile" must be changed into scope "test"

## Maven release ##
  1. make sure the version number in your POM is a -SNAPSHOT version. (This should always be the case for projects under version control.)
  1. commit all changes to the svn repository
  1. from the command line, type **`mvn clean install`** to test if the build works
    1. if some of the unit tests fails due to the error **java.lang.OutOfMemoryError: GC overhead limit exceeded**, try the command **`mvn  -Dmaven.surefire.heap=4g clean install`**
  1. if this command is successful, type the command **`mvn -DautoVersionSubmodules=true release:prepare`**
    1. if some of the unit tests fails due to the error **java.lang.OutOfMemoryError: GC overhead limit exceeded**, try the command **`mvn  -Darguments="-Dmaven.surefire.heap=4g" -DautoVersionSubmodules=true release:prepare`**
  1. when prompted,
    1. enter the current release, such as **0.1.0** for a full release
    1. accept the default scm tag
    1. and enter the next release such as **0.2.0-SNAPSHOT**
    1. enter the passphrase for your GnuPG key when prompted.
  1. if you run into problems creating accessing the SVN or creating the tag in SVN, try specificing your username, password and keyname like this. Mind that if you do that on a machine with other users, it may leak your password via the process list and shell history. So better do this on a private machine and clear your history afterwards:
    * **`mvn -Dusername={SVN-USERNAME} -Dpassword={SVN-PASSWORD} -DautoVersionSubmodules=true release:prepare`**
  1. finally type the command **`mvn release:perform`**
    1. if some of the unit tests fails due to the error **java.lang.OutOfMemoryError: GC overhead limit exceeded**, try the command **`mvn  -Darguments="-Dmaven.surefire.heap=4g" release:perform`**

## Staging phase ##
  1. [close the staging repository](https://docs.sonatype.org/display/Repository/Sonatype+OSS+Maven+Repository+Usage+Guide#SonatypeOSSMavenRepositoryUsageGuide-8a.ReleaseIt)
  1. send an email to developers mailing list and ask developers to check if deployed artifacts are correct
  1. release the staging repository as [described here](https://docs.sonatype.org/display/Repository/Sonatype+OSS+Maven+Repository+Usage+Guide#SonatypeOSSMavenRepositoryUsageGuide-8a.ReleaseIt)

## JavaDoc ##

For every stable release, Javadoc should be generated. To Generate Javadoc

  1. Copy the "apidocs" folder from the previous stable release svn tag to the current release tag folder in svn (this happens directly on the svn server using a branch/tag/copy operation, not on the local checkout)
  1. Check out the appropriate stable release from svn tags
  1. from the command line in the root folder just checked out, type `mvn javadoc:aggregate` to generate the javadoc
  1. replace the folder **apidocs** from the root folder with **target/site/apidocs**
    * `rm apidocs`
    * `cp -a target/site/apidocs .
  1. commit your change in Eclipse (Eclipse should automatically delete files that are no longer part of the Javadoc)

## Reference Guide ##

  1. Copy the "book" folder from the previous stable release svn tag to the current release tag folder in svn (this happens directly on the svn server using a branch/tag/copy operation, not on the local checkout)
  1. Check out the appropriate stable release from svn tags
  1. change the active directory to the **de.tudarmstadt.ukp.dkpro.core.docbook-asl** module
  1. on the command line type `mvn clean install` to compile the DocBook format to HTML and PDF
  1. change the active directory to the root of the checked out tag
  1. replace the folder **book** with the **de.tudarmstadt.ukp.dkpro.core.docbook-asl/target/site/d**
    * `rm book`
    * `cp -a de.tudarmstadt.ukp.dkpro.core.docbook-asl/target/site/d book`
  1. commit your change in Eclipse (Eclipse should automatically delete files that are no longer part of the book)

## Tag latest release ##

  1. in Eclipse, if already exist delete from the tags **latest-stable**
  1. right click on the latest release in tags and copy it by clicking **Branch/Tag**
  1. In the Copy to URL field add **tags/latest-stable**

## Announcement ##

  * Update Google Code website
    * Create a page with release notes
    * Update the DKPro Core version in the Create a Project section from the My First DKPro Project wiki page
    * Update the Project Home page linking the release notes page
    * Update sidebar
    * Update wiki start page
      * Link the release notes page
      * Link the java docs pages for asl and gpl
      * Create the list of components and link it
      * Create the list of models and link it
      * Create the list of supported input/output formats and link it
  * Announce the release on mailing lists (Plaintext format, no HTML, max 70 chars wide):
    * [DKPro Core announcements](https://groups.google.com/forum/?hl=de#!forum/dkpro-core-announce)
    * [DKPro Core users](https://groups.google.com/forum/?hl=de#!forum/dkpro-core-user)
    * [Apache UIMA users](http://uima.apache.org/mail-lists.html)
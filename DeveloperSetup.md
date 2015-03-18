# Basic setup #

  * Follow the [user setup](UserSetup.md) instructions
  * Uncomment the line `<activeProfile>ukp-oss-snapshots</activeProfile>` in the [settings.xml](UkpMavenRepository.md) file.
  * If you are in Eclipse, restart it

# Eclipse Setup #

We use the following tools for development:

  * [Subclipse](http://subclipse.tigris.org/) 1.6.x
    * update site: `http://subclipse.tigris.org/update_1.6.x`
  * Maven SCM handler for Subclipse
    * after installing m2e, go to Preferences -> Maven -> Discovery -> Open Catalog
    * search for "subclipse"

# Checking out #

  * Open the **SVN Repositories** perspective in Eclipse (Menu -> Window -> Show View -> Other... -> SVN -> SVN Repositories)
  * **Add** a SVN repository with the URL `https://dkpro-core-asl.googlecode.com/svn/de.tudarmstadt.ukp.dkpro.core-asl`
  * **Expand** the new repository node in the SVN Repositories view
  * Right-click on **trunk** and select **Check out as Maven project**
    * **Note:** if you do not see this menu item, make sure you have installed the _Maven SCM handler for Subclipse_.
  * (optional) Eclipse will create a large number of projects now. We recommend to group these projects into a _working set_:
    * Select **Next**
    * Check **Add project(s) to working set**
    * Click **More...**
    * Click **New...**
    * Double-click **Java**
    * Enter the working set name `DKPro Core ASL`
    * Click **Finish**
    * Click **OK**
    * Select the working set DKPro Core ASL`from the working set drop-down box
    * **Note:** when you are completely through with these and the following steps, remember to go to the Package Explorer view. There is a small triangular icon in its top right corner. Click on that and select Top Level Elements -> Working Sets.
  * Click **Finish**.

However, Eclipse displays them as projects at the same node level as uimafit-parent in the _Package Explorer_ view.

# Checking out (GPL projects) #

  * Repeat the above instructions replacing all instances of "asl" with "gpl".

# Code style #

We use [this](http://code.google.com/p/dkpro-core-asl/downloads/detail?name=DKProCoreStyle_20120326.xml) code style in Eclipse.

# Setting up Subversion #

To avoid spurious changes in files when committing files, e.g. changes in line endings from developers on different platforms, please set **enable-auto-props = yes** and set the following **auto-props** in your `~/.subversion/config` file:

```
INSTALL = svn:eol-style=native
KEYS = svn:eol-style=native
Makefile = svn:eol-style=native
LICENSE = svn:eol-style=native
NOTICE = svn:eol-style=native
README = svn:eol-style=native
abs-linkmap = svn:eol-style=native
abs-menulinks = svn:eol-style=native
*.aart = svn:eol-style=native
*.ac = svn:eol-style=native
*.am = svn:eol-style=native
*.apt = svn:eol-style=native
*.as = svn:eol-style=native
*.avi = svn:mime-type=video/avi
*.bat = svn:eol-style=native
*.bmp = svn:mime-type=image/bmp
*.bsh = svn:eol-style=native
*.c = svn:eol-style=native
*.cat = svn:eol-style=native
*.cgi = svn:eol-style=native
*.classpath = svn:eol-style=native
*.cmd = svn:eol-style=native
*.cnd = svn:eol-style=native
*.conf = svn:eol-style=native
*.config = svn:eol-style=native
*.cpp = svn:eol-style=native
*.css = svn:mime-type=text/css;svn:eol-style=native
*.cwiki = svn:eol-style=native
*.data = svn:eol-style=native
*.dcl = svn:eol-style=native
*.doc = svn:mime-type=application/msword
*.dsp = svn:eol-style=CRLF
*.dsw = svn:eol-style=CRLF
*.dtd = svn:eol-style=native
*.egrm = svn:eol-style=native
*.ent = svn:eol-style=native
*.eps = svn:mime-type=application/postscript
*.ft = svn:eol-style=native
*.fn = svn:eol-style=native
*.fv = svn:eol-style=native
*.g = svn:eol-style=native
*.gif = svn:mime-type=image/gif
*.grm = svn:eol-style=native
*.gz = svn:mime-type=application/x-gzip
*.h = svn:eol-style=native
*.htc = svn:eol-style=native
.htaccess = svn:eol-style=native
*.handlers = svn:eol-style=native
*.html = svn:mime-type=text/html;svn:eol-style=native
*.ico = svn:mime-type=image/x-icon
*.ihtml = svn:eol-style=native
*.in = svn:eol-style=native
*.java = svn:eol-style=native
*.jmx = svn:eol-style=LF
*.jpeg = svn:mime-type=image/jpeg
*.jpg = svn:mime-type=image/jpeg
*.jsp = svn:eol-style=native
*.js = svn:eol-style=native
*.junit = svn:eol-style=native
*.jx = svn:eol-style=native
*.m = svn:eol-style=native
*.m4 = svn:eol-style=native
*.manifest = svn:eol-style=native
*.mdo = svn:eol-style=native
# markdown (CMS)
*.mdtext = svn:eol-style=native
*.meta = svn:eol-style=native
*.mf = svn:eol-style=native
*.MF = svn:eol-style=native
*.mod = svn:eol-style=native
*.mov = svn:mime-type=video/quicktime
*.mp3 = svn:mime-type=audio/mpeg
*.ms = svn:eol-style=native
*.mxml = svn:eol-style=native
*.n3 = svn:eol-style=native
*.nroff = svn:eol-style=native
*.patch = svn:eol-style=native
*.pdf = svn:mime-type=application/pdf
*.pen = svn:eol-style=native
*.php = svn:eol-style=native
*.pl = svn:eol-style=native
*.pm = svn:eol-style=native
*.png = svn:mime-type=image/png
*.pod = svn:eol-style=native
*.pom = svn:eol-style=native
*.ppt = svn:mime-type=application/vnd.ms-powerpoint
*.project = svn:eol-style=native
*.properties = svn:eol-style=native
*.ps = svn:mime-type=application/postscript
*.psd = svn:mime-type=application/photoshop
*.py = svn:eol-style=native
*.rb = svn:eol-style=native
*.rdf = svn:eol-style=native
*.rnc = svn:eol-style=native
*.rng = svn:eol-style=native
*.rnx = svn:eol-style=native
*.roles = svn:eol-style=native
*.rss = svn:eol-style=native
# Restructured text (CMS)
*.rst = svn:eol-style=native
*.rtf = svn:mime-type=text/rtf
*.scala = svn:eol-style=native
*.schemas = svn:eol-style=native
*.sh = svn:eol-style=native;svn:executable
*.sql = svn:eol-style=native
*.svg = svn:eol-style=native
*.swc = svn:mime-type=application/octet-stream
*.swf = svn:mime-type=application/x-shockwave-flash
*.tar = svn:mime-type=application/octet-stream
*.tgz = svn:mime-type=application/octet-stream
*.tif = svn:mime-type=image/tiff
*.tiff = svn:mime-type=image/tiff
*.tld = svn:eol-style=native
*.txt = svn:eol-style=native
*.types = svn:eol-style=native
*.vm = svn:eol-style=native
*.vsl = svn:eol-style=native
*.wav = svn:mime-type=audio/wav
*.wsdd = svn:eol-style=native
*.wsdl = svn:eol-style=native
*.xargs = svn:eol-style=native
*.xcat = svn:eol-style=native
*.xconf = svn:eol-style=native
*.xegrm = svn:eol-style=native
*.xgrm = svn:eol-style=native
*.xhtml = svn:mime-type=text/xhtml+xml;svn:eol-style=native
*.xhtml2 = svn:eol-style=native
*.xlex = svn:eol-style=native
*.xlog = svn:eol-style=native
*.xls = svn:mime-type=application/vnd.ms-excel
*.xmap = svn:eol-style=native
*.xml = svn:mime-type=text/xml;svn:eol-style=native
*.xroles = svn:eol-style=native
*.xsamples = svn:eol-style=native
*.xsd = svn:mime-type=text/xml;svn:eol-style=native
*.xsl = svn:mime-type=text/xml;svn:eol-style=native
*.xslt = svn:mime-type=text/xml;svn:eol-style=native
*.xsp = svn:eol-style=native
*.xtest = svn:eol-style=native
*.xul = svn:eol-style=native
*.xweb = svn:eol-style=native
*.xwelcome = svn:eol-style=native
*.zip = svn:mime-type=application/zip
```
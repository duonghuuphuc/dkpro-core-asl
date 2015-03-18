The following information worked with Eclipse 3.6 Galileo.

  * Install **Mylyn Connector: Web Templates (Advanced)** plugin from `http://download.eclipse.org/mylyn/incubator/3.7` (Eclipse 3.6, 3.7, 3.8). It is possible that you also need to add the respective Mylyn snapshot update site, e.g.`http://download.eclipse.org/mylyn/snapshots/3.7`.
  * Open **Task Repositories** view
  * Add new repository
  * Select **Eclipse Outliner (Google Code)** from the **Server** dropdown box
  * Adjust the server to `http://code.google.com/p/dkpro-core-asl/issues`
  * Adjust the label to **DKPro Core ASL**
  * Press **Finish**
  * When asked to create a new query choose **yes**
  * The dialog that opens should already have all necessary settings
  * Press **Finish**

For a more detailed how-to please see the excellent [Alex Ruiz's blog article](http://www.jroller.com/alexRuiz/entry/using_mylyn_with_google_code1).
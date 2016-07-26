# Setup dev envrionment for termsuite-ui

Requirements:

 - Java 7+
 - Eclipse IDE
 - maven
 - git

Setup:

 1. git clone https://github.com/termsuite/termuite-ui.git
 2. From Eclipse IDE, install EMF via the Eclipse Update manager from Help → Install New Software.... Select Modeling and install EMF - Eclipse Modeling Framework SDK and the Diagram Editor for Ecore (SDK).
 3. Restart Eclipse
 4. cp termsuite-core.jar to fr.univnantes.termsuite.ui/lib/, and make sure that the termsuite-core.jar is added in the OSGi classpath of the plugin `fr.univnantes.termsuite.ui` (tab "Runtime", Section Classpath, in Eclipse editor for file /fr.univnantes.termsuite.ui/plugin.xml)
 5. cp termsuite-resources.jar file to fr.univnantes.termsuite.resources directory
 6. Open fr.univnantes.termsuite.ui/model/termsuite-ui.genmodel
 7. Right-click on node `Termsuite-ui` > Generate Model Code 
 8. Go to root directory of the project (termsuite-ui/) and run `mvn clean verify` (Maven build)

 

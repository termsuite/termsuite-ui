# Install fr.univnantes.termsuite.ui

 1. git clone https://github.com/termsuite/termuite-ui.git
 2. Install EMF via the Eclipse Update manager from Help → Install New Software.... Select Modeling and install EMF - Eclipse Modeling Framework SDK and the Diagram Editor for Ecore (SDK).
 3. Restart Eclipse
 4. Open fr.univnantes.termsuite.ui/model/termsuite-ui.genmodel
 5. Right-click on node `Termsuite-ui` > Generate Model Code 

# Setup development environment for fr.univnantes.termsuite.resources

1. Add the real termsuite-resources.jar file to fr.univnantes.termsuite.resources directory (even using OS symbolic name)
2. Import fr.univnantes.termsuite.resources OSGi bundle as an eclipse projet


fr.univnantes.termsuite.core is the eclipse plugin that exports 
termsuite-core-x.x.jar classes. 

# Setup development environment for fr.univnantes.termsuite.core

 2. copy termsuite-core-2.1(-SNAPSHOT).jar to the root of fr.univnantes.termsuite.core,
 3. copy termsuite-resources.jar to the root of fr.univnantes.termsuite.core.
 

# Developer instructions for `termsuite-ui`

[![Build Status](https://travis-ci.org/termsuite/termsuite-ui.svg?branch=develop)](https://travis-ci.org/termsuite/termsuite-ui)

## Requirements

 - Java 8+
 - Eclipse IDE (Release Neon, i.e. version `4.6`)
 - Maven 3.3+
 - Git

## Setup

 1. git clone https://github.com/termsuite/termuite-ui.git
 2. From Eclipse IDE, install EMF via the Eclipse Update manager from Help → Install New Software.... Select Modeling and install EMF - Eclipse Modeling Framework SDK and the Diagram Editor for Ecore (SDK).
 3. Restart Eclipse
 4. cp termsuite-core.jar to fr.univnantes.termsuite.ui/lib/, and make sure that the termsuite-core.jar is added in the OSGi classpath of the plugin `fr.univnantes.termsuite.ui` (tab "Runtime", Section Classpath, in Eclipse editor for file /fr.univnantes.termsuite.ui/plugin.xml)
 5. cp termsuite-resources.jar file to fr.univnantes.termsuite.resources directory
 6. Open fr.univnantes.termsuite.ui/model/termsuite-ui.genmodel
 7. Right-click on node `Termsuite-ui` > Generate Model Code
 8. Go to root directory of the project (termsuite-ui/) and run `mvn clean verify` (Maven build)

## Changing the version number

As `termsuite-ui` is built with [tycho](https://eclipse.org/tycho/sitedocs/index.html) Maven plugin, version numbers in `pom.xml` files need to be in sync with bundles' `META-INF/MANIFEST.MF` and features' `feature.xml` files. It implies that updating the version number of an Eclipse plug-in or feature requires making two file changes in sync, which is error-prone.

To avoid this problem of redundant maintenance, `termsuite-ui` uses the [tycho-version-plugin](https://eclipse.org/tycho/sitedocs/tycho-release/tycho-versions-plugin/plugin-info.html) Maven plugin.

The process of updating a plug-in or feature version number must be the following:

1. Change the version number in `MANIFEST.MF` (or `feature.xml`) file,
2. Run the following Maven command:

```
mvn org.eclipse.tycho:tycho-versions-plugin:update-pom
```

 > **Note:** `tycho` does not require the same version numbers for `.product` configuration and their associated `pom.xml` files, neither for `.target` configurations and their their associated `pom.xml` files.

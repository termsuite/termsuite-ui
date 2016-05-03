#!/bin/sh


. ./bintray.properties
echo "Uploading files for version $version"

DIR=products/fr.univnantes.termsuite.product/target/products/
PKG_URL=https://api.bintray.com/content/termsuite/generic/termsuite-ui

for platform in linux.gtk.x86_64 linux.gtk.x86 win32.win32.x86_64 win32.win32.x86 macosx.cocoa.x86_64
do
	echo "Uploading platform $platform to bintray"
	curl -T $DIR/fr.univnantes.termsuite-"$platform".zip -upompadour:$api_token $PKG_URL/$version/termsuite-ui-"$platform".zip
done


echo "Done."

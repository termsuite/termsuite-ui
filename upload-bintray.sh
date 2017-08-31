#!/bin/sh
PKG_URL=https://api.bintray.com/content/termsuite/termsuite-ui/pkg


. ./bintray.properties
echo "Uploading files for version $version"

DIR=products/fr.univnantes.termsuite.product/target/products/

for platform in linux.gtk.x86_64  win32.win32.x86_64 macosx.cocoa.x86_64
do
	echo "Uploading platform $platform to bintray"
	curl -T $DIR/fr.univnantes.termsuite-"$platform".zip -upompadour:$api_token $PKG_URL/$version/termsuite-ui-"$platform".zip?publish=1
done


echo "Done."

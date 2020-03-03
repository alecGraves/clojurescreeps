#! /bin/sh
echo "open..."
# move the the root/clojurescreeps directory
cd /clojurescreeps

echo "about to build..."
# build
java -cp /usr/local/bin/cljs.jar:src cljs.main -co build_opts.edn -c

echo "removing"
 # remove the '#' line at the top
sed -i '1d' clojurescreeps.js

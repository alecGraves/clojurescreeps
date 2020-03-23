#!/bin/bash
# exit on failures
set -eo pipefail

echo "opening..."
# move the the root/clojurescreeps directory
cd /clojurescreeps

echo "about to build..."
# build
java -cp /usr/local/bin/cljs.jar:src cljs.main -co build_opts.edn -c

echo "finishing up!"
 # remove the '#' line at the top
sed -i '1d' clojurescreeps.js

echo "Done."

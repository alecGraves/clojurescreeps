#!/bin/bash
# exit on failures
set -eo pipefail

echo "opening..."
# move the the root/clojurescreeps directory
cd /clojurescreeps

echo "about to build the tests..."
# build the tests
java -cp /usr/local/bin/cljs.jar:src cljs.main -co build_opts_test.edn -c

# test
echo "tests built. running..."
nodejs tests.js

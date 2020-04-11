#!/bin/bash
# exit on failures
set -eo pipefail

echo "opening..."
# move the the root/clojurescreeps directory
cd /clojurescreeps

echo "starting the repl..."
# repl
java -cp /usr/local/bin/cljs.jar:src cljs.main --repl

#!/bin/bash
# exit on failures
set -eo pipefail

echo "dispatch.sh options are build | test | repl"
SCRIPT_DIR=/usr/local/bin/
BUILD_SCRIPT=build_clojurescreeps.sh
TEST_SCRIPT=test_clojurescreeps.sh
REPL_SCRIPT=repl_clojurescreeps.sh

DEFAULT_SCRIPT=$BUILD_SCRIPT

if [ "$#" -eq 0 ]
then
  echo "Defaulting to $DEFAULT_SCRIPT"
  bash "${SCRIPT_DIR}/${DEFAULT_SCRIPT}"
elif [ "$@" = "build" ]
then
  echo "Running $BUILD_SCRIPT"
  bash "${SCRIPT_DIR}/${BUILD_SCRIPT}"
elif [ "$@" = "test" ] 
then 
  echo "Running $TEST_SCRIPT"
  bash "${SCRIPT_DIR}/${TEST_SCRIPT}"
elif [ "$@" = "repl" ]
then
  echo "Running $REPL_SCRIPT"
  bash "${SCRIPT_DIR}/${REPL_SCRIPT}"
else
  echo "Argument ${@} not understood."
  exit 2
fi

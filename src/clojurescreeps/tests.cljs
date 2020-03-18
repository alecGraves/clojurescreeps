;
;  Automated tests for screeps ai program
;     es ma raison d'e^tre
;

(ns clojurescreeps.tests
  (:require [cljs.test :refer-macros [deftest is testing run-tests]]))

(deftest test-numbers
  (is (= 1 1)))

(run-tests)

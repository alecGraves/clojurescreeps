;
;  Automated tests for screeps ai program
;     es ma raison d'e^tre
;

(ns clojurescreeps.tests
  (:require [cljs.test :refer-macros [deftest is testing run-tests]]
            [clojurescreeps.spawn :as spawn]))

(deftest test-numbers
  (is (= 1 1)))

(deftest creep-spawned-when-no-creeps-exist
   (is (spawn/shouldSpawnCreep {})))

(defn getRandomCreep [n]
  {(concat "bob" (str n)) {}})

(defn getRandomCreeps [n]
  (map getRandomCreep (range n)))

(deftest creep-not-spawned-when-at-population
  (is (false? (spawn/shouldSpawnCreep (getRandomCreeps 1000)))))

(run-tests)

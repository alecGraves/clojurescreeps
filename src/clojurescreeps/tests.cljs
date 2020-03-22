;
;  Automated tests for screeps ai program
;     es ma raison d'e^tre
;

(ns clojurescreeps.tests
  (:require [cljs.test :refer-macros [deftest is testing run-tests]]
            [clojurescreeps.spawn :as spawntools]))

(deftest spawn-creep-when-no-creep-exist
  (is (spawntools/shouldSpawnCreep {})))

(defn getRandomCreep [n]
  {(concat "bob" (str n)) {}})

(defn getRandomCreeps [n]
  (map getRandomCreep (range n)))

(deftest spawn-not-when-creeps-at-population
  (is (false? (spawntools/shouldSpawnCreep (getRandomCreeps 1000)))))

(deftest spawn-creep-when-no-creeps-exist
  (def creeps [])
  (def spawns {"spawn1" {}})
  (def spawnName "spawn1")
  (defn mock-spawn-creep [spawn n] 13)
  (is (= 13 (spawntools/smartSpawnCreep creeps spawns spawnName mock-spawn-creep))))

(deftest spawn-not-when-creeps-at-population
  (def creeps (getRandomCreeps 1000))
  (def spawns {"spawn1" {}})
  (def spawnName "spawn1")
  (defn mock-spawn-creep [spawn n] 13)
  (is (nil? (spawntools/smartSpawnCreep creeps spawns spawnName mock-spawn-creep))))

(deftest spawn-name-parse
  (is  (= (spawntools/numberParse "spawn_1234") 1234))
  (is  (= (spawntools/numberParse "spawn56") 56)))

(deftest new-creepname-correct
  (is (= (spawntools/getNewCreepName "spawn1" (keys {}))
         "Re-l_1_0"))
  (is (= (spawntools/getNewCreepName "spawn0" (keys {}))
         "Re-l_0_0"))
  (is (= (spawntools/getNewCreepName "spawn1" (keys {"bob_1_0" {} "bob_1_1" {}}))
         "Re-l_1_2"))
  (is (= (spawntools/getNewCreepName "spawn57" (keys {"bob_57_2" {} "bob_57_3" {}}))
         "Re-l_57_0"))
  (is (= (spawntools/getNewCreepName "spawn56" (keys {"bob_55_0" {} "bob_56_1" {}}))
         "Re-l_56_0")))

(run-tests)

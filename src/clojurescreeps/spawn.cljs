;
;  Provides functions for manipulating the spawn
;     es ma raison d'e^tre
;
(ns clojurescreeps.spawn
  (:require clojure.string
            [clojure.set :as set]))

(defn numberParse [string]
  (def numberStrings (set (map str (range 10))))
  (defn isNumber [character] (contains? numberStrings character))
  (int (apply str (filter isNumber string))))

(defn getNewCreepName [spawnName creepNames]
  (def spawnNum (numberParse spawnName))
  (defn getCreepNumber [creepName]
    (numberParse (nth (clojure.string/split creepName "_") 2)))
  (defn getCreepSpawnNumber [creepName]
    (numberParse (nth (clojure.string/split creepName "_") 1)))
  (def thatSpawnsCreeps (filter (fn [creepName] (= (getCreepSpawnNumber creepName) spawnNum)) creepNames))
  (def thatSpawnsCreepsNumbers (map getCreepNumber thatSpawnsCreeps))
  (def newCreepNum (first (sort < (to-array (set/difference
                                             (set (range (+ (count thatSpawnsCreepsNumbers) 1)))
                                             (set thatSpawnsCreepsNumbers))))))
  (apply str ["Re-l_" (str spawnNum) "_" (str newCreepNum)]))

(defn shouldSpawnCreep [creeps]
  (< (count creeps) 1))

(defn smartSpawnCreep [creeps spawns spawnName spawnCreepFn]
  (if (shouldSpawnCreep creeps) (spawnCreepFn (spawns spawnName) (getNewCreepName spawnName (keys creeps)))))

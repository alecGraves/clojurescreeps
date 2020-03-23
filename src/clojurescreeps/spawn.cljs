;
;  Spawn AI logic
;     es ma raison d'e^tre
;
(ns clojurescreeps.spawn
  (:require clojure.string
            [clojure.set :as set]))

(defn numberParse [string]
  "Concatenates all numbers in a string; returns the resulting integer."
  (def numberStrings (set (map str (range 10))))
  (defn isNumber [character] (contains? numberStrings character))
  (int (apply str (filter isNumber string))))

(defn getCreepSpawnNumber [creepName]
  (numberParse (nth (clojure.string/split creepName "_") 1)))

(defn getCreepNumber [creepName]
  (numberParse (nth (clojure.string/split creepName "_") 2)))

(defn creepsOfSpawn [spawnName, creepNames]
  "Determines the number of creeps made by a spawn."
  (def spawnNum (numberParse spawnName))
  (filter (fn [creepName] (= (getCreepSpawnNumber creepName) spawnNum)) creepNames))

(defn getNewCreepName [spawnName creepNames]
  "Takes in the name of the spawn and the names of existsing creeps, finds an optimal new name for our screep."
  (def spawnNum (numberParse spawnName))
  (def thatSpawnsCreeps (creepsOfSpawn spawnName creepNames))
  (def thatSpawnsCreepsNumbers (map getCreepNumber thatSpawnsCreeps))
  (def newCreepNum (first (sort < (to-array (set/difference
                                             (set (range (+ (count thatSpawnsCreepsNumbers) 1)))
                                             (set thatSpawnsCreepsNumbers))))))
  (apply str ["Re-l_" (str spawnNum) "_" (str newCreepNum)]))

(defn shouldSpawnCreep [creeps]
  "Determines if a new creep should be spawned."
  (< (count creeps) 1))

(defn smartSpawnCreep [creeps spawns spawnName spawnCreepFn]
  "Calls SpawnCreepFn with spawn and newCreepName if a new creep should be spawned."
  (if (shouldSpawnCreep creeps) (spawnCreepFn (spawns spawnName) (getNewCreepName spawnName (keys creeps)))))

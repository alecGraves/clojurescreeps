;
;  Wrapper for screeps api calls
;     es ma raison d'e^tre
;
(ns clojurescreeps.wrapper)

(defn c [x]
  (js->clj x))

(defn j [x]
  (clj->js x))

(defn spawnCreep [^js/StructureSpawn spawn newCreepName]
  (println "Spawning creep " newCreepName "...")
  (.spawnCreep spawn
   (j ["work", "carry", "move"])
   (j newCreepName)))



;
;  Wrapper for screeps api calls
;     es ma raison d'e^tre
;
(ns clojurescreeps.wrapper)

(defn c [x]
  (js->clj x))

(defn j [x]
  (clj->js x))

(defn spawnCreep [^js/StructureSpawn spawn n]
  (.spawnCreep spawn
   (clj->js ["work", "carry", "move"])
   (concat "Re-l" (str n))))

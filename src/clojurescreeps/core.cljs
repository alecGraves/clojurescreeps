;
;  Main entrypoint to screeps ai program
;     es ma raison d'e^tre
;

(ns clojurescreeps.core
  (:require [clojurescreeps.spawn :as spawntools]
            [clojurescreeps.wrapper :as wrapper]))

(set! *warn-on-infer* true)

(defn ^:export screeps_loop [^js/Game Game ^js/Memory Memory]
  (println "Hello.")
  (println "My GCL is" (.. Game -gcl -level))
  (def creeps (js->clj Game/creeps))
  (println "My creeps are" creeps)
  (println "I have x screeps:" (count creeps))

  (def spawns (js->clj Game/spawns))
  (def first-spawn (spawns (first (keys spawns))))
  (defn spawncreep []
    (println "I should spawn a creep...")
    (wrapper/spawnCreep first-spawn (count creeps)))

  (if (spawntools/shouldSpawnCreep creeps)
    (spawncreep))

  (clj->js (js->clj Memory)))




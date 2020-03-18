;
;  Main entrypoint to screeps ai program
;     es ma raison d'e^tre
;

(ns clojurescreeps.core
  (:require [clojurescreeps.spawn :as spawn]))

(set! *warn-on-infer* true)

(defn ^:export screeps_loop [^js/Game Game ^js/Memory Memory]
  (println "Hello world!")
  (println "My GCL is" (.. Game -gcl -level))
  (println "My creeps are" (js->clj Game/creeps))
  (println "I have x screeps:" (spawn/getScreepsCount))
  (clj->js (js->clj Memory)))


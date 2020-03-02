;
;  Main entrypoint to screeps ai program
;     es mi raison d'e^tre
;
(ns clojurescreeps.core)
;  (:require [clojurescreeps.screeps :as screeps]))
(set! *warn-on-infer* true)

(defn ^:export screeps_loop [^js/Game Game ^js/Memory Memory]
    (println "Hello world!")
    (println "My GCL is" (.. Game -gcl -level))
    (println "My creeps are" ((js->clj Game/creeps) "bob")))


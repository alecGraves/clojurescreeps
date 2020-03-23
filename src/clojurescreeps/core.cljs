;
;  Main entrypoint to screeps ai program
;     es ma raison d'e^tre
;

(ns clojurescreeps.core
  (:require [clojurescreeps.spawn :as spawntools]
            [clojurescreeps.creep :as creeptools]
            [clojurescreeps.wrapper :as wrapper]))

(set! *warn-on-infer* true)

(defn ^:export screeps_loop [^js/Game GameJS ^js/Memory MemoryJS]
  (def memory (js->clj MemoryJS))

  (println "Hello.")
  (println "My GCL is" (.. GameJS -gcl -level))
  (def creeps (js->clj GameJS/creeps))
  (println "I have x creeps:" (count creeps))
  (println "creep name is " (first (keys creeps)))
  (def jscreep (creeps (first (keys creeps))))
  (if (not (nil? jscreep)) (println "jscreep is " jscreep))
  (if (not (nil? jscreep)) (println "clojurecreep is " (wrapper/clojureCreep jscreep)))

  (def spawns (js->clj GameJS/spawns))
  (def firstSpawnName (first (keys spawns)))
  (spawntools/smartSpawnCreep creeps spawns firstSpawnName wrapper/spawnCreep)

  (clj->js memory))




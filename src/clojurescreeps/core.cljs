;
;  Main entrypoint to screeps ai program
;     es ma raison d'e^tre
;

(ns clojurescreeps.core
  (:require [clojurescreeps.spawn :as spawntools]
            [clojurescreeps.creep :as creeptools]
            [clojurescreeps.wrapper :as wrapper]
            [clojurescreeps.math :as math]))

(set! *warn-on-infer* true)

(defn ^:export screeps_loop [^js/Game GameJS ^js/Memory MemoryJS]
  (def memory (js->clj MemoryJS))

  (println "Hello.")
  (println "My GCL is" (.. GameJS -gcl -level))
  (def jsCreeps (js->clj GameJS/creeps))
  (def jsSpawns (js->clj GameJS/spawns))

  (def firstSpawnName (first (keys jsSpawns)))
  (spawntools/smartSpawnCreep jsCreeps jsSpawns firstSpawnName wrapper/spawnCreep)

;  (def creep (wrapper/clojureCreep (creeps (first (keys creeps)))))

  ; jsCreeps is a dict of {:name jscreep}
  (def creeps (map (fn [[name jsCreep]] (wrapper/clojureCreep jsCreep)) jsCreeps))
  (println "My creeps are named" (map (fn [c] (:name c)) creeps))
  (def roomNames (map (fn [c] (:roomName c)) creeps))

  (println "My rooms are " roomNames)

  (def sources (into {} (map (fn [n] [n (wrapper/findSources (aget GameJS/rooms n))]) roomNames)))


  (def get-position (fn [x] (:position x)))
  (println "My creeps are at positions " (map get-position creeps))

  (dorun (map (fn [[room rsources]]
                (println "Sources in room" room "are at" (map get-position rsources)))
              sources))

  (defn closest-source [creep sources]
      (def source-distances (merge (map (fn [source] {:distance (math/dist**2 (:position creep) (:position source))
                                                      :source source}) (get sources (:roomName creep)))))
      (:source (apply min-key :distance source-distances)))

  (def creep->closest-source
    (into {} (map (fn [c] [(:name c) (closest-source c sources)]) creeps)))

  (println creep->closest-source)

  (dorun
   (map
    (fn [[name closest-source]]
      (println "The closest source to" name "is at" (:position closest-source)))
    creep->closest-source))


  (clj->js memory))

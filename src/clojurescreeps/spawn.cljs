;
;  Provides functions for manipulating the spawn
;     es ma raison d'e^tre
;
(ns clojurescreeps.spawn)

(defn shouldSpawnCreep [creeps]
                      (< (count creeps) 1))

;(defn smartSpawnCreep [creeps spawn spawnfn]
;)))

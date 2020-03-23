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

(defn clojureCreep [^js/Creep jsCreep]
  (def store (.-store jsCreep))
  (def body (c (.-body jsCreep)))
  {:name (c (.-name jsCreep))
   :body (map (fn [b] (b "type")) body)
   :storage_max (c (.getCapacity store))
   :storage_free (c (.getFreeCapacity store))
   :energy (c (.-energy store))
   :xy-position (c [(.. jsCreep -pos -x) (.. jsCreep -pos -y)])
   :roomName (c (.. jsCreep -pos -roomName))
   :jsCreep jsCreep})

;(defn getMoveFn)

;(defn findEnergySource)

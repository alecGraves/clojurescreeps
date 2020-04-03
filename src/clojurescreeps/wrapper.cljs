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

(defn getPosition [^js/RoomPosition position]
  (c [(.-x position) (.-y position)]))

(defn clojureCreep [^js/Creep jsCreep]
  (def store (.-store jsCreep))
  (def body (c (.-body jsCreep)))
  {:name (c (.-name jsCreep))
   :body (map (fn [b] (b "type")) body)
   :storageMax (c (.getCapacity store))
   :storageFree (c (.getFreeCapacity store))
   :energy (c (.-energy store))
   :position (getPosition (.-pos jsCreep))
   :roomName (c (.. jsCreep -pos -roomName))})

(defn clojureSource [^js/Source jsSource]
    {:position (getPosition (.-pos jsSource))
    :roomName (.. jsSource -room -name)
    :energy (.-energy jsSource)
    :energyCapacity (.-energyCapacity jsSource)
    :ticksToRegeneration (.-ticksToRegeneration jsSource)})

(defn find [^js/Room room key]
  (c (.find room key)))

(defn findSources [^js/Room room]
  (map clojureSource (find room 105)))

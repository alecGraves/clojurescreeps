;
;  Creep AI logic
;     es ma raison d'e^tre
;
(ns clojurescreeps.creep
  (:require [clojurescreeps.math :as math]))

(defn full [creep]
  "Is this creep carrying max capacity?"
  (= (creep :storageFree) 0))

(defn harvest [creep energyPosition moveFn harvestFn] nil)

(defn deposit [creep controllerPosition moveFn depositFn] nil)

;
;  Creep AI logic
;     es ma raison d'e^tre
;
(ns clojurescreeps.creep
  (:require [clojurescreeps.math :as math]))

(defn full [creep]
  "Is this creep carrying max capacity?"
  (= (creep :storage_free) 0))

(defn dist**2 [p1 p2]
  "Squared euclidian distance between two points."
  (defn square [x] (* x x))
  (defn difference [[x y]] (- y x))
  (defn sum [x] (reduce + x))
  (def zipped (map vector p1 p2)) ; zip: (x1 x2) (y1 y2) => ([x1 x2] [y1 y2])
  (sum (map square (map difference zipped))))

(defn whatShouldIDo? [creep energyPosition controllerPosition]
  (def pos (creep :xy-position))
  (if (full creep) "harvest"
    (if (< (dist**2 pos energyPosition) (dist**2 pos controllerPosition)) "harvest"
      "deposit"))) ; else

(defn harvest [creep energyPosition moveFn harvestFn] nil)

(defn deposit [creeo controllerPosition moveFn depositFn] nil)


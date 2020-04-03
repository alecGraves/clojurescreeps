;
; Wraps common JS math functions
;
;
(ns clojurescreeps.math)

(defn abs [x] (.abs js/Math x))
(defn sqrt [x] (.sqrt js/Math x))
(defn square [x] (* x x))
(defn sum [x] (reduce + x))

(defn dist**2 [p1 p2]
  "Squared euclidian distance between two points."
  (+ (square (- (first p1) (first p2)))
     (square (- (second p1) (second p2)))))

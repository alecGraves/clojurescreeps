;
; Wraps common JS math functions
;
;
(ns clojurescreeps.math)

(defn abs [x] (.abs js/Math x))
(defn sqrt [x] (.sqrt js/Math x))
(defn squared [x] x*x)
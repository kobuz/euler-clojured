(ns euler-clojured.problem-5
  (:require [clojure.math.numeric-tower :as math]))

(defn lcm
  "Least common multiple."
  [a b]
  (/ (* a b) (math/gcd a b)))

(defn smallest-number-divisable
  "Return smallest number divisable by everything up to n."
  [n]
  (reduce lcm (range 1 (inc n))))

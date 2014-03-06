(ns euler-clojured.problem-5
  (:require [clojure.math.numeric-tower :as math]))

(defn smallest-number-divisable
  "Return smallest number divisable by everything up to n."
  [n]
  (reduce math/lcm (range 1 (inc n))))

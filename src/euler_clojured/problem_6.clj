(ns euler-clojured.problem-6
  (:require [clojure.math.numeric-tower :as math]))

(defn square [n] (* n n))

(defn sum-of-squares
  "Sum of squares up to n."
  [n]
  (reduce + (map square (range 1 (inc n)))))

(defn square-of-sums
  "Square of sum up to n."
  [n]
  (square (apply + (range 1 (inc n)))))

(defn task
  "One minus the other."
  [n]
  (math/abs (- (sum-of-squares n) (square-of-sums n))))

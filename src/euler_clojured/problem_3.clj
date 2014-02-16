(ns euler-clojured.problem-3
  (:require [clojure.set :refer [union]]
            [clojure.math.numeric-tower :as math]))

(defn divides?
  "Return whether k divides n."
  [k n]
  (zero? (rem n k)))

(defn get-multiples
  "Get multiples of k up to n."
  [k n]
  (take-while (fn [x] (< x n)) (iterate (partial + k) k)))

(defn generate-primes
  "Generate prime numbers up to n."
  [n]
  ; start from 3 and increment by 2
  (loop [candi 3
         primes (sorted-set 2)
         rejected #{}]
    (if (< candi n)
      (if (rejected candi)
        (recur (+ candi 2) primes rejected)
        (recur (+ candi 2) (conj primes candi) 
            (union rejected (into #{} (get-multiples candi n)))))
      primes)))

(defn largest-prime-factor
  "Return largest prime factor of n."
  [n]
  (let [sqrt (math/sqrt n)
        primes (generate-primes sqrt)]
    (apply max (filter (fn [k] (divides? k n)) primes))))

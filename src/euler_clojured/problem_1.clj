(ns euler-clojured.problem-1)

(defn mul-of-any?
  "Check if n is multiple of any of the items."
  [items n]
  (some (fn [x] (zero? (rem n x))) items))

(defn sum-of-muls
  "Return sum of 3 and 5 multiples up to n (excluding n)."
  [n]
  (let [mul? (partial mul-of-any? [3 5])]
    (reduce + (filter mul? (range n)))))

(ns euler-clojured.problem-2)

(defn fibs-under
  "Return fibonacci number sequence with values under n."
  [n]
  (loop [first 0
         second 1
         fibs (list 1 0)]
    (let [third (+ first second)]
      (if (< third n)
        (recur second third (conj fibs third))
        fibs))))

(defn sum-of-even-fibs-under
  "Return sum of even fibonacci number under value of n."
  [n]
  (reduce + (filter even? (fibs-under n))))

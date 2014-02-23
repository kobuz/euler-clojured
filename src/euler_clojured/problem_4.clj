(ns euler-clojured.problem-4)

(defn split-to-digits
  "Split a number to a list of it's digits."
  [n]
  (loop [k n
         digits ()]
    (if (zero? k)
      digits
      (recur (quot k 10) (conj digits (rem k 10))))))

(defn palindrome?
  "Decides whether an input is palindrome."
  [n]
  (let [digits (split-to-digits n)
        len (/ (count digits) 2)]
    (= (take len digits) (take len (reverse digits)))))

(defn product-of-three-digit-numbers
  "Return a list of products of 3-digits numbers."
  []
  (for [x (range 100 1000)
        y (range x 1000)]
    (* x y)))

(defn biggest-palindrome
  "Find the biggest palindrome from the product of two 3-digits numbers."
  []
  (apply max (filter palindrome? (product-of-three-digit-numbers))))
    

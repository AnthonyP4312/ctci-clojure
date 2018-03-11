(ns ctci.ch1.1-4-palperm
  (:require [ctci.core :refer [my-freq]]))

(defn palperm0? 
  "Determine wether a string is a permuation of a palindrome"
  [s]
  (>= 1 (count (filter odd? (vals (my-freq s))))))

(defn palperm1?
  "Avoid unnecesary work
  No observable difference in time!
  This is because the part where we check
  for odd characters is a constant where x
  is the number of possible characters in
  any given string"
  [s]
  (let [freq (vals (my-freq s))]
    (loop [counter 0 
           coll freq]
      (if (< 1 counter)
        false
        (if (empty? coll)
          true
          (if (odd? (first coll))
            (recur (inc counter) (rest coll))
            (recur counter (rest coll))))))))

(ns ctci.ch1.1-5-one-away)

(declare replace? insert?)

(defn one-away0?
  "There are three types of edits than can be performed on strings:
  insert char, remove char, or replace char. Given two strings write a
  function to check if they are one or zero edits away"
  [a b]
  (if (= a b)
    true
    (let [diff (Math/abs (- (count a) (count b)))]
      (cond 
        (= 0 diff) (replace? a b)
        (= 1 diff) (insert? a b)
        :else false))))
 
(defn replace?
  "Determines if a replace operation would cause strings to match"
  [a b]
  (loop [a a
         b b 
         i 0
         diff 0]
    (if (> diff 1)
      false
      (if (get a i)
        (if (= (get a i) (get b i))
          (recur a b (inc i) diff)
          (recur a b (inc i) (inc diff)))
        true))))

(defn insert?
  "Determines if an insert would cause strings to match"
  [a b]
  (if (< (count a) (count b))
    (recur b a)
    (loop [longer a
           shorter b 
           diff 0]
      (if (> diff 1)
        false
        (if (first shorter)
          (if (= (first shorter) (first longer))
            (recur (rest longer) (rest shorter) diff)
            (recur (rest longer) shorter (inc diff)))
          true)))))

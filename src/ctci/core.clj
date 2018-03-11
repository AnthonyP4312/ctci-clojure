(ns ctci.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn my-freq
  ([coll] (my-freq coll {}))
  ([coll acc]
   (if-let [head (first coll)]
     (if-let [count (get acc head)]
       (recur (rest coll) (assoc acc head (inc count)))
       (recur (rest coll) (assoc acc head 1)))
     acc)))

(defn my-merge
  [coll]
  (if (or (empty? coll) (= 1 (count coll)))
    coll
    (let [[a b] (split-at (/ (count coll) 2) coll)]
      (loop [sorted []
             a      (my-merge a)
             b      (my-merge b)]
        (cond (empty? a) (into sorted b)
              (empty? b) (into sorted a)
              :else      (if (> 0 (compare (first a) (first b)))
                           (recur (conj sorted (first a)) (rest a) b)
                           (recur (conj sorted (first b)) a (rest b))))))))

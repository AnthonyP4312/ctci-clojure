(ns ctci.ch1.1-6-compress)

(defn compress0
  [coll]
  (let [new-string (loop [coll coll
                          new-string ""]
                     (if (not (empty? coll))
                       (let [[match others] (split-with #(= % (first coll)) coll)]
                         (recur others (str new-string (first coll) (count match))))
                       new-string))]
    (if (< (count new-string) (count coll))
      new-string
      coll)))

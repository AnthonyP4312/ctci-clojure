(ns ctci.ch1.1-8-zero.clj)

(def matrix [[3 3 3]
             [0 1 1]
             [2 2 2]])


(defn run-zero
  "makes the zeros"
  [matrix row col]
  (map matrix (fn [row]
                ))
  
  )

(defn check-zero
  "finds the zeros"
  [matrix]
  (let [n (dec (count (get matrix 0)))]
    (for [row matrix]
      ())))



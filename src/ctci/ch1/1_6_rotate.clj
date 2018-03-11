(ns ctci.ch1.1-6-rotate)

(def matrix [[0 0 0]
             [1 1 1]
             [2 2 2]])
(def matrix-2 [[0 1 2]
               [3 4 5]
               [6 7 8]])


(defn rotate-matrix
  [read-matrix]
  (let [n (dec (count read-matrix))]
    (loop [row 0
           matrix read-matrix]
      (if (> row n)
        matrix
        (recur (inc row) 
               (loop [col 0
                      matrix matrix]
                 (if (> col n)
                   matrix
                   (recur (inc col) 
                          (assoc-in matrix [(- n row) col] 
                                    (get-in read-matrix [col row]))))))))))

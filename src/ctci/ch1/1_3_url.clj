(ns ctci.ch1.1_3_url)

(defn url0
  "This is supposed to be solved in-place
  Since we have immutable data structures
  we literally cant, so rip"
  [coll]
  (apply str (map (fn [ch]
                    (if (= ch \space)
                      "%20"
                      ch))
                  coll)))


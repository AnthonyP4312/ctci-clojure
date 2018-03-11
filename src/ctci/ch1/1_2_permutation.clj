(ns ctci.ch1.1-2-permutation
  (:require [ctci.core :refer [my-freq my-merge]]))

(defn perm0?
  "Bucket sort strings and compare"
  [a b]
  (= (my-freq a) (my-freq b)))

(defn perm1?
  "Merge sort strings and compare
  theoretically could be done without outside
  data structures"
  [a b]
  (= (my-merge a) (my-merge b)))




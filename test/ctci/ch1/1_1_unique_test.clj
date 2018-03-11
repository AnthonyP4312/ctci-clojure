(ns ctci.ch1.1-1-unique-test
  (:use clojure.test)
  (:require [ctci.ch1.1-1-unique :as unit]))

(deftest unique-str
  (is (unit/unique0? unit/x))
  ;; (is (unit/unique1? unit/x))
  (is (unit/unique2? unit/x))
  (is (unit/unique3? unit/x))
  (is (unit/unique4? unit/x))
)

(deftest not-unique-str
  (do
    (is (not (unit/unique0? unit/y)))
    ;; (is (unit/unique1? unit/y))
    (is (not (unit/unique2? unit/y)))
    (is (not (unit/unique3? unit/y)))
    (is (not (unit/unique4? unit/y)))))


  

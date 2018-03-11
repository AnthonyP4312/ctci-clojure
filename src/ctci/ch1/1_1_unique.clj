rmu(ns ctci.ch1.1-1-unique
  (:require [clojure.string :as s]))

(def x (str "qwertyuiopasdfghjklzxcvbnm,.;'[]=-0987654321!@#$%^&*()_+QWERTYUIOPASDFGHJKL{:?><MNBVCXZ"))
(def t (apply str (repeat 1000000 "abcdf")))
(def y (apply str (repeat 1000 x)))

(defn unique0?
  "This doesn't check until its gone thorough the whole list"
  [str]
  (let [chars (frequencies str)]
    (every? #(<= % 1) (vals chars))))

(defn unique1?
  "Doesnt actually work! For doesnt have a native index and im not making my own lol"
  [str]
  (every? 
   false?
   (flatten
    (for [i str]
      (for [j str]
        [i j])))))

(defn unique2?
  ([str] (unique2? str (count str) 0 0))
  ([str length i j]
   (if-not (= i j)
     (if (> j length)
       (recur str length (inc i) 0)
       (if (> i length)
         true
         (if (= (get str i) (get str j))
           false
           (recur str length i (inc j)))))
     (recur str length i (inc j)))))

(defn unique3?
  "This ones the best I guess"
  ([str] (unique3? str {} 0))
  ([str my-map i]
   (if (< i (count str))
     (if (get my-map (get str i))
       false
       (recur str (assoc my-map (get str i) true) (inc i)))
     true)))

(defn unique4?
  "I was wrong this is the best"
  ([str] (unique4? str 0 1))
  ([str i j] 
   (if (> i (count str))
     true
     (if (> j (count str))
       (recur str (inc i) (+ i 2))
       (if (= (get str i) (get str j))
         false
         (recur str i (inc j)))))))

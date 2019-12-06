(ns exercises.adventofcode.io
  (:require [clojure.string :as str]))

(defn day-file [day] (str "src/exercises/adventofcode/d" day ".txt"))

(defn- slurp-file [file-name]
  (as-> file-name it
        (slurp it)))

(defn- split-by-line-return [str]
  (str/split str #"\n"))

(defn- split-by-comma [str]
  (str/split str #","))

(defn- parse-str-to-int [str]
  (Integer/parseInt (re-find #"\d+" str)))


; Day 1
(defn day-1-input-from-file [file-name]
  "Day 1"
  (as-> file-name it
        (slurp-file it)
        (split-by-line-return it)
        (into [] it)))

; Day 2
(defn day-2-input-from-file [file-name]
  "Day 2"
  (as-> file-name it
        (slurp-file it)
        (split-by-comma it)
        (map parse-str-to-int it)
        (into [] it)))

; Day 3
(defn- parse [input]
  {:direction (first input)
   :amount    (parse-str-to-int input)})

(defn- parse-wire [wire]
  (map parse wire))

(defn day-3-input-from-file [file-name]
  "Day 3"
  (as-> file-name it
        (slurp-file it)
        (split-by-line-return it)
        (map split-by-comma it)
        (map parse-wire it)
        (into [] it)))

(defn day-3-input-from-code [str-list-1, str-list-2]
  (let [parse-input (fn [input] (map parse (split-by-comma input)))]
    [(parse-input str-list-1)
     (parse-input str-list-2)]))
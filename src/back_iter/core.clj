(ns back-iter.core
  (:require [back-iter.tree :as tree]))

(defprotocol BackIter
  (start* [this tree]) ; Starts iter
  (step [iter]) ; step returns (val x iter)
)

(declare inorder-left)

; Inorder traversal
(defrecord InorderBackIter [current current-right rest-iterator]
  BackIter
  (start* [_ tree]
    (inorder-left tree nil))

  (step [iter]
    (let [ { :keys [current current-right rest-iterator] } iter]
      [ current (inorder-left current-right rest-iterator)])))

(defn inorder-start [tree] (inorder-left tree nil))

(defn inorder-left [tree iterator]
  (if (nil? tree)
    iterator
    (let [{ :keys [value left right] } tree]
      (recur left (InorderBackIter. value right iterator)))))


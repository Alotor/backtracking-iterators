(ns back-iter.core-spec
  (:require
    [speclj.core :refer :all]
    [back-iter.tree :as tree]
    [back-iter.core :refer :all]))

(def normal-tree
  (->
    (tree/tree-make 1)
    (tree/tree-add 2)
    (tree/tree-add 3)
    (tree/tree-add 4)
    (tree/tree-add 5)
  ))

(def reversed-tree
  (->
    (tree/tree-make 5)
    (tree/tree-add 4)
    (tree/tree-add 3)
    (tree/tree-add 2)
    (tree/tree-add 1)
  ))

(def random-tree
  (->
    (tree/tree-make 3)
    (tree/tree-add 1)
    (tree/tree-add 5)
    (tree/tree-add 2)
    (tree/tree-add 4)
  ))

(describe "Inorder"
  (it "Check inorder - normal tree"
    (let [step1 (step (inorder-start normal-tree))
          step2 (step (second step1))
          step3 (step (second step2))
          step4 (step (second step3))
          step5 (step (second step4))]
      (should= 1 (first step1))
      (should= 2 (first step2))
      (should= 3 (first step3))
      (should= 4 (first step4))
      (should= 5 (first step5))
      (should= nil (second step5))))

  (it "Check inorder - reversed tree"
    (let [step1 (step (inorder-start reversed-tree))
          step2 (step (second step1))
          step3 (step (second step2))
          step4 (step (second step3))
          step5 (step (second step4))]
      (should= 1 (first step1))
      (should= 2 (first step2))
      (should= 3 (first step3))
      (should= 4 (first step4))
      (should= 5 (first step5))
      (should= nil (second step5))))

  (it "Check inorder - random tree"
    (let [step1 (step (inorder-start random-tree))
          step2 (step (second step1))
          step3 (step (second step2))
          step4 (step (second step3))
          step5 (step (second step4))]
      (should= 1 (first step1))
      (should= 2 (first step2))
      (should= 3 (first step3))
      (should= 4 (first step4))
      (should= 5 (first step5))
      (should= nil (second step5))))
)

(run-specs)

(ns back-iter.tree)

(defn tree-make [root] {:value root, :left nil, :right nil})
(defn tree-add [tree toInsert]
  (if (nil? tree)
    (tree-make toInsert)
    (let [{ value :value left :left right :right } tree]
      (cond
        (< toInsert value)
          { :value value,
            :left (tree-add left toInsert)
            :right right }
        (> toInsert value)
          { :value value,
            :left left
            :right (tree-add right toInsert) }
        :else tree))
  ))

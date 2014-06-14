(defproject backtracking-iterators "0.1.0-SNAPSHOT"
  :description "Clojure implementation of persistent cursors paper"
  :url "http://www.github.com/alotor"
  :license { :name "Apache License 2.0" :url "http://www.apache.org/licenses/LICENSE-2.0.txt"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :profiles {:dev {:dependencies [[speclj "2.9.0"]]}}
  :plugins [[speclj "2.9.0"]]
  :test-paths ["spec"]
)

(set-env!
 :source-paths #{"src/cljs"}
 :resource-paths #{"html"}

 :dependencies '[[adzerk/boot-cljs "2.1.5"]
                 [adzerk/boot-reload "0.6.1"]
                 [pandeiro/boot-http "0.8.3" :exclusions [org.clojure/clojure]]

                 [adzerk/boot-cljs-repl "0.4.0"]
                 [cider/piggieback "0.5.2"]
                 [weasel "0.7.1" :exclusions [org.clojure/clojure]]

                 [reagent "1.1.0"]
                 [cljsjs/react "17.0.2-0"]
                 [cljsjs/react-dom "17.0.2-0"]

                 ;; [org.clojure/clojure "1.10.3"]
                 [org.clojure/clojurescript "1.10.879"]
                 [org.clojure/tools.nrepl "0.2.13"]])

;; custom tasks
(require '[adzerk.boot-cljs :refer [cljs]]
         '[pandeiro.boot-http :refer [serve]]
         '[adzerk.boot-reload :refer [reload]]
         '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]])

;; define dev task as composition of subtasks
(deftask dev
  "Launch Immediate Feedback Development Environment"
  []
  (comp
   (serve :dir "target")
   (watch)
   (reload)
   (cljs-repl) ;; before cljs task
   (cljs)
   (target :dir #{"target"})))

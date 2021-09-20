(ns reagent-boot.core
  (:require [reagent.dom :as dom]))

(defn simple-component
  []
  [:div
   [:p "I am a component!"]
   [:p.someclass
    "I have " [:strong "bold"]
    [:span {:style {:color "red"}} " and red "] "text."]])

(defn ^:export init
  []
  (.log js/console "Hello from ClojureScript!")
  (dom/render [simple-component]
              (.getElementById js/document "app")))

(ns sleepy.service
  (:require [io.pedestal.http :as bootstrap]
            [io.pedestal.http.route.definition :refer [defroutes]]
            [io.pedestal.interceptor :refer [defbefore]]
            [io.pedestal.log :as log]
            [ring.util.response :as ring-resp]))


(defbefore inspect
  [context]
  (log/info :context context))

(def counter (atom 0))

(defn sleepy
  [request]
  (let [num (swap! counter inc)]
    (log/info :msg (format "Request %s: %s. Sleeping..."   num (:query-string request)))
    (Thread/sleep (* 1000 120))
    (log/info :msg (format "Request %s: %s. Responding..." num (:query-string request)))
    (ring-resp/response "Hi there.")))

(defroutes routes
  [[["/"         {:get sleepy}
     ["/inspect" {:get inspect}]]]])

(def service {:env :prod
              ::bootstrap/routes routes
              ::bootstrap/resource-path "/public"
              ::bootstrap/type :jetty
              ::bootstrap/port 8080})

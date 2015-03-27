(ns sleepy.server
  (:require [sleepy.service :as service]
            [io.pedestal.http :as server]))

(defonce runnable-service (server/create-server service/service))

(defn run-dev
  [& args]
  (println "\nCreating your [DEV] server...")
  (-> service/service
      (merge {:env :dev
              ::server/join? false
              ::server/routes #(deref #'service/routes)})
      server/default-interceptors
      server/dev-interceptors
      server/create-server
      server/start))

(defn -main
  [& args]
  (println "\nCreating your server...")
  (server/start runnable-service))


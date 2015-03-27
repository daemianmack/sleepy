(set-env!
 :source-paths #{"src" "dev"}
 :resource-paths #{"config"}
 :dependencies '[[org.clojure/clojure "1.7.0-alpha4"]
                 [io.pedestal/pedestal.service "0.3.1"]
                 [io.pedestal/pedestal.jetty "0.3.1"]

                 [ch.qos.logback/logback-classic "1.1.2" :exclusions [org.slf4j/slf4j-api]]
                 [org.slf4j/jul-to-slf4j "1.7.7"]
                 [org.slf4j/jcl-over-slf4j "1.7.7"]
                 [org.slf4j/log4j-over-slf4j "1.7.7"]])


(require '[sleepy.server :as server])


(deftask go [] (server/run-dev))

# sleepy

A tiny utility Pedestal service to simulate slow webservers.

## Getting Started

1. Start the application:
```
export BOOT_JVM_OPTIONS="-client -XX:+TieredCompilation -XX:TieredStopAtLevel=1 -Xmx2g -XX:MaxPermSize=128m -XX:+UseConcMarkSweepGC -XX:+CMSClassUnloadingEnabled -Xverify:none"
boot go wait
```
Or use lein, but boot loads fast enough that I haven't bothered following the 'Reloaded' pattern here...
```
lein run-dev
```
2. Request [localhost:8080](http://localhost:8080/) to enjoy a slow webserver.

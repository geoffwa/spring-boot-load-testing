# Simple Spring Boot performance testing simulator

## Getting Started

```shell
$ mvn spring-boot:run
# (in another terminal)
$ mvn gatling:test
$ open target/gatling/performancesimulation-*/index.html
```

## Observations

The endpoint `/io` _simulates_ IO by sleeping for an interval between 200 and 700ms. If you see requests taking longer than 700ms to fulfil, then there's a bottleneck somewhere.

1. Check `ulimit -n`, the number of file descriptiors your process can have open at a time.  Number of file descriptors == number of connections, for both the server and the performance test.
2. Change `server.tomcat.max-threads` in application.properties.  By default Spring Boot uses an embedded Tomcat server, and the default maximum threads if not set is 200.

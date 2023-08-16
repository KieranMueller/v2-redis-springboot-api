# v2-redis-springboot-api
Caching with Redis and Spring Boot

# Redis
Redis stands for Remote Dictionary Server. It is used as a distributed, 
in-memory key–value database, cache and message broker

# Steps
- install Redis, Windows currently unsupported, can either use Windows Subsystem for Linux, or this Windows adaption https://github.com/tporadowski/redis/releases
- run 'redis-server' to start server on default port: 6379
- open new terminal, run 'redis-cli'
- run command 'ping' to test connection, should receive response 'pong'
- configure database settings in application properties, alter maven dependencies as needed
- run project and postman collection
- implemented 2 second delay to GET all request to clearly present functionality of Redis cache in action, time to live is 60 mins
  - this means: if you experience a 2 second delay in the GET all request, it was a 'cache miss', this will occur when
    -  the data is being accessed for the first time and the cache needs to be filled/hydrated
    -   the data has been altered (PUT, POST, DELETE) since the cache was last accessed or 'hit'
    -   the time to live expired (60 mins)
- take note of response time between cache misses and cache hits
- take note of logger - logging calls to DB
- run multiple instances of application simultaneously and send requests to see cache in action across the board

# TODO
- implement failsafe, ensure application bypasses cache if server is down etc. and hits DB, set max time to try hitting cache, or if response is null, bypass

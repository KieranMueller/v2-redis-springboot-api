# v2-redis-springboot-api
Caching with Redis and Spring Boot

# steps
- install redis, Windows currently unsupported, can either use Windows Subsystem for Linux, or this Windows adaption https://github.com/tporadowski/redis/releases
- run 'redis-server' to start server on default port: 6379
- open new terminal, run 'redis-cli'
- run command 'ping' to test connection, should receive response 'pong'
- configure database settings in application properties, alter maven dependencies as needed
- run project and postman collection
- wrote a 3 second delay to GET all request to clearly present the functionality of the Redis cache in action, time to live is one hour
- run multiple instances of application simultaneously and send requests to see cache in action across the board


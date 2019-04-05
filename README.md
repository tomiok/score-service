Score service 
===========================================================================================================================

## Compile and run

With the maven wrapper:

1) `./mvnw clean verify`
2) `./mvnw spring-boot:run`

With docker

1) `docker build -t score-service .`
2) `docker run -p 8080:8080 score-service`
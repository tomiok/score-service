Score service 
===========================================================================================================================

## POC Highlights

You need [mongodb](https://www.mongodb.com) installed locally, using the database `score-service-local`. Otherwise you can setting up for free a mongo instance with [mlab](https://mlab.com) and change the application.yml settings according. Finally, 
for another alternative, you can run a docker image for mongo, running this commands:

```
mkdir ~/data
docker run -d -p 27017:27017 -v ~/data:/data/db mongo
```

You may see the spring-boot context test ignored, you can compile without errors but you cannot run the app.

# Compile & Run

With the maven wrapper:

1) `./mvnw clean verify`
2) `./mvnw spring-boot:run`

With docker

1) `docker build -t score-service .`
2) `docker run -p 8080:8080 score-service`

# cURLs for test

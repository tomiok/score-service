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

### Save
```
curl -X POST \
  http://localhost:8080/scores \
  -H 'Content-Type: application/json' \
  -H 'cache-control: no-cache' \
  -d '{
"comment":	"Nice burgers!",
"points":	5,
"saleIdentifier":	"someUUIDhere",
"storeIdentifier":	"storeUUIDhere",
"userIdentifier":	"userUUIDhere"
}'
```

### Delete (with score id = 5ca6e6c448d346195e0895da)

```
curl -X DELETE \
  http://localhost:8080/scores/5ca6e6c448d346195e0895da \
  -H 'cache-control: no-cache'
```

### Get by sale identifier (someUUIDhere)

```
curl -X GET \
  'http://localhost:8080/scores?saleIdentifier=someUUIDhere' \
  -H 'cache-control: no-cache'
```

### Find by user and date range

```
curl -X GET \
  'http://localhost:8080/scores?storeIdentifier=storeUUIDhere&timeFrom=0&timeTo=1554442585877' \
  -H 'cache-control: no-cache'
```

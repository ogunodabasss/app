#docker build -t --tag app_backend:latest .


docker or Manuel
----------------------------------------
docker-compose up --build -d

docker compose down --rmi all
----------------------------------------
docker example env...
--------------------------------------------
POSTGRESDB_USER= postgres
POSTGRESDB_ROOT_PASSWORD= custom password
POSTGRESDB_DATABASE= custom db name

GOOGLE_API_KEY=
GOOGLE_API_JS_KEY=
---------------------------------------------

GCP Enable  Nearby Search "GOOGLE_API_KEY" 
https://developers.google.com/maps/documentation/places/web-service/search-nearby?hl=tr

GCP Enable  JS Api "GOOGLE_API_JS_KEY" 



-----------------------------------------------

backend: localhost:8070
GET: 
http://localhost:8070/?longitude=38.810009&latitude=41.006277&radius=50

----------------------------
frontend: localhost:4200
---------------------------------------
Manuel gradle 8.5 and Min Java17 required

gradle clean build bootrun
gradle build --warning-mode all
gradle bootrun

gradle -v global settings
Project Gradle version Change  'distributionUrl' 
https://github.com/ogunodabasss/app/blob/main/backend/gradle/wrapper/gradle-wrapper.properties
----------------------------------------



-----------------------------------------------
- Project Detail 

Backend
Java21 + Spring Boot 3.2 + Gradle 8.5 Kotlin DSL

Frontend
Angular 17 + Vite

+ Docker
-----------------------------------------------

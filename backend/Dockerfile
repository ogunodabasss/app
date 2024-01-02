# syntax=docker/dockerfile:1

FROM eclipse-temurin:21-jdk-jammy
WORKDIR /backend

CMD ["./gradlew", "clean","build", "bootJar"]
COPY src ./src
COPY build/libs/*.jar ./backend-0.0.1-SNAPSHOT.jar

EXPOSE 8070
ENTRYPOINT ["java","-XX:TieredStopAtLevel=1","-Dfile.encoding=UTF-8","-Duser.country=US","-Duser.language=en","-jar","./backend-0.0.1-SNAPSHOT.jar"]
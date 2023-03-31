#Build stage
FROM gradle:7.6.1-alpine AS BUILD
WORKDIR /usr/app/
COPY . .
RUN ./gradlew build -x test

# Package stage
FROM openjdk:17-alpine3.14
ENV JAR_NAME=backend-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY --from=BUILD $APP_HOME .
EXPOSE 8080
ENTRYPOINT exec java -jar $APP_HOME/build/libs/$JAR_NAME
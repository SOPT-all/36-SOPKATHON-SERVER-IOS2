FROM gradle:8.7.0-jdk21 AS build
WORKDIR /app/kaswhy

COPY . .
RUN ls -al
RUN chmod +x gradlew
RUN ./gradlew build -x test

RUN cp $(ls /app/kaswhy/build/libs/*.jar | head -n 1) /app/kaswhy/build/libs/app.jar

FROM openjdk:21-jdk-slim
WORKDIR /app

COPY --from=build /app/kaswhy/build/libs/app.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

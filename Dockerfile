FROM openjdk:15.0.2-jdk-slim-buster
COPY ./build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

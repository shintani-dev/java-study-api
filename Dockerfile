FROM openjdk:15.0.2-jdk-slim-buster AS builder
ADD . /app
WORKDIR /app
RUN ./gradlew build -x test --parallel --max-workers=3

FROM openjdk:15.0.2-jdk-slim-buster
COPY --from=builder /app/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]

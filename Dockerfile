FROM adoptopenjdk:8-jdk-hotspot AS builder
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew bootwar

FROM adoptopenjdk:8-jdk-hotspot
COPY --from=builder build/libs/*.war app.war

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.war"]
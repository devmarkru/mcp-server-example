# Build stage
FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /app
COPY . /app
RUN ./gradlew build --no-daemon

# Package stage
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app
COPY --from=build /app/build/libs /app

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "mcp-server.jar"]

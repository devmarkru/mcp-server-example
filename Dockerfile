# Build stage
FROM gradle:jdk21 AS build
WORKDIR /app
COPY . /app
RUN gradle build --no-daemon

# Package stage
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app
COPY --from=build /app/build/libs /app

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "mcp-server.jar"]

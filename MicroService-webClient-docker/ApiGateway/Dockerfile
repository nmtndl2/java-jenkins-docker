FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/ApiGateway-0.0.1-SNAPSHOT.jar  ApiGateway-0.0.1-SNAPSHOT.jar

EXPOSE 8000

ENTRYPOINT ["java", "-jar", "ApiGateway-0.0.1-SNAPSHOT.jar"]
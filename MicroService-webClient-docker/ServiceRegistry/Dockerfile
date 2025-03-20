FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/ServiceRegistry-0.0.1-SNAPSHOT.jar  ServiceRegistry-0.0.1-SNAPSHOT.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "ServiceRegistry-0.0.1-SNAPSHOT.jar"]
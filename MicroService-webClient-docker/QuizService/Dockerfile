FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/QuizService-0.0.1-SNAPSHOT.jar  QuizService-0.0.1-SNAPSHOT.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "QuizService-0.0.1-SNAPSHOT.jar"]


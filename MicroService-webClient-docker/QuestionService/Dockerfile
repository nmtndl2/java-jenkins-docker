FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/QuestionService-0.0.1-SNAPSHOT.jar  QuestionService-0.0.1-SNAPSHOT.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "QuestionService-0.0.1-SNAPSHOT.jar"]
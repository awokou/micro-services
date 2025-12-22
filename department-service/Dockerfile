FROM openjdk:21-jdk-alpine
WORKDIR /app
COPY target/department-service-0.0.1-SNAPSHOT.jar department-service.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "department-service.jar"]
FROM openjdk:21-jdk-alpine
WORKDIR /app
COPY target/employee-service-0.0.1-SNAPSHOT.jar employee-service.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "employee-service.jar"]
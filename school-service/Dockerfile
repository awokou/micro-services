FROM openjdk:21-jdk-alpine
WORKDIR /app
COPY target/school-service-0.0.1-SNAPSHOT.jar school-service.jar
EXPOSE 8070
ENTRYPOINT ["java", "-jar", "school-service.jar"]
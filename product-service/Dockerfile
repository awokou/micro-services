FROM openjdk:21-jdk-alpine
WORKDIR /app
COPY target/product-service-0.0.1-SNAPSHOT.jar product-service.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "product-service.jar"]
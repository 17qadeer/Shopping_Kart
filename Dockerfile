FROM openjdk:17-alpine
COPY target/app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]

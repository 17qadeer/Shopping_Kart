FROM openjdk:17-alpine
COPY target/app.jar shopping_kart
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]

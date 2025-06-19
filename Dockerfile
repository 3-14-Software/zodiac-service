FROM eclipse-temurin:21-jre
COPY target/zodiac-service-*.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

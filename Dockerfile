FROM openjdk:11-jre-slim
WORKDIR /box2
COPY target/box-1.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

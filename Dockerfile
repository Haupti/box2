FROM openjdk:11-jre-slim
WORKDIR /box2
ADD target/box-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

FROM openjdk:17

WORKDIR /app

# Copy the Spring Boot JAR file into the container
#in order to get this jar file run mvn clean package in terminal or in  edit config enter clean package
COPY target/Booksmongodb-0.0.1-SNAPSHOT.jar      /app/Booksmongodb-0.0.1-SNAPSHOT.jar

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/Booksmongodb-0.0.1-SNAPSHOT.jar"]



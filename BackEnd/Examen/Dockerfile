# Use the oficial jdk image
FROM openjdk:17-jdk-alpine

# Copy the JAR file into the container
COPY target/Examen-0.0.1-SNAPSHOT.jar To-DoV1.jar

# Expose port 8080
EXPOSE 8080

# Define the entry point to run your application
ENTRYPOINT ["java", "-jar", "To-DoV1.jar"]
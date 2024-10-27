# Use a lightweight JDK 17 image
FROM azul/zulu-openjdk:17

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/crud-app-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that the app runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

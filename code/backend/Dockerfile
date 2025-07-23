# Use an official OpenJDK image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy all files (including hidden ones)
COPY . /app

# Make mvnw executable
RUN apt-get update && apt-get install -y dos2unix && dos2unix mvnw && chmod +x mvnw

# Debug: list files before build
RUN ls -l /app && ls -l /app/.mvn/wrapper

# Build the project
RUN ./mvnw clean package

# Expose the port your app runs on (change if needed)
EXPOSE 8080

# Run the jar
CMD ["java", "-jar", "target/cloudstore-backend-0.0.1-SNAPSHOT.jar"]

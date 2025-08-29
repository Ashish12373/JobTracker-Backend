# Step 1: Use Maven with Java 21
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source and build
COPY src ./src
RUN mvn clean package -DskipTests

# Step 2: Lightweight JDK 21 for running the app
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

# Copy built jar
COPY --from=build /app/target/*.jar app.jar

# Expose port
EXPOSE 8080

# Run app
ENTRYPOINT ["java", "-jar", "app.jar"]

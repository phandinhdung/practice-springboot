# Use an official OpenJDK runtime as a parent image
FROM --platform=amd64 openjdk:17.0.2-oraclelinux8

LABEL authors="phandinhdung"

# Set the working directory in the container
WORKDIR /app

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Expose the port your application will run on
EXPOSE 8081

# Specify the command to run your application when the container starts
CMD ["java", "-jar", "app.jar"]
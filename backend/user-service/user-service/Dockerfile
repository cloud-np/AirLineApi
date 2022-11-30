# Fetching latest version of Java
FROM openjdk:19

# Setting up work directory
WORKDIR /app

ADD target/spring-boot-docker.jar spring-boot-docker.jar

# Copy the jar file into our app
COPY ./target/spring-0.0.1-SNAPSHOT.jar /app

# Exposing port 9002
EXPOSE 9002

# Starting the application
CMD ["java", "-jar", "/spring-boot-docker.jar"]
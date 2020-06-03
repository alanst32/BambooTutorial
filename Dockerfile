

# Tutorial - https://stackabuse.com/dockerizing-a-spring-boot-application/
#FROM java:8-jdk-alpine
## Thats is the name of the Jar according to the build.gradle
## This tells Docker to copy files from the local file-system to a specific folder inside the build image.
## Here, we copy our .jar file to the build image (Linux image) inside /usr/app.
#COPY ./build/libs/masterchef-0.0.1-SNAPSHOT.jar /usr/app/
## The WORKDIR instruction sets the working directory for any RUN, CMD, ENTRYPOINT, COPY and ADD instructions that follow in the Dockerfile.
## Here we switched the workdir to /usr/app so as we don't have to write the long path again and again.
#WORKDIR /usr/app
## This tells Docker to execute a shell command-line within the target system.
## Here we practically just "touch" our file so that it has its modification time updated (Docker creates all container files in an "unmodified" state by default).
#RUN sh -c 'touch masterchef-0.0.1-SNAPSHOT.jar'
## This allows you to configure a container that will run as an executable. It's where you tell Docker how to run your application.
## We know we run our spring-boot app as java -jar <app-name>.jar, so we put it in an array.
#ENTRYPOINT ["java","-jar","masterchef-0.0.1-SNAPSHOT.jar"]


FROM openjdk:latest
MAINTAINER  Skoogle App <skoogleappr@email.com>
ARG JAR_FILE=skoogle-desktop-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} skoogle-desktop-0.0.1-SNAPSHOT.jar
RUN sh -c 'touch skoogle-desktop-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","skoogle-desktop-0.0.1-SNAPSHOT.jar"]
EXPOSE 9090
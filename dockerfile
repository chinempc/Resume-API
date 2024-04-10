#FROM eclipse-temurin:17-jre as builder
#WORKDIR application
#ARG JAR_FILE=build/libs/Resume-API-0.0.2-SNAPSHOT.jar
#COPY ${JAR_FILE} /application.jar
#RUN dir -s
#EXPOSE 8082

#ENTRYPOINT ["java", "-jar", "application.jar"]

#ENTRYPOINT ["./gradlew", "bootBuildImage", "--imageName=docker.io/library/chinempc/resume-api:0.0.3"]


FROM gradle:8.5.0-jdk17-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle clean
RUN gradle build --no-daemon

FROM openjdk:17-jdk-slim

EXPOSE 8080
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/spring-boot-application.jar
ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseContainerSupport", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/spring-boot-application.jar"]
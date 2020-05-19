FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

ARG SPRING_PROFILE

RUN echo ${SPRING_PROFILE}

ENTRYPOINT java -Dspring.profiles.active=${SPRING_PROFILE} -jar /app.jar


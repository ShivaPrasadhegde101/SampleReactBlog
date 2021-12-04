FROM openjdk:8-jdk-alpine
WORKDIR usr/src
COPY target/app1.jar ./
ENTRYPOINT ["java","-jar","app1.jar"]
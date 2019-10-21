FROM openjdk:8-jdk-alpine
MAINTAINER "oumq"<417585271@qq.com>
VOLUME /tmp
ADD springboot-0.0.1.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
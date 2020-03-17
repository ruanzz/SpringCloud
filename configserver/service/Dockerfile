FROM maven:3.6-alpine as BUILD

COPY src /usr/app/src
COPY pom.xml /usr/app

RUN mvn -f /usr/app/pom.xml clean package -Dmaven.test.skip=true

FROM openjdk:8-jdk-alpine

MAINTAINER ruanzz <rzz1995@live.com>

ENV LANG en_US.UTF-8
ENV LANGUAGE en_US:en
ENV LC_ALL en_US.UTF-8
ENV TZ=Asia/Shanghai

RUN mkdir /app

WORKDIR /app

COPY --from=BUILD /usr/app/target/sc-service-configserver-2.0.jar /app/configserver.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar","/app/configserver.jar"]

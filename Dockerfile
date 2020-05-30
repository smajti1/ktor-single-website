#https://ktor.io/quickstart/quickstart/docker.html
FROM openjdk:14-ea-8-jdk-alpine3.10

#RUN apk --update --no-cache add bash

WORKDIR /var/www

VOLUME ["/var/www"]

CMD java -jar ./my-application.jar && true

ARG JAVA_OPTS=" -server -Xms4g -Xmx4g -XX:+UseG1GC -XX:MaxGCPauseMillis=100 -XX:+UseStringDeduplication "

ENV JAVA_OTPS="${JAVA_OPTS}"

COPY ./build/libs/my-application.jar ./my-application.jar
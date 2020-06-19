FROM openjdk:8-jdk-alpine

LABEL maintainer="Raul Paulino <20461484+rfire12@users.noreply.github.com>"

VOLUME /tmp

EXPOSE 8080

COPY /build/libs/crud-0.0.1-SNAPSHOT.jar mi_app.jar

ENTRYPOINT ["java", "-jar", "mi_app.jar"]

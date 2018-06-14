FROM maven:3.5.3-jdk-8 AS build
COPY src /usr/app/src
COPY pom.xml /usr/app
RUN mvn -DskipTests -f /usr/app/pom.xml clean package

FROM gcr.io/distroless/java
MAINTAINER linux_china linux_china@hotmail.com

COPY --from=build /usr/app/target/mail-catcher-1.0.0-SNAPSHOT.jar /usr/app/mail-catcher-1.0.0-SNAPSHOT.jar

EXPOSE 1025
EXPOSE 1080

WORKDIR /usr/app

CMD ["mail-catcher-1.0.0-SNAPSHOT.jar"]

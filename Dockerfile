FROM java:8u66-jdk
MAINTAINER linux_china linux_china@hotmail.com

ADD target/mail-catcher-1.0.0-SNAPSHOT.jar /opt/mail-catcher-1.0.0-SNAPSHOT.jar

EXPOSE 1025
EXPOSE 1080

CMD java -jar /opt/mail-catcher-1.0.0-SNAPSHOT.jar
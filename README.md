Mail Catcher
==============================
MailCatcher runs a super simple SMTP server which catches any message sent to it to display in a web interface.

### Spring Boot package

mvn -DskipTests clean package sping-boot:repackage

### Docker Builder

* docker build -t linuxchina/mail-catcher .
* docker run -d -p 1080:1080 -p 1025:1024 linuxchina/mail-catcher

### Assembly to distribution

* mvn -DskipTests clean package assembly:assembly

### todo 

* websocket support: notify after mail received
* display email count on web
* Email detail: cc, bcc, attachment added
* HTTP REST API
* Pop3 or IMAP support
* Extract pop3 server from https://code.google.com/p/jemailserver/  http://sourceforge.net/projects/javaemailserver/files/JES%202/
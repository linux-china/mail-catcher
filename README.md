Mail Catcher
==============================
MailCatcher runs a super simple SMTP server which catches any message sent to it to display in a web interface.

### Features

* SMTP Server
* SendGrid API

### Spring Boot package

mvn -DskipTests clean package sping-boot:repackage

### Docker Builder

* docker build -t linuxchina/mail-catcher .
* docker run -d -p 1080:1080 -p 1025:1025 linuxchina/mail-catcher

### fig configuration

    mailcatcher:
        image: linuxchina/mail-catcher
        ports:
           - "1080:1080"
           - "1025:1025"

### Assembly to distribution

* mvn -DskipTests clean package assembly:assembly

### todo 

* WebSocket support: notify after mail received
* Display email count on web
* Email detail: cc, bcc, attachment added
* HTTP REST API
* Pop3 or IMAP support
* Extract pop3 server from https://code.google.com/p/jemailserver/  http://sourceforge.net/projects/javaemailserver/files/JES%202/


### send grid api

curl -X POST http://localhost:1080/api/mail.send.json \
     -d "to=test@sendgrid.com" \
     -d "from=you@youraddress.com" \
     -d "subject=Sending with SendGrid is Fun" \
     -d "html=and easy to do anywhere, even with CURL"
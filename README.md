Mail Catcher
============
MailCatcher runs a super simple SMTP server and REST API which catch any outbound emails for unit test

# Features

* SMTP Server: SMTP port 1025
* SendGrid API V2 & V3
* SendCloud V2
* Web user interface to check emails: http://localhost:1080
* Docker image

# Tech stack

* Spring Boot 2
* Thymeleaf 3
* Bootstrp 3
* SubEtha SMTP https://github.com/voodoodyne/subethasmtp
* Commons email & Javamail

# Docker support

* docker build
```
$ docker build -t linuxchina/mail-catcher .
```

* docker run
```
$ docker run -d -p 1080:1080 -p 1025:1025 linuxchina/mail-catcher
```

* docker compose
```yaml
version: "3"
services:
  mailcatcher:
      image: linuxchina/mail-catcher
      ports:
         - "1080:1080"
         - "1025:1025"
```

# Assembly to distribution

* mvn -DskipTests clean package assembly:assembly

### todo 

* Email quality check: SPF, DKIM

# References

* GreenMail: https://github.com/greenmail-mail-test/greenmail
* Jib: https://github.com/GoogleContainerTools/jib

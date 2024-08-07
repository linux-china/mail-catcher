Mail Catcher
============
MailCatcher runs a super simple SMTP server and REST API which catch all outbound emails for unit test.

# Features

* SMTP Server: SMTP port 1025
* SendGrid API V2 & V3
* SendCloud V2
* Docker image
* Web UI to check emails sent or not: http://localhost:1080

![Admin UI](admin-ui.png)

# Tech stack

* Spring Boot 2
* Thymeleaf 3
* Bootstrap 3
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
* maildev: SMTP Server + Web Interface for viewing and testing emails during development. https://github.com/maildev/maildev
* Mailpit: email testing for developers: https://github.com/axllent/mailpit
* MailHog: https://github.com/mailhog/MailHog
* Mailtutan: https://github.com/mailtutan/mailtutan
* JMail: A modern, fast, zero-dependency library for email address validation https://www.rohannagar.com/jmail/
* Ethereal Email: Ethereal is a fake SMTP service for email sending test https://ethereal.email/
* 10 Minutes email: https://temp-mail.org/en/10minutemail
* Securing SubEtha SMTP connections with TLS: https://blog.trifork.com/2009/11/10/securing-connections-with-tls/
* Stalwart Mail Server: Secure & Modern All-in-One Mail Server (IMAP, JMAP, POP3, SMTP) https://github.com/stalwartlabs/mail-server

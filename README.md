Mail Catcher
==============================
Catch all mail and display on the web, and main aim for unit testing.

### package

mvn -DskipTests clean package sping-boot:repackage

### Docker Builder

* docker build -t linuxchina/mail-catcher .
* docker run -d -p 1080:1080 -p 1025:1024 linuxchina/mail-catcher

### todo 

* notify after received
* email list page
* email detail page
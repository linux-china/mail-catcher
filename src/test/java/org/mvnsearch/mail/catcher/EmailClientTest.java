package org.mvnsearch.mail.catcher;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.junit.Test;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;

/**
 * email client test
 *
 * @author linux_china
 */
public class EmailClientTest {

    @Test
    public void testSendPlainEmail() throws Exception {
        Email email = constructEmail();
        email.setFrom("sender@gmail.com");
        email.setSubject("邮件标题");
        email.setMsg("邮件主体");
        email.addTo("receiver@bar.com");
        email.setCharset("UTF-8");
        email.send();
    }

    @Test
    public void testGetMailBody() throws Exception {
        Email email = constructEmail();
        email.setFrom("sender@gmail.com");
        email.setSubject("邮件标题");
        email.setMsg("邮件主体");
        email.addTo("receiver@bar.com");
        email.setCharset("UTF-8");
        email.send();
        MimeMessage mifmeMessage = email.getMimeMessage();
        System.out.println(mifmeMessage.getContentType());
    }

    public Email constructEmail() {
        Email email = new SimpleEmail();
        email.setHostName("127.0.0.1");
        email.setSmtpPort(1025);
        return email;
    }
}

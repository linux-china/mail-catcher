package org.mvnsearch.mail.catcher;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.subethamail.wiser.Wiser;

import javax.mail.internet.MimeMessage;

/**
 * email client test
 *
 * @author linux_china
 */
public class EmailClientTest {
    public static Wiser wiser;
    public static final int LISTEN_PORT = 10025;

    @BeforeClass
    public static void setUp() {
        wiser = new Wiser();
        wiser.setHostname("MailCatcher");
        wiser.setPort(LISTEN_PORT);
        wiser.start();
    }

    @AfterClass
    public static void tearDown() {
        wiser.stop();
    }

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
        email.setSmtpPort(LISTEN_PORT);
        return email;
    }
}

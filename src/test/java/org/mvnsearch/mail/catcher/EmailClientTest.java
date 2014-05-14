package org.mvnsearch.mail.catcher;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.junit.Test;

/**
 * email client test
 *
 * @author linux_china
 */
public class EmailClientTest {

    @Test
    public void testSendPlainEmail() throws Exception {
        Email email = constructEmail();
        email.setFrom("user@gmail.com");
        email.setSubject("TestMail");
        email.setMsg("This is a test mail ... :-)");
        email.addTo("foo@bar.com");
        email.send();
    }

    public Email constructEmail() {
        Email email = new SimpleEmail();
        email.setHostName("127.0.0.1");
        email.setSmtpPort(1025);
        return email;
    }
}

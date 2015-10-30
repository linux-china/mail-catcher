package org.mvnsearch.mail.catcher;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.junit.Test;

/**
 * commons email test
 *
 * @author linux_china
 */
public class CommonsEmailTest {

    @Test
    public void testSend() throws Exception {
        Email email = new SimpleEmail();
        email.setHostName("192.168.99.100");
        email.setSmtpPort(1025);
        email.setFrom("user@gmail.com");
        email.setSubject("你好拿铁会!!!");
        email.setMsg("This is a test mail ... :-)");
        email.addTo("foo@bar.com");
        email.send();
    }
}

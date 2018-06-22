package org.mvnsearch.mail.catcher.web;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;
import org.mvnsearch.mail.catcher.infrastructure.WiserServer;

import javax.annotation.Nullable;

/**
 * mail base controller
 *
 * @author linux_china
 */
public class MailBaseController {

    protected Email constructMail(String from, String to, String subject, @Nullable String text, @Nullable String html) throws Exception {
        Email email;
        if (!StringUtils.isEmpty(html)) {
            HtmlEmail temp = new HtmlEmail();
            temp.setHtmlMsg(html);
            email = temp;
        } else {
            email = new SimpleEmail();
            email.setMsg(text);
        }
        email.setHostName("127.0.0.1");
        email.setSmtpPort(WiserServer.LISTEN_PORT);
        email.setFrom(from);
        email.addTo(to);
        email.setSubject(subject);
        return email;
    }
}

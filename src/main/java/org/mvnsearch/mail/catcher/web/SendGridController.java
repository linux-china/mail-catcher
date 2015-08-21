package org.mvnsearch.mail.catcher.web;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.mvnsearch.mail.catcher.infrastructure.WiserServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * sendgrid controller
 *
 * @author linux_china
 */
@RestController
public class SendGridController {

    @RequestMapping("/api/mail.send.json")
    public Map<String, Serializable> send(@RequestParam("from") String from,
                                          @RequestParam("to") String to,
                                          @RequestParam("subject") String subject,
                                          @RequestParam("html") String html
    ) {
        Map<String, Serializable> result = new HashMap<>();
        result.put("message", "success");
        try {
            Email email = new SimpleEmail();
            email.setHostName("127.0.0.1");
            email.setSmtpPort(WiserServer.LISTEN_PORT);
            email.setFrom(from);
            email.addTo(to);
            email.setSubject(subject);
            email.setMsg(html);
            email.send();
        } catch (Exception e) {
            result.put("message", "fail");
        }
        return result;
    }
}

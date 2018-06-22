package org.mvnsearch.mail.catcher.web;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.Email;
import org.mvnsearch.mail.catcher.web.sendgrid.Mail;
import org.mvnsearch.mail.catcher.web.sendgrid.objects.Content;
import org.mvnsearch.mail.catcher.web.sendgrid.objects.Personalization;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * sendgrid controller
 *
 * @author linux_china
 */
@RestController
public class SendGridController extends MailBaseController {

    @RequestMapping("/api/mail.send.json")
    public Map<String, Serializable> send(
            @RequestParam("from") String from,
            @RequestParam("to") String to,
            @RequestParam("subject") String subject,
            @RequestParam(value = "html", required = false) String html,
            @RequestParam(value = "html", required = false) String text
    ) {
        Map<String, Serializable> result = new HashMap<>();
        result.put("message", "success");
        try {
            Email email = constructMail(from, to, subject, html, text);
            email.send();
        } catch (Exception e) {
            result.put("message", "fail");
        }
        return result;
    }

    @RequestMapping("/v3/mail/send")
    public void v3Send(HttpServletResponse response, @RequestBody Mail sendGridMail) {
        try {
            for (Personalization personalization: sendGridMail.getPersonalization()) {
                String to = null;
                for (org.mvnsearch.mail.catcher.web.sendgrid.objects.Email mailTo: personalization.getTos()) {
                    to = mailTo.getEmail();
                }
                String from = sendGridMail.getFrom().getEmail();
                String html = null;
                String text = null;
                Content content = sendGridMail.getContent().get(0);
                if ("text/plain".equalsIgnoreCase(content.getType())) {
                    text = content.getValue();
                } else {
                    html = content.getValue();
                }
                String subject = StringUtils.defaultIfBlank(personalization.getSubject(), sendGridMail.getSubject());
                Email email = constructMail(from, to, subject, text, html);
                email.send();
            }
        } catch (Exception e) {
            response.setStatus(400);
        }
        response.setStatus(202);
    }
}

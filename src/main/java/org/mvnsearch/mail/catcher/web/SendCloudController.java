package org.mvnsearch.mail.catcher.web;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;
import org.mvnsearch.mail.catcher.infrastructure.WiserServer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Send cloud controller
 *
 * @author linux_china
 */
@RestController
public class SendCloudController {

    @PostMapping("/apiv2/mail/send")
    public Map<String, Serializable> v2Send(
            @RequestParam("from") String from,
            @RequestParam("to") String to,
            @RequestParam("subject") String subject,
            @RequestParam(value = "html", required = false) String html,
            @RequestParam(value = "plain", required = false) String plain
    ) {
        Map<String, Serializable> result = new HashMap<>();
        result.put("result", true);
        result.put("statusCode", 200);
        try {
            Email email;
            if (!StringUtils.isEmpty(html)) {
                HtmlEmail temp = new HtmlEmail();
                temp.setHtmlMsg(html);
                email = temp;
            } else {
                email = new SimpleEmail();
                email.setMsg(plain);
            }
            email.setHostName("127.0.0.1");
            email.setSmtpPort(WiserServer.LISTEN_PORT);
            email.setFrom(from);
            email.addTo(to);
            email.setSubject(subject);
            email.send();
        } catch (Exception e) {
            result.put("result", false);
        }
        return result;
    }
}

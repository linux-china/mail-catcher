package org.mvnsearch.mail.catcher.web;


import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.mvnsearch.mail.catcher.infrastructure.WiserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * portal controller
 *
 * @author linux_china
 */
@RestController
public class PortalController {
    @Autowired
    WiserServer wiserServer;

    @RequestMapping("/")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("allEmails", wiserServer.getMessages());
        return modelAndView;
    }

    @RequestMapping("/tools")
    public ModelAndView tools() {
        return new ModelAndView("edit");
    }

    @RequestMapping("/send")
    public ModelAndView send(@RequestParam("from") String from, @RequestParam("to") String to,
                             @RequestParam("subject") String subject, @RequestParam("body") String body) {
        try {
            Email email = constructEmail();
            email.setFrom(from);
            email.addTo(to);
            email.setSubject(subject);
            email.setMsg(body);
            email.send();
        } catch (Exception ignore) {

        }
        return new ModelAndView("redirect:/");
    }


    public Email constructEmail() {
        Email email = new SimpleEmail();
        email.setHostName("127.0.0.1");
        email.setSmtpPort(1025);
        return email;
    }


}
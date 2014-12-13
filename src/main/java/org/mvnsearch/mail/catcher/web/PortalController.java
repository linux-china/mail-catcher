package org.mvnsearch.mail.catcher.web;


import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.mvnsearch.mail.catcher.infrastructure.EncodingUtils;
import org.mvnsearch.mail.catcher.infrastructure.WiserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.subethamail.wiser.WiserMessage;

/**
 * portal controller
 *
 * @author linux_china
 */
@RestController
public class PortalController {
    @Autowired
    private WiserServer wiserServer;
    private EncodingUtils encodingUtils = new EncodingUtils();

    @RequestMapping("/")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("allEmails", wiserServer.getMessages());
        modelAndView.addObject("encodingUtils", encodingUtils);
        return modelAndView;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(@RequestParam("id") String msgId) {
        wiserServer.removeMessage(msgId);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping("/show")
    public ModelAndView show(@RequestParam("id") String msgId) {
        ModelAndView modelAndView = new ModelAndView("email");
        WiserMessage email = wiserServer.findMsgById(msgId);
        modelAndView.addObject("email", email);
        return modelAndView;
    }

    @RequestMapping("/tools")
    public ModelAndView tools() {
        return new ModelAndView("send");
    }

    @RequestMapping("/clear")
    public ModelAndView clear() {
        wiserServer.clear();
        return new ModelAndView("redirect:/");
    }

    @RequestMapping("/send")
    public ModelAndView send(@RequestParam("sender") String sender, @RequestParam("receiver") String receiver,
                             @RequestParam("subject") String subject, @RequestParam("body") String body) {
        try {
            Email email = constructEmail();
            email.setFrom(sender);
            email.addTo(receiver);
            email.setSubject(subject);
            email.setCharset("UTF-8");
            email.setMsg(body);
            email.send();
        } catch (Exception ignore) {

        }
        return new ModelAndView("redirect:/");
    }

    private Email constructEmail() {
        Email email = new SimpleEmail();
        email.setHostName("127.0.0.1");
        email.setSmtpPort(1025);
        return email;
    }


}
package org.mvnsearch.mail.catcher.infrastructure.impl;

import org.mvnsearch.mail.catcher.infrastructure.WiserServer;
import org.springframework.stereotype.Service;
import org.subethamail.wiser.Wiser;
import org.subethamail.wiser.WiserMessage;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

/**
 * wiser server implementation
 *
 * @author linux_china
 */
@Service
public class WiserServerImpl implements WiserServer {
    public Wiser wiser;

    @PostConstruct
    public void start() {
        wiser = new Wiser();
        wiser.setHostname("MailCatcher");
        wiser.setPort(1025); // Default is 25
        wiser.start();
    }

    @PreDestroy
    public void stop() {
        wiser.stop();
    }

    /**
     * get messages in box
     *
     * @return message list
     */
    public List<WiserMessage> getMessages() {
        return wiser.getMessages();
    }
}

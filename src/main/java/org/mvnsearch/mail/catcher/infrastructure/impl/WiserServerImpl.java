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
        wiser.setPort(LISTEN_PORT);
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

    /**
     * find message by id
     *
     * @param id message id
     * @return wiser message
     */
    public WiserMessage findMsgById(String id) {
        List<WiserMessage> messages = getMessages();
        for (WiserMessage message : messages) {
            try {
                if (message.getMimeMessage().getMessageID().equals(id)) {
                    return message;
                }
            } catch (Exception ignore) {

            }
        }
        return null;
    }

    /**
     * remove message
     *
     * @param id message id
     */
    public void removeMessage(String id) {
        WiserMessage msg = findMsgById(id);
        if (msg != null) {
            getMessages().remove(msg);
        }
    }
}

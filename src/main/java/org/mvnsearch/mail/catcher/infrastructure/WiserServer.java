package org.mvnsearch.mail.catcher.infrastructure;

import org.subethamail.wiser.WiserMessage;

import java.util.List;

/**
 * wiser server
 *
 * @author linux_china
 */
public interface WiserServer {
    public int LISTEN_PORT = 1025;

    /**
     * start subethamail wiser server
     */
    public void start();

    /**
     * stop subethamail wiser server
     */
    public void stop();

    /**
     * get messages in box
     *
     * @return message list
     */
    public List<WiserMessage> getMessages();
}

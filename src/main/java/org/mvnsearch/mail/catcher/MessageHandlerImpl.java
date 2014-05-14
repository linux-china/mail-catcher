package org.mvnsearch.mail.catcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.subethamail.smtp.MessageContext;
import org.subethamail.smtp.MessageHandler;
import org.subethamail.smtp.RejectException;
import org.subethamail.smtp.TooMuchDataException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Message Handler
 *
 * @author linux_china
 */
public class MessageHandlerImpl implements MessageHandler {
    private static Logger log = LoggerFactory.getLogger(MessageHandlerImpl.class);
    private MessageContext context;
    private String from;
    private List<String> recipients = new ArrayList<>();

    public MessageHandlerImpl(MessageContext context) {
        this.context = context;
    }

    public void from(String from) throws RejectException {
        this.from = from;
    }

    public void recipient(String recipient) throws RejectException {
        this.recipients.add(recipient);
    }

    public void data(InputStream inputStream) throws RejectException, TooMuchDataException, IOException {

    }

    public void done() {

    }
}

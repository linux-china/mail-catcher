package org.mvnsearch.mail.catcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.subethamail.smtp.MessageContext;
import org.subethamail.smtp.MessageHandler;
import org.subethamail.smtp.RejectException;
import org.subethamail.smtp.TooMuchDataException;

import java.io.IOException;
import java.io.InputStream;

/**
 * Message Handler
 *
 * @author linux_china
 */
public class MessageHandlerImpl implements MessageHandler {
    private Logger log = LoggerFactory.getLogger(MessageHandlerImpl.class);
    MessageContext context;

    public MessageHandlerImpl(MessageContext context) {
        this.context = context;
    }

    public void from(String s) throws RejectException {

    }

    public void recipient(String s) throws RejectException {

    }

    public void data(InputStream inputStream) throws RejectException, TooMuchDataException, IOException {

    }

    public void done() {

    }
}

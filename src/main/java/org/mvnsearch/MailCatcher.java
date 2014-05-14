package org.mvnsearch;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.mvnsearch.mail.catcher.MessageHandlerImpl;
import org.mvnsearch.mail.catcher.web.servlet.WebMailServlet;
import org.mvnsearch.mail.catcher.web.servlet.WebjarsServlet;
import org.subethamail.smtp.MessageContext;
import org.subethamail.smtp.MessageHandler;
import org.subethamail.smtp.MessageHandlerFactory;
import org.subethamail.smtp.server.SMTPServer;

/**
 * mail catcher
 *
 * @author linux_china
 */
public class MailCatcher {
    public static void main(String[] args) throws Exception {
        System.out.println("Starting mail server");
        startSmtpServer();
        System.out.println("Starting web server");
        startWebServer();
        System.out.println("Done");
    }

    public static void startSmtpServer() {
        SMTPServer smtpServer = new SMTPServer(new MessageHandlerFactory() {
            public MessageHandler create(MessageContext messageContext) {
                return new MessageHandlerImpl(messageContext);
            }
        });
        smtpServer.setHostName("Mail Catcher");
        smtpServer.setPort(1025);
        smtpServer.start();
    }

    public static void startWebServer() throws Exception {
        Server server = new Server(8080);
        ServletHandler handler = new ServletHandler();
        server.setHandler(handler);
        handler.addServletWithMapping(WebjarsServlet.class, "/webjars/*");
        handler.addServletWithMapping(WebMailServlet.class, "*.html");
        server.start();
        server.join();
    }
}

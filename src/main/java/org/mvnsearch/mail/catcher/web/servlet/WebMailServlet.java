package org.mvnsearch.mail.catcher.web.servlet;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

/**
 * webmail servlet
 *
 * @author linux_china
 */
public class WebMailServlet extends HttpServlet {
    /**
     * velocity engine
     */
    private VelocityEngine ve;
    private String layout = "";

    public WebMailServlet() {
        Velocity.init();
        this.ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        try {
            this.layout = IOUtils.toString(this.getClass().getResourceAsStream("/templates/layout.vm"));
        } catch (Exception e) {

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        VelocityContext context = new VelocityContext();
        String template = "portal";
        if (StringUtils.isEmpty(action)) {
            template = portal(request, response, context);
        }
        response.setContentType("text/html");
        ServletOutputStream output = response.getOutputStream();
        String pageContent = render("/templates/" + template, context);
        output.write(layout.replace("$content", pageContent).getBytes());
        output.flush();
    }

    public String portal(HttpServletRequest request, HttpServletResponse response, VelocityContext context) throws ServletException, IOException {
        return "portal.vm";
    }

    private String render(String template, VelocityContext context) {
        StringWriter sw = new StringWriter();
        ve.getTemplate(template).merge(context, sw);
        return sw.toString();
    }
}

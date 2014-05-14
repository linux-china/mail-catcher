package org.mvnsearch.mail.catcher.web.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * webjars servlet
 *
 * @author linux_china
 */
public class WebjarsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestUri = request.getRequestURI();
        InputStream resource = this.getClass().getResourceAsStream("/META-INF/resources" + requestUri);
        response.setContentType("application/octet-stream");
        ServletOutputStream output = response.getOutputStream();
        IOUtils.copy(resource, output);
        output.flush();
    }
}

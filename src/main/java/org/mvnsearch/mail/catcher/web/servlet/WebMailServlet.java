package org.mvnsearch.mail.catcher.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * webmail servlet
 *
 * @author linux_china
 */
public class WebMailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        response.setContentType("text/html");
        ServletOutputStream output = response.getOutputStream();
        output.write("google".getBytes());
    }
}

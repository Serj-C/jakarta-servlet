package org.example.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.PushBuilder;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "resource-push-servlet", urlPatterns = {"/resource-push-servlet"})
public class ResourcePushServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>Server To Client Resources Push Servlet</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<h1>Servlet resource-push-servlet at " + request.getContextPath() + "</h1>");
            writer.println("<img src=\"images/1golf8.jpg\" width=400 heigth=300><br/>");
            writer.println("<img src=\"images/2golf8.jpg\" width=300 heigth=400>");
            writer.println("</body>");
            writer.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("In the servlet");
        ServletContext servletContext = getServletContext();
        PushBuilder pushBuilder = req.newPushBuilder();
        if (req.getRequestURI().equals("/jakarta-servlet-1.0/resource-push-servlet")) {
            if (pushBuilder != null) {
                pushBuilder.path("images/1golf8.jpg").push();
                pushBuilder.path("images/2golf8.jpg").push();
                System.out.println("Server Push completed");
            } else {
                System.out.println("PushBuilder not supported.");
            }
        }
        processRequest(req, resp);
    }
}

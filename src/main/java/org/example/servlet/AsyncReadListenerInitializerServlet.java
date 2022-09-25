package org.example.servlet;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.listener.AsyncReadListener;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/async-read-listener-initializer-servlet"}, asyncSupported = true)
public class AsyncReadListenerInitializerServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter writer = response.getWriter()) {
            AsyncContext asyncContext = request.startAsync();
            ServletInputStream servletInputStream = request.getInputStream();
            servletInputStream.setReadListener(new AsyncReadListener(servletInputStream, asyncContext));
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}

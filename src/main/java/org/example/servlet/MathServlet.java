package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "math-servlet", urlPatterns = {"/math-servlet"})
public class MathServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String numA = req.getParameter("numa");
        String numB = req.getParameter("numb");

        PrintWriter writer = resp.getWriter();
        writer.println("<html><head>");
        writer.println("<title>Test Math Servlet</title>");
        writer.println("\t<style>body { font-family: 'Lucida Grande', " +
                "'Lucida Sans Unicode'; font-size: 13px; }</style>");
        writer.println("</head>");
        writer.println("<body>");
        try {
            int solution = Integer.parseInt(numA) + Integer.parseInt(numB);
            writer.println("<p>Solution: " + numA + " + " + numB + " = " + solution + "</p>");
        } catch (NumberFormatException e) {
            writer.println("<p>Please use number only... try again.</p>");
        }
        writer.println("<br/><br/>");
        writer.println("<a href='page.html'>Add Two More Numbers</a>");
        writer.println("</body></html>");
        writer.close();
    }
}

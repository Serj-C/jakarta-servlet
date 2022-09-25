package org.example.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "async-reader-servlet", urlPatterns = {"/async-reader-servlet"})
public class AsyncReaderServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        String fileName = "test.txt";
        ServletContext servletContext = getServletContext();
        InputStream inputStream = servletContext.getResourceAsStream(fileName);
        try (PrintWriter writer = response.getWriter()) {
            String path = "http://"
                    + request.getServerName()
                    + ":"
                    + request.getServerPort()
                    + request.getContextPath()
                    + "/async-read-listener-initializer-servlet";
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>Async Reader Servlet</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<h1>Servlet Example at " + request.getContextPath() + "</h1>");
            writer.println("Invoking the endpoint: " + path + "<br>");
            writer.flush();
            URL url = new URL(path);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setChunkedStreamingMode(2);
            // If setDoOutput is enabled - POST HTTP Method is used.
            httpURLConnection.setDoOutput(true);
            httpURLConnection.connect();

            if (inputStream != null) {
                String text;
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                     BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(
                             httpURLConnection.getOutputStream()))) {
                    writer.println("Got the output... beginning read loop<br/>");
                    while ((text = bufferedReader.readLine()) != null) {
                        writer.println("&nbsp&nbsp&nbsp&nbspReading text: " + text + "<br/>");
                        writer.flush();
                        bufferedWriter.write(text + '\n');
                        Thread.sleep(1000);
                        writer.flush();
                    }
                    bufferedWriter.write("Ending writing now...");
                    bufferedWriter.flush();
                }
            } else {
                writer.println("File not found.");
            }
            writer.println("Review the WildFly logs for written data...");
            writer.println("</body>");
            writer.println("</html>");
        } catch (InterruptedException | IOException e) {
            Logger.getLogger(AsyncReaderServlet.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}

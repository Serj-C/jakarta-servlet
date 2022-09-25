package org.example.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class StartupShutdownListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Servlet startup...");
        System.out.println(sce.getServletContext().getServerInfo());
        System.out.println(System.currentTimeMillis());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Servlet shutdown...");
        System.out.println(sce.getServletContext().getServerInfo());
        System.out.println(System.currentTimeMillis());
    }
}

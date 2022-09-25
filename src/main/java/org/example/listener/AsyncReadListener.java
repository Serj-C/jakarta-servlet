package org.example.listener;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AsyncReadListener implements ReadListener {
    private final ServletInputStream servletInputStream;
    private final AsyncContext asyncContext;

    public AsyncReadListener(ServletInputStream servletInputStream, AsyncContext asyncContext) {
        this.servletInputStream = servletInputStream;
        this.asyncContext = asyncContext;
        System.out.println("Read listener initialized");
    }

    @Override
    public void onDataAvailable() throws IOException {
        System.out.println("onDataAvailable");
        try {
            StringBuilder stringBuilder = new StringBuilder();
            int len = -1;
            byte[] b = new byte[1024];
            while (servletInputStream.isReady() && (len = servletInputStream.read(b)) != -1) {
                String data = new String(b, 0, len);
                System.out.println(data);
            }
        } catch (IOException e) {
            Logger.getLogger(AsyncReadListener.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void onAllDataRead() throws IOException {
        System.out.println("onAllDataRead");
        asyncContext.complete();
    }

    @Override
    public void onError(Throwable t) {
        System.out.println("onError");
        System.out.println("Error: " + t);
        asyncContext.complete();
    }
}

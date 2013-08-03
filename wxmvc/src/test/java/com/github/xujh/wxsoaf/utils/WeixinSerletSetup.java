package com.github.xujh.wxsoaf.utils;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.junit.BeforeClass;

import com.github.xujh.wxsoaf.servlet.WeixinServerServlet;

public class WeixinSerletSetup {

    @BeforeClass
    public void setup() {
        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new WeixinServerServlet()), "/wx");
    }

}

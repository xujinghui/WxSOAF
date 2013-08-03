/**
 * 
 */
package com.github.xujh.wxsoaf.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.junit.Before;

import com.github.xujh.wxsoaf.servlet.WeixinServerServlet;

/**
 * @author stevenxu
 * 
 */
public class JettyStarter {

    /**
     * Embedding Jetty Docs: {@link #http://www.eclipse.org/jetty/documentation/current/embedding-jetty.html}
     * 
     * @param args
     * @throws Exception
     */
    @Before
    public static void main(String[] args) throws Exception {
        doServlet();
    }

    private static void doServlet() throws Exception {
        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        System.out.println("aaa1:" + context.getResourceBase());
        context.addServlet(new ServletHolder(new WeixinServerServlet()), "/hello");
        // context.addServlet(new ServletHolder(new HelloServlet("TYPE1 Request")), "/TYPE1/*");
        // context.addServlet(new ServletHolder(new HelloServlet("TYPE2 Request")), "/TYPE2/*");
        System.out.println("aaa2" + context.getResourceBase());
        server.start();
        System.out.println("aaa3:" + context.getResourceBase());
        // server.join();
        System.out.println("aaa4:" + context.getResourceBase());
    }

    private static void doServer1() throws Exception {
        Server server = new Server(8080);
        ContextHandler context = new ContextHandler();
        context.setContextPath("/");
        context.setResourceBase(".");
        // context.setClassLoader(Thread.currentThread().getContextClassLoader());
        server.setHandler(context);
        System.out.println("abc3");
        context.setHandler(new AbstractHandler() {
            public void handle(String target, Request baseRequest, HttpServletRequest request,
                    HttpServletResponse response) throws IOException, ServletException {
                System.out.println("abc");
                response.setContentType("text/html;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_OK);
                baseRequest.setHandled(true);
                response.getWriter().write("</pre> <h1>Hello World 1 " + "" + "</h1> <pre> ");
                response.flushBuffer();

            }

            @Override
            public void destroy() {
                System.out.println("destroy1");
                super.destroy();

            }
        });

        server.start();
        // server.join();
    }
}

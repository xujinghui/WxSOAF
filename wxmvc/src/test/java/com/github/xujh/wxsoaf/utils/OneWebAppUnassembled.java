/**
 * 
 */
package com.github.xujh.wxsoaf.utils;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * @author stevenxu
 * 
 */
public class OneWebAppUnassembled {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        WebAppContext context = new WebAppContext();
        context.setDescriptor("src/main/webapp/WEB-INF/web.xml");
        context.setResourceBase("src/main/webapp");
        context.setContextPath("/wxkm");
        context.setParentLoaderPriority(true);

        server.setHandler(context);

        server.start();
        server.join();
    }
}

/**
 * 
 */
package com.github.xujh.wxsoaf.servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.xujh.wxsoaf.mvc.IHandlerWrapper;
import com.github.xujh.wxsoaf.mvc.IProcessHandlerSelector;
import com.github.xujh.wxsoaf.mvc.IProtocolTypeSelector;
import com.github.xujh.wxsoaf.mvc.SpringUtils;
import com.github.xujh.wxsoaf.wxintf.IPushRequest;
import com.github.xujh.wxsoaf.wxintf.IPushResponse;
import com.github.xujh.wxsoaf.wxintf.WxStringConverter;
import com.github.xujh.wxsoaf.wxintf.XppDriver4CDATA;
import com.thoughtworks.xstream.XStream;

/**
 * @author stevenxu
 * 
 */
public class WeixinServerServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(WeixinServerServlet.class);

    private IProtocolTypeSelector typeSelector = null;

    private IProcessHandlerSelector handlerSelector = null;

    @Override
    public void init() throws ServletException {
        this.typeSelector = (IProtocolTypeSelector) SpringUtils.getBean(SpringUtils.TYPE_SELECTOR);
        this.handlerSelector = (IProcessHandlerSelector) SpringUtils
                .getBean(SpringUtils.HANDLER_SELECTOR);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        // request.setCharacterEncoding("UTF-8");
        // response.setContentType("text/html; charset=UTF-8");
        // response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        // response.getWriter().println("hello:" + System.currentTimeMillis());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);

    }

    private static final String REGEX = "<MsgType>\\D+</MsgType>";
    private static final Pattern PAT = Pattern.compile(REGEX);

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        IPushResponse pushResponse = null;
        try {
            logger.info("Request Entering.");
            String echoStr = request.getParameter("echostr");
            if (echoStr != null) {
                logger.info("echostr values:" + echoStr);
                response.getOutputStream().write(echoStr.getBytes());
                return;
            }
            pushResponse = doProcess(request, response);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        if (pushResponse != null) {
            processResponse(response, pushResponse);
        }

        // ObjectInputStream in = xstream.createObjectInputStream(is);
    }

    private IPushResponse doProcess(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String inputStr = IOUtils.toString(request.getInputStream());
        logger.info("inputStr content: \n" + inputStr);
        Matcher matcher = PAT.matcher(inputStr);

        Class<? extends IPushRequest> reqType = null;
        IHandlerWrapper handlerWrapper = null;
        IPushResponse pushResponse = null;
        if (matcher.find()) {
            String typeStr = matcher.group(0);
            String type = typeStr.substring(18, typeStr.length() - 13);
            logger.info("inputStr type: \n" + type.toString());
            reqType = typeSelector.getTypeClaz(typeStr);
            // handler = HandlerFactory.getHandler(type);
        }

        if (reqType != null) {
            ;
        } else {
            XStream reqXStream = new XStream();
            reqXStream.processAnnotations(new Class[] { reqType });
            IPushRequest obj = (IPushRequest) reqXStream.fromXML(inputStr);
            handlerWrapper = handlerSelector.getHandlerWrapper(obj);
            pushResponse = handlerWrapper.handle(obj, new WxContext(request.getSession()));
        }

        return pushResponse;
    }

    private void processResponse(HttpServletResponse response, IPushResponse pushResponse)
            throws IOException {
        XStream resXStream = new XStream(new XppDriver4CDATA());
        resXStream.registerConverter(new WxStringConverter());

        resXStream.alias("xml", pushResponse.getClass());
        resXStream.processAnnotations(pushResponse.getClass());
        String xml = resXStream.toXML(pushResponse);
        logger.info("response messages 1:" + xml);
        // resXStream.toXML(pushResponse, response.getOutputStream());
        response.getOutputStream().write(xml.getBytes());
    }
}

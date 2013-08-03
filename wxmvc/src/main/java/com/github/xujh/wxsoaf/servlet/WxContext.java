/**
 * 
 */
package com.github.xujh.wxsoaf.servlet;

import javax.servlet.http.HttpSession;

/**
 * @author stevenxu
 * 
 */
public class WxContext {

    private HttpSession session;
    
    private Class requestType;

    public WxContext(HttpSession session) {
        this.session = session;
    }

    public Class getRequestType() {
        return requestType;
    }

    public void setRequestType(Class requestType) {
        this.requestType = requestType;
    }
    
    
}

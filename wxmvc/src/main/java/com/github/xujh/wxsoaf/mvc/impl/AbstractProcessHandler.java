/**
 * 
 */
package com.github.xujh.wxsoaf.mvc.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.util.CollectionUtils;

import com.github.xujh.wxsoaf.mvc.Controller;
import com.github.xujh.wxsoaf.mvc.IProcessHandler;
import com.github.xujh.wxsoaf.servlet.WxContext;
import com.github.xujh.wxsoaf.wxintf.IPushRequest;
import com.github.xujh.wxsoaf.wxintf.IPushResponse;

/**
 * @author stevenxu
 * 
 */
public abstract class AbstractProcessHandler<T extends IPushRequest> implements IProcessHandler<T> {
    private Object rootHandler;

    protected final Map<String, Controller> controllerMap = new HashMap<String, Controller>();

    public void setRootHandler(Object rootHandler) {
        this.rootHandler = rootHandler;
    }

    /**
     * Return the root handler for this handler mapping (registered for "/"), or {@code null} if none.
     */
    public Object getRootHandler() {
        return this.rootHandler;
    }

    public void setMappings(Map<String, Controller> urlMap) {
        this.controllerMap.putAll(urlMap);
    }

    public void setUrlMap(Map<String, Controller> urlMap) {
        this.controllerMap.putAll(urlMap);
    }

    public Map<String, ?> getUrlMap() {
        return this.controllerMap;
    }

}

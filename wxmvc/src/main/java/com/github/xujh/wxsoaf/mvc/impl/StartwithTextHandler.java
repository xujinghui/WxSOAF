/**
 * 
 */
package com.github.xujh.wxsoaf.mvc.impl;

import java.util.Map;

import com.github.xujh.wxsoaf.mvc.Controller;
import com.github.xujh.wxsoaf.wxintf.TextRequest;

/**
 * @author stevenxu
 * 
 */
public class StartwithTextHandler extends AbstractProcessHandler<TextRequest> {

    /*
     * (non-Javadoc)
     * 
     * @see com.github.xujh.wxsoaf.servlet.mvc.IHandlerMapping#getHandler(java.lang.String)
     */
    public Controller getController(TextRequest req) {
        String text = req.getContent().trim();
        for (Map.Entry<String, Controller> entry : controllerMap.entrySet()) {
            if (text.startsWith(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }
}

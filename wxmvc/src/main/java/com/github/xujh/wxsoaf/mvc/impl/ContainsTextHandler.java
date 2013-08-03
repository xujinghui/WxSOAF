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
public class ContainsTextHandler extends AbstractProcessHandler<TextRequest> {
    
    public Controller getController(TextRequest req) {
        String text = req.getContent().trim();
        for (Map.Entry<String, Controller> entry : controllerMap.entrySet()) {
            if (text.contains(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }
}

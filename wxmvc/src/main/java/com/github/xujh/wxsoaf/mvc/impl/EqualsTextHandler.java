/**
 * 
 */
package com.github.xujh.wxsoaf.mvc.impl;

import com.github.xujh.wxsoaf.mvc.Controller;
import com.github.xujh.wxsoaf.wxintf.TextRequest;

/**
 * @author stevenxu
 * 
 */
public class EqualsTextHandler extends AbstractProcessHandler<TextRequest> {

    @Override
    public Controller getController(TextRequest req) {
        String text = req.getContent();
        if (controllerMap.keySet().contains(text.trim())) {
            return controllerMap.get(text.trim());
        }

        return null;
    }

}

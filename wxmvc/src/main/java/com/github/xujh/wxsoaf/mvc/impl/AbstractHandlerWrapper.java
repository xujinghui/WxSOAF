/**
 * 
 */
package com.github.xujh.wxsoaf.mvc.impl;

import com.github.xujh.wxsoaf.mvc.Controller;
import com.github.xujh.wxsoaf.mvc.IHandlerWrapper;
import com.github.xujh.wxsoaf.servlet.WxContext;
import com.github.xujh.wxsoaf.wxintf.IPushRequest;
import com.github.xujh.wxsoaf.wxintf.IPushResponse;

/**
 * @author stevenxu
 * 
 */
public abstract class AbstractHandlerWrapper implements IHandlerWrapper {

    public IPushResponse handle(IPushRequest req, WxContext ctx) {
        Controller controller = this.getController(req);
        if (controller != null) {
            return controller.handleRequest(req, ctx);
        }

        return null;
    }

    protected abstract Controller getController(IPushRequest req);

}

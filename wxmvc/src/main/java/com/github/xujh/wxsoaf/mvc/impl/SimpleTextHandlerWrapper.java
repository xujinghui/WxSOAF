/**
 * 
 */
package com.github.xujh.wxsoaf.mvc.impl;

import java.util.LinkedList;
import java.util.List;

import com.github.xujh.wxsoaf.mvc.Controller;
import com.github.xujh.wxsoaf.mvc.IProcessHandler;
import com.github.xujh.wxsoaf.wxintf.IPushRequest;

/**
 * @author stevenxu
 * 
 */
public class SimpleTextHandlerWrapper extends AbstractHandlerWrapper {

    private List<IProcessHandler> handleList = new LinkedList<IProcessHandler>();

    public void setHandlers(List handlers) {
        handleList.addAll(handlers);
    }

    protected Controller getController(IPushRequest req) {

        for (IProcessHandler handler : this.handleList) {

            // controller = getController(hm.getHandler(req.getContent()));
            Controller controller = handler.getController(req);
            if (controller != null) {
                return controller;
            }
        }

        return null;
    }

}

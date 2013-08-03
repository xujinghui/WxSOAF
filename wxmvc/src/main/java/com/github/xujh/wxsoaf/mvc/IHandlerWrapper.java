/**
 * 
 */
package com.github.xujh.wxsoaf.mvc;

import com.github.xujh.wxsoaf.servlet.WxContext;
import com.github.xujh.wxsoaf.wxintf.IPushRequest;
import com.github.xujh.wxsoaf.wxintf.IPushResponse;

/**
 * @author stevenxu
 * 
 */
public interface IHandlerWrapper {
    // String getHandler(String text);

    IPushResponse handle(IPushRequest req, WxContext ctx);

}

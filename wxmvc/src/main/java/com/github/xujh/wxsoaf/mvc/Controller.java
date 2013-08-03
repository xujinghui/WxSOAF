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
public interface Controller<T extends IPushRequest> {

    IPushResponse handleRequest(T req, WxContext ctx);

}

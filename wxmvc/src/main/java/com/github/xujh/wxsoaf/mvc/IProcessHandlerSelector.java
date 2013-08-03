/**
 * 
 */
package com.github.xujh.wxsoaf.mvc;

import com.github.xujh.wxsoaf.wxintf.IPushRequest;

/**
 * @author stevenxu
 * 
 */
public interface IProcessHandlerSelector<T extends IPushRequest> {

    public IHandlerWrapper getHandlerWrapper(T req);
}

/**
 * 
 */
package com.github.xujh.wxsoaf.mvc;

import com.github.xujh.wxsoaf.wxintf.IPushRequest;

/**
 * @author stevenxu
 * 
 */
public interface IProtocolTypeSelector {
    public Class<? extends IPushRequest> getTypeClaz(String typeStr);
}

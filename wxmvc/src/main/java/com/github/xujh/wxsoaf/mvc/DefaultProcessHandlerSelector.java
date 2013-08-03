/**
 * 
 */
package com.github.xujh.wxsoaf.mvc;

import java.util.HashMap;
import java.util.Map;

import com.github.xujh.wxsoaf.wxintf.AbstractPushRequest;

/**
 * @author stevenxu
 * 
 */
public class DefaultProcessHandlerSelector implements IProcessHandlerSelector<AbstractPushRequest> {
    protected final Map<String, IHandlerWrapper> wrapperMap = new HashMap<String, IHandlerWrapper>();

    public void setMappings(Map<String, IHandlerWrapper> mappings) {
        // CollectionUtils.mergePropertiesIntoMap(mappings, this.wrapperMap);
        this.wrapperMap.putAll(mappings);
    }

    public void setHandlerMap(Map<String, IHandlerWrapper> urlMap) {
        this.wrapperMap.putAll(urlMap);
    }

    public Map<String, ?> getHandlerMap() {
        return this.wrapperMap;
    }

    @Override
    public IHandlerWrapper getHandlerWrapper(AbstractPushRequest req) {
        IHandlerWrapper wrapper = wrapperMap.get(req.getMsgType());
        if (wrapper == null) {
            wrapper = wrapperMap.get(SpringUtils.DEFAULT);
        }

        return wrapper;
    }
}

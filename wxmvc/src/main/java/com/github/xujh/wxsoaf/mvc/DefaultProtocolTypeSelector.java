/**
 * 
 */
package com.github.xujh.wxsoaf.mvc;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.github.xujh.wxsoaf.annotation.RequestType;
import com.github.xujh.wxsoaf.wxintf.EventRequest;
import com.github.xujh.wxsoaf.wxintf.IPushRequest;
import com.github.xujh.wxsoaf.wxintf.ImageRequest;
import com.github.xujh.wxsoaf.wxintf.LinkRequest;
import com.github.xujh.wxsoaf.wxintf.LocationRequest;
import com.github.xujh.wxsoaf.wxintf.TextRequest;

/**
 * @author stevenxu
 * 
 */
public class DefaultProtocolTypeSelector implements IProtocolTypeSelector {
    private static final Logger logger = LoggerFactory.getLogger(DefaultProtocolTypeSelector.class);

    protected final Map<String, Class> typeMap = new HashMap<String, Class>();

    public DefaultProtocolTypeSelector() {
        typeMap.put(RequestType.text.name(), TextRequest.class);
        typeMap.put(RequestType.image.name(), ImageRequest.class);
        typeMap.put(RequestType.link.name(), LinkRequest.class);
        typeMap.put(RequestType.location.name(), LocationRequest.class);
        typeMap.put(RequestType.event.name(), EventRequest.class);
    }

    public void setMappings(Properties props) {
        if (props != null) {
            for (Enumeration en = props.propertyNames(); en.hasMoreElements();) {
                String key = (String) en.nextElement();
                Object value = props.getProperty(key);
                if (value == null) {
                    // Potentially a non-String value...
                    value = props.get(key);
                }
                try {
                    Class claz = Class.forName(value.toString());
                    typeMap.put(key, claz);
                } catch (ClassNotFoundException cnfe) {
                    logger.info("", cnfe);
                }

            }
        }

    }

    public void setHandlerMap(Map<String, String> urlMap) {
        // this.typeMap.putAll(urlMap);
    }

    public Map<String, ?> getHandlerMap() {
        return this.typeMap;
    }

    public Class<? extends IPushRequest> getTypeClaz(String typeStr) {
        return typeMap.get(typeStr);
    }
}

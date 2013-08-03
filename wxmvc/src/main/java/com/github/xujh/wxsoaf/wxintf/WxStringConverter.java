/**
 * 
 */
package com.github.xujh.wxsoaf.wxintf;

import com.thoughtworks.xstream.converters.basic.StringConverter;

/**
 * @author stevenxu
 * 
 */
public class WxStringConverter extends StringConverter {
    public String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        //
        // StringBuffer sb = new StringBuffer();
        // sb.append("<![CDATA[");
        // sb.append(obj.toString());
        // sb.append("]]>");

        return "<![CDATA[" + obj.toString() + "]]>";
    }
}

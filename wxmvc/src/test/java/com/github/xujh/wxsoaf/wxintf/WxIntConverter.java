/**
 * 
 */
package com.github.xujh.wxsoaf.wxintf;

import com.thoughtworks.xstream.converters.basic.IntConverter;

/**
 * @author stevenxu
 * 
 */
public class WxIntConverter extends IntConverter {
    public String toString(Object obj) {
        System.out.println("----------------------WxIntConverter toString:" + obj);
        return super.toString(obj);
    }

    public Object fromString(String str) {
        System.out.println("---------------------------WxIntConverter toString:" + str);
        return super.fromString(str);
    }
}

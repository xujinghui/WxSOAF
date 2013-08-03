/**
 * 
 */
package com.github.xujh.wxsoaf.utils;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author stevenxu
 * 
 */
public class XmlClasspathLoadTestCase {

    @Test
    public void testA() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext(
                "classpath:spring/mvc-core-config.xml");
        Object obj = app.getBean("showMessages");
    }
}

/**
 * 
 */
package com.github.xujh.wxsoaf.wxintf;

import java.io.Writer;

import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * @author stevenxu
 * 
 */
public class XppDriver4CDATA extends XppDriver {

    public HierarchicalStreamWriter createWriter(Writer out) {
        return new PrettyPrintWriter(out) {
            // 对所有xml节点的转换都增加CDATA标记
            boolean cdata = true;

            @SuppressWarnings("unchecked")
            public void startNode(String name, Class clazz) {
                // System.out.println("text2:" + name + " " + clazz.getName());
                super.startNode(name, clazz);
            }

            protected void writeText(QuickWriter writer, String text) {
                // System.out.println("text1:" + text);
                if (cdata) {
                    // writer.write("<![CDATA[");
                    writer.write(text);
                    // writer.write("]]>");
                } else {
                    writer.write(text);
                }
            }
        };
    }

}

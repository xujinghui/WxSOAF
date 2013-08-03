package com.github.xujh.wxsoaf.wxintf;

import java.io.Writer;
import java.util.Calendar;
import java.util.Locale;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class TextRequestXStreamTestCase {
    protected static String PREFIX_CDATA = "<![CDATA[";
    protected static String SUFFIX_CDATA = "]]>";

    @Test
    public void test2() {
        // XStream xstream = new XStream(new XppDriver() {
        // public HierarchicalStreamWriter createWriter(Writer out) {
        // return new PrettyPrintWriter(out) {
        // protected void writeText(QuickWriter writer, String text) {
        // if (text.startsWith(PREFIX_CDATA) && text.endsWith(SUFFIX_CDATA)) {
        // writer.write(text);
        // } else {
        // super.writeText(writer, text);
        // }
        // }
        // };
        // };
        // });
        // XStream xstream = new XStream(new XppDriver() {
        //
        //
        // public HierarchicalStreamWriter createWriter(Writer out) {
        //
        //
        // return new PrettyPrintWriter(out) {
        // // 对所有xml节点的转换都增加CDATA标记
        // boolean cdata = true;
        //
        // @SuppressWarnings("unchecked")
        // public void startNode(String name, Class clazz) {
        // super.startNode(name, clazz);
        // }
        //
        // protected void writeText(QuickWriter writer, String text) {
        // if (cdata) {
        // writer.write("<![CDATA[");
        // writer.write(text);
        // writer.write("]]>");
        // } else {
        // writer.write(text);
        // }
        // }
        // };
        // }
        // });
        XStream xstream = new XStream(new XppDriver());

        xstream.alias("xml", TextRequest.class);

        String str = "<xml><ToUserName><![CDATA[text]]></ToUserName></xml>";
        xstream.processAnnotations(new Class[] { TextRequest.class });
        TextRequest tr = (TextRequest) xstream.fromXML(str);
        System.out.println(tr.getToUserName().length());
        System.out.println(tr.getToUserName());
    }

    @Test
    public void test1() {
        XStream xstream = new XStream(new XppDriver() {
            public HierarchicalStreamWriter createWriter(Writer out) {
                return new PrettyPrintWriter(out) {
                    // 对所有xml节点的转换都增加CDATA标记
                    boolean cdata = true;

                    @SuppressWarnings("unchecked")
                    public void startNode(String name, Class clazz) {
                        super.startNode(name, clazz);
                    }

                    protected void writeText(QuickWriter writer, String text) {
                        if (cdata) {
                            writer.write("<![CDATA[");
                            writer.write(text);
                            writer.write("]]>");
                        } else {
                            writer.write(text);
                        }
                    }
                };
            }
        });
        // xstream.alias("xml", TextRequest.class);

        TextRequest hm = new TextRequest();
        hm.setToUserName("abc");
        hm.setFromUserName("cde");
        xstream.processAnnotations(new Class[] { TextRequest.class });
        System.out.println(xstream.toXML(hm));
    }

    @Test
    public void test3() {
        MusciResponse tr = new MusciResponse();
        tr.setFromUserName("u");
        tr.setToUserName("z");
        tr.setCreateTime("");

        String content = null;

        // if (!userBindService.isBinded(req.getFromUserName())) {
        //
        // }
        String musicUrl = "http://zhangmenshiting.baidu.com/data2/music/64313818/126259821600128.mp3?xcode=d7acefd0abdf98a52ea7fb4febd8cf5dc641dd56c7eeeccc";

        Music music = new Music();
        music.setDescription("Desc");
        music.setTitle("Music coming!");
        music.sethQMusicUrl(musicUrl);
        music.setMusicUrl(musicUrl);
        tr.setMusic(music);
        tr.setFuncFlag(0);

        // XStream xstream = new XStream(new XppDriver() {
        // public HierarchicalStreamWriter createWriter(Writer out) {
        // return new PrettyPrintWriter(out) {
        // // 对所有xml节点的转换都增加CDATA标记
        // boolean cdata = true;
        //
        // @SuppressWarnings("unchecked")
        // public void startNode(String name, Class clazz) {
        // super.startNode(name, clazz);
        // }
        //
        // protected void writeText(QuickWriter writer, String text) {
        // System.out.println("text1:" + text);
        // if (cdata) {
        // writer.write("<![CDATA[");
        // writer.write(text);
        // writer.write("]]>");
        // } else {
        // writer.write(text);
        // }
        // }
        // };
        // }
        // });

        // xstream.alias("xml", MusciResponse.class);
        // xstream.processAnnotations(new Class[] { MusciResponse.class });
        XStream resXStream = new XStream(new XppDriver4CDATA());
        // XStream resXStream = new XStream(new XppDriver());
        resXStream.alias("xml", tr.getClass());
        // resXStream.registerConverter(new WxIntConverter());
        resXStream.registerConverter(new WxStringConverter());
        resXStream.processAnnotations(new Class[] { tr.getClass() });
        System.out.println("OneMp3ResponseController: \n" + resXStream.toXML(tr));
    }

    @Test
    public void testCreateTime() {
        Calendar c = Calendar.getInstance(Locale.CHINA);
        c.setTimeInMillis(1375234164);

        long msgId = 1234567890123456l;

        System.out.println(c.getTimeInMillis());
        System.out.println(Calendar.getInstance(Locale.CHINA).getTimeInMillis());
    }
}

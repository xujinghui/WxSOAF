package com.github.xujh.wxsoaf.sample;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import com.github.xujh.wxsoaf.utils.HttpUtils;

public class WeixinTextReqTestCase {

    public static final String URL = "http://127.0.0.1:8080/wxkm/wxkm";

    public WeixinTextReqTestCase() {

    }

    @Test
    public void testNoFoundController() throws IOException {
        InputStream is = WeixinTextReqTestCase.class.getClassLoader().getResourceAsStream(
                "com/github/xujh/wxsoaf/sample/weixin-text-error-req.txt");
        Assert.assertNotNull(is);
        String content = IOUtils.toString(is);
        is.close();
        // System.out.println(content);

        String res = HttpUtils.sendGet(WeixinTextReqTestCase.URL, content);
        System.out.println("Response Message: " + res);

    }

    @Test
    public void testA() throws IOException {
        WeixinTextReqTestCase w = new WeixinTextReqTestCase();
        String str1 = w.getContent();
        String res = HttpUtils.sendGet(WeixinTextReqTestCase.URL, str1);
        // System.out.println("abc" + str1);
    }

    public String getContent() {
        // StringBuilder sb = new StringBuilder();
        // sb.append("<xml>");
        // sb.append("<ToUserName><![CDATA[toUser]]></ToUserName>");
        // sb.append("<FromUserName><![CDATA[fromUser]]></FromUserName> ");
        // sb.append("<CreateTime>1348831860</CreateTime>");
        // sb.append("<MsgType><![CDATA[text]]></MsgType>");
        // sb.append("<Content><![CDATA[this is a test]]></Content>");
        // sb.append("<MsgId>1234567890123456</MsgId>");
        // sb.append("</xml>");
        // return sb.toString();
        // getResourceAsStream("com/../wexin-text-req.txt");
        try {
            InputStream is = WeixinTextReqTestCase.class.getClassLoader().getResourceAsStream(
                    "com/github//xujh/wxsoaf/sample/weixin-text-req.txt");
            Assert.assertNotNull(is);
            return IOUtils.toString(is);
            // InputStream bis = ByteArrayOutputStream.toBufferedInputStream(is);

            // List l = IOUtils.readLines(is);
            // System.out.println("l:" + l.size());

            // ByteArrayOutputStream baos = new ByteArrayOutputStream();
            // IOUtils.copy(is, baos);

            // return IOUtils.toString(IOUtils.toBufferedInputStream(bis));
            // return new String(baos.toByteArray());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "IOException: ";
    }

}

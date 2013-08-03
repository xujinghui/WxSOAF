/**
 * 
 */
package com.github.xujh.wxsoaf.sample;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import com.github.xujh.wxsoaf.utils.HttpUtils;

/**
 * @author stevenxu
 * 
 */
public class WxLinkReqTestCase {
    @Test
    public void testReq() throws IOException {
        InputStream is = WeixinTextReqTestCase.class.getClassLoader().getResourceAsStream(
                "com/github//xujh/wxsoaf/sample/weixin-link-req.txt");
        Assert.assertNotNull(is);
        String content = IOUtils.toString(is);
        // System.out.println(content);

        String res = HttpUtils.sendGet(WeixinTextReqTestCase.URL, content);
        System.out.println("Response Message: " + res);
    }
    
    
}

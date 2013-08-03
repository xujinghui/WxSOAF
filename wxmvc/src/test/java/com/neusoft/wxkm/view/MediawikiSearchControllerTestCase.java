package com.neusoft.wxkm.view;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import com.github.xujh.wxsoaf.sample.WeixinTextReqTestCase;
import com.github.xujh.wxsoaf.utils.HttpUtils;

public class MediawikiSearchControllerTestCase {

    @Test
    public void testHandleRequest() throws IOException {
        InputStream is = WeixinTextReqTestCase.class.getClassLoader().getResourceAsStream(
                "com/neusoft/wxkm/view/weixin-text-search-req.txt");
        Assert.assertNotNull(is);
        String content = IOUtils.toString(is);
         System.out.println(content);

        String res = HttpUtils.sendGet(WeixinTextReqTestCase.URL, content);
        System.out.println("Response Message: " + res);
    }

}

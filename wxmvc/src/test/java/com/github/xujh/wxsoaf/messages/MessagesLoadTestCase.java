package com.github.xujh.wxsoaf.messages;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessagesLoadTestCase {

    @Test
    public void test() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext(
                "classpath:com/github/xujh/wxsoaf/messages/spring-messages.xml");
        MessagesLoad msgLoad = (MessagesLoad) app.getBean("msgLoad");
        Assert.assertNotNull(msgLoad);
        System.out.println("msg: " + msgLoad.getResource());
        Assert.assertNotNull(msgLoad.getResource());
    }
}

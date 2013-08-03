package com.github.xujh.wxsoaf.annotation;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.xujh.wxsoaf.stereotype.WxController;

public class AnnotationInitTestCase {

	@Test
	public void test4LinkRequest() {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext(
				"classpath:com/github/xujh/wxsoaf/annotation/spring-controllers.xml");
		Map<String, Object> map = app
				.getBeansWithAnnotation(WxController.class);
		for (String name : map.keySet()) {
			System.out.println("name -->: " + name);
			WxController anno = app.findAnnotationOnBean(name,
					WxController.class);
			System.out.println(anno.toString());
			RequestType[] types = anno.type();
			for (RequestType type : types) {
				if (RequestType.link.equals(type)) {
					System.out.println(" name of type 1:" + type);
				} else {
					System.out.println(" name of type 2:" + type);
				}
			}
		}

	}

}

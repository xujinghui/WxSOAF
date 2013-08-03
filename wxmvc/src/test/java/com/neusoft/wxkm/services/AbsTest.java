package com.neusoft.wxkm.services;

import junit.framework.TestCase;
 
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public abstract class AbsTest extends TestCase{
	protected ApplicationContext aContext=null;
	public AbsTest()
	{
		
		
		try {
	
			 aContext = new ClassPathXmlApplicationContext("classpath:spring/mvc-core-config.xml");
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Object getService(String beanId)
	{
		   return aContext.getBean(beanId);
	}
}

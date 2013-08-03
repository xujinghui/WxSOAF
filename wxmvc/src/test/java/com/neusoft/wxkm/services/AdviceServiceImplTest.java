package com.neusoft.wxkm.services;

import org.junit.Test;

import com.neusoft.wxkm.services.intf.IAdviceService;




public class AdviceServiceImplTest extends AbsTest{
	IAdviceService adviceService = null;
	

public AdviceServiceImplTest() {
	super();
	try {
	
		this.adviceService = (IAdviceService)this.getService("adviceService");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}


@Test
public void testService()
{
	String userAlias="bai_sh";
	adviceService.service(userAlias,"提点建议！");
}


}

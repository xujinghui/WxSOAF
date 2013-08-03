package com.neusoft.wxkm.services;

import org.junit.Test;
import org.springframework.util.Assert;

import com.neusoft.wxkm.services.intf.IUserBindService;

public class UserBindServiceImplTest extends AbsTest {

	IUserBindService userBindService = null;

	public UserBindServiceImplTest() {
		userBindService = (IUserBindService) this.getService("userBindService");
	}
	@Test
	public void testBind()
	{
//		String result=userBindService.bind("bai_sh", "白爽", "200602013247");
//		Assert.isNull(result);
		
		userBindService.bind("niujie", "牛杰", "200707018985");
		
		
	}

}

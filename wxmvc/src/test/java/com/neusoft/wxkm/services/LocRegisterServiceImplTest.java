package com.neusoft.wxkm.services;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.neusoft.wxkm.model.BaiduLocation;
import com.neusoft.wxkm.services.intf.ILocRegisterService;
import com.neusoft.wxkm.services.intf.LocationVO;

public class LocRegisterServiceImplTest extends AbsTest{
	ILocRegisterService locRegService = new LocRegisterServiceImpl();

	public LocRegisterServiceImplTest() {

		try {
			this.locRegService = (ILocRegisterService)this.getService("locRegisterService");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetCityByLocation() {
		String userAlias="5533242";
		LocationVO locVo = getTestLocationVo();
		BaiduLocation location=locRegService.getLocation(locVo.getLocation_X(),locVo.getLocation_Y());
		Assert.assertNotNull("沈阳", location.getResult().getAddressComponent().getCity());
		Assert.assertNotNull(location.getResult().getAddressComponent().getStreet());
		Assert.assertNotNull(location.getResult().getAddressComponent().getDistrict());
		Assert.assertNotNull(location.getResult().getAddressComponent().getProvince());
		
		//System.out.println(city);
		
	}

	
	@Test
	public void testLocReg()
	{
		String userAlias="niujie";
		LocationVO locVo = getTestLocationVo();
		List list=locRegService.service(userAlias, locVo);
		String userAlias2="bai_sh";
		list=locRegService.service(userAlias2, locVo);
		Assert.assertTrue(list.size()>0);
		
	}
	private LocationVO getTestLocationVo() {
		LocationVO locVo=new LocationVO();
		locVo.setLocation_X("123.53151");
		locVo.setLocation_Y("41.57435");
		return locVo;
	}
	
}

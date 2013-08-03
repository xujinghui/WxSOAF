package com.neusoft.wxkm.services;

import java.io.IOException;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.ProxyHost;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang.StringUtils;

import com.neusoft.wxkm.mapper.locReg.LocationRegisterMapper;
import com.neusoft.wxkm.model.BaiduLocation;
import com.neusoft.wxkm.model.LocationRegister;
import com.neusoft.wxkm.model.User;
import com.neusoft.wxkm.model.UserLocationInfo;
import com.neusoft.wxkm.services.intf.ILocRegisterService;
import com.neusoft.wxkm.services.intf.LocationVO;
import com.neusoft.wxkm.utils.JsonUtil;

public class LocRegisterServiceImpl implements ILocRegisterService{
	LocationRegisterMapper locationRegisterMapper=null;

	public List<UserLocationInfo> service(String userAlias, LocationVO locVo) {
		

		UserLocationInfo userLocInfo=new UserLocationInfo();
		if(StringUtils.isBlank(locVo.getLocation_X())||StringUtils.isBlank(locVo.getLocation_Y())){
			throw new IllegalArgumentException("不能识别的经纬度！"+locVo.getLocation_X()+"  "+locVo.getLocation_Y()); 
		}
		userLocInfo.setLatitude(locVo.getLocation_Y());
		userLocInfo.setLongitude(locVo.getLocation_X());
		userLocInfo.setUserAlias(userAlias);
		String city=null;
		try {
			city=this.getLocation(userLocInfo.getLongitude(),userLocInfo.getLatitude()).getResult().getAddressComponent().getCity();
		} catch (Exception e) {
				e.printStackTrace();
				return null;
		}
		userLocInfo.setCity(city);
		List<UserLocationInfo> users=locationRegisterMapper.queryUsersByCity(city);
		locationRegisterMapper.delete(userLocInfo.getUserAlias());
		locationRegisterMapper.insert(userLocInfo.getLocation());
		return users;
	}
	

	public BaiduLocation getLocation(String longitude, String latitude){
		String jsonStr=getLocationJson(longitude,latitude);
		BaiduLocation loc=JsonUtil.getObject(jsonStr, BaiduLocation.class);
		return loc;
	}
	

	public String getLocationJson(String longitude, String latitude) {
	  
	        HttpClient httpClient = new HttpClient();
	        ProxyHost proxyHost = new ProxyHost("proxy.neusoft.com", 8080);
	        httpClient.getHostConfiguration().setProxyHost(proxyHost);
	        UsernamePasswordCredentials creds = new UsernamePasswordCredentials("bai_sh",
	                "CccBS221.4");
	        httpClient.getState().setProxyCredentials(AuthScope.ANY, creds);
	        String url = "http://api.map.baidu.com/geocoder?location=" + latitude + "," + longitude
	                + "&output=json&key=B91a77d0ad7481c5494d22d37128765c";
	        GetMethod httpGet = new GetMethod(url);
	        try {
	            int state = httpClient.executeMethod(httpGet);
	            if (state == HttpStatus.SC_OK) {
	                String charset = httpGet.getResponseCharSet();
	                String sbody = new String(httpGet.getResponseBody(), charset);
	                
	                return sbody;
	            }
	        } catch (HttpException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return null;
	    
	}


	public LocationRegisterMapper getLocationRegisterMapper() {
		return locationRegisterMapper;
	}


	public void setLocationRegisterMapper(
			LocationRegisterMapper locationRegisterMapper) {
		this.locationRegisterMapper = locationRegisterMapper;
	}


}

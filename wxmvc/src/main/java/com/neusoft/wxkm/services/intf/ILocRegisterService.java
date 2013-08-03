/**
 * 
 */
package com.neusoft.wxkm.services.intf;

import java.util.List;

import com.neusoft.wxkm.model.BaiduLocation;

/**
 * @author stevenxu
 * 
 */
public interface ILocRegisterService<T> {

    List<T> service(String userAlias, LocationVO req);

    String getLocationJson(String longitude, String latitude);

	public abstract BaiduLocation getLocation(String longitude, String latitude);
}

package com.neusoft.wxkm.mapper.locReg;

import java.util.List;

import com.neusoft.wxkm.model.LocationRegister;
import com.neusoft.wxkm.model.User;
import com.neusoft.wxkm.model.UserLocationInfo;


/**
 * 方法接口
 * @author Administrator
 *
 */
public interface LocationRegisterMapper {

	User find(String userAlias);

	void insert(LocationRegister userLocInfo);

	List<UserLocationInfo> queryUsersByCity(String city);
	
	void delete(String userAlias);
	


}

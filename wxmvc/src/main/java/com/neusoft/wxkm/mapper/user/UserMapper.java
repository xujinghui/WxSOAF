package com.neusoft.wxkm.mapper.user;

import com.neusoft.wxkm.model.User;


/**
 * 方法接口
 * @author Administrator
 *
 */
public interface UserMapper {

	User find(String employeeId);

	void insert(User user);

	User findBind(String userAlias);

	


}

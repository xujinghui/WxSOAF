package com.neusoft.wxkm.services;

import com.neusoft.wxkm.mapper.user.UserMapper;
import com.neusoft.wxkm.model.User;
import com.neusoft.wxkm.services.intf.IUserBindService;

public class UserBindServiceImpl implements IUserBindService{

	private UserMapper userMapper=null;
	
	public boolean addSubscriber(String userAlias, String createTime){
	    
	    return true;
	}

	@Override
	public boolean isBinded(String userAlias) {
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public synchronized String bind(String userAlias, String name, String employeeId) {


			User user = userMapper.findBind(userAlias);
			if (user != null) {
				return "该用户已绑定！";
			}
			user = userMapper.find(employeeId);
			if (user == null)
				return "该员工不存在！";
			try {
				user.setUserAlias(userAlias);
				userMapper.insert(user);
			} catch (Exception e) {
				e.printStackTrace();
				return "绑定时出错！:" + e.getMessage();
			}
		
		return null;
	}

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}




}

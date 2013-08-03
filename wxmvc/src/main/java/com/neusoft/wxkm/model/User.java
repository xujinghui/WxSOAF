package com.neusoft.wxkm.model;

public class User {
	private String bindId=null;
	private String name=null;

	private String employeeId=null;
	private String userAlias=null;
	private String emailPrefix=null;

	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getUserAlias() {
		return userAlias;
	}
	public void setUserAlias(String userAlias) {
		this.userAlias = userAlias;
	}
	public String getEmailPrefix() {
		return emailPrefix;
	}
	public void setEmailPrefix(String email) {
		this.emailPrefix = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBindId() {
		return bindId;
	}
	public void setBindId(String bindId) {
		this.bindId = bindId;
	}
	
}

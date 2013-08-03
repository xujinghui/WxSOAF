package com.neusoft.wxkm.model;

import com.neusoft.wxkm.services.intf.LocationVO;

public class UserLocationInfo {
private User user=new User();
private LocationRegister location=new LocationRegister();
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public LocationRegister getLocation() {
	return location;
}
public void setLocation(LocationRegister location) {
	this.location = location;
}
public String getEmployeeId() {
	return user.getEmployeeId();
}
public void setEmployeeId(String employeeId) {
	user.setEmployeeId(employeeId);
}
public String getUserAlias() {
	return user.getUserAlias();
}
public void setUserAlias(String userAlias) {
	user.setUserAlias(userAlias);
	location.setUserAlias(userAlias);
}
public String getEmailPrefix() {
	return user.getEmailPrefix();
}
public void setEmailPrefix(String email) {
	user.setEmailPrefix(email);
}
public String getName() {
	return user.getName();
}
public void setName(String name) {
	user.setName(name);
}
public String getLongitude() {
	return String.valueOf(location.getLongitude());
}
public void setLongitude(String longitude) {
	location.setLatitude(Double.valueOf(longitude));
}
public String getLatitude() {
	return String.valueOf(location.getLatitude());
}
public void setLatitude(String latitude) {
	location.setLatitude(Double.valueOf(latitude));
}
public String getCity() {
	return location.getCity();
}
public void setCity(String city) {
	location.setCity(city);
}

}

package com.neusoft.wxkm.model;

import java.util.Date;

public class LocationRegister {
	private String locId = null;
	private String userAlias = null;
	private double latitude = 0;
	private double longitude = 0;
	private String city = null;
	private Date timestamp=null;
	
	public String getUserAlias() {
		return userAlias;
	}

	public void setUserAlias(String employeeId) {
		this.userAlias = employeeId;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLocId() {
		return locId;
	}

	public void setLocId(String locId) {
		this.locId = locId;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}

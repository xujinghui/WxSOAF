package com.neusoft.wxkm.model;

public class Advice {
private String adviceId;
private String userAlias;
private String adviceContent;
private String timestamp;
public String getUserAlias() {
	return userAlias;
}
public void setUserAlias(String userAlias) {
	this.userAlias = userAlias;
}
public String getAdviceContent() {
	return adviceContent;
}
public void setAdviceContent(String adviceContent) {
	this.adviceContent = adviceContent;
}
public String getTimestamp() {
	return timestamp;
}
public void setTimestamp(String timeStamp) {
	this.timestamp = timeStamp;
}
public String getAdviceId() {
	return adviceId;
}
public void setAdviceId(String adviceId) {
	this.adviceId = adviceId;
}

}

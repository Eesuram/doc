package com.dealretail.model;


public class BaseBean {
	
	private long userId;
	private String userName;
	private boolean admin;
	private boolean signedIn;
	
	public boolean isSignedIn() {
		return signedIn;
	}
	public void setSignedIn(boolean signedIn) {
		this.signedIn = signedIn;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		return "BaseBean [userId=" + userId + ", userName=" + userName + "]";
	}
	
}

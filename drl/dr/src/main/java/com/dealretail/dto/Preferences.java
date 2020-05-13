package com.dealretail.dto;

import java.io.Serializable;

public class Preferences implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2360974322434063733L;
	
	private long id;
	private long userId;
	private boolean email;
	private boolean sms;
	private long mobile;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public boolean isEmail() {
		return email;
	}
	public void setEmail(boolean email) {
		this.email = email;
	}
	public boolean isSms() {
		return sms;
	}
	public void setSms(boolean sms) {
		this.sms = sms;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
	@Override
	public String toString() {
		return "Preferences [id=" + id + ", userId=" + userId + ", email="
				+ email + ", sms=" + sms + ", mobile=" + mobile + "]";
	}
	
	

}

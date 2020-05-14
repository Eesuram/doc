package com.personal.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Preferences implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2360974322434063733L;

	@Id
	private Long id;
	private Long userId;
	private boolean email;
	private boolean sms;
	private long mobile;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
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

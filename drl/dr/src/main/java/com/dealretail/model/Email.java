package com.dealretail.model;

public class Email {
	
	private String sender;
	private String password;
	private String[] recipients;
	private String subject;
	private String message;
	private String signature;
	
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String[] getRecipients() {
		return recipients;
	}
	public void setRecipients(String[] recipients) {
		this.recipients = recipients;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	

}

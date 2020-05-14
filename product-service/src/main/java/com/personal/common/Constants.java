package com.personal.common;

public interface Constants {
	
	String URL_READ_TIMEOUT = "10000";
	String USER_INFO = "USER_INFO";
	int ROLE_ADMIN = 1;
	int ROLE_USER = 2;

	String EMAIL_REGULAR_EXPRESSION="^[\\w\\.\\-\\_\\+]+@([\\w\\-]+\\.)+[a-zA-Z]{2,10}$";
	String NAME_REGULAR_EXPRESSION="^[a-zA-Z\\.\\ \\-\\']+$";
}

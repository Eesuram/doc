package com.dealretail.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;

import com.dealretail.common.Constants;
import com.dealretail.helper.EmailHelper;

public class CustomValidator {

	public static void rejectIfNotValidName(Errors errors, String fieldName) {
		if (null != errors.getFieldValue(fieldName)) {
			Pattern pattern = Pattern.compile(Constants.NAME_REGULAR_EXPRESSION);
			Matcher matcher = pattern.matcher((String) errors.getFieldValue(fieldName));
			
			if (!matcher.matches()) {
				errors.rejectValue(fieldName, "invalid");
			}
		}
	}
	
	public static void rejectIfNotValidEmail(Errors errors, String fieldName) {
		if (null != errors.getFieldValue(fieldName)) {
			String fieldValue = (String) errors.getFieldValue(fieldName);
			
			Pattern pattern = Pattern.compile(Constants.EMAIL_REGULAR_EXPRESSION);
			Matcher matcher = pattern.matcher(fieldValue);
			
			if (!matcher.matches()) {
				errors.rejectValue(fieldName, "invalid");
			}
		}
	}
	
}

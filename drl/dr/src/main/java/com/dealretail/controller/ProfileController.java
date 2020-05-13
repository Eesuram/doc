package com.dealretail.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dealretail.common.Constants;
import com.dealretail.dao.UserDAO;
import com.dealretail.dto.User;
import com.dealretail.helper.CookieHelper;
import com.dealretail.helper.EmailHelper;
import com.dealretail.validator.CustomValidator;

@Controller
public class ProfileController {

	@RequestMapping(method=RequestMethod.GET)
	public String showProfile(User user, HttpServletRequest request, HttpServletResponse response) {
		return "profile";
	}

	@RequestMapping(value = "/adduser", method=RequestMethod.POST)
	public @ResponseBody User addUser(@ModelAttribute User user, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
		boolean success = false;
		validateUser(result);
		
		if (result.hasErrors()) {
			List<String> errors = pushErrors(result);
			user.setErrors(errors);
			return user;
		}/* else if (!emailHelper.isActive(user.getEmail())) {
			result.rejectValue("email", "inactive");
			return "";
		}*/
		
		success = userDAO.addUser(user);
		
		if (success) {
			HttpSession session = request.getSession(true);
			session.setAttribute(Constants.USER_INFO, user);
		} 
		
		return user;
	}
	
	private List<String> pushErrors(BindingResult result) {
		// TODO Auto-generated method stub
		List<String> errors = new ArrayList<String>();
		if (result.getFieldErrorCount() > 0) {
			List<FieldError> fieldErrors = result.getFieldErrors();
			for (FieldError fieldError : fieldErrors) {
				errors.add(messageSource.getMessage(fieldError.getCodes()[1], null, null));
			}
		}
		return errors;
	}

	private void validateUser(BindingResult result) {
		// TODO Auto-generated method stub
		validateRequiredFields(result);
		
		if (!result.hasErrors()) {
			validateOtherRules(result);
		}
	}

	private void validateOtherRules(BindingResult result) {
		CustomValidator.rejectIfNotValidName(result, "firstName");
		CustomValidator.rejectIfNotValidName(result, "lastName");
		CustomValidator.rejectIfNotValidEmail(result, "email");
	}

	private void validateRequiredFields(BindingResult result) {
		ValidationUtils.rejectIfEmptyOrWhitespace(result, "firstName", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(result, "lastName", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(result, "email", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(result, "password", "required");
	}

	@RequestMapping(value = "/signin", method=RequestMethod.POST)
	public String authenticateUser(String email, String password, HttpServletRequest request, HttpServletResponse response) {
		User user = null;
		
		if (null != email && null != password) {
			user = userDAO.getUser(email, password);
		}
		
		if (null != user) {
			HttpSession session = request.getSession(true);
			session.setAttribute(Constants.USER_INFO, user);
		}
		
		return "welcomeR";
	}
	
	@RequestMapping(value = "/signout", method=RequestMethod.GET)
	public String signOutUser(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession(false);
		session.removeAttribute(Constants.USER_INFO);
		
		return "welcomeR";
	}
	
	@RequestMapping(value = "/updateuser", method=RequestMethod.POST)
	public String updateUser(HttpServletRequest request, HttpServletResponse response) {
		return "welcomeR";
	}
	
	@Autowired
	private UserDAO userDAO;

	@Autowired
	private CookieHelper cookieHelper;

	@Autowired
	private EmailHelper emailHelper;
	
	@Autowired
	private MessageSource messageSource;
}

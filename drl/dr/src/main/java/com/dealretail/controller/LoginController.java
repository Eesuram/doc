package com.dealretail.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(HttpServletRequest request, HttpServletResponse response) {
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processLogin(HttpServletRequest request, HttpServletResponse response) {
		return "welcome";
	}
	
}

package com.dealretail.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dealretail.common.ApplicationData;
import com.dealretail.dto.Category;
import com.dealretail.helper.AdminHelper;

@Controller
public class ManageCategoriesController {

	@RequestMapping (value="/managecategories", method=RequestMethod.GET)
	public String showCategories(HttpServletRequest request, HttpServletResponse response) {
		return "managecategories";
	}

	@RequestMapping (value = "/addcategory", method=RequestMethod.POST)
	public String addCategory(Category category,
			HttpServletRequest request, HttpServletResponse response) {
		if (null != category) {
			adminHelper.addCategory(category);
			ApplicationData.categories = null;
		}
		return "managecategoriesR";
	}

	@RequestMapping (value = "/removecategory", method=RequestMethod.POST)
	public String removeCategory(@RequestParam (value = "category") String categoryId, 
			HttpServletRequest request, HttpServletResponse response) {
		if (StringUtils.isNotEmpty(categoryId)) {
			adminHelper.removeCategorySiteByCategory(categoryId);
			adminHelper.removeCategory(categoryId);
			ApplicationData.categories = null;
		}
		return "managecategoriesR";
	}

	@Autowired
	private AdminHelper adminHelper;
	
}

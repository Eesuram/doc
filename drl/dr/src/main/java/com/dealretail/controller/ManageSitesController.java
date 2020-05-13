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
import com.dealretail.dto.Site;
import com.dealretail.helper.AdminHelper;

@Controller
public class ManageSitesController {

	@RequestMapping (value = "/managesites", method=RequestMethod.GET)
	public String showSites(HttpServletRequest request, HttpServletResponse response) {
		return "managesites";
	}

	@RequestMapping (value = "/addsite", method=RequestMethod.POST)
	public String addSite(Site site,
			HttpServletRequest request, HttpServletResponse response) {
		if (null != site) {
			adminHelper.addSite(site);
			ApplicationData.sites = null;
		}
		return "managesitesR";
	}

	@RequestMapping (value = "/removesite", method=RequestMethod.POST)
	public String removeSite(@RequestParam (value = "site") String siteId, 
			HttpServletRequest request, HttpServletResponse response) {
		if (StringUtils.isNotEmpty(siteId)) {
			adminHelper.removeCategorySiteBySite(siteId);
			adminHelper.removeSite(siteId);
			ApplicationData.sites = null;
		}
		
		return "managesitesR";
	}
	
	@Autowired
	private AdminHelper adminHelper;

}

package com.dealretail.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dealretail.helper.ProductHelper;

@Controller
@RequestMapping("/redirect")
public class RedirectController {
	
	Log log = LogFactory.getLog(RedirectController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public String redirectToSite(@RequestParam String productId, HttpServletResponse response) {
		if (log.isDebugEnabled()) {
			log.debug("START :: Redirecting Product :: " + productId);
		}
		
		String redirectURL = productHelper.getProductURL(productId);
		productHelper.updateSiteCounter(productId);
		redirectURL = attachSignature(redirectURL);
		
		try {
			response.sendRedirect(redirectURL);
		} catch (IOException e) {
			log.error("Failed to redirect to the page :: " + redirectURL, e);
		}

		if (log.isDebugEnabled()) {
			log.debug("END :: Redirecting to the Page :: " + redirectURL);
		}
		
		return null;
	}
	

	private String attachSignature(String url) {
		if (url.indexOf("?") != -1) {
			url = url + "&source=doc";
		} else {
			url = url + "?source=doc";
		}
		return url;
	}
	
	@Autowired
	private ProductHelper productHelper;

}

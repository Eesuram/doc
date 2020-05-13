package com.dealretail.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dealretail.helper.ProductHelper;

@Controller
public class RefreshProductsController {

	@RequestMapping (value="/refreshproducts", method=RequestMethod.GET)
	public String showProducts(HttpServletRequest request, HttpServletResponse response) {
		int count = productHelper.getProductCount();
		request.setAttribute("productCount", count);
		
		return "refreshproducts";
	}

	@RequestMapping (value="/refreshproducts", method=RequestMethod.POST)
	public String refreshAllProducts(HttpServletRequest request, HttpServletResponse response) {
		productHelper.refreshProducts();
		return "refreshproductsR";
	}

	@RequestMapping (value = "/category", method=RequestMethod.POST)
	public String refreshProductsByCategory(@RequestParam (value="category") String catId,
			HttpServletRequest request, HttpServletResponse response) {
		return "refreshproducts";
	}

	@RequestMapping (value = "/site", method=RequestMethod.POST)
	public String refreshProductsBySite(@RequestParam (value = "site") String siteId,
			HttpServletRequest request, HttpServletResponse response) {
		return "refreshproducts";
	}

	@RequestMapping (value = "/refreshproductscs", method=RequestMethod.POST)
	public String refreshProductsByCategorySite(@RequestParam (value="category") String catId,
			@RequestParam (value = "site") String siteId,
			HttpServletRequest request, HttpServletResponse response) {
		productHelper.refreshProducts(catId, siteId);
		return "refreshproductsR";
	}

	@Autowired
	private ProductHelper productHelper;
}

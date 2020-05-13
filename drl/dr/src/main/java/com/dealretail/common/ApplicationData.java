package com.dealretail.common;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dealretail.dto.Category;
import com.dealretail.dto.CategorySite;
import com.dealretail.dto.Site;
import com.dealretail.helper.AdminHelper;
@Component
public class ApplicationData {

	@PostConstruct
	public void init() {
		getCategories();
		getSites();
		getCategorySites();
	}
	
	public List<Category> getCategories() {
		if (CollectionUtils.isNotEmpty(categories)) {
			return categories;
		}
		
		categories = adminHelper.getAllCategories();
		
		return categories;
	}
	
	public List<Site> getSites() {
		if (CollectionUtils.isNotEmpty(sites)) {
			return sites;
		}
		
		sites = adminHelper.getAllSites();
		
		return sites;
	}
	
	public List<CategorySite> getCategorySites() {
		if (CollectionUtils.isNotEmpty(categorySites)) {
			return categorySites;
		}
		
		categorySites = adminHelper.getAllCategorySites();
		
		return categorySites;
	}
	
	public static List<Category> categories;
	
	public static List<Site> sites;

	public static List<CategorySite> categorySites;

	@Autowired
	private AdminHelper adminHelper;

}

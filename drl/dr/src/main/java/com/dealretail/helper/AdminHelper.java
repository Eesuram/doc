package com.dealretail.helper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dealretail.dao.AdminDAO;
import com.dealretail.dto.Category;
import com.dealretail.dto.CategorySite;
import com.dealretail.dto.Site;

@Component
public class AdminHelper {

	public List<Category> getAllCategories() {
		return adminDAO.getCategories();
	}
	
	public List<Site> getAllSites() {
		return adminDAO.getSites();
	}
	
	public List<CategorySite> getAllCategorySites() {
		return adminDAO.getCategorySites();
	}
	
	public void addCategory(Category category) {
		adminDAO.addCategory(category);
	}
	
	public void addSite(Site site) {
		adminDAO.addSite(site);
	}
	
	public void addCategorySite(CategorySite categorySite) {
		adminDAO.addCategorySite(categorySite);
	}
	
	public void removeCategory(String catId) {
		adminDAO.removeCategory(Integer.parseInt(catId));
	}
	
	public void removeSite(String siteId) {
		adminDAO.removeSite(Integer.parseInt(siteId));
	}
	
	public void removeCategorySite(String catId, String siteId) {
		adminDAO.removeCategorySite(Integer.parseInt(catId), 
				Integer.parseInt(siteId));
	}
	
	public void removeCategorySiteBySite(String siteId) {
		adminDAO.removeCategorySiteBySite(Integer.parseInt(siteId));
	}
	
	public void removeCategorySiteByCategory(String catId) {
		adminDAO.removeCategorySiteByCategory(Integer.parseInt(catId));
	}
	
	@Autowired
	private AdminDAO adminDAO;
}

package com.dealretail.model;

import java.util.List;

import com.dealretail.dto.CategorySite;

public class CategorySiteBean extends BaseBean {
	
	private List<CategorySiteVO> allCategorySites;
	private CategorySite newCategorySite;
	
	public List<CategorySiteVO> getAllCategorySites() {
		return allCategorySites;
	}
	public void setAllCategorySites(List<CategorySiteVO> allCategorySites) {
		this.allCategorySites = allCategorySites;
	}
	public CategorySite getNewCategorySite() {
		return newCategorySite;
	}
	public void setNewCategorySite(CategorySite newCategorySite) {
		this.newCategorySite = newCategorySite;
	}
	
	@Override
	public String toString() {
		return "CategorySiteBean [allCategorySites=" + allCategorySites
				+ ", newCategorySite=" + newCategorySite + "]";
	}

	
}

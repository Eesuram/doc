package com.dealretail.dao;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.dealretail.common.Constants;
import com.dealretail.dto.Category;
import com.dealretail.dto.CategorySite;
import com.dealretail.dto.Site;
import com.dealretail.dto.mapper.CategoryMapper;
import com.dealretail.dto.mapper.CategorySiteMapper;
import com.dealretail.dto.mapper.SiteMapper;

@Component
public class AdminDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Category> getCategories() {
		return this.jdbcTemplate.query(Constants.GET_ALL_CATEGORIES, new CategoryMapper());
	}

	public List<Site> getSites() {
		return this.jdbcTemplate.query(Constants.GET_ALL_SITES, new SiteMapper());
	}

	public List<CategorySite> getCategorySites() {
		return this.jdbcTemplate.query(
				Constants.GET_ALL_CATEGORY_SITES, new CategorySiteMapper());
	}

	public List<CategorySite> getCategorySitesByCategory(int catId) {
		return this.jdbcTemplate.query(
				Constants.GET_CATEGORY_SITES_BY_CATEGORY_ID, new CategorySiteMapper(), catId);
	}

	public List<CategorySite> getCategorySitesBySite(int siteId) {
		return this.jdbcTemplate.query(
				Constants.GET_CATEGORY_SITES_BY_SITE_ID, new CategorySiteMapper(), siteId);
	}

	public List<CategorySite> getCategorySites(int catId, int siteId) {
		return this.jdbcTemplate.query(
				Constants.GET_CATEGORY_SITES_BY_CATEGORY_SITE_ID, new CategorySiteMapper(), catId, siteId);
	}

	public void updateSiteCounter(String productId) {
		this.jdbcTemplate.update(Constants.UPDATE_SITE_COUNTER, productId);		
	}
	
	public void addSite(Site site) {
		this.jdbcTemplate.update(Constants.INSERT_SITE, 
				site.getSiteId(), site.getSiteName(), site.getSiteLink(), site.getSiteDescription(), 0);
	}
	
	public void addCategory(Category category) {
		this.jdbcTemplate.update(Constants.INSERT_CATEGORY, category.getCatId(), category.getCatName());
	}
	
	public void addCategorySite(CategorySite categorySite) {
		this.jdbcTemplate.update(Constants.INSERT_CATEGORY_SITE, categorySite.getCatId(),
				categorySite.getSiteId(), categorySite.getBrowseLink(), categorySite.getProductKeyword(),
				categorySite.getImageKeyword(), categorySite.getOrgPriceKeyword(), categorySite.getSalePriceKeyword(),
				categorySite.getDescriptionKeyword(), categorySite.getRedirectionKeyword(), 
				categorySite.getItemCountKeyword(), categorySite.getPaginationUrl(), categorySite.getItemsPerPage(), 0);
	}
	
	public void removeSite(int siteId) {
		this.jdbcTemplate.update(Constants.REMOVE_SITE, siteId);
	}
	
	public void removeCategory(int catId) {
		this.jdbcTemplate.update(Constants.REMOVE_CATEGORY, catId);
	}
	
	public void removeCategorySite(int catId, int siteId) {
		this.jdbcTemplate.update(Constants.REMOVE_CATEGORY_SITE, catId, siteId);
	}

	public void removeCategorySiteByCategory(int catId) {
		this.jdbcTemplate.update(Constants.REMOVE_CATEGORY_SITE_BY_CATEGORY, catId);
	}

	public void removeCategorySiteBySite(int siteId) {
		this.jdbcTemplate.update(Constants.REMOVE_CATEGORY_SITE_BY_SITE, siteId);
	}
}

package com.dealretail.dto.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dealretail.dto.CategorySite;

public class CategorySiteMapper implements RowMapper<CategorySite> {

	public CategorySite mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		CategorySite categorySite = new CategorySite();
		
		categorySite.setCatId(rs.getInt("cat_id"));
		categorySite.setSiteId(rs.getInt("site_id"));
		categorySite.setBrowseLink(rs.getString("browse_link"));
		categorySite.setProductKeyword(rs.getString("product_keyword"));
		categorySite.setImageKeyword(rs.getString("image_keyword"));
		categorySite.setOrgPriceKeyword(rs.getString("org_price_keyword"));
		categorySite.setSalePriceKeyword(rs.getString("sale_price_keyword"));
		categorySite.setDescriptionKeyword(rs.getString("description_keyword"));
		categorySite.setRedirectionKeyword(rs.getString("redirection_keyword"));
		categorySite.setPaginationUrl(rs.getString("pagination_url"));
		categorySite.setItemsPerPage(rs.getInt("items_per_page"));
		categorySite.setItemCountKeyword(rs.getString("item_count_keyword"));
		categorySite.setCounter(rs.getInt("counter"));
		
		return categorySite;
	}
	
	

}

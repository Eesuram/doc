package com.dealretail.dto.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dealretail.dto.Product;

public class ProductMapper implements RowMapper<Product> {

	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Product product = new Product();
		
		product.setProductId(rs.getInt("product_id"));
		product.setSiteId(rs.getInt("site_id"));
		product.setCatId(rs.getInt("cat_id"));
		product.setImageLink(rs.getString("image_link"));
		product.setOrgPrice(rs.getFloat("org_price"));
		product.setProductLink(rs.getString("product_link"));
		product.setProductName(rs.getString("product_name"));
		product.setSalePrice(rs.getFloat("sale_price"));
		product.setSavings(rs.getFloat("savings"));
		
		return product;
	}
	
}

package com.dealretail.dto.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dealretail.dto.Category;

public class CategoryMapper implements RowMapper<Category> {

	@Override
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Category category = new Category();
		
		category.setCatId(rs.getInt("cat_id"));
		category.setCatName(rs.getString("cat_name"));
		
		return category;
	}

}

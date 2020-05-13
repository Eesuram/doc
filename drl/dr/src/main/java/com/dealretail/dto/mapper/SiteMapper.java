package com.dealretail.dto.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dealretail.dto.Site;

public class SiteMapper implements RowMapper<Site> {

	@Override
	public Site mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Site site = new Site();
		
		site.setSiteId(rs.getInt("site_id"));
		site.setSiteName(rs.getString("site_name"));
		site.setSiteLink(rs.getString("site_link"));
		site.setSiteDescription(rs.getString("site_description"));
		site.setCounter(rs.getInt("counter"));
		
		return site;
	}
	

}

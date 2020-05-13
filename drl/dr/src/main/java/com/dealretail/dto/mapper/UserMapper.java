package com.dealretail.dto.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dealretail.dto.User;

public class UserMapper implements RowMapper<User> {

	private boolean includePreferences;
	
	public boolean isIncludePreferences() {
		return includePreferences;
	}

	public void setIncludePreferences(boolean includePreferences) {
		this.includePreferences = includePreferences;
	}

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		User user = new User();
		
		user.setId(rs.getInt("id"));
		user.setAddressLine1(rs.getString("address_line1"));
		user.setAddressLine2(rs.getString("address_line2"));
		user.setCity(rs.getString("city"));
		user.setCountry(rs.getString("country"));
		user.setEmail(rs.getString("email"));
		user.setFirstName(rs.getString("first_name"));
		user.setLastName(rs.getString("last_name"));
		user.setPassword(rs.getString("password"));
		
		if (includePreferences) {
			user.setPreferences(
					new PreferencesMapper().mapRow(rs, rowNum));
		}
		
		user.setPrivilegeId(rs.getInt("privilege_id"));
		user.setState(rs.getString("state"));
		user.setZipCode(rs.getString("zip_code"));
		
		return user;
	}

}

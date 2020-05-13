package com.dealretail.dto.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dealretail.dto.Preferences;

public class PreferencesMapper implements RowMapper<Preferences> {

	@Override
	public Preferences mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Preferences preferences = new Preferences();
		
		preferences.setId(rs.getInt("preference_id"));
		preferences.setUserId(rs.getInt("user_id"));
		preferences.setEmail(rs.getBoolean("email_pref"));
		preferences.setSms(rs.getBoolean("sms_pref"));
		preferences.setMobile(rs.getLong("mobile"));
		
		return preferences;
	}
	

}

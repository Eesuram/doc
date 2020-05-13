package com.dealretail.dto.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dealretail.dto.Privilege;

public class PrivilegeMapper implements RowMapper<Privilege> {

	@Override
	public Privilege mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Privilege privilege = new Privilege();
		
		privilege.setId(rs.getInt("privilege_id"));
		privilege.setName(rs.getString("name"));
		privilege.setDescription(rs.getString("description"));
		
		return privilege;
	}

}

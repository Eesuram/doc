package com.dealretail.dao;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.dealretail.common.Constants;
import com.dealretail.dto.User;
import com.dealretail.dto.mapper.UserMapper;

@Component
public class UserDAO {

	Log log = LogFactory.getLog(UserDAO.class);

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public boolean addUser(User user) {
		int rows = this.jdbcTemplate.update(Constants.ADD_NEW_USER, 
				user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
		
		if (rows > 0) {
			return true;
		}
		
		return false;
	}

	public User getUser(String email, String password) {
		return this.jdbcTemplate.queryForObject(Constants.GET_USER_BY_LOGIN_CR, new UserMapper(), email, password);
	}

	public User getUserWithPreferences(String email, String password) {
		UserMapper mapper = new UserMapper();
		mapper.setIncludePreferences(true);
		
		return this.jdbcTemplate.queryForObject(Constants.GET_USER_WITH_PREFERENCES, mapper, email, password);
	}
}

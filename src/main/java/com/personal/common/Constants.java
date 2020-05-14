package com.personal.common;

public interface Constants {
	
	String URL_READ_TIMEOUT = "10000";
	String USER_INFO = "USER_INFO";
	int ROLE_ADMIN = 1;
	int ROLE_USER = 2;

	String EMAIL_REGULAR_EXPRESSION="^[\\w\\.\\-\\_\\+]+@([\\w\\-]+\\.)+[a-zA-Z]{2,10}$";
	String NAME_REGULAR_EXPRESSION="^[a-zA-Z\\.\\ \\-\\']+$";

	// SQL Queries
	String GET_ALL_CATEGORIES = "SELECT * FROM sale.category";
	String GET_ALL_SITES = "SELECT * FROM sale.site";
	String GET_ALL_CATEGORY_SITES = "SELECT * FROM sale.category_site";
	String GET_CATEGORY_SITES_BY_SITE_ID = "SELECT * FROM sale.category_site WHERE SITE_ID = ?";
	String GET_CATEGORY_SITES_BY_CATEGORY_ID = "SELECT * FROM sale.category_site WHERE CAT_ID = ?";
	String GET_CATEGORY_SITES_BY_CATEGORY_SITE_ID = "SELECT * FROM sale.category_site WHERE CAT_ID = ? AND SITE_ID = ?";
	
	String REMOVE_ALL_PRODUCTS = "DELETE FROM sale.product";
	String REMOVE_PRODUCT_BY_ID = "DELETE FROM sale.product WHERE PRODUCT_ID = ?";
	String REMOVE_PRODUCT_BY_CATEGORY_ID = "DELETE FROM sale.product WHERE CAT_ID = ?";
	String REMOVE_PRODUCT_BY_SITE_ID = "DELETE FROM sale.product WHERE SITE_ID = ?";
	String REMOVE_PRODUCT_BY_CATEGORY_SITE_ID = "DELETE FROM sale.product WHERE CAT_ID = ? AND SITE_ID = ?";
	
	String INSERT_CATEGORY = "INSERT INTO sale.category (CAT_ID, CAT_NAME) VALUES (?, ?)";	
	String INSERT_SITE = "INSERT INTO sale.site "
			+ "(SITE_ID, SITE_NAME, SITE_LINK, SITE_DESCRIPTION, COUNTER) VALUES (?, ?, ?, ?, ?)";
	
	String INSERT_CATEGORY_SITE = "INSERT INTO sale.category_site "
			+ "(CAT_ID, SITE_ID, BROWSE_LINK, PRODUCT_KEYWORD, IMAGE_KEYWORD, ORG_PRICE_KEYWORD, "
			+ "SALE_PRICE_KEYWORD, DESCRIPTION_KEYWORD, "
			+ "REDIRECTION_KEYWORD, ITEM_COUNT_KEYWORD, PAGINATION_URL, ITEMS_PER_PAGE, COUNTER) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	String INSERT_PRODUCT = "INSERT INTO sale.product "
			+ "(PRODUCT_NAME, PRODUCT_LINK, IMAGE_LINK, ORG_PRICE, SALE_PRICE, SAVINGS, SITE_ID, CAT_ID) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	
	String REMOVE_CATEGORY = "DELETE FROM sale.category WHERE CAT_ID = ?";
	String REMOVE_SITE = "DELETE FROM sale.site WHERE SITE_ID = ?";
	String REMOVE_CATEGORY_SITE = "DELETE FROM sale.category_site WHERE CAT_ID = ? AND SITE_ID = ?";
	String REMOVE_CATEGORY_SITE_BY_CATEGORY = "DELETE FROM sale.category_site WHERE CAT_ID = ?";
	String REMOVE_CATEGORY_SITE_BY_SITE = "DELETE FROM sale.category_site WHERE SITE_ID = ?";
	
	String GET_ALL_PRODUCTS = "SELECT * FROM sale.product";
	String GET_PRODUCTS_BY_CATEGORY = "SELECT * FROM sale.product WHERE CAT_ID = ?";
	String GET_PRODUCTS_BY_SITE = "SELECT * FROM sale.product WHERE SITE_ID = ?";
	String GET_PRODUCTS_BY_CATEGORY_SITE = "SELECT * FROM sale.product WHERE CAT_ID = ? AND SITE_ID = ?";
	String GET_PRODUCT_BY_ID = "SELECT * FROM sale.product WHERE PRODUCT_ID = ?";
	String GET_PRODUCT_BY_PRODUCT_NAME = "SELECT * FROM sale.product WHERE to_lowercase(PRODUCT_NAME) LIKE '%to_lowercase(?)%'";
	
	String GET_PRODUCTS_BY_PRICE_RANGE = "SELECT * FROM sale.product WHERE SALE_PRICE BETWEEN ? AND ?"; 
	String GET_PRODUCTS_BY_SAVINGS = "SELECT * FROM sale.product WHERE SAVINGS >= ?"; 
	String GET_PRODUCT_REDIRECT_URL = "SELECT PRODUCT_LINK FROM sale.product WHERE PRODUCT_ID = ?";
	
	String UPDATE_SITE_COUNTER = "UPDATE sale.site S SET S.COUNTER = S.COUNTER + 1 WHERE S.SITE_ID = "
			+ "(SELECT P.SITE_ID FROM sale.product P WHERE P.PRODUCT_ID = ?)";

	String RESET_PRODUCT_ID_SEQ_TO_ONE = "ALTER TABLE sale.product AUTO_INCREMENT = 1";

	String GET_PRODUCT_COUNT = "SELECT COUNT(*) FROM sale.product";
	
	String ADD_NEW_USER = "INSERT INTO sale.user (FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, PRIVILEGE_ID) VALUES (?, ?, ?, ?, 2)";

	String GET_USER_BY_LOGIN_CR = "SELECT * FROM sale.user WHERE EMAIL = ? AND PASSWORD = ?";

	String GET_USER_WITH_PREFERENCES = "SELECT * FROM sale.user U, sale.preferences P WHERE U.EMAIL = ? AND U.PASSWORD = ?"
			+ " AND U.ID = P.USER_ID";

}

package com.dealretail.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.dealretail.common.Constants;
import com.dealretail.dto.Product;
import com.dealretail.dto.mapper.ProductMapper;
import com.dealretail.helper.ProductHelper;

@Component
public class ProductDAO {

	Log log = LogFactory.getLog(ProductDAO.class);

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Product> getAllProducts() {
		return this.jdbcTemplate.query(Constants.GET_ALL_PRODUCTS,
				new ProductMapper());
	}

	public List<Product> getAllProducts(final int pageNumber, final int pageSize) {
		return this.jdbcTemplate.query(Constants.GET_ALL_PRODUCTS,
				new ProductMapper());
	}

	public Product getProductById(long productId) {
		return this.jdbcTemplate.queryForObject(Constants.GET_PRODUCT_BY_ID,
				new ProductMapper(), productId);
	}

	public List<Product> getProductByProductName(String productName) {
		return this.jdbcTemplate.query(Constants.GET_PRODUCT_BY_PRODUCT_NAME,
				new ProductMapper(), productName);
	}

	public List<Product> getProductByCategory(long categoryId) {
		return this.jdbcTemplate.query(Constants.GET_PRODUCTS_BY_CATEGORY,
				new ProductMapper(), categoryId);
	}

	public List<Product> getProductBySite(long siteId) {
		return this.jdbcTemplate.query(Constants.GET_PRODUCTS_BY_SITE,
				new ProductMapper(), siteId);
	}

	public List<Product> getProductByCategorySite(long categoryId, long siteId) {
		return this.jdbcTemplate.query(Constants.GET_PRODUCTS_BY_CATEGORY_SITE,
				new ProductMapper(), categoryId, siteId);
	}

	public List<Product> getProductByPriceRange(float startPrice, float endPrice) {
		return this.jdbcTemplate.query(Constants.GET_PRODUCTS_BY_PRICE_RANGE,
				new ProductMapper(), startPrice, endPrice);
	}

	public List<Product> getProductBySavings(float savings) {
		return this.jdbcTemplate.query(Constants.GET_PRODUCTS_BY_SAVINGS,
				new ProductMapper(), savings);
	}

	public List<Product> getProductsBySearchCriteria(String searchCriteria) {
		String sqlQuery = Constants.GET_ALL_PRODUCTS + searchCriteria;
		return this.jdbcTemplate.query(sqlQuery, new ProductMapper());
	}

	public List<Product> getProductsBySearchCriteria(String searchCriteria, final int pageNumber, final int pageSize) {
		String sqlQuery = Constants.GET_ALL_PRODUCTS + searchCriteria;
		sqlQuery += " LIMIT ";
		sqlQuery = sqlQuery + ((pageNumber - 1) * pageSize) + ", " + pageSize;  
		return this.jdbcTemplate.query(sqlQuery, new ProductMapper());
	}

	public void removeAllProducts() {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update(Constants.REMOVE_ALL_PRODUCTS);
	}

	public void removeProductById(long productId) {
		this.jdbcTemplate.update(Constants.REMOVE_PRODUCT_BY_ID, productId);
	}

	public void removeProductsByCategory(long categoryId) {
		this.jdbcTemplate.update(Constants.REMOVE_PRODUCT_BY_CATEGORY_ID,
				categoryId);
	}

	public void removeProductsBySite(long siteId) {
		this.jdbcTemplate.update(Constants.REMOVE_PRODUCT_BY_SITE_ID, siteId);
	}

	public void removeProductsByCategorySite(long categoryId, long siteId) {
		this.jdbcTemplate.update(Constants.REMOVE_PRODUCT_BY_CATEGORY_SITE_ID,
				categoryId, siteId);
	}

	public void updateProducts(final List<Product> products) {
		if (CollectionUtils.isNotEmpty(products)) {
			this.jdbcTemplate.batchUpdate(Constants.INSERT_PRODUCT,
					new BatchPreparedStatementSetter() {

						public void setValues(PreparedStatement ps, int i) {
							try {
								// TODO Auto-generated method stub
								Product product = products.get(i);
								ps.setString(1, product.getProductName());
								ps.setString(2, product.getProductLink());
								ps.setString(3, product.getImageLink());
								ps.setFloat(4, product.getOrgPrice());
								ps.setFloat(5, product.getSalePrice());
								ps.setFloat(6, product.getSavings());
								ps.setLong(7, product.getSiteId());
								ps.setLong(8, product.getCatId());
							} catch (SQLException se) {
								log.error("Error in SQL update :: " + products,
										se);
							}
						}

						public int getBatchSize() {
							// TODO Auto-generated method stub
							return products.size();
						}

					});
		}
	}

	public String getProductRedirectURL(String productId) {
		return this.jdbcTemplate.queryForObject(
				Constants.GET_PRODUCT_REDIRECT_URL, new Object[] { productId },
				String.class);
	}

	public void resetProductIdIncrementer() {
		this.jdbcTemplate.execute(Constants.RESET_PRODUCT_ID_SEQ_TO_ONE);
	}

	public int getProductCount() {
		return this.jdbcTemplate.queryForInt(Constants.GET_PRODUCT_COUNT);
	}

	public int getProductCount(String searchCriteria) {
		return this.jdbcTemplate.queryForInt(Constants.GET_PRODUCT_COUNT + searchCriteria);
	}
}

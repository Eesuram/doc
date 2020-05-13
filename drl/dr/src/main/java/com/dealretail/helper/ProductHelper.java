package com.dealretail.helper;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.dealretail.dao.AdminDAO;
import com.dealretail.dao.ProductDAO;
import com.dealretail.dto.CategorySite;
import com.dealretail.dto.Product;

@Component
public class ProductHelper {

	Log log = LogFactory.getLog(ProductHelper.class);

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private AdminDAO adminDAO;

	public void refreshProducts() {
		List<CategorySite> categorySites = adminDAO.getCategorySites();

		if (CollectionUtils.isEmpty(categorySites)) {
			return;
		}

		productDAO.removeAllProducts();
		productDAO.resetProductIdIncrementer();

	}

	public List<Product> getProductsByCategory(String categoryId) {
		return productDAO.getProductByCategory(Long.parseLong(categoryId));
	}

	public List<Product> getProductsBySearchKey(String searchKey) {
		return productDAO.getProductByProductName(searchKey);
	}

	public List<Product> getProductsByPriceRange(String startPrice,
			String endPrice) {
		return productDAO.getProductByPriceRange(Float.parseFloat(startPrice),
				Float.parseFloat(endPrice));
	}

	public List<Product> getProductsBySavings(String savings) {
		return productDAO.getProductBySavings(Float.parseFloat(savings));
	}

	public Product getProduct(String productId) {
		return productDAO.getProductById(Long.parseLong(productId));
	}

	@Async
	public void updateSiteCounter(String productId) {
		adminDAO.updateSiteCounter(productId);
	}

	public String getProductURL(String productId) {
		return productDAO.getProductRedirectURL(productId);
	}

	public List<Product> getProductsBySearchCriteria(String searchCriteria) {
		return productDAO.getProductsBySearchCriteria(searchCriteria);
	}

	public List<Product> getProductsBySearchCriteria(String searchCriteria, final int pageIndex, final int pageSize) {
		return productDAO.getProductsBySearchCriteria(searchCriteria, pageIndex, pageSize);
	}

	public List<Product> getAllProducts() {
		return productDAO.getAllProducts();
	}

	public int getProductCount() {
		return productDAO.getProductCount();
	}

	public int getProductCount(String searchCriteria) {
		return productDAO.getProductCount(searchCriteria);
	}
}

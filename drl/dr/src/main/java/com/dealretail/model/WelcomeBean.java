package com.dealretail.model;

import java.util.List;

import com.dealretail.dto.Product;
import com.dealretail.dto.User;

public class WelcomeBean extends BaseBean {

	private List<Product> products;
	private FilterCriteria filterCriteria;
	private User user;
	private int currentPage;
	private int productCount;

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the filterCriteria
	 */
	public FilterCriteria getFilterCriteria() {
		return filterCriteria;
	}

	/**
	 * @param filterCriteria the filterCriteria to set
	 */
	public void setFilterCriteria(FilterCriteria filterCriteria) {
		this.filterCriteria = filterCriteria;
	}

	/**
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WelcomeBean [products=" + products + "]";
	}


	
}

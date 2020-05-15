package com.personal.model;

import com.personal.entity.Product;

import java.util.List;

public class ProductResponse {

	private List<Product> products;
	private FilterCriteria filterCriteria;
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

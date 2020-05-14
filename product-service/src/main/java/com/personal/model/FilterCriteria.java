package com.personal.model;

public class FilterCriteria {

	private String searchKey;
	private String category;
	private String priceRange;
	private String savings;
	private String sortBy;
	private int pageIndex;
	private int pageSize;

	/**
	 * @return the searchKey
	 */
	public String getSearchKey() {
		return searchKey;
	}
	/**
	 * @param searchKey the searchKey to set
	 */
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the priceRange
	 */
	public String getPriceRange() {
		return priceRange;
	}
	/**
	 * @param priceRange the priceRange to set
	 */
	public void setPriceRange(String priceRange) {
		this.priceRange = priceRange;
	}
	/**
	 * @return the savings
	 */
	public String getSavings() {
		return savings;
	}
	/**
	 * @param savings the savings to set
	 */
	public void setSavings(String savings) {
		this.savings = savings;
	}
	/**
	 * @return the sortBy
	 */
	public String getSortBy() {
		return sortBy;
	}
	/**
	 * @param sortBy the sortBy to set
	 */
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FilterCriteria [searchKey=" + searchKey + ", category="
				+ category + ", priceRange=" + priceRange + ", savings="
				+ savings + ", sortBy=" + sortBy + "]";
	}
	
	
}

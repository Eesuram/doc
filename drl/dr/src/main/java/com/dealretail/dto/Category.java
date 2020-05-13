package com.dealretail.dto;

import java.io.Serializable;

public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 945625853227893115L;
	
	private long catId;
	private String catName;

	/**
	 * @return the catId
	 */
	public long getCatId() {
		return catId;
	}
	/**
	 * @param catId the catId to set
	 */
	public void setCatId(long catId) {
		this.catId = catId;
	}
	/**
	 * @return the catName
	 */
	public String getCatName() {
		return catName;
	}
	/**
	 * @param catName the catName to set
	 */
	public void setCatName(String catName) {
		this.catName = catName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Category [catId=" + catId + ", catName=" + catName + "]";
	}
	
	
}

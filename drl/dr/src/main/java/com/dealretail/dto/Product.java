package com.dealretail.dto;

import java.io.Serializable;

public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -838237306907477623L;
	
	private long productId;
	private String productName;
	private String productLink;
	private String imageLink;
	private float orgPrice;
	private float salePrice;
	private float savings;
	private long siteId;
	private long catId;
	
	/**
	 * @return the productId
	 */
	public long getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(long productId) {
		this.productId = productId;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the productLink
	 */
	public String getProductLink() {
		return productLink;
	}
	/**
	 * @param productLink the productLink to set
	 */
	public void setProductLink(String productLink) {
		this.productLink = productLink;
	}
	/**
	 * @return the imageLink
	 */
	public String getImageLink() {
		return imageLink;
	}
	/**
	 * @param imageLink the imageLink to set
	 */
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	/**
	 * @return the orgPrice
	 */
	public float getOrgPrice() {
		return orgPrice;
	}
	/**
	 * @param orgPrice the orgPrice to set
	 */
	public void setOrgPrice(float orgPrice) {
		this.orgPrice = orgPrice;
	}
	/**
	 * @return the salePrice
	 */
	public float getSalePrice() {
		return salePrice;
	}
	/**
	 * @param salePrice the salePrice to set
	 */
	public void setSalePrice(float salePrice) {
		this.salePrice = salePrice;
	}
	/**
	 * @return the savings
	 */
	public float getSavings() {
		return savings;
	}
	/**
	 * @param savings the savings to set
	 */
	public void setSavings(float savings) {
		this.savings = savings;
	}

	/**
	 * @return the siteId
	 */
	public long getSiteId() {
		return siteId;
	}
	/**
	 * @param siteId the siteId to set
	 */
	public void setSiteId(long siteId) {
		this.siteId = siteId;
	}
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName="
				+ productName + ", productLink=" + productLink + ", imageLink="
				+ imageLink + ", orgPrice=" + orgPrice + ", salePrice="
				+ salePrice + ", savings=" + savings + ", siteId=" + siteId
				+ ", catId=" + catId + "]";
	}

}

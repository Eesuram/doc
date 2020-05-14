package com.personal.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -838237306907477623L;

	@Id
	private Long productId;
	private String productName;
	private String productLink;
	private String imageLink;
	private BigDecimal orgPrice;
	private BigDecimal salePrice;
	private BigDecimal savings;
	private Long siteId;
	private Long catId;
	
	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Long productId) {
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
	public BigDecimal getOrgPrice() {
		return orgPrice;
	}
	/**
	 * @param orgPrice the orgPrice to set
	 */
	public void setOrgPrice(BigDecimal orgPrice) {
		this.orgPrice = orgPrice;
	}
	/**
	 * @return the salePrice
	 */
	public BigDecimal getSalePrice() {
		return salePrice;
	}
	/**
	 * @param salePrice the salePrice to set
	 */
	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}
	/**
	 * @return the savings
	 */
	public BigDecimal getSavings() {
		return savings;
	}
	/**
	 * @param savings the savings to set
	 */
	public void setSavings(BigDecimal savings) {
		this.savings = savings;
	}

	/**
	 * @return the siteId
	 */
	public Long getSiteId() {
		return siteId;
	}
	/**
	 * @param siteId the siteId to set
	 */
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	/**
	 * @return the catId
	 */
	public Long getCatId() {
		return catId;
	}
	/**
	 * @param catId the catId to set
	 */
	public void setCatId(Long catId) {
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

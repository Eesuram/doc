package com.personal.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Entity
@IdClass(CategorySiteId.class)
public class CategorySite implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7800667367957647384L;

	@Id
	private Long catId;

	@Id
	private Long siteId;
	private String browseLink;
	private String productKeyword;
	private String imageKeyword;
	private String redirectionKeyword;
	private String orgPriceKeyword;
	private String salePriceKeyword;
	private String descriptionKeyword;
	private String itemCountKeyword;
	private String paginationUrl;
	private int itemsPerPage;
	private int counter;

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
	 * @return the browseLink
	 */
	public String getBrowseLink() {
		return browseLink;
	}
	/**
	 * @param browseLink the browseLink to set
	 */
	public void setBrowseLink(String browseLink) {
		this.browseLink = browseLink;
	}
	/**
	 * @return the productKeyword
	 */
	public String getProductKeyword() {
		return productKeyword;
	}
	/**
	 * @param productKeyword the productKeyword to set
	 */
	public void setProductKeyword(String productKeyword) {
		this.productKeyword = productKeyword;
	}
	/**
	 * @return the itemCountKeyword
	 */
	public String getItemCountKeyword() {
		return itemCountKeyword;
	}
	/**
	 * @param itemCountKeyword the itemCountKeyword to set
	 */
	public void setItemCountKeyword(String itemCountKeyword) {
		this.itemCountKeyword = itemCountKeyword;
	}
	/**
	 * @return the paginationUrl
	 */
	public String getPaginationUrl() {
		return paginationUrl;
	}
	/**
	 * @param paginationUrl the paginationUrl to set
	 */
	public void setPaginationUrl(String paginationUrl) {
		this.paginationUrl = paginationUrl;
	}
	/**
	 * @return the imageKeyword
	 */
	public String getImageKeyword() {
		return imageKeyword;
	}
	/**
	 * @param imageKeyword the imageKeyword to set
	 */
	public void setImageKeyword(String imageKeyword) {
		this.imageKeyword = imageKeyword;
	}
	/**
	 * @return the orgPriceKeyword
	 */
	public String getOrgPriceKeyword() {
		return orgPriceKeyword;
	}
	/**
	 * @param orgPriceKeyword the orgPriceKeyword to set
	 */
	public void setOrgPriceKeyword(String orgPriceKeyword) {
		this.orgPriceKeyword = orgPriceKeyword;
	}
	/**
	 * @return the salePriceKeyword
	 */
	public String getSalePriceKeyword() {
		return salePriceKeyword;
	}
	/**
	 * @param salePriceKeyword the salePriceKeyword to set
	 */
	public void setSalePriceKeyword(String salePriceKeyword) {
		this.salePriceKeyword = salePriceKeyword;
	}
	/**
	 * @return the descriptionKeyword
	 */
	public String getDescriptionKeyword() {
		return descriptionKeyword;
	}
	/**
	 * @param descriptionKeyword the descriptionKeyword to set
	 */
	public void setDescriptionKeyword(String descriptionKeyword) {
		this.descriptionKeyword = descriptionKeyword;
	}
	
	/**
	 * @return the redirectionKeyword
	 */
	public String getRedirectionKeyword() {
		return redirectionKeyword;
	}
	/**
	 * @param redirectionKeyword the redirectionKeyword to set
	 */
	public void setRedirectionKeyword(String redirectionKeyword) {
		this.redirectionKeyword = redirectionKeyword;
	}

	/**
	 * @return the itemsPerPage
	 */
	public int getItemsPerPage() {
		return itemsPerPage;
	}
	/**
	 * @param itemsPerPage the itemsPerPage to set
	 */
	public void setItemsPerPage(int itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}
	/**
	 * @return the counter
	 */
	public int getCounter() {
		return counter;
	}
	/**
	 * @param counter the counter to set
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CategorySite [catId=" + catId + ", siteId=" + siteId
				+ ", browseLink=" + browseLink + ", productKeyword="
				+ productKeyword + ", imageKeyword=" + imageKeyword
				+ ", redirectionKeyword=" + redirectionKeyword
				+ ", orgPriceKeyword=" + orgPriceKeyword
				+ ", salePriceKeyword=" + salePriceKeyword
				+ ", descriptionKeyword=" + descriptionKeyword
				+ ", itemCountKeyword=" + itemCountKeyword + ", paginationUrl="
				+ paginationUrl + ", itemsPerPage=" + itemsPerPage
				+ ", counter=" + counter + "]";
	}

}

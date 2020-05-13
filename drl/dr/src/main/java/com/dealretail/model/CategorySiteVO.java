package com.dealretail.model;

public class CategorySiteVO {

	private int catId;
	private int siteId;
	private String catName;
	private String siteName;
	private String browseLink;
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public int getSiteId() {
		return siteId;
	}
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getBrowseLink() {
		return browseLink;
	}
	public void setBrowseLink(String browseLink) {
		this.browseLink = browseLink;
	}
	
	@Override
	public String toString() {
		return "CategorySiteVO [catId=" + catId + ", siteId=" + siteId
				+ ", catName=" + catName + ", siteName=" + siteName
				+ ", browseLink=" + browseLink + "]";
	}
	
	
}

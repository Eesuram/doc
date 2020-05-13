package com.dealretail.dto;

import java.io.Serializable;

public class Site implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8676695364496530622L;
	
	private long siteId;
	private String siteName;
	private String siteLink;
	private String siteDescription;
	private long counter;
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
	 * @return the siteName
	 */
	public String getSiteName() {
		return siteName;
	}
	/**
	 * @param siteName the siteName to set
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	/**
	 * @return the siteLink
	 */
	public String getSiteLink() {
		return siteLink;
	}
	/**
	 * @param siteLink the siteLink to set
	 */
	public void setSiteLink(String siteLink) {
		this.siteLink = siteLink;
	}
	/**
	 * @return the siteDescription
	 */
	public String getSiteDescription() {
		return siteDescription;
	}
	/**
	 * @param siteDescription the siteDescription to set
	 */
	public void setSiteDescription(String siteDescription) {
		this.siteDescription = siteDescription;
	}
	/**
	 * @return the counter
	 */
	public long getCounter() {
		return counter;
	}
	/**
	 * @param counter the counter to set
	 */
	public void setCounter(long counter) {
		this.counter = counter;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Site [siteId=" + siteId + ", siteName=" + siteName
				+ ", siteLink=" + siteLink + ", siteDescription="
				+ siteDescription + ", counter=" + counter + "]";
	}
	
	
	
}

package com.personal.entity;

import java.io.Serializable;

public class CategorySiteId implements Serializable {

    private Long catId;
    private Long siteId;

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }
}

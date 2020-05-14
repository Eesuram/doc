package com.personal.common;

import com.personal.entity.Category;
import com.personal.entity.CategorySite;
import com.personal.entity.Site;
import com.personal.repository.CategoryRepository;
import com.personal.repository.CategorySiteRepository;
import com.personal.repository.SiteRepository;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class ApplicationData {

    public static List<Category> categories;
    public static List<Site> sites;
    public static List<CategorySite> categorySites;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SiteRepository siteRepository;

    @Autowired
    private CategorySiteRepository categorySiteRepository;

    @PostConstruct
    public void init() {
        getCategories();
        getSites();
        getCategorySites();
    }

    public List<Category> getCategories() {
        if (CollectionUtils.isNotEmpty(categories)) {
            return categories;
        }

        categories = categoryRepository.findAll();

        return categories;
    }

    public List<Site> getSites() {
        if (CollectionUtils.isNotEmpty(sites)) {
            return sites;
        }

        sites = siteRepository.findAll();

        return sites;
    }

    public List<CategorySite> getCategorySites() {
        if (CollectionUtils.isNotEmpty(categorySites)) {
            return categorySites;
        }

        categorySites = categorySiteRepository.findAll();

        return categorySites;
    }

}

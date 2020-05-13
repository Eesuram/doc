package com.dealretail.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dealretail.common.ApplicationData;
import com.dealretail.common.ContextBean;
import com.dealretail.dto.Category;
import com.dealretail.dto.CategorySite;
import com.dealretail.dto.Site;
import com.dealretail.helper.AdminHelper;
import com.dealretail.model.CategorySiteBean;
import com.dealretail.model.CategorySiteVO;

@Controller
public class ManageCssController {

	@RequestMapping (value="/managecss", method=RequestMethod.GET)
	public String showCategorySites(CategorySiteBean categorySiteBean, 
			HttpServletRequest request, HttpServletResponse response) {
		List<CategorySite> categorySites = adminHelper.getAllCategorySites();
		if (CollectionUtils.isNotEmpty(categorySites)) {
			List<CategorySiteVO> csVOs = new ArrayList<CategorySiteVO>();
			for (CategorySite categorySite : categorySites) {
				CategorySiteVO csVO = new CategorySiteVO();
				csVO.setCatId(categorySite.getCatId());
				csVO.setCatName(getCategoryName(categorySite.getCatId()));
				csVO.setSiteId(categorySite.getSiteId());
				csVO.setSiteName(getSiteName(categorySite.getSiteId()));
				csVO.setBrowseLink(categorySite.getBrowseLink());
				csVOs.add(csVO);
			}
			
			categorySiteBean.setAllCategorySites(csVOs);
		}
		return "managecss";
	}

	@RequestMapping (value = "/addcss", method=RequestMethod.POST)
	public String addCategorySite(CategorySiteBean categorySiteBean,
			HttpServletRequest request, HttpServletResponse response) {
		if (null != categorySiteBean.getNewCategorySite()) {
			adminHelper.addCategorySite(categorySiteBean.getNewCategorySite());
			ApplicationData.categorySites = null;
		}
		
		return "managecssR";
	}

	@RequestMapping (value = "/removecss", method=RequestMethod.POST)
	public String removeCategorySite(@RequestParam (value = "category") String categoryId, 
			@RequestParam (value = "site") String siteId, CategorySiteBean categorySiteBean,
			HttpServletRequest request, HttpServletResponse response) {
		if (StringUtils.isNotEmpty(categoryId) && StringUtils.isNotEmpty(siteId)) {
			adminHelper.removeCategorySite(categoryId, siteId);
			ApplicationData.categorySites = null;
		}
		
		return "managecssR";
	}

	private String getSiteName(int siteId) {
		if (CollectionUtils.isNotEmpty(ApplicationData.sites)) {
			for (Site site : ApplicationData.sites) {
				if (site.getSiteId() == siteId) {
					return site.getSiteName();
				}
			}
		}
		
		return "";
	}

	private String getCategoryName(int catId) {
		if (CollectionUtils.isNotEmpty(ApplicationData.categories)) {
			for (Category category : ApplicationData.categories) {
				if (category.getCatId() == catId) {
					return category.getCatName();
				}
			}
		}
		
		return "";
	}

	@Autowired
	private AdminHelper adminHelper;

}

package com.dealretail.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dealretail.common.ApplicationData;
import com.dealretail.common.Constants;
import com.dealretail.dto.Category;
import com.dealretail.dto.Product;
import com.dealretail.helper.AdminHelper;
import com.dealretail.helper.ProductHelper;
import com.dealretail.model.FilterCriteria;
import com.dealretail.model.WelcomeBean;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

	Log log = LogFactory.getLog(WelcomeController.class);
	private final String MODEL_ATTRIBTE = "welcomeBean";

	@RequestMapping(method = RequestMethod.GET)
	public String defaultPage(
			@ModelAttribute(MODEL_ATTRIBTE) WelcomeBean welcomeBean,
			HttpServletRequest request) {
		try {

			HttpSession session = request.getSession(false);
			if (null != session
					&& null != session.getAttribute(Constants.USER_INFO)) {
				welcomeBean.setSignedIn(true);
			} else {
				welcomeBean.setSignedIn(false);
			}

			String searchCriteria = (String) request
					.getAttribute("searchCriteria");
			int currentPage = 1;
			if (null != request.getParameter("pageIndex")) {
				currentPage = Integer.parseInt(request
						.getParameter("pageIndex"));
			}

			welcomeBean.setCurrentPage(currentPage);

			if (log.isDebugEnabled()) {
				log.debug("START :: Open the welcome page with Search Criteria :: "
						+ searchCriteria);
			}

			List<Product> products = null;

			if (StringUtils.isNotEmpty(searchCriteria)) {
				products = productHelper.getProductsBySearchCriteria(
						searchCriteria, currentPage, 18);
			} else {
				products = productHelper.getAllProducts();
			}

			welcomeBean.setProductCount(productHelper
					.getProductCount(searchCriteria));

			FilterCriteria filterCriteria = buildFilterCriteria(request);
			welcomeBean.setProducts(products);
			welcomeBean.setFilterCriteria(filterCriteria);

			if (log.isDebugEnabled()) {
				log.debug("END :: No. of Products :: " + products.size());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "welcome";
	}

	private FilterCriteria buildFilterCriteria(HttpServletRequest request) {
		Map<String, String> cookieMap = (Map<String, String>) request
				.getAttribute("cookieMap");
		FilterCriteria filterCriteria = new FilterCriteria();

		if (MapUtils.isNotEmpty(cookieMap)) {
			if (StringUtils.isNotEmpty(cookieMap.get("categoryId"))) {
				filterCriteria.setCategory(getCategoryName(cookieMap
						.get("categoryId")));
			}
			filterCriteria.setPriceRange(cookieMap.get("priceRange"));
			if (StringUtils.isNotEmpty(cookieMap.get("savings"))) {
				filterCriteria.setSavings(discountMap.get(cookieMap
						.get("savings")));
			}
			filterCriteria.setSearchKey(cookieMap.get("searchKey"));
			filterCriteria.setSortBy(cookieMap.get("sortBy"));
		}

		return filterCriteria;
	}

	private String getCategoryName(String categoryId) {
		if (CollectionUtils.isNotEmpty(ApplicationData.categories)) {
			for (Category category : ApplicationData.categories) {
				long catId = Long.parseLong(categoryId);
				if (category.getCatId() == catId) {
					return category.getCatName();
				}
			}
		}

		return null;
	}

	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public String productsByCategory(@RequestParam String categoryId,
			@ModelAttribute(value = MODEL_ATTRIBTE) WelcomeBean welcomeBean) {
		List<Product> products = productHelper
				.getProductsByCategory(categoryId);
		welcomeBean.setProducts(products);
		return "welcome";
	}

	@RequestMapping(value = "/searchkey", method = RequestMethod.POST)
	public String productsBySearch(@RequestParam String searchKey,
			@ModelAttribute(value = MODEL_ATTRIBTE) WelcomeBean welcomeBean) {
		List<Product> products = productHelper
				.getProductsBySearchKey(searchKey);
		welcomeBean.setProducts(products);
		return "welcome";
	}

	@RequestMapping(value = "/price", method = RequestMethod.POST)
	public String productsByPriceRange(@RequestParam String priceRange,
			@ModelAttribute(value = MODEL_ATTRIBTE) WelcomeBean welcomeBean) {
		String[] price = priceRange.split("-");
		List<Product> products = productHelper.getProductsByPriceRange(
				price[0], price[1]);
		welcomeBean.setProducts(products);
		return "welcome";
	}

	@RequestMapping(value = "/savings", method = RequestMethod.POST)
	public String productsBySavings(@RequestParam String savings,
			@ModelAttribute(value = MODEL_ATTRIBTE) WelcomeBean welcomeBean) {
		List<Product> products = productHelper.getProductsBySavings(savings);
		welcomeBean.setProducts(products);
		return "welcome";
	}

	@Autowired
	private ProductHelper productHelper;

	@Autowired
	private AdminHelper adminHelper;

	@Resource(name = "discountMap")
	private Map<String, String> discountMap;
}

package com.dealretail.helper;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.dealretail.dao.AdminDAO;
import com.dealretail.dao.ProductDAO;
import com.dealretail.dto.CategorySite;
import com.dealretail.dto.Product;

@Component
public class ProductHelper {

	Log log = LogFactory.getLog(ProductHelper.class);

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private AdminDAO adminDAO;

	@Autowired
	private SoupHelper soupHelper;

	public void refreshProducts() {
		List<CategorySite> categorySites = adminDAO.getCategorySites();

		if (CollectionUtils.isEmpty(categorySites)) {
			return;
		}

		productDAO.removeAllProducts();
		productDAO.resetProductIdIncrementer();
		refreshProducts(categorySites);

	}

	public void refreshProducts(String catId, String siteId) {
		List<CategorySite> categorySites = null;

		if (StringUtils.isNotEmpty(catId) && StringUtils.isNotEmpty(siteId)) {
			categorySites = adminDAO.getCategorySites(Integer.parseInt(catId),
					Integer.parseInt(siteId));
			if (CollectionUtils.isEmpty(categorySites)) {
				return;
			}

			productDAO.removeProductsByCategorySite(Integer.parseInt(catId),
					Integer.parseInt(siteId));
			;

		} else if (StringUtils.isNotEmpty(catId)) {
			categorySites = adminDAO.getCategorySitesByCategory(Integer
					.parseInt(catId));
			if (CollectionUtils.isEmpty(categorySites)) {
				return;
			}

			productDAO.removeProductsByCategory(Integer.parseInt(catId));
			;

		} else if (StringUtils.isNotEmpty(siteId)) {
			categorySites = adminDAO.getCategorySitesBySite(Integer
					.parseInt(siteId));
			if (CollectionUtils.isEmpty(categorySites)) {
				return;
			}

			productDAO.removeProductsBySite(Integer.parseInt(siteId));
			;

		} else {
			return;
		}

		refreshProducts(categorySites);
	}

	private void refreshProducts(List<CategorySite> categorySites) {

		for (CategorySite categorySite : categorySites) {
			log.info("Processing Category browse link :: "
					+ categorySite.getBrowseLink());

			updateProducts(categorySite, categorySite.getBrowseLink());

			if (StringUtils.isNotEmpty(categorySite.getPaginationUrl())) {
				int itemCount = soupHelper.getItemCount(
						categorySite.getBrowseLink(),
						categorySite.getItemCountKeyword());

				if (itemCount > 0 && categorySite.getItemsPerPage() > 0) {
					int noOfPages = itemCount / categorySite.getItemsPerPage();
					if (itemCount % categorySite.getItemsPerPage() > 0) {
						noOfPages++;
					}

					for (int pageIndex = 2; pageIndex <= noOfPages; pageIndex++) {
						String url = categorySite.getPaginationUrl();
						url = url.replace("{0}", pageIndex + "");

						updateProducts(categorySite, url);
					}
				}
			}
		}
	}

	public void updateProducts(CategorySite categorySite, String url) {
		List<Product> products = soupHelper.getProducts(categorySite, url);

		if (CollectionUtils.isNotEmpty(products)) {
			log.info("Processed URL :: " + url + " --- No. of Products :: "
					+ products.size());

			productDAO.updateProducts(products);
		} else {
			log.info("Processed URL :: " + url + " --- No products updated");
		}
	}

	public List<Product> getProductsByCategory(String categoryId) {
		return productDAO.getProductByCategory(Long.parseLong(categoryId));
	}

	public List<Product> getProductsBySearchKey(String searchKey) {
		return productDAO.getProductByProductName(searchKey);
	}

	public List<Product> getProductsByPriceRange(String startPrice,
			String endPrice) {
		return productDAO.getProductByPriceRange(Float.parseFloat(startPrice),
				Float.parseFloat(endPrice));
	}

	public List<Product> getProductsBySavings(String savings) {
		return productDAO.getProductBySavings(Float.parseFloat(savings));
	}

	public Product getProduct(String productId) {
		return productDAO.getProductById(Long.parseLong(productId));
	}

	@Async
	public void updateSiteCounter(String productId) {
		adminDAO.updateSiteCounter(productId);
	}

	public String getProductURL(String productId) {
		return productDAO.getProductRedirectURL(productId);
	}

	public List<Product> getProductsBySearchCriteria(String searchCriteria) {
		return productDAO.getProductsBySearchCriteria(searchCriteria);
	}

	public List<Product> getProductsBySearchCriteria(String searchCriteria, final int pageIndex, final int pageSize) {
		return productDAO.getProductsBySearchCriteria(searchCriteria, pageIndex, pageSize);
	}

	public List<Product> getAllProducts() {
		return productDAO.getAllProducts();
	}

	public int getProductCount() {
		return productDAO.getProductCount();
	}

	public int getProductCount(String searchCriteria) {
		return productDAO.getProductCount(searchCriteria);
	}
}

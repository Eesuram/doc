package com.personal.controller;

import com.personal.common.ApplicationData;
import com.personal.common.Constants;
import com.personal.entity.Category;
import com.personal.entity.Product;
import com.personal.helper.ProductHelper;
import com.personal.model.FilterCriteria;
import com.personal.model.ProductResponse;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class WelcomeController {

    Log log = LogFactory.getLog(WelcomeController.class);

    @Autowired
    private ProductHelper productHelper;

    @Resource(name = "discountMap")
    private Map<String, String> discountMap;

    @GetMapping
    public ProductResponse defaultPage(@RequestBody FilterCriteria filterCriteria, HttpServletRequest request) {
        ProductResponse response = new ProductResponse();

        try {
            HttpSession session = request.getSession(false);
            if (null != session && null != session.getAttribute(Constants.USER_INFO)) {
                response.setSignedIn(true);
            } else {
                response.setSignedIn(false);
                filterCriteria.setSavings("40");
            }

            response.setCurrentPage(filterCriteria.getPageIndex() + 1);

            if (log.isDebugEnabled()) {
                log.debug("START :: Open the welcome page with Search Criteria :: " + filterCriteria);
            }

            List<Product> products = productHelper.getProductsByFilterCriteria(filterCriteria);
            response.setProductCount(productHelper.getProductCount(filterCriteria));

            response.setProducts(products);
            response.setFilterCriteria(filterCriteria);

            if (log.isDebugEnabled()) {
                log.debug("END :: No. of Products :: " + products.size());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    @PostMapping(value = "/category/{categoryId}")
    public List<Product> productsByCategory(@PathVariable String categoryId) {
        return productHelper.getProductsByCategory(categoryId);
    }

    @PostMapping(value = "/search/{key}")
    public List<Product> productsBySearch(@PathVariable String key) {
        FilterCriteria filterCriteria = new FilterCriteria();
        filterCriteria.setSearchKey(key);
        return productHelper.getProductsByFilterCriteria(filterCriteria);
    }

    @PostMapping(value = "/price-range")
    public List<Product> productsByPriceRange(@PathVariable String priceRange) {
        FilterCriteria filterCriteria = new FilterCriteria();
        filterCriteria.setPriceRange(priceRange);
        return productHelper.getProductsByFilterCriteria(filterCriteria);
    }

    @PostMapping(value = "/savings/{savings}")
    public List<Product> productsBySavings(@PathVariable String savings) {
        FilterCriteria filterCriteria = new FilterCriteria();
        filterCriteria.setSavings(savings);
        return productHelper.getProductsByFilterCriteria(filterCriteria);
    }
}

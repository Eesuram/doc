package com.personal.helper;

import com.microsoft.applicationinsights.TelemetryClient;
import com.personal.entity.Product;
import com.personal.model.FilterCriteria;
import com.personal.repository.ProductRepository;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductHelper {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductsByCategory(String categoryId) {
        return productRepository.findAllProductsByCatId(Integer.parseInt(categoryId));
    }

    public List<Product> getProductsByFilterCriteria(FilterCriteria filterCriteria) {
        Sort sortBy = Sort.by(Sort.Direction.DESC, "savings");
        if (null != filterCriteria && StringUtils.isNotBlank(filterCriteria.getSortBy())) {
            if ("price".equalsIgnoreCase(filterCriteria.getSortBy())) {
                sortBy = Sort.by(Sort.Direction.ASC, "salePrice");
            }
        }

        Specification<Product> specification = buildSpecification(filterCriteria);

        List<Product> products = null;
        if (filterCriteria.getPageIndex() > 0) {
            int pageSize = (0 == filterCriteria.getPageSize()) ? 18 : filterCriteria.getPageSize();
            Page<Product> productPage = productRepository.findAll(specification, PageRequest.of(filterCriteria.getPageIndex(), pageSize, sortBy));
            products = productPage.getContent();
        } else {
            products = productRepository.findAll(specification, sortBy);
        }

        return products;
    }

    private Specification<Product> buildSpecification(FilterCriteria filterCriteria) {
        List<Criteria> searchCriteria = ProductSpecifications.build(filterCriteria);
        Specification<Product> specification = null;
        int i = 0;
        for (Criteria criteria: searchCriteria) {
            if(++i == 1) {
                specification = Specification.where(new ProductSpecifications(criteria));
            } else {
                specification = specification.and(new ProductSpecifications(criteria));
            }
        }
        return specification;
    }

    public Product getProduct(String productId) {
        return productRepository.findById(Integer.parseInt(productId)).get();
    }

    public String getProductURL(String productId) {
        Product product = getProduct(productId);
        return product.getProductLink();
    }

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public int getProductCount() {
        return (int) productRepository.count();
    }

    public int getProductCount(FilterCriteria filterCriteria) {
        return (int) productRepository.count(buildSpecification(filterCriteria));
    }
}

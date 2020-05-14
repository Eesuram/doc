package com.personal.helper;

import com.personal.entity.Product;
import com.personal.model.FilterCriteria;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductSpecifications implements Specification<Product> {

    private Criteria criteria;

    public ProductSpecifications(Criteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (criteria.getOperation().equalsIgnoreCase(">=")) {
            return criteriaBuilder.greaterThanOrEqualTo(root.get(criteria.key),
                    BigDecimal.valueOf(Double.parseDouble(criteria.getValue())));
        } else if (criteria.getOperation().equalsIgnoreCase("<=")) {
            return criteriaBuilder.lessThanOrEqualTo(root.get(criteria.key),
                    BigDecimal.valueOf(Double.parseDouble(criteria.getValue())));
        } else if (criteria.getOperation().equalsIgnoreCase("=")) {
            return criteriaBuilder.equal(root.get(criteria.key), criteria.getValue());
        }  else if (criteria.getOperation().equalsIgnoreCase("<")) {
            return criteriaBuilder.equal(root.get(criteria.key), criteria.getValue());
        }  else if (criteria.getOperation().equalsIgnoreCase(":")) {
            return criteriaBuilder.like(root.get(criteria.key), "%" + criteria.getValue().toLowerCase() + "%");
        }

        return null;
    }

    public static List<Criteria> build(FilterCriteria filterCriteria) {
        List<Criteria> searchCriteria = new ArrayList<>();

        if (null != filterCriteria) {
            if (StringUtils.isNotBlank(filterCriteria.getCategory())) {
                searchCriteria.add(new Criteria("catId", filterCriteria.getCategory(), "="));
            }
            if (StringUtils.isNotBlank(filterCriteria.getPriceRange())) {
                String[] range = filterCriteria.getPriceRange().split("-");

                searchCriteria.add(new Criteria("salePrice", range[0], ">="));
                searchCriteria.add(new Criteria("salePrice", range[1], "<="));
            }
            if (StringUtils.isNotBlank(filterCriteria.getSavings())) {
                if ("40".equalsIgnoreCase(filterCriteria.getSavings())) {
                    searchCriteria.add(new Criteria("savings", filterCriteria.getSavings(), "<"));
                } else {
                    searchCriteria.add(new Criteria("savings", filterCriteria.getSavings(), ">="));
                }
            }

            if (StringUtils.isNotBlank(filterCriteria.getSearchKey())) {
                searchCriteria.add(new Criteria("productName", filterCriteria.getSearchKey(), ":"));
            }
        }

        return searchCriteria;
    }
}

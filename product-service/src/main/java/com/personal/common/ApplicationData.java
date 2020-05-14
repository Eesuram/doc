package com.personal.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.personal.entity.Category;
import com.personal.repository.CategoryRepository;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Component
public class ApplicationData {

    private List<Category> categories;

    @Autowired
    public Map<String, String> discounts;

    @Autowired
    public Map<String, String> priceRanges;

    @Autowired
    private CategoryRepository categoryRepository;

    @PostConstruct
    public void init() {
        getCategories();
    }

    public List<Category> getCategories() {
        if (CollectionUtils.isNotEmpty(categories)) {
            return categories;
        }

        categories = categoryRepository.findAll();

        return categories;
    }
}

package com.personal.repository;

import com.personal.entity.CategorySite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorySiteRepository extends JpaRepository<CategorySite, Integer> {

    List<CategorySite> findAllCategorySitesByCatId(int catId);

    List<CategorySite> findAllCategorySitesBySiteId(int siteId);

    CategorySite findAllCategorySitesByCatIdAndSiteId(int catId, int siteId);
}

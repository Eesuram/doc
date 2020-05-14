package com.personal.repository;

import com.personal.entity.Product;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer>, JpaSpecificationExecutor<Product> {

    Product findProductByProductId(Integer productId);

    List<Product> findAllProductsByProductName(String productName);

    List<Product> findAllProductsByCatId(Integer catId);

    List<Product> findAllProductsBySiteId(Integer siteId);

    List<Product> findAllProductsByCatIdAndSiteId(Integer catId, Integer siteId);

}

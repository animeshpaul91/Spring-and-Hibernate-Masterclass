package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
// productCategory will be the name of the JSON entry while
// product-category will be a reference to the path of the endpoint. Normally JPA pluralizes the entity name
// this is the way to customize it
@CrossOrigin("http://localhost:4200") // accept calls from web browser javascript for this origin
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    // Different Origin here http://localhost:4200 != http://localhost:8080
}

package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("http://localhost:4200") // accept calls from web browser javascript for this origin
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
 // Different Origin here http://localhost:4200 != http://localhost:8080
    Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);
    // behind the scenes spring will execute a query similar to select * from product where category_id=2; and
    // expose the endpoint - http://localhost:8080/api/products/search/findByCategoryId?id=2  2 is an example here

    Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
    // select * from Product p where p.name LIKE CONCAT('%', :name, '%')
}

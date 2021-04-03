package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200") // accept calls from web browser javascript for this origin
public interface ProductRepository extends JpaRepository<Product, Long> {
 // Different Origin here http://localhost:4200 != http://localhost:8080
}

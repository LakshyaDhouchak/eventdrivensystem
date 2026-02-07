package com.lakshya.ecommerce.eventdrivensystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lakshya.ecommerce.eventdrivensystem.entity.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products,Long> {
    
}

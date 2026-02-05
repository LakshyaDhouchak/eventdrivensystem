package com.lakshya.ecommerce.eventdrivensystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lakshya.ecommerce.eventdrivensystem.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory , String> {
    
}

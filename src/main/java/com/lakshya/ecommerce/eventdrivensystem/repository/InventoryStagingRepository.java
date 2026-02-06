package com.lakshya.ecommerce.eventdrivensystem.repository;

import java.math.BigDecimal;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lakshya.ecommerce.eventdrivensystem.entity.InventoryStaging;

@Repository
public interface InventoryStagingRepository extends JpaRepository<InventoryStaging , Long> {

    void deleteByPriceLessThanEqual(BigDecimal zero);
    
}

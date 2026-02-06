package com.lakshya.ecommerce.eventdrivensystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lakshya.ecommerce.eventdrivensystem.entity.Inventory;

import jakarta.transaction.Transactional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory , String> {
    @Modifying
    @Transactional
    @Query(value = """
            INSERT INTO inventory (product_id,category,product_title,product_description,
            pack_size_quantity , price , stock_quantity , crawl_timestamp)

            SELECT uniq_id , category , product_title , product_description , pack_size_quantity
            ,price , pack_size_quantity , crawl_timestamp 
            FROM inventory_staging
            ON DUPLICATE KEY UPDATE
            stock_quantity = inventory.stock_quantity + VALUES(stock_quantity),  
            category = VALUES(category),
            product_title = VALUES(product_title),
            product_description = VALUES(product_description),
            price = VALUES(price),
            crawl_timestamp = VALUES(crawl_timestamp),
            updated_at = CURRENT_TIMESTAMP

            """, nativeQuery = true)
    void aggregateAndMerge();

    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE inventory_staging", nativeQuery = true)
    void truncateStaging();
    
}

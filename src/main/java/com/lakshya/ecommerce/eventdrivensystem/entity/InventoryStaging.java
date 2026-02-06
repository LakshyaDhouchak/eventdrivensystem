package com.lakshya.ecommerce.eventdrivensystem.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "inventory_staging")
public class InventoryStaging {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staging_id")
    private Long stagingId;  

    @Column(name = "uniq_id", length = 100)
    private String uniqId;

    @Column(name = "crawl_timestamp")
    private LocalDateTime crawlTimestamp;

    @Column(name = "product_title", length = 500)
    private String productTitle;

    @Column(name = "category", length = 255)
    private String category;

    @Column(name = "product_description", columnDefinition = "TEXT")
    private String productDescription;

    @Column(name = "pack_size_quantity")
    private Integer packSizeQuantity;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "source_system")
    @Builder.Default
    private String sourceSystem = "KAGGLE";
}
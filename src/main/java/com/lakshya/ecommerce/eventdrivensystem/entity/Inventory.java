package com.lakshya.ecommerce.eventdrivensystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "inventory")
public class Inventory {

    @Id
    @Column(name = "product_id", length = 100)
    private String productId;

    @Column(nullable = false, length = 255)
    private String category;

    @Column(name = "product_title", nullable = false, length = 500)
    private String productTitle;

    @Column(name = "product_description", columnDefinition = "TEXT")
    private String productDescription;

    private String brand;

    @Column(name = "pack_size_quantity")
    private Integer packSizeQuantity;

    private BigDecimal mrp;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(name = "stock_quantity", nullable = false)
    private Integer stockQuantity;

    @Column(name = "crawl_timestamp")
    private LocalDateTime crawlTimestamp;

    // We removed the @Version field as per your requirement

    @Column(name = "created_at", updatable = false, insertable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", updatable = false, insertable = false)
    private LocalDateTime updatedAt;
}

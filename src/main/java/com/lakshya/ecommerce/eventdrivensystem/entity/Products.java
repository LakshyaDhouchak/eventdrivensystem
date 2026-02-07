package com.lakshya.ecommerce.eventdrivensystem.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
@Builder
public class Products {
    // define the properties
    @Id
    @Column(name = "product_id")
    private Long productId;

    @Column(name = " product_name")
    private String productName;

    @Column(name = "category")
    private String category;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;
}

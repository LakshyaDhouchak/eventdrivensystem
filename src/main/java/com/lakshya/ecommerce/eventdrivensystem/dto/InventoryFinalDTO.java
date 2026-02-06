package com.lakshya.ecommerce.eventdrivensystem.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InventoryFinalDTO {
    private String productId;
    private String category;
    private String productTitle;
    private String productDescription;
    private String brand;
    private Integer packSizeQuantity;
    private BigDecimal mrp;
    private BigDecimal price;
    private Integer stockQuantity;
}

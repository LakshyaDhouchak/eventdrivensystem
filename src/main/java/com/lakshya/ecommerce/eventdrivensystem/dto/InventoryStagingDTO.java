package com.lakshya.ecommerce.eventdrivensystem.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InventoryStagingDTO {
    // define the properties
    private Long stagingId;
    private String uniqId;
    private LocalDateTime crawlTimestamp;
    private String projectTitle;
    private String category;
    private String productDescription;
    private String brand;
    private Integer packSizeQuantity;
    private BigDecimal mrp;
    private BigDecimal price;
    private String sourceSystem;

}

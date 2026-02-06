package com.lakshya.ecommerce.eventdrivensystem.dto;

import lombok.Data;

@Data
public class InventoryCsvRow {
    // define the properties
    private String productId;
    private String productName;
    private String productCategory;
    private String productDescription;
    private String price;
    private String StockQuantity;
    private String warrantyPeriod;
    private String ProductDimensions;
    private String manufacturingDate;
    private String expirationDate;
    private String sku;
    private String productTags;
    private String colorSizeValidation;
    private String productRating;

}

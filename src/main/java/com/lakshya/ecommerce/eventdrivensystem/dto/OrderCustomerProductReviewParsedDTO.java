package com.lakshya.ecommerce.eventdrivensystem.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderCustomerProductReviewParsedDTO {
    
    //  define the properties
    private String customerId;
    private String firstName;
    private String lastName;
    private String gender;
    private String ageGroup;
    private LocalDate signupDate;
    private String country;
    private String productId;
    private String productName;
    private String category;
    private Integer quantity;
    private BigDecimal unitPrice;
    private String orderId;
    private LocalDate orderDate;
    private String orderStatus;
    private Integer rating;
    private String reviewText;
    private String reviewId;
    private LocalDate reviewDate;

}


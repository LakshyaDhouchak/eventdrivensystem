package com.lakshya.ecommerce.eventdrivensystem.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "reviews")
public class Reviews {
    // define the properties
    @Id
    @Column(name = "review_id")
    private Long reviewId;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "review_text", columnDefinition = "Text")
    private String reviewText;

    @Column(name = "review_date")
    private LocalDate reviewDate;
    
}

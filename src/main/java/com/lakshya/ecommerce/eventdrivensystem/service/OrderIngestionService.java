package com.lakshya.ecommerce.eventdrivensystem.service;


import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.lakshya.ecommerce.eventdrivensystem.dto.OrderCustomerProductReviewParsedDTO;
import com.lakshya.ecommerce.eventdrivensystem.entity.Customers;
import com.lakshya.ecommerce.eventdrivensystem.entity.OrderItems;
import com.lakshya.ecommerce.eventdrivensystem.entity.Orders;
import com.lakshya.ecommerce.eventdrivensystem.entity.Products;
import com.lakshya.ecommerce.eventdrivensystem.entity.Reviews;
import com.lakshya.ecommerce.eventdrivensystem.repository.CustomersRepository;
import com.lakshya.ecommerce.eventdrivensystem.repository.OrderItemsRepository;
import com.lakshya.ecommerce.eventdrivensystem.repository.OrderRepository;
import com.lakshya.ecommerce.eventdrivensystem.repository.ProductsRepository;
import com.lakshya.ecommerce.eventdrivensystem.repository.ReviewsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderIngestionService implements OrderServiceInterface {
    // define the properties
    private final CustomersRepository customersRepo;
    private final OrderRepository orderRepo;
    private final OrderItemsRepository orderItemsRepo;
    private final ProductsRepository productsRepo;
    private final ReviewsRepository reviewsRepo;


    // define the helper class
    private OrderCustomerProductReviewParsedDTO mapToCsvDTO(String[] columns){
        return OrderCustomerProductReviewParsedDTO.builder()
                .customerId(columns[0])
                .firstName(columns[1])
                .lastName(columns[2])
                .gender(columns[3])
                .ageGroup(columns[4])
                .signupDate(LocalDate.parse(columns[5]))
                .country(columns[6])
                .productId(columns[7])
                .productName(columns[8])
                .category(columns[9])
                .quantity(Integer.parseInt(columns[10]))
                .unitPrice(new BigDecimal(columns[11]))
                .orderId(columns[12])
                .orderDate(LocalDate.parse(columns[13]))
                .orderStatus(columns[14])
                .rating(Integer.parseInt(columns[16]))
                .reviewText(columns[17])
                .reviewId(columns[18])
                .reviewDate(LocalDate.parse((columns[19])))
                .build();
    }

    private Customers mapToCustomerEntity(OrderCustomerProductReviewParsedDTO dto){
        return Customers.builder()
                .customerId(Long.valueOf(dto.getCustomerId()))
                .firstName((dto.getFirstName()))
                .lastName((dto.getLastName()))
                .gender(dto.getGender())
                .ageGroup(dto.getAgeGroup())
                .signupDate(dto.getSignupDate())
                .country(dto.getCountry())
                .build();
    }

    private Products mapToProductEntity(OrderCustomerProductReviewParsedDTO dto){
        return Products.builder()
                .productId(Long.valueOf(dto.getProductId()))
                .productName(dto.getProductName())
                .category(dto.getCategory())
                .unitPrice(dto.getUnitPrice())
                .build();
    }

    private Orders mapToOrdersEntity(OrderCustomerProductReviewParsedDTO dto){
        return Orders.builder()
                .orderId(Long.valueOf(dto.getOrderId()))
                .customerId(Long.valueOf(dto.getCustomerId()))
                .orderDate(dto.getOrderDate())
                .orderStatus(dto.getOrderStatus())
                .build();
    }

    private OrderItems mapToOrderItemsEntity(OrderCustomerProductReviewParsedDTO dto){
        return OrderItems.builder()
                .orderId(Long.valueOf(dto.getOrderId()))
                .productId(Long.valueOf(dto.getProductId()))
                .quantity(dto.getQuantity())
                .unitPrice(dto.getUnitPrice())
                .build();
    }

    private Reviews mapToReviewsEntity(OrderCustomerProductReviewParsedDTO dto){
        return Reviews.builder()
                .reviewId(Long.valueOf(dto.getReviewId()))
                .orderId(Long.valueOf((dto.getOrderId())))
                .customerId(Long.valueOf(dto.getCustomerId()))
                .productId(Long.valueOf(dto.getProductId()))
                .rating(dto.getRating())
                .reviewText(dto.getReviewText())
                .reviewDate(dto.getReviewDate())
                .build();
    }
    @Override
    public void ingestOrder(OrderCustomerProductReviewParsedDTO dto) {
        
    }

    @Override
    public void simulate(String filePath) {
        
    }
    
}

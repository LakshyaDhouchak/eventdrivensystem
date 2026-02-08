package com.lakshya.ecommerce.eventdrivensystem.service;

import com.lakshya.ecommerce.eventdrivensystem.dto.OrderCustomerProductReviewParsedDTO;

public interface OrderServiceInterface {
    // define the methord
    void ingestOrder(OrderCustomerProductReviewParsedDTO dto);
    void simulate(String filePath) throws InterruptedException;
}

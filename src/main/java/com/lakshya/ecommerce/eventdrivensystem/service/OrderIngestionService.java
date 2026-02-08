package com.lakshya.ecommerce.eventdrivensystem.service;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Service;
import com.lakshya.ecommerce.eventdrivensystem.dto.OrderCustomerProductReviewParsedDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderIngestionService implements OrderServiceInterface {

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

    @Override
    public void ingestOrder(OrderCustomerProductReviewParsedDTO dto) {
        
    }

    @Override
    public void simulate(String filePath) throws InterruptedException {
        try{
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                br.readLine();
                String line;

                // define the condition
                while((line = br.readLine()) != null){
                    String[] columns = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                    OrderCustomerProductReviewParsedDTO dto = mapToCsvDTO(columns);

                    // calling the ingestOrder() methord
                    ingestOrder(dto);
                    Thread.sleep(200);
                }
            }

        }
        catch(IOException ex){
            throw new RuntimeException("Error reading CSV file: " + filePath, ex);
        }
    }
    
}

package com.lakshya.ecommerce.eventdrivensystem.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lakshya.ecommerce.eventdrivensystem.dto.InventoryCsvRow;
import com.lakshya.ecommerce.eventdrivensystem.entity.InventoryStaging;
import com.lakshya.ecommerce.eventdrivensystem.repository.InventoryRepository;
import com.lakshya.ecommerce.eventdrivensystem.repository.InventoryStagingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryIngestionService implements InventoryServiceInterface{
    // define the properties
    private InventoryStagingRepository inventoryStagingRepo;
    private InventoryRepository inventoryRepo;

    // define the helper class
    private InventoryCsvRow mapInventoryCsvRow(String[] cols){
        InventoryCsvRow invertory =  new InventoryCsvRow();
        invertory.setProductId(cols[0]);
        invertory.setProductName(cols[1]);
        invertory.setProductCategory(cols[2]);
        invertory.setProductDescription(cols[3]);
        invertory.setPrice(cols[4]);
        invertory.setStockQuantity(Integer.parseInt(cols[5]));
        invertory.setWarrantyPeriod(cols[6]);
        invertory.setProductDimensions(cols[7]);
        invertory.setManufacturingDate(cols[8]);
        invertory.setExpirationDate(cols[9]);
        invertory.setSku(cols[10]);
        invertory.setProductTags(cols[11]);
        invertory.setColorSizeValidation(cols[12]);
        invertory.setProductRating(cols[13]);
        return invertory;
    }

    private InventoryStaging convertToEntity(InventoryCsvRow dto){
        return InventoryStaging.builder()
                .uniqId(dto.getProductId())
                .category(dto.getProductCategory())
                .crawlTimestamp(LocalDateTime.now())
                .productTitle(dto.getProductName())
                .category(dto.getProductCategory())
                .productDescription(dto.getProductDescription())
                .packSizeQuantity(dto.getStockQuantity())
                .sourceSystem("Kaggke")
                .build();
    }

    private boolean isDataSecureAndValid(InventoryCsvRow dto){
        try{
            // define the condition
            if(dto.getProductId() == null || dto.getProductId().isBlank() ){
                return false;
            }
            BigDecimal price = new BigDecimal(dto.getPrice());
            if(price.compareTo(BigDecimal.ZERO) <0){
                return false;
            }
            if(dto.getProductName() != null && dto.getProductName().length()>500){
                dto.setProductName(dto.getProductName().substring(0,475));
            }
            return true;
        }
        catch(Exception ex){
            ex.getMessage();
            return false;
        }
    }

    @Transactional
    @Override
    public void ingectCsv(String filePath) {
        // define the properties
        int batchSize = 50;
        List<InventoryStaging> batch = new ArrayList<>();
        try{
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                br.readLine();

                // define the while loop
                while((line = br.readLine()) != null){
                    String[] columns = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                    InventoryCsvRow dto = mapInventoryCsvRow(columns);
                    if(isDataSecureAndValid(dto)){
                        batch.add(convertToEntity(dto));
                    }
                    // define the condition
                    if(batch.size()>= batchSize){
                        inventoryStagingRepo.saveAll(batch);
                        batch.clear();
                    }
                }
            }
            if(!batch.isEmpty()){
                inventoryStagingRepo.saveAll(batch);
                batch.clear();
            }
            
        }
        catch(IOException ex){
            ex.getMessage();
        }
    }

    @Override
    @Transactional
    public void processAndMerge() {
        // step 1: In this we delete all price less than Zero aur Less than 
        inventoryStagingRepo.deleteByPriceLessThanEqual(BigDecimal.ZERO);

        // step 2: now we merge duplicate entry and send data to new final inventory database
        inventoryRepo.aggregateAndMerge();
    }


}

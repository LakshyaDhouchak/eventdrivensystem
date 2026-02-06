package com.lakshya.ecommerce.eventdrivensystem.commandLineRunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.lakshya.ecommerce.eventdrivensystem.processed.FileConfig;
import com.lakshya.ecommerce.eventdrivensystem.service.InventoryServiceInterface;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataLoadRunner implements CommandLineRunner{
    // define the properties
    private final InventoryServiceInterface inventoryServiceInterface;
    @Override
    public void run(String... args) throws Exception {
        inventoryServiceInterface.ingectCsv(FileConfig.ORDERS_FILE);
    }
    
}

package com.lakshya.ecommerce.eventdrivensystem.service;

public interface InventoryServiceInterface {
    // define the abstract methord
    void ingectCsv(String filePath);
    void processAndMerge();
}

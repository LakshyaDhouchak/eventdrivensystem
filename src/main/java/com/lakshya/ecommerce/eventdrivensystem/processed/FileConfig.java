package com.lakshya.ecommerce.eventdrivensystem.processed;

import java.io.File;

public class FileConfig {
    // define the properties
    public static final String INPUT_DIR = "input";
    public static final String OUTPUT_DIR = "output";
    public static final String INVENTORY_FILE = INPUT_DIR + File.separator + "ecommerce_dataset.csv";
    public static final String ORDERS_FILE = INPUT_DIR + File.separator + "products.csv";
    public static final String UPDATED_ORDERS = OUTPUT_DIR + File.separator +"ecommerce_final_datasets.csv";

    // define the header attribute fo find
    public static final String COL_PRODUCT_ID = "product_id";
    public static final String COL_CATAGORY = "category";
}

-- define the inventory staging table
CREATE TABLE IF NOT EXISTS inventory_staging(
    staging_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    uniq_id VARCHAR(100),
    crawl_timestamp TIMESTAMP,
    product_title VARCHAR(500),
    category VARCHAR(255),
    product_description TEXT,
    pack_size_quantity INT,
    price DECIMAL(10,2),
    ingestion_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    source_system VARCHAR(50) DEFAULT 'KAGGLE'
    
);
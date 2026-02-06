-- define the inventory table
CREATE TABLE IF NOT EXISTS inventory(
    product_id VARCHAR(100) PRIMARY KEY,
    category VARCHAR(255) NOT NULL,
    product_title VARCHAR(500) NOT NULL,
    product_description TEXT,
    pack_size_quantity INT ,
    price DECIMAL(10,2) NOT NULL,
    stock_quantity INT NOT NULL,
    crawl_timestamp TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
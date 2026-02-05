CREATE INDEX idx_inventory_category ON inventory(category);
CREATE INDEX idx_inventory_product_title ON inventory(product_title);

ALTER TABLE inventory ADD CONSTRAINT chk_stock_quantity CHECK(stock_quantity>=0);

ALTER TABLE inventory MODIFY updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP;
-- make the order table
CREATE TABLE IF NOT EXISTS orders(
    order_id BIGINT PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    order_date TIMESTAMP NOT NULL,
    order_status VARCHAR(20) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_orders_consumer
        FOREIGN KEY (consumer_id)
        REFERENCES consumers(consumer_id),

    CONSTRAINT chk_order_status
        CHECK (order_status IN('PENDING' ,'COMPLETED','CANCELLED'))    
);
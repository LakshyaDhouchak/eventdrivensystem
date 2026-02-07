-- make the reviews table
CREATE TABLE IF NOT EXISTS reviews(
    review_id BIGINT PRIMARY KEY,
    order_id BIGINT NOT NULL,
    customer_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    review_text TEXT,
    review_date DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_reviews_order
        FOREIGN KEY(order_id)
        REFERENCES orders(order_id),
    CONSTRAINT fk_reviews_consumer
        FOREIGN KEY (consumer_id)
        REFERENCES consumers(consumer_id),
    CONSTRAINT fk_reviews_product
        FOREIGN KEY(product_id)
        REFERENCES products(product_id)    
);
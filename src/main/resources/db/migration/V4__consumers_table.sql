-- make the customer table
CREATE TABLE IF NOT EXISTS customers(
    consumer_id BIGINT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    gender VARCHAR(20),
    age_group VARCHAR(50),
    signup_date VARCHAR(100),
    country VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
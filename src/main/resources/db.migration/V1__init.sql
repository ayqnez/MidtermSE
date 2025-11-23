-- ============================
-- USERS TABLE
-- ============================
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

-- ============================
-- PRODUCTS TABLE
-- ============================
CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    description TEXT,
    category VARCHAR(255),
    in_stock BOOLEAN
);

-- ============================
-- ORDERS TABLE
-- ============================
CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    user_id BIGINT,
    CONSTRAINT fk_orders_user
        FOREIGN KEY (user_id)
            REFERENCES users (id)
            ON DELETE SET NULL
);

-- ============================
-- MANY-TO-MANY: orders_products
-- ============================
CREATE TABLE orders_products (
    orders_id BIGINT NOT NULL,
    products_id BIGINT NOT NULL,

    CONSTRAINT fk_orders_products_order
     FOREIGN KEY (orders_id)
         REFERENCES orders (id)
         ON DELETE CASCADE,

    CONSTRAINT fk_orders_products_product
     FOREIGN KEY (products_id)
         REFERENCES products (id)
         ON DELETE CASCADE
);


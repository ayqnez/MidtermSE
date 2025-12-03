CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    password VARCHAR(255)
);

CREATE TABLE permissions (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE users_permissions (
    user_id BIGINT NOT NULL,
    permission_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, permission_id),
    CONSTRAINT fk_user
     FOREIGN KEY (user_id)
         REFERENCES users(id)
         ON DELETE CASCADE,
    CONSTRAINT fk_permission
     FOREIGN KEY (permission_id)
         REFERENCES permissions(id)
         ON DELETE CASCADE
);

CREATE TABLE products (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    description TEXT,
    price INTEGER,
    category VARCHAR(255),
    in_stock BOOLEAN
);

CREATE TABLE orders (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT,
    CONSTRAINT fk_orders_user
      FOREIGN KEY (user_id)
          REFERENCES users (id)
          ON DELETE SET NULL
);


CREATE TABLE orders_products (
    order_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    CONSTRAINT fk_orders_products_order
       FOREIGN KEY (order_id)
           REFERENCES orders (id)
           ON DELETE CASCADE,
    CONSTRAINT fk_orders_products_product
       FOREIGN KEY (product_id)
           REFERENCES products (id)
           ON DELETE CASCADE
);
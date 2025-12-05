-- ============================
-- INSERT DEFAULT PERMISSIONS
-- ============================
INSERT INTO permissions (name)
VALUES ('ROLE_USER')
ON CONFLICT (name) DO NOTHING;

INSERT INTO permissions (name)
VALUES ('ROLE_ADMIN')
ON CONFLICT (name) DO NOTHING;

-- ============================
-- INSERT SAMPLE PRODUCTS
-- ============================
INSERT INTO products (name, description, category, in_stock)
VALUES
    ('Laptop', 'High performance laptop', 'Electronics', true),
    ('Book', 'Programming book', 'Books', true),
    ('Coffee Mug', 'Ceramic coffee mug', 'Home', true),
    ('Headphones', 'Wireless headphones', 'Electronics', false)
ON CONFLICT DO NOTHING;
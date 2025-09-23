CREATE TABLE lookup(
    id BIGSERIAL PRIMARY KEY,
    type VARCHAR(40) NOT NULL,
    code VARCHAR(80) NOT NULL,
    label VARCHAR(120) NOT NULL,
    parent_code VARCHAR(80),
    active BOOLEAN DEFAULT TRUE
);

CREATE TABLE customer(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(120) NOT NULL,
    document VARCHAR(40),
    default_destination VARCHAR(80),
    default_satellite VARCHAR(80),
    default_convenience VARCHAR(80)
);

CREATE TABLE purchase_request(
    id BIGSERIAL PRIMARY KEY,
    request_number VARCHAR(40) UNIQUE NOT NULL,
    customer_id BIGINT REFERENCES customer(id),
    destination VARCHAR(80),
    satellite VARCHAR(80),
    convenience VARCHAR(80),
    status VARCHAR(40) NOT NULL,
    created_at TIMESTAMPTZ,
    updated_at TIMESTAMPTZ
);

CREATE TABLE purchase_item(
    id BIGSERIAL PRIMARY KEY,
    purchase_request_id BIGINT REFERENCES purchase_request(id) ON DELETE CASCADE,
    brand VARCHAR(80) NOT NULL,
    model_name VARCHAR(80) NOT NULL,
    color VARCHAR(60) NOT NULL,
    gender VARCHAR(20) NOT NULL,
    lifecycle VARCHAR(30) NOT NULL,
    collection VARCHAR(40) NOT NULL,
    subcollection VARCHAR(60),
    sku_vendor VARCHAR(40),
    ean VARCHAR(40),
    size_scale VARCHAR(40),
    price_cost NUMERIC(12,2),
    price_list NUMERIC(12,2),
    standard_description VARCHAR(240) NOT NULL
);

-- script/schema.sql

CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  username VARCHAR(255),
  email VARCHAR(255),
  password VARCHAR(255)
);

CREATE TABLE api_entities (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255),
  description TEXT,
  base_url VARCHAR(255)
);

CREATE TABLE reviews (
  id SERIAL PRIMARY KEY,
  rating INT,
  comment TEXT,
  created_at TIMESTAMP,
  user_id BIGINT NOT NULL,
  api_id BIGINT NOT NULL,
  CONSTRAINT fk_user
    FOREIGN KEY (user_id) 
    REFERENCES users (id),
  CONSTRAINT fk_api
    FOREIGN KEY (api_id)
    REFERENCES api_entities (id)
);

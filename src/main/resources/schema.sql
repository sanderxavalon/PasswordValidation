CREATE TABLE config (
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    config_key VARCHAR(255) NOT NULL,
    config_value INTEGER NOT NULL
);
DROP TABLE IF EXISTS user;

CREATE TABLE user (
    id BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    created_date TIMESTAMP NOT NULL,
    last_modified_date TIMESTAMP NOT NULL,
    version BIGINT NOT NULL DEFAULT 0,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    is_account_non_expired BOOLEAN DEFAULT 1,
    is_account_non_locked BOOLEAN DEFAULT 1,
    is_credential_non_expired BOOLEAN DEFAULT 1,
    is_enabled BOOLEAN DEFAULT 1,
    PRIMARY KEY (id)
);
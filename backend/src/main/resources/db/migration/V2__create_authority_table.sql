DROP TABLE IF EXISTS authority;

CREATE TABLE authority
(
    id                 BIGINT       NOT NULL UNIQUE AUTO_INCREMENT,
    created_date       TIMESTAMP    NOT NULL,
    last_modified_date TIMESTAMP    NOT NULL,
    version            BIGINT       NOT NULL DEFAULT 0,
    permission         VARCHAR(100) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

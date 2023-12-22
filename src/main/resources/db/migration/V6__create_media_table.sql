DROP TABLE IF EXISTS media;

CREATE TABLE media
(
    id                 BIGINT                            NOT NULL UNIQUE AUTO_INCREMENT,
    created_date       TIMESTAMP                         NOT NULL,
    last_modified_date TIMESTAMP                         NOT NULL,
    version            BIGINT                            NOT NULL DEFAULT 0,
    title              VARCHAR(200)                      NOT NULL,
    category           ENUM ("movie", "tv_series")       NOT NULL,
    rating             ENUM ("pg", "e", "eighteen_plus") NOT NULL,
    is_trending        BOOLEAN                                    DEFAULT FALSE,
    year               INT                               NOT NULL,
    image              LONGBLOB
);


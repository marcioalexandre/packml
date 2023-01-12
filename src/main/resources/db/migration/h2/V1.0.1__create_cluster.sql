CREATE TABLE IF NOT EXISTS cluster (
    id              SERIAL NOT NULL PRIMARY KEY,
    cluster_id      INTEGER,
    name            VARCHAR(255),
    description     VARCHAR(255)
);
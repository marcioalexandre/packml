CREATE TABLE IF NOT EXISTS component (
    id              SERIAL NOT NULL PRIMARY KEY,
    cluster_id      INTEGER NOT NULL,
    url             VARCHAR(255),
    name            VARCHAR(255),
    machine_number  INTEGER
);
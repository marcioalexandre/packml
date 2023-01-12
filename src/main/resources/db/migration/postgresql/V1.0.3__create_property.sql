CREATE TABLE IF NOT EXISTS property (
    id              SERIAL NOT NULL PRIMARY KEY,
    parent_id       INTEGER NOT NULL,
    type            VARCHAR(20),
    name            VARCHAR(255),
    value           VARCHAR(255)
);
CREATE TABLE registration_vehicle
(
    id                VARCHAR(7) PRIMARY KEY,
    model             VARCHAR,
    series            VARCHAR,
    year_production   INTEGER,
    year_registration INTEGER,
    valid             BOOLEAN
);
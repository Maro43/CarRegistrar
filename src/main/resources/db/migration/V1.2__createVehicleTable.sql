CREATE TABLE registration_vehicle
(
    id                VARCHAR(7) PRIMARY KEY,
    model             VARCHAR,
    series            VARCHAR,
    year_production   INTEGER,
    year_registration INTEGER,
    valid             BOOLEAN,
    owner_id          INTEGER,
    FOREIGN KEY (owner_id) references owner (id)
);

CREATE UNIQUE INDEX idx_registration_vehicle_id ON car_api.registration_vehicle (id);
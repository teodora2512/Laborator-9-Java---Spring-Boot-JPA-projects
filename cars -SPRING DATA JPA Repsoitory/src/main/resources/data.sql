
INSERT INTO masini (license_plate, brand, an_fabricatie, culoare, nr_km)
VALUES
    ('AB-12-ABC', 'BMW', 2018, 'Black', 85000),
    ('BC-23-BCD', 'Audi', 2020, 'White', 45000),
    ('CD-34-CDE', 'Mercedes', 2019, 'Silver', 60000),
    ('DE-45-DEF', 'Volkswagen', 2017, 'Blue', 120000),
    ('EF-56-EFG', 'Toyota', 2021, 'Red', 25000)
    ON DUPLICATE KEY UPDATE
                         brand = VALUES(brand),
                         an_fabricatie = VALUES(an_fabricatie),
                         culoare = VALUES(culoare),
                         nr_km= VALUES(nr_km);
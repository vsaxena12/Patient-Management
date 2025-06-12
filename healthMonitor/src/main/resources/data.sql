-- Ensure the 'patient_entity' table exists
CREATE TABLE IF NOT EXISTS patient_entity
(
    id                  UUID PRIMARY KEY,
    first_name          VARCHAR(255)        NOT NULL,
    last_name           VARCHAR(255)        NOT NULL,
    email               VARCHAR(255) UNIQUE NOT NULL,
    address             VARCHAR(255)        NOT NULL,
    date_of_birth       DATE                NOT NULL,
    date_of_admit       DATE                NOT NULL,
    date_of_discharge   DATE                NOT NULL
);

-- Insert well-known UUIDs for specific patient_entitys
INSERT INTO patient_entity (id, first_name, last_name, email, address, date_of_birth, date_of_admit, date_of_discharge)
SELECT '123e4567-e89b-12d3-a456-426614174000',
       'John',
       'Doe',
       'john.doe@example.com',
       '123 Main St, Springfield',
       '1985-06-15',
       '2024-01-10',
       '2024-01-11'
WHERE NOT EXISTS (SELECT 1
                  FROM patient_entity
                  WHERE id = '123e4567-e89b-12d3-a456-426614174000');

--INSERT INTO patient_entity (id, name, email, address, date_of_birth, date_of_admit, date_of_discharge)
--SELECT '123e4567-e89b-12d3-a456-426614174001',
--       'Jane Smith',
--       'jane.smith@example.com',
--       '456 Elm St, Shelbyville',
--       '1990-09-23',
--       '2023-12-01',
--       '2024-01-11'
--WHERE NOT EXISTS (SELECT 1
--                  FROM patient_entity
--                  WHERE id = '123e4567-e89b-12d3-a456-426614174001');
--
--INSERT INTO patient_entity (id, name, email, address, date_of_birth, date_of_admit, date_of_discharge)
--SELECT '123e4567-e89b-12d3-a456-426614174002',
--       'Alice Johnson',
--       'alice.johnson@example.com',
--       '789 Oak St, Capital City',
--       '1978-03-12',
--       '2022-06-20',
--       '2025-01-12'
--WHERE NOT EXISTS (SELECT 1
--                  FROM patient_entity
--                  WHERE id = '123e4567-e89b-12d3-a456-426614174002');
--
--INSERT INTO patient_entity (id, name, email, address, date_of_birth, date_of_admit, date_of_discharge)
--SELECT '123e4567-e89b-12d3-a456-426614174003',
--       'Bob Brown',
--       'bob.brown@example.com',
--       '321 Pine St, Springfield',
--       '1982-11-30',
--       '2023-05-14',
--       '2023-06-10'
--WHERE NOT EXISTS (SELECT 1
--                  FROM patient_entity
--                  WHERE id = '123e4567-e89b-12d3-a456-426614174003');
--
---- Code is wrong here since Admit date cannot be later than discharge date
--INSERT INTO patient_entity (id, name, email, address, date_of_birth, date_of_admit, date_of_discharge)
--SELECT '123e4567-e89b-12d3-a456-426614174004',
--       'Emily Davis',
--       'emily.davis@example.com',
--       '654 Maple St, Shelbyville',
--       '1995-02-05',
--       '2024-03-01',
--       '2024-01-10'
--WHERE NOT EXISTS (SELECT 1
--                  FROM patient_entity
--                  WHERE id = '123e4567-e89b-12d3-a456-426614174004');
--
---- Insert well-known UUIDs for specific patient_entitys
--INSERT INTO patient_entity (id, name, email, address, date_of_birth, date_of_admit, date_of_discharge)
--SELECT '223e4567-e89b-12d3-a456-426614174005',
--       'Michael Green',
--       'michael.green@example.com',
--       '987 Cedar St, Springfield',
--       '1988-07-25',
--       '2024-02-15',
--       '2024-01-10'
--WHERE NOT EXISTS (SELECT 1 FROM patient_entity WHERE id = '223e4567-e89b-12d3-a456-426614174005');
--
--INSERT INTO patient_entity (id, name, email, address, date_of_birth, date_of_admit, date_of_discharge)
--SELECT '223e4567-e89b-12d3-a456-426614174006',
--       'Sarah Taylor',
--       'sarah.taylor@example.com',
--       '123 Birch St, Shelbyville',
--       '1992-04-18',
--       '2023-08-25'
--WHERE NOT EXISTS (SELECT 1 FROM patient_entity WHERE id = '223e4567-e89b-12d3-a456-426614174006');
--
--INSERT INTO patient_entity (id, name, email, address, date_of_birth, date_of_admit, date_of_discharge)
--SELECT '223e4567-e89b-12d3-a456-426614174007',
--       'David Wilson',
--       'david.wilson@example.com',
--       '456 Ash St, Capital City',
--       '1975-01-11',
--       '2022-10-10',
--       '2024-01-10'
--WHERE NOT EXISTS (SELECT 1 FROM patient_entity WHERE id = '223e4567-e89b-12d3-a456-426614174007');
--
--INSERT INTO patient_entity (id, name, email, address, date_of_birth, date_of_admit, date_of_discharge)
--SELECT '223e4567-e89b-12d3-a456-426614174008',
--       'Laura White',
--       'laura.white@example.com',
--       '789 Palm St, Springfield',
--       '1989-09-02',
--       '2024-04-20',
--       '2024-01-10'
--WHERE NOT EXISTS (SELECT 1 FROM patient_entity WHERE id = '223e4567-e89b-12d3-a456-426614174008');
--
--INSERT INTO patient_entity (id, name, email, address, date_of_birth, date_of_admit, date_of_discharge)
--SELECT '223e4567-e89b-12d3-a456-426614174009',
--       'James Harris',
--       'james.harris@example.com',
--       '321 Cherry St, Shelbyville',
--       '1993-11-15',
--       '2023-06-30',
--       '2024-01-10'
--WHERE NOT EXISTS (SELECT 1 FROM patient_entity WHERE id = '223e4567-e89b-12d3-a456-426614174009');
--
--INSERT INTO patient_entity (id, name, email, address, date_of_birth, date_of_admit, date_of_discharge)
--SELECT '223e4567-e89b-12d3-a456-426614174010',
--       'Emma Moore',
--       'emma.moore@example.com',
--       '654 Spruce St, Capital City',
--       '1980-08-09',
--       '2023-01-22',
--       '2024-01-10'
--WHERE NOT EXISTS (SELECT 1 FROM patient_entity WHERE id = '223e4567-e89b-12d3-a456-426614174010');
--
--INSERT INTO patient_entity (id, name, email, address, date_of_birth, date_of_admit, date_of_discharge)
--SELECT '223e4567-e89b-12d3-a456-426614174011',
--       'Ethan Martinez',
--       'ethan.martinez@example.com',
--       '987 Redwood St, Springfield',
--       '1984-05-03',
--       '2024-05-12',
--       '2024-01-10'
--WHERE NOT EXISTS (SELECT 1 FROM patient_entity WHERE id = '223e4567-e89b-12d3-a456-426614174011');
--
--INSERT INTO patient_entity (id, name, email, address, date_of_birth, date_of_admit, date_of_discharge)
--SELECT '223e4567-e89b-12d3-a456-426614174012',
--       'Sophia Clark',
--       'sophia.clark@example.com',
--       '123 Hickory St, Shelbyville',
--       '1991-12-25',
--       '2022-11-11',
--       '2024-01-10'
--WHERE NOT EXISTS (SELECT 1 FROM patient_entity WHERE id = '223e4567-e89b-12d3-a456-426614174012');
--
--INSERT INTO patient_entity (id, name, email, address, date_of_birth, date_of_admit, date_of_discharge)
--SELECT '223e4567-e89b-12d3-a456-426614174013',
--       'Daniel Lewis',
--       'daniel.lewis@example.com',
--       '456 Cypress St, Capital City',
--       '1976-06-08',
--       '2023-09-19',
--       '2024-01-10'
--WHERE NOT EXISTS (SELECT 1 FROM patient_entity WHERE id = '223e4567-e89b-12d3-a456-426614174013');
--
--INSERT INTO patient_entity (id, name, email, address, date_of_birth, date_of_admit, date_of_discharge)
--SELECT '223e4567-e89b-12d3-a456-426614174014',
--       'Isabella Walker',
--       'isabella.walker@example.com',
--       '789 Willow St, Springfield',
--       '1987-10-17',
--       '2024-03-29',
--       '2024-01-10'
--WHERE NOT EXISTS (SELECT 1 FROM patient_entity WHERE id = '223e4567-e89b-12d3-a456-426614174014');
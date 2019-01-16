CREATE USER pfm_dbo    WITH ENCRYPTED PASSWORD 'Alien.44';
CREATE USER pfm_access WITH ENCRYPTED PASSWORD 'Alien.44';
CREATE USER pfm_test   WITH ENCRYPTED PASSWORD 'Test.99';

CREATE DATABASE pfm_db      WITH OWNER pfm_dbo;
CREATE DATABASE pfm_test_db WITH OWNER pfm_dbo;

GRANT ALL PRIVILEGES ON DATABASE pfm_db TO pfm_dbo;
GRANT ALL PRIVILEGES ON DATABASE pfm_db TO pfm_access;

GRANT ALL PRIVILEGES ON DATABASE pfm_test_db TO pfm_dbo;
GRANT ALL PRIVILEGES ON DATABASE pfm_test_db TO pfm_test;

-- Run as admin user to create a new user

--DROP USER demo;
CREATE USER demo                -- Sets the username for a new user
IDENTIFIED BY password          -- Sets the password
DEFAULT TABLESPACE users        -- Defines the default tablespace for the user
TEMPORARY TABLESPACE temp       -- Defines a temporary tablespace
QUOTA 10M ON users;             -- Establishes a row quota for the tablespace



GRANT CONNECT TO demo;
GRANT RESOURCE TO demo;
GRANT CREATE SESSION TO demo;
GRANT CREATE TABLE TO demo;
GRANT CREATE VIEW TO demo;
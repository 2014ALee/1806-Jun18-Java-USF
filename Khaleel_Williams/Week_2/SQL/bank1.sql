/********************************************************************************/
DROP USER bank CASCADE;


/*******************************************************************************
   Create database
********************************************************************************/
CREATE USER bank
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to bank;
GRANT resource to bank;
GRANT create session TO bank;
GRANT create table TO bank;
GRANT create view TO bank;

--DROP TABLE customers;



/*******************************************************************************
   Create database
********************************************************************************/
CREATE USER bankproject
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to bankproject;
GRANT resource to bankproject;
GRANT create session TO bankproject;
GRANT create table TO bankproject;
GRANT create view TO bankproject;

conn bankproject/p4ssw0rd

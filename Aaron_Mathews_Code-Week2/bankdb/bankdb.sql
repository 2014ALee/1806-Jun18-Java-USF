CREATE USER bankdb
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to bankdb;
GRANT resource to bankdb;
GRANT create session TO bankdb;
GRANT create table TO bankdb;
GRANT create view TO bankdb;
CREATE USER banker
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to banker;
GRANT resource to banker;
GRANT create session TO banker;
GRANT create table TO banker;
GRANT create view TO banker;
CREATE USER empl
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to empl;
GRANT resource to empl;
GRANT create session TO empl;
GRANT create table TO empl;
GRANT create view TO empl;
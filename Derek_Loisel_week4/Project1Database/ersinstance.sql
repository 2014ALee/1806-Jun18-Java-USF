CREATE USER ersproject
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to ersproject;
GRANT resource to ersproject;
GRANT create session TO ersproject;
GRANT create table TO ersproject;
GRANT create view TO ersproject;

conn ersproject/p4ssw0rd
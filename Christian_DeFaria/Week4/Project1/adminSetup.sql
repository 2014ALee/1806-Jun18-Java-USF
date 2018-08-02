CREATE USER 'manager'@'%' IDENTIFIED BY 'p4ssw0rd';
GRANT ALL ON scoop_share.* TO 'manager'@'%';
--DEFAULT TABLESPACE users
--TEMPORARY TABLESPACE temp
--QUOTA 10M ON users;

--GRANT connect to manager;
--GRANT resource to manager;
--GRANT create session TO manager;
--GRANT create table TO manager;
--GRANT create view TO manager;
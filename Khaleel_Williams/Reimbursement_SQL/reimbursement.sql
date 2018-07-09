/*******************************************************************************
   Drop database if it exists
********************************************************************************/
DROP USER reimbursement CASCADE;


/*******************************************************************************
   Create database
********************************************************************************/
CREATE USER reimbursement
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to reimbursement;
GRANT resource to reimbursement;
GRANT create session TO reimbursement;
GRANT create table TO reimbursement;
GRANT create view TO reimbursement;

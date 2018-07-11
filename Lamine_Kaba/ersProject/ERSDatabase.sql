
CREATE USER lkaba              -- Sets the username for a new user
IDENTIFIED BY kaquev11          -- Sets the password for the new user
DEFAULT TABLESPACE users        -- Defines a default tablespace
TEMPORARY TABLESPACE temp       -- Defines a temporary tablespace
QUOTA 10M ON users;             -- Establishes a row quota for the table space


GRANT CONNECT TO lkaba;                -- Necessary to be able to connect to the DB
GRANT RESOURCE TO lkaba;               -- Necessary to access DB resources
GRANT CREATE SESSION TO lkaba;         -- Necessary to be able to create DB sessions
GRANT CREATE TABLE TO lkaba;           -- Necessary to be able to create tables
GRANT CREATE VIEW TO lkaba;            -- Necessary to be able to create views

--Create table users

CREATE TABLE ers_users (
    ers_users_id             NUMBER  PRIMARY KEY,-- on this line you can write PRIMARY KEY, but you can't specify the name; to specify the name of the constraint create constraint below the table creation.
    ers_username           VARCHAR2(50)   UNIQUE,
    ers_password            VARCHAR2(50),
    ers_first_name          VARCHAR2(100),
    ers_last_name           VARCHAR2(100),
    ers_email               VARCHAR2(150)   UNIQUE,
    ers_role_id             NUMBER,
    
    --CONSTRAINT ers_users_pk PRIMARY KEY(ers_users_id),
    CONSTRAINT ers_users_pk 
        FOREIGN KEY (ers_role_id)
        REFERENCES ers_user_roles (ers_user_role_id)
);

-- Create the Reimbursement table and define its columns and their constraints
CREATE TABLE ers_reimbursement (
    reimb_id              NUMBER PRIMARY KEY,
    reimb_amount          NUMBER,
    reimb_submitted       Date,
    reimb_resolved        DATE,
    reimb_description     VARCHAR2(250),
    reimb_receipt         BLOB,
    reimb_author          number,
    reimb_resolver        NUMBER,
    reimb_status_id       number,
    reimb_type_id         NUMBER,
    
    --CONSTRAINT ers_reimbursement_pk PRIMARY KEY(reimb_id),
    CONSTRAINT ers_users_fk_auth 
        FOREIGN KEY (reimb_author)
        REFERENCES ers_users (ers_users_id),
    CONSTRAINT ers_users_fk_reslvr 
        FOREIGN KEY (reimb_resolver)
        REFERENCES ers_users (ers_users_id),
    CONSTRAINT ers_reimbursement_status_fk 
        FOREIGN KEY (reimb_status_id)
        REFERENCES ers_reimbursement_status (reimb_status_id),
    CONSTRAINT ers_reimbursement_type_fk 
        FOREIGN KEY (reimb_type_id)
        REFERENCES ers_reimbursement_type (reimb_type_id)
);

-- Create the Reimbursement status table and define its columns and their constraints
CREATE TABLE ers_reimbursement_status (
    reimb_status_id      NUMBER CONSTRAINT reimb_status_pk PRIMARY KEY,
    reimb_status        VARCHAR2(10) 
);

-- Create the Reimbursement type table and define its columns and their constraints
CREATE TABLE ers_reimbursement_type (
    reimb_type_id       NUMBER CONSTRAINT reimb_type_pk PRIMARY KEY,
    reimb_type        VARCHAR2(10)
);

-- Create the user roles table and define its columns and their constraints
CREATE TABLE ers_user_roles (
    ers_user_role_id    NUMBER CONSTRAINT ers_user_roles_pk PRIMARY KEY,
    user_role        VARCHAR2(10)
);

-- Create sequenses for each table

CREATE SEQUENCE SQ_ers_users_id
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
  
  CREATE SEQUENCE SQ_reimb_id
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
  
CREATE SEQUENCE SQ_reimb_status_id
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
  
    
CREATE SEQUENCE SQ_reimb_type_id
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
  
CREATE SEQUENCE SQ_ers_user_role_id
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
  
  --Create trigglers for each table using the sequences
create or replace TRIGGER TR_reimb_id
    BEFORE INSERT
    ON ers_reimbursement 
    FOR EACH ROW
    BEGIN
    :NEW.reimb_id := SQ_reimb_id.nextval ;
    END TR_reimb_id;
    
    
create or replace TRIGGER TR_reimb_status_id
    BEFORE INSERT
    ON ers_reimbursement_status 
    FOR EACH ROW
    BEGIN
    :NEW.reimb_status_id := SQ_reimb_status_id.NEXTVAL ;
    END TR_reimb_status_id;
    
create or replace TRIGGER TR_reimb_type_id
    BEFORE INSERT
    ON ers_reimbursement_type 
    FOR EACH ROW
    BEGIN
    :NEW.reimb_type_id := SQ_reimb_type_id.NEXTVAL ;
    END TR_reimb_type_id;
    
create or replace TRIGGER TR_ers_user_role_id
    BEFORE INSERT
    ON ers_user_roles 
    FOR EACH ROW
    BEGIN
    :NEW.ers_user_role_id := SQ_ers_user_role_id.NEXTVAL ;
    END TR_ers_user_role_id;
    
create or replace TRIGGER TR_ers_users_id
    BEFORE INSERT
    ON ers_users 
    FOR EACH ROW
    BEGIN
    :NEW.ers_users_id := SQ_ers_users_id.NEXTVAL ;
    END TR_ers_users_id;



 
 
  
 select SUPPLIER_SEQ.NEXTVAL from SYS.DUAL;

DROP TABLE ers_users;
DROP TABLE ers_reimbursement;
DROP TABLE ers_reimbursement_status;
DROP TABLE ers_reimbursement_type;
DROP TABLE ers_user_roles;

ALTER TABLE ers_users 
	DROP CONSTRAINT ers_users_pk;
    
 DROP SEQUENCE SUPPLIER_SEQ;







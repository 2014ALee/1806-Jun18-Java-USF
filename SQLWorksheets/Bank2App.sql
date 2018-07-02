CREATE USER scripttanuki              -- Sets the username for a new user
IDENTIFIED BY password          -- Sets the password for the new user
DEFAULT TABLESPACE SYSTEM        -- Defines a default tablespace
TEMPORARY TABLESPACE temp       -- Defines a temporary tablespace
QUOTA 10M ON SYSTEM;             -- Establishes a row quota for the table space

UPDATE ALL_USERS SET balance = ?;
SELECT * FROM DBA_USERS;
DROP USER TEST1 CASCADE;
DROP USER TEST2 CASCADE;
DROP USER TEST3 CASCADE;
DROP USER HTEST CASCADE;
DROP USER SQLTEST CASCADE;
DROP USER TESTMAN CASCADE;
DROP USER WHYPLEASE CASCADE;
DROP USER OTHERKIDS CASCADE;
DROP USER SOMEHOWCONFLICTINGNAME CASCADE;
DROP USER LOL CASCADE;
DROP USER MRTEST CASCADE;
DROP USER PLEASEWORK CASCADE;
DROP USER TEST2 CASCADE;

GRANT CONNECT TO scripttanuki WITH ADMIN OPTION;                -- Necessary to be able to connect to the DB
GRANT RESOURCE TO scripttanuki WITH ADMIN OPTION;               -- Necessary to access DB resources
GRANT CREATE SESSION TO scripttanuki WITH ADMIN OPTION;         -- Necessary to be able to create DB sessions
GRANT CREATE TABLE TO scripttanuki;           -- Necessary to be able to create tables
GRANT CREATE VIEW TO scripttanuki;            -- Necessary to be able to create views
GRANT INSERT ON ALL_USERS TO scripttanuki; -- || user_name;
GRANT CREATE USER TO scripttanuki;
GRANT ANY ROLE TO scripttanuki WITH ADMIN OPTION;

SELECT * from SYSTEM;

GRANT ANY PRIVILEGE TO codetanuki;
GRANT ADMINISTER TO codetanuki WITH ADMIN OPTION;
GRANT ANY ROLE TO scripttanuki WITH ADMIN OPTION;
SELECT * FROM DBA_TAB_PRIVS tp WHERE tp.owner = 'codetanuki' AND tp.table_name = 'ALL_USERS';
SELECT * FROM DBA_SYS_PRIVS;
--Worksheet for Query/procedure testing

--Initial table, all users inputs start here.
CREATE TABLE ALL_USERS(
    username    VARCHAR2(20) CONSTRAINT pk_username PRIMARY KEY,
    first_name  VARCHAR2(20) NOT NULL,
    last_name   VARCHAR2(20) NOT NULL,
    email       VARCHAR2(20) UNIQUE NOT NULL,
    balance     NUMBER(5,2) DEFAULT (0.00) NOT NULL
    )

--procedure for creating a user
    CREATE OR REPLACE PROCEDURE register_user(
    fn IN VARCHAR2, ln IN VARCHAR2,user_name IN VARCHAR2,
    pw IN VARCHAR2, em IN VARCHAR2)
    IS
    BEGIN
        EXECUTE IMMEDIATE 'CREATE USER'|| user_name|| 'IDENTIFIED BY'|| pw|| 'DEFAULT TABLESPACE SYSTEM';
        EXECUTE IMMEDIATE 'GRANT CONNECT TO'|| user_name;
        --EXECUTE IMMEDIATE 'GRANT RESOURCE TO'|| user_name;
        INSERT INTO ALL_USERS(username, first_name, last_name,email) VALUES (user_name, fn, ln, em);
    END;
    /
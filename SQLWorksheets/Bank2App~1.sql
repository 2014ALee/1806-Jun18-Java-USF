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
        INSERT INTO ALL_USERS(username, first_name, last_name,email) VALUES (user_name, fn, ln, em);
    END;
    /
    
    CREATE OR REPLACE PROCEDURE check_username(
    username IN VARCHAR2, counter INOUT NUMBER)
    IS
    other_username VARCHAR2 (25);
    BEGIN
        SELECT COUNT(1) INTO counter FROM ALL_USERS WHERE (username = other_username);
    END;
    /
    
    CREATE OR REPLACE PROCEDURE check_email(
    email IN VARCHAR2, counter OUT NUMBER)
    IS
    other_email VARCHAR2 (25);
    BEGIN
        SELECT COUNT(1) INTO counter FROM ALL_USERS WHERE (email = other_email);
    END;
    /
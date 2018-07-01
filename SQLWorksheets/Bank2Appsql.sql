
Error starting at line : 1 in command -
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
        EXECUTE IMMEDIATE 'CREATE USER'|| user_name|| 'IDENTIFIED BY'|| pw|| 'DEFAULT TABLESPACE SYSTEM'
Error report -
ORA-00922: missing or invalid option
00922. 00000 -  "missing or invalid option"
*Cause:    
*Action:

Error starting at line : 16 in command -
BEGIN IMMEDIATE 'GRANT CONNECT TO'|| user_name; END;
Error report -
ORA-06550: line 1, column 17:
PLS-00103: Encountered the symbol "GRANT CONNECT TO" when expecting one of the following:

   := . ( @ % ;
The symbol ":=" was substituted for "GRANT CONNECT TO" to continue.
06550. 00000 -  "line %s, column %s:\n%s"
*Cause:    Usually a PL/SQL compilation error.
*Action:

Error starting at line : 18 in command -
        INSERT INTO ALL_USERS(username, first_name, last_name,email) VALUES (user_name, fn, ln, em)
Error at Command Line : 18 Column : 97
Error report -
SQL Error: ORA-00984: column not allowed here
00984. 00000 -  "column not allowed here"
*Cause:    
*Action:

Error starting at line : 19 in command -
    END
Error report -
Unknown Command


Table ALL_USERS created.


Procedure REGISTER_USER compiled


Create TABLE allUsers (
    user_id              NUMBER(5) CONSTRAINT pk_user_id PRIMARY KEY,
    first_name              VARCHAR2(25),
    last_name              VARCHAR2(25),
    username              VARCHAR2(20),
    password              VARCHAR2(20),
    email               VARCHAR2(255)
    );
    COMMIT;
    
    drop table allusers;
    
    CREATE TABLE account (
    account_id              NUMBER(5) CONSTRAINT pk_account_id PRIMARY KEY,
    user_id                  number(5),
    checking              number(12,2),
    savings              number(12,2),
    CONSTRAINT accout_id_cst 
        FOREIGN KEY (user_id)
    REFERENCES Allusers (user_id)
    );
    Commit;
    
    drop table account;
    
CREATE OR REPLACE TRIGGER TR_userId
    BEFORE INSERT
    ON allUsers 
    FOR EACH ROW
    BEGIN
    :NEW.user_id := SQ_USERID.NEXTVAL ;
    END TR_userId;
    
CREATE OR REPLACE TRIGGER TR_accountId
    BEFORE INSERT
    ON account 
    FOR EACH ROW
    BEGIN
    :NEW.account_id := SQ_ACCOUNTID.NEXTVAL ;
    END TR_accountId;
 
create SEQUENCE sq_accountId;

Select sq_accountid.nextval from dual; -- Check the sequencial NUMBER ON the console

drop SEQUENCE sq_userId;
drop TRIGGER tr_userid;

INSERT INTO allUsers(first_name,last_name,username,password,email) values('No', 'Quevedo', 'nquevedo', 'norma', 'nq@y.com');
COMMIT;

INSERT INTO account(CHECKING, savings)VALUES(100, 100);
COMMIT;

--Check to see if the trigger is enabled
SELECT TRIGGER_NAME, STATUS FROM USER_TRIGGERS; --ALL triggers IN the database
SELECT STATUS FROM USER_TRIGGERS WHERE TRIGGER_NAME = 'TR_UserI'; -- particular trigger 














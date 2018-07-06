USE Bank;
DROP Table IF EXISTS users;

CREATE TABLE users(

    users_id             NUMBER(8)      CONSTRAINT pk_users PRIMARY KEY,

    username            VARCHAR2(25),

    p4ssword            VARCHAR2(25),

    email               VARCHAR2(200)

    );

    CREATE SEQUENCE users_Seq
    Start WITH 1;
    
    CREATE OR REPLACE TRIGGER user_trigger

BEFORE INSERT ON users

FOR EACH ROW

BEGIN

    SELECT users_seq.NEXTVAL

    INTO :new.users_id

    FROM dual; 
END;
/

CREATE TABLE BankApp (

    account_id           NUMBER(8)      CONSTRAINT pk_account_id PRIMARY KEY,

    users_id              NUMBER(8), 

    user_number          VARCHAR2(10),

    credbalance              NUMBER(8),

    user_account        VARCHAR2(8),

    

    CONSTRAINT fk_account_customer 

    FOREIGN KEY (users_id) 

    REFERENCES customer (users_id)

    );

INSERT INTO users VALUES (1, 'Teddy', 'Smith', 'teddy@gmail.com');

INSERT INTO users VALUES (2, 'Arianna', 'Gray', 'gray@yahoo.com');


INSERT INTO BankApp VALUES(1, 1, 000001, 0, 'Checking');

INSERT INTO BankApp VALUES(2, 1, 000002, 0, 'Savings');

INSERT INTO BankApp VALUES(3, 2, 000003, 120, 'Checking');

UPDATE "user"

SET user_name = 'Teddy',

    p4ssword = 'teddys'

WHERE user_id = 2;

CREATE SEQUENCE user_sequence

MINVALUE 1

MAXVALUE 999999999

INCREMENT BY 1

START WITH 3;

CREATE OR REPLACE TRIGGER user_trigger

BEFORE INSERT ON users

FOR EACH ROW

BEGIN

    SELECT users_seq.NEXTVAL

    INTO :new.users_id

    FROM dual; 
END;
/

CREATE SEQUENCE account_sequence

MINVALUE 1

MAXVALUE 999999999

INCREMENT BY 1

START WITH 4;

CREATE OR REPLACE TRIGGER account_trigger

BEFORE INSERT ON "account"

FOR EACH ROW

BEGIN

    SELECT account_seqence.NEXTVAL

    INTO :new.account_id

    FROM dual; 
END;
/
commit;
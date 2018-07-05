CREATE TABLE customer(
    cust_id             NUMBER(8)      CONSTRAINT pk_cust PRIMARY KEY,
    username            VARCHAR2(25),
    pass_word            VARCHAR2(25),
    email               VARCHAR2(200)
    );
    
CREATE TABLE BankAccount (
    account_id           NUMBER(8)      CONSTRAINT pk_account_id PRIMARY KEY,
    cust_id              NUMBER(8), 
    account_num          VARCHAR2(10),
    balance              NUMBER(8),
    account_type        VARCHAR2(8),
    
    CONSTRAINT fk_account_customer 
    FOREIGN KEY (cust_id) 
    REFERENCES customer (cust_id)
    );
    
INSERT INTO customer VALUES (1, 'John', 'Beineke', 'john.beineke@gmail.com');
INSERT INTO customer VALUES (2, 'Bill', 'Smith', 'bsmith@yahoo.com');

INSERT INTO BankAccount VALUES(1, 1, 000001, 0, 'Checking');
INSERT INTO BankAccount VALUES(2, 1, 000002, 0, 'Savings');
INSERT INTO BankAccount VALUES(3, 2, 000003, 120, 'Checking');

UPDATE "user"
SET user_name = 'bsmith',
    pass_word = '123'
WHERE user_id = 2;


CREATE SEQUENCE cust_seq
MINVALUE 1
MAXVALUE 999999999
INCREMENT BY 1
START WITH 3;

CREATE OR REPLACE TRIGGER cust_trig
BEFORE INSERT ON customer
FOR EACH ROW
BEGIN
    SELECT cust_seq.NEXTVAL
    INTO :new.cust_id
    FROM dual; 
END;
/

CREATE SEQUENCE BankAccount_seq
MINVALUE 1
MAXVALUE 999999999
INCREMENT BY 1
START WITH 4;

CREATE OR REPLACE TRIGGER BankAccount1
BEFORE INSERT ON BankAccount
FOR EACH ROW
BEGIN
    SELECT account_seq.NEXTVAL
    INTO :new.account_id
    FROM dual; 
END;
/

CREATE OR REPLACE TRIGGER BankAccount
BEFORE INSERT ON BankAccount
FOR EACH ROW
BEGIN
    SELECT BankAccount_seq.NEXTVAL
    INTO :new.account_num
    FROM dual; 
END;
/

commit;

ALTER TABLE BankAccount
RENAME COLUMN user_id to cust_id;

commit;

DELETE 
FROM CUSTOMER
WHERE username = "1";

CREATE OR REPLACE PROCEDURE get_user_accounts(
    custid IN BANKACCOUNT.CUST_ID%TYPE,
    my_cursor OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN my_cursor FOR
    SELECT * 
    FROM BankAccount
    WHERE BankAccount.cust_id = custid;
END;
/







--DROP TABLE Customers;
--DROP TABLE Accounts;
--DROP TABLE UserAccounts;
--DROP TABLE Transactions;

CREATE TABLE Customers
(
    customerId  NUMBER          NOT NULL,
    username    varchar(20)     NOT NULL,
    email       varchar(60)     NOT NULL,
    pw          varchar(255)    NOT NULL,
    
    CONSTRAINT  PK_Customers    PRIMARY KEY (customerId)
);

CREATE TABLE Accounts
(
    accountId   NUMBER      NOT NULL,
    accountType VARCHAR(8)  NOT NULL,
    balance     NUMBER(9,2) NOT NULL,
    
    CONSTRAINT  PK_Accounts PRIMARY KEY (accountId)
);

CREATE TABLE UserAccounts
(
    customerId    NUMBER  NOT NULL,
    accountId       NUMBER  NOT NULL,
    
    CONSTRAINT FK_CustomerId FOREIGN KEY (customerId)
    REFERENCES Customers (customerId)
    ON DELETE CASCADE,
    
    CONSTRAINT FK_AccountId  FOREIGN KEY (accountId)
    REFERENCES Accounts (accountId)
    ON DELETE CASCADE,
    
    CONSTRAINT PK_UserAccountsId PRIMARY KEY (customerId, accountId)
);

CREATE TABLE Transactions
(
    transactionId   NUMBER  NOT NULL,
    amount          NUMBER  NOT NULL,
    userId          NUMBER  NOT NULL,
    fromAccount     NUMBER  NOT NULL,
    toAccount       NUMBER  NOT NULL,
    
    CONSTRAINT  PK_TransactionsId PRIMARY KEY (transactionId),
    
    CONSTRAINT FK_CustomerTransId FOREIGN KEY (userId)
    REFERENCES Customers (customerId)
    ON DELETE CASCADE,
    
    CONSTRAINT FK_Account1Id FOREIGN KEY (fromAccount)
    REFERENCES Accounts (accountId)
    ON DELETE CASCADE,
    
    CONSTRAINT FK_Account2Id FOREIGN KEY (toAccount)
    REFERENCES Accounts (accountId)
    ON DELETE CASCADE
);

CREATE SEQUENCE cust_seq
MINVALUE 1
MAXVALUE 9999999999
INCREMENT BY 1
START WITH 1;

CREATE OR REPLACE TRIGGER cust_trigger
BEFORE INSERT ON customers
FOR EACH ROW

BEGIN
    SELECT cust_seq.NEXTVAL
    INTO :new.customerid
    FROM dual;
END;
/

CREATE SEQUENCE acc_seq
MINVALUE 1
MAXVALUE 9999999999
INCREMENT BY 1
START WITH 1;

CREATE OR REPLACE TRIGGER acc_trigger
BEFORE INSERT ON accounts
FOR EACH ROW

BEGIN
    SELECT acc_seq.NEXTVAL
    INTO :new.accountid
    FROM dual;
END;
/

CREATE SEQUENCE trans_seq
MINVALUE 1
MAXVALUE 9999999999
INCREMENT BY 1
START WITH 1;

CREATE OR REPLACE TRIGGER trans_trigger
BEFORE INSERT ON transactions
FOR EACH ROW

BEGIN
    SELECT trans_seq.NEXTVAL
    INTO :new.transactionId
    FROM dual;
END;
/

CREATE OR REPLACE PROCEDURE update_balance (
    account_id  IN  ACCOUNTS.ACCOUNTID%TYPE,
    bal         IN  ACCOUNTS.BALANCE%TYPE)
IS
BEGIN
    UPDATE accounts 
    SET balance = bal 
    WHERE accountId = account_id;
END;
/

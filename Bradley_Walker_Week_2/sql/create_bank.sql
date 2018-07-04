/*
    This is the database for the banking application.
*/

DROP TABLE UserHasAccount;
DROP TABLE Transactions;
DROP TABLE Transfers;
DROP TABLE Loans;
DROP TABLE Users;
DROP TABLE Accounts;
DROP SEQUENCE user_seq;
DROP SEQUENCE account_seq;
DROP SEQUENCE transaction_seq;
DROP SEQUENCE transfer_seq;
DROP SEQUENCE loan_seq;

-- Users
CREATE TABLE Users(
    user_id     NUMBER(8),
    username    VARCHAR2(50)    NOT NULL    UNIQUE,
    pw_hash     VARCHAR2(64)    NOT NULL,
    pw_salt     VARCHAR2(16)    NOT NULL,
    email       VARCHAR2(255)   NOT NULL,
    phone       VARCHAR(20)     NOT NULL,
    frozen      NUMBER(1)       DEFAULT 0,
    
    CONSTRAINT pk_users
        PRIMARY KEY(user_id)
);


-- Accounts
CREATE TABLE Accounts(
    account_id      NUMBER(8),
    account_name    VARCHAR2(50)    NOT NULL,
    balance         NUMBER(10,2)    DEFAULT 0.00,
    
    CONSTRAINT pk_accounts
        PRIMARY KEY(account_id)
);


-- UserHasAccount
CREATE TABLE UserHasAccount(
    user_id     NUMBER(8),
    account_id      NUMBER(8),
    
    CONSTRAINT fk_uha_users
        FOREIGN KEY(user_id)
        REFERENCES Users (user_id),
    
    CONSTRAINT fk_uha_accounts
        FOREIGN KEY(account_id)
        REFERENCES Accounts (account_id),
    
    CONSTRAINT pk_uha
        PRIMARY KEY(user_id, account_id)
);


-- Transactions
CREATE TABLE Transactions(
    transaction_id      NUMBER(8),
    user_id             NUMBER(8)       NOT NULL,
    account_id          NUMBER(8)       NOT NULL,
    amount              NUMBER(10,2)    NOT NULL,
    timestamp       TIMESTAMP(2) WITH TIME ZONE     DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT pk_transactions
        PRIMARY KEY(transaction_id),
    
    CONSTRAINT fk_transactions_users
        FOREIGN KEY(user_id)
        REFERENCES Users (user_id),
    
    CONSTRAINT fk_transactions_accounts
        FOREIGN KEY(account_id)
        REFERENCES Accounts (account_id)
);


--Transfers
CREATE TABLE Transfers(
    transfer_id         NUMBER(8),
    from_user_id        NUMBER(8)       NOT NULL,
    to_user_id          NUMBER(8)       NOT NULL,
    from_account_id     NUMBER(8)       NOT NULL,
    to_account_id       NUMBER(8)       NOT NULL,
    amount              NUMBER(10,2)    NOT NULL,
    timestamp       TIMESTAMP(2) WITH TIME ZONE     DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT pk_transfers
        PRIMARY KEY(transfer_id),
    
    CONSTRAINT fk_transfers_users_from
        FOREIGN KEY(from_user_id)
        REFERENCES Users (user_id),
    
    CONSTRAINT fk_transfers_users_to
        FOREIGN KEY(to_user_id)
        REFERENCES Users (user_id),    
    
    CONSTRAINT fk_from_account
        FOREIGN KEY(from_account_id)
        REFERENCES Accounts (account_id),
    
    CONSTRAINT fk_to_account
        FOREIGN KEY(to_account_id)
        REFERENCES Accounts (account_id)    
);


-- Loans
CREATE TABLE Loans(
    loan_id         NUMBER(8),
    user_id         NUMBER(8)       NOT NULL,
    amount_loaned   NUMBER(10,2)    NOT NULL,
    amount_repaid   NUMBER(10,2)    DEFAULT 0.00,
    pay_by          TIMESTAMP(2) WITH TIME ZONE     NOT NULL,
    timestamp       TIMESTAMP(2) WITH TIME ZONE     DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT pk_loans
        PRIMARY KEY(loan_id),
    
    CONSTRAINT fk_loans_users
        FOREIGN KEY(user_id)
        REFERENCES Users (user_id)    
);

-- These are the sequences and triggers used to auto-increment the primary keys of some of the tables

CREATE SEQUENCE user_seq
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER before_insert_users
BEFORE INSERT ON Users
FOR EACH ROW
BEGIN
    :NEW.user_id := user_seq.NEXTVAL;
END;
/

CREATE SEQUENCE account_seq
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER before_insert_accounts
BEFORE INSERT ON Accounts
FOR EACH ROW
BEGIN
    :NEW.account_id := account_seq.NEXTVAL;
END;
/

CREATE SEQUENCE transaction_seq
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER before_insert_transactions
BEFORE INSERT ON Transactions
FOR EACH ROW
BEGIN
    :NEW.transaction_id := transaction_seq.NEXTVAL;
END;
/

CREATE SEQUENCE transfer_seq
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER before_insert_transfers
BEFORE INSERT ON Transfers
FOR EACH ROW
BEGIN
    :NEW.transfer_id := transfer_seq.NEXTVAL;
END;
/

CREATE SEQUENCE loan_seq
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER before_insert_loans
BEFORE INSERT ON Loans
FOR EACH ROW
BEGIN
    :NEW.loan_id := loan_seq.NEXTVAL;
END;
/

--INSERT INTO Users (username, pw_hash, pw_salt, email, phone) VALUES ('admin', '1234', '1234', 'admin@revature.com', '(123) 456-6789');
--INSERT INTO Accounts (account_name, balance) VALUES ('Savings', 100);
--INSERT INTO Transactions (transaction_id, user_id, account_id, amount) VALUES(1, 21, 1, 10);


CREATE OR REPLACE PROCEDURE get_all_users_except(
userID IN NUMBER,
my_cursor OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN my_cursor FOR
    SELECT *
    FROM Users
    WHERE user_id != userID AND username != 'admin';
END;
/

COMMIT;
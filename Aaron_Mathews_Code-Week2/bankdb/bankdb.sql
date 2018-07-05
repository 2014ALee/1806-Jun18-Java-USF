CREATE TABLE Users
(
    userid NUMBER PRIMARY KEY,
    firstname VARCHAR2(160) NOT NULL,
    lastname VARCHAR2(160) NOT NULL,
    username VARCHAR2(50) NOT NULL UNIQUE,
    email VARCHAR2(255) NOT NULL UNIQUE,
    pass VARCHAR2(255) NOT NULL
);
CREATE TABLE Accounts
(
    accountid NUMBER PRIMARY KEY,
    ownerid NUMBER NOT NULL,
    balance NUMBER(30,2) DEFAULT 0,
    jointid NUMBER,
    CONSTRAINT FK_Users FOREIGN KEY (ownerid) REFERENCES Users(userid)
    ON DELETE CASCADE
);

CREATE TABLE Transactions
(
    transactionid NUMBER PRIMARY KEY,
    accountid NUMBER NOT NULL,
    amount NUMBER NOT NULL,
    CONSTRAINT FK_Accounts FOREIGN KEY (accountid) REFERENCES Accounts(accountid)
    ON DELETE CASCADE
);

CREATE SEQUENCE user_seq
MINVALUE 1
MAXVALUE 9999999999
INCREMENT BY 1
START WITH 1;

-- Create a trigger that will use art_seq whenever a new row is inserted
CREATE OR REPLACE TRIGGER user_trigger
BEFORE INSERT ON users         -- the logic of this trigger will execute BEFORE any insert on the artist table
FOR EACH ROW                    -- it will do the logic for each row inserted

BEGIN
    SELECT user_seq.NEXTVAL      -- get the next value from our sequence
    INTO :new.userid          -- put that value into the artistid field of the row being inserted
    FROM dual;                  -- need to use dual because we are not getting the value from any table
END;
/

CREATE SEQUENCE acc_seq
MINVALUE 1
MAXVALUE 9999999999
INCREMENT BY 1
START WITH 1;

-- Create a trigger that will use art_seq whenever a new row is inserted
CREATE OR REPLACE TRIGGER acc_trigger
BEFORE INSERT ON accounts         -- the logic of this trigger will execute BEFORE any insert on the artist table
FOR EACH ROW                    -- it will do the logic for each row inserted

BEGIN
    SELECT acc_seq.NEXTVAL      -- get the next value from our sequence
    INTO :new.accountid          -- put that value into the artistid field of the row being inserted
    FROM dual;                  -- need to use dual because we are not getting the value from any table
END;
/

CREATE SEQUENCE trans_seq
MINVALUE 1
MAXVALUE 9999999999
INCREMENT BY 1
START WITH 1;

-- Create a trigger that will use art_seq whenever a new row is inserted
CREATE OR REPLACE TRIGGER trans_trigger
BEFORE INSERT ON transactions         -- the logic of this trigger will execute BEFORE any insert on the artist table
FOR EACH ROW                    -- it will do the logic for each row inserted

BEGIN
    SELECT trans_seq.NEXTVAL      -- get the next value from our sequence
    INTO :new.transactionid          -- put that value into the artistid field of the row being inserted
    FROM dual;                  -- need to use dual because we are not getting the value from any table
END;
/

CREATE OR REPLACE FUNCTION balance_average
    RETURN NUMBER
AS
    average NUMBER(30,2);
BEGIN
    SELECT AVG(balance) 
    INTO average
    FROM accounts;
RETURN average;
END;
/
commit;


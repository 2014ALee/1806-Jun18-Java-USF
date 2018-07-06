CREATE TABLE clients (
    clientid NUMBER NOT NULL,
    username VARCHAR2(20) NOT NULL,
    passwd VARCHAR2(20) NOT NULL,
    firstname VARCHAR2(20) NOT NULL,
    lastname VARCHAR2(20) NOT NULL,
    email VARCHAR2(40) NOT NULL,
CONSTRAINT PK_Clients PRIMARY KEY(clientid)
);

CREATE TABLE accounts (
    accountid NUMBER NOT NULL,
    accounttype VARCHAR2(10) NOT NULL,
    balance NUMBER NOT NULL,
    CONSTRAINT PK_Accounts PRIMARY KEY(accountid)
);

CREATE TABLE clientaccounts (
    clientid NUMBER NOT NULL,
    accountid NUMBER NOT NULL,
    CONSTRAINT PK_ClientAccounts PRIMARY KEY (clientid, accountid),
    CONSTRAINT FK_ClientAccountsClientId FOREIGN KEY (clientid) REFERENCES clients (clientid),
    CONSTRAINT FK_ClientAccountsAccountId FOREIGN KEY (accountid) REFERENCES accounts (accountid)
);

CREATE SEQUENCE client_seq
MINVALUE 1
MAXVALUE 9999999
INCREMENT BY 1
START WITH 1;

CREATE OR REPLACE TRIGGER client_trigger
BEFORE INSERT ON clients
FOR EACH ROW
BEGIN
    SELECT client_seq.NEXTVAL
    INTO :NEW.clientid
    FROM dual;
END;
/

CREATE SEQUENCE account_seq
MINVALUE 1
MAXVALUE 9999999
INCREMENT BY 1
START WITH 1;

CREATE OR REPLACE TRIGGER account_trigger
BEFORE INSERT ON accounts
FOR EACH ROW
BEGIN
    SELECT account_seq.NEXTVAL
    INTO :NEW.accountid
    FROM dual;
END;
/

CREATE OR REPLACE PROCEDURE link_client_account (userid IN NUMBER, u_accountid IN NUMBER)
IS
BEGIN
INSERT INTO clientaccounts VALUES (userid,u_accountid);
END;
/

CREATE INDEX user_account
ON clients(clientid,username,passwd);

COMMIT;
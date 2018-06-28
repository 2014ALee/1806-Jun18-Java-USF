CREATE TABLE Users(
    user_id         NUMBER(100)     NOT NULL,
    username        VARCHAR2(50)    NOT NULL,
    password_hash   VARCHAR2(64)    NOT NULL,
    password_salt   VARCHAR2(16)    NOT NULL,
    email           VARCHAR2(255)   NOT NULL,
    
    CONSTRAINT pk_users
        PRIMARY KEY (user_id)
);

CREATE TABLE Accounts(
    account_id      NUMBER(100)     NOT NULL,
    account_name    VARCHAR(50)     NOT NULL,
    balance         NUMBER(30,2)    NOT NULL,
    
    CONSTRAINT pk_accounts
        PRIMARY KEY (account_id)
);

CREATE TABLE UserHasAccounts(
    user_id         NUMBER(100)     NOT NULL,
    account_id      NUMBER(100)     NOT NULL
);
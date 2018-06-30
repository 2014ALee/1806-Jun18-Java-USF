--Create a user table, an Accounts table, and a JointAcct table
CREATE TABLE account (
    accountid           NUMBER(10) CONSTRAINT pk_account PRIMARY KEY,
    checkingbalance     NUMBER (11,2),
    savingsbalance      NUMBER(11,2)
);

CREATE TABLE jointaccount(
    jointid             NUMBER (10) CONSTRAINT pk_jointaccount PRIMARY KEY,
    jointbalance        NUMBER (11,2)
);

CREATE TABLE users(
    userid              NUMBER (10) CONSTRAINT pk_user PRIMARY KEY,
    accountid           NUMBER (10),
    jointid             NUMBER (10),
    username            VARCHAR2 (20),
    pass                VARCHAR2 (20),
    firstname           VARCHAR2 (20),
    lastname            VARCHAR2 (20),
    email               VARCHAR2 (20),
    
    CONSTRAINT fk_user_account
        FOREIGN KEY (accountid)
        REFERENCES account (accountid),
        
    CONSTRAINT fk_user_jointaccount
        FOREIGN KEY (jointid)
        REFERENCES jointaccount (jointid)
);


--add an account record for admin
INSERT INTO account VALUES (1, null, null);
--add a jointaccount record for admin
INSERT INTO jointaccount VALUES (1, null);
--add an admin user record
INSERT INTO users VALUES (1, 1, 1, 'admin', 'admin', 'admin', 'admin', 'bankadmin@gmail.com');

SELECT *
FROM account;

SELECT*
FROM jointaccount;

select*
FROM users;




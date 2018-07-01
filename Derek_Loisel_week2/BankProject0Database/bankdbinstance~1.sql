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
    
    CONSTRAINT fk_users_account
        FOREIGN KEY (accountid)
        REFERENCES account (accountid)
    
);


--add an account record for admin
INSERT INTO account VALUES (1, null, null);
--add a jointaccount record for admin
INSERT INTO jointaccount VALUES (1, null);
--add an admin user record
INSERT INTO users VALUES (1, 1, 1, 'admin', 'admin', 'admin', 'admin', 'bankadmin@gmail.com');

delete
from account
where accountid = 10;

SELECT *
FROM account;

SELECT*
FROM jointaccount;

select*
FROM users;

-- Create sequence that will be used to increment primary keys in the account table
CREATE SEQUENCE account_sequence
MINVALUE 1
MAXVALUE 9999999999
INCREMENT BY 1
START WITH 2;

-- Create a trigger that will use account_sequence whenever a new row is inserted
CREATE OR REPLACE TRIGGER account_trigger
BEFORE INSERT ON account         -- the logic of this trigger will execute BEFORE any insert on the account table
FOR EACH ROW                    -- it will do the logic for each row inserted

BEGIN
    SELECT account_sequence.NEXTVAL      -- get the next value from our sequence
    INTO :new.accountid          -- put that value into the accountid field of the row being inserted
    FROM dual;                  -- need to use dual because we are not getting the value from any table
END;
/

CREATE SEQUENCE users_sequence
MINVALUE 1
MAXVALUE 9999999999
INCREMENT BY 1
START WITH 2;

-- Create a trigger that will use account_sequence whenever a new row is inserted
CREATE OR REPLACE TRIGGER users_trigger
BEFORE INSERT ON users         -- the logic of this trigger will execute BEFORE any insert on the account table
FOR EACH ROW                    -- it will do the logic for each row inserted

BEGIN
    SELECT users_sequence.NEXTVAL      -- get the next value from our sequence
    INTO :new.userid          -- put that value into the accountid field of the row being inserted
    FROM dual;                  -- need to use dual because we are not getting the value from any table
END;
/

CREATE SEQUENCE jointaccount_sequence
MINVALUE 1
MAXVALUE 9999999999
INCREMENT BY 1
START WITH 2;

-- Create a trigger that will use account_sequence whenever a new row is inserted
CREATE OR REPLACE TRIGGER jointaccount_trigger
BEFORE INSERT ON jointaccount         -- the logic of this trigger will execute BEFORE any insert on the account table
FOR EACH ROW                    -- it will do the logic for each row inserted

BEGIN
    SELECT jointaccount_sequence.NEXTVAL      -- get the next value from our sequence
    INTO :new.jointid          -- put that value into the accountid field of the row being inserted
    FROM dual;                  -- need to use dual because we are not getting the value from any table
END;
/


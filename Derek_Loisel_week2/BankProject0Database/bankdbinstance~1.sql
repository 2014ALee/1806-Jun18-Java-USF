--Create a user table, an Accounts table, and a JointAcct table
CREATE TABLE users(
    userid              NUMBER (10) CONSTRAINT pk_user PRIMARY KEY,
    username            VARCHAR2 (20),
    pass                VARCHAR2 (20),
    firstname           VARCHAR2 (20),
    lastname            VARCHAR2 (20),
    email               VARCHAR2 (20)

);

CREATE TABLE account (
    accountid           NUMBER(10) CONSTRAINT pk_account PRIMARY KEY,
    userid              NUMBER (10),
    checkingbalance     NUMBER (11,2),
    savingsbalance      NUMBER(11,2),
    
    CONSTRAINT fk_account_users
        FOREIGN KEY (userid)
        REFERENCES users (userid)
        
);

CREATE TABLE jointaccount(
    jointid             NUMBER (10) CONSTRAINT pk_jointaccount PRIMARY KEY,
    user1id             NUMBER (10),
    user2id             NUMBER (10),
    jointbalance        NUMBER (11,2),
    
    CONSTRAINT fk_joint_user1
        FOREIGN KEY (user1id)
        REFERENCES users (userid),
        
    CONSTRAINT fk_joint_user2
        FOREIGN KEY (user2id)
        REFERENCES users (userid)
);

INSERT INTO jointaccount (user1id, user2id, jointbalance) VALUES (42, 26, 50);
DELETE
FROM jointaccount
WHERE jointid = 3;
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

CREATE OR REPLACE PROCEDURE get_account_by_userid(
user_id IN NUMBER, my_cursor OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN my_cursor FOR 
    SELECT *
    FROM account
    WHERE userid = user_id;
    
END get_account_by_userid;


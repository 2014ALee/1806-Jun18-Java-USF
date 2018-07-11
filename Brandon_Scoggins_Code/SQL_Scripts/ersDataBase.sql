-- Create a non-admin user to interact with the DB
CREATE USER notadmin
IDENTIFIED BY notadminpassword
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;
-- Grant the non-admin user some basic abilities
GRANT CONNECT TO notadmin;
GRANT RESOURCE TO notadmin;
GRANT CREATE SESSION TO notadmin;
GRANT CREATE TABLE TO notadmin;
GRANT CREATE VIEW TO notadmin;
-- Disconnect as admin

-- Connect as non-admin user

-- Create the users table (holds user information)
CREATE TABLE ersUsers(
    userId          NUMBER, 
    userName        VARCHAR2(50)        NOT NULL,
    passWord        VARCHAR2(50)        NOT NULL,
    firstName       VARCHAR2(100)       NOT NULL,
    lastName        VARCHAR2(100)       NOT NULL,
    email           VARCHAR2(150)       NOT NULL,
    userRoleId      NUMBER,
    
    CONSTRAINT pk_user_ids PRIMARY KEY (userId),
    CONSTRAINT uniq_user UNIQUE (userName, email),
    CONSTRAINT fk_user_role_id FOREIGN KEY (userRoleId) 
                                REFERENCES ersUserRoles (userRoleId)
);
-- Create table to hold user role information
CREATE TABLE ersUserRoles (
    userRoleId      NUMBER          PRIMARY KEY,
    userRole        VARCHAR2(10)    
);
-- Create table to hold reimburesement type information
CREATE TABLE ersReimbursementType (
    reimTypeId      NUMBER          PRIMARY KEY,
    reimType        VARCHAR2(10)
);
-- Create table to hold reimburesement status information
CREATE TABLE ersReimbursementStatus (
    reimStatusId    NUMBER          PRIMARY KEY,
    reimStatus      VARCHAR2(10)
);
-- Create table track reimbursement information
CREATE TABLE ersReimbursement(
    reimId          NUMBER          PRIMARY KEY,
    reimAmount      NUMBER,
    reimSubmitted   TIMESTAMP,
    reimResolved    TIMESTAMP,
    reimDescription VARCHAR2(250),
    reimAuthor      NUMBER,
    reimResolver    NUMBER,
    reimStatusId    NUMBER,
    reimTypeId      NUMBER,
    
    CONSTRAINT fk_author FOREIGN KEY (reimAuthor) 
                            REFERENCES ersUsers(userId),
    CONSTRAINT fk_resolver FOREIGN KEY (reimResolver) 
                            REFERENCES ersUsers(userId),
    CONSTRAINT fk_status FOREIGN KEY (reimStatusId) 
                            REFERENCES ersReimbursementStatus(reimStatusId),
    CONSTRAINT fk_type FOREIGN KEY (reimTypeId) 
                            REFERENCES ersReimbursementType(reimTypeId)                        
);
-- Create some sequences and triggers to increment the primary keys properly
-- User Id's
CREATE SEQUENCE user_id_seq
MINVALUE 1
MAXVALUE 9999999999
INCREMENT BY 1
START WITH 1;

CREATE OR REPLACE TRIGGER user_id_trigger
BEFORE INSERT ON users
FOR EACH ROW

BEGIN
    SELECT user_id_seq.NEXTVAL
    INTO :new.userId
    FROM dual;
END;
/
-- Transfer Id's
CREATE SEQUENCE transfer_id_seq
MINVALUE 1
MAXVALUE 9999999999
INCREMENT BY 1
START WITH 1;

CREATE OR REPLACE TRIGGER transfer_id_trigger
BEFORE INSERT ON transfers
FOR EACH ROW

BEGIN
    SELECT transfer_id_seq.NEXTVAL
    INTO :new.transferId
    FROM dual;
END;
/
-- Transaction Id's
CREATE SEQUENCE transaction_id_seq
MINVALUE 1
MAXVALUE 9999999999
INCREMENT BY 1
START WITH 1;

CREATE OR REPLACE TRIGGER transaction_id_trigger
BEFORE INSERT ON transactions
FOR EACH ROW

BEGIN
    SELECT transaction_id_seq.NEXTVAL
    INTO :new.transactionId
    FROM dual;
END;
/
-- Savings Account Id's
CREATE SEQUENCE savings_id_seq
MINVALUE 1
MAXVALUE 9999999999
INCREMENT BY 1
START WITH 1;

CREATE OR REPLACE TRIGGER savings_id_trigger
BEFORE INSERT ON savingsAccounts
FOR EACH ROW

BEGIN
    SELECT savings_id_seq.NEXTVAL
    INTO :new.accountId
    FROM dual;
END;
/
-- Checking Account Id's
CREATE SEQUENCE checking_id_seq
MINVALUE 1
MAXVALUE 9999999999
INCREMENT BY 1
START WITH 1;

CREATE OR REPLACE TRIGGER checking_id_trigger
BEFORE INSERT ON checkingAccounts
FOR EACH ROW

BEGIN
    SELECT checking_id_seq.NEXTVAL
    INTO :new.accountId
    FROM dual;
END;
/
-- Account Id's
CREATE SEQUENCE account_id_seq
MINVALUE 1
MAXVALUE 9999999999
INCREMENT BY 1
START WITH 1;

CREATE OR REPLACE TRIGGER account_id_trigger
BEFORE INSERT ON accounts
FOR EACH ROW

BEGIN
    SELECT account_id_seq.NEXTVAL
    INTO :new.accountId
    FROM dual;
END;
/
-- Trigger on transactions to get system date and time
CREATE OR REPLACE TRIGGER get_date
BEFORE INSERT ON transactions
FOR EACH ROW

BEGIN
    SELECT CURRENT_TIMESTAMP
    INTO :new.dateOf
    FROM dual;
END;
/
COMMIT;
-- Insert a test user to make sure everything is working
INSERT INTO users VALUES(3, 'testfirstname', 'testlastname', 'testusername', 'testpassword', 'testemail@email.com');
SELECT *
FROM users;
-- Callable Procedure to log in a user and return the user fields
CREATE OR REPLACE PROCEDURE log_in_user(
    user_name_or_email IN users.userName%TYPE,
    pass_word IN users.passWord%TYPE,
    my_cursor OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN my_cursor FOR
    SELECT * 
    FROM users
    WHERE (userName = user_name_or_email OR email = user_name_or_email) AND passWord = pass_word;
END;
/

CREATE TABLE ers_user_roles(

ers_user_role_id        NUMBER CONSTRAINT pk_ers_user_roles PRIMARY KEY ,
user_role               VARCHAR2(10)

);

CREATE TABLE ers_reimbursement_status(

reimb_status_id         NUMBER CONSTRAINT pk_ers_reimbursement_status PRIMARY KEY ,
reimb_status            VARCHAR2 (10)

);

CREATE TABLE ers_reimbursement_type(
reimb_type_id           NUMBER CONSTRAINT pk_ers_reimbursement_type PRIMARY KEY ,
reimb_type              VARCHAR2(10)

);

CREATE TABLE ers_users(

ers_users_id            NUMBER CONSTRAINT pk_ers_users PRIMARY KEY ,
ers_username            VARCHAR2 (50),
ers_password            VARCHAR2 (50),
user_first_name         VARCHAR2 (100),
user_last_name          VARCHAR2 (100),
user_email              VARCHAR2 (150),
user_role_id            NUMBER ,

CONSTRAINT ers_user_roles_fk
    FOREIGN KEY (user_role_id)
    REFERENCES ers_user_roles (ers_user_role_id)

);

CREATE TABLE ers_reimbursement(

reimb_id                NUMBER CONSTRAINT pk_ers_reimbursement PRIMARY KEY ,
reimb_amount            NUMBER,
reimb_submitted         TIMESTAMP,
reimb_resolved          TIMESTAMP,
reimb_description       VARCHAR2 (250),
reimb_receipt           BLOB,
reimb_author            NUMBER,
reimb_resolver          NUMBER,
reimb_status_id         NUMBER,
reimb_type_id           NUMBER,

CONSTRAINT ers_users_fk_author
    FOREIGN KEY (reimb_author)
    REFERENCES ers_users (ers_users_id),
    
CONSTRAINT ers_users_fk_resolver
    FOREIGN KEY (reimb_resolver)
    REFERENCES ers_users (ers_users_id),
    
CONSTRAINT ers_reimbursement_status_fk
    FOREIGN KEY (reimb_status_id)
    REFERENCES ers_reimbursement_status (reimb_status_id),
    
CONSTRAINT ers_reimbursement_type_fk
    FOREIGN KEY (reimb_type_id)
    REFERENCES ers_reimbursement_type (reimb_type_id)
    
);

-- Create sequence that will be used to increment primary keys in the ers_users table
CREATE SEQUENCE ers_users_sequence
MINVALUE 1
MAXVALUE 9999999999
INCREMENT BY 1
START WITH 2;

-- Create sequence that will be used to increment primary keys in the ers_reimbursement table
CREATE SEQUENCE ers_reimbursement_sequence
MINVALUE 1
MAXVALUE 9999999999
INCREMENT BY 1
START WITH 2;
/*
--This sequence not currently active
-- Create sequence that will be used to increment primary keys in the ers_reimbursement_status table
CREATE SEQUENCE reimbursement_status_sequence
MINVALUE 1
MAXVALUE 9999999999
INCREMENT BY 1
START WITH 2;
--This sequence not currently active
-- Create sequence that will be used to increment primary keys in the ers_reimbursement_type table
CREATE SEQUENCE reimbursement_type_sequence
MINVALUE 1
MAXVALUE 9999999999
INCREMENT BY 1
START WITH 2;
--This sequence not currently active
-- Create sequence that will be used to increment primary keys in the ers_user_roles table
CREATE SEQUENCE ers_user_roles_sequence
MINVALUE 1
MAXVALUE 9999999999
INCREMENT BY 1
START WITH 2;
*/
-- Create a trigger that will use ers_users_sequence whenever a new row is inserted
CREATE OR REPLACE TRIGGER ers_users_trigger
BEFORE INSERT ON ers_users      -- the logic of this trigger will execute BEFORE any insert on the table
FOR EACH ROW                    -- it will do the logic for each row inserted

BEGIN
    SELECT ers_users_sequence.NEXTVAL      -- get the next value from our sequence
    INTO :new.ers_users_id          -- put that value into the ers_users_id field of the row being inserted
    FROM dual;                  -- need to use dual because we are not getting the value from any table
END;
/

-- Create a trigger that will use ers_reimbursement_sequence whenever a new row is inserted
CREATE OR REPLACE TRIGGER ers_reimbursement_trigger
BEFORE INSERT ON ers_reimbursement  
FOR EACH ROW                    

BEGIN
    SELECT ers_reimbursement_sequence.NEXTVAL      
    INTO :new.reimb_id          
    FROM dual;                  
END;
/
/*
--This trigger not currently active
-- Create a trigger that will use reimbursement_status_sequence whenever a new row is inserted
CREATE OR REPLACE TRIGGER reimbursement_status_trigger
BEFORE INSERT ON ers_reimbursement_status  
FOR EACH ROW                  

BEGIN
    SELECT reimbursement_status_sequence.NEXTVAL    
    INTO :new.reimb_status_id   
    FROM dual;                 
END;
/

--This trigger not currently active
-- Create a trigger that will use reimbursement_type_sequence whenever a new row is inserted
CREATE OR REPLACE TRIGGER reimbursement_type_trigger
BEFORE INSERT ON ers_reimbursement_type  
FOR EACH ROW                  

BEGIN
    SELECT reimbursement_type_sequence.NEXTVAL    
    INTO :new.reimb_type_id   
    FROM dual;                 
END;
/

--This trigger not currently active
-- Create a trigger that will use ers_user_roles_sequence whenever a new row is inserted
CREATE OR REPLACE TRIGGER ers_user_roles_trigger
BEFORE INSERT ON ers_user_roles  
FOR EACH ROW                  

BEGIN
    SELECT ers_user_roles_sequence.NEXTVAL    
    INTO :new.ers_user_role_id   
    FROM dual;                 
END;
/
*/
CREATE OR REPLACE PROCEDURE get_user_by_username(
username IN VARCHAR2, my_cursor OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN my_cursor FOR 
    SELECT *
    FROM ers_users
    WHERE ers_username = username;
    
END get_user_by_username;
/

CREATE TABLE ERS_User_Roles
(
    ers_user_role_id NUMBER,
    user_role varchar(10),
    
    CONSTRAINT PK_ERS_User_Roles PRIMARY KEY (ers_user_role_id)
);

CREATE TABLE ERS_Users
(
    ers_users_id NUMBER,
    ers_username varchar(50) UNIQUE,
    ers_password varchar(50),
    user_first_name varchar(100),
    user_last_name varchar(100),
    user_email varchar(150) UNIQUE,
    user_role_id NUMBER,
    
    CONSTRAINT  PK_ERS_Users    PRIMARY KEY (ers_users_id),
    
    CONSTRAINT FK_User_RoleId FOREIGN KEY (user_role_id)
    REFERENCES ERS_User_Roles (ers_user_role_id)
    ON DELETE CASCADE
);

CREATE TABLE ERS_Reimbursement_Status
(
    REIMB_Status_ID NUMBER,
    REIMB_Status varchar(10),
    
    CONSTRAINT PK_ERS_Reimb_Stat PRIMARY KEY (REIMB_Status_ID)
);

CREATE TABLE ERS_Reimbursement_Type
(
    REIMB_Type_ID NUMBER,
    REIMB_Type varchar(10),
    
    CONSTRAINT PK_ERS_Reimb_Type PRIMARY KEY (REIMB_Type_ID)
);

CREATE TABLE ERS_Reimbursement
(
    REIMB_ID NUMBER,
    REIMB_Amount NUMBER,
    REIMB_Submitted TIMESTAMP,
    REIMB_Resolved TIMESTAMP,
    REIMB_Description varchar(250),
    REIMB_Receipt BLOB,
    REIMB_Author NUMBER,
    REIMB_Resolver NUMBER,
    REIMB_Status_ID NUMBER,
    REIMB_Type_ID NUMBER,
    
    CONSTRAINT PK_ERS_Reimb PRIMARY KEY (REIMB_ID),
    
    CONSTRAINT FK_User_Auth FOREIGN KEY (REIMB_Author)
    REFERENCES ERS_Users (ers_users_id)
    ON DELETE CASCADE,
    
    CONSTRAINT FK_User_Resolver FOREIGN KEY (REIMB_Resolver)
    REFERENCES ERS_Users (ers_users_id)
    ON DELETE CASCADE,
    
    CONSTRAINT FK_REIMB_Stat FOREIGN KEY (REIMB_Status_ID)
    REFERENCES ERS_Reimbursement_Status (REIMB_Status_ID)
    ON DELETE CASCADE,
    
    CONSTRAINT FK_REIMB_Type FOREIGN KEY (REIMB_Type_ID)
    REFERENCES ERS_Reimbursement_Type (REIMB_Type_ID)
    ON DELETE CASCADE
);

CREATE SEQUENCE users_seq
MINVALUE 1
MAXVALUE 9999999999
INCREMENT BY 1
START WITH 1;

CREATE OR REPLACE TRIGGER users_trigger
BEFORE INSERT ON ERS_Users
FOR EACH ROW

BEGIN
    SELECT users_seq.NEXTVAL
    INTO :new.ERS_Users_ID
    FROM dual;
END;
/

CREATE SEQUENCE reimb_seq
MINVALUE 1
MAXVALUE 9999999999
INCREMENT BY 1
START WITH 1;

CREATE OR REPLACE TRIGGER reimb_trigger
BEFORE INSERT ON ERS_Reimbursement
FOR EACH ROW

BEGIN
    SELECT reimb_seq.NEXTVAL
    INTO :new.REIMB_ID
    FROM dual;
END;
/

CREATE SEQUENCE stat_seq
MINVALUE 1
MAXVALUE 9999999999
INCREMENT BY 1
START WITH 1;

CREATE OR REPLACE TRIGGER stat_trigger
BEFORE INSERT ON ERS_Reimbursement_Status
FOR EACH ROW

BEGIN
    SELECT stat_seq.NEXTVAL
    INTO :new.REIMB_Status_ID
    FROM dual;
END;
/

CREATE SEQUENCE type_seq
MINVALUE 1
MAXVALUE 9999999999
INCREMENT BY 1
START WITH 1;

CREATE OR REPLACE TRIGGER type_trigger
BEFORE INSERT ON ERS_Reimbursement_Type
FOR EACH ROW

BEGIN
    SELECT type_seq.NEXTVAL
    INTO :new.REIMB_Type_ID
    FROM dual;
END;
/

CREATE SEQUENCE roles_seq
MINVALUE 1
MAXVALUE 9999999999
INCREMENT BY 1
START WITH 1;

CREATE OR REPLACE TRIGGER roles_trigger
BEFORE INSERT ON ERS_User_Roles
FOR EACH ROW

BEGIN
    SELECT roles_seq.NEXTVAL
    INTO :new.ERS_User_Role_ID
    FROM dual;
END;
/

INSERT INTO ers_reimbursement_type (reimb_type) VALUES ('LODGING');
INSERT INTO ers_reimbursement_type (reimb_type) VALUES ('TRAVEL');
INSERT INTO ers_reimbursement_type (reimb_type) VALUES ('FOOD');
INSERT INTO ers_reimbursement_type (reimb_type) VALUES ('OTHER');

INSERT INTO ers_user_roles (user_role) VALUES ('MANAGER');
INSERT INTO ers_user_roles (user_role) VALUES ('REGULAR');

INSERT INTO ers_reimbursement_status (reimb_status) VALUES ('PENDING');
INSERT INTO ers_reimbursement_status (reimb_status) VALUES ('DENIED');
INSERT INTO ers_reimbursement_status (reimb_status) VALUES ('APPROVED');

INSERT INTO ers_users (ers_users_id, ers_username, ers_password, user_first_name,user_last_name, user_email, user_role_id) VALUES (0, 'test1', 'test', '', '', 'test1@gmail.com', 1);
INSERT INTO ers_users (ers_users_id, ers_username, ers_password, user_first_name,user_last_name, user_email, user_role_id) VALUES (0, 'test2', 'test', '', '', 'test2@gmail.com', 2);

CREATE OR REPLACE PROCEDURE update_reimb (
    r_amount IN ERS_REIMBURSEMENT.REIMB_AMOUNT%TYPE,
    r_submitted IN ERS_REIMBURSEMENT.REIMB_SUBMITTED%TYPE,
    r_resolved IN ERS_REIMBURSEMENT.REIMB_RESOLVED%TYPE,
    r_desc IN ERS_REIMBURSEMENT.REIMB_DESCRIPTION%TYPE,
    r_receipt IN ERS_REIMBURSEMENT.REIMB_RECEIPT%TYPE,
    r_auth IN ERS_REIMBURSEMENT.REIMB_AUTHOR%TYPE,
    r_resolver IN ERS_REIMBURSEMENT.REIMB_RESOLVER%TYPE,
    r_stat IN ERS_REIMBURSEMENT.REIMB_STATUS_ID%TYPE,
    r_type IN ERS_REIMBURSEMENT.REIMB_TYPE_ID%TYPE,
    r_id IN ERS_REIMBURSEMENT.REIMB_ID%TYPE)
IS
BEGIN
    UPDATE ers_reimbursement 
    SET reimb_amount=r_amount, 
    reimb_submitted=r_submitted, 
    reimb_resolved=r_resolved, 
    reimb_description=r_desc, 
    reimb_receipt=r_receipt, 
    reimb_author=r_auth, 
    reimb_resolver=r_resolver, 
    reimb_status_id=r_stat, 
    reimb_type_id=r_type 
    WHERE reimb_id = r_id;
END;
/

COMMIT;

select * from ERS_USERS;
select * from ERS_USER_ROLES;
select * from ERS_REIMBURSEMENT_STATUS;
select * from ERS_REIMBURSEMENT_TYPE;
select * from ERS_REIMBURSEMENT;

DELETE FROM ERS_USERS where ers_users_id > 13;

INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES ('cdefaria','password','Christian','DeFaria','cdefaria@gmail.com',1);

insert into ers_reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) values (300.00, null, null, 'Airfair to a conference', null, 2, null, 1, 2);
insert into ers_reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) values (200.00, null, null, 'Hotel at a conference', null, 2, null, 1, 1);
insert into ers_reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) values (500.00, null, null, 'Financial Manager request', null, 13, null, 1, 4);

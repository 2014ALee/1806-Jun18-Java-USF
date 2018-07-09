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









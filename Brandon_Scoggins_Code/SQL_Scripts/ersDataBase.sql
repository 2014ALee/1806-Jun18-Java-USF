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

ALTER TABLE ersUsers
DROP CONSTRAINT fk_user_role_id; 

ALTER TABLE ersUsers
ADD CONSTRAINT fk_user_role_id FOREIGN KEY (userRoleId) 
                                REFERENCES ersUserRoles (userRoleId)
                                ON DELETE CASCADE;
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

ALTER TABLE ersReimbursement
DROP CONSTRAINT fk_author; 

ALTER TABLE ersReimbursement
DROP CONSTRAINT fk_resolver; 

ALTER TABLE ersReimbursement
DROP CONSTRAINT fk_status; 

ALTER TABLE ersReimbursement
DROP CONSTRAINT fk_type; 

ALTER TABLE ersReimbursement
ADD CONSTRAINT fk_author FOREIGN KEY (reimAuthor) 
                            REFERENCES ersUsers(userId)
                            ON DELETE CASCADE;
ALTER TABLE ersReimbursement
ADD CONSTRAINT fk_resolver FOREIGN KEY (reimResolver) 
                            REFERENCES ersUsers(userId)
                            ON DELETE CASCADE;
ALTER TABLE ersReimbursement
ADD CONSTRAINT fk_status FOREIGN KEY (reimStatusId) 
                            REFERENCES ersReimbursementStatus(reimStatusId)
                            ON DELETE CASCADE;        
ALTER TABLE ersReimbursement
ADD CONSTRAINT fk_type FOREIGN KEY (reimTypeId) 
                            REFERENCES ersReimbursementType(reimTypeId)
                            ON DELETE CASCADE;      
ALTER TABLE ersReimbursement
MODIFY reimResolved DEFAULT null; 

ALTER TABLE ersReimbursement
MODIFY reimResolver DEFAULT null; 
-- Insert static values into type, status, and role tables
INSERT INTO ersReimbursementStatus VALUES(1, 'New');
INSERT INTO ersReimbursementStatus VALUES(2, 'Viewed');
INSERT INTO ersReimbursementStatus VALUES(3, 'Approved');
INSERT INTO ersReimbursementStatus VALUES(4, 'Denied');
INSERT INTO ersReimbursementStatus VALUES(5, 'Canceled');

INSERT INTO ersReimbursementType VALUES(1, 'Lodging');
INSERT INTO ersReimbursementType VALUES(2, 'Travel');
INSERT INTO ersReimbursementType VALUES(3, 'Food');
INSERT INTO ersReimbursementType VALUES(4, 'Other');


INSERT INTO ersUserRoles VALUES(1, 'Employee');
INSERT INTO ersUserRoles VALUES(2, 'Manager');

COMMIT;

CREATE OR REPLACE TRIGGER get_resolved_date
BEFORE UPDATE ON ersReimbursement
FOR EACH ROW

BEGIN
    SELECT CURRENT_TIMESTAMP
    INTO :new.reimResolved
    FROM dual;
END;
/

-- Make some test reimbursement data
INSERT INTO ersReimbursement (reimAmount, reimDescription, reimAuthor, reimStatusId, reimTypeId) VALUES (56.00, 'For testing purposes', 24, 1, 4);
INSERT INTO ersReimbursement (reimAmount, reimDescription, reimAuthor, reimStatusId, reimTypeId) VALUES (56.00, 'For testing purposes', 24, 2, 3);
INSERT INTO ersReimbursement (reimAmount, reimDescription, reimAuthor, reimStatusId, reimTypeId) VALUES (56.00, 'For testing purposes', 24, 3, 2);
INSERT INTO ersReimbursement (reimAmount, reimDescription, reimAuthor, reimStatusId, reimTypeId) VALUES (56.00, 'For testing purposes', 24, 4, 1);
INSERT INTO ersReimbursement (reimAmount, reimDescription, reimAuthor, reimStatusId, reimTypeId) VALUES (56.00, 'For testing purposes', 25, 5, 3);
INSERT INTO ersReimbursement (reimAmount, reimDescription, reimAuthor, reimStatusId, reimTypeId) VALUES (56.00, 'For testing purposes', 25, 1, 4);
COMMIT;

-- Clean all tables
DELETE FROM ersReimbursement;
DELETE FROM ersUsers;
COMMIT;
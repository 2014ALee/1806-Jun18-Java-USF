--                                              TABLE CREATION
CREATE TABLE ers_users(
    ers_users_id                    NUMBER,
    ers_username                    VARCHAR2(50),
    ers_password                    VARCHAR2(50),
    user_first_name                 VARCHAR2(100),
    user_last_name                  VARCHAR2(100),
    user_email                      VARCHAR2(150),
    user_role_id                    NUMBER,
    
    CONSTRAINT ers_users_pk PRIMARY KEY (ers_users_ID),
    CONSTRAINT user_roles_fk 
        FOREIGN KEY (user_role_id)
        REFERENCES ers_user_roles (ers_user_role_id),
    CONSTRAINT ers_users_UNv1 UNIQUE (ers_username, user_email)
);

INSERT INTO ers_user_roles VALUES (1, 'Employee');
INSERT INTO ers_user_roles VALUES (2, 'Manager');

INSERT INTO ers_users VALUES (0, 'jbein', 'password', 'John', 'Beineke', 'jbein@gmail.com', 2);


CREATE TABLE ers_reimbursement(
    reimb_id                    NUMBER,
    reimb_amount                NUMBER,
    reimb_submitted             TIMESTAMP,
    reimb_resolved              TIMESTAMP,
    reimb_description           VARCHAR2(250),
    reimb_receipt               BLOB,
    reimb_author                NUMBER,
    reimb_resolver              NUMBER,
    reimb_status_id             NUMBER,
    reimb_type_id               NUMBER,
    
    CONSTRAINT ers_reimbursement_pk PRIMARY KEY (reimb_id),
    CONSTRAINT ers_users_fk_auth FOREIGN KEY(reimb_author)
        REFERENCES ers_users (ers_users_id),
    CONSTRAINT ers_users_fk_reslvr FOREIGN KEY (reimb_resolver)
        REFERENCES ers_users (ers_users_id),
    CONSTRAINT ers_reimbursement_status_fk FOREIGN KEY (reimb_status_id)
        REFERENCES ers_reimbursement_status (reimb_status_id),
    CONSTRAINT ers_reimbursement_type_fk FOREIGN KEY (reimb_type_id)
        REFERENCES ers_reimbursement_type (reimb_type_id)
    
);

CREATE TABLE ers_user_roles(
    ers_user_role_id        NUMBER          CONSTRAINT ers_user_roles_pk PRIMARY KEY,
    user_role               VARCHAR2(10)    
);

CREATE TABLE ers_reimbursement_type(
    reimb_type_id           NUMBER          CONSTRAINT reimb_type_pk PRIMARY KEY,
    reimb_type              VARCHAR2(10)    
);

CREATE TABLE ers_reimbursement_status(
    reimb_status_id         NUMBER          CONSTRAINT reimb_status_pk PRIMARY KEY,
    reimb_status            VARCHAR2(10)    
);

--                              SEQUENCES AND TRIGGERS
CREATE SEQUENCE users_seq
MINVALUE 1
MAXVALUE 999999999
INCREMENT BY 1
START WITH 1;

CREATE OR REPLACE TRIGGER users_trig
BEFORE INSERT ON ers_users
FOR EACH ROW
BEGIN
    SELECT users_seq.NEXTVAL
    INTO :new.ers_users_id
    FROM dual; 
END;
/

CREATE SEQUENCE reimbursement_seq
MINVALUE 1
MAXVALUE 999999999
INCREMENT BY 1
START WITH 1;

CREATE OR REPLACE TRIGGER reimbursement_trig
BEFORE INSERT ON ers_reimbursement
FOR EACH ROW
BEGIN
    SELECT reimbursement_seq.NEXTVAL
    INTO :new.reimb_id
    FROM dual; 
END;
/

INSERT INTO ers_reimbursement_type VALUES (1, 'Lodging');
INSERT INTO ers_reimbursement_type VALUES (2, 'Travel');
INSERT INTO ers_reimbursement_type VALUES (3, 'Food');
INSERT INTO ers_reimbursement_type VALUES (4, 'Other');

COMMIT;

INSERT INTO ers_reimbursement_status VALUES (1, 'Pending');
INSERT INTO ers_reimbursement_status VALUES (2, 'Approved');
INSERT INTO ers_reimbursement_status VALUES (3, 'Denied');
COMMIT;
INSERT INTO ers_reimbursement
    
    
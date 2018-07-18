CREATE TABLE reimbursement_status (
reimb_status_id NUMBER NOT NULL,
reimb_status VARCHAR2(10) NOT NULL,
CONSTRAINT reimb_status_pk PRIMARY KEY (reimb_status_id)
);

CREATE TABLE reimbursement_type (
reimb_type_id NUMBER NOT NULL,
reimb_type VARCHAR2(10) NOT NULL,
CONSTRAINT reimb_type_pk PRIMARY KEY (reimb_type_id)
);

CREATE TABLE user_roles (
user_role_id NUMBER NOT NULL,
user_role VARCHAR2(10) NOT NULL,
CONSTRAINT user_roles_pk PRIMARY KEY (user_role_id)
);

CREATE TABLE users (
users_id NUMBER NOT NULL,
username VARCHAR2(50) NOT NULL,
passwd VARCHAR2(50) NOT NULL,
first_name VARCHAR2(100) NOT NULL,
last_name VARCHAR2(100) NOT NULL,
email VARCHAR2(150) NOT NULL,
user_role_id NUMBER NOT NULL,
CONSTRAINT users_pk PRIMARY KEY (users_id),
CONSTRAINT user_roles_fk FOREIGN KEY (user_role_id) REFERENCES user_roles (user_role_id),
CONSTRAINT users_un UNIQUE (username,email)
);

CREATE TABLE reimbursement (
reimb_id NUMBER NOT NULL,
reimb_amount NUMBER NOT NULL,
reimb_submitted TIMESTAMP NOT NULL,
reimb_resolved TIMESTAMP,
reimb_description VARCHAR2(250),
reimb_receipt BLOB,
reimb_author NUMBER NOT NULL,
reimb_resolver NUMBER,
reimb_status_id NUMBER NOT NULL,
reimb_type_id NUMBER NOT NULL,
CONSTRAINT reimbursement_pk PRIMARY KEY (reimb_id),
CONSTRAINT users_fk_auth FOREIGN KEY (reimb_author) REFERENCES users(users_id),
CONSTRAINT users_fk_reslvr FOREIGN KEY (reimb_resolver) REFERENCES users(users_id),
CONSTRAINT reimbursement_status_fk FOREIGN KEY (reimb_status_id) REFERENCES reimbursement_status(reimb_status_id),
CONSTRAINT reimbursement_type_fk FOREIGN KEY (reimb_type_id) REFERENCES reimbursement_type(reimb_type_id)
);

INSERT INTO user_roles VALUES (1,'Employee');
INSERT INTO user_roles VALUES (2,'FinancMngr');

INSERT INTO reimbursement_type VALUES (1,'Lodging');
INSERT INTO reimbursement_type VALUES (2,'Travel');
INSERT INTO reimbursement_type VALUES (3,'Food');
INSERT INTO reimbursement_type VALUES (4,'Other');

INSERT INTO reimbursement_status VALUES (1,'Pending');
INSERT INTO reimbursement_status VALUES (2,'Approved');
INSERT INTO reimbursement_status VALUES (3,'Denied');

CREATE SEQUENCE reimb_seq
MINVALUE 1
MAXVALUE 9999999
INCREMENT BY 1
START WITH 1;

CREATE OR REPLACE TRIGGER reimb_trigger
BEFORE INSERT ON reimbursement
FOR EACH ROW
BEGIN
    SELECT reimb_seq.NEXTVAL
    INTO :NEW.reimb_id
    FROM dual;
END;
/

CREATE SEQUENCE user_seq
MINVALUE 1
MAXVALUE 9999999
INCREMENT BY 1
START WITH 1;

CREATE OR REPLACE TRIGGER user_trigger
BEFORE INSERT ON users
FOR EACH ROW
BEGIN
    SELECT user_seq.NEXTVAL
    INTO :NEW.users_id
    FROM dual;
END;
/

CREATE OR REPLACE PROCEDURE update_reimbursement (
c_id IN NUMBER,
c_status IN NUMBER,
c_resolver IN NUMBER,
c_resolved IN DATE,
c_result OUT SYS_REFCURSOR
)
IS
BEGIN
UPDATE reimbursement
SET  reimb_status_id = c_status, reimb_resolver = c_resolver, reimb_resolved = c_resolved
WHERE c_id = reimb_id;

OPEN c_result FOR
SELECT *
FROM reimbursement
WHERE reimb_id = c_id;

END;
/

COMMIT;
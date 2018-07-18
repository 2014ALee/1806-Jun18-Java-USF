INSERT INTO users VALUES (1,'matneyka','jon','Karen','Matney','matneyka@gmail.com',1);
INSERT INTO users VALUES (2,'atibs','atibs','Merced','Matney','merced@gmail.com',2);

INSERT INTO reimbursement (reimb_amount,reimb_submitted,reimb_author,reimb_status_id,reimb_type_id) VALUES (40.24,LOCALTIMESTAMP,1,1,3);
INSERT INTO reimbursement (reimb_amount,reimb_submitted,reimb_author,reimb_status_id,reimb_type_id) VALUES (150.24,LOCALTIMESTAMP,1,1,1);

DECLARE 
    my_cursor SYS_REFCURSOR;
BEGIN
    update_reimbursement(1,2,2,LOCALTIMESTAMP,my_cursor);
    CLOSE my_cursor; 
END;
/

COMMIT;
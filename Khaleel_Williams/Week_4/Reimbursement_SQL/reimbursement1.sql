insert into REIMBURSEMENT_TYPE values(1, 'Lodging');
insert into REIMBURSEMENT_TYPE values(2, 'Travel');
insert into REIMBURSEMENT_TYPE values(3, 'Food');
insert into REIMBURSEMENT_TYPE values(4, 'Other');

insert into REIMBURSEMENT_STATUS values(1, 'Pending');
insert into REIMBURSEMENT_STATUS values(2, 'Approved');
insert into REIMBURSEMENT_STATUS values(3, 'Denied');

insert into user_roles values(1, 'Manager');
insert into user_roles values(2, 'Employee' );

insert into users values(1, 'johndoe', 'password', 'john', 'doe', 'john@gmail.com', 1);
insert into users values(2, 'janedoe', 'password', 'jane', 'doe', 'jane@gmail.com', 2);

insert into reimbursement values(1, 20.93, CURRENT_TIMESTAMP, null , 'parts missing', null, 2, 1, 1, 4);

commit;

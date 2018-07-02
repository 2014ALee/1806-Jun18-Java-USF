select *
from accounts;

select *
from customers;

delete from CUSTOMERS where username = 'test';
delete from accounts where accountid > 2;

--insert into USERACCOUNTS (customerid, accountid) values (1,1);
--insert into USERACCOUNTS (customerid, accountid) values (1,2);

commit;

select *
from useraccounts;
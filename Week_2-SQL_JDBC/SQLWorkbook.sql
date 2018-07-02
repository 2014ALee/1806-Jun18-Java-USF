/*  Task – Select all records from the Employee table.  */

select *
FROM employee

/*  Task – Select all records from the Employee table where last name is King.  */

select *
from employee
where lastname = 'King';

/*  Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL. */

select *
from employee
where (

firstname = 'Andrew'

)
and (

reportsto is null
);

/*  Task – Select all albums in album table and sort result set in descending order */

select title
from album
order by albumid desc;

/*  **Task – Select first name from Customer and sort result set in ascending order   */

select firstname
from customer
order by firstname asc;

/*  **Task – Insert two new records into Genre table incomplete */

insert into genre (genreid, name)
values( 26,'soul');

insert into genre (genreid, name)
values (27, 'coffee house')

/*  Update Aaron Mitchell in Customer table to Robert Walter  incomplete  */

update Customer
set firstname='Robert', lastname= 'Walter'
where firstname= 'Aaron' and lastname= 'Mitchell';

/*   Update name of the artist "Creedence Clearwater Revival" to "CCR" */
--do I always have to go back and look at the table to know the column name. Faster way?
update artist
set name= 'CCR'
where name= 'Creedence Clearwater Revival';

--went into artist folder and sorted names in asc to check for ccr

/*  Select all invoices with a billing address "T" */

select *
from invoice
where billingaddress like 'T%';

/*  Select all invoices that have a total between 15 and 50   */

select * from invoice 
where total between '15.00' and '50.00';

--is there another way of doing this that includes <, > operators???

/*  Select all employees hired between 1 June 2003 and 1" of March 2004 */

select *
from employee
where hiredate between '1-JUN-2003' and '1-MAR-2004';

--be sure to watch for plurals and capitalization. 

/*   Delete a record in Customer table where the name is Robert Walter (There
may be constraints that rely on this, find out how to resolve them)    */

delete 
from customer
where firstname= 'Robert' and lastname= 'Walter';

-- use the on delete cascade. do I have to reference a 

-- -- --  -- -- -- -- -- --  -- -- -- --  -- -- --  -- -- -- -- -- -- -- -- -- -- --- -- --

/* 

3.0 SQL Functions
In this section you will be using the Oracle system functions, as well as your own functions, 
to perform various actions against the database

 */


--  3.1 System Defined Functions
--  Task – Create a function that returns the current time

select localtimestamp from 
employee;

--  Task – create a function that returns the length of a mediatype from the mediatype table **INCOMPLTE: INVOKE FUNCTION

create or replace function get_track_length 
return number

as track_length number;

begin
select Milliseconds
into track_length
from track 
where trackid= 359;
return (track_length);
DBMS_OUTPUT.PUT_LINE(track_length);
end get_track_length;
/
  set serveroutput on
  execute get_track_length;
  
--  Task – Create a function that returns the average total of all invoices
create or replace function avg_total_invoices
is 
begin 
end;
/

--  Task – Create a function that returns the most expensive track

  create or replace function get_expensive_track
  
  return number
  as
  
  most_expensive_track number;
  begin
  select max(unit price)
  into most_expensive_track
  from track;
  
  return (most_expensive_track)
dbms_output.put_line ('The most expensive track: ' || most_expensive_track);

end get_expensive_track;
/

/* 4.0 Stored Procedures
 In this section you will be creating and executing stored procedures. You will be creating various types of stored 
 procedures that take input and output parameters. */
      
-- Task – Create a stored procedure that selects the first and last names of all the employees.         
create or replace procedure get_emp_name 
is
begin 
select firstname, lastname
into emp_name
from employee
order by lastname;

end get_emp_name;
/
-- Task – Create a stored procedure that updates the personal information of an employee.

create or replace procedure new_emp_info(emp_birthdate in varchar2, emp_address in varchar2)
as
emp_birthdate   varchar(10)
emp_address     varchar(50)

begin

update emp_birthdate, emp_address
from employee

end;
/


-- Task – Create a stored procedure that returns the managers of an employee.

-- Task – Create a stored procedure that returns the name and company of a customer.


/*  5.0 Transactions
In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also 
be working with handling errors in your SQL. */

-- Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, 
--find out how to resolve them).


-- Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table




--  6.0 Triggers
--  In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--  6.1 AFTER/FOR

--  Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
Create or replace trigger new_emp 
AFTER INSERT OR UPDATE
on employee
for each row
begin 

dbms_output.put_line('New Employee Recored Inserted On Employee Table.');

End new_emp;
/

--  Task – Create an after update trigger on the album table that fires after a row is inserted in the table.

Create or replace trigger new_album
AFTER UPDATE OR INSERT on album
for each row
begin

dbms_output.put_line('New Album Update On Album Table');

end new_album;
/

--  Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.

Create or replace trigger delete_cust
AFTER DELETE on customer
FOR EACH ROW
Begin

dbms_output.put_line('New Delete On Customer Table.');

end;
/

--  6.2 BEFORE
--  Task – Create a before trigger that restricts the deletion of any invoice that is priced over 50 dollars.

create or replace trigger restrict_delete
Before Delete on invoice
for each row
when (TOTAL > 50.00);

begin

dbms_output.put_line('Cannot Delete For Invoice Total Above $50.');

end;
/

--  7.0 JOINS
--  In this section you will be working with combining various tables through the use of joins. 
-- You will work with outer, inner, right, left, cross, and self joins.

--  7.1 INNER
--  Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.

select firstname, lastname, invoiceid
from customer c
join invoice i
on c.customerid = i.invoiceid;


--  7.2 OUTER
--  Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, 
--  firstname, lastname, invoiceId, and total.

select firstname, lastname, invoiceid, total, customerid
from customer 
left outer join invoice 
using (customerid);

--  7.3 RIGHT
--  Task – Create a right join that joins album and artist specifying artist name and title.

select album.title, artist.name
from album
right join artist
using (artistid);

--  7.4 CROSS
--  Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.

select artist.name
from artist 
cross join album
order by artist.name asc;


--  7.5 SELF
--  Task – Perform a self-join on the employee table, joining on the reports to column.

select *
from employee e
self join employee emp
on e.reportsto = emp.id;


--  8.0 Indexes
--  In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.

--  8.1 Indexes
--  Task – Create an index on of table of your choice

create unique index find_album
on album (title);

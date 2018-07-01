--2.1 SELECT
--In this section you will be performing various queries against the Oracle Chinook database.
SELECT *FROM employee;
--Select all records from the Employee table where last name is King.
SELECT *FROM employee 
WHERE lastname = 'King';
--Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT *FROM employee
WHERE firstname = 'Andrew' AND reportsto is NULL;

--2.2 ORDER BY
--Select all albums in album table and sort result set in descending order
SELECT *FROM album
ORDER BY albumId DESC;
--Select first name from Customer and sort result set in ascending order
SELECT *FROM customer
ORDER BY customerid ASC;

--2.3 INSERT INTO
--Insert two new records into Genre table
INSERT INTO genre (genreId, name) VALUES(27, 'Kaba');
--Insert two new records into Employee table
INSERT INTO employee (employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, address, city, state, country, postalcode, phone, fax, email) 
VALUES(10, 'Quevedo', 'Norma', 'Software Engineer', '', '30-Nov-76', '18-Jun-2018', '16251 Lithium Ave N','Ramsey', 'MN', 'USA', '55303', '612-352-0000', '612-351-0000', 'email@email.com' );
--Task – Insert two new records into Customer table
INSERT INTO customer (customerId, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid) 
VALUES(61, 'Lamine', 'Kaba', 'Revature', '16251 Lithium Ave N','Ramsey', 'MN', 'USA', '55303', '612-352-0000', '612-351-0000', 'email@email.com', 4 );

--2.4 UPDATE
--Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer SET firstname ='Aaron', lastname = 'Mitchell'
WHERE customerid = 32;
--Update name of artist “Creedence Clearwater Revival” to “CCR”
UPDATE artist SET name ='CCR'
WHERE artistid = 76;

--2.5 LIKE
--Select all invoices with a billing address like “T”
SELECT *FROM invoice WHERE billingaddress LIKE '%T%';

--2.6 BETWEEN
--Select all invoices that have a total between 15 and 50
SELECT *FROM invoice 
WHERE total BETWEEN 15 AND 50;
--Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT *FROM employee
WHERE hiredate BETWEEN date '2003-06-01' AND date '2004-03-01';
/*
SELECT *FROM employee
WHERE hiredate > date '2003-06-01' AND  hiredate < date '2004-03-01';
*/

--2.7 DELETE
--Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
--Drop the constraint on foreign key, then add foreign with on delete set Null
ALTER TABLE customer
    DROP CONSTRAINT FK_CUSTOMERSUPPORTREPID;
ALTER TABLE Customer 
    ADD CONSTRAINT FK_CUSTOMERSUPPORTREPID FOREIGN KEY (SUPPORTREPID)
    REFERENCES CHINOOK.EMPLOYEE ("EMPLOYEEID") On Delete SET NULL;
--Now let delete Robert walter
DELETE FROM customer
WHERE firstname = 'Robert' AND lastname='Walter';

--3.0 SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
SELECT UPPER('hello world') FROM dual;
SELECT lastname FROM employee WHERE employeeid = 1 initcap(lastname);
SELECT concat(concat(firstname, '   '), lastname) FROM employee;
SELECT UPPER(lastname) AS "Last Name" FROM employee;
SELECT SUBSTR(address,0,10) FROM employee;
SELECT INITCAP('the soap') FROM dual;
SELECT COUNT(*) AS "Row COUNT" FROM employee;
CREATE OR replace FUNCTION addTowNum(num1, num2,)
RETURN NUMBER 
AS 
num3 NUMBER, 

BEGIN 
    num3 = num1 +num2;
   SELECT upper('the num1 + num2 is: ') FROM dual;
   RETURN num3;
end;
/
--3.1 System Defined Functions
--Create a function that returns the current time.

CREATE  OR REPLACE FUNCTION  showDate
RETURN TIMESTAMP;
IS 
  myDate TIMESTAMP;
begin
  SELECT SYSDATE INTO myDate FROM dual;
  return myDate;
end;
/

--3.2 System Defined Aggregate Functions
--Create a function that returns the average total of all invoices
create or replace FUNCTION total_invoices
RETURN NUMBER 
AS
sum_of_invoices NUMBER;
BEGIN
    SELECT SUM(total) INTO sum_of_invoices FROM invoice;
    RETURN sum_of_invoices;
END;

--Create a function that returns the most expensive track
create or replace FUNCTION max_invoices
RETURN NUMBER 
AS
most_expensive NUMBER;
BEGIN
    SELECT MAX(total) INTO most_expensive FROM invoice;
    RETURN most_expensive;
END;

--3.3 User Defined Scalar Functions
--Create a function that returns the average price of invoiceline items in the invoiceline table
create or replace FUNCTION avg_invoices
RETURN NUMBER 
AS
inv_average NUMBER;
BEGIN
    SELECT AVG(unitprice) INTO inv_average FROM invoiceline;
    RETURN inv_average;
END;
--3.4 User Defined Table Valued Functions
--Create a function that returns all employees who are born after 1968.
--From week2_demo
CREATE OR REPLACE FUNCTION after_1968
    RETURN SYS_REFCURSOR
IS
    my_cursor SYS_REFCURSOR;
BEGIN
    OPEN my_cursor FOR  -- The result set returned by the query below is stored in our declared cursor
    SELECT firstname, lastname, birthdate
    FROM employee
    WHERE birthdate > DATE '1968-12-31';
    
    RETURN my_cursor;    -- This function returns a SYS_REFCURSOR, so return our declared cursor
END;
/

CREATE OR REPLACE FUNCTION lamine
RETURN SYS_REFCURSOR
AS
my_new_TABLE SYS_REFCURSOR;

BEGIN
    OPEN my_new_TABLE FOR 
    SELECT employeeid, firstname, lastname FROM employee;
    RETURN my_new_TABLE;
END;
/

CREATE OR REPLACE PROCEDURE greetings 
AS 
BEGIN 
   dbms_output.put_line('Hello World!'); 
END; 
/
create or replace Procedure select_fristname_lastname(new_table OUT sys_refcursor)
AS
BEGIN
    OPEN new_table for
    select firstname, lastname from employee;
END select_fristname_lastname;

--4.1 Basic Stored Procedure
--Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE first_and_lastname(
new_table OUT SYS_REFCURSOR)
AS 
BEGIN
    OPEN new_table FOR 
    SELECT firstname, lastname
    FROM employee;
END first_and_lastname;
/ 

DECLARE 
    firstname employee.firstname%TYPE;
    lastname employee.lastname%TYPE;
    my_cursor SYS_REFCURSOR;

BEGIN
    first_and_lastname(my_cursor);

    LOOP 
        FETCH my_cursor
        INTO firstname, lastname;
    
        EXIT WHEN my_cursor%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('firstname: ' || firstname || ', lastname: ' || lastname);
    END LOOP ;
    CLOSE my_cursor;
END;

--4.2 Stored Procedure Input Parameters
--Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE update_personal_info(emp_id IN NUMBER,  emp_lastname IN VARCHAR2, emp_firstname IN VARCHAR2 )
AS
BEGIN
    UPDATE employee
    SET firstname = emp_firstname, lastname = emp_lastname
    WHERE employeeid = emp_id;
    
END update_personal_info;
/
DECLARE
emp_id NUMBER(10);
emp_lastname VARCHAR2(40) ;
emp_firstname VARCHAR2(40) ;
BEGIN
emp_id := 1;
emp_lastname := 'Lamine';
emp_firstname := 'kaba';
update_personal_info(emp_id, emp_lastname, emp_firstname);
END ;
/
--Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE get_manager_name(emp_id IN NUMBER, my_cursor OUT SYS_REFCURSOR) 
AS  
BEGIN
    OPEN my_cursor FOR 
    SELECT reportsto  
    FROM employee
    WHERE employeeid = emp_id;
     
END get_manager_name ;
/
DECLARE 
    emp_id NUMBER ;
    manager NUMBER  ; 
    my_cursor SYS_REFCURSOR;
BEGIN
    emp_id := 1;
    get_manager_name(emp_id, my_cursor);

    LOOP 
        FETCH my_cursor
        INTO manager;
    
        EXIT WHEN my_cursor%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(' manager_id: ' || manager);
    END LOOP ;
    CLOSE my_cursor;
END;
/
--4.3 Stored Procedure Output Parameters
--Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE customer_name_company(cust_id IN NUMBER, my_cursor OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN my_cursor FOR 
    SELECT firstname, lastname, company FROM customer
    WHERE customerid = cust_id;
    
END customer_name_company;
/

DECLARE
    emp_id NUMBER;
    firstname VARCHAR2(50);
    lastname VARCHAR2(50) ;
    companyname VARCHAR2(50) ;
    my_cursor SYS_REFCURSOR;
    
BEGIN
    emp_id := 1;
    customer_name_company(emp_id, my_cursor);
    LOOP 
    FETCH my_cursor
    INTO firstname, lastname, companyname;
     EXIT WHEN my_cursor%NOTFOUND;
     
     DBMS_OUTPUT.PUT_LINE('firstname: ' || firstname || ', lastname: ' || lastname || ', company: ' || companyname);
     END LOOP ;
     CLOSE my_cursor;
END ;
/

--5.0 Transactions
--Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
with Derek
CREATE OR REPLACE PROCEDURE delete_invoice(invoice_id IN NUMBER)
AS 
BEGIN
    DELETE FROM invoiceline
    WHERE invoiceid = invoice_id;
    IF (SQL%NOTFOUND)
     THEN
         dbms_output.put_line('This record does not exist in invoiceline');
     END IF;
    
    DELETE FROM invoice
    WHERE invoiceid = invoice_id;
    IF (SQL%NOTFOUND)
     THEN
         dbms_output.put_line('This record does not exist in invoice ');
     END IF;
     
END delete_invoice ;
/

DECLARE 
    emp_id NUMBER ;
BEGIN 
    emp_id := 215;
    delete_invoice(emp_id);
END;
/

--Create a transaction nested within a stored procedure that inserts a new record in the Customer table
ALTER TABLE Customer DROP CONSTRAINT FK_CUSTOMERSUPPORTREPID;
ALTER TABLE Customer DROP CONSTRAINT PK_CUSTOMER;
CREATE OR REPLACE PROCEDURE add_new_customer(customer_id IN NUMBER)
AS 
BEGIN

INSERT INTO customer (customerid, firstname, lastname, email) VALUES(customer_id, 'Lamine', 'Kaba', 'lamine@kaba.com');
  
END add_new_customer;
/

DECLARE
customer_id NUMBER;
BEGIN 
customer_id := 62;
add_new_customer(customer_id);
END ;

--6.1 AFTER/FOR
--Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER insert_employee_trigger
AFTER INSERT ON employee FOR EACH ROW              
BEGIN
dbms_output.put_line( 'A new employee was inserted');
END ;
/

--Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER update_album_TRIGGER
AFTER UPDATE ON album FOR EACH ROW

BEGIN
dbms_output.put_line( 'A row was inserted ON album table');
END;

--Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER delete_customer_TRIGGER
AFTER DELETE ON customer FOR EACH ROW
BEGIN
dbms_output.put_line( 'A row was deleted IN customer table');
END ;
/

--6.2 BEFORE
--Create a before trigger that restricts the deletion of any invoice that is priced over 50 dollars.
CREATE OR REPLACE TRIGGER restricted_deletion_TRIGGER
BEFORE DELETE ON invoice FOR EACH ROW
DECLARE
price NUMBER; 
BEGIN
    price := :old.total;
IF (price > 50 )
    THEN
    raise_application_error(20001, 'This cannot be deleted');
    END if;
END;
/

--7.1 INNER
--Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT
    c.lastname,
    c.firstname,
    i.invoiceid
FROM
customer c
INNER JOIN invoice i ON c.customerid = i.customerid

--7.2 OUTER
--Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT
    c.lastname,
    c.firstname,
    i.invoiceid,
    c.customerid,
    i.total
FROM customer c
JOIN invoice i ON c.customerid = i.customerid;

--7.3 RIGHT
--Create a right join that joins album and artist specifying artist name and title.
SELECT al.title, ar.name
FROM album al
RIGHT OUTER JOIN artist ar
ON al.artistid = ar.artistid;

--7.4 CROSS
--Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT *
FROM album
CROSS JOIN artist
ORDER BY name ASC;

--7.5 SELF
--Perform a self-join on the employee table, joining on the reports to column.
SELECT *
FROM employee a, employee b
WHERE a.reportsto = b.reportsto;

--8.0 Indexes
--In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
CREATE INDEX emp_index ON employee (employeeid, firstname, lastname);
--8.1 Indexes
--Create an index on of table of your choice
CREATE INDEX customer_index ON customer (customerid, firstname, lastname);









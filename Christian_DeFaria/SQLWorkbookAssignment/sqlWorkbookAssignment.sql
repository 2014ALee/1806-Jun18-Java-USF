--2.0 SQL Queries
--In this section you will be performing various queries against the Oracle Chinook database.

--2.1 SELECT
--Task – Select all records from the Employee table. 
SELECT *
FROM employee;
--Task – Select all records from the Employee table where last name is King.
SELECT *
FROM employee
WHERE lastname = 'King';
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT *
FROM employee
WHERE firstname = 'Andrew'
AND reportsto IS NULL;

--2.2 ORDER BY
--Task – Select all albums in album table and sort result set in descending order
SELECT *
FROM album
ORDER BY title DESC;
--Task – Select first name from Customer and sort result set in ascending order
SELECT firstname
FROM customer
ORDER BY firstname;

--2.3 INSERT INTO
--Task – Insert two new records into Genre table
INSERT INTO Genre (GenreId, Name) VALUES (26, 'Independent');
INSERT INTO Genre (GenreId, Name) VALUES (27, 'Punk Rock');
--Task – Insert two new records into Employee table
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, 
    PostalCode, Phone, Fax, Email) VALUES (9, 'DeFaria', 'Christian', 'Trainee', 6, TO_DATE('1994-6-17 00:00:00',
    'yyyy-mm-dd hh24:mi:ss'), TO_DATE('2018-05-27 00:00:00','yyyy-mm-dd hh24:mi:ss'), '12977 N 50th St APT 104B', 
    'Temple Terrace', 'FL', 'USA', '33617', '+1 (530) 592-9591', '+1 (530) 592-9591', 'cdefaria@chinookcorp.com');
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, 
    PostalCode, Phone, Fax, Email) VALUES (10, 'Wood', 'Mike', 'IT Staff', 6, TO_DATE('1968-1-9 00:00:00',
    'yyyy-mm-dd hh24:mi:ss'), TO_DATE('2004-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss'), '400 W 2nd St', 'Chico', 'CA', 
    'USA', '95929', '+1 (530) 898-4577', '+1 (530) 898-4577', 'mwood@chinookcorp.com');
--Task – Insert two new records into Customer table
INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) 
    VALUES (60, 'DeFaria', 'Christian', '12977 N 50th St', 'Temple Terrace', 'USA', '33617', '+1 (530) 592-9591', 
    'cdefaria17@gmail.com', 3);
INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) 
    VALUES (61, 'Wood', 'Mike', '400 W 2nd St', 'Chico', 'USA', '95929', '+1 (530) 898-4577', 
    'mwood@gmail.com', 3);
--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer
SET firstname = 'Robert',
lastname = 'Walter'
where customerid = (
    SELECT customerid
    FROM customer
    WHERE FIRSTNAME = 'Aaron'
    AND LASTNAME = 'Mitchell'
);
--Task – Update name of artist “Creedence Clearwater Revival” to “CCR”
UPDATE artist
SET name = 'CCR'
where artistid = (
    SELECT artistid
    FROM artist
    WHERE name = 'Creedence Clearwater Revival'
);

--2.5 LIKE
--Task – Select all invoices with a billing address like “T”
SELECT *
FROM invoice
WHERE billingaddress like 'T';
--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT *
FROM invoice
WHERE total BETWEEN 15 AND 20;
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT *
FROM employee
WHERE hiredate BETWEEN DATE '2003-06-01' AND DATE '2004-03-01';

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, 
--find out how to resolve them).
DELETE FROM invoiceline
WHERE invoiceid in (
    SELECT invoiceid
    FROM invoice
    WHERE customerid = (
        SELECT customerid
        FROM customer
        WHERE firstname = 'Robert'
        AND lastname = 'Walter'
    )
);
DELETE FROM invoice
WHERE customerid = (
    SELECT customerid
    FROM customer
    WHERE firstname = 'Robert'
    AND lastname = 'Walter'
);
DELETE FROM customer
WHERE firstname = 'Robert'
AND lastname = 'Walter';


--3.0 SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions 
--against the database
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
SELECT systimestamp from dual;
--Task – create a function that returns the length of a mediatype from the mediatype table
SELECT LENGTH(name)
FROM MEDIATYPE;

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
SELECT AVG(total)
FROM invoice;
--Task – Create a function that returns the most expensive track
SELECT MAX(unitprice)
FROM track;
--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION get_avg_price_invoiceline
    RETURN NUMBER
AS
    avg_price NUMBER;
BEGIN
    SELECT AVG(unitprice)
    INTO avg_price
    FROM invoiceline;
    
    RETURN avg_price;
END;
/
--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
--From pl-sql_demo.sql
CREATE OR REPLACE FUNCTION after_1968
    RETURN SYS_REFCURSOR
IS
    my_cursor   SYS_REFCURSOR;
BEGIN
    OPEN my_cursor FOR
    SELECT firstname, lastname, birthdate
    FROM employee
    WHERE birthdate > DATE '1968-12-31';
    
    RETURN my_cursor;
END;
/

--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE get_all_employees(
    my_cursor   OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN my_cursor FOR
    SELECT firstname, lastname
    FROM employee;
END;
/
--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE update_employee_by_id(
    emp_id      IN  EMPLOYEE.EMPLOYEEID%TYPE,
    ln          IN  EMPLOYEE.LASTNAME%TYPE,
    fn          IN  EMPLOYEE.FIRSTNAME%TYPE,
    emp_title   IN  EMPLOYEE.TITLE%TYPE,
    reports_to  IN  EMPLOYEE.REPORTSTO%TYPE,
    bday        IN  EMPLOYEE.BIRTHDATE%TYPE,
    hdate       IN  EMPLOYEE.HIREDATE%TYPE,
    addr        IN  EMPLOYEE.ADDRESS%TYPE,
    cty         IN  EMPLOYEE.CITY%TYPE,
    st          IN  EMPLOYEE.STATE%TYPE,
    cnty        IN  EMPLOYEE.COUNTRY%TYPE,
    pcode       IN  EMPLOYEE.POSTALCODE%TYPE,
    p_num       IN  EMPLOYEE.PHONE%TYPE,
    f_num       IN  EMPLOYEE.FAX%TYPE,
    e_mail      IN  EMPLOYEE.EMAIL%TYPE)
IS
BEGIN
    UPDATE employee
    SET lastname = ln,
        firstname = fn,
        title = emp_title,
        reportsto = reports_to,
        birthdate = bday,
        hiredate = hdate,
        address = addr,
        city = cty,
        state = st,
        country = cnty,
        postalcode = pcode,
        phone = p_num,
        fax = f_num,
        email = e_mail
    WHERE employeeid = emp_id;
END;
/
--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE update_employee_by_id(
    emp_id      IN  EMPLOYEE.EMPLOYEEID%TYPE,
    mang_id     OUT EMPLOYEE.REPORTSTO%TYPE)
IS
BEGIN
    SELECT reportsto
    INTO mang_id
    FROM employee
    WHERE employeeid = emp_id;
END;
/
--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE get_customer(
    cust_id IN  CUSTOMER.CUSTOMERID%TYPE,
    fn      OUT CUSTOMER.FIRSTNAME%TYPE,
    ln      OUT CUSTOMER.LASTNAME%TYPE,
    comp    OUT CUSTOMER.COMPANY%TYPE)
IS
BEGIN
    SELECT firstname, lastname, company
    INTO fn, ln, comp
    FROM customer
    WHERE customerid = cust_id;
END;
/
--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure. 
--You will also be working with handling errors in your SQL.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, 
--          find out how to resolve them).

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table


--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
--
--6.2 BEFORE
--Task – Create a before trigger that restricts the deletion of any invoice that is priced over 50 dollars.


--7.0 JOINS
--In this section you will be working with combining various tables through the use of joins. You will work with outer, 
--inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT cust.firstname, cust.lastname, inv.invoiceid
FROM customer cust
JOIN invoice inv
ON cust.customerid = inv.customerid;
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, 
--          invoiceId, and total.
SELECT cust.customerId, cust.firstname, cust.lastname, inv.invoiceId, inv.total
FROM customer cust
JOIN invoice inv
ON cust.customerid = inv.customerid
WHERE cust.customerid IS NULL
OR inv.customerid IS NULL;
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT art.name, alb.title
FROM album alb
RIGHT JOIN artist art
ON art.artistid = alb.artistid;
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT *
FROM album alb
CROSS JOIN artist art
ORDER BY art.name;
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reports to column.
SELECT DISTINCT e.employeeid, e.firstname, e.lastname, e.title
FROM employee e
JOIN employee em
ON e.employeeid = em.reportsto
ORDER BY employeeid;


--8.0 Indexes
--In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
--8.1 Indexes
--Task – Create an index on of table of your choice
CREATE INDEX track_index
ON track (trackid, name, unitprice);
--2.0 SQL Queries
--In this section you will be performing various queries against the Oracle Chinook database.
--2.1 SELECT
--Task – Select all records from the Employee table.
SELECT *
FROM Employee;
--Task – Select all records from the Employee table where last name is King.
SELECT *
FROM Employee
WHERE lastname = 'King';
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT *
FROM Employee
WHERE firstname = 'Andrew' AND REPORTSTO IS NULL;
--2.2 ORDER BY
--Task – Select all albums in album table and sort result set in descending order
SELECT *
FROM Album
ORDER BY title DESC;
--Task – Select first name from Customer and sort result set in ascending order
SELECT firstname
FROM customer
ORDER BY firstname;
--2.3 INSERT INTO
--Task – Insert two new records into Genre table
INSERT INTO genre VALUES (26, 'Screamo');
INSERT INTO genre VALUES (27, 'Techno');
--Task – Insert two new records into Employee table
INSERT INTO employee VALUES (9, 'James', 'Jimothy', 'General Manager', 3, Date '1996-03-02', DATE '2013-04-23',
    '3434 Main Street', 'Portland', 'OR', 'USA', '12345', '+1 (303) 293-3849', '+1 (940) 483-3838', 'jimjames@gmail.com');
INSERT INTO employee VALUES (10, 'Tames', 'Timothy', 'Sales Manager', 2, Date '1994-05-25', DATE '2012-09-19',
    '14 Plymoth Ave', 'Chicago', 'IL', 'USA', '60625', '+1 (773) 849-9292', '+1 (312) 834-3749', 'timtames@gmail.com');
--Task – Insert two new records into Customer table
INSERT INTO Customer VALUES (1, 'Luís', 'Gonçalves', 'Embraer - Empresa Brasileira de Aeronáutica S.A.', 
    'Av. Brigadeiro Faria Lima, 2170', 'São José dos Campos', 'SP', 'Brazil', '12227-000', '+55 (12) 3923-5555', 
    '+55 (12) 3923-5566', 'luisg@embraer.com.br', 3);
INSERT INTO Customer VALUES (1, 'Luís', 'Gonçalves', 'Embraer - Empresa Brasileira de Aeronáutica S.A.', 
    'Av. Brigadeiro Faria Lima, 2170', 'São José dos Campos', 'SP', 'Brazil', '12227-000', '+55 (12) 3923-5555', 
    '+55 (12) 3923-5566', 'luisg@embraer.com.br', 3);
--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE Customer
SET firstname = 'Robert', lastname = 'Walter'
WHERE firstname = 'Aaron' AND lastname = 'Mitchell';

--Task – Update name of artist “Creedence Clearwater Revival” to “CCR”
UPDATE Artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';
--2.5 LIKE
--Task – Select all invoices with a billing address like “T”
SELECT *
FROM invoice
WHERE billingaddress LIKE 'T%';
--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT *
FROM invoice
WHERE total BETWEEN 15 AND 50;
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT *
FROM employee
WHERE hiredate BETWEEN DATE '2003-06-01' AND DATE '2004-03-01';
--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
SELECT invoiceid 
FROM invoiceline
WHERE invoiceid IN  
    (
        SELECT invoiceid 
        FROM invoice
        WHERE customerid = 
        (
            SELECT customerid
            FROM customer
            WHERE firstname = 'Robert' AND lastname = 'Walter'
        )
    );
DELETE  
FROM invoiceline
WHERE invoiceid IN  
    (
        SELECT invoiceid 
        FROM invoice
        WHERE customerid = 
        (
            SELECT customerid
            FROM customer
            WHERE firstname = 'Robert' AND lastname = 'Walter'
        )
    );
DELETE 
FROM invoice
WHERE customerid = 
    (
        SELECT customerid
        FROM customer
        WHERE firstname = 'Robert' AND lastname = 'Walter'
    );
DELETE 
FROM customer
WHERE firstname = 'Robert' AND lastname = 'Walter';
--
--3.0 SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
--Task – create a function that returns the length of a mediatype from the mediatype table
--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
--Task – Create a function that returns the most expensive track
--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
--Task – Create a stored procedure that returns the managers of an employee.
--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
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
--In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reports to column.
--8.0 Indexes
--In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
--8.1 Indexes
--Task – Create an index on of table of your choice


--QUERIES
--SELECT
/* Task – Select all records from the Employee table.*/
SELECT * 
FROM Employee;

/* Task – Select all records from the Employee table where last name is King.*/
SELECT *
FROM Employee
WHERE lastname = 'King';

/* Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.*/
SELECT *
FROM Employee
WHERE firstname = 'Andrew' AND reportsto IS null;

--ORDER BY
/* Task – Select all albums in album table and sort result set in descending order*/
SELECT title
FROM Album
ORDER BY title DESC ;

/* Task – Select first name from Customer and sort result set in ascending orde*/
SELECT firstname
FROM customer
ORDER BY firstname ASC ;

--INSERT INTO
/* Task – Insert two new records into Genre table*/
INSERT INTO genre VALUES (26, 'Synthwave');
INSERT INTO genre VALUES (27, 'Chillstep');
SELECT *
FROM genre;

/* Task – Insert two new records into Employee table*/
INSERT INTO employee VALUES (9, 'crew', 'joe', 'cashier', 1, DATE '1989-04-26', DATE '2010-02-27', '12343 Golo st w', 'minneapolis', 'mn', 'united states', '55433', '+1 (612) 234-4321', '+1 (378) 789-8776', 'joe@gmail.com');
INSERT INTO employee VALUES (10, 'lows', 'joey', 'cashier', 2, DATE '1989-05-27', DATE '2010-02-15', '16673 hihio st nw', 'minneapolis', 'mn', 'united states', '55433', '+1 (612) 774-4091', '+1 (372) 349-8556', 'lowz@gmail.com');
SELECT *
FROM employee;

/* Task – Insert two new records into Customer table*/
INSERT INTO customer VALUES (60, 'billy', 'bill', 'walmart', '55543 Golo st w', 'minneapolis', 'mn', 'united states', '55433', '+1 (612) 984-4321', '+1 (378) 789-8886', 'bill@gmail.com', 2);
INSERT INTO customer VALUES (61, 'timmy', 'tim', 'target', '99973 hihio st nw', 'minneapolis', 'mn', 'united states', '55433', '+1 (612) 194-4091', '+1 (372) 349-9056', 'tim@gmail.com', 5);
SELECT *
FROM customer;

--UPDATE
/* Task – Update Aaron Mitchell in Customer table to Robert Walter*/
UPDATE customer
SET firstname = 'Robert', lastname = 'Walter'
WHERE firstname = 'Aaron' AND lastname = 'Mitchell';
SELECT *
FROM customer;

/* Task – Update name of artist “Creedence Clearwater Revival” to “CCR”*/
UPDATE artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';
SELECT *
FROM artist;

--LIKE
/* Task – Select all invoices with a billing address like “T”*/
SELECT *
FROM invoice
WHERE billingaddress LIKE 'T%';

--BETWEEN
/*Task – Select all invoices that have a total between 15 and 50*/
SELECT *
FROM invoice
WHERE total > 15 AND total < 50;

/*Task – Select all employees hired between 1st of June 2003 and 1st of March 2004*/
SELECT *
FROM employee
WHERE hiredate > DATE '2003-06-01' AND hiredate < DATE '2004-03-01';

--DELETE
/*Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them)*/
--collab with kyle & aaron
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

--FUNCTIONS
--SYSTEM DEFINED FUNCTIONS
--Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION get_current_time
    RETURN TIMESTAMP
AS
    my_current_time TIMESTAMP  ;
BEGIN
    SELECT CURRENT_TIMESTAMP
    INTO my_current_time
    FROM dual;
    
    RETURN my_current_time;
END;
/

DECLARE
    my_current_time TIMESTAMP ;
BEGIN
    my_current_time := get_current_time();
    DBMS_OUTPUT.PUT_LINE('The current time is: ' || my_current_time);
END;
/

--Task – create a function that returns the length of a mediatype from the mediatype table

--SYSTEM DEFINED AGGREGATE FUNCTIONS
--Task – Create a function that returns the average total of all invoices

--Task – Create a function that returns the most expensive track

--USER DEFINED SCALAR FUNCTIONS
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table

--USER DEFINED TABLE VALUED FUNCTIONS
--Task – Create a function that returns all employees who are born after 1968.

--STORED PROCEDURES
--In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--BASIC STORED PROCEDURE
--Task – Create a stored procedure that selects the first and last names of all the employees.

--STORED PROCEDURE WITH INPUT PARAMS
--Task – Create a stored procedure that updates the personal information of an employee.

--Task – Create a stored procedure that returns the managers of an employee.

--STORED PROCEDURE WITH OUTPUT PARAMS
--Task – Create a stored procedure that returns the name and company of a customer.

--TRANSACTIONS
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table

--TRIGGERS
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.

--BEFORE
--Task – Create a before trigger that restricts the deletion of any invoice that is priced over 50 dollars.

--JOINS
--In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.

--OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.

--RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.

--CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.

--SELF
--Task – Perform a self-join on the employee table, joining on the reports to column.

--INDEXES
--In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
--Task – Create an index on of table of your choice



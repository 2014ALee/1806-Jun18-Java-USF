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
ORDER BY firstname ASC;
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
INSERT INTO Customer VALUES (60, 'Jorge', 'Samuels', 'Towing Inc.', 
    '1234 Main', 'Tampa', 'FL', 'USA', '33610', '+1 (323) 234-4432', 
    '+1 (323) 234-3324', 'jsameuls@gmail.com', 2);
INSERT INTO Customer VALUES (61, 'John', 'Jones', 'Dunder Mifflin', 
    '2342 Octagon Ave', 'Scranton', 'PA', 'USA', '19134', '+1 215 234-2343', 
    '', 'JJAMES@GMAIL.COM', 1);
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
--Collab with Brandon
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


SAVEPOINT customer_delete;
--
--3.0 SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION current_time
    RETURN TIMESTAMP
AS
    currentTime TIMESTAMP;
BEGIN
    SELECT CURRENT_TIMESTAMP
    INTO currentTime
    FROM dual;
    
    RETURN currentTime;
END;
/
--Testing current time function
DECLARE
    ct TIMESTAMP;
BEGIN
    ct := current_time();
    DBMS_OUTPUT.PUT_LINE('The current time is: ' || ct);
END;
/

--Task – create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION mediatype_length
    RETURN NUMBER
AS
    mediatype_length NUMBER;
BEGIN
    SELECT LENGTH(name)
    INTO mediatype_length
    FROM mediatype
    WHERE ROWNUM = 1;
    
    RETURN mediatype_length;
END;
/

DECLARE
    len NUMBER;
BEGIN
    len := mediatype_length();
    DBMS_OUTPUT.PUT_LINE('The length of the first mediatype entry is ' || len);
END;
/
--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION get_invoice_avg
    RETURN NUMBER
AS 
    invoice_avg NUMBER;
BEGIN
    SELECT AVG(total) 
    INTO invoice_avg
    FROM invoice;
    
    RETURN invoice_avg;
 END;
 / 
 --Testing avg invoice 
DECLARE
    average NUMBER;
BEGIN
    average := get_invoice_avg();
    DBMS_OUTPUT.PUT_LINE('The average is: ' || average);
END;
/

--Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION most_exp_track
    RETURN VARCHAR2
AS
    trackname VARCHAR2(200 BYTE);
BEGIN
    SELECT track.name
    INTO trackname
    FROM track 
    WHERE unitprice = 
        (
        SELECT MAX(unitprice)
        FROM track
        ) AND ROWNUM = 1;
    RETURN trackname;
END;
/

--Testing most expensive track (Expect for track with unitprice = 1.99)
DECLARE 
    most_exp VARCHAR(200 BYTE);
BEGIN
    most_exp := most_exp_track();
    DBMS_OUTPUT.PUT_LINE('The most expensive track is ' || most_exp);
END;
/
--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION get_invoiceline_avg
    RETURN NUMBER
AS 
    invoiceline_avg NUMBER;
BEGIN
    SELECT AVG(total) 
    INTO invoiceline_avg
    FROM invoiceline;
    
    RETURN invoiceline_avg;
 END;
 / 
 --Testing avg invoiceline
DECLARE
    average NUMBER;
BEGIN
    average := get_invoice_avg();
    DBMS_OUTPUT.PUT_LINE('The average is: ' || average);
END;
/
--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION after_1968
RETURN SYS_REFCURSOR
IS
    my_cursor SYS_REFCURSOR;
BEGIN
    OPEN my_cursor FOR --The result SET returned by the query is stored IN our declared cursor
    SELECT firstname, lastname, birthdate
    FROM employee
    WHERE birthdate > DATE '1968-12-31';
    RETURN my_cursor; -- Function returns SYS_REFCURSOR, so RETURN the declared cursor
END function_name;

--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE get_names(
    my_cursor OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN my_cursor FOR 
    SELECT lastname, firstname
    FROM employee
    ORDER BY lastname;
END;
/ 

DECLARE 
    firstname EMPLOYEE.FIRSTNAME%TYPE;
    lastname EMPLOYEE.LASTNAME%TYPE;
    my_cursor SYS_REFCURSOR;
BEGIN
    get_names(my_cursor);
    LOOP
        FETCH my_cursor
        INTO lastname, firstname;
        
        EXIT WHEN my_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(firstname || ' ' || lastname);
    END LOOP;
    CLOSE my_cursor;
END;
--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE update_info(
    empid IN NUMBER, fn IN VARCHAR2, ln IN VARCHAR2, addr IN VARCHAR2, c IN VARCHAR2, st IN VARCHAR2, coun IN VARCHAR2, post IN VARCHAR2, 
    ph IN VARCHAR2, fx IN VARCHAR2, em IN VARCHAR2)
AS
BEGIN
    UPDATE employee
    SET firstname = fn,
        lastname = ln,
        address = addr,
        city = c,
        state = st,
        country = coun,
        postalcode = post,
        phone = ph,
        fax = fx,
        email = em
        WHERE employeeid = empid;
END;
/ 
--Task – Create a stored procedure that returns the managers of an employee.

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE get_name_and_comp (
    my_cursor OUT SYS_REFCURSOR, custid IN NUMBER)
AS
BEGIN
    OPEN my_cursor FOR 
    SELECT lastname, firstname, company, customerid
    FROM customer
    WHERE customerid = custid
    ORDER BY lastname;
END;
/ 

DECLARE
    firstname CUSTOMER.FIRSTNAME%TYPE;
    lastname CUSTOMER.LASTNAME%TYPE;
    company CUSTOMER.COMPANY%TYPE;
    customerid CUSTOMER.CUSTOMERID%TYPE;
    my_cursor SYS_REFCURSOR;
BEGIN
    get_name_and_comp(my_cursor, 10);
    LOOP
        FETCH my_cursor
        INTO lastname, firstname, company, customerid;
        
        EXIT WHEN my_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(firstname || ' ' || lastname || ' works for ' || company);
    END LOOP;
    CLOSE my_cursor;
END;
/
savepoint stored_procedures;
--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE delete_invoice (
    invId IN INVOICE.INVOICEID%TYPE)
AS
BEGIN
    DELETE 
    FROM invoiceline
    WHERE invoiceid = invId;
    DELETE
    FROM invoice
    WHERE invoiceid = invId;
    COMMIT;
END;
/
DECLARE
    invId INVOICE.INVOICEID%TYPE;
BEGIN 
    delete_invoice(1);
END;
/

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER emp_insert_trigger
AFTER INSERT ON employee 
FOR EACH ROW 

BEGIN 
    DBMS_OUTPUT.PUT_LINE('New employee inserted');
END;

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER album_update_trigger
AFTER UPDATE ON album
FOR EACH ROW 

BEGIN 
    DBMS_OUTPUT.PUT_LINE('Abum has been updated');
END; 
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER cust_delete_trigger
AFTER DELETE ON customer 
FOR EACH ROW 

BEGIN 
    DBMS_OUTPUT.PUT_LINE('Customer has been deleted.');
END;
--
--6.2 BEFORE
--Task – Create a before trigger that restricts the deletion of any invoice that is priced over 50 dollars.
CREATE OR REPLACE TRIGGER invoice_trigger
BEFORE DELETE ON invoice 
FOR EACH ROW 
DECLARE 
    price NUMBER;

BEGIN 
    SELECT total 
    INTO price
    FROM invoice;
    IF (price > 50)
    THEN
        RAISE_APPLICATION_ERROR( -20001, 
                             'Cannot delete invoice that is priced over 50 dollars' );
    END IF;
END;
--7.0 JOINS
--In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT firstname, lastname, invoiceid
FROM customer
JOIN invoice
USING (customerid);
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT customerid, firstname, lastname, invoiceid, total
FROM customer
OUTTER JOIN invoice
USING (customerid);
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT artist.name, title
FROM album
RIGHT JOIN artist
USING (artistid);
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
select artist.name, album.title
FROM album
CROSS JOIN artist;
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reports to column.
SELECT *
FROM employee e
JOIN employee em
ON (e.reportsto = em.employeeid);
--8.0 Indexes
--In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
--8.1 Indexes
--Task – Create an index on of table of your choice
CREATE INDEX album_ind ON album (artistid, title);

commit;

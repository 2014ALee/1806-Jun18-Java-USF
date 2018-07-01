-- Karen Matney

-- 2.1 SELECT
-- Task: Select all records from the Employee table.
SELECT *
FROM employee;

-- Task: Select all records from the Employee table where last name is King.
SElECT *
FROM employee
WHERE lastname = 'King';

-- Task: Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT *
FROM employee
WHERE firstname = 'Andrew' AND reportsto is null;

-- 2.2 ORDER BY
-- Task: Select all albums in album table and sort result set in descending order
Select *
FROM album
ORDER BY title DESC;

-- Task: Select first name from Customer and sort result set in ascending order
SELECT firstname
FROM customer
ORDER BY firstname; -- Ascending is implicit

-- 2.3 INSERT INTO
-- Task: Insert two new records into Genre table
INSERT INTO genre
VALUES (26,'Pop punk');

INSERT INTO genre
VALUES (27,'Bubblegum pop');

-- Task: Insert two new records into Employee table
INSERT INTO employee
VALUES (9,'Rozewichz','Megan','IT Staff', 6,DATE '1993-05-08',DATE '2009-06-09','923 7 ST NW','Lethbridge','AB','Canda',
'T1H 1Y8','+1 (324) 234-4534','+1 (234) 234-4535','megan@chinnokcorp.com');

INSERT INTO employee
VALUES (10,'Norman','Tiana','Sales Support Agent', 2,DATE '1993-04-14',DATE '2009-06-09','923 7 ST NW','Calgary','AB','Canda',
'T3B 1Y8','+1 (314) 234-5034','+1 (212) 223-1245','tiana@chinnokcorp.com');

-- Task: Insert two new records into Customer table
INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, State, Country, PostalCode, Phone, Email, SupportRepId)
VALUES (60, 'Jon', 'Smith', '234 Main St', 'Somewhere', 'KS', 'USA', '12345', '+1 (123) 456-6789', 'jon@email.com', 10);

INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, State, Country, PostalCode, Phone, Email, SupportRepId)
VALUES (61, 'Marie', 'Jackson', '234 Main St', 'Paris', 'OH', 'USA', '98765', '+1 (123) 456-1233', 'marie@email.com', 10);

-- 2.4 UPDATE
-- Task: Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer
SET lastname = 'Walter', firstname = 'Robert'
WHERE customerid = 32; -- used customerid because general don't want to update all 'Aaron Mitchell's in this scenario

-- Task: Update name of artist â€œCreedence Clearwater Revivalâ€? to â€œCCRâ€?
UPDATE artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';

-- 2.5 LIKE
-- Task: Select all invoices with a billing address like â€œTâ€?
SELECT *
FROM invoice
WHERE billingaddress LIKE '%T%';  -- Need percent on at least one side or it retrieves an empty result set

-- 2.6 BETWEEN
-- Task: Select all invoices that have a total between 15 and 50
SELECT *
FROM invoice
WHERE total BETWEEN 15 AND 50;  -- inclusive

-- Task: Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT *
FROM employee
WHERE hiredate BETWEEN DATE '2003-06-01' AND DATE '2004-03-01';

-- 2.7 DELETE
-- Task: Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this,
-- find out how to resolve them).
DELETE FROM invoiceline         -- invoiceline has a foreign key 
WHERE invoiceid = ANY           -- returns true if any of the subquery values meet the condition
(
    SELECT invoiceid            -- finds all of the invoiceids for Robert Walter (customerid = 32)
    FROM invoice
    WHERE customerid = 32
);

DELETE FROM invoice             -- Deletes all invoices for Robert Walter
WHERE customerid = 32;

DELETE FROM customer            -- Finally can delete Robert Walter
WHERE customerid = 32;

-- 3.1 System Defined Functions
-- Task: Create a function that returns the current time.
CREATE OR REPLACE FUNCTION get_current_time
    RETURN DATE
AS
    curr_time TIMESTAMP;
BEGIN
    curr_time := CURRENT_TIMESTAMP;
    RETURN curr_time;
END;
/

DECLARE
    curr_time TIMESTAMP;
BEGIN
    curr_time := get_current_time();
    DBMS_OUTPUT.PUT_LINE('Current Time: ' || curr_time);
END;
/

-- Task: create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION get_length (mediatype IN STRING)
    RETURN NUMBER
AS
    char_length NUMBER;
BEGIN
    char_length := LENGTH(mediatype);
    
    RETURN char_length;
END;
/

SELECT get_length(name)
FROM mediatype;

-- 3.2 System Defined Aggregate Functions
-- Task: Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION get_avg_invoice
    RETURN NUMBER
AS
    average_invoice NUMBER;
BEGIN
    SELECT AVG(total)
    INTO average_invoice
    FROM invoice;
    
    RETURN average_invoice;
END;
/

DECLARE
    avg_invoice NUMBER;
BEGIN
    avg_invoice := get_avg_invoice();
    DBMS_OUTPUT.PUT_LINE('Average invoice: ' || avg_invoice);
END;
/

-- Task: Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION get_highest_priced_track
    RETURN SYS_REFCURSOR
IS
    my_cursor SYS_REFCURSOR;
BEGIN
    OPEN my_cursor FOR
    
    SELECT trackid,name
    FROM track
    WHERE unitprice =
    (
        SELECT MAX(unitprice)
        FROM track
    );
    
    RETURN my_cursor;
END;
/

SELECT get_highest_priced_track()
FROM dual;

-- 3.3 User Defined Scalar Functions
-- Task: Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION get_average_invoiceline
    RETURN NUMBER
AS
    avg_invoiceline NUMBER;
BEGIN
    DECLARE 
        counting NUMBER;
    BEGIN
    SELECT SUM(unitprice)
    INTO avg_invoiceline
    FROM invoiceline;
    
    SELECT COUNT(*)
    INTO counting
    FROM invoiceline;
    
    avg_invoiceline := avg_invoiceline / counting;
    
    END;
    RETURN avg_invoiceline;
END;
/

DECLARE
avg_invoiceline NUMBER;
BEGIN
    avg_invoiceline := get_average_invoiceline();
    DBMS_OUTPUT.PUT_LINE('Average invoiceline: ' || avg_invoiceline);
END;
/

-- Checking correct value
SELECT AVG(unitprice)
FROM INVOICELINE;

-- 3.4 User Defined Table Valued Functions 
-- Task: Create a function that returns all employees who are born after 1968.
-- Working with an explicit cursor
CREATE OR REPLACE FUNCTION after_1968
    RETURN SYS_REFCURSOR                    -- The result set returned by the query is stored in our declared cursor
IS
    my_cursor SYS_REFCURSOR;
BEGIN
    OPEN my_cursor FOR
    SELECT firstname,lastname,birthdate
    FROM employee
    WHERE birthdate > DATE '1968-12-31';
    
    RETURN my_cursor;                       -- This function returns a SYS_REFCURSOR, so return our declared cursor
END;
/

-- Using the dual table to invoke our stored function
SELECT after_1968()
FROM dual;

-- 4.1 Basic Stored Procedure
-- Task: Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE get_all_employees (my_cursor OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN my_cursor FOR
    SELECT firstname,lastname
    FROM employee
    ORDER BY lastname;
END;
/

DECLARE 
    first_name EMPLOYEE.FIRSTNAME%TYPE;
    last_name EMPLOYEE.LASTNAME%TYPE;
    my_cursor SYS_REFCURSOR;
BEGIN
    get_all_employees(my_cursor);
    
    LOOP
        FETCH my_cursor                     -- FETCH the next record stored in my cursor
        INTO first_name,last_name;         -- put the values in my_cursor in to these variables
        
        EXIT WHEN my_cursor%NOTFOUND;       -- exit this loop when there are no more records in my_cursor -- %
        
        DBMS_OUTPUT.PUT_LINE('First Name: ' || first_name || ' ' || last_name);
    END LOOP;
    CLOSE my_cursor;                        -- good practice dictates tate we close cursors when we are done with them
END;
/

-- 4.2 Stored Procedure Input Parameters
-- Task: Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE update_employee (
u_employeeid IN NUMBER,
e_lastname IN VARCHAR2,
e_firstname IN VARCHAR2,
e_title IN VARCHAR2,
e_reportsto IN NUMBER,
e_birthdate IN DATE,
e_hiredate IN DATE,
e_address IN VARCHAR2,
e_city IN VARCHAR2,
e_state IN VARCHAR2,
e_country IN VARCHAR2,
e_postalcode IN VARCHAR2,
e_phone IN VARCHAR2,
e_fax IN VARCHAR2,
e_email IN VARCHAR2
)
IS
BEGIN

UPDATE employee
SET lastname = e_lastname,
firstname = e_firstname,
title = e_title,
reportsto = e_reportsto,
birthdate = e_birthdate,
hiredate = e_hiredate,
address = e_address,
city = e_city,
state = e_state,
country = e_country,
postalcode = e_postalcode,
phone = e_phone,
fax = e_fax,
email = e_email
WHERE employeeid = u_employeeid;

END;
/

-- Check to see if it works
-- User could create a procedure/function to get the current values, iterate through, etc
BEGIN
update_employee(8,'Summers','Crystal','Systems Manager',1, DATE '1999-09-09', DATE '2007-07-07','2345 Adobe St','Florence','NM','USA','23412','+1 (850) 823-1239','+1 (234) 234-2346','crystal@email.com');
END;
/
-- Task: Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE get_manager(e_id IN NUMBER,
m_firstname OUT VARCHAR,
m_lastname OUT VARCHAR
)        -- Assuming only the one, more than one would be a cursor
AS
BEGIN
    SELECT m.firstname,m.lastname  -- more than one would use a loop until reportsto = null
    INTO m_firstname,m_lastname
    FROM employee e
    JOIN employee m
    ON m.employeeid = e.reportsto
    WHERE e.employeeid = e_id;
END;
/

DECLARE
m_firstname VARCHAR(20);
m_lastname VARCHAR(20);
BEGIN
get_manager(3,m_firstname,m_lastname);
DBMS_OUTPUT.PUT_LINE('manager ' || m_firstname || ' ' || m_lastname);
END;
/
-- 4.3 Stored Procedure Output Parameters
-- Task: Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE get_cust_name_company(
c_id IN NUMBER,
c_firstname OUT VARCHAR,
c_lastname OUT VARCHAR,
c_company OUT VARCHAR
)
IS
BEGIN
    SELECT firstname,lastname,company
    INTO c_firstname,c_lastname,c_company
    FROM customer
    WHERE customerid = c_id;
END;
/

DECLARE
c_firstname VARCHAR(40);
c_lastname VARCHAR(20);
c_company VARCHAR(80);
BEGIN
get_cust_name_company(6,c_firstname,c_lastname,c_company);
DBMS_OUTPUT.PUT_LINE('Customer: ' || c_firstname || ' ' || c_lastname || ', Company: ' || c_company);
END;
/

-- 5.0 Transactions ...
-- Task: Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this,
-- find out how to resolve them).
ALTER TABLE invoiceline
    DROP CONSTRAINT fk_invoicelineinvoiceid;
    
ALTER TABLE invoiceline
    ADD CONSTRAINT fk_invoicelineinvoiceid
    FOREIGN KEY (invoiceid)
    REFERENCES invoice(invoiceid)
    ON DELETE CASCADE;
        
CREATE OR REPLACE PROCEDURE delete_invoice(i_invoiceid IN NUMBER)
IS
BEGIN
DELETE FROM invoice
WHERE invoiceid = i_invoiceid;
-- SAVEPOINT;
END;
/

BEGIN
delete_invoice(5);
END;
/

-- Task: Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE commit_insert(
e_lastname IN VARCHAR2,
e_firstname IN VARCHAR2,
e_title IN VARCHAR2,
e_reportsto IN NUMBER,
e_birthdate IN DATE,
e_hiredate IN DATE,
e_address IN VARCHAR2,
e_city IN VARCHAR2,
e_state IN VARCHAR2,
e_country IN VARCHAR2,
e_postalcode IN VARCHAR2,
e_phone IN VARCHAR2,
e_fax IN VARCHAR2,
e_email IN VARCHAR2
)
IS
BEGIN
INSERT INTO employee(lastname,firstname,title,reportsto,birthdate,hiredate,address,citystate,country,postalcode,phone,
fax,email)
VALUES (e_lastname,e_firstname,e_title,e_reportsto,e_birthdate,e_hiredate,e_address,e_city,e_state,e_country,e_postalcode,
e_phone,e_fax,e_email);

-- SAVEPOINT;
END;
/

-- 6.1 AFTER/FOR
-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER name
AFTER INSERT ON table
-- ON EACH ROW equivalent?
BEGIN
END;
/

-- Task: Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER name
AFTER INSERT ON table
-- ON EACH ROW equivalent?
BEGIN
END;
/

-- Task: Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER name
AFTER DELETE ON table
-- ON EACH ROW equivalent?
BEGIN
END;
/

-- 6.2 BEFORE
-- Task: Create a before trigger that restricts the deletion of any invoice that is priced over 50 dollars.
CREATE OR REPLACE TRIGGER name
BEFORE INSERT ON table
-- ON EACH ROW equivalent?
BEGIN
END;
/

-- 7.1 INNER
-- Task: Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT c.firstname, c.lastname, i.invoiceid
FROM customer c
JOIN invoice i
USING (customerid);

-- 7.2 OUTER
-- Task: Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname,
-- invoiceId, and total.
SELECT c.customerid, c.firstname, c.lastname, i.invoiceid, i.total
FROM customer c
FULL OUTER JOIN invoice i
ON c.customerid = i.customerid;

-- 7.3 RIGHT
-- Task: Create a right join that joins album and artist specifying artist name and title.
SELECT art.name, alb.title
FROM album alb
RIGHT JOIN artist art
ON alb.artistid = art.artistid;

-- 7.4 CROSS
-- Task: Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT art.name, alb.title
FROM album alb
CROSS JOIN artist art
ORDER BY art.name;

-- 7.5 SELF
-- Task: Perform a self-join on the employee table, joining on the reports to column.
SELECT e.firstname as e_firstname, e.lastname as e_lastname,
    r.firstname as rt_firstname, r.lastname as rt_lastname
FROM employee e
JOIN employee r
ON e.reportsto = r.employeeid;

-- 8.1 Indexes
-- Task: Create an index on of table of your choice (not employee)
CREATE INDEX customer_address
ON customer (customerid,firstname,lastname,address,city,state,country,postalcode);
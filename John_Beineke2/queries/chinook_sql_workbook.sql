/*
    John Beineke
    SQL Workbook questions
*/

/*
    2.1 - SELECT
*/

-- Task – Select all records from the Employee table.
SELECT *
  FROM employee;
  
-- Task – Select all records from the Employee table where last name is King.
SELECT * 
  FROM employee
 WHERE lastname = 'King';
 
 -- Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
 SELECT *
   FROM employee
  WHERE FIRSTNAME = 'Andrew'
    AND REPORTSTO = null;
    
/*
    2.2 ORDER BY
*/

-- Task – Select all albums in album table and sort result set in descending order
  SELECT * 
    FROM album
ORDER BY ALBUMID DESC;

-- Task – Select first name from Customer and sort result set in ascending order
SELECT firstname
  FROM customer
  ORDER BY firstname;
  
/*
    INSERT INTO
*/

-- Task – Insert two new records into Genre table
INSERT INTO genre VALUES (26, 'Summer Jams');
INSERT INTO genre VALUES (27, 'Movie Soundtrack');

-- Task – Insert two new records into Employee table
INSERT INTO employee VALUES (9, 'Beineke', 'John', 'IT Staff', 1, DATE '1995-01-03', DATE '2018-06-27', '8637 Railroad Rd.', 'Indianapolis',
'IN', 'USA', '46217', '1 (317) 956-0842', '1 (317) 956-0842', 'jb@gmail.com');

INSERT INTO employee VALUES (10, 'Beineke', 'Jeff', 'Sales Support Staff', 1, DATE '1959-01-23', DATE '1986-10-03', '123 Pancake Rd.', 'Louisville',
'KY', 'USA', '72539', '1 (857) 266-0428', '1 (857) 266-0428', 'jb123@gmail.com');

-- Task – Insert two new records into Customer table
INSERT INTO customer VALUES (60, 'Collins', 'Tom', null, '321 Post Rd.', 'Little Rock',
'AK', 'USA', '19539', '1 (857) 266-0428', null, 'tomc@gmail.com', 2);

INSERT INTO customer VALUES (61, 'Robbins', 'Stu', null, '9827 Pidgeon St.', 'San Diego',
'CA', 'USA', '19641', '1 (857) 266-0428', null, 'sturob@gmail.com', 3);

COMMIT;

/*
    2.4 UPDATE
*/

-- Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer
SET firstname = 'Robert',
    lastname = 'Walter'
WHERE customerid = 32;

-- Task – Update name of artist “Creedence Clearwater Revival” to “CCR”
UPDATE artist
SET name = 'CCR'
WHERE ARTISTID = 76;

/*
    2.5 LIKE
*/
-- Task – Select all invoices with a billing address like “T”
SELECT *
  FROM invoice
 WHERE billingaddress like 'T%';
 
 /*
    2.6 BETWEEN
 */
 
 -- Task – Select all invoices that have a total between 15 and 50
 SELECT *
   FROM invoice
 WHERE total BETWEEN 15 AND 50;
 
 -- Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
 SELECT * 
   FROM employee
  WHERE hiredate BETWEEN DATE '2003-06-01' AND DATE '2004-03-01';
  
/*
    2.7 DELETE
*/
-- Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this,
-- find out how to resolve them).
DELETE
FROM customer 
WHERE firstname = 'Robert' AND lastname = 'Walter';

COMMIT;

/*
    3.1 SYSTEM DEFINED FUNCTIONS
*/

-- Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION get_time
    RETURN TIMESTAMP
AS
    curr_time DATE;
BEGIN
    SELECT CURRENT_TIMESTAMP
    INTO curr_time
    FROM dual;
    RETURN curr_time;
END;
/

SELECT get_time()
FROM dual;

-- Task – create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION get_mediatype_length(media_type IN NUMBER)
    RETURN NUMBER
AS
    mediatype_length NUMBER;
BEGIN
    SELECT LENGTH(name)
    INTO mediatype_length
    FROM mediatype
    WHERE mediatypeid = media_type;
    RETURN mediatype_length;
END;
/

SELECT get_mediatype_length(2)
FROM dual;

/*
    3.2 - SYSTEM AGGREGATE FUNCTIONS
*/

-- Task – Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION avg_total
    RETURN VARCHAR2
IS
    avg_total VARCHAR2(100);
BEGIN
    SELECT AVG(UNITPRICE)
    INTO avg_total
    FROM track;
    RETURN avg_total;
END;
/

SELECT avg_total()
FROM dual;

-- Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION most_exp_track
    RETURN VARCHAR2
AS
    most_exp VARCHAR2(50);
BEGIN
    SELECT name
    INTO most_exp
    FROM track
    WHERE unitprice = (
            SELECT MAX(unitprice)
            FROM track) AND rownum =1;
    RETURN most_exp;   
END;
/

SELECT MOST_EXP_TRACK()
FROM dual;

/*
    3.3 USER DEFINED SCALAR FUNCTIONS
*/
-- Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION avg_inline_price
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

SELECT avg_inline_price()
FROM dual;

/*
3.4 User Defined Table Valued Functions
*/
-- Task – Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION after_1968
    RETURN SYS_REFCURSOR
IS
    my_cursor SYS_REFCURSOR;
BEGIN
    OPEN my_cursor FOR
    SELECT firstname, lastname, birthdate
      FROM employee
     WHERE birthdate > DATE '1968-12-31';
     
     RETURN my_cursor; -- this function returns a sysref cursor, so return our declared cursor
END;
/

-- Using dual table to invoke stored function
SELECT after_1968()
  FROM dual;
  
/*
4.1 Basic Stored Procedure
*/
-- Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE get_employees(emp_cursor OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN emp_cursor FOR
    SELECT firstname, lastname
    FROM employee;
END;
/


DECLARE
    firstname EMPLOYEE.FIRSTNAME%TYPE;
    lastname EMPLOYEE.LASTNAME%TYPE;
    emp_cursor SYS_REFCURSOR;
BEGIN
    get_employees(emp_cursor);
    
    LOOP
        FETCH emp_cursor                 -- fetch the next record stored in my_cursor
        INTO firstname, lastname;        -- puth the values in my_cursor into these variables
        
        EXIT WHEN emp_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('emp First Name: ' || firstname || ' emp Last Name: ' || lastname);
    END LOOP;
    CLOSE emp_cursor;
END;
/

-- Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE modify_employee(empid IN NUMBER)
IS
BEGIN
    UPDATE employee
    SET firstname = 'BillyBob'
    WHERE employee.employeeid = empid;
END;
/

-- Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE find_managers(
    my_cursor OUT SYS_REFCURSOR,
    emp_id IN NUMBER)
AS
BEGIN
    OPEN my_cursor FOR
    SELECT firstname, lastname
    FROM employee
    WHERE employeeid <= (SELECT reportsto
            FROM employee
            WHERE employeeid = emp_id );
END;
/
DECLARE
    firstname EMPLOYEE.FIRSTNAME%TYPE;
    lastname EMPLOYEE.LASTNAME%TYPE;
    my_cursor SYS_REFCURSOR;
BEGIN
    find_managers(my_cursor, 5);
    LOOP
        FETCH my_cursor
        INTO firstname, lastname; 
        
        EXIT WHEN my_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Manager First Name: ' || firstname || ' Manager Last Name: ' || lastname);
    END LOOP;
    CLOSE my_cursor;
END;
/

--                  4.3 Stored Procedure Output Parameters
-- Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE get_info(
        my_cursor OUT SYS_REFCURSOR,
        cust_id IN NUMBER)
IS
BEGIN
    OPEN my_cursor FOR
    SELECT firstname, lastname, company
    FROM CUSTOMER
    WHERE customerid = cust_id;
END;
/

DECLARE 
    firstname CUSTOMER.FIRSTNAME%TYPE;
    lastname CUSTOMER.LASTNAME%TYPE;
    company CUSTOMER.COMPANY%TYPE;
    my_cursor SYS_REFCURSOR;
BEGIN
    get_info(my_cursor, 5);
        LOOP
         FETCH my_cursor
         INTO firstname, lastname, company;
         EXIT WHEN my_cursor%NOTFOUND;
         DBMS_OUTPUT.PUT_LINE('First Name: ' || firstname || ' Last Name: ' || lastname || ' Company: ' || company);
        END LOOP;
        CLOSE my_cursor;
END;
/

-- 5.0 Transactions
-- Task – Create a transaction that given a invoiceId will delete that invoice 
-- (There may be constraints that rely on this, find out how to resolve them).



/*
    6.0 Triggers 
In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
6.1 AFTER/FOR
Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
*/
CREATE OR REPLACE TRIGGER insert_employee
AFTER INSERT ON employee
FOR EACH ROW 
BEGIN
DBMS_OUTPUT.PUT_LINE('New employee inserted');
END;
/

-- Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER insert_album
AFTER INSERT ON album
FOR EACH ROW 
BEGIN
DBMS_OUTPUT.PUT_LINE('New album inserted');
END;
/

-- 6.2 BEFORE
-- Task Create a before trigger that restricts the deletion of any invoice that is priced over 50 dollars.
CREATE OR REPLACE TRIGGER restrict_deletion
BEFORE INSERT ON invoice
FOR EACH ROW
BEGIN
    if (:old.total >= 50) 
    THEN 
        RAISE_APPLICATION_ERROR(-2000, 'Cannot delete invoices with a price over 50!');  
    END IF;
END;
/

-- Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER delete_customer
AFTER DELETE ON customer
FOR EACH ROW 
BEGIN
DBMS_OUTPUT.PUT_LINE('Customer deleted');
END;
/

/*
    7.1 INNER JOIN
*/
-- Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT firstname, lastname, invoiceid
  FROM Customer, Invoice
 WHERE customer.customerid = invoice.customerid;

/*
    7.2 OUTER JOIN
*/
-- Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT c.customerid, c.firstname, c.lastname, i.invoiceid, i.total
FROM customer c
LEFT OUTER JOIN invoice i
ON c.customerid = i.customerid;

-- 7.3 RIGHT
-- Task – Create a right join that joins album and artist specifying artist name and title.
SELECT a.name, b.title
FROM artist a
RIGHT OUTER JOIN album b
ON a.ARTISTID = b.artistid;

-- 7.4 CROSS
-- Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT *
FROM artist, album
ORDER BY artist.NAME;

-- 7.5 SELF
-- Task – Perform a self-join on the employee table, joining on the reports to column.
SELECT *
FROM employee a, employee b
WHERE a.reportsto = b.reportsto;

-- 8.1 Indexes
-- Task – Create an index on of table of your choice
CREATE INDEX cust_index ON customer (customerid, firstname, lastname);

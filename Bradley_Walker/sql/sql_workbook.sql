-- 2.1

-- Select all records from the employee table
SELECT *
FROM employee;

-- Select all records from the employee table where last name is King
SELECT *
FROM employee
WHERE lastname = 'King';

-- Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT *
FROM employee
WHERE firstname = 'Andrew' AND reportsto IS NULL;

-- 2.2

-- Select all albums in album table and sort result set in descending order
SELECT *
FROM album
ORDER BY title DESC;

-- Select first name from Customer and sort result set in ascending order
SELECT firstname
FROM customer
ORDER BY firstname;

-- 2.3

-- Insert two new records into Genre table
INSERT INTO genre VALUES(26, 'R and B');
INSERT INTO genre VALUES(27, 'Gospel');

-- Insert two new records into Employee table
INSERT INTO employee VALUES(9, 'Nichols', 'Rachel', 'Awesome Bro', 1, '01-JAN-89', '01-FEB-14', '1234 Main Street', 'Anywhere', 'AB', 'Canada', 'places', 'numbers', 'more numbers', 'a@gmail.com');
INSERT INTO employee VALUES(10, 'Nichols', 'Nate', 'Awesome Bro', 1, '01-JAN-89', '01-FEB-14', '1234 Main Street', 'Anywhere', 'AB', 'Canada', 'places', 'numbers', 'more numbers', 'b@gmail.com');

-- Insert two new records into Customer table
SELECT * FROM customer;
INSERT INTO customer VALUES(60, 'Aaron', 'Matthews', 'Revature', '1234 Main Street', 'Tampa', 'FL', 'United States', 'numbers', 'numbers', 'numbers', 'email', 3);
INSERT INTO customer VALUES(61, 'Wezley', 'Singleton', 'Revature', '1235 Main Street', 'Tampa', 'FL', 'United States', 'numbers', 'numbers', 'numbers', 'email', 3);

-- 2.4

-- Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer
SET firstname = 'Robert', lastname = 'Walter'
WHERE firstname = 'Aaron' AND lastname = 'Mitchell';

-- Update name of artist “Creedence Clearwater Revival” to “CCR”
UPDATE artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';

-- 2.5

-- Select all invoices with a billing address like “T”
SELECT *
FROM invoice
WHERE billingaddress LIKE 'T';

-- 2.6

-- Select all invoices that have a total between 15 and 50
SELECT *
FROM invoice
WHERE total BETWEEN 15 and 50;

-- Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT *
FROM employee
WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';

-- 2.7

-- Delete a record in Customer table where the name is Robert Walter
DELETE FROM invoiceline
WHERE invoiceid IN (SELECT invoiceid
                    FROM invoice
                    WHERE customerid IN (SELECT customerid
                                        FROM customer
                                        WHERE firstname = 'Robert' AND lastname = 'Walter'));
DELETE FROM invoice
WHERE customerid IN (SELECT customerid
                    FROM customer
                    WHERE firstname = 'Robert' AND lastname = 'Walter');
DELETE FROM customer
WHERE firstname = 'Robert' AND lastname = 'Walter';

-- 3.1

-- Create a function that returns the current time.
CREATE OR REPLACE FUNCTION get_time
    RETURN VARCHAR2
IS
    my_time VARCHAR2(8);
BEGIN
    my_time := TO_CHAR (SYSDATE, 'HH12:MI:SS');
    RETURN my_time;
END;
/

SELECT get_time()
FROM dual;

-- create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION get_length(i IN NUMBER)
    RETURN NUMBER
IS
    len NUMBER(8);
BEGIN
    SELECT LENGTH(name) INTO len FROM mediatype WHERE mediatypeid = i;
    RETURN len;
END;
/

SELECT get_length(1)
FROM dual;

-- Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION get_avg_total
    RETURN NUMBER
IS
    average NUMBER(8);
BEGIN
    SELECT AVG(total) INTO average FROM invoice;
    RETURN average;
END;
/

SELECT get_avg_total()
FROM dual;

-- Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION most_expensive
    RETURN VARCHAR2
IS
    t VARCHAR2(200);
BEGIN
    SELECT name
    INTO t
    FROM track
    WHERE unitprice IN (
        SELECT MAX(unitprice)
        FROM track
    ) AND ROWNUM = 1;
    return t;
END;
/

SELECT most_expensive()
FROM dual;

-- Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION get_average_invoiceline
    RETURN NUMBER
IS
    average NUMBER(8);
BEGIN
    SELECT AVG(unitprice)
    INTO average
    FROM invoiceline;
    RETURN average;
END;
/

SELECT get_average_invoiceline()
FROM dual;

-- Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION after_1968
    RETURN SYS_REFCURSOR
IS
    my_cursor SYS_REFCURSOR;
BEGIN
    OPEN my_cursor FOR -- the result set returned by the query is stored in the cursor
    SELECT firstname, lastname, birthdate
    FROM employee
    WHERE birthdate > DATE '1968-12-31';
    
    RETURN my_cursor;   -- this function returns a sys_refcursor
END;
/

-- Using the dual function to invoke our stored function
SELECT after_1968()
FROM dual;

-- 4.1

-- Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE get_employee_names
(my_cursor OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN my_cursor FOR
    SELECT firstname, lastname
    FROM employee;
END;
/

-- 4.2

-- Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE change_info
IS
BEGIN
    UPDATE employee
    SET firstname = 'Bob'
    WHERE lastname = 'Adams';
END;
/

-- Create a stored procedure that returns the managers of an employee.
-- I take this to mean you want a list of employees who manage other employees
CREATE OR REPLACE PROCEDURE get_managers
(my_cursor OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN my_cursor FOR
    SELECT e1.firstname, e1.lastname
    FROM employee e1, employee e2
    WHERE e1.employeeid = e2.reportsto;
END;
/

DECLARE
    my_cursor SYS_REFCURSOR;
    fn EMPLOYEE.FIRSTNAME%TYPE;
    ln EMPLOYEE.LASTNAME%TYPE;
BEGIN
    get_managers(my_cursor);
    
    LOOP
        FETCH my_cursor
        INTO fn, ln;
        
        EXIT WHEN my_cursor%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE('Name: ' || fn || ' ' || ln);
    END LOOP; 
END;
/

-- 4.3

-- Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE get_customer_info
(cust_id IN NUMBER, cust_fn OUT VARCHAR2, cust_ln OUT VARCHAR2, cust_company OUT VARCHAR2)
IS
BEGIN
    SELECT firstname, lastname, company
    INTO cust_fn, cust_ln, cust_company
    FROM customer
    WHERE customerid = cust_id;
END;
/

DECLARE 
    cust_fn CUSTOMER.FIRSTNAME%TYPE;
    cust_ln CUSTOMER.LASTNAME%TYPE;
    cust_company CUSTOMER.COMPANY%TYPE;
BEGIN
    get_customer_info(1, cust_fn, cust_ln, cust_company);
    DBMS_OUTPUT.PUT_LINE('Name: ' || cust_fn || ' ' || cust_ln || ', Company: ' || cust_company);
END;
/

-- 5.0

-- Create a transaction that given a invoiceId will delete that invoice
DECLARE
    inv_id NUMBER;
BEGIN
    SAVEPOINT start_tran;           -- Savepoint for the start of the transaction
    inv_id := 5;
    
    DELETE FROM invoiceline
    WHERE invoiceid = inv_id;
    
    DELETE FROM invoice
    WHERE invoiceid = inv_id;
    
    COMMIT;                         -- If all went well, save the changes
EXCEPTION                           -- If an exception occurs
    WHEN OTHERS THEN
        ROLLBACK TO start_tran;     -- Rollback to the savepoint;
        RAISE;                      -- And raise the exception
END;
/

-- Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE new_customer
IS
BEGIN
    SAVEPOINT start_tran;           -- Same routine as before
    
    INSERT INTO customer VALUES(500, 'fn', 'ln', 'company', 'address', 'city', 'state', 'country', 'zip code', 'phone', 'fax', 'email', 1);
    
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK to start_tran;
        RAISE;
END;
/

-- Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER after_insert_employee
AFTER INSERT ON employee

FOR EACH ROW

BEGIN
    DBMS_OUTPUT.PUT_LINE(:new.firstname);
END;
/

-- Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER after_update_album
AFTER UPDATE ON album
FOR EACH ROW

BEGIN
    DBMS_OUTPUT.PUT_LINE(:new.title);
END;
/

-- Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER after_delete_customer
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Too bad ' || :new.firstname || ' left.');
END;
/

-- Create a before trigger that restricts the deletion of any invoice that is priced over 50 dollars.
CREATE OR REPLACE TRIGGER before_delete_invoice
BEFORE DELETE ON invoice
FOR EACH ROW
BEGIN
    IF :old.total > 50 THEN
        -- if they try to delete a high priced invoice, create an error to stop them
        raise_application_error(20001, 'Cannot delete invoices priced over 50 dollars');
    END IF;
END;
/


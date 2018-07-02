--Revature Associate SQL Workbook
--Oracle 11g
--
--Working with Relational Database Management Systems
--
--Part I – Working with an existing database
--
--Setting up Chinook
--In this section you will begin the process of working with the Chinook database
--Task – Open the Chinook.sql file and execute the scripts within under the master.
--
--
--
--2.0 SQL Queries
--In this section you will be performing various queries against the Oracle Chinook database.
--2.1 SELECT
--Task – Select all records from the Employee table.
SELECT *
FROM EMPLOYEE;

--Task – Select all records from the Employee table where last name is King.
SELECT *
FROM EMPLOYEE
WHERE LASTNAME = 'King';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT *
FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew' 
    AND REPORTSTO IS NULL;

--2.2 ORDER BY
--Task – Select all albums in album table and sort result set in descending order
SELECT *
FROM ALBUM
ORDER BY ALBUMID DESC;

--Task – Select first name from Customer and sort result set in ascending order
SELECT FIRSTNAME
FROM CUSTOMER
ORDER BY FIRSTNAME;     -- Ascending is default ordering

--2.3 INSERT INTO
--Task – Insert two new records into Genre table
SELECT *
FROM GENRE
ORDER BY NAME;

SELECT COUNT(*)
FROM GENRE;

INSERT INTO GENRE VALUES (26, 'Dub Step');
INSERT INTO GENRE VALUES (27, 'Grunge');

--Task – Insert two new records into Employee table
SELECT *
FROM EMPLOYEE;

INSERT INTO EMPLOYEE VALUES (9, 'Edward', 'Henry', 'King', NULL, DATE '1470-11-02', DATE '1491-05-28', '123 Kings Way', 
                            'London', 'Eu', 'England', 'WC2N 5DU', '+1 (555) 364-5263', '+1 (555) 364-5263', 'thekingisgreat@gmail.com');
INSERT INTO EMPLOYEE VALUES (10, 'Richard', 'Charlemagne', 'King', NULL, DATE '1483-05-26', DATE '742-04-02', 
                            '456 Kings Court', 'London', 'Eu', 'England', 'WC2N 5DT', '+1 (546) 447-2005', '+1 (546) 447-2005', 'thekingisbae@gmail.com');

--Task – Insert two new records into Customer table
SELECT *
FROM CUSTOMER;

SELECT COUNT(*)
FROM CUSTOMER;

INSERT INTO CUSTOMER VALUES (60, 'Slade', 'Wilson', 'League of Villans', '345 Evil Way', 'Metropolis', 'NY', 'USA', '45833', 
                            '+1 (455) 7447', '+1 (455) 7447', 'sla_is_bae@gmail.com', 3);
INSERT INTO CUSTOMER VALUES (61, 'Wade', 'Wilson', 'League of Not Villans', '345 Meh Way', 'Metropolis', 'NY', 'USA', '45833', 
                            '+1 (455) 4774', '+1 (455) 4774', 'wade_is_slade@gmail.com', 3);

--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
SELECT *
FROM CUSTOMER
ORDER BY FIRSTNAME;

UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' 
    AND LASTNAME = 'Mitchell';
    
--Task – Update name of artist “Creedence Clearwater Revival” to “CCR”
SELECT *
FROM ARTIST
ORDER BY NAME;

UPDATE ARTIST 
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

--2.5 LIKE
--Task – Select all invoices with a billing address like “T”
SELECT *
FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT *
FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT *
FROM EMPLOYEE
WHERE HIREDATE BETWEEN DATE '2003-05-01' AND DATE '2004-03-01';

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
SELECT *
FROM INVOICELINE
WHERE INVOICEID IN
    (
        SELECT INVOICEID
        FROM INVOICE
        WHERE CUSTOMERID =
            (
                SELECT CUSTOMERID
                FROM CUSTOMER
                WHERE FIRSTNAME = 'Robert'
                    AND LASTNAME = 'Walter'
            )
    );

DELETE
FROM INVOICELINE
WHERE INVOICEID IN
    (
        SELECT INVOICEID
        FROM INVOICE
        WHERE CUSTOMERID =
            (
                SELECT CUSTOMERID
                FROM CUSTOMER
                WHERE FIRSTNAME = 'Robert'
                    AND LASTNAME = 'Walter'
            )
    );

DELETE 
FROM INVOICE
WHERE CUSTOMERID =
    (
        SELECT CUSTOMERID
        FROM CUSTOMER
        WHERE FIRSTNAME = 'Robert'
            AND LASTNAME = 'Walter'
    );

DELETE
FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
-- Test it
SELECT *
FROM CUSTOMER
WHERE FIRSTNAME = 'Robert'
    AND LASTNAME = 'Walter';


/*
    Attempt using to alter the foreign key constraint
*/



--
--
--
--
--3.0 SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
SELECT CURRENT_TIMESTAMP
FROM dual;

CREATE OR REPLACE FUNCTION get_current_time
    RETURN TIMESTAMP WITH TIME ZONE
    AS my_current_time TIMESTAMP WITH TIME ZONE;
BEGIN
    SELECT CURRENT_TIMESTAMP
    INTO my_current_time
    FROM dual;
    
    RETURN my_current_time;
END;
/
-- Test it
DECLARE
    my_current_time TIMESTAMP WITH TIME ZONE;
BEGIN
    my_current_time := get_current_time();
    DBMS_OUTPUT.PUT_LINE('Current time: ' || my_current_time);
END;
/
--Task  create a function that returns the length of a mediatype from the mediatype table
SELECT *
FROM MEDIATYPE;

CREATE OR REPLACE FUNCTION get_media_type_length
    (media_type IN MEDIATYPE.NAME%TYPE)
    RETURN NUMBER
    AS media_type_length NUMBER;
BEGIN
    SELECT LENGTH (media_type)
    INTO media_type_length
    FROM dual;
    
    RETURN media_type_length;
END;
/
-- Test it
DECLARE
    my_media_type_length NUMBER;
    media_type MEDIATYPE.NAME%TYPE;
BEGIN
    media_type := 'AAC audio file';
    my_media_type_length := get_media_type_length(media_type);
    DBMS_OUTPUT.PUT_LINE('Length of "' || media_type || '" is: ' || my_media_type_length);
END;
/

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
SELECT TOTAL
FROM INVOICE;

CREATE OR REPLACE FUNCTION get_avg_invoice_total
    RETURN NUMBER
AS
    avg_total NUMBER;
BEGIN
    SELECT AVG(TOTAL)
    INTO avg_total
    FROM INVOICE;
    
    RETURN avg_total;
END;
/
-- Test it
DECLARE
    avg_total NUMBER;
BEGIN
    avg_total := get_avg_invoice_total();
    DBMS_OUTPUT.PUT_LINE('Average invoice total: ' || avg_total);
END;
/

--Task – Create a function that returns the most expensive track
SELECT UNITPRICE
FROM TRACK
ORDER BY UNITPRICE DESC;

CREATE OR REPLACE FUNCTION get_most_expensive_track
    RETURN SYS_REFCURSOR
    IS expensive_track_cursor SYS_REFCURSOR;
BEGIN
    OPEN expensive_track_cursor FOR
    SELECT NAME, UNITPRICE
    FROM TRACK
    WHERE UNITPRICE = 
        (
            SELECT MAX(UNITPRICE)
            FROM TRACK
        );
        
    RETURN expensive_track_cursor;
END;
/

SELECT get_most_expensive_track()
FROM dual;

DECLARE
    track_name      TRACK.NAME%TYPE;
    unit_price      TRACK.UNITPRICE%TYPE;
    track_cursor    SYS_REFCURSOR;
BEGIN
    track_cursor := get_most_expensive_track();
    
    LOOP
        FETCH track_cursor
        INTO track_name, unit_price;
        
        EXIT WHEN track_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Track: ' || track_name || ', Unit price: $' || unit_price);
    END LOOP;
    CLOSE track_cursor;
END;
/

--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
SELECT AVG(UNITPRICE)
FROM INVOICELINE;

CREATE OR REPLACE FUNCTION get_avg_invoiceline_price
    RETURN NUMBER
    AS avg_invoiceline_price NUMBER;
BEGIN
    SELECT AVG(UNITPRICE)
    INTO avg_invoiceline_price
    FROM INVOICELINE;
    
    RETURN avg_invoiceline_price;
END;
/

DECLARE
    avg_price NUMBER;
BEGIN
    avg_price := get_avg_invoiceline_price();
    DBMS_OUTPUT.PUT_LINE('Avg invoiceline unit price: $' || avg_price);
END;
/

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
    -- Using an explicit cursor
CREATE OR REPLACE FUNCTION born_after_1968
    RETURN SYS_REFCURSOR                                -- Functions can only return one thing, so we must store multiple returns as a single cursor
IS
    my_cursor SYS_REFCURSOR;
BEGIN
    OPEN my_cursor FOR
    SELECT FIRSTNAME, LASTNAME
    FROM EMPLOYEE
    WHERE BIRTHDATE > DATE '1968-12-31';
    
    RETURN my_cursor;
END;
/
-- Using the dual table to invoke our stored function
SELECT born_after_1968()
FROM dual;
--
--
--
--
--
--
--
--
--
--
--
--
--
--
--
--
--
--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE get_employee_names
    (name_cursor OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN name_cursor FOR
    SELECT FIRSTNAME, LASTNAME
    FROM EMPLOYEE;
END;
/

DECLARE
    first_name      EMPLOYEE.FIRSTNAME%TYPE;
    last_name       EMPLOYEE.LASTNAME%TYPE;
    name_cursor     SYS_REFCURSOR;
BEGIN
     get_employee_names(name_cursor);
    
    LOOP
        FETCH name_cursor
        INTO first_name, last_name;
        
        EXIT WHEN name_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Firstname: ' || first_name || ', Lastname: ' || last_name);
    END LOOP;
    CLOSE name_cursor;
END;
/

--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
SELECT *
FROM EMPLOYEE;
-- An update procedure for it they moved
CREATE OR REPLACE PROCEDURE update_employee_address
    (emp_id IN EMPLOYEE.EMPLOYEEID%TYPE,
    new_address IN EMPLOYEE.ADDRESS%TYPE,
    new_city IN EMPLOYEE.CITY%TYPE,
    new_state IN EMPLOYEE.STATE%TYPE,
    new_country IN EMPLOYEE.COUNTRY%TYPE,
    new_postalcode IN EMPLOYEE.POSTALCODE%TYPE)
IS
BEGIN
    UPDATE EMPLOYEE
    SET ADDRESS = new_address,
        CITY = new_city,
        STATE = new_state,
        COUNTRY = new_country,
        POSTALCODE = new_postalcode
    WHERE EMPLOYEEID = emp_id;
END;
/

BEGIN
    update_employee_address(1, '3257 Maple Grove Church Rd', 'Resaca', 'Ga', 'USA', '30735');
END;
/

--Task – Create a stored procedure that returns the managers of an employee.
SELECT EMPLOYEEID, FIRSTNAME, LASTNAME, REPORTSTO
FROM EMPLOYEE;

CREATE OR REPLACE PROCEDURE return_reportsto_cursor
    (reportsto_cursor OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN reportsto_cursor FOR
    SELECT EMPLOYEEID, FIRSTNAME, LASTNAME, REPORTSTO
    FROM EMPLOYEE
    ORDER BY REPORTSTO;
END;
/

DECLARE
    emp_id              EMPLOYEE.EMPLOYEEID%TYPE;
    first_name          EMPLOYEE.FIRSTNAME%TYPE;
    last_name           EMPLOYEE.LASTNAME%TYPE;
    manager             EMPLOYEE.REPORTSTO%TYPE;
    reportsto_cursor    SYS_REFCURSOR;
BEGIN
    return_reportsto_cursor(reportsto_cursor);
    
    LOOP
        FETCH reportsto_cursor
        INTO emp_id, first_name, last_name, manager;
        
        EXIT WHEN reportsto_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Employee: ' || first_name || ' ' || last_name || ' (Emp. Id: ' || emp_id || ') 
                            reports to ' || manager || '.');
    END LOOP;
    CLOSE reportsto_cursor;
END;
/

CREATE OR REPLACE PROCEDURE return_reportsto
    (emp_id IN EMPLOYEE.EMPLOYEEID%TYPE,
    reportsto_cursor OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN reportsto_cursor FOR
    SELECT EMPLOYEEID, FIRSTNAME, LASTNAME, (SELECT EMPLOYEEID
                                                FROM EMPLOYEE
                                                WHERE EMPLOYEEID = (
                                                                        SELECT REPORTSTO
                                                                        FROM EMPLOYEE
                                                                        WHERE EMPLOYEEID = emp_id
                                                                    )),
                                             (SELECT FIRSTNAME
                                                FROM EMPLOYEE
                                                WHERE EMPLOYEEID = (
                                                                        SELECT REPORTSTO
                                                                        FROM EMPLOYEE
                                                                        WHERE EMPLOYEEID = emp_id
                                                                    )),
                                             (SELECT LASTNAME
                                                FROM EMPLOYEE
                                                WHERE EMPLOYEEID = (
                                                                        SELECT REPORTSTO
                                                                        FROM EMPLOYEE
                                                                        WHERE EMPLOYEEID = emp_id
                                                                    ))
                                            
    FROM EMPLOYEE
    WHERE EMPLOYEEID = emp_id;
END;
/

DECLARE
    emp_id                  EMPLOYEE.EMPLOYEEID%TYPE;
    emp_first_name          EMPLOYEE.FIRSTNAME%TYPE;
    emp_last_name           EMPLOYEE.LASTNAME%TYPE;
    manage_id               EMPLOYEE.EMPLOYEEID%TYPE;
    manage_first_name       EMPLOYEE.FIRSTNAME%TYPE;
    manage_last_name        EMPLOYEE.LASTNAME%TYPE;
    reportsto_cursor        SYS_REFCURSOR;
BEGIN
    return_reportsto(5, reportsto_cursor);
    
    FETCH reportsto_cursor
    INTO emp_id, emp_first_name, emp_last_name, manage_id, manage_first_name, manage_last_name;
    
    DBMS_OUTPUT.PUT_LINE('Employee: ' || emp_first_name || ' ' || emp_last_name || ' (Emp. Id: ' || emp_id || ') 
                        Reports to: ' || manage_first_name || ' ' || manage_last_name || ' (Mng. Id: ' || manage_id || ').');

    CLOSE reportsto_cursor;
END;
/

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
SELECT CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY
FROM CUSTOMER;

CREATE OR REPLACE PROCEDURE customer_to_company
    (customer_id IN CUSTOMER.CUSTOMERID%TYPE,
    my_cursor OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN my_cursor FOR
    SELECT CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY
    FROM CUSTOMER
    WHERE CUSTOMERID = customer_id;
END;
/

DECLARE
    customer_id             CUSTOMER.CUSTOMERID%TYPE;
    customer_first_name     CUSTOMER.FIRSTNAME%TYPE;
    customer_last_name      CUSTOMER.LASTNAME%TYPE;
    company_name            CUSTOMER.COMPANY%TYPE;
    my_cursor               SYS_REFCURSOR;
BEGIN
    customer_to_company(5, my_cursor);
    
    FETCH my_cursor
    INTO customer_id, customer_first_name, customer_last_name, company_name;
    
    DBMS_OUTPUT.PUT_LINE('Customer: ' || customer_first_name || ' ' || customer_last_name || ' (Cust. Id: ' || 
                        customer_id || ') Company: ' || company_name || ').');

    CLOSE my_cursor;
END;
/

--
--
--
--
--
--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE delete_invoice
    (invoice_id IN NUMBER)
IS
BEGIN
DELETE
FROM INVOICELINE
WHERE INVOICEID = invoice_id;

DELETE 
FROM INVOICE
WHERE INVOICEID = invoice_id;

COMMIT;
END;
/

BEGIN
    delete_invoice(2);
END;
/

SELECT COUNT(*)
FROM INVOICELINE
WHERE INVOICEID = 2;

SELECT COUNT(*)
FROM INVOICE
WHERE INVOICEID = 2;

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
SELECT *
FROM CUSTOMER;

CREATE OR REPLACE PROCEDURE insert_customer
    (cust_id            IN CUSTOMER.CUSTOMERID%TYPE,
    cust_first_name     IN CUSTOMER.FIRSTNAME%TYPE,
    cust_last_name      IN CUSTOMER.LASTNAME%TYPE,
    cust_company        IN CUSTOMER.COMPANY%TYPE,
    cust_address        IN CUSTOMER.ADDRESS%TYPE,
    cust_city           IN CUSTOMER.CITY%TYPE,
    cust_state          IN CUSTOMER.STATE%TYPE,
    cust_country        IN CUSTOMER.COUNTRY%TYPE,
    cust_postal_code    IN CUSTOMER.POSTALCODE%TYPE,
    cust_phone          IN CUSTOMER.PHONE%TYPE,
    cust_fax            IN CUSTOMER.FAX%TYPE,
    cust_email          IN CUSTOMER.EMAIL%TYPE,
    cust_support_rep_id IN CUSTOMER.SUPPORTREPID%TYPE)
IS
BEGIN
    INSERT INTO CUSTOMER VALUES (cust_id, cust_first_name, cust_last_name, cust_company, cust_address, cust_city, 
                                cust_state, cust_country, cust_postal_code, cust_phone, cust_fax, cust_email, 
                                cust_support_rep_id);
    COMMIT;
END;
/

BEGIN
    insert_customer(62, 'Bill', 'Bilson', 'Bill Co', 'Bills Place', 'Billville', 
                                'Bi', 'United Places of Bill', '8177', '+1 (555) 817-8177', '+1 (555) 817-8177', 'BILL8177@billmail.com', 
                                '7');
END;
/

SELECT *
FROM CUSTOMER
WHERE customerid = 62;

--
--
--
--
--
--
--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--Sequence for testing triggers
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER new_emp_trigger
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('New employee added.');
END;
/

BEGIN
INSERT INTO EMPLOYEE VALUES (26, 'RichardIV', 'CharlemagneIV', 'King', NULL, DATE '1483-05-26', DATE '742-04-02', 
                            '456 Kings Court', 'London', 'Eu', 'England', 'WC2N 5DT', '+1 (546) 447-2005', '+1 (546) 447-2005', 'thekingisbae@gmail.com');
END;
/

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE TRIGGER album_row_inserted
AFTER INSERT ON album
FOR EACH ROW

BEGIN
    DBMS_OUTPUT.PUT_LINE('Row inserted into album.');
END;
/

BEGIN
    INSERT INTO album VALUES (3000, 'The Hand That Feeds', 200);
END;
/

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE TRIGGER customer_delete_trigger
AFTER DELETE ON customer
FOR EACH ROW

BEGIN
    DBMS_OUTPUT.PUT_LINE('Row deleted from customer.');
END;
/

BEGIN
    DELETE
    FROM customer
    WHERE customerid = 62;
END;
/

--6.2 BEFORE
--Task – Create a before trigger that restricts the deletion of any invoice that is priced over 50 dollars.
CREATE TRIGGER invoice_restrict_delete
BEFORE DELETE ON INVOICE
FOR EACH ROW
DECLARE
    no_delete EXCEPTION;
BEGIN
    IF :old.TOTAL > 100
    THEN DBMS_OUTPUT.PUT_LINE('Can''t delete invoice''s over $50.00');
    RAISE no_delete;
    END IF;
    EXCEPTION
        WHEN no_delete
        THEN DBMS_OUTPUT.PUT_LINE('Can''t delete invoice''s over $50.00');
END;
/


--
--
--7.0 JOINS
--In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT INVOICEID, FIRSTNAME, LASTNAME
FROM CUSTOMER
JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

SELECT INVOICEID, FIRSTNAME, LASTNAME
FROM CUSTOMER
JOIN INVOICE
USING (CUSTOMERID);

--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT CUSTOMER.CUSTOMERID, FIRSTNAME, LASTNAME, INVOICEID, TOTAL
FROM CUSTOMER
FULL OUTER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT ARTIST.NAME, TITLE
FROM ALBUM
RIGHT JOIN ARTIST
ON ALBUM.ARTISTID = ARTIST.ARTISTID;

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT *
FROM ALBUM
CROSS JOIN ARTIST
ORDER BY ARTIST.NAME;

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reports to column.
SELECT *
FROM EMPLOYEE E
JOIN EMPLOYEE EM
ON E.REPORTSTO = EM.REPORTSTO;
--

--
--
--
--8.0 Indexes
--In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
--8.1 Indexes
--Task – Create an index on of table of your choice
CREATE INDEX customer_index
ON customer (customerid, firstname, lastname, email);


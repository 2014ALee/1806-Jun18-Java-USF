            --2.1 SELECT--
--select all records from the employee table
SELECT * 
FROM employee;

--select all records from the Employee table where last name is King.
SELECT *
FROM employee
WHERE  lastname = 'King';

--select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT *
FROM employee
WHERE firstname = 'Andrew' AND REPORTSTO is null; --when checking for null use IS do not use '='

        -- 2.2 Order By
        
--Select all albums in album table and sort result set in descending order
SELECT *
FROM album 
ORDER BY albumid desc;

--Select first name from Customer and sort result set in ascending order
SELECT firstname
FROM customer
ORDER BY firstname ASC; --This sorts alphabetically


        --2.3 INSERT INTO--

--Insert two new records into Genre table
INSERT INTO genre VALUES( 26, 'Rap');
INSERT INTO genre VALUES( 27, 'Reggaeton');

--Insert two new records into Employee table
INSERT INTO employee VALUES( 9, 'Doe', 'John', 'IT Staff', null, '02-JAN-90', '02-JAN-12', '983 6TH Ave', 'Edmonton',
                            'AB', 'Canada', 'T9D 0K1', '+1 (780) 345-9274', '+1 (780) 3980-3254', 'john@yahoo.com');
                            
INSERT INTO employee VALUES( 10, 'Doe', 'Jane', 'IT Supervisor', null, '02-JAN-87', '02-JAN-08', '983 6TH Ave', 'Edmonton',
                            'AB', 'Canada', 'T9D 0K1', '+1 (780) 345-5555', '+1 (780) 3980-5555', 'jane@yahoo.com');
                            
--Insert two new records into Customer table
INSERT INTO cutomer VALUES( 9, 'Doe', 'John', 'IT Staff', null, '02-JAN-90', '02-JAN-12', '983 6TH Ave', 'Edmonton',
                            'AB', 'Canada', 'T9D 0K1', '+1 (780) 345-9274', '+1 (780) 3980-3254', 'john@yahoo.com');


            --2.4 UPDATE--

--Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer
SET lastname = 'Walter', firstname = 'Robert'
WHERE firstname = 'Aaron';

--Update name of artist “Creedence Clearwater Revival” to “CCR”
UPDATE artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';


            --2.5 LIKE--
            
--Select all invoices with a billing address like “T”
SELECT billingaddress
FROM invoice
WHERE billingaddress LIKE 'T%'; 


            --2.6 BETWEEEN--
            
--Select all invoices that have a total between 15 and 50
SELECT *
FROM invoice 
WHERE total BETWEEN 15 AND 50;

--Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT *
FROM employee 
WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';


            --2.7 DELETE--
--Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE invoice
DROP CONSTRAINT fk_invoicecustomerid;

ALTER TABLE invoice
ADD CONSTRAINT fk_invoicecustomerid
    FOREIGN KEY (customerid)
    REFERENCES customer (customerid)
    ON DELETE CASCADE;

ALTER TABLE invoiceline
DROP CONSTRAINT fk_invoicelineinvoiceid;

ALTER TABLE invoiceline
ADD CONSTRAINT fk_invoicelineinvoiceid
    FOREIGN KEY (invoiceid)
    REFERENCES invoice (invoiceid)
    ON DELETE CASCADE;

DELETE
FROM customer
WHERE lastname = 'Walter' AND firstname = 'Robert';

            --3.0 SQL Functions---
            
            --3.1 System Defined Fucntions
            
--Create a function that returns the current time
CREATE OR REPLACE FUNCTION get_current_time
    Return TIMESTAMP
AS
    current_t TIMESTAMP;
BEGIN 
    SELECT current_timestamp(2)
    INTO current_t
    FROM dual;
    
    RETURN current_t;   
END;
/

DECLARE
    current_t TIMESTAMP;
BEGIN
    current_t := get_current_time();
    DBMS_OUTPUT.PUT_LINE('The current time is : ' || current_t);
END;
/

--Create a function that returns the length of a mediatype from the mediatype table
SELECT length(name) from (mediatype) WHERE (mediatypeid = 1);

CREATE OR REPLACE FUNCTION get_length
    RETURN NUMBER
AS
    found_length NUMBER;

BEGIN
    SELECT length(name) 
    INTO found_length
    FROM mediatype 
    WHERE mediatypeid = 1;
    
    RETURN found_length;
END;
/

DECLARE
    name_length NUMBER;
BEGIN
    name_length := get_length();
    DBMS_OUTPUT.PUT_LINE('Length of name from mediatype : ' || name_length);
END;
/

            --System Defined Aggregate Functions
            
--Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION get_average_total
    RETURN NUMBER 
AS
    average NUMBER;

BEGIN
    SELECT AVG(total)
    INTO average
    FROM invoice;
    
    RETURN average;
END;
/

DECLARE
    ave NUMBER;
BEGIN
    ave := get_average_total();
    DBMS_OUTPUT.PUT_LINE('Average of total : ' || ave);
END;
/


--Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION get_pricy_track
    RETURN NUMBER 
AS
    price NUMBER;

BEGIN
    SELECT MAX(unitprice)
    INTO price
    FROM track;
    
    RETURN price;
END;
/

DECLARE
    expensive NUMBER;
BEGIN
    expensive := get_pricy_track();
    DBMS_OUTPUT.PUT_LINE('Most expensive track : ' || expensive);
END;
/

            --3.3 User Defined Scalar Functions

--Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION get_average_price
    RETURN NUMBER 
AS
    price NUMBER;

BEGIN
    SELECT AVG(unitprice)
    INTO price
    FROM invoiceline;
    
    RETURN price;
END;
/

DECLARE
    ave_p NUMBER;
BEGIN
    ave_p := get_average_price();
    DBMS_OUTPUT.PUT_LINE('Average price of invoiceline : ' || ave_p);
END;
/


            --3.4 User Defined Table Valued Functions
            
--Create a function that returns all employees who are born after 1968.
--done in class, do later

            --4.0 Stored Procedures
            
--In this section you will be creating and executing stored procedures. You will be creating various types
--of stored procedures that take input and output parameters.


            --4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE get_lastandfirstname(
    my_cursor OUT SYS_REFCURSOR)
IS -- even if there is no variable the key word 'is' should still be included
BEGIN
    OPEN my_cursor FOR 
    SELECT lastname, firstname
    FROM employee;
END;
/

DECLARE
    customer_firstname       EMPLOYEE.FIRSTNAME%TYPE;
    customer_lastname     EMPLOYEE.LASTNAME%TYPE; 
    my_cursor       SYS_REFCURSOR;
BEGIN
    get_lastandfirstname(my_cursor);
    
    LOOP
        FETCH my_cursor                 --fetch the next record stored in my_cursor
        INTO customer_firstname, customer_lastname;    --put the values in my_cursor into these variables
        
        EXIT WHEN my_cursor%NOTFOUND;   --exit this loop when there are no more records in my_cursor
        DBMS_OUTPUT.PUT_LINE('Cusomer firstname: ' || customer_firstname || ', Customer lastname : ' || customer_lastname);   -- output
        
        END LOOP;
        CLOSE my_cursor;
    
END;
/

                --Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE update_employee(
        employeeid_position IN NUMBER,
        new_employee_id IN EMPLOYEE.EMPLOYEEID%TYPE,
        new_title IN EMPLOYEE.TITLE%TYPE,
        new_phone IN EMPLOYEE.PHONE%TYPE,
        new_email IN EMPLOYEE.EMAIL%TYPE)
IS
BEGIN
    UPDATE employee
    SET employeeid = new_employee_id, title = new_title, phone = new_phone, email = new_email
    WHERE employeeid = employeeid_position;
END;
/

BEGIN 
    update_employee(10, 200, 'Janitor', null, 'newemail@gmail.com');
END;
/
SELECT *
FROM employee;

--Task – Create a stored procedure that returns the managers of an employee.
--CREATE OR REPLACE PROCEDURE return_manager(
--        employee_title IN EMPLOYEE.TITLE%TYPE,
--        manager_id  OUT EMPLOYEE.EMPLOYEEID%TYPE)
--IS
--BEGIN
--       SELECT employeeid
--       INTO manager_id
--       FROM employee
--       WHERE  title LIKE '%MANAGER%';
--END;
--/

            --6.0 Triggers 
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.


            --6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER employee_trigger
AFTER INSERT ON employee
FOR EACH ROW

BEGIN
    DBMS_OUTPUT.PUT_LINE('A new record was inserted into employee tabe');
END;
/

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER album_trigger
AFTER UPDATE ON album
FOR EACH ROW

BEGIN
    DBMS_OUTPUT.PUT_LINE('A record has been updated in album');
END;
/

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER customer_trigger
AFTER DELETE ON customer
FOR EACH ROW

BEGIN
    DBMS_OUTPUT.PUT_LINE('A customer has been deleted');
END;
/

                --6.2 BEFORE
--Task – Create a before trigger that restricts the deletion of any invoice that is priced over 50 dollars.
CREATE OR REPLACE TRIGGER invoice_trigger
BEFORE DELETE ON invoice             
FOR EACH ROW                        

BEGIN
    IF :old.total > 50 THEN
        raise_application_error(-20001,'Totals above 50 cannot be deleted');
    END IF;
END;
/


                --7.0 JOINS
--In this section you will be working with combining various tables through the use of joins.
--You will work with outer, inner, right, left, cross, and self joins.

                --7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT lastname, firstname, invoiceid
FROM customer
INNER JOIN invoice
ON customer.customerid = invoiceid;

                --7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT customer.customerid, firstname, lastname, invoiceid, total
FROM customer
FULL OUTER JOIN invoice
ON customer.customerid = invoice.invoiceid;
--WHERE customer.customerid is null or invoice.invoiceid is null;

                --7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT name, title
FROM album al
RIGHT JOIN artist ar
ON  al.artistid = ar.artistid;

                --7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT *
FROM album
CROSS JOIN artist
ORDER BY name ASC;

                --7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reports to column.
SELECT A.reportsto
FROM employee A, employee B
WHERE A.reportsto = B.reportsto;

                --8.0 Indexes
--In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.

                --8.1 Indexes
--Task – Create an index on table of your choice
CREATE INDEX customer_index ON customer (customerid, firstname, lastname, company);


    
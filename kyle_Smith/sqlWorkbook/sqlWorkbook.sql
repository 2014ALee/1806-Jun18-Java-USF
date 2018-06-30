-- 2.1 SELECT
-- Task – Select all records from the Employee table.
SELECT * 
FROM employee;

-- Task – Select all records from the Employee table where last name is King.
SELECT *
FROM employee e
WHERE e.lastname = 'King';

-- Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM employee e
WHERE (e.firstname = 'Andrew') 
AND (e.reportsto is NULL);


--2.2 ORDER BY
-- Task – Select all albums in album table and sort result set in descending order
SELECT * FROM ALBUM
ORDER BY TITLE DESC;

-- Task – Select first name from Customer and sort result set in ascending order
SELECT c.firstname FROM customer c
ORDER BY c.firstname ASC;

-- 2.3 INSERT INTO
--Task – Insert two new records into Genre table
INSERT INTO Genre (GenreId, Name) VALUES (26, 'Death Metal');
INSERT INTO Genre (GenreId, Name) VALUES (27, 'Trance');

--Task – Insert two new records into Employee table
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (9, 'bill', 'Andrew', 'General Manager', TO_DATE('1962-2-18 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2002-8-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), '11120 Jasper Ave NW', 'Edmonton', 'AB', 'Canada', 'T5K 2N1', '+1 (780) 428-9482', '+1 (780) 428-3457', 'andrew@chinookcorp.com');
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (10, 'nye', 'Andrew', 'General Manager', TO_DATE('1962-2-18 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2002-8-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), '11120 Jasper Ave NW', 'Edmonton', 'AB', 'Canada', 'T5K 2N1', '+1 (780) 428-9482', '+1 (780) 428-3457', 'andrew@chinookcorp.com');

--Task – Insert two new records into Customer table
INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) VALUES (60, 'bill', 'Gonçalves', 'Embraer - Empresa Brasileira de Aeronáutica S.A.', 'Av. Brigadeiro Faria Lima, 2170', 'São José dos Campos', 'SP', 'Brazil', '12227-000', '+55 (12) 3923-5555', '+55 (12) 3923-5566', 'luisg@embraer.com.br', 3);
INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) VALUES (61, 'nar', 'Gonçalves', 'Embraer - Empresa Brasileira de Aeronáutica S.A.', 'Av. Brigadeiro Faria Lima, 2170', 'São José dos Campos', 'SP', 'Brazil', '12227-000', '+55 (12) 3923-5555', '+55 (12) 3923-5566', 'luisg@embraer.com.br', 3);

-- 2.4 UPDATE
-- Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer c
SET c.firstname = 'Robert', c.lastname = 'Walter'
WHERE c.firstname = 'Aaron'
AND c.lastname = 'Mitchell';

-- Task – Update name of artist “Creedence Clearwater Revival” to “CCR”
UPDATE artist a
SET a.name = 'CCR'
WHERE a.name = 'Creedence Clearwater Revival';



--2.5 LIKE
--Task – Select all invoices with a billing address like “T”
SELECT * FROM invoice
WHERE BILLINGADDRESS LIKE 'T%';



--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT *
FROM invoice
WHERE total BETWEEN 15 AND 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee e
WHERE hiredate BETWEEN '01-Jun-03' AND '01-Mar-04';


--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
DELETE FROM invoiceline inv WHERE inv.invoiceid in 
    (
        SELECT invoiceid FROM invoice i
        WHERE i.customerid = (
            SELECT c.customerid from customer c
            WHERE c.firstname = 'Robert' AND
              c.lastname  = 'Walter'
        )
    );
DELETE FROM invoice i
    WHERE i.customerid = (
        SELECT c.customerid from customer c
        WHERE c.firstname = 'Robert' AND
          c.lastname  = 'Walter'
          );
DELETE FROM customer c
WHERE c.firstname = 'Robert' AND
          c.lastname  = 'Walter';


--3.0 SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION currentDate
RETURN timestamp as theDate timestamp;
BEGIN select current_timestamp into theDate from dual;
    return theDate;
END;
/ 



--Task – create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION lengthMediatype
RETURN NUMBER 
AS theLength NUMBER;
BEGIN
    SELECT MAX(LENGTH(me.name)) INTO theLength
    FROM mediatype me;
    RETURN theLength;
END;
/ 
DECLARE
    len number;
BEGIN 
    len:= lengthMediatype;
DBMS_OUTPUT.PUT_LINE('work' || len);
END;

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION avgTotal
RETURN NUMBER AS theAvg NUMBER;
BEGIN select AVG(total) into theAvg from invoice;
    return theAvg;
END;
/

--Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION expTrack
RETURN varchar2 AS tracks varchar2(100);
BEGIN SELECT name into tracks  FROM track
    WHERE unitprice = 
    (select MAX(unitprice) from track
    where
    ROWNUM = 1);
    return tracks;
END;
/


--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION avgPriceFun
RETURN NUMBER AS avgPrice NUMBER;
BEGIN select AVG(unitprice) into avgPrice from invoiceline;
    return avgPrice;
END;
/


--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
create or replace FUNCTION after_1968
    RETURN SYS_REFCURSOR
IS
    my_cursor SYS_REFCURSOR;
BEGIN
    OPEN my_cursor FOR  -- The result set returned by the query below is stored in our declared cursor
    SELECT firstname, lastname, birthdate
    FROM employee
    WHERE birthdate > DATE '1968-12-31';
    --stored function logic
    RETURN my_cursor;  --This funciton returns a sys_refcursor, so return our declared cursor
END after_1968;


--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of 
--all the employees.
CREATE OR REPLACE PROCEDURE getEmployee(
    my_cursor OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN my_cursor FOR
    SELECT firstname, lastname
    FROM employee;
    RETURN my_cursor;
END;
/


--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE updateEmployee(newFirstName EMPLOYEE.FIRSTNAME%TYPE)
IS
BEGIN
    update employee
    SET firstname = newFirstName
    where employeeid = 1;
    commit;
END;
/


--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE getManagers(
    my_cursor OUT SYS_REFCURSOR, thisEmp number)
IS
BEGIN
    OPEN my_cursor FOR
    SELECT *
    FROM employee
    WHERE employeeid = (
        SELECT reportsto
        FROM employee
        WHERE employeeid = thisEmp
    );
    RETURN my_cursor;
END;
/


--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE getInfo(
    my_cursor OUT SYS_REFCURSOR, thisCust in number)
IS
BEGIN
    OPEN my_cursor FOR
    SELECT firstname, company
    FROM customer
    WHERE customerid = thisCust
    ORDER BY firstname;
END;
/


--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).

BEGIN
    DELETE FROM invoiceline invl
        WHERE invl.invoiceid = (
            SELECT MIN(invoiceid) 
            FROM invoice
        );

    DELETE FROM invoice i
        WHERE i.invoiceid = (
            SELECT MIN(invoiceid) 
            FROM invoice
        )
        AND rownum = 1;
    commit;
END;
/


    
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE newCustomer(newCustomer customer.FIRSTNAME%TYPE)
IS
BEGIN
    INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) VALUES (8888, newCustomer, 'Gonçalves', 'Embraer - Empresa Brasileira de Aeronáutica S.A.', 'Av. Brigadeiro Faria Lima, 2170', 'São José dos Campos', 'SP', 'Brazil', '12227-000', '+55 (12) 3923-5555', '+55 (12) 3923-5566', 'luisg@embraer.com.br', 3);
    commit;
END;
/


--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.

CREATE OR REPLACE trigger employee_after_insert_trigger
after INSERT ON employee        
FOR each row                   

--DECLARE
    --v_firstname varchar2(100);
BEGIN
   -- Find username of person performing UPDATE into table
       --SELECT :new.firstname INTO v_firstname
       --FROM dual;
    --v_firstname = :new.firstname
    --DBMS_OUTPUT.GET_LINE(:buffer, :status); 
    DBMS_OUTPUT.PUT_LINE('I got here:'||:new.firstname||' is the new value'); 
END;
/

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER employee_after_update_trigger
AFTER UPDATE ON album
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('I got here:'||:new.title||' is the new update'); 
END;
/

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER customer_after_delete_trigger
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('I got here:'||:old.firstname||' this value deleted'); 
END;
/



--6.2 BEFORE
--Task – Create a before trigger that restricts the deletion of any invoice that is priced over 50 dollars.
CREATE OR REPLACE TRIGGER invoice_before_delete_trigger
BEFORE DELETE ON invoice
FOR EACH ROW
BEGIN
    if(:old.total > 50)
    then
        raise_application_error(-20001,'Records can not be deleted');
    end if;
END;
/


--7.0 JOINS
--In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT firstname,lastname, invoiceid
FROM customer c
INNER JOIN invoice i ON c.customerid = i.customerid;


--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT c.customerid, firstname, lastname, invoiceid, total
FROM customer c
FULL OUTER JOIN invoice i ON c.customerid = i.customerid;


--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT art.name, al.title
FROM artist art
right JOIN album al ON art.artistid = al.artistid;


--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT *
FROM artist
CROSS JOIN album
order by artist.name;


--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reports to column.
select *
from employee emp1, employee emp2
where emp1.reportsto = emp2.employeeid;


--8.0 Indexes
--In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
--8.1 Indexes
--Task – Create an index on of table of your choice
CREATE INDEX emp_index ON employee (employeeid, firstname, lastname);

SELECT employeeid, firstname, lastname
FROM employee;

CREATE SEQUENCE employee_seq
minvalue 1
maxvalue 99999999
increment by 1
START WITH 11;

CREATE OR REPLACE trigger employee_trigger
before INSERT ON employee        
FOR each row                   

BEGIN
    SELECT employee_seq.NEXTVAL      
    into :new.employeeid          
    FROM dual;                  
END;
/





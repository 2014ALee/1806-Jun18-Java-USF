
--Found on stack overflow to print to console 
set serveroutput on format wrapped;
begin
    DBMS_OUTPUT.put_line('text to print');
end;

--2.1 SELECT
--Task – Select all records from the Employee table. 
SELECT * FROM EMPLOYEE;

--Task – Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE
WHERE LASTNAME = 'King';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew'
AND REPORTSTO IS NULL;

--2.2 ORDER BY

--Task – Select all albums in album table and sort result set in descending order
SELECT * FROM album
ORDER BY ALBUMID;

--Task – Select first name from Customer and sort result set in ascending order
SELECT FIRSTNAME FROM Customer
ORDER BY FIRSTNAME;

--2.3 INSERT INTO

--Task – Insert two new records into Genre table
INSERT INTO Genre(GENREID, NAME)
VALUES (26, 'METAL');

INSERT INTO Genre(GENREID, NAME)
VALUES(27,'DEATH METAL');

--Task – Insert two new records into Employee table
INSERT INTO Employee(EmployeeID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES(9, 'Li', 'Andrew', 'Software Engineer', 6, '12-JUL-93', '23-JUN-17', '123 Nowhere Avenue', 'Tampa', 'Fl', 'United States', '13423', '+1 (234) 225-1235', '+1 (623) 666-5920', 'andrewLi@gmail.com');

INSERT INTO Employee(EmployeeID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES(10, 'Lee', 'Andrew', 'Software Engineer', 6, '12-JUL-93', '23-JUN-17', '123 Nowhere Avenue', 'Tampa', 'Fl', 'United States', '13423', '+1 (234) 225-1235', '+1 (623) 666-5920', 'andrewLi@gmail.com');

--Task – Insert two new records into Customer table
INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId)
VALUES (100, 'Andrew', 'Gonçalves', 'Embraer - Empresa Brasileira de Aeronáutica S.A.', 'Av. Brigadeiro Faria Lima, 2170', 'São José dos Campos', 'SP', 'Brazil', '12227-000', '+55 (12) 3923-5555', '+55 (12) 3923-5566', 'luisg@embraer.com.br', 3);

INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId)
VALUES (101, 'Joe', 'Gonçalves', 'Embraer - Empresa Brasileira de Aeronáutica S.A.', 'Av. Brigadeiro Faria Lima, 2170', 'São José dos Campos', 'SP', 'Brazil', '12227-000', '+55 (12) 3923-5555', '+55 (12) 3923-5566', 'luisg@embraer.com.br', 3);


--2.4 UPDATE

--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE Customer
SET FirstName = 'Robert', LastName = 'Walter'
WHERE FirstName = 'Aaron' AND LastName = 'Mitchell';

--Task – Update name of artist “Creedence Clearwater Revival” to “CCR”
UPDATE Artist
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';


--2.5 LIKE
--Task – Select all invoices with a billing address like “T”
SELECT * FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T';


--2.6 BETWEEN

--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE
WHERE HIREDATE BETWEEN '1-JUN-03' AND '1-MAR-04';


--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).

SELECT * FROM CUSTOMER;


--First we delete from the invoice line table because it's referenced to by the invoice table, which is referenceed to by customers
DELETE FROM INVOICELINE
WHERE INVOICEID IN (

SELECT INVOICEID FROM INVOICE i
WHERE i.CUSTOMERID = (

SELECT CUSTOMERID FROM CUSTOMER j
WHERE j.FIRSTNAME = 'Robert'
AND j.LASTNAME = 'Walter'
    )
);

--Now we delete from invoice where our customer is named Robert Walter
DELETE FROM INVOICE
WHERE CUSTOMERID = (

SELECT CUSTOMERID FROM CUSTOMER j
WHERE j.FIRSTNAME = 'Robert'
AND j.LASTNAME = 'Walter'
    );

--Finally, we delete our customers now that their records aren't tied to records on any other tables
DELETE FROM CUSTOMER 
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

--3.1 System Defined Functions
--Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION convertDate

    RETURN VARCHAR2   
AS
    convertedDate VARCHAR2(12);
    
BEGIN
    SELECT TO_CHAR(CURRENT_DATE,'DD-MON-YYYY HH:MI:SS') 
    INTO convertedDate FROM dual;
    RETURN convertedDate;
 END;   
        

--Task – create a function that returns the length of a mediatype from the mediatype table        
CREATE OR REPLACE FUNCTION mediaTypeLength

    RETURN NUMBER   
AS
    mediaLength NUMBER;

BEGIN    

SELECT MAX(LENGTH(NAME))
INTO mediaLength
FROM MEDIATYPE;

return mediaLength;
END;        
        
--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
  CREATE OR REPLACE FUNCTION averageInvoiceTotal      
        RETURN NUMBER
    AS
        average NUMBER;
        
    BEGIN   
    SELECT AVG(TOTAL) 
    INTO average FROM INVOICE;

    RETURN average;
    END;
 
-- Task – Create a function that returns the most expensive track
    CREATE OR REPLACE FUNCTION getMostExpensiveTrack
        RETURN VARCHAR2
    AS
        mostExpensive VARCHAR2(50);
        
    BEGIN
    SELECT NAME
    INTO mostExpensive    
    FROM TRACK
    
    WHERE UNITPRICE =
    
    (SELECT MAX(UNITPRICE)
    FROM TRACK);
    
    RETURN mostExpensive;    
    END;
     
--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
 CREATE OR REPLACE FUNCTION getAvgPriceOfInvoices
        RETURN NUMBER
    AS
        averagePrice NUMBER;
        
    BEGIN   
    SELECT AVG(TOTAL) 
    INTO averagePrice FROM INVOICE;

    RETURN averagePrice;
    END;
          
--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
      
CREATE OR REPLACE FUNCTION getEmployees1968
RETURN SYS_REFCURSOR
AS myCursor SYS_REFCURSOR;
    
BEGIN   
OPEN myCursor FOR
SELECT *
FROM EMPLOYEE
WHERE BIRTHDATE > '1-JAN-68';

RETURN myCursor;
END;

--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE firstAndLastName
IS

myCursor SYS_REFCURSOR;

BEGIN
OPEN myCursor FOR
SELECT FIRSTNAME, LASTNAME
FROM EMPLOYEE;

END;

--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE changeInfo(chosenID IN NUMBER, newNumber IN VARCHAR2, newEmail IN VARCHAR2)
IS

BEGIN

UPDATE EMPLOYEE
SET PHONE = newNumber, EMAIL = newEmail
WHERE EMPLOYEEID = chosenID;

END;


--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE returnManagers(chosenID IN NUMBER, myCursor OUT SYS_REFCURSOR)

IS
BEGIN

OPEN myCursor FOR
SELECT FIRSTNAME, LASTNAME
FROM EMPLOYEE
WHERE EMPLOYEEID=
(
SELECT REPORTSTO
FROM EMPLOYEE
WHERE employeeid=chosenID
);

END;

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE nameAndCompany(inputID IN NUMBER, myCursor OUT SYS_REFCURSOR)

IS
BEGIN
OPEN myCursor FOR
SELECT FIRSTNAME, LASTNAME, COMPANY
FROM CUSTOMER
WHERE CUSTOMERID = inputID;
END;

--5.0 Transactions
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE deleteInvoice(invoice_id NUMBER IN)
IS
BEGIN

ALTER TABLE INVOICE
DROP CONSTRAINT FK_INVOICECUSTOMERID; 

ALTER TABLE INVOICE
ADD CONSTRAINT FK_INVOICECUSTOMERID
FOREIGN KEY (CUSTOMERID)
REFERENCES CUSTOMER(CUSTOMERID)
ON DELETE CASCADE;

DELETE
FROM INVOICE
WHERE INVOICEID = 1;

END;

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE insertCustomerRecord
IS
BEGIN
INSERT INTO CUSTOMER(CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES (100, 'Bjørn', 'Hansen', 'Ullevålsveien 14', 'Oslo','ETC','ETC', 'Norway', '0171', '+47 22 44 22 22', 'bjorn.hansen@yahoo.no','bjorn.hansen@yahoo.no', 100);
END;


 --Create an after insert trigger on the employee table fired after a new record is inserted into the table.
 CREATE OR REPLACE TRIGGER afterInsert
 AFTER INSERT ON EMPLOYEE FOR EACH ROW
 DECLARE
 BEGIN
 DBMS_OUTPUT.put_line('done inserting');
 END;
 
 
-- Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER afterInsert
 BEFORE INSERT ON EMPLOYEE FOR EACH ROW
 DECLARE
 BEGIN
 DBMS_OUTPUT.put_line('DONE INSERTING');
 END;
 
 
 --Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
 CREATE OR REPLACE TRIGGER afterDelete
 AFTER DELETE ON EMPLOYEE FOR EACH ROW
 DECLARE
 BEGIN
 DBMS_OUTPUT.put_line('DONE DELETING');
 END;


--6.2 BEFORE
--Task – Create a before trigger that restricts the deletion of any invoice that is priced over 50 dollars.
CREATE OR REPLACE TRIGGER beforeDeletion
BEFORE DELETE ON INVOICE FOR EACH ROW
DECLARE
BEGIN
IF old.TOTAL > 50
THEN
raise_application_error(-20001,'Cannot delete the given record from EMPLOYEE');
END IF;
END;

--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT  
CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID
FROM INVOICE
INNER JOIN CUSTOMER ON INVOICE.CUSTOMERID = CUSTOMER.CUSTOMERID; 


--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT 
CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID,INVOICE.TOTAL
FROM CUSTOMER
FULL OUTER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ARTIST
RIGHT JOIN ALBUM
ON ARTIST.ARTISTID = ALBUM.ARTISTID;

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM ALBUM
CROSS JOIN ARTIST
ORDER BY ARTIST.NAME ASC; 

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reports to column.
 SELECT A.LASTNAME "EMPLOYEE", B.LASTNAME "MANAGER"
 FROM EMPLOYEE A JOIN EMPLOYEE B
 ON (A.EMPLOYEEID = B.REPORTSTO);
 
--8.1 Indexes
--Task – Create an index on of table of your choice
CREATE INDEX EMPLOYEENAME
ON EMPLOYEE (FIRSTNAME,LASTNAME);

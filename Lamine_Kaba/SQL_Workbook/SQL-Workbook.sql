--2.1 SELECT
--In this section you will be performing various queries against the Oracle Chinook database.
SELECT *FROM employee;
--Select all records from the Employee table where last name is King.
SELECT *FROM employee 
WHERE lastname = 'King';
--Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT *FROM employee
WHERE firstname = 'Andrew' AND reportsto is NULL;

--2.2 ORDER BY
--Select all albums in album table and sort result set in descending order
SELECT *FROM album
ORDER BY albumId DESC;
--Select first name from Customer and sort result set in ascending order
SELECT *FROM customer
ORDER BY customerid ASC;

--2.3 INSERT INTO
--Insert two new records into Genre table
INSERT INTO genre (genreId, name) VALUES(27, 'Kaba');
--Insert two new records into Employee table
INSERT INTO employee (employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, address, city, state, country, postalcode, phone, fax, email) 
VALUES(10, 'Quevedo', 'Norma', 'Software Engineer', '', '30-Nov-76', '18-Jun-2018', '16251 Lithium Ave N','Ramsey', 'MN', 'USA', '55303', '612-352-0000', '612-351-0000', 'email@email.com' );
--Task – Insert two new records into Customer table
INSERT INTO customer (customerId, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid) 
VALUES(61, 'Lamine', 'Kaba', 'Revature', '16251 Lithium Ave N','Ramsey', 'MN', 'USA', '55303', '612-352-0000', '612-351-0000', 'email@email.com', 4 );

--2.4 UPDATE
--Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer SET firstname ='Aaron', lastname = 'Mitchell'
WHERE customerid = 32;
--Update name of artist “Creedence Clearwater Revival” to “CCR”
UPDATE artist SET name ='CCR'
WHERE artistid = 76;

--2.5 LIKE
--Select all invoices with a billing address like “T”
SELECT *FROM invoice WHERE billingaddress LIKE '%T%';

--2.6 BETWEEN
--Select all invoices that have a total between 15 and 50
SELECT *FROM invoice 
WHERE total BETWEEN 15 AND 50;
--Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT *FROM employee
WHERE hiredate BETWEEN date '2003-06-01' AND date '2004-03-01';
/*
SELECT *FROM employee
WHERE hiredate > date '2003-06-01' AND  hiredate < date '2004-03-01';
*/

--2.7 DELETE
--Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
--Drop the constraint on foreign key, then add foreign with on delete set Null
ALTER TABLE customer
    DROP CONSTRAINT FK_CUSTOMERSUPPORTREPID;
ALTER TABLE Customer 
    ADD CONSTRAINT FK_CUSTOMERSUPPORTREPID FOREIGN KEY (SUPPORTREPID)
    REFERENCES CHINOOK.EMPLOYEE ("EMPLOYEEID") On Delete SET NULL;
--Now let delete Robert walter
DELETE FROM customer
WHERE firstname = 'Robert' AND lastname='Walter';

--3.0 SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
SELECT UPPER('hello world') FROM dual;
SELECT lastname FROM employee WHERE employeeid = 1 initcap(lastname);
SELECT concat(concat(firstname, '   '), lastname) FROM employee;
SELECT UPPER(lastname) AS "Last Name" FROM employee;
SELECT SUBSTR(address,0,10) FROM employee;
SELECT INITCAP('the soap') FROM dual;
SELECT COUNT(*) AS "Row COUNT" FROM employee;
CREATE OR replace FUNCTION addTowNum(num1, num2,)
RETURN NUMBER 
AS 
num3 NUMBER, 

BEGIN 
    num3 = num1 +num2;
   SELECT upper('the num1 + num2 is: ') FROM dual;
   RETURN num3;
end;
/
--3.1 System Defined Functions
--Create a function that returns the current time.

CREATE  OR REPLACE FUNCTION  showDate
RETURN TIMESTAMP;
IS 
  myDate TIMESTAMP;
begin
  SELECT SYSDATE INTO myDate FROM dual;
  return myDate;
end;
/
declare timeNow TIMESTAMP;
BEGIN 
    timeNow:=showDate();
    DBMS_OUTPUT.PUT_LINE('The time is:', timeNow);
END;
/







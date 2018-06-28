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

/* Task – Select all albums in album table and sort result set in descending order*/
SELECT title
FROM Album
ORDER BY title DESC ;

/* Task – Select first name from Customer and sort result set in ascending orde*/
SELECT firstname
FROM customer
ORDER BY firstname ASC ;

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

/* Task – Select all invoices with a billing address like “T”*/
SELECT *
FROM invoice
WHERE billingaddress LIKE 'T%';

/*Task – Select all invoices that have a total between 15 and 50*/
SELECT *
FROM invoice
WHERE total > 15 AND total < 50;

/*Task – Select all employees hired between 1st of June 2003 and 1st of March 2004*/
SELECT *
FROM employee
WHERE hiredate > DATE '2003-06-01' AND hiredate < DATE '2004-03-01';

/*Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them)*/


SELECT *
FROM customer;

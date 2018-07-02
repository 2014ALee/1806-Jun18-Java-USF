-- 2.1 SELECT statements
-- 2.1.1 Task - Selecting all records from the Employee Table.
SELECT *
	FROM employee;
-- 2.1.2 Task - Selecting all records from the Employee table where last name is King.
SELECT *
	FROM employee 
	WHERE lastname='King';
-- 2.1.3 Task - Selecting all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT *
	FROM employee
	WHERE (firstname='Andrew' AND reportsto IS NULL);

-- 2.2 ORDER BY
-- 2.2.1 Sorting the results from the album table in descending order.
SELECT *
	FROM album
	ORDER BY albumid DESC;
-- 2.2.2 Selecting first name from Customer and sorting result set in ascending order
SELECT firstname
	FROM customer
	ORDER BY firstname ASC;

-- 2.3 INSERT INTO
-- 2.3.1 Inserting two new records into Genre table
INSERT INTO genre (genreid, name)
	VALUES (26, 'Tech');
INSERT INTO genre (genreid, name)
	VALUES (27, 'Free style');
-- 2.3.2 Inserting two new records into the Employee Table
INSERT INTO employee (employeeid, lastname,
	firstname, title, reportsto, birthdate,
	hiredate, address, city, state, country,
	postalcode, phone, fax, email) 
	VALUES (9, 'Li', 'Andrew', 'IT Staff', 6,
		'24-JUN-94', '7-SEP-18', '360 Kincardine Way',
		'Alpharetta', 'GA', 'United States', '30022',
		'+1 (770) 866-1429', '+1 (770) 866-1440',
		'andrewli.gatech@gmail.com');
INSERT INTO employee (employeeid, lastname,
	firstname, title, reportsto, birthdate,
	hiredate, address, city, state, country,
	postalcode, phone, fax, email)
	VALUES (10, 'Steyaert', 'Tom', 'IT Staff', 6, '6-JUL-95',
		'7-SEP-18', '7899 Hillside Ave', 'New York',
		'NY', 'United States', '10025', '+1 (484) 447-1963',
		'+1 (484) 447-1980', 'tomssteyaert@gmail.com');
-- 2.3.3 Inserting two new records into the Customer table
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, 
	LASTNAME, COMPANY, ADDRESS, CITY, STATE, 
	COUNTRY, POSTALCODE, PHONE, FAX, EMAIL,
	SUPPORTREPID)
	VALUES (60, 'John', 'Doe', 'Microsoft',
		'North Hickory Drive', 'San Francisco',
		'California', 'United States', '94112',
		'+1 (214) 214-2921', '+1 (214) 214-2940',
		'johndoe12@yahoo.com', 5);
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, 
	LASTNAME, COMPANY, ADDRESS, CITY, STATE, 
	COUNTRY, POSTALCODE, PHONE, FAX, EMAIL,
	SUPPORTREPID)
	VALUES (61, 'Jane', 'Doe', 'Google', 'North Hickory Drive',
		'San Francisco', 'California', 'United States', '94112',
		'+1 (214) 160-2103', '+1 (214) 160-2120',
		'janedoe790212@yahoo.com', 5);

-- 2.4 UPDATE
-- 2.4.1 Updating Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER 
	SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
	WHERE (FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell');
-- 2.4.2 Updating name of artist "Creedence Clearwater Revival" to "CCR"
UPDATE ARTIST
	SET NAME = 'CCR'
	WHERE NAME = 'Creedence Clearwater Revival');

-- 2.5 LIKE
SELECT *
	FROM INVOICE
	WHERE BILLINGADDRESS
	LIKE '%T%';

-- 2.6 BETWEEN
-- 2.6.1 Selecting invoices that have a total between 15 and 50
SELECT *
	FROM INVOICE
	WHERE TOTAL
	BETWEEN 15
	AND 50;
-- 2.6.2 Selecting employees hired between 1st of June 2003 and 1st of March 2004
SELECT *
	FROM EMPLOYEE
	WHERE HIREDATE
	BETWEEN DATE'2003-06-01' 
	AND DATE'2004-03-01';

-- 2.7 DELETE
DELETE FROM INVOICELINE
    WHERE INVOICEID
    IN (SELECT INVOICEID 
        FROM INVOICE
        WHERE CUSTOMERID
        IN (SELECT CUSTOMERID
            FROM CUSTOMER
            WHERE FIRSTNAME='Robert'
            AND LASTNAME='Walter'));
DELETE FROM INVOICE
    WHERE CUSTOMERID
    IN (SELECT CUSTOMERID
        FROM CUSTOMER
        WHERE FIRSTNAME='Robert'
        AND LASTNAME='Walter');
DELETE FROM CUSTOMER
    WHERE FIRSTNAME='Robert'
    AND LASTNAME='Walter';



-- 3.0 Functions

-- 3.1 System Defined Functions
-- 3.1.1 Return the current time
create or replace FUNCTION GET_CURRENT_TIME
    RETURN VARCHAR2
AS
    current_time TIMESTAMP;
BEGIN
    RETURN REPLACE(SUBSTR(CURRENT_TIMESTAMP(), 10, 9), '.', ':');
END;
/
-- 3.1.2 Return the length of a media type.
create or replace FUNCTION GET_MEDIATYPE_LENGTH
    RETURN NUMBER
AS
    mtlength NUMBER;
BEGIN
    SELECT MAX(LENGTH(NAME))
    INTO mtlength
    FROM MEDIATYPE;
    return mtlength;
END;
/

-- 3.2 System Defined Aggregate Functions
-- 3.2.1 Return the average of all invoices
create or replace FUNCTION GET_AVG_INVOICE
    RETURN NUMBER
AS
    avg_invoice NUMBER;
BEGIN
    SELECT AVG(TOTAL)
    INTO avg_invoice
    FROM INVOICE;
    return avg_invoice;
END;
/
-- 3.2.2 Return the most expensive track
create or replace FUNCTION GET_EXPENSIVE_TRACK
    RETURN TRACK.NAME%TYPE
AS
    highest_price TRACK.UNITPRICE%TYPE;
    expensive_track TRACK.NAME%TYPE;
    expensive_track_id TRACK.TRACKID%TYPE;
BEGIN
    SELECT MAX(UNITPRICE) -- First want to know what the max is
    INTO highest_price
    FROM TRACK;
    SELECT MIN(TRACK.TRACKID) -- Limit to one selection of items wit max
    INTO expensive_track_id
    FROM TRACK
    WHERE (UNITPRICE=highest_price);
    SELECT MAX(TRACK.NAME) -- Taking the name as a value rather than a table.
    INTO expensive_track
    FROM TRACK
    WHERE (TRACKID=expensive_track_id);
    return expensive_track;
END;
/
-- 3.3 User Defined Scalar Functions
-- 3.3.1 Creating a function that returns the average price of invoiceline items in the invoiceline table
create or replace FUNCTION GET_AVG_INVOICELINE
    RETURN NUMBER
AS
    avg_invoiceline NUMBER;
BEGIN
    SELECT AVG(UNITPRICE)
    INTO avg_invoiceline
    FROM INVOICELINE;
    return avg_invoiceline;
END;
/

-- 3.4 User Defined Table Valued Function
-- 3.4.1 Creating a function that returns all employees who are born after 1968.
-- From the pl-sql_demo
-- https://github.com/wsingleton/1806-Jun18-Java-USF/blob/master/Week_2-SQL_JDBC/pl-sql_demo.sql
CREATE OR REPLACE FUNCTION AFTER_1968
	RETURN SYS_REFCURSOR
IS
	employee_cursor SYS_REFCURSOR;
BEGIN
	OPEN employee_cursor FOR
	SELECT *
	FROM EMPLOYEE
	WHERE BIRTHDATE > DATE'1968-12-31';
	return employee_cursor;
END;
/


-- 4.0 STORED PROCEDURES
-- 4.1 Basic Stored Procedures
create or replace PROCEDURE GET_EMPLOYEES_NAMES(
	employees_names_cursor OUT SYS_REFCURSOR)
IS
BEGIN
	OPEN employees_names_cursor FOR
	SELECT FIRSTNAME, LASTNAME
	FROM EMPLOYEE;
END;
/

-- 4.2 Stored Procedure Input Parameters
-- 4.2.1 Creating a stored procedure that updates the personal information of an employee.
create or replace PROCEDURE UPDATE_EMPLOYEE_INFO(
	employee_id IN EMPLOYEE.EMPLOYEEID%TYPE,
    new_email IN EMPLOYEE.EMAIL%TYPE
    )
IS
BEGIN
	UPDATE EMPLOYEE
	SET EMAIL = new_email
    WHERE EMPLOYEEID = employee_id;
END;
/
-- 4.2.2 Task – creating a stored procedure that returns the managers of an employee.
create or replace PROCEDURE GET_MANAGERS(
	employee_id IN EMPLOYEE.EMPLOYEEID%TYPE,
	manager_id OUT EMPLOYEE.EMPLOYEEID%TYPE,
	manager_firstname OUT EMPLOYEE.FIRSTNAME%TYPE,
	manager_lastname OUT EMPLOYEE.LASTNAME%TYPE
    )
IS
BEGIN
	SELECT MIN(EMPLOYEE.REPORTSTO)
    INTO manager_id
    FROM EMPLOYEE
    WHERE (EMPLOYEEID=employee_id);
    IF (manager_id IS NULL) THEN
    	manager_firstname := NULL;
    	manager_lastname := NULL;
    ELSE
    	SELECT MAX(EMPLOYEE.FIRSTNAME), MAX(EMPLOYEE.LASTNAME)
    	INTO manager_firstname, manager_lastname
    	FROM EMPLOYEE
    	WHERE EMPLOYEEID=manager_id;
    END IF;
END;
/
-- 4.3 Stored Procedure Output Parameters
create or replace PROCEDURE GET_CUSTOMER_INFO(
	customer_id IN CUSTOMER.CUSTOMERID%TYPE,
	customer_fn OUT CUSTOMER.FIRSTNAME%TYPE,
	customer_ln OUT CUSTOMER.LASTNAME%TYPE,
	customer_cmp OUT CUSTOMER.COMPANY%TYPE
    )
IS
BEGIN
	SELECT MIN(CUSTOMER.FIRSTNAME), MIN(CUSTOMER.LASTNAME), MIN(CUSTOMER.COMPANY)
    INTO customer_fn, customer_ln, customer_cmp
    FROM CUSTOMER
    WHERE (CUSTOMER.CUSTOMERID=customer_id);
END;
/

-- 5.0 Transactions
-- Task - Creating a transaction that given a invoiceId will delete that invoice
create or replace PROCEDURE DELETE_INVOICE(
	invoice_id IN INVOICE.INVOICEID%TYPE
    )
IS
BEGIN
	DELETE FROM INVOICELINE
        WHERE INVOICEID=invoice_id;
    DELETE FROM INVOICE
        WHERE INVOICEID=invoice_id;
	COMMIT;
END;
/
-- Task – Creating a transaction nested within a stored procedure
--		  that inserts a new record in the Customer table
create or replace PROCEDURE INSERT_CUSTOMER_TRANSACT(
	customer_id IN CUSTOMER.CUSTOMERID%TYPE,
	first_name IN CUSTOMER.FIRSTNAME%TYPE, 
	last_name IN CUSTOMER.LASTNAME%TYPE,
	customer_company IN CUSTOMER.COMPANY%TYPE, 
	customer_address IN CUSTOMER.ADDRESS%TYPE,
	customer_city IN CUSTOMER.CITY%TYPE, 
	customer_state IN CUSTOMER.STATE%TYPE, 
	customer_country IN CUSTOMER.COUNTRY%TYPE, 
	postal_code IN CUSTOMER.POSTALCODE%TYPE,
	phone_number IN CUSTOMER.PHONE%TYPE,
	customer_fax IN CUSTOMER.FAX%TYPE,
	customer_email IN CUSTOMER.EMAIL%TYPE,
	support_rep_id IN CUSTOMER.SUPPORTREPID%TYPE)
IS
BEGIN
	INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, 
	LASTNAME, COMPANY, ADDRESS, CITY, STATE, 
	COUNTRY, POSTALCODE, PHONE, FAX, EMAIL,
	SUPPORTREPID)
	VALUES (customer_id, first_name, last_name,
		customer_company, customer_address,
		customer_city, customer_state, customer_country,
		postal_code, phone_number, customer_fax,
		customer_email, support_rep_id);
	COMMIT;
END;
/


-- 6 Triggers 
-- 6.1 AFTER/FOR
-- 6.1.1 Task - Creating an after insert trigger on the employee table 
--              fired after a new record is inserted into the table.
create or replace TRIGGER ORGANIZE_ID 
    AFTER
    INSERT 
    ON EMPLOYEE
        DECLARE
            max_employee_id         EMPLOYEE.EMPLOYEEID%TYPE;
            employee_id             EMPLOYEE.EMPLOYEEID%TYPE;
            employee_ln             EMPLOYEE.LASTNAME%TYPE;
            employee_fn             EMPLOYEE.FIRSTNAME%TYPE;
            employee_tt             EMPLOYEE.TITLE%TYPE;
            employee_rt             EMPLOYEE.REPORTSTO%TYPE;
            employee_bd             EMPLOYEE.BIRTHDATE%TYPE;
            employee_hd             EMPLOYEE.HIREDATE%TYPE;
            employee_ad             EMPLOYEE.ADDRESS%TYPE;
            employee_ci             EMPLOYEE.CITY%TYPE;
            employee_st             EMPLOYEE.STATE%TYPE;
            employee_cn             EMPLOYEE.COUNTRY%TYPE;
            employee_pc             EMPLOYEE.POSTALCODE%TYPE;
            employee_pn             EMPLOYEE.PHONE%TYPE;
            employee_fx             EMPLOYEE.FAX%TYPE;
            employee_em             EMPLOYEE.EMAIL%TYPE;
        BEGIN
            SELECT MAX(EMPLOYEE.EMPLOYEEID), COUNT(*)
                INTO max_employee_id, employee_id
                FROM EMPLOYEE;
            IF (employee_id <> max_employee_id) THEN
                SELECT MAX(EMPLOYEE.LASTNAME), MAX(EMPLOYEE.FIRSTNAME),
                    MAX(EMPLOYEE.TITLE), MAX(EMPLOYEE.REPORTSTO),
                    MAX(EMPLOYEE.BIRTHDATE), MAX(EMPLOYEE.HIREDATE),
                    MAX(EMPLOYEE.ADDRESS), MAX(EMPLOYEE.CITY),
                    MAX(EMPLOYEE.STATE), MAX(EMPLOYEE.COUNTRY),
                    MAX(EMPLOYEE.POSTALCODE), MAX(EMPLOYEE.PHONE),
                    MAX(EMPLOYEE.FAX), MAX(EMPLOYEE.EMAIL)
                    INTO employee_ln, employee_fn, employee_tt, 
                        employee_rt, employee_bd, employee_hd,
                        employee_ad, employee_ci, employee_st,
                        employee_cn, employee_pc, employee_pn,
                        employee_fx, employee_em
                    FROM EMPLOYEE
                    WHERE EMPLOYEEID = max_employee_id;
                DELETE FROM EMPLOYEE
                    WHERE EMPLOYEEID = max_employee_id;
                SELECT MAX(EMPLOYEE.EMPLOYEEID)
                    INTO max_employee_id
                    FROM EMPLOYEE;
                max_employee_id := max_employee_id + 1;
                INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME,
                    TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY,
                    STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL) 
                    VALUES (max_employee_id, employee_ln, employee_fn,
                        employee_tt, employee_rt, employee_bd,
                        employee_hd, employee_ad, employee_ci,
                        employee_st, employee_cn, employee_pc,
                        employee_pn, employee_fx, employee_em);
            END IF;
        END;
/
-- 6.1.2 Task – Creating an after update trigger on the album table that
--              fires after a row is inserted in the table
create or replace TRIGGER UPDATE_ALBUM_TRIGGER
    AFTER
    UPDATE 
    ON ALBUM 
        DECLARE
            albums_with_title NUMBER;
        BEGIN
            SELECT COUNT(*)
                INTO albums_with_title
                FROM ALBUM
                WHERE TITLE='Change back to Transmissions';
            IF (albums_with_title > 0) THEN
                UPDATE ALBUM
                SET TITLE='Transmissions'
                WHERE TITLE='Change back to Transmissions';
            END IF;
        END;
/
-- 6.1.3 Task – Creating an after delete trigger on the customer table
--              that fires after a row is deleted from the table.
create or replace TRIGGER CUSTOMER_DELETE_TRIGGER
    AFTER
    DELETE 
    ON CUSTOMER 
        DECLARE
            customers_with_name NUMBER;
        BEGIN
            SELECT COUNT(*)
                INTO customers_with_name
                FROM CUSTOMER
                WHERE ((FIRSTNAME = 'John' OR FIRSTNAME = 'Jane')
                	AND LASTNAME='Doe');
            IF (customers_with_name > 0) THEN
                DELETE FROM CUSTOMER
                WHERE ((FIRSTNAME = 'John' OR FIRSTNAME = 'Jane')
                	AND LASTNAME='Doe');
            END IF;
        END;
/
-- 6.2 BEFORE
-- Task – Creating a before trigger that restricts the 
-- deletion of any invoice that is priced over 50 dollars.
create or replace TRIGGER INVOICE_BEFORE_DELETE
    BEFORE
    DELETE 
    ON INVOICE
    	FOR EACH ROW WHEN (OLD.TOTAL > 50) BEGIN
            RAISE_APPLICATION_ERROR(-20000, 'Cannot delete an invoice of over 50 dollars.');
        END;
/

-- 7.0 JOINS
-- 7.1 INNER JOINS
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID
	FROM CUSTOMER
	INNER JOIN INVOICE
	ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
-- 7.2 OUTER JOINS
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME,
	INVOICE.INVOICEID, INVOICE.TOTAL
	FROM CUSTOMER
	FULL JOIN INVOICE
	ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
-- 7.3 RIGHT JOINS
SELECT ARTIST.NAME, ALBUM.TITLE
	FROM ALBUM
	RIGHT JOIN ARTIST
	ON ALBUM.ARTISTID = ARTIST.ARTISTID;
-- 7.4 CROSS JOINS
SELECT ARTIST.NAME, ALBUM.TITLE, ALBUM.ALBUMID
	FROM ALBUM
	CROSS JOIN ARTIST
	WHERE ALBUM.ARTISTID = ARTIST.ARTISTID
    ORDER BY ARTIST.NAME ASC;
-- 7.5 SELF JOINS
SELECT worker.FIRSTNAME, worker.LASTNAME, worker.EMAIL,
	boss.FIRSTNAME, boss.LASTNAME, boss.EMAIL
	FROM EMPLOYEE worker, EMPLOYEE boss
	WHERE worker.REPORTSTO = boss.EMPLOYEEID;
-- 8.0 INDEXES
CREATE INDEX EMPLOYEE_LOOKUP
	ON EMPLOYEE (LASTNAME, FIRSTNAME, EMAIL, PHONE);
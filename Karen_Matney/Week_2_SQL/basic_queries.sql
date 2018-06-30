SELECT *
FROM  products;

SELECT product_name,price
FROM products;

SELECT product_name, price, 'test', (price /2)
FROM products;

-- Get teh first and last names of all employees with their monthly incomes
SELECT emp_fn,emp_ln,monthln_income
FROM employees;

-- Get all the inofrmation form the departments table
SELECT *
FROM departments;

-- The company is going to give all employees a 20% increase on their saleries,
-- and your task is to display a list of all the employees which includes the
-- employee's ID, their name, current monthly income, and the income they will have after
-- the 20% increase. Use column aliases to rename appropriate columns.
SELECT emp_id,emp_fn,emp_ln,monthln_income AS current_income,(monthln_income * 1.2) AS new_income
FROM employees;

-- WHERE clause
-- SELECT (column names)
-- FROME table_anem
-- WHERE (conditonal)

SELECT prod_id, product_name, price
FROM products
WHERE price < 10;

-- Retrive all product information for products whose expiration dates is earlier than 01-APR-2019
SELECT *
FROM products
WHERE expiration_date < '01-APR-2019';

-- Complex WHERE clauses
SELECT *
FROM products
WHERE 
    (
        prod_id < 5
        OR (product_name = 'Amoxicillin' AND price = 10)
    )
    AND
    (
        price <= 10
        OR expiration_date = DATE '2018-04-30'
    );
    
-- DISTINCT keyword
-- SELCT DISTINCT (column_names)
-- FROM table_name;

SELECT DISTING department_id
FROM employees;

SELECT DISTINCT department_id, emp_fn,emp_ln
FROM employees;

SELECT UNIQUE department_id
FROM employees;

-- ORDER BY
SELECT *
FROM employees
ORDER BY birthdate;

SELECT *
FROM employees
ORDER BY birthdate DESC;

SELECT *
FROM employees
ORDER BY department_id,monthln_income;

SELECT *
FROM employees
ORDER BY 5,6;               -- columns are 1-based

-- Aggregate Functions
SELECT MIN(price), MAX(price)
FROM products;

SELECT MIN(price), MAX(price), SUM(price)
FROM products;

SELECT COUNT(*)            -- Will not count nulls
FROM products;

ALTER TABLE products
ADD alternate_name VARCHAR2(25);

UPDATE products
SET alternate_name = SUBSTR(product_name, 1, 3)  -- Inclusive, a scalar function (1-on-1)
WHERE prod_id < 4;


SELECT COUNT(prod_id), SUM(price), COUNT(alternate_name)
FROM products;

-- Scalar functions

/*
    Numeric Functions
        - ABS()
        - CEIL()
        - FLOOR()
        - TRUNC(value, index)
        - ROUND()
        
    Character or Text Functions
        - LOWER()
        - UPPER()
        - INITCAPT()
        - LTRIM()
        - RTRIM()
        - TRIM()
        - SUBSTR()
        - LENGTH()
        
    Date Functions
        - MONTHS_BETWEEN(date1, date2) -- returns a number NOT a DATE
        - NEXT_DAY()
        - SYSDATE
        - LAST_DAY()
        
    Conversion Functions
        - TO_CHAR()
        - TO_DATE()
        - TO_NUMBER()
*/

-- GROUP BY
SELECT department_id,COUNT(*)
FROM employees
GROUP BY department_id;

-- HAVING
SELECT department_id, MIN(monthln_income), MAX(monthln_income), AVG(monthln_income)
FROM employees
GROUP BY department_id
HAVING MIN(monthln_income) < 2000
    OR MAX(monthln_income) > 4000
ORDER BY MIN(monthln_income) DESC;

/*
    Logical Operators
    
        - AND
        - OR
        - NOT
        - IN -- set of values
        - EXISTS (typically used with subqueries)
        - BETWEEN
*/

-- Subqueries
SELECT *
FROM employees
WHERE monthln_income = 
    (                               -- Scalar subquery
        SELECT MAX(monthln_income)
        FROM employees
    );
    
SELECT *
FROM employees
WHERE department_id IN
    (
        SELECT dept_id
        FROM departments
        WHERE monthy_budget > 20000
    );
    
/*
    Set Opuerations
        - UNION
        - UNION ALL
        - MINUS
        - INTERSECT
*/

-- UNION
-- For any kind of UNION, result sets must have the same number of columns and the datatypes must be compatible
-- Below does not work!
SELECT *
FROM departments
UNION
SELECT department_id
FROM employees;

SELECT dept_id
FROM departments
UNION
SELECT department_id
FROM employees;

-- Union all is just like a union, except a regular union doesn't include duplicates
-- UNION ALL
SELECT dept_id
FROM departments
UNION ALL
SELECT department_id
FROM employees;

-- INTERSECT
SELECT dept_id
FROM departments
WHERE monthy_budget > 15000
INTERSECT
SELECT department_id
FROM employees
WHERE monthln_income BETWEEN 2000 AND 2500;

-- MINUS
SELECT dept_id
FROM departments
WHERE monthy_budget > 15000
MINUS
SELECT department_id
FROM employees
WHERE monthln_income BETWEEN 2000 AND 2500;

-- What's the difference between minus and intersect
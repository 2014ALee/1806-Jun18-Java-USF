SELECT *
FROM products;

SELECT product_name, price
FROM products;

SELECT product_name, price, 'test', (price/2)
FROM products;

SELECT emp_fn, emp_ln, monthly_income
FROM employees;

SELECT *
FROM products;

SELECT emp_id, emp_fn, emp_ln, monthly_income AS current_income, (monthly_income*1.2) AS new_income
FROM employees;

--SELECT (column_names)
--FROM table_name
--WHERE (conditional)

SELECT prod_id, product_name, price
FROM products
WHERE price < 10;

SELECT *
FROM products
where expiration_date < '01-APR-2019';

SELECT *
FROM products
WHERE expiration_date < DATE '2019-04-01';

SELECT *
FROM products
WHERE
    (
        prod_id < 5
--        or (product_name = 'Amoxicillin' and price > 10)
    )
    and
    (
        price <= 10
--        or expiration_date = DATE '2018-04-30'
    );

SELECT DISTINCT department_id
FROM employees;

SELECT DISTINCT department_id, emp_fn, emp_ln
FROM employees;

SELECT UNIQUE department_id
FROM employees;

SELECT *
FROM employees
ORDER BY BIRTHDATE;

SELECT *
FROM employees
ORDER BY BIRTHDATE DESC;

SELECT *
FROM employees
ORDER BY department_id, monthly_income;

SELECT *
FROM employees
ORDER BY 5, 6;

SELECT MIN(price), MAX(price)
FROM products;

SELECT MIN(price), MAX(price), SUM(price)
FROM products;

SELECT COUNT(*)
FROM products;

ALTER TABLE products
ADD alternate_name VARCHAR2(25);

UPDATE products
SET alternate_name = SUBSTR(product_name, 1, 3)
where prod_id < 4;

SELECT COUNT(prod_id), SUM(price), COUNT(alternate_name)
FROM products;

/*  Scalars
    Numeric Functions
        - ABS()
        - CEIL()
        - FLOOR()
        - TRUNC(value, index)
        - ROUND()
        
    Character/Text Functions
        - LOWER()
        - UPPER()
        - INITCAP()
        - LTRIM()
        - RTRIM()
        - TRIM()
        - SUBSTR()
        - LENGTH()
    Date Functions
        - MONTHS_BETWEEN(date1, date2)
        - NEXT_DAY()
        - SYSDATE
        - LAST_DAY()
    
    Conversion Functions
        - TO_CHAR()
        - TO_DATE()
        - TO_NUMBER()
*/

SELECT department_id, COUNT(*)
FROM employees
GROUP BY DEPARTMENT_ID;

SELECT department_id, MIN(monthly_income), MAX(monthly_income), AVG(monthly_income)
FROM employees
GROUP BY department_id
HAVING MIN(monthly_income) < 2000
    OR MAX(monthly_income) > 4000
ORDER BY MIN(monthly_income);

/*
    Logical Operators
    
    - AND
    - OR
    - NOT
    - IN
    - EXISTS (typically used with subqueries)
    - BETWEEN
*/

SELECT *
FROM employees
WHERE monthly_income = 
    (
        SELECT MAX(monthly_income)
        FROM employees
    );

SELECT *
FROM employees
WHERE department_id in 
    (
        SELECT dept_id
        FROM departments
        WHERE monthly_budget > 20000
    );

/*
    Set Operations
        - UNION
        - UNION ALL
        - MINUS
        - INTERSET
*/

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

SELECT dept_id
FROM departments
UNION ALL
SELECT department_id
FROM employees;

SELECT dept_id
FROM departments
where monthly_budget > 15000
INTERSECT
SELECT department_id
FROM employees
WHERE monthly_income BETWEEN 2000 AND 2500;

SELECT dept_id
FROM departments
where monthly_budget > 15000
MINUS
SELECT department_id
FROM employees
WHERE monthly_income BETWEEN 2000 AND 2500;












/*
    In a SELECT statement, you need to specify at least:
        - the columns you want to retrieve
        - the table where those values are stored
        
    We can grab all of the columns from a table using an asterisk 
    in place of a column list. This should seem familiar to you, 
    since in Java we use the asterisk to import all of the contained
    classes from a targeted package.
*/

SELECT *
FROM products;

-- Specify certain columns
SELECT product_name, price
FROM products;

-- Not many restrictions on what columns we include in our result set
SELECT product_name, price, 'test', (price /2)
FROM products;

-- Get the first and last names of all employees with their monthly incomes
SELECT emp_fn, emp_ln, monthly_income
FROM employees;

-- Get all the information from the departments table
SELECT *
FROM departments;

-- The company is going to give all employees a 20% increase on their salaries, 
-- and your task is to display a list of all of the employees which includes the 
-- employee's ID, their name, current monthly income, and the income they will have after 
-- the 20% increase. Use column aliases to rename appropriate columns.
SELECT emp_id, emp_fn, emp_ln, monthly_income AS current_income, (monthly_income * 1.2) AS new_income
FROM employees;

/*
    WHERE clause
    
    So far, we have written queries that return all of the rows from the table that 
    we are querying. However, sometimes we do not always need all of the rows in our 
    tables. Instead, we might want to filter out certain rows based off of some 
    conditional. This is where the WHERE clause comes in handy.
*/
SELECT prod_id, product_name, price
FROM products
WHERE price < 10;

-- Retrieve all product information for products whose expiration dates is earlier than 01-APR-2019
SELECT *
FROM products 
WHERE expiration_date < '01-APR-2019';

/*
    NOTE: When you use strings to represent dates, as in the previous example, Oracle uses the date 
    format defined in your system to convert the string to an actual date. So even though it works 
    correctly for you nothing guarantees that the same statement will work as intended on another 
    system.
*/

/*
    Complex WHERE clauses
    
    We can make our WHERE clauses extremely complex if desired. To include multiple conditionals we 
    can simply chain them using the logical operator keywords AND & OR. No matter how many of these 
    conditionals we chain, the results we get still comes down to what the final conditional is 
    evaluated to.
*/
SELECT *
FROM products
WHERE 
    (
        prod_id < 5
        OR (product_name = 'Amoxicillin' AND price > 10)
    )
    AND
    (
        price <= 10
        OR expiration_date = DATE '2018-04-30'
    );
    
/*
    DISTINCT
    
    Used to only return distinct, or unique, results in a result set.
*/
SELECT department_id -- returns duplicates
FROM employees;

SELECT DISTINCT department_id -- eliminates duplicates
FROM employees;

-- A record is duplicate if all of the retrieved columns are the same
SELECT DISTINCT department_id, emp_fn, emp_ln
FROM employees;

-- The UNIQUE keyword can be used in place of DISTINCT
SELECT UNIQUE department_id
FROM employees;

/*
    ORDER BY clause
    
    In most real world scenarios, we will want to retrieve the results of a query 
    in some specific order. We can accomplish this by using the ORDER BY clause.  
*/
-- returns all the employees in ascending order based on birthdate
SELECT *
FROM employees
ORDER BY birthdate;

-- Does the exact same thing, ASC is implicit
SELECT *
FROM employees
ORDER BY birthdate ASC;

-- returns all the employees in descending order based on birthdate
SELECT *
FROM employees
ORDER BY birthdate DESC;

-- we can apply more than one sorting criteria to our query
SELECT *
FROM employees
ORDER BY department_id, monthly_income;

-- alternatively, we can use the column positions instead of their names
SELECT *
FROM employees
ORDER BY 6, 5;

/*
    Scalar Functions
    
    Scalar functions, also known as single row functions, return a value for every 
    row that is processed in a query. There are four types of scalar functions that 
    you should be familiar with:
    
        - Numeric functions
            + ABS()
            + CEIL(), FLOOR()
            + TRUNC(), ROUND()
            
        - Character/Text functions
            + LOWER(), UPPER(), INITCAP()
            + LTRIM(), RTRIM(), TRIM()
            + SUBSTR()
            + LENGTH()
            
        - Date functions
            + ADD_MONTH()
            + MONTHS_BETWEEN()
            + SYSTIME
            
        - Conversion functions
            + TO_CHAR()
            + TO_DATE()
            + TO_NUMBER()
*/

/*
    Aggregate functions
    
    Functions that operate on a group of rows at the same time and provide a single value, 
    as opposed to scalar functions which operate upon a single value at a time.
*/
SELECT MIN(price), MAX(price)
FROM products;

-- these aggregate functions produce a single value based off of the data in an entire column
SELECT MIN(price), MAX(price), SUM(price)
FROM products;

-- COUNT() is a commonly used aggregate function (does not cound null values)
SELECT COUNT(product_name)
FROM products;

-- Alter the products table to add a new column (all values will be null for existing records
ALTER TABLE products
ADD alternate_name VARCHAR2(25);

-- Update the values of the new column for some of our records, leaving a few null values
UPDATE products
SET alternate_name = SUBSTR(product_name, 1, 3) --  SUBSTR() is a scalar function
WHERE prod_id < 4;

-- notice that the last column that is counting is less than our first column (null values are not counted)
SELECT COUNT(prod_id), SUM(price), COUNT(alternate_name)
FROM products;

/*
    GROUP BY clause
    
    The GROUP BY clause groups the result set into groups and most of the time, 
    it used with aggregate functions. When that is the case the aggregate function 
    is applied to each group, and the results include one row per group.
*/

-- Retrieve all of the rows in the Employees table and group them by department_id, and then
-- apply the count function to each group.
SELECT department_id, COUNT(*)
FROM employees
GROUP BY department_id;

/*
    HAVING clause
    
    The HAVING clause is used in a similar manner as the WHERE clause, just as the GROUP BY
    clause is used similarly to the ORDER BY clause. In fact, the same difference between those two
    is the difference between HAVING and WHERE. The HAVING clause is used with aggregate function.  
*/
-- Retrieves only departments whose smallest salary is less than 2000 or their highest salary is 
-- greater than 4000. The results are displayed in descending order by the salary.
SELECT department_id, MIN(monthly_income), MAX(monthly_income), AVG(monthly_income)
FROM employees
GROUP BY department_id
HAVING MIN(monthly_income) < 2000
    OR MAX(monthly_income) > 4000
ORDER BY MIN(monthly_income) DESC;    

/*
    More on the HAVING clause
    
    Key points here are that you can use conditions that involve aggregate functions in the HAVING clause, 
    and you can also order the results by including an aggregate function in the HAVING clause. 
    
    Remember that you can do these 2 things even if the aggregate functions are not used or referenced in 
    the SELECT list of the query.
*/

/*
    Logical Operators
    
    Logical operators are those that are true or false. The return true or false values to combine 
    one or more true or false values.

    - AND
        + compares between two Booleans as expression and returns true when both expressions are true.
        
    - OR
        + compares between two Booleans as expression and returns true when one of the expression is true.
        
    - NOT
        + takes a single Boolean as an argument and changes its value from false to true or from true 
        to false.
        
    - IN
        + checks a value within a set of values separated by commas and retrieve the rows from the 
          table which are matching.
        
    - BETWEEN
        + tests an expression against a range. The range consists of a beginning, followed by an AND 
          keyword and an end expression.
        
    - ANY
        + compares a value to each value in a list or results from a query and evaluates to true if the 
          result of an inner query contains at least one row.
        
    - ALL
        + used to select all records of a SELECT statement. It compares a value to every value in a list 
          or results from a query.
          
        + must be preceded by the comparison operators and evaluates to TRUE if the query returns no rows.
        
    - SOME
        + compare a value to each value in a list or results from a query and evaluate to true if the 
          result of an inner query contains at least one row.
        
    - EXISTS
        + checks the existence of a result of a subquery.
        + tests whether a subquery fetches at least one row
        + when no data is returned then this operator returns 'FALSE'.
*/

/*
    Subqueries
    
    A subquery is a SELECT statement that is included, or nested, within another SQL statement 
    (any SELECT, INSERT, UPDATE, or DELETE) - and are always enclosed within in parenthesis.
*/

/*
    Since we are using a comparison operator in our WHERE clause, our subquery MUST return one 
    and only one value, a single column and a single row. This type of subquery is called a 
    scalar subquery.
*/
SELECT *
FROM employees
WHERE monthly_income =
    (
        SELECT MAX(monthly_income)
        FROM employees
    );
  
-- Use IN to handle a subquery that returns more than one result  
SELECT *
FROM employees
WHERE department_id IN
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
    - INTERSECT
*/

/*
    UNION
    
    UNION is an operator keyword in SQL that is used to combine the results from queries, and 
    then removes duplicate rows from the final result set.

        - The result set of each SELECT statement MUST have the same number of columns
        - Columns in each result set MUST have compatible datatypes
*/

-- Does not work (# of columns does not match)
SELECT *
FROM departments
UNION
SELECT department_id
FROM employees;

-- This works!
SELECT dept_id
FROM departments
UNION
SELECT department_id
FROM employees;

-- UNION ALL does not filter out duplicates
SELECT dept_id
FROM departments
UNION ALL
SELECT department_id
FROM employees;

/*
    INTERSECT
    
    Returns only the rows which are returned by both queries. So, in order for a row to be 
    included in the final result set, it must be included in the first AND the second queries. 
    
    Also, after calculating the intersection of the results from the component queries, 
    duplicate rows are eliminated.
*/
SELECT dept_id
FROM departments
WHERE monthly_budget > 15000
INTERSECT
SELECT department_id
FROM employees
WHERE monthly_income BETWEEN 2000 AND 2500;

/*
    MINUS
    
    MINUS work in the opposite, or converse, manner as INTERSECT. Rather than returning the results that
    are shared by both queries, it returns the results that are not present in both queries.
*/
SELECT department_id
FROM employees
WHERE monthly_income BETWEEN 2000 AND 2500
MINUS
SELECT dept_id
FROM departments
WHERE monthly_budget > 15000;
/*
        INNER JOIN
        
        A kind of join that returns rows that satisfy the JOIN condition. Which means that a row from the 
        first table, will only be returned if there is a matching row in the second table.
*/

SELECT *
FROM employees
JOIN jobs
ON employees.job_id = jobs.job_id;

SELECT *
FROM  employees e
JOIN jobs j
ON e.job_id = j.job_id;

SELECT *
FROM  employees e
INNER JOIN jobs j
ON e.job_id = j.job_id;

SELECT *
FROM employees 
JOIN jobs
USING (job_id);         -- Only for  natural joins

SELECT *
FROM employees, jobs            -- Prodoces Cartisean Product (rows in A * rows in B)
WHERE employees.job_id = jobs.job_id;

-- CROSS JOIN
SELECT *
FROM employees
CROSS JOIN departments;

SELECT *
FROM employees, departments;

-- SELF JOIN
SELECT e.employee_id, e.first_name, e.last_name, e.salary
FROM employees e
JOIN employees em
ON e.manager_id = em.employee_id
ORDER BY employee_id;

/*
    Equi and Theta Joins
    
    Equi joins on one table perform a JOIN against equal or matching column values of the other table,
    using the equals operator. Most of the JOINs will be qui joins.
    
    Theta joins, or non-equi joins, are types of joins that are performed against some arbitrary comparision
    operator/relationship (greater than, less than, etc.)
*/
SELECT e.id, e.name, e.salary, sc.classificiation
FROM employee e
JOIN salary_classification sc
ON e.salary BETWEEN sc.highest_value AND sc.highest_value

/*
    Cursor
    
    A pointer to the context area that holds the rows returned by a SQL statement. This will
    be useful to us when we start working with JDBC, and parsing through our result sets.
*/
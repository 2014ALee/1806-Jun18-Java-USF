/*
    INNER JOIN
    
    Inner Joins are the kind of joins that return rows that satisfy the join condition. Which 
    means that a row from the first table, will only be returned if there is a matching row in 
    the second table.
    
    Inner joins are the most commonly used type of joins in SQL, and are even implicitly executed 
    when no specific type of join is used with the JOIN keyword.
*/
SELECT *
FROM employees
JOIN jobs
ON employees.job_id = jobs.job_id;

-- We can also alias tables, similar to how we alias columns in the column list (no need for AS here)
-- Makes for easy referencing in the query.
SELECT *
FROM employees e
JOIN jobs j
ON e.job_id = j.job_id;

-- Returns the same thing as the previous queries. INNER is implicit if no JOIN is specified.
SELECT *
FROM employees e
INNER JOIN jobs j 
ON e.job_id = j.job_id;

-- With natural joins (same column in both tables), we can use the USING clause
SELECT *
FROM employees
JOIN jobs
USING (job_id);

-- We can achieve the same result without using a JOIN explicitly, by using multiple tables in 
-- the FROM clause
SELECT *
FROM employees, jobs
WHERE employees.job_id = jobs.job_id;

/*
    CROSS JOIN
    
    Returns the cartesian product of the tables: all rows from one table are combined with 
    all of the rows from the other table. You can think of a CROSS JOIN, as a JOIN without 
    conditions.
    
    Table A has 10 rows, and Table B has 16 rows, then a CROSS JOIN between these two tables
    would produce a result set with 160 rows (10 * 16).
*/
SELECT *
FROM employees
CROSS JOIN departments;

-- We can achieve a CROSS JOIN without using using a JOIN clause at all
SELECT *
FROM employees, departments;

/*
    SELF JOIN
    
    A SELF JOIN is nothing more than a normal join, but you can join the table to itself
*/
SELECT DISTINCT e.employee_id, e.first_name, e.last_name, e.salary
FROM employees e
JOIN employees em
ON e.manager_id = em.employee_id
ORDER BY employee_id;

/*
    Equi and Theta Joins
    
    Equi joins on one table perform a JOIN against equal or matching column values of the other table,
    using the equals operator. Most of the JOINs will be equi joins.
    
    Theta joins, or non-equi joins, are types of joins that are performed against some arbitrary comparsion
    operator/relationship (greater than, less than, etc.)
*/
SELECT e.id, e.name, e.salary, sc.classification
FROM employees e
JOIN salary_classification sc
ON e.salary BETWEEN sc.lowest_value AND sc.highest_value;

/*
    Cursor
    
    A pointer to the context area that holds the rows returned by a SQL statement. This will
    be useful to us when we start working with JDBC, and parsing through our result sets.
*/

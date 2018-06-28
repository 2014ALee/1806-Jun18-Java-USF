/*
    Inner Join
    
    Returns rows that satisfy the join condition. A row from the first table will onlt be returned
    if there is a matching row in the second table. Similar to natural join except natural join doesn't
    include both columns.
*/
SELECT *
FROM employees e
JOIN jobs j
ON e.job_id = j.job_id;
-- similar to
-- Natural join
SELECT *
FROM employees
NATURAL JOIN jobs;
-- equivalent to
SELECT *
FROM employees
JOIN jobs
USING (job_id);

-- Cross Join
-- num rows in a * num rows in b = size of result set
SELECT *
FROM employees
CROSS JOIN departments;

-- Self joins
-- get all employees whos employee_id is another employee's manager_id
SELECT e.employee_id, e.first_name, e.last_name, e.salary
FROM employees e
JOIN employees em
ON e.manager_id = em.employee_id
ORDER BY employee_id;


/*
    Equi and Theta joins
    
    Equi joins perform a join against equal or matching column values of the other table
    
    Theta joins are joins that are performed agains some arbitrary comparison operator/relationship
*/
SELECT e.id, e.name, e.salary, sc.classification
FROM employees e
JOIN salary_classification sc
on sc.salary BETWEEN sc.lowest_value and sc.highest_value;

/*
    Cursor
    
    A pointer to the context area that holds the rows returned by an SQL statement. This will
    be useful to us when we start working with JDBC, and parsing through our result set.
*/
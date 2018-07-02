SELECT *
FROM employees e
JOIN jobs j
ON employees.job_id = jobs.job_id;

SELECT *
FROM employees e
JOIN jobs j
ON e.job_id = j.job_id;

SELECT *
FROM employees e
INNER JOIN jobs j
ON e.job_id = j.job_id;

SELECT *
FROM employees, jobs
WHERE employees.job_id = jobs.job_id;

SELECT *
FROM employees
CROSS JOIN departments;

SELECT e.employee_id, e.first_name, e.last_name, e.salary
FROM employees e
JOIN employees em
ON e.manager_id = em.employee_id
ORDER BY employee_id;

--Theta Join
SELECT e.id, e.name, e.salary, sc.classification
FROM employee e
JOIN salary_classification sc
ON e.salary BETWEEN sc.lowest_value AND sc.highest_value;











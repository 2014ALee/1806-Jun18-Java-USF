SELECT EmployeeFirstName, EmployeeLastName
FROM Employees;

SELECT EmployeeFirstName, HireDate, 'test', (MonthlyIncome * 1.5)
FROM Employees;

SELECT EmployeeID, EmployeeFirstName, EmployeeLastName, MonthlyIncome AS current_income, (MonthlyIncome * 1.2) AS new_income
FROM Employees;

-- Where clause
SELECT *
FROM Employees
WHERE MonthlyIncome > 4000 AND JobID != 'HR_REP';

SELECT *
FROM Employees
WHERE HireDate > '01-JAN-2000';


-- distinct
SELECT DISTINCT DepartmentID
FROM Employees;

-- select distinct all columns
SELECT DISTINCT DepartmentID, EmployeeFirstName, EmployeeLastName
FROM Employees;


-- Order By
SELECT *
FROM Employees
WHERE HIREDATE > '01-JAN-2000'
ORDER BY BirthDate;

SELECT *
FROM Employees
ORDER BY BirthDate DESC;

SELECT *
FROM Employees
ORDER BY DepartmentID, MonthlyIncome;


-- Aggregate functions operate on a group of data
SELECT MIN(MonthlyIncome), MAX(MonthlyIncome)
FROM Employees;

SELECT MIN(MonthlyIncome), MAX(MonthlyIncome), SUM(MonthlyIncome)
FROM Employees;

SELECT MonthlyIncome, COUNT(*)
FROM Employees group by MonthlyIncome;

-- Alter
ALTER TABLE Employees
ADD newCol VARCHAR2(25);

-- Update
UPDATE Employees
SET newCol = SUBSTR(EMPLOYEEFIRSTNAME, 1, 3)
WHERE EMPLOYEEID < 10;

SELECT COUNT(EmployeeID), SUM(MonthlyIncome), COUNT(newCol)
FROM Employees
WHERE EmployeeFirstName NOT IN(SELECT EmployeeFirstName
                                FROM Employees
                                WHERE MonthlyIncome < 2000);
                                
-- Scalar Functions

/*
    Numeric Functions
        ABS()
        CEIL()
        FLOOR()
        TRUNC(value, index)
        ROUND()
        
    Text functions
        LOWER()
        UPPER()
        INITCAP()
        LTRIM()
        RTRIM()
        SUBSTR()
        LENGTH()
        
    Date Functiuons
        MONTHS_BETWEEN(DATE1, DATE2) - returns a number
        NEXT_DAY(DATE)
        SYSDATE()
        LAST_DAY()
        
    Conversion Functions
        TO_CHAR()
        TO_DATE()
        TO_NUMBER()
        
*/

-- Group By / Having
SELECT DepartmentName, COUNT(*)
FROM Employees e, Departments d
WHERE d.DepartmentID = e.DepartmentID
GROUP BY DepartmentName;

SELECT DepartmentID, MIN(MonthlyIncome), MAX(MonthlyIncome), AVG(MonthlyIncome)
FROM Employees
GROUP BY DepartmentID
HAVING MIN(MonthlyIncome) < 2000
    OR MAX(MonthlyIncome) > 4000
ORDER BY MIN(MonthlyIncome);

/*
    Logical Operators
        AND
        OR
        NOT
        IN
        EXISTS
        BETWEEN
*/

-- Subqueries
SELECT COUNT(EmployeeID), SUM(MonthlyIncome), COUNT(newCol)
FROM Employees
WHERE EmployeeFirstName NOT IN(SELECT EmployeeFirstName
                                FROM Employees
                                WHERE MonthlyIncome < 2000);

SELECT *
FROM Employees
WHERE MonthlyIncome = (
    SELECT MAX(MonthlyIncome)
    FROM Employees
);

/*
    Set Operations
        UNION
        UNION ALL
        MINUS
        INTERSECT
*/

-- union: shows things that are in either set
SELECT DepartmentID
FROM Departments
UNION
SELECT DepartmentID
FROM Employees;
-- NOTE: union doesn't show duplicates, union all does

-- intersect: shows things that are in both sets
SELECT DepartmentID
FROM Departments
INTERSECT
SELECT DepartmentID
FROM Employees;

-- minus
SELECT DepartmentID
FROM Departments
MINUS
SELECT DepartmentID
FROM Employees;
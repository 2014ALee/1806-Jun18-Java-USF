--DROP TABLE Departments;
--DROP TABLE Employees;
--DROP TABLE Products;

CREATE TABLE Departments(
    DepartmentID        NUMBER(5)       CONSTRAINT pk_departments PRIMARY KEY,
    DepartmentName      VARCHAR2(50),
    MonthlyBudget       NUMBER(8,2)   -- Number containing 8 digits, 2 of which are after the decimal
);

CREATE TABLE Employees(
    EmployeeID          NUMBER(5),
    EmployeeFirstName   VARCHAR2(25),
    EmployeeLastName    VARCHAR2(25),
    BirthDate           DATE,
    MonthlyIncome       NUMBER(7,2)     NOT NULL,
    DepartmentID        NUMBER(5),
    HireDate            DATE,
    JobID               VARCHAR2(20),
    EmailAddress        VARCHAR2(255),
    
    CONSTRAINT pk_employees
        PRIMARY KEY (EmployeeID),
    CONSTRAINT fk_employee_department
        FOREIGN KEY (DepartmentID)
        REFERENCES Departments (DepartmentID)
);

CREATE TABLE Products(
    ProductID           NUMBER(5),
    ProductName         VARCHAR2(50)    NOT NULL,
    Price               NUMBER(7,2)     NOT NULL,
    ExpirationDate      DATE            NOT NULL
);

--DELETE FROM Departments;
INSERT INTO Departments(DepartmentID, DepartmentName, MonthlyBudget) VALUES(1, 'Accounting', 20000);
INSERT INTO Departments(DepartmentID, DepartmentName, MonthlyBudget) VALUES(2, 'IT', 15000);
INSERT INTO Departments(DepartmentID, DepartmentName, MonthlyBudget) VALUES(3, 'HR', 25000);
INSERT INTO Departments(DepartmentID, DepartmentName, MonthlyBudget) VALUES(4, 'Marketing', 20000);
INSERT INTO Departments(DepartmentID, DepartmentName, MonthlyBudget) VALUES(5, 'Customer Service', 2000);
INSERT INTO Departments(DepartmentID, DepartmentName, MonthlyBudget) VALUES(6, 'Regulatory Affairs', 5000);

--TRUNCATE TABLE Employees;
INSERT INTO Employees(EmployeeID, EmployeeFirstName, EmployeeLastName, BirthDate, MonthlyIncome, DepartmentID, HireDate, JobID, EmailAddress)
    VALUES (14, 'John', 'Smith', DATE '1995-01-01', 8000, 1, DATE '2010-01-01', 'Administrator', 'john@gmail.com');
INSERT INTO Employees(EmployeeID, EmployeeFirstName, EmployeeLastName, BirthDate, MonthlyIncome, DepartmentID, HireDate, JobID, EmailAddress)
    VALUES (15, 'Wezley', 'Singleton', DATE '1900-01-01', 8000, 1, DATE '2000-01-01', 'Trainer', 'wez@gmail.com');
INSERT INTO Employees(EmployeeID, EmployeeFirstName, EmployeeLastName, BirthDate, MonthlyIncome, DepartmentID, HireDate, JobID, EmailAddress)
    VALUES (16, 'Emily', 'Chachula', DATE '1900-01-01', 8000, 2, DATE '2000-01-01', 'Doer', 'emily@gmail.com');
INSERT INTO Employees(EmployeeID, EmployeeFirstName, EmployeeLastName, BirthDate, MonthlyIncome, DepartmentID, HireDate, JobID, EmailAddress)
    VALUES (17, 'Aaron', 'Matthews', DATE '1900-01-01', 8000, 3, DATE '2100-01-01', 'Thinker', 'aaron@gmail.com');
INSERT INTO Employees(EmployeeID, EmployeeFirstName, EmployeeLastName, BirthDate, MonthlyIncome, DepartmentID, HireDate, JobID, EmailAddress)
    VALUES (18, 'Andrew', 'Li', DATE '1900-01-01', 8000, 3, DATE '1800-01-01', 'Maker', 'andrew@gmail.com');
INSERT INTO Employees(EmployeeID, EmployeeFirstName, EmployeeLastName, BirthDate, MonthlyIncome, DepartmentID, HireDate, JobID, EmailAddress)
    VALUES (19, 'Bradley', 'Walker', DATE '1900-01-01', 8000, 2, DATE '2000-01-01', 'Writer', 'bradley@gmail.com');


INSERT INTO employees VALUES (1, 'JOHN', 'SMITH', date '1995-01-01', 4000.00, 1, date '2015-03-28', 'AC_ACCOUNT', 'JSMITH');
INSERT INTO employees VALUES (2, 'JAMES', 'BOSH', date '1992-02-15', 3500.00, 2, date '2014-07-01', 'MK_REP', 'JBOSH');
INSERT INTO employees VALUES (3, 'LUISA', 'JACKSON', date '1970-03-08', 4500.00, 3, date '2013-08-29', 'IT_PROG', 'LJACKSON');
INSERT INTO employees VALUES (4, 'STUART', 'GARCIA', date '1965-04-12', 2000.00, 4, date '2010-02-15', 'HR_REP', 'SGARCIA');
INSERT INTO employees VALUES (5, 'JUSTIN', 'BLACK', date '1990-05-16', 2550.00, 1, date '2015-05-02', 'AC_ACCOUNT', 'JBLACK');
INSERT INTO employees VALUES (6, 'ANGIE', 'CROOD', date '1998-06-22', 1500.00, 1, date '2015-07-01', 'AC_ACCOUNT', 'ACROOD');
INSERT INTO employees VALUES (7, 'CHARLES', 'DEAN', date '1973-06-08', 2250.00, 3, date '2002-03-01', 'IT_PROG', 'CDEAN');
INSERT INTO employees VALUES (8, 'EDDIE', 'FARREL', date '1980-07-28', 3000.00, 1, date '2009-04-20', 'AC_ACCOUNT', 'EFARREL');
INSERT INTO employees VALUES (9, 'GEORGE', 'HAYES', date '1982-08-03', 2500.00, 2, date '2012-09-22', 'MK_REP', 'GHAYES');
INSERT INTO employees VALUES (10, 'IGOR', 'OSBOURNE', date '1987-09-11', 6000.00, 3, date '2014-11-14', 'IT_PROG', 'IKEYS');
INSERT INTO employees VALUES (11, 'LUKE', 'MINT', date '1985-10-19', 5000.00, 4, date '2011-01-08', 'HR_REP', 'LMINT');
INSERT INTO employees VALUES (12, 'NIGEL', 'OAKS', date '1997-11-05', 4750.00, 4, date '2014-10-01', 'HR_REP', 'NOAKS');
INSERT INTO employees VALUES (13, 'LUKE', 'GREEN', date '1995-02-05', 4750.00, 4, date '2015-09-01', 'HR_REP', 'LGREEN');

--COMMIT;
--DELETE FROM Employees;
--ROLLBACK;




CREATE USER tester              -- Sets the username for a new user
IDENTIFIED BY p4ssw0rd          -- Sets the password for the new user
DEFAULT TABLESPACE users        -- Defines a default tablespace
TEMPORARY TABLESPACE temp       -- Defines a temporary tablespace
QUOTA 10M ON users;             -- Establishes a row quota for the table space

/*
    Tablespaces
    
    An Oracle database consists of one or more logical storage units called 
    tablespaces, which collectively store all of the database's data.

    Each tablespace in an Oracle database consists of one or more files called 
    datafiles, which are physical structures that conform to the operating 
    system in which Oracle is running.

    A database's data is collectively stored in the datafiles that constitute 
    each tablespace of the database.
*/

GRANT CONNECT TO tester;                -- Necessary to be able to connect to the DB
GRANT RESOURCE TO tester;               -- Necessary to access DB resources
GRANT CREATE SESSION TO tester;         -- Necessary to be able to create DB sessions
GRANT CREATE TABLE TO tester;           -- Necessary to be able to create tables
GRANT CREATE VIEW TO tester;            -- Necessary to be able to create views

/*
    Tables vs Views
    
    A table contains data, a view simply a virtual table created from some previous 
    SELECT query. The advantage of a view is that it can join data from several tables 
    thus creating a new view of it. 
    
    Say you have a database with salaries and you need to do some complex statistical 
    queries on it. Instead of sending the complex query to the database all the time, 
    you can save the query as a view and then SELECT * FROM view.
*/
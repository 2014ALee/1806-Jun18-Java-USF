CREATE USER matneyka                        -- Sets the username for a new user
IDENTIFIED BY k                        -- Sets the password for the new user
DEFAULT TABLESPACE users                    -- Defines a default tablespace for the new user
TEMPORARY TABLESPACE temp                   -- Defines a temporary tablespace for teh new user
QUOTA 10M ON users;                         -- Establishes a row quota for the tablespace

/*

    Tablespaces
*/

GRANT CONNECT TO  matneyka;                 -- Necessary for the user to connect to the DB
GRANT RESOURCE TO matneyka;                 -- Gives the user access to DB resources
GRANT CREATE SESSION TO matneyka;           -- Allows the user the ability to create DB sesions
GRANT CREATE TABLE TO matneyka;             -- Allows the user the ability to create tables within their tablespace
GRANT CREATE VIEW  TO matneyka;             -- Allows the usre the ability to create view ithin their tablespace

/*
    Tabs vs Views
    
    Notes to go here
*/
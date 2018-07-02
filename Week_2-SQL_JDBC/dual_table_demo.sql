/*
    The DUAL table is a special one-column, one-row table that is present 
    in all Oracle databases. It has a single column called "DUMMY" which 
    has a value of "X".
*/
SELECT * FROM dual;

/*
    This table will be used to test functions or retrieve constant values 
    that don't come from any table in the DB, like the system date:
*/
SELECT sysdate FROM dual;

-- Understanding SQL errors (ORA errors)
SELECT sysdate FROM dualy;

-- Syntactically correct, logically flawed (we cannot covert "X" to a number)
SELECT to_number(dummy) FROM dual;

SELECT CURRENT_TIMESTAMP
FROM DUAL;
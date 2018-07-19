--CREATE TABLE customers(
--    username VARCHAR(40) PRIMARY KEY,
--    password VARCHAR(40) NOT NULL,
--    balance NUMBER(14,2)
--    )
    
SELECT COUNT(*)
FROM customers;

SELECT *
FROM customers
ORDER BY username ASC;

DELETE 
FROM customers
WHERE username = 'Khaleel';

INSERT INTO customers VALUES ('khaleel','password',0);
commit;

CREATE OR REPLACE PROCEDURE getUser(
    user_name IN CUSTOMERS.USERNAME%TYPE,
    my_cursor OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN my_cursor FOR
    SELECT *
    FROM customers
    WHERE username = user_name;
END;
/
    
CREATE OR REPLACE FUNCTION getTotal
    RETURN NUMBER
AS
    counter NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO counter
    FROM customers;
    
    RETURN counter;
END;
/
DECLARE 
    cu NUMBER;
BEGIN
    cu := getCount;
    DBMS_OUTPUT.PUT_LINE('Number of customer = ' || cu);
END;
/
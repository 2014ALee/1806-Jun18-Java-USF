-- pls/sql demo
-- STORED FUNCTIONS AND PROCEDURES

CREATE OR REPLACE FUNCTION get_max_id
    RETURN NUMBER
AS
    max_id NUMBER;

BEGIN
    SELECT MAX(artistid)
    INTO max_id
    FROM artist;
    
    RETURN max_id;
END;
/


-- Calling the function
DECLARE
    max_id NUMBER;
BEGIN
    max_id := get_max_id();
    DBMS_OUTPUT.PUT_LINE('The max id in the artist table is: ' || max_id);
END;
/

--  THIS WILL remove the function
DROP FUNCTION get_max_id ;

-- Create a function that returns all employees who are born after 1968
CREATE OR REPLACE FUNCTION after_1968
    RETURN SYS_REFCURSOR
IS
    my_cursor SYS_REFCURSOR;
BEGIN
    OPEN my_cursor FOR
    SELECT firstname, lastname, birthdate
      FROM employee
     WHERE birthdate > DATE '1968-12-31';
     
     RETURN my_cursor; -- this function returns a sysref cursor, so return our declared cursor
END;
/

-- Using dual table to invoke stored function
SELECT after_1968()
  FROM dual;

-- creat a procedure that return all the artists in the artist table
CREATE OR REPLACE PROCEDURE get_all_artists(my_cursor OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN my_cursor FOR
    SELECT artistid, name
    FROM artist
    ORDER BY artistid;
END;
/

-- invoke 
DECLARE 
    -- make sure data types are same
    artist_id ARTIST.ARTISTID%TYPE;
    artist_name ARTIST.NAME%TYPE;
    my_cursor SYS_REFCURSOR;
BEGIN
    get_all_artists(my_cursor);
    
    LOOP
        FETCH my_cursor                 -- fetch the next record stored in my_cursor
        INTO artist_id, artist_name;    -- puth the values in my_cursor into these variables
        
        EXIT WHEN my_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Artist id: ' || artist_id || ' Artist Name: ' || artist_name);
    END LOOP;
    CLOSE my_cursor;    
END;
/

-- Creating an index on our employee table
CREATE INDEX emp_index ON employee (employeeid, firstname, lastname);

--use an index(dbms just  recognizes that this matches an index)
SELECT employeeid, firstname, lastname
FROM employee;

-- SEQUENCES(rule that allows us to automatically inc or dec our primary key
-- UNFORTUNATELY WE HAVE TO DO THIS FOR EVERY TABLE, ORACLE DOESN'T AUTO INCREMENT

-- create a sequence that will be used to increment ok in artist table
CREATE SEQUENCE art_seq
MINVALUE 1
MAXVALUE 99999999
INCREMENT BY 1
START WITH 276;

-- create trigger that will use art_seq whenever a new row is inserted
CREATE OR REPLACE TRIGGER art_trigger
BEFORE INSERT ON artist
FOR EACH ROW 
BEGIN
    SELECT art_seq.NEXTVAL  -- get the next value from our sequence
    INTO :new.artistid      -- put the value into the artistid field of the new row  being inserted
    FROM dual;              -- need to use dual because we are not getting the value from any table
END;
/




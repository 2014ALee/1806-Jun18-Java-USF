-- Function: Max ID from the artist table
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

-- Invoke the get_max_id stored function
DECLARE
    max_id NUMBER;
BEGIN
    max_id := get_max_id();
    DBMS_OUTPUT.PUT_LINE('The max id in the artist table is: ' || max_id);
END;
/

-- Remove the stored function get_max_id
DROP FUNCTION get_max_id;

-- Create a function that returns all employees who are born after 1968
-- Working with an explicit cursor
CREATE OR REPLACE FUNCTION after_1968
    RETURN SYS_REFCURSOR
IS
    my_cursor SYS_REFCURSOR;
BEGIN
    OPEN my_cursor FOR  -- The result set returned by the query below is stored in our declared cursor
    SELECT firstname, lastname, birthdate
    FROM employee
    WHERE birthdate > DATE '1968-12-31';
    
    RETURN my_cursor;    -- This function returns a SYS_REFCURSOR, so return our declared cursor

END;
/

-- Using the dual table to invoke our stored function
SELECT after_1968()
FROM dual;

-- Procedure: Returns all the artists in the artist
CREATE OR REPLACE PROCEDURE get_all_artists(
    my_cursor OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN my_cursor FOR
    SELECT artistid, name
    FROM artist
    ORDER BY artistid;
END;
/

DECLARE
    artist_id       ARTIST.ARTISTID%TYPE;
    artist_name     ARTIST.NAME%TYPE;
    my_cursor       SYS_REFCURSOR;
BEGIN
    get_all_artists(my_cursor);
    
    LOOP
        FETCH my_cursor                 -- fetch the next record stored in my_cursor
        INTO artist_id, artist_name;    -- put the values in my_cursor into these variables
        
        EXIT WHEN my_cursor%NOTFOUND;   -- exit this loop when there are no more records in my_cursor
        DBMS_OUTPUT.PUT_LINE('Artist Id: ' || artist_id || ', Artist name: ' || artist_name);   -- output
    END LOOP;
    CLOSE my_cursor;    -- good practice dictates that we close cursors when we are done with them
END;
/

/*
    Indexes
*/

-- Creating an index on the employee table
CREATE INDEX emp_index ON employee (employeeid, firstname, lastname);

-- Create sequence that will be used to increment primary keys in the artist table
CREATE SEQUENCE art_seq
MINVALUE 1
MAXVALUE 9999999999
INCREMENT BY 1
START WITH 276;

-- Create a trigger that will use art_seq whenever a new row is inserted
CREATE OR REPLACE TRIGGER art_trigger
BEFORE INSERT ON artist         -- the logic of this trigger will execute BEFORE any insert on the artist table
FOR EACH ROW                    -- it will do the logic for each row inserted

BEGIN
    SELECT art_seq.NEXTVAL      -- get the next value from our sequence
    INTO :new.artistid          -- put that value into the artistid field of the row being inserted
    FROM dual;                  -- need to use dual because we are not getting the value from any table
END;
/

INSERT INTO artist (name) VALUES ('Megadeth');      -- adds the row with artistid = 276
INSERT INTO artist (name) VALUES ('Trans-Siberian Orchestra'); -- adds the row with artistid = 277
INSERT INTO artist VALUES (300, 'Evanescence'); -- even if we provide a PK value, the sequence overrides it
-- FUNCTION: Max ID from the artist table
CREATE OR REPLACE FUNCTION get_max_id
    RETURN NUMBER
AS
    max_id NUMBER;
BEGIN
    SELECT MAX(ARTISTID)
    INTO max_id
    FROM ARTIST;
    
    RETURN max_id;
END get_max_id;
/

-- Invoke the function
DECLARE
    max_id NUMBER;
BEGIN
    max_id := get_max_id();
    DBMS_OUTPUT.PUT_LINE('The max_id in the artist table is: ' || max_id);
END;
/

-- To remove a function
--DROP FUNCTION get_max_id;


--Task – Create a function that returns all employees who are born after 1968.
    -- Using an explicit cursor
CREATE OR REPLACE FUNCTION born_after_1968
    RETURN SYS_REFCURSOR                                -- Functions can only return one thing, so we must store multiple returns as a single cursor
IS
    my_cursor SYS_REFCURSOR;
BEGIN
    OPEN my_cursor FOR
    SELECT FIRSTNAME, LASTNAME
    FROM EMPLOYEE
    WHERE BIRTHDATE > DATE '1968-12-31';
    
    RETURN my_cursor;
END;
/
-- Using the dual table to invoke our stored function
SELECT born_after_1968()
FROM dual;



-- Procedure: Returns all the artist in the artist table
CREATE OR REPLACE PROCEDURE get_all_artists (
    my_cursor OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN my_cursor FOR
    SELECT ARTISTID, NAME
    FROM ARTIST
    ORDER BY ARTISTID;
END;
/

DECLARE
    artist_id       ARTIST.ARTISTID%TYPE;
    artist_name     ARTIST.NAME%TYPE;
    my_cursor       SYS_REFCURSOR;
BEGIN 
    get_all_artists(my_cursor);
    
    LOOP
        FETCH my_cursor                 -- Fetch the next record in my_cursor
        INTO artist_id, artist_name;    -- Put these values into these variables
        
        EXIT WHEN my_cursor%NOTFOUND;   -- Exit this loop when there are no more records in my_cursor
        DBMS_OUTPUT.PUT_LINE('Artist Id: ' || artist_id || ', Artist Name: ' || artist_name);
    END LOOP;
    CLOSE my_cursor;                    -- Good practice dictates that we close my_cursor
END;
/


/*
    Index Notes will go here
    -- Used behind the scenes to optimize queries
*/

-- Create an index on our employee table
CREATE INDEX emp_index
ON EMPLOYEE (EMPLOYEEID, FIRSTNAME, LASTNAME);

-- Can now query on the associated table
SELECT EMPLOYEEID, FIRSTNAME, LASTNAME
FROM EMPLOYEE;



/*
    Sequences and Triggers
*/
CREATE SEQUENCE art_seq
MINVALUE 1
MAXVALUE 9999999999
INCREMENT BY 1
START WITH 276;

-- Create a trigger that will use art_seq when ever a new row is inserted
CREATE OR REPLACE TRIGGER art_trigger
BEFORE INSERT ON ARTIST             -- the logic of hte trigger will execute BEFORE any insert on the artist table
FOR EACH ROW                        -- it will do the logic for each row

BEGIN
    SELECT art_seq.NEXTVAL          -- get the next value form our sequence
    INTO :new.artistid              -- put taht vlue into the artistid field of the row being inserted
    FROM dual;                      -- need to use dual because we are not getting the value from any table
END;
/

INSERT INTO ARTIST (name) VALUES('Kenny Loggins');
INSERT INTO ARTIST VALUES (300, 'Evanescence'); -- Even if we provide a PK value, the seqence will override it 
-- Function: Max ID from the artist table
CREATE or REPLACE FUNCTION get_max_id
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

-- INVOKE the get_max_id function
DECLARE
    max_id NUMBER;
BEGIN
    max_id := get_max_id();
    DBMS_OUTPUT.PUT_LINE('The max id in the artist table is: ' || max_id);
END;
/

-- DROP FUNCTION get_max_id;

-- 3.4 from workbook done together

CREATE OR REPLACE PROCEDURE get_all_artists (
    my_cursor OUT SYS_REFCURSOR)
IS --
BEGIN
    OPEN my_cursor FOR
    SELECT artistid, name
    FROM artist
    ORDER BY artistid;
END;
/

-- If doesn't take any parameters
-- EXECUTE get_all_artists();

DECLARE 
    artist_id ARTIST.ARTISTID%TYPE;
    artist_name ARTIST.NAME%TYPE;
    my_cursor SYS_REFCURSOR;
BEGIN
    get_all_artists(my_cursor);
    
    LOOP
        FETCH my_cursor                     -- FETCH the next record stored in my cursor
        INTO artist_id,artist_name;         -- put the values in my_cursor in to these variables
        
        EXIT WHEN my_cursor%NOTFOUND;       -- exit this loop when there are no more records in my_cursor -- %
        
        DBMS_OUTPUT.PUT_LINE('Artist ID: ' || artist_id || ', Artist Name: ' || artist_name);
    END LOOP;
    CLOSE my_cursor;                        -- good practice dictates tate we close cursors when we are done with them
END;
/
/*
*/
-- Creating an index on employee table
CREATE INDEX emp_index
ON employee (employeeid, firstname, lastname);

-- Makes it faster
SELECT employeeid, firstname, lastname
FROM employee;

-- create sequence that will be used to increment primary keys in the artist table
CREATE SEQUENCE art_seq
MINVALUE 1
MAXVALUE 9999999
INCREMENT BY 1
START WITH 276;

-- Create a trigger taht will use art_seq whenever a new row is inserted
CREATE OR REPLACE TRIGGER art_trigger
BEFORE INSERT ON artist         -- the logic of this trigger will execute BEFORE any insert on the artist table
FOR EACH ROW                    -- it will do the logic for each row inserted

BEGIN
    SELECT art_seq.NEXTVAL   -- get the next value from our sequence
    INTO :new.artistid       -- putat the value into the artistid field fo the row being inserted
    FROM dual;               -- need to use dual because we are not getting the value from any table

END;
/

INSERT INTO artist(name) VALUES ('Megadeth');
INSERT INTO artist(name) VALUES ('Trans-Siberian Orchestra');
INSERT INto artist VALUES (280,'Evanescence'); -- Trigger will overwrite it
-- Functions
-- Max ID from the artist table
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

DECLARE
    max_id NUMBER;
BEGIN
    max_id := get_max_id();
    DBMS_OUTPUT.PUT_LINE('The max id in the artist table is: ' || max_id);
END;
/

-- Create a function that returns all employees born after 1968

CREATE OR REPLACE FUNCTION after_1968
    RETURN SYS_REFCURSOR
IS
    my_cursor SYS_REFCURSOR;
BEGIN
    OPEN my_cursor FOR -- the result set returned by the query is stored in the cursor
    SELECT firstname, lastname, birthdate
    FROM employee
    WHERE birthdate > DATE '1968-12-31';
    
    RETURN my_cursor;   -- this function returns a sys_refcursor
END;
/

-- Using the dual function to invoke our stored function
SELECT after_1968()
FROM dual;


-- Procedure: returns all artists in the artist table
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
    artist_id ARTIST.ARTISTID%TYPE; -- ensure the variable has the correct type
    artist_name ARTIST.NAME%TYPE;
    my_cursor SYS_REFCURSOR;
BEGIN
    get_all_artists(my_cursor);

    LOOP
        -- Get the next record in the cursor into the variables
        FETCH my_cursor
        INTO artist_id, artist_name;
        
        -- Exit when you rech the end of the result set
        EXIT WHEN my_cursor%NOTFOUND;
        
        -- If you haven't reached the end, output the results
        DBMS_OUTPUT.PUT_LINE('Artist ID: ' || artist_id || ', Artist Name: ' || artist_name);
    END LOOP;
    CLOSE my_cursor;
END;
/

-- Creating an index on the employee table

CREATE INDEX emp_index ON employee(employeeid, firstname, lastname);

SELECT employeeid, firstname, lastname
FROM employee;


-- Sequences and Triggers
-- This will be used to increment the primary key in the artist table
CREATE SEQUENCE art_seq
MINVALUE 1
MAXVALUE 999999999
INCREMENT BY 1
START WITH 276;

-- This trigger will use art_seq to increment the artist PK
CREATE OR REPLACE TRIGGER art_trigger
BEFORE INSERT ON artist     -- execute before insert
FOR EACH ROW                -- executes the logic for every row created

BEGIN
    SELECT art_seq.NEXTVAL  -- get the nex value in the sequence
    INTO :new.artistid      -- put it into the artistid for the new record
    FROM dual;              -- need to use dual because we aren't getting the value from any table
END;
/

INSERT INTO artist(name) VALUES('Megadeath');
INSERT INTO artist(name) VALUES('Trans-Siberian Orchestra');

CREATE OR REPLACE FUNCTION func_name([parameter (IN) Type])
    RETURN return_datatype
IS/AS
    -- variable to return
BEGIN
    -- stored function logic
END;
/

CREATE OR REPLACE PROCEDURE procedure_name
([parameter (IN, OUT, IN/OUT) Type])
IS/AS
    -- variable to return
BEGIN
    --stored procedure logic
 END;
 /
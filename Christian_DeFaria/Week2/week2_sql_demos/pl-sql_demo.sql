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
    max_id  NUMBER;
BEGIN
    max_id := get_max_id();
    DBMS_OUTPUT.PUT_LINE('The max_id in the artist table is: ' || max_id);
END;
/

CREATE OR REPLACE FUNCTION after_1968
    RETURN SYS_REFCURSOR
IS
    my_cursor   SYS_REFCURSOR;
BEGIN
    OPEN my_cursor FOR
    SELECT firstname, lastname, birthdate
    FROM employee
    WHERE birthdate > DATE '1968-12-31';
    
    RETURN my_cursor;
END;
/

SELECT after_1968()
FROM dual;

CREATE OR REPLACE PROCEDURE get_all_artists(
    my_cursor   OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN my_cursor FOR
    SELECT artistid, name
    FROM artist
    ORDER BY artistid;
END;
/

DECLARE
    artist_id   ARTIST.ARTISTID%TYPE;
    artist_name ARTIST.NAME%TYPE;
    my_cursor   SYS_REFCURSOR;
BEGIN
    get_all_artists(my_cursor);
    
    LOOP
        FETCH my_cursor
        INTO artist_id, artist_name;
        EXIT WHEN my_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Artist ID: ' || artist_id || ', Artist Name: ' || artist_name);
    END LOOP;
    CLOSE my_cursor;
END;
/

CREATE INDEX emp_index
ON employee (employeeid, firstname, lastname);

SELECT employeeid, firstname, lastname
FROM employee;

CREATE SEQUENCE art_seq
MINVALUE 1
MAXVALUE 9999999999
INCREMENT BY 1
START WITH 276;

CREATE OR REPLACE TRIGGER art_trigger
BEFORE INSERT ON artist
FOR EACH ROW

BEGIN
    SELECT art_seq.NEXTVAL
    INTO :new.artistid
    FROM dual;
END;
/













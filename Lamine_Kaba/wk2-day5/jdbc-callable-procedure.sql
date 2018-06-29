CREATE OR REPLACE PROCEDURE get_artist_albums(
    artist_id IN artist.artistid%type,
    my_cursor OUT SYS_REFCURSOR)
    
AS 
BEGIN
    OPEN my_cursor for
    SELECT *
    FROM album
    WHERE artistid = artist_id;
END;
/
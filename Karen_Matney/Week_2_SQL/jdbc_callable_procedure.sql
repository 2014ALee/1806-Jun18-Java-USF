-- Get all of the albums that belong to a given artist
CREATE OR REPLACE PROCEDURE get_artist_albums(
    artist_id IN ARTIST.ARTISTID%TYPE,
    album_cursor OUT SYS_REFCURSOR
    )
IS
BEGIN
    OPEN album_cursor FOR
    SELECT *
    FROM album
    WHERE artistid = artist_id;
END;
/
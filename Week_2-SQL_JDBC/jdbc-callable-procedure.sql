-- Get all of the albums that belong to a given artist
CREATE OR REPLACE PROCEDURE get_artist_albums(
    artist_id   IN  artist.artistid%TYPE,
    my_cursor   OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN my_cursor FOR
    SELECT *
    FROM album
    WHERE artistid = artist_id;
END;
/
--get all the albums that belong to the given artist
CREATE OR REPLACE PROCEDURE get_artist_albums (
artist_id IN artist.artistid%type,
my_cursor OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN my_cursor FOR 
    SELECT *
    FROM album
    WHERE artist_id = artistid;

    END get_artist_albums;
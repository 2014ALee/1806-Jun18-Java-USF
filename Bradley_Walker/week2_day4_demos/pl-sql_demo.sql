-- Functions
-- Max ID from the artist table
CREATE OR REPLACE FUNCTION get_max_id
    RETURN NUMBER
AS
    max_id NUMBER;
BEGIN
    SELECT MAX(artist_id)
    INTO max_id
    FROM artist;
    RETURN max_id;
END;
/
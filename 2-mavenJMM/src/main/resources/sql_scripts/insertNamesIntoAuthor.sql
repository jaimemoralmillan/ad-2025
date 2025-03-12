--insertar autores en authors
INSERT INTO authors (name)
SELECT DISTINCT author FROM books
WHERE author IS NOT NULL 
AND author NOT IN (SELECT name FROM authors);
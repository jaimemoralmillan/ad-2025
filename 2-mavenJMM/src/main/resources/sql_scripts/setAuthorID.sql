UPDATE books b
SET author_id = (SELECT id FROM author a WHERE a.name = b.author)
WHERE b.author IS NOT NULL;
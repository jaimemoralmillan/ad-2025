ALTER TABLE books 
ADD COLUMN author_id INT,
ADD CONSTRAINT fk_author FOREIGN KEY (author_id) REFERENCES author(id) ON DELETE CASCADE;

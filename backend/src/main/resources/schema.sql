CREATE TABLE IF NOT EXISTS todo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title varchar(255) NOT NULL,
    description CLOB,
    completed BOOLEAN NOT NULL
);
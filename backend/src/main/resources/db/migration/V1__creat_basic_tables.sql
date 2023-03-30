CREATE TABLE student
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    email      VARCHAR(50) NOT NULL,
    image      VARCHAR(50),
    course     VARCHAR(50),
    country    VARCHAR(50),
    city       VARCHAR(50)
);



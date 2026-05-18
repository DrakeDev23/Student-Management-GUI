CREATE DATABASE student_system;

USE student_system;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50),
    password VARCHAR(50)
);

INSERT INTO users(username, password)
VALUES('admin', 'admin123');

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fullname VARCHAR(100),
    course VARCHAR(100),
    year_level VARCHAR(20)
);
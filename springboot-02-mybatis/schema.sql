DROP DATABASE IF EXISTS springbootMybatis;
CREATE DATABASE springbootMybatis;
USE springbootMybatis;
DROP TABLE IF EXISTS author;
CREATE TABLE author (
    id INT(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL DEFAULT 'UNKNOWN',
    dob DATE NOT NULL,
    gender INT(11) DEFAULT 0,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS book;
CREATE TABLE book (
    id INT(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL DEFAULT 'SOME_BOOK',
    description VARCHAR(100) NOT NULL DEFAULT 'The author is too lazy to leave any description',
    publication_date DATE NOT NULL,
    author_id INT(11) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FOREIGN KEY (author_id) REFERENCES author(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
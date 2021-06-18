DROP DATABASE IF EXISTS springbootSpringSecurity;
CREATE DATABASE springbootSpringSecurity;
USE springbootSpringSecurity;

DROP TABLE IF EXISTS user;
CREATE TABLE user (
    id INT(11) NOT NULL AUTO_INCREMENT,
    username VARCHAR(20)    UNIQUE NOT NULL,
    password VARCHAR(64) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS role;
CREATE TABLE role (
    id INT(11) NOT NULL AUTO_INCREMENT,
    role_name VARCHAR(20) UNIQUE NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS user_role;
CREATE TABLE user_role (
    user_id INT(11) NOT NULL,
    role_id INT(11) NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (role_id) REFERENCES role(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS operation;
CREATE TABLE operation (
    id INT(11) NOT NULL,
    op_name VARCHAR(20) UNIQUE  NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS role_operation;
CREATE TABLE role_operation (
    role_id INT(11) NOT NULL,
    operation_id INT(11) NOT NULL,
    PRIMARY KEY (role_id, operation_id),
    FOREIGN KEY (role_id) REFERENCES role(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (operation_id) REFERENCES operation(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

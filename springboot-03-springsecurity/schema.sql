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
    CONSTRAINT FOREIGN KEY (user_id) REFERENCES user(id),
    CONSTRAINT FOREIGN KEY (role_id) REFERENCES role(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS action;
CREATE TABLE action (
    id INT(11) NOT NULL,
    name VARCHAR(20) UNIQUE  NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS role_action;
CREATE TABLE role_action (
    role_id INT(11) NOT NULL,
    action_id INT(11) NOT NULL,
    PRIMARY KEY (role_id, action_id),
    CONSTRAINT FOREIGN KEY (role_id) REFERENCES role(id),
    CONSTRAINT FOREIGN KEY (action_id) REFERENCES action(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

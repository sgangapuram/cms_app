CREATE TABLE IF NOT EXISTS  Customer
(
    custId int(11) NOT NULL AUTO_INCREMENT,
    custFName varchar(100) NOT NULL,
    custLName varchar(100) NOT NULL,
    custEmail varchar(100) DEFAULT NULL,
    PRIMARY KEY (custId)
);

CREATE TABLE  IF NOT EXISTS Users
(
    id int(11) NOT NULL AUTO_INCREMENT,
    name varchar(100) NOT NULL,
    email varchar(100) DEFAULT NULL,
    PRIMARY KEY (id)
);
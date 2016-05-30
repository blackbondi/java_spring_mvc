CREATE SCHEMA `webshop`;

CREATE TABLE `webshop`.seller (
    id INT NOT NULL auto_increment, 
    name VARCHAR(50) NOT NULL,
    personnelNumber VARCHAR(30) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE `webshop`.product (
    id INT NOT NULL auto_increment, 
    name VARCHAR(50) NOT NULL,
    number VARCHAR(30) NOT NULL UNIQUE,
    count INT NOT NULL DEFAULT 0,
    PRIMARY KEY (id)
);
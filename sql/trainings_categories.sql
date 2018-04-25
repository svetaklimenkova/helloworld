CREATE TABLE trainings.categories
(
    categoryId int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    categoryName varchar(50) NOT NULL
);
INSERT INTO trainings.categories (categoryName) VALUES ('Саморазвитие');
INSERT INTO trainings.categories (categoryName) VALUES ('Языки');
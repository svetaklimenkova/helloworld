CREATE TABLE trainings.roles
(
    roleId int(11) PRIMARY KEY NOT NULL,
    roleName varchar(45) NOT NULL
);
INSERT INTO trainings.roles (roleId, roleName) VALUES (1, 'ROLE_ADMIN');
INSERT INTO trainings.roles (roleId, roleName) VALUES (2, 'ROLE_TRAINER');
INSERT INTO trainings.roles (roleId, roleName) VALUES (3, 'ROLE_USER');
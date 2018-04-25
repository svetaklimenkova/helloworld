CREATE TABLE trainings.users
(
    userId int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username varchar(32) NOT NULL,
    password varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    roleId int(11) NOT NULL,
    isConfirmed tinyint(1) NOT NULL,
    CONSTRAINT fk_user_role FOREIGN KEY (roleId) REFERENCES roles (roleId)
);
CREATE UNIQUE INDEX email_UNIQUE ON trainings.users (email);
CREATE INDEX fk_user_role_idx ON trainings.users (roleId);
INSERT INTO trainings.users (username, password, email, roleId, isConfirmed) VALUES ('admin', '$2a$10$XkSKLT38rkmmHOJxCh1tQOPKbR7VWwzZ0ZJS5ep3G9TWoSdknASEK', 'svetaklimenkova@mail.ru', 1, 1);
INSERT INTO trainings.users (username, password, email, roleId, isConfirmed) VALUES ('user', '$2a$10$SxnV/5PPGLQUKjFUXyqh1.1lTjwKSOwUzwyyR0Pi9Ly8oN9NIuWBG', 'user@mail.ru', 3, 1);
INSERT INTO trainings.users (username, password, email, roleId, isConfirmed) VALUES ('trainer', '$2a$10$XkSKLT38rkmmHOJxCh1tQOPKbR7VWwzZ0ZJS5ep3G9TWoSdknASEK', 'trainer@mail.ru', 2, 1);
INSERT INTO trainings.users (username, password, email, roleId, isConfirmed) VALUES ('trainer1', '$2a$10$imDPfd.qB94H9C0E18F/GuSZa9DLLjVwSuAnfYVRZZojdlnZQG7dG', 'trainer1@mail.ru', 2, 1);
INSERT INTO trainings.users (username, password, email, roleId, isConfirmed) VALUES ('trainer3', '$2a$10$x.yh5pjQlrinWZxW63GkAesTin6jv9hodypVvJx7Ixe6sbN83s//i', 'trainer3@mail.ru', 2, 1);
INSERT INTO trainings.users (username, password, email, roleId, isConfirmed) VALUES ('trainer4', '$2a$10$UM/KqCuzgGmlJQJpGobkZOxCrADUTUithSXKNg401PqzLxOu2k6GK', 'trainer4@MAIL.RU', 2, 1);
INSERT INTO trainings.users (username, password, email, roleId, isConfirmed) VALUES ('user3', '$2a$10$zT3HJ5.FMlsWU7uPAtYBSep/yu.55zsSO96H7lYkHr./wKXo0sYdK', 'user3@mail.ru', 3, 1);
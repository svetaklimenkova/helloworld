CREATE TABLE trainings.applicationtype
(
    applicationTypeId int(11) PRIMARY KEY NOT NULL,
    applicationTypeName varchar(45)
);
INSERT INTO trainings.applicationtype (applicationTypeId, applicationTypeName) VALUES (1, 'TRAINER');
INSERT INTO trainings.applicationtype (applicationTypeId, applicationTypeName) VALUES (2, 'PASSWORD');
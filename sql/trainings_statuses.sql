CREATE TABLE trainings.statuses
(
    statusId int(11) PRIMARY KEY NOT NULL,
    statusName varchar(255)
);
INSERT INTO trainings.statuses (statusId, statusName) VALUES (1, 'IN_PROGRESS');
INSERT INTO trainings.statuses (statusId, statusName) VALUES (2, 'ACCEPTED');
INSERT INTO trainings.statuses (statusId, statusName) VALUES (3, 'REJECTED');
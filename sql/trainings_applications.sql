CREATE TABLE trainings.applications
(
    applicationId int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    description text NOT NULL,
    userId int(11) NOT NULL,
    statusId int(11) NOT NULL,
    applicationTypeId int(11) NOT NULL,
    createdBy datetime,
    updatedBy datetime,
    CONSTRAINT fk_application_user FOREIGN KEY (userId) REFERENCES users (userId),
    CONSTRAINT fk_application_status FOREIGN KEY (statusId) REFERENCES statuses (statusId),
    CONSTRAINT fk_application_type FOREIGN KEY (applicationTypeId) REFERENCES applicationtype (applicationTypeId)
);
CREATE INDEX fk_application_status_idx ON trainings.applications (statusId);
CREATE INDEX fk_application_type_idx ON trainings.applications (applicationTypeId);
CREATE INDEX fk_application_user_idx ON trainings.applications (userId);
INSERT INTO trainings.applications (description, userId, statusId, applicationTypeId, createdBy, updatedBy) VALUES ('Just want to be a trainer', 7, 2, 1, null, null);
INSERT INTO trainings.applications (description, userId, statusId, applicationTypeId, createdBy, updatedBy) VALUES ('bhnpikrfs;vgk''[as', 8, 2, 1, null, '2018-04-20 12:02:38');
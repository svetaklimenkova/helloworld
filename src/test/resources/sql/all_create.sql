DROP TABLE IF EXISTS `taskstatuses`;
CREATE TABLE `taskstatuses` (
  `taskStatusId` int(11) NOT NULL,
  `taskStatusName` varchar(45) NOT NULL,
  PRIMARY KEY (`taskStatusId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `statuses`;
CREATE TABLE `statuses` (
  `statusId` int(11) NOT NULL,
  `statuseName` varchar(45) NOT NULL,
  PRIMARY KEY (`statusId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `roleId` int(11) NOT NULL,
  `roleName` varchar(45) NOT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `applicationtype`;
CREATE TABLE `applicationtype` (
  `applicationTypeId` int(11) NOT NULL,
  `applicationTypeName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`applicationTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories` (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(50) NOT NULL,
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `password` varchar(255),
  `email` varchar(255) NOT NULL,
  `roleId` int(11) NOT NULL,
  `isConfirmed` tinyint(1) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  FOREIGN KEY (`roleId`) REFERENCES `roles` (`roleId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `trainings`;
CREATE TABLE `trainings` (
  `trainingId` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(52) NOT NULL,
  `description` text NOT NULL,
  `categoryId` int(11) DEFAULT NULL,
  `forWhom` varchar(255) NOT NULL,
  `goal` varchar(255) NOT NULL,
  `maxParticipants` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`trainingId`),
  FOREIGN KEY (`categoryId`) REFERENCES `categories` (`categoryId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY (`userId`) REFERENCES `users` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `stages`;
CREATE TABLE `stages` (
  `stageId` int(11) NOT NULL,
  `stageName` varchar(128) NOT NULL,
  `trainingId` int(11) NOT NULL,
  PRIMARY KEY (`stageId`),
  FOREIGN KEY (`trainingId`) REFERENCES `trainings` (`trainingId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `tasks`;
CREATE TABLE `tasks` (
  `taskId` int(11) NOT NULL,
  `taskName` varchar(255) NOT NULL,
  `stageId` int(11) NOT NULL,
  PRIMARY KEY (`taskId`),
  CONSTRAINT `fk_stage_task` FOREIGN KEY (`stageId`) REFERENCES `stages` (`stageId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `applications`;
CREATE TABLE `applications` (
  `applicationId` int(11) NOT NULL AUTO_INCREMENT,
  `description` text NOT NULL,
  `userId` int(11) NOT NULL,
  `statusId` int(11) NOT NULL,
  `applicationTypeId` int(11) NOT NULL,
  PRIMARY KEY (`applicationId`),
  CONSTRAINT `fk_application_status` FOREIGN KEY (`statusId`) REFERENCES `statuses` (`statusId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_application_type` FOREIGN KEY (`applicationTypeId`) REFERENCES `applicationtype` (`applicationTypeId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_application_user` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `reports`;
CREATE TABLE `reports` (
  `reportId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `taskId` int(11) NOT NULL,
  `message` text NOT NULL,
  `statusId` int(11) NOT NULL,
  PRIMARY KEY (`reportId`),
  CONSTRAINT `fk_report_status` FOREIGN KEY (`statusId`) REFERENCES `statuses` (`statusId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_report_task` FOREIGN KEY (`taskId`) REFERENCES `tasks` (`taskId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_report_user` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `participantstasks`;
CREATE TABLE `participantstasks` (
  `taskId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `taskStatusId` int(11) NOT NULL,
  CONSTRAINT `fk_task_task` FOREIGN KEY (`taskId`) REFERENCES `tasks` (`taskId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_taskstatus_taskstatus` FOREIGN KEY (`taskStatusId`) REFERENCES `taskstatuses` (`taskStatusId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_user` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO roles (roleId, roleName) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (roleId, roleName) VALUES (2, 'ROLE_TRAINER');
INSERT INTO roles (roleId, roleName) VALUES (3, 'ROLE_USER');

INSERT INTO statuses (statusId, statuseName) VALUES (1, 'IN_PROGRESS');
INSERT INTO statuses (statusId, statuseName) VALUES (2, 'ACCEPTED');
INSERT INTO statuses (statusId, statuseName) VALUES (3, 'REJECTED');

INSERT INTO applicationtype (applicationTypeId, applicationTypeName) VALUES (1, 'TRAINER');
INSERT INTO applicationtype (applicationTypeId, applicationTypeName) VALUES (2, 'PASSWORD');

INSERT INTO users (userId, username, email, roleId, isConfirmed) VALUES (1, 'test_user 1', 'test1@mail.ru', 3, 1);
INSERT INTO users (userId, username, email, roleId, isConfirmed) VALUES (2, 'test_user 2', 'test2@mail.ru', 3, 1);

INSERT INTO categories (categoryId, categoryName) VALUES (1, 'test category 1');
INSERT INTO categories (categoryId, categoryName) VALUES (2, 'test category 2');

INSERT INTO applications (applicationId, description, userId, statusId, applicationTypeId)
  VALUES (1, 'test 1', 1, 1, 1);
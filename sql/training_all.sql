CREATE DATABASE  IF NOT EXISTS `trainings` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `trainings`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: trainings
-- ------------------------------------------------------
-- Server version	5.7.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `applications`
--

DROP TABLE IF EXISTS `applications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `applications` (
  `applicationId` int(11) NOT NULL AUTO_INCREMENT,
  `description` text NOT NULL,
  `userId` int(11) NOT NULL,
  `statusId` int(11) NOT NULL,
  `applicationTypeId` int(11) NOT NULL,
  PRIMARY KEY (`applicationId`),
  KEY `fk_application_user_idx` (`userId`),
  KEY `fk_application_status_idx` (`statusId`),
  KEY `fk_application_type_idx` (`applicationTypeId`),
  CONSTRAINT `fk_application_status` FOREIGN KEY (`statusId`) REFERENCES `statuses` (`statusId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_application_type` FOREIGN KEY (`applicationTypeId`) REFERENCES `applicationtype` (`applicationTypeId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_application_user` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applications`
--

LOCK TABLES `applications` WRITE;
/*!40000 ALTER TABLE `applications` DISABLE KEYS */;
/*!40000 ALTER TABLE `applications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `applicationtype`
--

DROP TABLE IF EXISTS `applicationtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `applicationtype` (
  `applicationTypeId` int(11) NOT NULL,
  `applicationTypeName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`applicationTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applicationtype`
--

LOCK TABLES `applicationtype` WRITE;
/*!40000 ALTER TABLE `applicationtype` DISABLE KEYS */;
/*!40000 ALTER TABLE `applicationtype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categories` (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(50) NOT NULL,
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participantstasks`
--

DROP TABLE IF EXISTS `participantstasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `participantstasks` (
  `taskId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `taskStatusId` int(11) NOT NULL,
  KEY `fk_task_task_idx` (`taskId`),
  KEY `fk_user_user_idx` (`userId`),
  KEY `fk_taskstatus_taskstatus_idx` (`taskStatusId`),
  CONSTRAINT `fk_task_task` FOREIGN KEY (`taskId`) REFERENCES `tasks` (`taskId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_taskstatus_taskstatus` FOREIGN KEY (`taskStatusId`) REFERENCES `taskstatuses` (`taskStatusId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_user` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participantstasks`
--

LOCK TABLES `participantstasks` WRITE;
/*!40000 ALTER TABLE `participantstasks` DISABLE KEYS */;
/*!40000 ALTER TABLE `participantstasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reports`
--

DROP TABLE IF EXISTS `reports`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reports` (
  `reportId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `taskId` int(11) NOT NULL,
  `message` text NOT NULL,
  `statusId` int(11) NOT NULL,
  PRIMARY KEY (`reportId`),
  KEY `fk_report_status_idx` (`statusId`),
  KEY `fk_report_user_idx` (`userId`),
  KEY `fk_report_task_idx` (`taskId`),
  CONSTRAINT `fk_report_status` FOREIGN KEY (`statusId`) REFERENCES `statuses` (`statusId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_report_task` FOREIGN KEY (`taskId`) REFERENCES `tasks` (`taskId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_report_user` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reports`
--

LOCK TABLES `reports` WRITE;
/*!40000 ALTER TABLE `reports` DISABLE KEYS */;
/*!40000 ALTER TABLE `reports` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `roleId` int(11) NOT NULL,
  `roleName` varchar(45) NOT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_TRAINER'),(3,'ROLE_USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stages`
--

DROP TABLE IF EXISTS `stages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stages` (
  `stageId` int(11) NOT NULL,
  `stageName` varchar(128) NOT NULL,
  `trainingId` int(11) NOT NULL,
  PRIMARY KEY (`stageId`),
  KEY `fk_training_stage_idx` (`trainingId`),
  CONSTRAINT `fk_training_stage` FOREIGN KEY (`trainingId`) REFERENCES `trainings` (`trainingId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stages`
--

LOCK TABLES `stages` WRITE;
/*!40000 ALTER TABLE `stages` DISABLE KEYS */;
/*!40000 ALTER TABLE `stages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statuses`
--

DROP TABLE IF EXISTS `statuses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `statuses` (
  `statusId` int(11) NOT NULL,
  `statuseName` varchar(45) NOT NULL,
  PRIMARY KEY (`statusId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statuses`
--

LOCK TABLES `statuses` WRITE;
/*!40000 ALTER TABLE `statuses` DISABLE KEYS */;
/*!40000 ALTER TABLE `statuses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks`
--

DROP TABLE IF EXISTS `tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tasks` (
  `taskId` int(11) NOT NULL,
  `taskName` varchar(255) NOT NULL,
  `stageId` int(11) NOT NULL,
  PRIMARY KEY (`taskId`),
  KEY `fk_stage_task_idx` (`stageId`),
  CONSTRAINT `fk_stage_task` FOREIGN KEY (`stageId`) REFERENCES `stages` (`stageId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks`
--

LOCK TABLES `tasks` WRITE;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
/*!40000 ALTER TABLE `tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taskstatuses`
--

DROP TABLE IF EXISTS `taskstatuses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `taskstatuses` (
  `taskStatusId` int(11) NOT NULL,
  `taskStatusName` varchar(45) NOT NULL,
  PRIMARY KEY (`taskStatusId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taskstatuses`
--

LOCK TABLES `taskstatuses` WRITE;
/*!40000 ALTER TABLE `taskstatuses` DISABLE KEYS */;
/*!40000 ALTER TABLE `taskstatuses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainings`
--

DROP TABLE IF EXISTS `trainings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  KEY `fk_trainings_category_idx` (`categoryId`),
  KEY `fk_trainings_user_idx` (`userId`),
  CONSTRAINT `fk_trainings_category` FOREIGN KEY (`categoryId`) REFERENCES `categories` (`categoryId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_trainings_user` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainings`
--

LOCK TABLES `trainings` WRITE;
/*!40000 ALTER TABLE `trainings` DISABLE KEYS */;
INSERT INTO trainings.trainings (title, description, categoryId, forWhom, goal, maxParticipants, userId) VALUES ('Training', 'description', 1, 'All', 'No goal', 20, 7);
INSERT INTO trainings.trainings (title, description, categoryId, forWhom, goal, maxParticipants, userId) VALUES ('Second training', 'vriov', 3, 'revgfs', 'rves', 2, 7);
INSERT INTO trainings.trainings (title, description, categoryId, forWhom, goal, maxParticipants, userId) VALUES ('hd training', 'vriov', 3, 'revgfs', 'rves', 2, 7);
INSERT INTO trainings.trainings (title, description, categoryId, forWhom, goal, maxParticipants, userId) VALUES ('dhfbf training', 'vriov', 1, 'revgfs', 'rves', 2, 7);
INSERT INTO trainings.trainings (title, description, categoryId, forWhom, goal, maxParticipants, userId) VALUES ('hd training', 'vriov', 3, 'revgfs', 'rves', 2, 7);
INSERT INTO trainings.trainings (title, description, categoryId, forWhom, goal, maxParticipants, userId) VALUES ('fjtj training', 'vriov', 3, 'revgfs', 'rves', 2, 7);
INSERT INTO trainings.trainings (title, description, categoryId, forWhom, goal, maxParticipants, userId) VALUES ('hed training', '7u,fj', 1, 'revgfs', 'rves', 2, 7);
/*!40000 ALTER TABLE `trainings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `roleId` int(11) NOT NULL,
  `isConfirmed` tinyint(1) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `fk_user_role_idx` (`roleId`),
  CONSTRAINT `fk_user_role` FOREIGN KEY (`roleId`) REFERENCES `roles` (`roleId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','$2a$10$XkSKLT38rkmmHOJxCh1tQOPKbR7VWwzZ0ZJS5ep3G9TWoSdknASEK','svetaklimenkova@mail.ru',1,1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-14 13:01:10

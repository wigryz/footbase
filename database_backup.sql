-- MySQL dump 10.13  Distrib 8.0.25, for Linux (x86_64)
--
-- Host: localhost    Database: football
-- ------------------------------------------------------
-- Server version	8.0.25-0ubuntu0.20.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `game`
--
USE football;
DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `game` (
  `id` int NOT NULL AUTO_INCREMENT,
  `host_score` int DEFAULT NULL,
  `guest_score` int DEFAULT NULL,
  `game_date` date DEFAULT NULL,
  `host_team_id` int NOT NULL,
  `guest_team_id` int NOT NULL,
  `referee_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `game_guest_fk` (`guest_team_id`),
  KEY `game_host_fk` (`host_team_id`),
  KEY `game_referee_fk` (`referee_id`),
  CONSTRAINT `game_guest_fk` FOREIGN KEY (`guest_team_id`) REFERENCES `team` (`id`),
  CONSTRAINT `game_host_fk` FOREIGN KEY (`host_team_id`) REFERENCES `team` (`id`),
  CONSTRAINT `game_referee_fk` FOREIGN KEY (`referee_id`) REFERENCES `referee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` VALUES (1,2,1,'2021-05-12',9,4,2);
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (12);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incident`
--

DROP TABLE IF EXISTS `incident`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `incident` (
  `id` int NOT NULL AUTO_INCREMENT,
  `incident_type_id` int NOT NULL,
  `game_id` int NOT NULL,
  `player_id` int NOT NULL,
  `minute` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `incident_incident_type_fk` (`incident_type_id`),
  KEY `incident_game_fk` (`game_id`),
  KEY `incident_player_fk` (`player_id`),
  CONSTRAINT `incident_game_fk` FOREIGN KEY (`game_id`) REFERENCES `game` (`id`),
  CONSTRAINT `incident_incident_type_fk` FOREIGN KEY (`incident_type_id`) REFERENCES `incident_type` (`id`),
  CONSTRAINT `incident_player_fk` FOREIGN KEY (`player_id`) REFERENCES `player` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incident`
--

LOCK TABLES `incident` WRITE;
/*!40000 ALTER TABLE `incident` DISABLE KEYS */;
/*!40000 ALTER TABLE `incident` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incident_type`
--

DROP TABLE IF EXISTS `incident_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `incident_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `incident_name` char(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incident_type`
--

LOCK TABLES `incident_type` WRITE;
/*!40000 ALTER TABLE `incident_type` DISABLE KEYS */;
INSERT INTO `incident_type` VALUES (1,'goal'),(2,'own goal'),(3,'yellow card'),(4,'red card');
/*!40000 ALTER TABLE `incident_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player`
--

DROP TABLE IF EXISTS `player`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `player` (
  `id` int NOT NULL AUTO_INCREMENT,
  `full_name` char(30) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `current_team_id` int DEFAULT NULL,
  `main_position_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `player_position_fk` (`main_position_id`),
  KEY `player_team_fk` (`current_team_id`),
  CONSTRAINT `player_position_fk` FOREIGN KEY (`main_position_id`) REFERENCES `position` (`id`) ON DELETE SET NULL,
  CONSTRAINT `player_team_fk` FOREIGN KEY (`current_team_id`) REFERENCES `team` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player`
--

LOCK TABLES `player` WRITE;
/*!40000 ALTER TABLE `player` DISABLE KEYS */;
INSERT INTO `player` VALUES (1,'Daniel Kolasa','1988-02-05',9,1),(2,'Artur Blacharczyk','1998-03-02',9,2),(3,'Bartosz Chowaniec','1998-05-10',9,2),(4,'Jarosław Chowaniec','1990-12-12',9,2),(5,'Władysław Chowaniec','1996-10-05',9,2),(6,'Michał Chmielak','2001-06-12',9,2),(7,'Paweł Wincek','2001-06-12',9,3),(8,'Jakub Maciasz','1998-02-12',9,3),(9,'Szymon Chowaniec','1997-03-21',9,4),(10,'Kamil Łęczycki','1996-04-20',9,4),(11,'Dawid Chmielak','1994-05-07',9,3),(12,'Marcin Grzywnowicz','2002-10-08',9,4),(13,'Tomasz Ligęza','2000-04-27',9,3),(14,'Sebastian Kasprzak','2002-05-09',9,4),(15,'Dominik Klamerus','1999-05-12',9,1),(16,'Lewis Mccray','2003-08-22',1,3),(17,'Chaim Romero','2003-07-16',1,2),(18,'Jacob Newman','2000-10-25',1,2),(19,'Nigel Sanford','2003-02-14',1,2),(20,'Armando Hendricks','2003-04-22',1,3),(21,'Eric Lane','2003-09-04',1,1),(22,'Quinn Pace','2003-09-26',1,3),(23,'Zachery Mason','2003-09-14',1,2),(24,'Jarrod Phillips','2003-05-31',1,4),(25,'Wang Moses','1994-08-16',1,2),(26,'Christian Atkinson','2003-11-15',1,3),(27,'Octavius Cain','1996-03-28',1,1),(28,'Lucas Little','2000-09-22',1,2),(29,'Zane Fitzpatrick','1995-05-26',1,2),(30,'Finn Ward','2003-01-20',1,2),(31,'Cameron Sargent','2003-05-19',1,1),(32,'Chase Hatfield','1995-05-21',2,4),(33,'Yardley Harmon','1990-10-23',2,4),(34,'Garrison Gould','2003-09-26',2,4),(35,'Gary Schneider','2003-10-12',2,2),(36,'Lucian Hendricks','2003-11-05',2,4),(37,'Andrew Dennis','2003-10-02',2,3),(38,'Griffith Mosley','2001-12-18',2,3),(39,'Gary Hooper','2003-04-18',2,4),(40,'Tanek Greer','2000-06-16',2,1),(41,'Randall Garner','2003-03-20',2,4),(42,'Hammett Alford','2001-09-13',2,3),(43,'Andrew Mendoza','1993-08-13',2,1),(44,'Bevis Cherry','2003-05-31',2,2),(45,'Preston Mcleod','2003-05-20',2,1),(46,'Hilel Walters','2003-05-11',2,3),(47,'Leonard Bullock','1992-05-15',2,2),(48,'Galvin Whitley','2003-03-06',3,2),(49,'Keane Hoffman','2003-02-24',3,4),(50,'Henry Key','2003-06-30',3,1),(51,'Phelan Nash','2003-10-11',3,4),(52,'Vincent Figueroa','2003-02-20',3,2),(53,'Ashton Watts','2003-01-02',3,2),(54,'Felix Poole','2003-03-03',3,3),(55,'Kamal Craft','2003-10-20',3,3),(56,'Upton Booker','2003-08-28',3,1),(57,'Blake Boyle','1999-07-27',3,2),(58,'Martin Owens','2003-10-12',3,1),(59,'Igor Cox','2003-09-26',3,2),(60,'Jackson Hunter','2003-08-26',3,1),(61,'Brady Levine','1998-09-16',3,3),(62,'Dalton Harper','2003-07-24',3,1),(63,'Murphy Franks','2001-04-08',3,1),(64,'Caesar Trevino','1998-04-17',4,4),(65,'Erasmus Shepard','2003-04-07',4,1),(66,'Kelly Francis','1991-03-18',4,3),(67,'Vladimir Velasquez','2003-04-05',4,4),(68,'Kennan Walsh','1994-04-19',4,1),(69,'Simon Banks','1997-11-08',4,1),(70,'Melvin Good','2000-01-04',4,1),(71,'Ivor Kinney','2000-01-24',4,2),(72,'Yoshio French','2003-08-12',4,2),(73,'Mark Huff','2002-01-06',4,4),(74,'Julian Blevins','1997-07-08',4,2),(75,'Ralph Snider','1991-02-08',4,3),(76,'Deacon Mcdaniel','2003-01-17',4,3),(77,'Knox York','1997-07-03',4,1),(78,'Vernon Finch','2003-11-30',5,1),(79,'Steven Pennington','2003-01-12',5,2),(80,'Graham Mills','2003-04-24',5,1),(81,'Jasper Riggs','2000-03-08',5,4),(82,'Dominic Wyatt','1997-12-01',5,4),(83,'Matthew Kinney','2003-12-01',5,4),(84,'Carter Lamb','2003-12-11',5,1),(85,'Magee Anthony','2003-12-30',5,2),(86,'Akeem Stuart','2003-01-23',5,1),(87,'Gareth Bradley','1996-09-13',5,1),(88,'Kato Kim','1993-08-31',5,4),(89,'Hyatt Knapp','2001-11-09',5,4),(90,'Dale Taylor','2003-01-15',5,2),(91,'Craig Beck','1996-01-20',5,3),(92,'Geoffrey Deleon','1994-09-11',5,4),(93,'Brennan Anderson','2003-10-14',6,4),(94,'Bradley Conrad','2001-12-05',6,3),(95,'Lev Potter','1996-08-20',6,3),(96,'Nero Ferrell','2003-06-28',6,4),(97,'Talon Jordan','2003-10-17',6,2),(98,'Alexander Burns','2003-10-30',6,4),(99,'Dieter Rocha','2003-01-11',6,3),(100,'Silas Lindsay','2003-01-22',6,1),(101,'Alexander Morales','2003-01-31',6,3),(102,'Dominic Delacruz','2003-10-17',6,4),(103,'Louis Conrad','2003-10-15',6,3),(104,'Raja Ellison','2003-08-03',6,1),(105,'Joel Roman','2003-06-07',6,1),(106,'Allen Mercer','2003-11-16',6,1),(107,'Harper Sargent','2003-02-05',6,3),(108,'Porter Talley','2003-01-16',7,4),(109,'Lev Watson','1992-04-22',7,2),(110,'Elvis Hernandez','2003-08-22',7,2),(111,'Clinton Blackburn','1995-07-24',7,1),(112,'Ross Aguilar','2001-11-11',7,3),(113,'Jeremy Dean','2003-11-27',7,1),(114,'Wade Curry','2003-01-21',7,1),(115,'William Guzman','2003-09-07',7,4),(116,'Zane Rodriquez','2003-10-29',7,4),(117,'Tyler Arnold','2003-03-27',7,2),(118,'Lyle Shaffer','1991-12-08',7,1),(119,'Channing Mckenzie','2003-08-01',7,4),(120,'Ahmed Jefferson','2003-01-07',7,3),(121,'Clayton Paul','2003-12-16',7,4),(122,'Roth Frost','1997-06-16',7,1),(123,'Keegan Tyson','1996-03-09',7,1),(124,'Magee Hughes','1990-02-13',7,2),(125,'Herrod French','2003-09-02',7,2),(126,'Yuli Bright','2003-06-18',8,1),(127,'Duncan Crane','1996-11-18',8,4),(128,'Hu Howell','2003-02-11',8,1),(129,'Dennis Potts','2003-02-08',8,1),(130,'Levi Herring','2003-06-02',8,1),(131,'Noah Nelson','2003-12-25',8,4),(132,'Timothy Lynch','2003-09-07',8,1),(133,'Clark Marks','1999-03-28',8,1),(134,'Carter Bennett','2003-07-22',8,2),(135,'Lev Cantrell','1992-11-21',8,2),(136,'Grant Sandoval','2003-05-05',8,4),(137,'Bruno Glover','2003-12-07',8,2),(138,'Matthew Kennedy','1996-01-29',8,2),(139,'Dorian Klein','2003-12-23',8,1),(140,'Knox Stewart','2000-10-03',8,3),(141,'Conan Rosario','2003-12-21',10,1),(142,'Addison Blackwell','2001-09-25',10,3),(143,'Dillon Osborne','1997-05-06',10,2),(144,'Price Cameron','2001-02-15',10,3),(145,'Alec Oneal','1999-05-09',10,4),(146,'Kermit Chaney','2003-09-23',10,2),(147,'Hamish Pratt','1991-11-26',10,4),(148,'Conan Espinoza','2003-11-13',10,2),(149,'Kasimir Cabrera','2003-02-06',10,2),(150,'Owen Hammond','1995-09-11',10,4),(151,'Ivor Hopper','1995-08-19',10,1),(152,'Chaim Goff','1995-08-23',10,3),(153,'Chancellor Decker','1991-02-15',10,2),(154,'Quinlan Kline','2002-07-14',10,1),(155,'Erich Rivers','2003-02-15',11,4),(156,'Alvin Chang','2003-09-16',11,3),(157,'Wallace Herman','1998-11-17',11,4),(158,'Nero Gonzalez','1997-06-16',11,3),(159,'Drew Best','2000-08-27',11,4),(160,'Tanner Moses','2003-04-10',11,2),(161,'Amal Vega','2003-09-08',11,1),(162,'Xenos Horton','2001-04-05',11,3),(163,'Aristotle Lynn','2000-02-11',11,4),(164,'Zachery Merrill','2001-06-01',11,4),(165,'Brent Heath','1994-10-13',11,3),(166,'Paki Williams','2003-11-07',11,1),(167,'Amir Rojas','2003-01-16',11,2),(168,'Declan Huffman','1998-05-06',11,3),(169,'Walker Greer','2003-07-30',11,3),(170,'Lawrence Barron','2003-06-08',11,1),(171,'Kamal Ewing','1993-11-28',12,2),(172,'Cedric Everett','2003-05-28',12,4),(173,'Lars Warren','2003-08-09',12,4),(174,'Vance Poole','1997-03-29',12,2),(175,'Xanthus Pickett','1995-01-11',12,3),(176,'Brady Bowers','1991-04-14',12,3),(177,'Basil Macias','1993-02-04',12,3),(178,'Flynn Mooney','2003-11-27',12,3),(179,'Harper Frost','2003-02-11',12,4),(180,'Elijah Williamson','2003-10-01',12,1),(181,'Garrett Lopez','2003-07-16',12,3),(182,'Ishmael Reed','1990-07-06',12,3),(183,'Fritz Velez','2003-06-11',12,1),(184,'Kenneth Ware','1992-12-07',12,2),(185,'Emmanuel Ellis','1991-05-08',12,2),(186,'Stewart Cohen','2003-03-04',13,3),(187,'Jackson Duran','2003-05-28',13,1),(188,'Phelan Dickson','2003-03-22',13,4),(189,'Magee Malone','1992-08-22',13,3),(190,'Dillon Wade','1994-03-30',13,2),(191,'Castor Silva','1990-09-22',13,4),(192,'Lance Goff','2003-09-02',13,2),(193,'Edward Sparks','2003-10-01',13,4),(194,'Cooper Blake','2003-08-13',13,1),(195,'Gage George','1991-06-01',13,2),(196,'Dillon Maynard','2000-02-27',13,4),(197,'Mannix Knapp','1998-12-28',13,2),(198,'Keefe Pope','2003-09-03',13,4),(199,'Cade House','2003-12-26',13,4),(200,'Nathan Collier','2003-05-16',13,4),(201,'Alan Norris','1991-06-03',14,4),(202,'Allistair Allison','1990-07-05',14,2),(203,'Rudyard Moran','2003-11-16',14,4),(204,'Deacon Rivera','2003-11-22',14,1),(205,'Benedict Rodgers','2000-01-08',14,2),(206,'Fritz Horn','2003-11-02',14,1),(207,'Brent Rodriguez','1992-01-21',14,1),(208,'Berk Kinney','2003-09-28',14,3),(209,'Kennedy Figueroa','2003-12-04',14,3),(210,'Nehru Curtis','2003-08-07',14,2),(211,'Hashim Hewitt','2003-04-05',14,3),(212,'Gil Bowen','2003-04-20',14,2),(213,'Tad Diaz','2003-11-29',14,3),(214,'Felix Delaney','1999-01-10',14,3),(215,'Tanner William','2003-12-06',15,3),(216,'Logan Short','2003-03-27',15,4),(217,'Carl Barber','1990-07-31',15,3),(218,'Samuel Jensen','2003-11-10',15,4),(219,'Nero Forbes','2003-07-19',15,2),(220,'Beck Head','2003-10-23',15,4),(221,'Alan Mckinney','1999-10-08',15,2),(222,'Mason Barnes','1999-03-21',15,1),(223,'Barrett Mccullough','2003-05-17',15,3),(224,'Otto Simon','2003-05-21',15,1),(225,'Bert Puckett','1990-05-09',15,3),(226,'Yuli Rosa','2003-05-26',15,1),(227,'Garth Clemons','1999-11-04',15,4),(228,'Micah Shepherd','1996-10-14',15,4),(229,'Tarik Velez','1999-06-16',15,4),(230,'Oleg Gaines','2003-02-12',16,4),(231,'Laith Hatfield','2003-05-15',16,2),(232,'Allistair Rowe','2003-04-02',16,2),(233,'Philip Moran','2003-10-20',16,1),(234,'Mohammad Meadows','2003-09-06',16,3),(235,'Kermit Gross','1996-06-25',16,3),(236,'Elmo Dickson','2003-03-05',16,4),(237,'Rafael Payne','2003-08-28',16,2),(238,'Raphael Wade','1991-03-12',16,3),(239,'Warren Tyler','1996-04-10',16,2),(240,'Hashim Lynch','2003-01-12',16,1),(241,'Abbot Meyer','2003-10-19',16,2),(242,'Barry Lloyd','2003-01-10',16,2),(243,'Flynn Gray','2003-10-25',16,2),(244,'Bert Mcmillan','2003-12-31',16,3);
/*!40000 ALTER TABLE `player` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `position` (
  `id` int NOT NULL AUTO_INCREMENT,
  `position_name` char(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES (1,'goalkeeper'),(2,'defender'),(3,'midfielder'),(4,'forward');
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `referee`
--

DROP TABLE IF EXISTS `referee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `referee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `full_name` char(30) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `referee`
--

LOCK TABLES `referee` WRITE;
/*!40000 ALTER TABLE `referee` DISABLE KEYS */;
INSERT INTO `referee` VALUES (1,'Arendarczyk Kamil','2000-03-12'),(2,'Florczyk Szymon','1998-05-23'),(3,'Firek Damian','1997-01-23'),(4,'Marondel Wiktor','1999-12-24'),(5,'Michalak Patryk','1974-02-10'),(6,'Tesarski Marcin','1980-07-30'),(7,'Warmuz Wojciech','1985-09-15'),(8,'Zagata Leszek','1987-01-21'),(9,'Zoń Mariusz','2001-09-23');
/*!40000 ALTER TABLE `referee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `substitution`
--

DROP TABLE IF EXISTS `substitution`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `substitution` (
  `id` int NOT NULL AUTO_INCREMENT,
  `game_id` int NOT NULL,
  `ingoing_player_id` int NOT NULL,
  `outgoing_player_id` int NOT NULL,
  `minute` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `substitution_ingoing_fk` (`ingoing_player_id`),
  KEY `substitution_game_fk` (`game_id`),
  KEY `substitution_outgoing_fk` (`outgoing_player_id`),
  CONSTRAINT `substitution_game_fk` FOREIGN KEY (`game_id`) REFERENCES `game` (`id`),
  CONSTRAINT `substitution_ingoing_fk` FOREIGN KEY (`ingoing_player_id`) REFERENCES `player` (`id`),
  CONSTRAINT `substitution_outgoing_fk` FOREIGN KEY (`outgoing_player_id`) REFERENCES `player` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `substitution`
--

LOCK TABLES `substitution` WRITE;
/*!40000 ALTER TABLE `substitution` DISABLE KEYS */;
/*!40000 ALTER TABLE `substitution` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `team` (
  `id` int NOT NULL AUTO_INCREMENT,
  `team_name` char(30) DEFAULT NULL,
  `year_of_creation` int DEFAULT NULL,
  `full_address` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
INSERT INTO `team` VALUES (1,'Orkan Raba Wyżna',1946,'Raba Wyżna 210'),(2,'Zawrat Bukowina Tatrzańska',2003,'Bukowina Tatrzańska ul. Kościuszki 1'),(3,'Lubań Tylmanowa',1993,'os. Kozielce 287 Tylmanowa'),(4,'Skalni Zaskale',2000,'Zaskale, ul. Kard. K. Wojtyły 67'),(5,'KS Zakopane',2007,'ul. Skibówki 11a 34-500 Zakopane'),(6,'GKS Łapsze Niżne',2000,'ul. Długa 90 34-441 Łapsze Niżne'),(7,'Bór Dębno',1960,'ul. Jana Pawła II 35 34-434 Dębno'),(8,'Gorce Rdzawka',NULL,NULL),(9,'Przełęcz Łopuszna',1948,'ul. Podhalańska 15 34-432 Łopuszna'),(10,'Dunajec Ostrowsko',1999,'ul. Pienińska 57 34-431 Ostrowsko'),(11,'Orawa Jabłonka',1995,'34-482 Lipnica Wielka 297b'),(12,'KS Lokomotiv Chabówka',2002,'34-720 Chabówka 280'),(13,'Biali Biały Dunajec',2000,'ul. Jana Pawła II 363 34-425 Biały Dunajec'),(14,'Skawianin Skawa',1997,'34-713 Skawa 110a'),(15,'Wierchy Lasek',1965,'Lasek 65a 34-404 Klikuszowa'),(16,'ZKP Asy Zakopane',NULL,NULL);
/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-30 16:33:58

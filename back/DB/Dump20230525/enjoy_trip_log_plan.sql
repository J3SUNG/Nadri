-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: enjoy_trip
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `log_plan`
--

DROP TABLE IF EXISTS `log_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log_plan` (
  `log_no` int NOT NULL AUTO_INCREMENT,
  `log_date` timestamp NOT NULL,
  `plan_no` int NOT NULL,
  `user_no` int DEFAULT NULL,
  PRIMARY KEY (`log_no`),
  KEY `log_no.plan_no_idx` (`plan_no`),
  CONSTRAINT `log_no.plan_no` FOREIGN KEY (`plan_no`) REFERENCES `plan` (`plan_no`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=230 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_plan`
--

LOCK TABLES `log_plan` WRITE;
/*!40000 ALTER TABLE `log_plan` DISABLE KEYS */;
INSERT INTO `log_plan` VALUES (1,'2023-05-23 05:27:54',1,1),(2,'2023-05-23 05:29:14',2,1),(3,'2023-05-23 05:29:15',3,1),(4,'2023-05-23 05:29:18',3,2),(5,'2023-05-23 05:29:19',2,2),(6,'2023-05-23 05:29:20',1,2),(7,'2023-05-23 05:40:13',1,2),(8,'2023-05-23 05:46:48',1,7),(10,'2023-05-23 11:59:08',1,1),(11,'2023-05-23 12:18:21',5,1),(12,'2023-05-23 12:19:01',5,1),(13,'2023-05-23 14:26:02',1,1),(14,'2023-05-23 14:28:31',1,1),(15,'2023-05-23 14:31:55',1,1),(16,'2023-05-23 16:06:45',2,1),(17,'2023-05-23 16:07:00',2,1),(18,'2023-05-23 16:07:05',2,1),(19,'2023-05-23 16:08:47',2,1),(20,'2023-05-23 16:10:16',2,1),(21,'2023-05-23 16:12:15',2,1),(22,'2023-05-23 16:12:52',2,1),(23,'2023-05-23 16:13:25',2,1),(24,'2023-05-23 16:13:42',2,1),(25,'2023-05-23 16:13:48',2,1),(26,'2023-05-23 16:13:50',2,1),(27,'2023-05-23 16:14:27',2,1),(28,'2023-05-23 16:14:38',2,1),(29,'2023-05-23 16:15:00',2,1),(30,'2023-05-23 16:15:11',2,1),(31,'2023-05-23 16:15:17',2,1),(32,'2023-05-23 16:16:13',2,1),(33,'2023-05-23 16:16:23',2,1),(34,'2023-05-23 16:17:33',2,1),(35,'2023-05-23 16:19:16',2,1),(36,'2023-05-23 16:20:48',2,1),(37,'2023-05-23 16:20:54',2,1),(38,'2023-05-23 16:22:39',2,1),(39,'2023-05-23 16:23:05',3,1),(40,'2023-05-23 16:23:31',3,1),(41,'2023-05-23 16:24:11',3,1),(42,'2023-05-23 16:24:31',3,1),(43,'2023-05-23 16:24:40',3,1),(44,'2023-05-23 16:25:02',3,1),(45,'2023-05-23 16:26:05',1,1),(46,'2023-05-23 16:26:24',1,1),(47,'2023-05-23 16:26:29',1,1),(48,'2023-05-23 16:26:51',1,1),(49,'2023-05-23 16:27:06',1,1),(50,'2023-05-23 16:27:20',1,1),(51,'2023-05-23 16:27:20',1,1),(52,'2023-05-23 16:27:38',1,1),(53,'2023-05-23 16:28:04',1,1),(54,'2023-05-23 16:28:17',1,1),(55,'2023-05-23 16:28:26',2,1),(56,'2023-05-23 16:29:40',2,1),(57,'2023-05-23 16:29:51',2,1),(58,'2023-05-23 16:30:29',2,1),(59,'2023-05-23 16:30:55',2,1),(60,'2023-05-23 16:31:27',2,1),(61,'2023-05-23 16:31:32',2,1),(62,'2023-05-23 16:31:40',2,1),(63,'2023-05-23 16:31:48',2,1),(64,'2023-05-23 16:31:51',2,1),(65,'2023-05-23 16:31:59',2,1),(66,'2023-05-23 16:32:11',2,1),(67,'2023-05-23 16:32:20',2,1),(68,'2023-05-23 16:32:25',2,1),(69,'2023-05-23 16:33:31',2,1),(70,'2023-05-23 16:34:26',2,1),(71,'2023-05-23 16:34:28',2,1),(72,'2023-05-23 16:35:09',3,1),(73,'2023-05-23 16:35:10',1,1),(74,'2023-05-23 16:35:11',2,1),(75,'2023-05-23 16:35:12',5,1),(80,'2023-05-23 16:35:16',1,1),(81,'2023-05-23 16:35:58',1,1),(82,'2023-05-23 16:36:12',1,1),(83,'2023-05-23 16:36:17',1,1),(84,'2023-05-23 16:36:35',1,1),(85,'2023-05-23 16:36:39',1,1),(86,'2023-05-23 16:38:39',1,1),(87,'2023-05-23 16:41:19',1,1),(88,'2023-05-23 16:43:06',1,1),(89,'2023-05-23 16:43:48',1,1),(90,'2023-05-23 16:44:57',1,1),(91,'2023-05-23 16:45:24',3,1),(92,'2023-05-23 16:49:46',2,1),(97,'2023-05-24 00:54:37',3,0),(98,'2023-05-24 00:54:44',2,0),(100,'2023-05-24 00:54:50',5,0),(101,'2023-05-24 00:54:59',1,1),(102,'2023-05-24 00:56:28',1,1),(107,'2023-05-24 00:59:53',2,1),(108,'2023-05-24 01:00:35',2,1),(109,'2023-05-24 01:00:45',2,1),(110,'2023-05-24 01:00:51',2,1),(111,'2023-05-24 01:01:13',2,1),(112,'2023-05-24 01:01:21',2,1),(113,'2023-05-24 01:01:30',3,1),(115,'2023-05-24 01:01:46',5,1),(116,'2023-05-24 01:01:52',5,1),(117,'2023-05-24 01:01:56',5,1),(118,'2023-05-24 01:02:01',5,1),(119,'2023-05-24 01:02:23',5,1),(120,'2023-05-24 01:02:51',5,1),(121,'2023-05-24 01:02:58',5,1),(122,'2023-05-24 01:03:08',5,1),(123,'2023-05-24 01:03:16',5,1),(124,'2023-05-24 01:03:38',5,1),(125,'2023-05-24 01:03:43',2,1),(128,'2023-05-24 04:05:07',2,0),(130,'2023-05-24 04:14:36',1,1),(131,'2023-05-24 04:14:42',5,1),(132,'2023-05-24 04:18:31',5,1),(133,'2023-05-24 04:32:33',3,1),(134,'2023-05-24 05:21:01',1,1),(135,'2023-05-24 05:21:02',2,1),(136,'2023-05-24 05:21:03',3,1),(137,'2023-05-24 05:21:11',3,1),(138,'2023-05-24 05:21:47',3,1),(141,'2023-05-24 05:25:23',2,1),(142,'2023-05-24 05:25:24',1,1),(143,'2023-05-24 05:25:25',3,1),(150,'2023-05-24 05:26:09',1,1),(151,'2023-05-24 05:26:10',3,1),(152,'2023-05-24 05:26:10',2,1),(154,'2023-05-24 05:26:12',5,1),(155,'2023-05-24 05:46:27',3,1),(156,'2023-05-24 05:46:30',2,1),(157,'2023-05-24 05:46:31',1,1),(159,'2023-05-24 06:19:17',1,1),(160,'2023-05-24 06:19:17',3,1),(161,'2023-05-24 06:19:18',2,1),(162,'2023-05-24 06:19:19',5,1),(164,'2023-05-24 06:19:42',1,1),(165,'2023-05-24 06:19:43',5,1),(166,'2023-05-24 06:19:43',2,1),(168,'2023-05-24 06:19:45',3,1),(170,'2023-05-24 06:20:07',1,1),(171,'2023-05-24 06:20:07',3,1),(172,'2023-05-24 06:20:08',2,1),(173,'2023-05-24 06:20:09',5,1),(177,'2023-05-24 06:20:24',5,1),(178,'2023-05-24 06:20:27',2,1),(179,'2023-05-24 06:20:36',3,1),(199,'2023-05-24 08:25:42',41,1),(201,'2023-05-25 00:54:28',41,1),(202,'2023-05-25 03:49:54',41,0),(205,'2023-05-25 07:12:43',41,29),(207,'2023-05-25 07:29:53',3,29),(208,'2023-05-25 07:51:57',1,0),(209,'2023-05-25 07:52:50',2,0),(214,'2023-05-25 08:18:59',46,12),(215,'2023-05-25 08:19:20',5,12),(216,'2023-05-25 08:20:23',46,12),(217,'2023-05-25 08:38:15',47,30),(218,'2023-05-25 08:38:15',46,30),(219,'2023-05-25 08:38:16',41,30),(220,'2023-05-25 08:38:19',3,30),(221,'2023-05-25 08:38:19',1,30),(222,'2023-05-25 08:40:33',47,31),(223,'2023-05-25 08:40:34',46,31),(224,'2023-05-25 08:40:35',41,31),(225,'2023-05-25 08:40:36',5,31),(226,'2023-05-25 08:40:37',3,31),(227,'2023-05-25 08:40:39',1,31),(228,'2023-05-25 08:42:34',1,31),(229,'2023-05-25 08:42:39',5,31);
/*!40000 ALTER TABLE `log_plan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-25 17:59:37

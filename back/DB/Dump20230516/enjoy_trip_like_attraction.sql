-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 192.168.31.79    Database: enjoy_trip
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
-- Table structure for table `like_attraction`
--

DROP TABLE IF EXISTS `like_attraction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `like_attraction` (
  `like_no` int NOT NULL AUTO_INCREMENT,
  `registration_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `attraction_no` int NOT NULL,
  `user_no` int DEFAULT NULL,
  PRIMARY KEY (`like_no`),
  KEY `fk_like_attraction_attraction_info1_idx` (`attraction_no`),
  KEY `fk_like_attraction_user1_idx` (`user_no`),
  CONSTRAINT `fk_like_attraction_attraction_info1` FOREIGN KEY (`attraction_no`) REFERENCES `attraction_info` (`attraction_no`),
  CONSTRAINT `fk_like_attraction_user1` FOREIGN KEY (`user_no`) REFERENCES `user` (`user_no`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `like_attraction`
--

LOCK TABLES `like_attraction` WRITE;
/*!40000 ALTER TABLE `like_attraction` DISABLE KEYS */;
INSERT INTO `like_attraction` VALUES (1,'2023-05-16 05:27:58',1,1),(2,'2023-05-17 05:27:58',2,1),(3,'2023-05-17 05:27:58',3,1),(4,'2023-05-17 05:27:58',4,1),(5,'2023-05-16 05:33:08',1,2),(6,'2023-05-16 05:33:08',2,2),(7,'2023-05-16 05:33:08',1,3),(8,'2023-05-16 05:33:08',2,3),(9,'2023-05-16 05:33:08',3,2),(10,'2023-05-16 05:33:46',3,3),(11,'2023-05-16 05:34:30',1,4),(12,'2023-05-16 05:34:30',2,4),(13,'2023-05-16 05:34:30',3,4),(14,'2023-05-16 05:34:30',4,4),(15,'2023-05-16 05:34:30',5,4),(16,'2023-05-16 05:34:51',1,5),(17,'2023-05-16 05:34:51',2,5),(18,'2023-05-16 05:34:51',3,5),(19,'2023-05-16 05:34:51',4,5),(20,'2023-05-16 05:34:51',5,5);
/*!40000 ALTER TABLE `like_attraction` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-16 14:56:30

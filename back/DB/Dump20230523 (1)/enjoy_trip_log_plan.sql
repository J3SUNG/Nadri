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
  KEY `log_no.user_no_idx` (`user_no`),
  CONSTRAINT `log_no.plan_no` FOREIGN KEY (`plan_no`) REFERENCES `plan` (`plan_no`) ON DELETE CASCADE,
  CONSTRAINT `log_no.user_no` FOREIGN KEY (`user_no`) REFERENCES `user` (`user_no`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_plan`
--

LOCK TABLES `log_plan` WRITE;
/*!40000 ALTER TABLE `log_plan` DISABLE KEYS */;
INSERT INTO `log_plan` VALUES (1,'2023-05-23 05:27:54',1,1),(2,'2023-05-23 05:29:14',2,1),(3,'2023-05-23 05:29:15',3,1),(4,'2023-05-23 05:29:18',3,2),(5,'2023-05-23 05:29:19',2,2),(6,'2023-05-23 05:29:20',1,2),(7,'2023-05-23 05:40:13',1,2),(8,'2023-05-23 05:46:48',1,7),(9,'2023-05-23 05:46:55',7,7);
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

-- Dump completed on 2023-05-23 18:34:17

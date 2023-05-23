-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: enjoy_trip
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
-- Table structure for table `attraction_review`
--

DROP TABLE IF EXISTS `attraction_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attraction_review` (
  `review_no` int NOT NULL AUTO_INCREMENT,
  `content` varchar(1000) NOT NULL,
  `createtime` timestamp NOT NULL,
  `attraction_no` int NOT NULL,
  `user_no` int DEFAULT NULL,
  PRIMARY KEY (`review_no`),
  KEY `fk_attraction_review_attraction_info1_idx` (`attraction_no`),
  KEY `fk_attraction_review_user1_idx` (`user_no`),
  CONSTRAINT `fk_attraction_review_attraction_info1` FOREIGN KEY (`attraction_no`) REFERENCES `attraction_info` (`attraction_no`),
  CONSTRAINT `fk_attraction_review_user1` FOREIGN KEY (`user_no`) REFERENCES `user` (`user_no`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attraction_review`
--

LOCK TABLES `attraction_review` WRITE;
/*!40000 ALTER TABLE `attraction_review` DISABLE KEYS */;
INSERT INTO `attraction_review` VALUES (1,'절경이구요 장관입니다','2023-05-16 05:52:04',1,1),(2,'절경이구요 장관입니다','2023-05-16 05:52:04',2,1),(3,'절경이구요 장관입니다','2023-05-16 05:52:04',3,1),(4,'절경이구요 장관입니다','2023-05-16 05:52:04',4,1),(5,'절경이구요 장관입니다','2023-05-16 05:52:04',5,1),(6,'절경이구요 장관입니다','2023-05-16 05:52:04',1,2),(7,'절경이구요 장관입니다','2023-05-16 05:52:04',2,2),(8,'절경이구요 장관입니다','2023-05-16 05:52:04',3,2),(9,'절경이구요 장관입니다','2023-05-16 05:52:04',4,2),(10,'절경이구요 장관입니다','2023-05-16 05:52:04',5,2),(11,'멋져요 user3 관광지1','2023-05-16 05:53:35',1,3),(12,'멋져요','2023-05-16 05:53:35',2,3),(13,'멋져요','2023-05-16 05:53:35',3,3),(14,'멋져요','2023-05-16 05:53:35',4,3),(15,'멋져요','2023-05-16 05:53:35',5,3),(16,'멋져요','2023-05-16 05:53:35',1,4),(17,'멋져요','2023-05-16 05:53:35',2,4),(18,'멋져요','2023-05-16 05:53:35',3,5),(19,'멋져요','2023-05-16 05:53:35',4,5),(20,'멋져요','2023-05-16 05:53:35',5,5);
/*!40000 ALTER TABLE `attraction_review` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-24  2:27:20

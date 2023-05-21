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
-- Table structure for table `board_like`
--

DROP TABLE IF EXISTS `board_like`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board_like` (
  `like_no` int NOT NULL AUTO_INCREMENT,
  `like_time` timestamp NOT NULL,
  `user_no` int DEFAULT NULL,
  `board_no` int NOT NULL,
  PRIMARY KEY (`like_no`),
  KEY `fk_board_like_user1_idx` (`user_no`),
  KEY `fk_board_like_board1_idx` (`board_no`),
  CONSTRAINT `fk_board_like_board1` FOREIGN KEY (`board_no`) REFERENCES `board` (`board_no`) ON DELETE CASCADE,
  CONSTRAINT `fk_board_like_user1` FOREIGN KEY (`user_no`) REFERENCES `user` (`user_no`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board_like`
--

LOCK TABLES `board_like` WRITE;
/*!40000 ALTER TABLE `board_like` DISABLE KEYS */;
INSERT INTO `board_like` VALUES (1,'2023-05-02 15:00:00',4,21),(2,'2023-05-02 15:00:00',5,21),(3,'2023-05-02 15:00:00',6,21),(4,'2023-05-02 15:00:00',5,22),(5,'2023-05-15 08:21:36',3,22),(11,'2023-05-02 15:00:00',1,20),(12,'2023-05-02 15:00:00',2,20),(13,'2023-05-02 15:00:00',3,20),(14,'2023-05-02 15:00:00',4,20),(15,'2023-05-15 08:21:36',5,20),(16,'2023-05-15 08:21:36',6,20);
/*!40000 ALTER TABLE `board_like` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-22  0:51:47

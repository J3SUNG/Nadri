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
-- Table structure for table `board_comment`
--

DROP TABLE IF EXISTS `board_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board_comment` (
  `comment_no` int NOT NULL AUTO_INCREMENT,
  `content` varchar(1000) NOT NULL,
  `create_time` timestamp NOT NULL,
  `user_no` int DEFAULT NULL,
  `board_no` int NOT NULL,
  PRIMARY KEY (`comment_no`),
  KEY `fk_board_comment_user1_idx` (`user_no`),
  KEY `fk_board_comment_board1_idx` (`board_no`),
  CONSTRAINT `fk_board_comment_board1` FOREIGN KEY (`board_no`) REFERENCES `board` (`board_no`),
  CONSTRAINT `fk_board_comment_user1` FOREIGN KEY (`user_no`) REFERENCES `user` (`user_no`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board_comment`
--

LOCK TABLES `board_comment` WRITE;
/*!40000 ALTER TABLE `board_comment` DISABLE KEYS */;
INSERT INTO `board_comment` VALUES (11,'정말 인상 깊은 여행지에요 21번 유저2','2023-05-15 08:17:39',2,21),(12,'comment test 1','2023-05-15 08:18:39',2,21),(13,'comment test 2','2023-05-15 08:18:39',2,21),(14,'comment test 3','2023-05-15 08:18:39',2,21),(15,'comment test 4','2023-05-15 08:18:39',2,21),(16,'comment test 5','2023-05-15 08:18:39',2,21),(17,'comment test 1','2023-05-15 08:19:29',2,21),(18,'comment test 2','2023-05-15 08:19:29',2,21),(19,'comment test 3','2023-05-15 08:19:29',2,21),(21,'정말 인상 깊은 여행지에요 20번글 유저3','2023-05-15 08:17:39',3,20),(22,'comment test 1','2023-05-15 08:18:39',3,20),(23,'comment test 2','2023-05-15 08:18:39',3,20),(24,'comment test 3','2023-05-15 08:18:39',3,20),(25,'comment test 4','2023-05-15 08:18:39',3,20),(26,'comment test 5','2023-05-15 08:18:39',3,20),(27,'comment test 1','2023-05-15 08:19:29',3,20),(28,'comment test 2','2023-05-15 08:19:29',3,20),(29,'comment test 3','2023-05-15 08:19:29',3,20),(30,'comment test 4','2023-05-15 08:19:29',3,20),(31,'정말 인상 깊은 여행지에요 21번글 유저3','2023-05-15 08:17:39',3,21),(32,'comment test 1','2023-05-15 08:18:39',3,21),(33,'comment test 2','2023-05-15 08:18:39',3,21),(34,'comment test 3','2023-05-15 08:18:39',3,21),(35,'comment test 4','2023-05-15 08:18:39',3,21),(36,'comment test 5','2023-05-15 08:18:39',3,21),(37,'comment test 1','2023-05-15 08:19:29',3,21),(38,'comment test 2','2023-05-15 08:19:29',3,21),(39,'comment test 3','2023-05-15 08:19:29',3,21),(40,'comment test 4','2023-05-15 08:19:29',3,21);
/*!40000 ALTER TABLE `board_comment` ENABLE KEYS */;
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

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_no` int NOT NULL AUTO_INCREMENT,
  `id` varchar(40) NOT NULL,
  `password` varchar(200) NOT NULL,
  `nickname` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL,
  `join_date` timestamp NOT NULL,
  `grade` char(1) NOT NULL,
  `token` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`user_no`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3 COMMENT='				';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'ssafy','1234','예삐','test@gmail.com','2023-05-15 08:30:31','A',NULL),(2,'user1','1234','바보','u1@naver.com','2023-05-15 08:30:32','U','eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyZWZyZXNoLXRva2VuIiwiaWF0IjoxNjg0NjczMTEwLCJleHAiOjE2ODQ3NTk1MTAsInVzZXJpZCI6InNzYWZ5In0.xR9mCWowe_6fZK1wwhK2wqGWrgVXgolI_mOBeIaahBs'),(3,'user2','1234','po','u2@gmail.com','2023-05-15 08:30:32','U',NULL),(4,'user3','1234','monkey','u3@daum.net','2023-05-15 08:30:32','U',NULL),(5,'user4','1234','cute boy','u4@kakao.com','2023-05-15 08:30:32','U',NULL),(6,'user5','1234','tomboy','u5@ssafy.com','2023-05-15 08:30:32','U',NULL),(7,'userA','1234','king','ua@ssafy.com','2023-05-14 23:30:31','U',NULL),(8,'userB','1234','sky','ub@naver.com','2023-05-14 23:30:32','U',NULL),(9,'userC','1234','wowbow','uc@gmail.com','2023-05-14 23:30:32','U',NULL),(10,'userD','1234','okeydokey','ud@daum.net','2023-05-14 23:30:32','U',NULL),(11,'userE','1234','trip mania','ue@kakao.com','2023-05-14 23:30:32','U',NULL),(12,'userF','1234','hype boy','uf@ssafy.com','2023-05-14 23:30:32','U',NULL),(13,'asdf','asdf','바보','asdf@asdf.com','2023-05-17 15:00:00','U',NULL),(14,'df','fd','sts','sts@gmail.com','2023-05-19 10:56:10','U',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
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

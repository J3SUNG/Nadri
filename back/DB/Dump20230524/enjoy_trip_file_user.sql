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
-- Table structure for table `file_user`
--

DROP TABLE IF EXISTS `file_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `file_user` (
  `idx` int NOT NULL AUTO_INCREMENT,
  `user_no` int DEFAULT NULL,
  `save_folder` varchar(45) DEFAULT NULL,
  `original_file` varchar(50) DEFAULT NULL,
  `save_file` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idx`),
  KEY `user_no_idx` (`user_no`),
  CONSTRAINT `file_user.user_no` FOREIGN KEY (`user_no`) REFERENCES `user` (`user_no`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file_user`
--

LOCK TABLES `file_user` WRITE;
/*!40000 ALTER TABLE `file_user` DISABLE KEYS */;
INSERT INTO `file_user` VALUES (6,2,'230523','good2.jpg','553a88b1-2a75-4b50-9b43-4c9536e1cf60.jpg'),(7,3,'230523','po.jpg','f3e4e61d-9a8e-4f19-be8a-8cf7eeb41852.jpg'),(8,4,'230523','good3.jpg','6a19d31f-ffe6-42a7-8d30-c05126b4ea3b.jpg'),(9,5,'230523','finn.jpg','e7af5ec5-e735-4794-ac45-28715b24315c.jpg'),(10,6,'230523','cat.jpg','382e7a9b-0b16-40ea-952f-f55d21604501.jpg'),(11,7,'230523','mangu.jpg','d3d609c0-0aba-4ccd-853d-33564c7beb64.jpg'),(17,8,'230523','finn2.jpg','69623c12-7a72-41e8-a6b6-fc98b9ee68e7.jpg'),(58,1,'230523','user.png','4a9aece8-d077-49fe-90e2-461ced97aa60.png'),(67,26,'230523','cat.jpg','1f9618ad-afb1-4ef1-9f9f-26b075914eda.jpg');
/*!40000 ALTER TABLE `file_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-24  2:27:19

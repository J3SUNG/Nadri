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
-- Table structure for table `file_plan`
--

DROP TABLE IF EXISTS `file_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `file_plan` (
  `idx` int NOT NULL AUTO_INCREMENT,
  `plan_no` int DEFAULT NULL,
  `save_folder` varchar(45) DEFAULT NULL,
  `original_file` varchar(50) DEFAULT NULL,
  `save_file` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idx`),
  KEY `file_plan.plan_no_idx` (`plan_no`),
  CONSTRAINT `file_plan.plan_no` FOREIGN KEY (`plan_no`) REFERENCES `plan` (`plan_no`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file_plan`
--

LOCK TABLES `file_plan` WRITE;
/*!40000 ALTER TABLE `file_plan` DISABLE KEYS */;
INSERT INTO `file_plan` VALUES (1,9,'230521','test2.png','3f44647b-e108-4cdd-a0b0-b8b67d955711.png'),(2,9,'230521','test-image.png','baff9d83-2ee9-433b-9342-9c7355b57c1f.png'),(3,10,'230521','test2.png','11b3667f-fdd5-4113-8597-d8ae0b3ca203.png'),(4,11,'230521','test2.png','fa43c66e-dfd7-45b2-8350-243cdd9185e3.png'),(5,12,'230521','test2.png','5ef4f6dc-2dc5-4538-b41c-1d6221bae2cd.png');
/*!40000 ALTER TABLE `file_plan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-22 13:06:23

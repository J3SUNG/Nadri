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
-- Table structure for table `plan`
--

DROP TABLE IF EXISTS `plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plan` (
  `plan_no` int NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL,
  `subject` varchar(100) NOT NULL,
  `content` varchar(10000) NOT NULL,
  `start_date` timestamp NOT NULL,
  `end_date` timestamp NOT NULL,
  `read_count` int NOT NULL DEFAULT '0',
  `user_no` int DEFAULT NULL,
  `img` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`plan_no`),
  KEY `fk_plan_user_idx` (`user_no`),
  CONSTRAINT `fk_plan_user` FOREIGN KEY (`user_no`) REFERENCES `user` (`user_no`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plan`
--

LOCK TABLES `plan` WRITE;
/*!40000 ALTER TABLE `plan` DISABLE KEYS */;
INSERT INTO `plan` VALUES (1,'2023-05-16 08:27:01','첫번째 여행계획','멋진 여행계획을 만들어봤습니다.','2023-06-16 08:27:01','2023-06-23 08:27:01',43,1,'http://tong.visitkorea.or.kr/cms/resource/21/2657021_image2_1.jpg'),(2,'2023-05-10 08:32:16','두번째 여행계획','미친 여행계획을 만들어봤습니다.','2023-06-26 08:32:16','2023-06-28 08:32:16',52,2,'http://tong.visitkorea.or.kr/cms/resource/83/1070183_image2_1.jpg'),(3,'2023-05-16 15:49:48','세번째 여행계획','드디어 세번재 여행계획을 짜보았는데요. 짧게 1박 2일로 계획했습니다.','2023-08-17 08:27:01','2023-08-16 08:27:01',19,4,'http://tong.visitkorea.or.kr/cms/resource/29/2617229_image2_1.JPG'),(5,'2023-05-20 07:15:33','대단한 여행계획','대단한 여행계획을 말해주지','2020-02-22 15:00:00','2020-02-01 15:00:00',11,3,'http://tong.visitkorea.or.kr/cms/resource/62/219162_image2_1.jpg'),(13,'2023-05-23 15:48:17','여행 계획 더미 제목','여행 계획 더미 내용','2023-05-23 15:48:17','2023-05-23 15:48:17',1,4,'http://tong.visitkorea.or.kr/cms/resource/62/219162_image2_1.jpg'),(14,'2023-05-23 15:48:24','여행 계획 더미 제목','여행 계획 더미 내용','2023-05-23 15:48:24','2023-05-23 15:48:24',1,4,'http://tong.visitkorea.or.kr/cms/resource/62/219162_image2_1.jpg'),(15,'2023-05-23 15:48:25','여행 계획 더미 제목','여행 계획 더미 내용','2023-05-23 15:48:25','2023-05-23 15:48:25',0,4,'http://tong.visitkorea.or.kr/cms/resource/62/219162_image2_1.jpg'),(16,'2023-05-23 15:48:25','여행 계획 더미 제목','여행 계획 더미 내용','2023-05-23 15:48:25','2023-05-23 15:48:25',1,4,'http://tong.visitkorea.or.kr/cms/resource/62/219162_image2_1.jpg'),(17,'2023-05-23 15:48:26','여행 계획 더미 제목','여행 계획 더미 내용','2023-05-23 15:48:26','2023-05-23 15:48:26',1,4,'http://tong.visitkorea.or.kr/cms/resource/62/219162_image2_1.jpg'),(18,'2023-05-23 15:48:27','여행 계획 더미 제목','여행 계획 더미 내용','2023-05-23 15:48:27','2023-05-23 15:48:27',0,4,'http://tong.visitkorea.or.kr/cms/resource/62/219162_image2_1.jpg'),(19,'2023-05-23 15:48:27','여행 계획 더미 제목','여행 계획 더미 내용','2023-05-23 15:48:27','2023-05-23 15:48:27',0,4,'http://tong.visitkorea.or.kr/cms/resource/62/219162_image2_1.jpg'),(20,'2023-05-23 15:48:27','여행 계획 더미 제목','여행 계획 더미 내용','2023-05-23 15:48:27','2023-05-23 15:48:27',0,4,'http://tong.visitkorea.or.kr/cms/resource/62/219162_image2_1.jpg'),(21,'2023-05-23 15:48:28','여행 계획 더미 제목','여행 계획 더미 내용','2023-05-23 15:48:28','2023-05-23 15:48:28',0,4,'http://tong.visitkorea.or.kr/cms/resource/62/219162_image2_1.jpg'),(22,'2023-05-23 15:48:28','여행 계획 더미 제목','여행 계획 더미 내용','2023-05-23 15:48:28','2023-05-23 15:48:28',0,4,'http://tong.visitkorea.or.kr/cms/resource/62/219162_image2_1.jpg'),(23,'2023-05-23 15:48:29','여행 계획 더미 제목','여행 계획 더미 내용','2023-05-23 15:48:29','2023-05-23 15:48:29',0,4,'http://tong.visitkorea.or.kr/cms/resource/62/219162_image2_1.jpg');
/*!40000 ALTER TABLE `plan` ENABLE KEYS */;
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

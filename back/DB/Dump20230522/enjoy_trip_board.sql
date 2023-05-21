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
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board` (
  `board_no` int NOT NULL AUTO_INCREMENT,
  `board_type` int NOT NULL,
  `create_time` timestamp NOT NULL,
  `subject` varchar(40) NOT NULL,
  `content` varchar(10000) NOT NULL,
  `user_no` int DEFAULT NULL,
  PRIMARY KEY (`board_no`),
  KEY `fk_board_user1_idx` (`user_no`),
  CONSTRAINT `fk_board_user1` FOREIGN KEY (`user_no`) REFERENCES `user` (`user_no`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (1,0,'2022-01-02 15:00:00','사이트 배포 안내','사이트가 배포되었습니다. 축하해주세요',1),(2,0,'2022-02-02 15:00:00','22년 2월 사이트 점검 안내','점검 내용 : 2월 점검',1),(3,0,'2022-03-02 15:00:00','22년 3월 사이트 점검 안내','점검 내용 : 3월 점검 가나다라마바사아자차카타파하abcdefghijklmnopqlstuvwxyz1234567890가나다라마바사아자차카타파하abcdefghijklmnopqlstuvwxyz1234567890가나다라마바사아자차카타파하abcdefghijklmnopqlstuvwxyz1234567890',1),(4,0,'2022-04-02 15:00:00','22년 4월 사이트 점검 안내','점검 내용 : 4월 점검',1),(5,0,'2022-05-02 15:00:00','22년 5월 사이트 점검 안내','점검 내용 : 5월 점검',1),(6,0,'2022-06-02 15:00:00','22년 6월 사이트 점검 안내','점검 내용 : 6월 점검',1),(7,0,'2022-07-02 15:00:00','22년 7월 사이트 점검 안내','점검 내용 : 7월 점검',1),(8,0,'2022-08-02 15:00:00','22년 8월 사이트 점검 안내','점검 내용 : 8월 점검',1),(9,0,'2022-09-02 15:00:00','22년 9월 사이트 점검 안내','점검 내용 : 9월 점검',1),(10,0,'2022-10-02 06:39:54','22년 10월 사이트 점검 안내','점검 내용 : 10월 점검',1),(11,1,'2023-05-15 07:38:51','sub test11','con test1',2),(12,1,'2023-05-15 07:38:51','sub test12','con test2',2),(13,1,'2023-05-15 07:38:51','sub test13','con test3',2),(14,1,'2023-05-15 07:38:51','sub test14','con test4',2),(15,1,'2023-05-15 07:38:51','sub test15','con test5',2),(16,1,'2023-05-15 08:00:23','sub test11 con test1con test1con test1co','Lorem Ipsum is simply dummy text of the printing and typesetting industry. \nLorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, \nwhen an unknown printer took a galley of type and scrambled it to make a type \nspecimen book. It has survived not only five centuries, but also the leap into \nelectronic typesetting, remaining essentially unchanged. It was popularised in the \n1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more \nrecently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',3),(17,1,'2023-05-15 08:00:24','long long page','Lorem Ipsum is simply dummy text of the printing and typesetting industry. \nLorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, \nwhen an unknown printer took a galley of type and scrambled it to make a type \nspecimen book. It has survived not only five centuries, but also the leap into \nelectronic typesetting, remaining essentially unchanged. It was popularised in the \n1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more \nrecently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',3),(18,1,'2023-05-15 08:00:24','long long page','Lorem Ipsum is simply dummy text of the printing and typesetting industry. \nLorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, \nwhen an unknown printer took a galley of type and scrambled it to make a type \nspecimen book. It has survived not only five centuries, but also the leap into \nelectronic typesetting, remaining essentially unchanged. It was popularised in the \n1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more \nrecently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',3),(19,1,'2023-05-15 08:00:24','long long page','Lorem Ipsum is simply dummy text of the printing and typesetting industry. \nLorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, \nwhen an unknown printer took a galley of type and scrambled it to make a type \nspecimen book. It has survived not only five centuries, but also the leap into \nelectronic typesetting, remaining essentially unchanged. It was popularised in the \n1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more \nrecently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',3),(20,1,'2023-05-15 08:00:24','댓글 많은 페이지','Lorem Ipsum is simply dummy text of the printing and typesetting industry. \nLorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, \nwhen an unknown printer took a galley of type and scrambled it to make a type \nspecimen book. It has survived not only five centuries, but also the leap into \nelectronic typesetting, remaining essentially unchanged. It was popularised in the \n1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more \nrecently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',3),(21,1,'2023-05-15 07:38:51','댓글 테스트 페이지','con test1',4),(22,1,'2023-05-15 07:38:51','sub test22','con test2',4);
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-22  0:51:46

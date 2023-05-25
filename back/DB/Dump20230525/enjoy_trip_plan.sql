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
  `read_count` int NOT NULL DEFAULT '0',
  `user_no` int DEFAULT NULL,
  `img` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`plan_no`),
  KEY `fk_plan_user_idx` (`user_no`),
  CONSTRAINT `fk_plan_user` FOREIGN KEY (`user_no`) REFERENCES `user` (`user_no`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plan`
--

LOCK TABLES `plan` WRITE;
/*!40000 ALTER TABLE `plan` DISABLE KEYS */;
INSERT INTO `plan` VALUES (1,'2023-05-16 08:27:01','산림욕을 제대로 즐겨보시겠어요?','맑은 공기를 가득 담은 장소들로 여행 계획을 세워보았습니다.',58,1,'http://tong.visitkorea.or.kr/cms/resource/21/2657021_image2_1.jpg'),(2,'2023-05-10 08:32:16','문경 여행기','문경에 숨겨진 아름다운 여행지들을 소개합니다.',71,2,'http://tong.visitkorea.or.kr/cms/resource/83/1070183_image2_1.jpg'),(3,'2023-05-16 15:49:48','산! 산! 산!','드디어 세번재 여행계획을 짜보았는데요. 짧게 1박 2일로 계획했습니다. 저는 산을 아주 좋아합니다. 산은 곧 인생을 나타냅니다. 등산을 생활화 합시다.',37,4,'http://tong.visitkorea.or.kr/cms/resource/29/2617229_image2_1.JPG'),(5,'2023-05-20 07:15:33','추억이 깃든 여행지','제가 어린 시절 자주 갔었던 곳들을 소개합니다.',32,3,'http://tong.visitkorea.or.kr/cms/resource/62/219162_image2_1.jpg'),(41,'2023-05-24 08:25:40','준비되었다','사진도',6,1,'http://tong.visitkorea.or.kr/cms/resource/49/2653949_image2_1.jpg'),(46,'2023-05-25 08:06:56','대구의 역사와 현대를 만나는 다채로운 여행','안녕하세요! 대구는 한국의 역사와 현대 문화가 조화로운 도시로, 다양한 관광지와 맛집, 문화 ',4,12,'http://tong.visitkorea.or.kr/cms/resource/51/2653751_image2_1.jpg'),(47,'2023-05-25 08:26:54','울산 여행지 추천드려요~','울산의 숨겨진 명소!',2,10,'http://tong.visitkorea.or.kr/cms/resource/88/1588088_image2_1.jpg');
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

-- Dump completed on 2023-05-25 17:59:37

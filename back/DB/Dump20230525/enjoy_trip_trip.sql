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
-- Table structure for table `trip`
--

DROP TABLE IF EXISTS `trip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trip` (
  `trip_no` int NOT NULL AUTO_INCREMENT,
  `order` int NOT NULL,
  `memo` varchar(100) NOT NULL,
  `plan_no` int DEFAULT NULL,
  `attraction_no` int NOT NULL,
  PRIMARY KEY (`trip_no`),
  KEY `fk_trip_attraction_info1_idx` (`attraction_no`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip`
--

LOCK TABLES `trip` WRITE;
/*!40000 ALTER TABLE `trip` DISABLE KEYS */;
INSERT INTO `trip` VALUES (1,1,'맑은 공기로 힐링~',1,125266),(2,2,'새소리를 들으며 명상하기 좋은 곳',1,125405),(3,3,'경치도 좋고 공기도 좋고',1,125406),(4,1,'제가 정말 좋아하는 여행지에요.',2,125407),(5,2,'과학책에서 보던 퇴적암을 직접 관찰해보세요. 세월이 담겨 있습니다.',2,125408),(7,1,'산이 곧 인생이다.',3,125465),(8,2,'산은 평화롭다.',3,125467),(9,3,'산은 산이요, 물은 물이다.',3,125465),(11,1,'비슬산의 맑은 공기!',5,125406),(12,2,'어린 시절 추억이 깃든 장소',5,126130),(13,3,'마음의 평화',5,126160),(28,0,'순',41,126730),(29,1,'천',41,125416),(30,2,'만',41,506809),(34,0,'수성못은 데이트하기 좋은 장쇼죠~',46,1115613),(35,1,'대구 앞산공원과 대구 근대골목\n있습니다. 또한, 근대골목인 성서 근대골목',46,126132),(36,2,'대구 동성로와 서문시장\n대구의 대표적인 상업 지구인 동성로는 다양,',46,2745604),(37,0,'조용히 힐링하는 장소',47,304689),(38,1,'풍경이 아름다워요',47,129165);
/*!40000 ALTER TABLE `trip` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-25 17:59:38

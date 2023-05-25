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
-- Table structure for table `file_info`
--

DROP TABLE IF EXISTS `file_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `file_info` (
  `idx` int NOT NULL AUTO_INCREMENT,
  `board_no` int DEFAULT NULL,
  `save_folder` varchar(45) DEFAULT NULL,
  `original_file` varchar(50) DEFAULT NULL,
  `save_file` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idx`),
  KEY `board_no_idx` (`board_no`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file_info`
--

LOCK TABLES `file_info` WRITE;
/*!40000 ALTER TABLE `file_info` DISABLE KEYS */;
INSERT INTO `file_info` VALUES (37,221,'230522','all.png','646412d1-f2cd-4f10-8352-69ce9a2812f2.png'),(38,222,'230523','all.png','9f36f99d-c360-4e1b-9794-7dcca638ac8d.png'),(39,223,'230523','all.png','26f52cd3-233a-46e9-9807-5eac0e1f26f3.png'),(40,224,'230523','all.png','2f593055-55ed-40a4-a2ff-c2775eace283.png'),(41,225,'230523','all.png','c4fe5fd3-a77b-47a6-a17a-fb1ce36d378d.png'),(42,225,'230523','beach-umbrella.png','946319f2-6065-47e7-bf6c-6780163cdc2e.png'),(43,221,'230523','type_back_course.png','211d2240-664e-408b-a5fa-70b51ad89003.png'),(44,221,'230523','type_back_event.png','cee95fa0-a2ff-45f8-927e-4fd3ba9312fd.png'),(45,222,'230523','user.png','a70c9dae-74e0-487d-944f-4924fc1d16b3.png'),(46,223,'230523','user.png','979eb335-ddc7-4c8b-abfc-1d528f98dcbf.png'),(47,223,'230523','type_back_course.png','113d43ef-4672-41c1-ab4d-6c7be9be1980.png'),(48,224,'230523','finn2.jpg','74d30d19-ea47-453c-84af-63cb734d5827.jpg'),(49,224,'230523','jake.jpg','8bf098db-1bba-4a59-9aaf-fda6ce0e430b.jpg'),(50,224,'230523','finn.jpg','60ec4760-c6cb-45b1-b320-0b44b8bb9549.jpg'),(51,225,'230523','finn2.jpg','8f20cc4d-8456-4944-8bc8-ff542c198674.jpg'),(52,225,'230523','jake.jpg','5a320d5c-530c-4c13-91a4-83f53fce9124.jpg'),(53,225,'230523','finn.jpg','1ca4def0-af8c-4253-953a-cbbe8184f568.jpg'),(54,226,'230523','finn.jpg','22964d5c-2cf6-4010-bb13-b6dabd9ab5a3.jpg'),(55,226,'230523','mangu.jpg','9560c8ea-f738-443d-a892-71354da45121.jpg'),(56,227,'230523','user.png','84de0bbc-96d1-4a2f-94d5-3d9125f2d083.png'),(57,228,'230523','finn2.jpg','e1d0ea2b-1f58-4390-8a31-943b88775363.jpg'),(58,228,'230523','jake.jpg','69d121d6-b562-429b-a275-ea4ede32823d.jpg'),(59,228,'230523','finn.jpg','c7c5ae4c-4e21-4c22-8ce4-c43272140de8.jpg'),(60,228,'230523','mangu.jpg','368388d5-c1b4-4876-a416-5697ac2dc533.jpg'),(61,229,'230523','finn2.jpg','dc85cc2e-f880-422d-82dc-0bcae8779da5.jpg'),(62,230,'230523','mangu.jpg','e9ba7278-c879-4154-89b6-f53af4bbea5b.jpg'),(63,231,'230523','finn2.jpg','e2547ac0-7073-4af4-a2a6-7af9c7564bd4.jpg'),(64,231,'230523','jake.jpg','8060c5c2-c0a7-4227-b00b-83199a8392eb.jpg'),(65,231,'230523','finn.jpg','ddcf75af-e53e-472f-8583-e8bbc2c9780d.jpg'),(66,232,'230523','cat.jpg','3a6d662c-c6dd-4591-8a6e-9a2b8a05b1e1.jpg'),(67,233,'230523','type_back_food.png','a5896b4c-84c1-407b-8787-01e40c4d1221.png'),(68,234,'230523','mangu.jpg','2843cc90-16fc-447a-a040-009fd8a08e6f.jpg'),(69,234,'230523','bmo.jpg','70166f2c-ff98-4f4c-80d7-d386777b62f6.jpg'),(70,234,'230523','cat.jpg','d85a74b7-9524-43cb-a336-34bd08e67738.jpg'),(71,235,'230523','jetty.jpg','2cd3cfc9-f899-4757-899c-cc3bed2a992d.jpg'),(72,236,'230523','KakaoTalk_20210705_221439907.jpg','401e3256-3365-4b5a-bb7e-10cdbe3998d4.jpg'),(73,237,'230523','KakaoTalk_20210705_221439907.jpg','b9265e2f-a30a-42a2-af35-f50ee49bd84f.jpg'),(74,323,'230525','bmo.jpg','eeadbf6f-ab78-4b97-9b46-cf07a4d47dc2.jpg'),(75,323,'230525','cat.jpg','2a5e7da5-43b8-4f6a-bd2d-8217cc2359aa.jpg'),(76,334,'230525','finn.jpg','9661735d-8c9b-43fa-bb3a-2ac261ba8cc0.jpg'),(77,334,'230525','mangu.jpg','d103bed2-294d-45b2-81fc-217da306ee1a.jpg'),(78,335,'230525','cat.jpg','808a7cfd-2f2e-44f9-b8fb-4793d7882d3a.jpg'),(79,336,'230525','jake.jpg','e3fe6ef9-3512-4b56-acc7-74427a83c6c7.jpg'),(80,355,'230525','cat.jpg','382b9af5-71a9-4851-926a-6af349e5e2fc.jpg');
/*!40000 ALTER TABLE `file_info` ENABLE KEYS */;
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

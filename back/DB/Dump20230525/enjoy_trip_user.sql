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
  `join_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `grade` char(1) NOT NULL,
  `token` varchar(2000) DEFAULT NULL,
  `save_folder` varchar(50) DEFAULT '230521',
  `save_file` varchar(200) DEFAULT '979eb335-ddc7-4c8b-abfc-1d528f98dcbf.png',
  PRIMARY KEY (`user_no`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `nickname_UNIQUE` (`nickname`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb3 COMMENT='				';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'ssafy','79340e6f0a166da3ee1e28c2239c38698c651693fb1f3227c06311380c351dc8','ssafy','ssafy@ssafy.com','2023-05-15 08:30:31','A',NULL,'230523','4a9aece8-d077-49fe-90e2-461ced97aa60.png'),(2,'user1','b90d11770fc3396f0f1a34bc58dc3e63311d324cc1f369a805a6677700f613d1','바보','u1@naver.com','2023-05-15 08:30:32','U','eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyZWZyZXNoLXRva2VuIiwiaWF0IjoxNjg1MDA0MDA4LCJleHAiOjE2ODUwOTA0MDgsInVzZXJpZCI6ImpldHR5MTIifQ.7DElPHaKLU74Hr3Z2eF_I7VcPbJgX3EHEhwE_gazSEY','230523','553a88b1-2a75-4b50-9b43-4c9536e1cf60.jpg'),(3,'user2','b90d11770fc3396f0f1a34bc58dc3e63311d324cc1f369a805a6677700f613d1','po','u2@gmail.com','2023-05-15 08:30:32','U',NULL,'230523','f3e4e61d-9a8e-4f19-be8a-8cf7eeb41852.jpg'),(4,'user3','79340e6f0a166da3ee1e28c2239c38698c651693fb1f3227c06311380c351dc8','monkey','u3@daum.net','2023-05-15 08:30:32','U',NULL,'230523','6a19d31f-ffe6-42a7-8d30-c05126b4ea3b.jpg'),(5,'user4','b90d11770fc3396f0f1a34bc58dc3e63311d324cc1f369a805a6677700f613d1','cuteboy','u4@kakao.com','2023-05-15 08:30:32','U',NULL,'230523','6a19d31f-ffe6-42a7-8d30-c05126b4ea3b.jpg'),(6,'user5','b90d11770fc3396f0f1a34bc58dc3e63311d324cc1f369a805a6677700f613d1','tomboy','u5@ssafy.com','2023-05-15 08:30:32','U',NULL,'230523','382e7a9b-0b16-40ea-952f-f55d21604501.jpg'),(7,'userA','b90d11770fc3396f0f1a34bc58dc3e63311d324cc1f369a805a6677700f613d1','king','ua@ssafy.com','2023-05-14 23:30:31','U',NULL,'230523','d3d609c0-0aba-4ccd-853d-33564c7beb64.jpg'),(8,'userB','b90d11770fc3396f0f1a34bc58dc3e63311d324cc1f369a805a6677700f613d1','sky','sky@naver.com','2023-05-14 23:30:32','U',NULL,'230523','69623c12-7a72-41e8-a6b6-fc98b9ee68e7.jpg'),(9,'userC','b90d11770fc3396f0f1a34bc58dc3e63311d324cc1f369a805a6677700f613d1','wowbow','uc@gmail.com','2023-05-14 23:30:32','U',NULL,'230521','979eb335-ddc7-4c8b-abfc-1d528f98dcbf.png'),(10,'userD','b90d11770fc3396f0f1a34bc58dc3e63311d324cc1f369a805a6677700f613d1','okeydokey','ud@daum.net','2023-05-14 23:30:32','U',NULL,'230521','979eb335-ddc7-4c8b-abfc-1d528f98dcbf.png'),(11,'userE','b90d11770fc3396f0f1a34bc58dc3e63311d324cc1f369a805a6677700f613d1','trip mania','ue@kakao.com','2023-05-14 23:30:32','U',NULL,'230521','979eb335-ddc7-4c8b-abfc-1d528f98dcbf.png'),(12,'userF','b90d11770fc3396f0f1a34bc58dc3e63311d324cc1f369a805a6677700f613d1','hype boy','uf@ssafy.com','2023-05-14 23:30:32','U',NULL,'230521','979eb335-ddc7-4c8b-abfc-1d528f98dcbf.png'),(14,'df','b90d11770fc3396f0f1a34bc58dc3e63311d324cc1f369a805a6677700f613d1','sts','sts@gmail.com','2023-05-19 10:56:10','U',NULL,'230521','979eb335-ddc7-4c8b-abfc-1d528f98dcbf.png'),(18,'testest','b90d11770fc3396f0f1a34bc58dc3e63311d324cc1f369a805a6677700f613d1','test','test@na.com','2023-05-23 04:42:37','U',NULL,'230521','979eb335-ddc7-4c8b-abfc-1d528f98dcbf.png'),(26,'jetty1','79340e6f0a166da3ee1e28c2239c38698c651693fb1f3227c06311380c351dc8','jtjt','jjtt@jj.tt','2023-05-23 07:47:41','U',NULL,'230523','1f9618ad-afb1-4ef1-9f9f-26b075914eda.jpg'),(27,'hello','b90d11770fc3396f0f1a34bc58dc3e63311d324cc1f369a805a6677700f613d1','hello','hello@dd.dd','2023-05-20 15:00:00','U',NULL,'230521','979eb335-ddc7-4c8b-abfc-1d528f98dcbf.png'),(28,'asdfsdf','b90d11770fc3396f0f1a34bc58dc3e63311d324cc1f369a805a6677700f613d1','dfsdfds','string','2023-05-25 00:17:16','U',NULL,'230521','979eb335-ddc7-4c8b-abfc-1d528f98dcbf.png');
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

-- Dump completed on 2023-05-25 17:59:37

-- MySQL dump 10.13  Distrib 5.6.10, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: BusTicketManagement
-- ------------------------------------------------------
-- Server version	5.6.10

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bookingstatus`
--

DROP TABLE IF EXISTS `bookingstatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookingstatus` (
  `bookingid` int(11) NOT NULL AUTO_INCREMENT,
  `passengerid` int(11) DEFAULT NULL,
  `busid` int(11) DEFAULT NULL,
  `noofseats` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`bookingid`),
  KEY `passengerid` (`passengerid`),
  KEY `busid` (`busid`),
  CONSTRAINT `bookingstatus_ibfk_1` FOREIGN KEY (`passengerid`) REFERENCES `passenger` (`passengerid`) ON DELETE CASCADE,
  CONSTRAINT `bookingstatus_ibfk_2` FOREIGN KEY (`busid`) REFERENCES `busdetails` (`busid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookingstatus`
--

LOCK TABLES `bookingstatus` WRITE;
/*!40000 ALTER TABLE `bookingstatus` DISABLE KEYS */;
INSERT INTO `bookingstatus` VALUES (85,106,102,5,15,'2021-05-13'),(86,106,102,5,15,'2021-05-13'),(87,104,105,5,15,'2021-05-13'),(88,104,105,5,15,'2021-05-13'),(89,104,105,5,15,'2021-05-13'),(91,104,105,6,20,'2021-05-13'),(92,104,105,6,20,'2021-05-13'),(93,104,105,6,20,'2021-05-13'),(94,104,105,6,20,'2021-05-13'),(95,104,105,6,20,'2021-05-13'),(96,101,101,1,30,'2021-05-13');
/*!40000 ALTER TABLE `bookingstatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `busdetails`
--

DROP TABLE IF EXISTS `busdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `busdetails` (
  `busid` int(11) NOT NULL,
  `busno` varchar(45) DEFAULT NULL,
  `busdestination` varchar(45) DEFAULT NULL,
  `source` varchar(45) DEFAULT NULL,
  `seats` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`busid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `busdetails`
--

LOCK TABLES `busdetails` WRITE;
/*!40000 ALTER TABLE `busdetails` DISABLE KEYS */;
INSERT INTO `busdetails` VALUES (101,'DL1258','Anand Vihar','Vivek Vihar',19,30),(102,'DL4578','Kamal Vihar','Noida',45,15),(103,'DL4100','Sarojini','Mayur Vihar',5,10),(105,'DL78415','Preet Vihar','Geeta Colony',70,60),(110,'DL1258','Anand Vihar','Vivek Vihar',20,30),(111,'DL1258','Anand Vihar','Vivek Vihar',20,30);
/*!40000 ALTER TABLE `busdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passenger`
--

DROP TABLE IF EXISTS `passenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passenger` (
  `passengerid` int(11) NOT NULL,
  `passengername` varchar(45) DEFAULT NULL,
  `passengerusername` varchar(45) DEFAULT NULL,
  `passengerpassword` varchar(45) DEFAULT NULL,
  `passengeradd` varchar(45) DEFAULT NULL,
  `passengermobileno` int(11) DEFAULT NULL,
  `passengerdestination` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`passengerid`),
  UNIQUE KEY `passengerusername_UNIQUE` (`passengerusername`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passenger`
--

LOCK TABLES `passenger` WRITE;
/*!40000 ALTER TABLE `passenger` DISABLE KEYS */;
INSERT INTO `passenger` VALUES (100,'Kamlesh','Kamlesh@123','Kamlesh123','Nand Nagri',4784124,'Gonda'),(101,'Rohini Gaud','Rohini@123','Rohini123','Noida',784558,'Harsh Vihar'),(104,'Prashant','Prashant@123','Prashant123','Karol Bagh',78181484,'Badarpur'),(106,'Kajal','Kajal@123','Kajal123','Nagloi',9552659,'Jyoti Nagar'),(110,'Prashant','Prashant@1234','Prashant123','Karol Bagh',781814,'Badarpur'),(112,'Priyanka','Priyanka@123','Priyanka123','Karol Bagh',78181484,'Badarpur');
/*!40000 ALTER TABLE `passenger` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-13 21:58:21

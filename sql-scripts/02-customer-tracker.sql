CREATE DATABASE  IF NOT EXISTS `web_customer_tracker` ;
USE `web_customer_tracker`;

-- Table structure for table `customer`
DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table `customer`

LOCK TABLES `customer` WRITE;

INSERT INTO `customer` VALUES 
	(1,'Minh','Cong','minh@devpb.com'),
	(2,'Hang','Cao','minh@devpb.com'),
	(3,'Mun','Ta','mun@devpb.com'),
	(4,'Miu','Ta','miu@devpb.com'),
	(5,'Kem','Cao','kem@devpb.com');


UNLOCK TABLES;


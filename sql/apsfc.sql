/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.7.19 : Database - apsfc
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`apsfc` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `apsfc`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  `authority` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`id`,`name`,`pwd`,`authority`) values (1,'admin','123','1'),(2,'苏','123','0');

/*Table structure for table `menus` */

DROP TABLE IF EXISTS `menus`;

CREATE TABLE `menus` (
  `id` int(4) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `typeid` int(4) unsigned DEFAULT NULL,
  `burden` varchar(50) DEFAULT NULL COMMENT '配料',
  `brief` varchar(500) DEFAULT NULL COMMENT '说明',
  `price` float unsigned DEFAULT NULL COMMENT '市场价销售数量',
  `sums` int(4) unsigned DEFAULT '0' COMMENT '市场价销售数量',
  `price1` float unsigned DEFAULT NULL COMMENT '会员单价',
  `sums1` int(4) unsigned DEFAULT '0' COMMENT '会员价销售数量',
  `imgpath` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

/*Data for the table `menus` */

insert  into `menus`(`id`,`name`,`typeid`,`burden`,`brief`,`price`,`sums`,`price1`,`sums1`,`imgpath`) values (12,'粉蒸肉',10,'米粉、五花肉','暂无',26,0,23,0,'img/m_fenzhengrou.gif'),(14,'糖醋排骨',2,'排骨、糖、醋','暂无',26,0,24,4,'img/m_tangcupaigu.gif'),(15,'咸肉菜饭',1,'咸肉、米饭','暂无',15,0,12,4,'img/m_xianroucaifan.gif'),(17,'五香驴肉',1,'驴肉','暂无',25,0,21,1,'img/m_wuxianglvrou.gif'),(18,'黄瓜拉皮',1,'黄瓜、拉皮','暂无',8,0,6,1,'img/m_huanggualapi.gif'),(19,'水煮鱼',11,'鱼，辣椒','暂无',38,0,32,1,'img/m_shuizhuyu.gif'),(32,'粉丝',1,'淀粉','好吃不上火',10,0,9,0,'img/53625.jpg');

/*Table structure for table `notice` */

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `times` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8;

/*Data for the table `notice` */

insert  into `notice`(`id`,`name`,`content`,`times`) values (6,'新增菜单《糖醋排骨》','糖醋排骨超级好吃。再挑食的小朋友都无法拒绝酸甜的口味，吃光排骨，再用糖醋汁拌米饭，今天的饭量见长。','2015-02-28 13:49:40'),(7,'本店特色《咸菜肉饭》','记得小时候每每妈妈做咸肉菜饭，我都要吃上二大碗，那个香啊那个好吃啊，真的不知道怎样来形容。吃过的朋友，大家都懂的，呵呵!','2015-02-28 13:53:39'),(79,'111111','11111','2021-08-28 12:05:56');

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `userid` int(4) unsigned DEFAULT NULL,
  `menuid` int(4) unsigned DEFAULT NULL,
  `menusum` int(4) unsigned DEFAULT NULL,
  `times` varchar(20) DEFAULT NULL,
  `delivery` int(4) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

insert  into `orders`(`id`,`userid`,`menuid`,`menusum`,`times`,`delivery`) values (16,2,12,2,'2015-07-26 13:16:28',1),(17,1,14,1,'2015-07-26 13:23:30',1),(19,4,15,2,'2015-07-26 23:26:20',1),(23,4,14,1,'2015-07-27 00:35:09',1),(24,4,17,1,'2015-07-27 00:35:09',1),(25,2,15,1,'2015-07-27 20:14:23',1),(27,2,18,1,'2015-07-27 20:31:56',1),(28,2,19,1,'2015-07-27 20:31:56',1),(30,2,12,8,'2021-08-17 10:23:05',1),(31,2,14,9,'2021-08-17 10:23:05',1),(32,6,15,10,'2021-08-17 21:15:22',1),(34,6,15,7,'2021-08-17 21:21:31',1),(35,6,18,1,'2021-08-17 21:21:31',1),(39,6,14,3,'2021-08-17 22:37:45',1),(41,6,15,1,'2021-08-17 22:51:05',1),(42,6,18,1,'2021-08-17 22:51:05',1),(43,6,17,1,'2021-08-17 22:51:05',1),(61,6,14,1,'2021-08-17 23:41:27',0),(62,6,17,1,'2021-08-17 23:41:27',0),(63,2,14,2,'2021-08-28 13:00:37',1),(64,2,15,1,'2021-08-28 13:16:21',1),(65,2,14,1,'2021-08-28 13:16:21',1),(66,2,17,1,'2021-08-28 13:16:21',1),(67,2,15,1,'2021-08-28 13:16:26',1),(68,2,18,1,'2021-08-28 13:16:26',1),(69,2,19,1,'2021-08-28 13:16:26',0),(70,2,14,4,'2021-09-15 16:48:09',0),(71,1,14,2,'2021-09-15 17:13:36',0),(72,1,14,2,'2021-09-15 17:40:27',0),(73,1,14,4,'2021-09-15 17:45:18',0),(74,1,14,2,'2021-09-15 17:48:44',0),(75,1,14,2,'2021-09-15 17:50:05',0),(76,1,14,1,'2021-09-15 17:54:59',0),(77,1,14,3,'2021-09-15 17:55:29',0),(78,1,14,3,'2021-09-15 17:58:10',0),(79,1,14,1,'2021-09-15 18:03:21',0),(80,1,14,2,'2021-09-15 18:06:17',0),(81,1,14,1,'2021-09-15 18:10:55',0);

/*Table structure for table `types` */

DROP TABLE IF EXISTS `types`;

CREATE TABLE `types` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8;

/*Data for the table `types` */

insert  into `types`(`id`,`name`) values (1,'凉拌菜'),(2,'炒菜'),(6,'炒饭'),(10,'蒸菜'),(11,'川菜'),(87,'冷菜');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  `realname` varchar(20) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `age` int(4) unsigned DEFAULT NULL,
  `card` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `code` varchar(10) DEFAULT NULL,
  `type` int(4) unsigned DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`id`,`name`,`pwd`,`realname`,`sex`,`age`,`card`,`address`,`phone`,`email`,`code`,`type`) values (1,'1','1','sa','男',11,'111','安徽','11111111111','111111111','1111111111',NULL),(2,'222','123','2221','男',241,'211111111111111111','天津市','13988888888','123@163.com','110044',0),(3,'sunday','123','张三','男',26,'4222222222222222','北京市海淀区','13901001111','13901001111@139.com','101000',0),(4,'4','1','1','男',1,'1','1','1','1','1',0),(5,'何朝伟','123','何朝伟','男',20,'12345678','wefg','18056899303','2821188630@qq.com','111111',NULL),(6,'何2','123','何朝伟','女',20,'12345678','wefg','18056899303','2821188630@qq.com','111111',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.31 : Database - bookinfo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookinfo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bookinfo`;

/*Table structure for table `bookinfo` */

DROP TABLE IF EXISTS `bookinfo`;

CREATE TABLE `bookinfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `bookName` varchar(1024) DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  `nick` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

/*Data for the table `bookinfo` */

insert  into `bookinfo`(`id`,`bookName`,`price`,`nick`) values (21,'零基础学Python从入门到精通 python教程自学全套 编程入门零基础自学电脑计算机程序设计python编程从入门到实践书籍语言程序设计',34.90,'广东人民出版社旗舰店'),(22,'【当当网 正版】Python编程从入门到实践第2版 编程入门零基础自学核心编程教程书籍 数据分析网络爬虫深度学习语言程序设计蟒蛇书',66.80,'当当网官方旗舰店'),(23,'Python编程从入门到精通 计算机电脑编程入门自学零基础教程全套书籍 pathon编程从入门到实践python基础教程语言程序设计清华大学',24.00,'墨涵图书专营店'),(24,'Python编程从入门到精通 零基础学python数据分析教程书籍 网络爬虫基础实践 计算机语言开发核心实战 py3.7程序设计项目案例教材',34.80,'瑞雅图书专营'),(25,'【2020新版】Python编程从入门到实践第2版 Python3.9教程自学全套 语言程序开发网络爬虫开发计算机编程入门到精通零基础教材书籍',66.80,'博库图书专营店'),(26,'【共3册】Python编程从入门到实践+Python编程快速上手+Python极客项目编程 python编程语言从入门到精通程序设计书籍网络爬虫基础',159.80,'博库图书专营店'),(27,'深入理解JAVA虚拟机 JVM高级特性与最佳实践 第3三版 周志明 机工Java开发入门程序设计 计算机正版书籍编程教程 计算机组成原理书',84.00,'新华文轩网络书店'),(28,'【视频教学】Java编程从入门到实践 精通java语言程序设计电脑编程序员计算机软件开发教程JAVA编程入门零基础自学书籍javascript',24.00,'华心图书专营店'),(29,'【新华书店旗舰店官网】正版包邮 Python编程从入门到实践第2版/图灵程序设计丛书 Python3语言程序数据分析编程入门零基础教程',71.80,'浙江新华书店图书专营店'),(30,'【官方旗舰店】Python编程从入门到实践第2二版 python3编程从入门到实战程序设计基础从入门到精通python核心编程数据分析编程书',66.80,'人民邮电出版社官方旗舰店');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

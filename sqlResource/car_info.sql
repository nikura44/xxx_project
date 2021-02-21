/*
Navicat MySQL Data Transfer

Source Server         : xxx_project
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : xxx_project

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2021-02-21 15:02:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for car_info
-- ----------------------------
DROP TABLE IF EXISTS `car_info`;
CREATE TABLE `car_info` (
  `car_id` bigint NOT NULL AUTO_INCREMENT,
  `status` tinyint NOT NULL,
  `city` varchar(255) NOT NULL,
  `price` double(10,2) NOT NULL,
  `brand` varchar(255) NOT NULL,
  `model` varchar(255) NOT NULL,
  PRIMARY KEY (`car_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of car_info
-- ----------------------------
INSERT INTO `car_info` VALUES ('1', '1', '合肥', '500.00', '宝马', 'X3');
INSERT INTO `car_info` VALUES ('2', '1', '南京', '700.00', '宝马', 'X5');
INSERT INTO `car_info` VALUES ('3', '1', '郑州', '500.00', '奥迪', 'A4');
INSERT INTO `car_info` VALUES ('4', '1', '上海', '800.00', '奥迪', 'A7');
INSERT INTO `car_info` VALUES ('5', '1', '长沙', '1000.00', '奥迪', 'A8');
INSERT INTO `car_info` VALUES ('6', '1', '芜湖', '200.00', '奇瑞', 'QQ');

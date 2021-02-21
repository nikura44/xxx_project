/*
Navicat MySQL Data Transfer

Source Server         : xxx_project
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : xxx_project

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2021-02-21 15:02:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'xxx', '123456');
INSERT INTO `user` VALUES ('2', 'zyn', '555555');

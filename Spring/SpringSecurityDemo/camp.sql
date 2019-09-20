/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : 192.168.0.106:3306
Source Database       : camp

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-09-20 18:04:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for camp_role
-- ----------------------------
DROP TABLE IF EXISTS `camp_role`;
CREATE TABLE `camp_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of camp_role
-- ----------------------------
INSERT INTO `camp_role` VALUES ('1', 'admin');
INSERT INTO `camp_role` VALUES ('2', 'user');

-- ----------------------------
-- Table structure for camp_user
-- ----------------------------
DROP TABLE IF EXISTS `camp_user`;
CREATE TABLE `camp_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) DEFAULT NULL,
  `user_c_name` varchar(20) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `mobile` int(11) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `camp_user_name_index` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of camp_user
-- ----------------------------
INSERT INTO `camp_user` VALUES ('1', 'admin', 'admin', 'n7iSCaBtblh6CkVLskt6EQ==', '1111111111', '2019-09-20 16:14:23', '1');

-- ----------------------------
-- Table structure for camp_user_role
-- ----------------------------
DROP TABLE IF EXISTS `camp_user_role`;
CREATE TABLE `camp_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKelkl5k08y2ydbgti89sudqacj` (`role_id`),
  KEY `FKl5rauq0a3fwrp2x6ttsnatx7e` (`user_id`),
  CONSTRAINT `FKelkl5k08y2ydbgti89sudqacj` FOREIGN KEY (`role_id`) REFERENCES `camp_role` (`id`),
  CONSTRAINT `FKl5rauq0a3fwrp2x6ttsnatx7e` FOREIGN KEY (`user_id`) REFERENCES `camp_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of camp_user_role
-- ----------------------------
INSERT INTO `camp_user_role` VALUES ('1', '1', '1');
INSERT INTO `camp_user_role` VALUES ('2', '1', '2');

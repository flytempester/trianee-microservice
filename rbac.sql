/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : rbac

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2020-07-27 20:17:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'admin', null, null);

-- ----------------------------
-- Table structure for menu_info
-- ----------------------------
DROP TABLE IF EXISTS `menu_info`;
CREATE TABLE `menu_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu_info
-- ----------------------------
INSERT INTO `menu_info` VALUES ('1', '查看', null, null);
INSERT INTO `menu_info` VALUES ('2', '添加', null, null);
INSERT INTO `menu_info` VALUES ('3', '删除', null, null);
INSERT INTO `menu_info` VALUES ('4', '修改', null, null);

-- ----------------------------
-- Table structure for role_info
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_info
-- ----------------------------
INSERT INTO `role_info` VALUES ('1', 'user', null, null);
INSERT INTO `role_info` VALUES ('2', 'admin', null, null);
INSERT INTO `role_info` VALUES ('3', 'superAdmin', null, null);

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('1', '1', '1', null, null);
INSERT INTO `role_menu` VALUES ('2', '1', '2', null, null);
INSERT INTO `role_menu` VALUES ('3', '2', '2', null, null);
INSERT INTO `role_menu` VALUES ('4', '2', '3', null, null);
INSERT INTO `role_menu` VALUES ('5', '3', '1', null, null);
INSERT INTO `role_menu` VALUES ('6', '3', '2', null, null);
INSERT INTO `role_menu` VALUES ('7', '3', '3', null, null);
INSERT INTO `role_menu` VALUES ('8', '3', '4', null, null);

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'zs', '666', null, null);
INSERT INTO `user_info` VALUES ('2', 'ls', '777', null, null);
INSERT INTO `user_info` VALUES ('3', 'wy', '888', null, null);
INSERT INTO `user_info` VALUES ('4', 'ml', 'ml', null, null);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `creare_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1', null, null);
INSERT INTO `user_role` VALUES ('2', '2', '1', null, null);
INSERT INTO `user_role` VALUES ('3', '3', '2', null, null);
INSERT INTO `user_role` VALUES ('4', '4', '3', null, null);
INSERT INTO `user_role` VALUES ('5', '1', '2', null, null);

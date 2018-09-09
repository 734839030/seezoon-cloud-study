/*
 Navicat Premium Data Transfer

 Source Server         : 本机mysql
 Source Server Type    : MySQL
 Source Server Version : 50633
 Source Host           : localhost
 Source Database       : framework

 Target Server Type    : MySQL
 Target Server Version : 50633
 File Encoding         : utf-8

 Date: 09/09/2018 15:17:55 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `demo_user`
-- ----------------------------
DROP TABLE IF EXISTS `demo_user`;
CREATE TABLE `demo_user` (
  `id` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(30) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `create_by` varchar(32) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(32) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `create_by` (`create_by`),
  KEY `create_date` (`create_date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息';

SET FOREIGN_KEY_CHECKS = 1;

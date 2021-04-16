/*
 Navicat Premium Data Transfer

 Source Server         : yzw
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : yzwco

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 15/04/2021 21:07:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for workorder
-- ----------------------------
DROP TABLE IF EXISTS `workorder`;
CREATE TABLE `workorder`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `project_id` int(10) NOT NULL,
  `creater` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `order_level` int(1) NOT NULL,
  `create_date` date NOT NULL,
  `count` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `project_id`(`project_id`) USING BTREE,
  CONSTRAINT `project_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of workorder
-- ----------------------------
INSERT INTO `workorder` VALUES (1, 1, '张三', '办公用品', 2, '2021-04-09', 6);
INSERT INTO `workorder` VALUES (2, 2, '赵六', '客户会面推广', 1, '2021-04-07', 2);
INSERT INTO `workorder` VALUES (3, 1, '刘七', '采购笔记本', 2, '2021-04-09', 1);
INSERT INTO `workorder` VALUES (4, 2, '刘七', '客户会见', 2, '2021-04-09', 1);
INSERT INTO `workorder` VALUES (5, 2, '赵谦', '客户会面', 2, '2021-04-09', 0);
INSERT INTO `workorder` VALUES (6, 3, '孟珏', '售后处理描述', 3, '2021-04-10', 2);
INSERT INTO `workorder` VALUES (7, 2, '于八', '客户会谈商讨', 2, '2021-04-10', 1);
INSERT INTO `workorder` VALUES (8, 2, '瓦尼亚', '会见出版商', 3, '2021-04-11', 2);
INSERT INTO `workorder` VALUES (9, 2, '于六', '任务描述6', 2, '2021-04-14', 1);
INSERT INTO `workorder` VALUES (10, 1, '王思', '任务描述415', 2, '2021-04-15', 1);
INSERT INTO `workorder` VALUES (11, 1, '王九', '任务描述415-2', 3, '2021-04-15', 1);
INSERT INTO `workorder` VALUES (12, 3, '张四', '任务描述415-3', 1, '2021-04-15', 1);
INSERT INTO `workorder` VALUES (13, 3, '王五', '任务描述415-5', 3, '2021-04-15', 1);

SET FOREIGN_KEY_CHECKS = 1;

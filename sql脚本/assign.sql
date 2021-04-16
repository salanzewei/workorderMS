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

 Date: 15/04/2021 21:04:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for assign
-- ----------------------------
DROP TABLE IF EXISTS `assign`;
CREATE TABLE `assign`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `workorder_id` int(10) NULL DEFAULT NULL,
  `executor` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `execution_time` date NOT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `workorder_id`(`workorder_id`) USING BTREE,
  CONSTRAINT `workorder_id` FOREIGN KEY (`workorder_id`) REFERENCES `workorder` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of assign
-- ----------------------------
INSERT INTO `assign` VALUES (1, 1, '李四', '2021-04-09', '打印机采购');
INSERT INTO `assign` VALUES (2, 1, '王五', '2021-04-09', '文具采购');
INSERT INTO `assign` VALUES (3, 1, '王六', '2021-04-06', '采购订书机');
INSERT INTO `assign` VALUES (4, 1, '于鱼', '2021-03-28', '采购胶带');
INSERT INTO `assign` VALUES (5, 1, '于七', '2021-04-05', '购买鼠标');
INSERT INTO `assign` VALUES (6, 7, '于九', '2021-03-30', '客户聚餐');
INSERT INTO `assign` VALUES (7, 2, '赵三', '2021-04-06', '任务2');
INSERT INTO `assign` VALUES (8, 2, '赵五', '2021-04-07', '客户任务二');
INSERT INTO `assign` VALUES (9, 3, '张思', '2021-04-13', '任务三');
INSERT INTO `assign` VALUES (10, 6, '皮特', '2021-04-10', '勇于离开，撑住');
INSERT INTO `assign` VALUES (11, 6, '公爵', '2021-04-07', '卑鄙人，极端利己主义者');
INSERT INTO `assign` VALUES (12, 8, '安娜', '2021-04-12', '任务详情，放弃对阿辽沙的幻想，认清现实，回到家庭');
INSERT INTO `assign` VALUES (13, 8, '阿辽沙', '2021-03-28', '任务详情：虚伪，伪善，自我评价十分高尚，实质就是道德绑架他人');
INSERT INTO `assign` VALUES (14, 4, '刘十', '2021-03-29', '任务详情：客户会见');
INSERT INTO `assign` VALUES (15, 9, '于七', '2021-03-31', '任务描述1');
INSERT INTO `assign` VALUES (16, 10, '王思', '2021-04-16', '任务详情415');
INSERT INTO `assign` VALUES (17, 11, '王九', '2021-04-17', '任务描述415-1');
INSERT INTO `assign` VALUES (18, 12, '王六', '2021-04-20', '任务详情415-4');
INSERT INTO `assign` VALUES (19, 13, '于七', '2021-04-06', '任务详情415-5');

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES (1, '行政采购');
INSERT INTO `project` VALUES (2, '渠道推广');
INSERT INTO `project` VALUES (3, '售后工单');

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

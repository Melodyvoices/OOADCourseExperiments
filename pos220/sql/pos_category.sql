/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80031
 Source Host           : localhost:3306
 Source Schema         : pos220

 Target Server Type    : MySQL
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 06/11/2022 20:33:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pos_category
-- ----------------------------
DROP TABLE IF EXISTS `pos_category`;
CREATE TABLE `pos_category`  (
                                 `category_id` bigint(0) NOT NULL AUTO_INCREMENT,
                                 `category_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                                 `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                                 `create_time` datetime(0) NULL DEFAULT NULL,
                                 `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                                 `update_time` datetime(0) NULL DEFAULT NULL,
                                 PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pos_category
-- ----------------------------
INSERT INTO `pos_category` VALUES (1, '文具', NULL, '2022-11-06 20:23:12', NULL, NULL);
INSERT INTO `pos_category` VALUES (2, '日用品', NULL, '2022-11-06 20:25:52', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;

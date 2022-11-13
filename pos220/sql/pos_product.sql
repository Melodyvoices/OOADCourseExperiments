SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pos_product
-- ----------------------------
DROP TABLE IF EXISTS `pos_product`;
CREATE TABLE `pos_product`  (
                                `product_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '产品id',
                                `product_sn` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品编码',
                                `product_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品名称',
                                `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
                                `category_id` bigint(20) NULL DEFAULT NULL COMMENT '类别id',
                                `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
                                `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                                `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新者',
                                `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
                                PRIMARY KEY (`product_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pos_product
-- ----------------------------
INSERT INTO `pos_product` VALUES (1, '1001', '铅笔', 65.00, 1, NULL, '2022-06-26 15:43:22', NULL, NULL);
INSERT INTO `pos_product` VALUES (2, '1002', '日记本', 25.00, 1, NULL, '2022-06-26 15:43:26', NULL, NULL);
INSERT INTO `pos_product` VALUES (3, '1003', '铅笔盒', 45.00, 1, NULL, '2022-06-26 15:43:29', NULL, NULL);
INSERT INTO `pos_product` VALUES (4, '1004', '毛巾', 10.00, 2, NULL, '2022-06-26 15:43:32', NULL, NULL);
INSERT INTO `pos_product` VALUES (5, '1005', '香波', 80.00, 2, NULL, '2022-06-26 15:43:35', NULL, NULL);
INSERT INTO `pos_product` VALUES (6, '1006', '拖鞋', 30.00, 2, NULL, '2022-06-26 15:43:38', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
CREATE TABLE IF NOT EXISTS `account`  (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '账户状态',
  `account_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '账户类型：注册用户/游客',
  `equipment` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备号',
  `phone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '账号',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `town_id` int(11) DEFAULT NULL COMMENT '小镇id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id`(`id`, `equipment`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 94502 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '账户表' ROW_FORMAT = Dynamic;

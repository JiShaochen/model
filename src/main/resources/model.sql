CREATE TABLE `account` (
   `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
   `user_name` varchar(49) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '账户名称',
   `status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '账户状态',
   `account_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '账户类型：注册用户/游客',
   `equipment` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备号',
   `phone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '账号',
   `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
   `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
   `town_id` int DEFAULT NULL COMMENT '小镇id',
   PRIMARY KEY (`id`) USING BTREE,
   KEY `id` (`id`,`equipment`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='账户表';
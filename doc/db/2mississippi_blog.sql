USE mississippi_blog;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
                             `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
                             `username` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登录账号',
                             `real_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '真实名字',
                             `nickname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '昵称',
                             `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
                             `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
                             `gender` tinyint(1) NULL DEFAULT -1 COMMENT '性别(未知:-1,男:1,女:0. 默认：-1)',
                             `email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电子邮件',
                             `mobile` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号',
                             `status` tinyint(1) NULL DEFAULT NULL COMMENT '状态(1-正常,0-冻结)',
                             `wx_openid` varchar(32) DEFAULT NULL COMMENT '微信登录openId',
                             `mini_openid` varchar(32) DEFAULT NULL COMMENT '小程序openId',
                             `qq_openid` varchar(32) DEFAULT NULL COMMENT 'QQ openId',
                             `dept_id` int(11) NULL DEFAULT NULL COMMENT '部门ID',
                             `deleted` bigint(20) NULL DEFAULT 0 COMMENT '逻辑删除标识，未删除为 0，已删除为删除时间',
                             `create_by` int(11) NULL DEFAULT NULL COMMENT '创建人',
                             `update_by` int(11) NULL DEFAULT NULL COMMENT '修改人',
                             `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                             PRIMARY KEY (`id`) USING BTREE,
                             UNIQUE INDEX `uk_username_deleted`(`username`, `deleted`) USING BTREE,
                             INDEX `idx_wx_openid` (`wx_openid`) USING BTREE,
                             INDEX `idx_qq_openid` (`qq_openid`) USING BTREE,
                             INDEX `idx_dept_id`(`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100  CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表';


DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
                             `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                             `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部门名称',
                             `deleted` bigint(20) NULL DEFAULT 0 COMMENT '逻辑删除标识，未删除为 0，已删除为删除时间',
                             `create_by` int(11) NULL DEFAULT NULL COMMENT '创建者',
                             `update_by` int(11) NULL DEFAULT NULL COMMENT '修改者',
                             `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100  CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '部门表';


DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
                             `id` int(11) NOT NULL AUTO_INCREMENT,
                             `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                             `code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                             `remark` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
                             `deleted` bigint(20) NULL DEFAULT 0 COMMENT '逻辑删除标识，未删除为 0，已删除为删除时间',
                             `create_by` int(11) NULL DEFAULT NULL COMMENT '创建人',
                             `update_by` int(11) NULL DEFAULT NULL COMMENT '修改人',
                             `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                             PRIMARY KEY (`id`) USING BTREE,
                             UNIQUE INDEX `uk_code_deleted`(`code`, `deleted`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100  CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统角色表';


DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
                                  `id` int(11) NOT NULL AUTO_INCREMENT,
                                  `user_id` int(11) NOT NULL COMMENT '用户ID',
                                  `role_id` int(11) NOT NULL COMMENT '用户ID',
                                  PRIMARY KEY (`id`) USING BTREE,
                                  UNIQUE INDEX `uk_userId_roleId`(`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色表';

SET FOREIGN_KEY_CHECKS = 1;
-- ----------------------------
-- Table structure for gundam_user
-- ----------------------------
DROP TABLE IF EXISTS `gundam_user`;
CREATE TABLE `gundam_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(255) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '姓名',
  `gender` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT 'unknown' COMMENT '性别:男、male，女、female，未知、unknown',
  `age` int(10) NOT NULL DEFAULT '0' COMMENT '年龄',
  `state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态:-1、禁止用户，0、正常用户，1、机器人',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `updated_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户基础信息表';

-- ----------------------------
-- Records of gundam_user
-- ----------------------------
BEGIN;
INSERT INTO `gundam_user` VALUES (1, 'renjie', 'male', 18, 0, '2019-06-19 16:30:58', '2019-06-19 16:30:58');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

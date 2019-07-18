CREATE TABLE `sys_email` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `EMAIL` varchar(30) NOT NULL COMMENT '服务邮箱',
  `SMTP_HOST` varchar(20) NOT NULL COMMENT 'smtp服务商地址',
  `SMTP_PORT` int(11) DEFAULT '465' COMMENT 'smtp端口',
  `AUTH_CODE` varchar(50) DEFAULT '' COMMENT '邮箱授权码',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='服务邮箱表';
CREATE TABLE `client_email` (
  `USER_ID` bigint(20) NOT NULL COMMENT '用户id',
  `EMAIL` varchar(30) NOT NULL DEFAULT '' COMMENT '邮箱地址'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='客户邮箱关联表';

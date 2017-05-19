/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50628
Source Host           : 127.0.0.1:3306
Source Database       : aosuite

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2017-04-08 00:49:22
*/

-- ----------------------------
-- Table structure for aos_module
-- ----------------------------
DROP TABLE IF EXISTS `crm_module`;
CREATE TABLE `crm_module` (
  `id` int(10) NOT NULL COMMENT '功能模块流水号',
  `cascade_id` varchar(255) NOT NULL COMMENT '节点语义ID',
  `parent_id` int(10) NOT NULL COMMENT '父节点流水号',
  `name` varchar(255) NOT NULL COMMENT '功能模块名称',
  `url` varchar(255) DEFAULT NULL COMMENT '主页面URL',
  `icon_name` varchar(255) DEFAULT NULL COMMENT '节点图标文件名称',
  `is_leaf` varchar(255) NOT NULL COMMENT '是否叶子节点',
  `is_auto_expand` varchar(255) NOT NULL COMMENT '是否自动展开',
  `is_enable` varchar(255) NOT NULL COMMENT '是否启用',
  `vector` varchar(255) DEFAULT NULL COMMENT '矢量图标',
  `sort_no` int(10) DEFAULT NULL COMMENT '排序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='功能模块表';

-- ----------------------------
-- Records of aos_module
-- ----------------------------
INSERT INTO `crm_module` VALUES ('-1', '0.001.008.003', '45', '角色管理', 'roleService.init', 'own.png', '1', '0', '1', '', '30');
INSERT INTO `crm_module` VALUES ('26', '0', '0', 'crm系统', '', 'home.png', '0', '1', '1', '', '1');
INSERT INTO `crm_module` VALUES ('27', '0.001', '26', '客户管理', '', 'folder1.png', '0', '1', '1', 'fa-bug', '10');
INSERT INTO `crm_module` VALUES ('38', '0.002', '26', '系统管理', '', 'folder22.png', '0', '1', '1', 'fa-cogs', '10');
INSERT INTO `crm_module` VALUES ('45', '0.002.008', '38', '权限', '', 'folder1.png', '0', '1', '1', '', '20');
INSERT INTO `crm_module` VALUES ('46', '0.002.008.001', '45', '部门管理', 'orgService.init', 'org.png', '1', '0', '1', '', '10');
INSERT INTO `crm_module` VALUES ('47', '0.002.008.002', '45', '用户管理', 'userService.init', 'user6.png', '1', '0', '1', '', '20');
INSERT INTO `crm_module` VALUES ('49', '0.002.009', '38', '监控', '', 'folder1.png', '0', '1', '1', '', '30');
INSERT INTO `crm_module` VALUES ('50', '0.002.009.001', '49', '在线用户', 'onlineUserService.init', 'text_list.png', '1', '0', '1', '', '10');

-- ----------------------------
-- Table structure for aos_org
-- ----------------------------
DROP TABLE IF EXISTS `crm_org`;
CREATE TABLE `crm_org` (
  `id` int(10) NOT NULL COMMENT '流水号',
  `cascade_id` varchar(255) NOT NULL COMMENT '节点语义ID',
  `name` varchar(255) NOT NULL COMMENT '组织名称',
  `hotkey` varchar(255) DEFAULT NULL COMMENT '热键',
  `parent_id` int(10) NOT NULL COMMENT '父节点流水号',
  `is_leaf` varchar(255) NOT NULL COMMENT '是否叶子节点',
  `is_auto_expand` varchar(255) NOT NULL COMMENT '是否自动展开',
  `icon_name` varchar(255) DEFAULT NULL COMMENT '节点图标文件名称',
  `type` varchar(255) NOT NULL COMMENT '组织类型',
  `biz_code` varchar(255) DEFAULT NULL COMMENT '扩展码',
  `sort_no` int(10) DEFAULT NULL COMMENT '排序号',
  `remark` varchar(4000) DEFAULT NULL COMMENT '备注',
  `is_del` varchar(255) NOT NULL COMMENT '是否已删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` int(10) NOT NULL COMMENT '创建人ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织表';


-- ----------------------------
-- Records of aos_org
-- ----------------------------
INSERT INTO `crm_org` VALUES ('-1', '0', '总公司', '', '0', '0', '1', 'home.png', '1', '', '1', '', '0', '2016-08-12 17:38:32', '-1');
INSERT INTO `crm_org` VALUES ('73', '0.001', '研发部', '', '-1', '0', '1', '', '1', '', '1', '', '0', '2016-09-06 10:31:11', '-1');
INSERT INTO `crm_org` VALUES ('74', '0.002', '市场部', '', '73', '1', '0', '', '1', '', '1', null, '0', '2016-09-06 10:33:05', '-1');
INSERT INTO `crm_org` VALUES ('251', '0.001.001', '测试', null, '73', '1', '0', null, '1', null, '2', null, '1', '2017-03-25 09:01:42', '-1');

-- ----------------------------
-- Table structure for aos_role
-- ----------------------------
DROP TABLE IF EXISTS `crm_role`;
CREATE TABLE `crm_role` (
  `id` int(10) NOT NULL COMMENT ' 流水号',
  `name` varchar(255) NOT NULL COMMENT '角色名称',
  `is_enable` varchar(255) NOT NULL COMMENT '是否启用',
  `type` varchar(255) NOT NULL COMMENT '角色类型',
  `biz_code` varchar(255) DEFAULT NULL COMMENT '扩展码',
  `remark` varchar(4000) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` int(10) NOT NULL COMMENT '创建人ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of aos_role
-- ----------------------------
INSERT INTO `crm_role` VALUES ('-1', '超级用户角色', '1', '1', null, null, '2016-08-14 14:18:28', '-1');
INSERT INTO `crm_role` VALUES ('296', '测试角色', '1', '1', '', '', '2017-03-26 23:42:34', '-1');

-- ----------------------------
-- Table structure for aos_role_module
-- ----------------------------
DROP TABLE IF EXISTS `crm_role_module`;
CREATE TABLE `crm_role_module` (
  `id` int(10) NOT NULL COMMENT '流水号',
  `role_id` int(10) NOT NULL COMMENT ' 角色流水号',
  `module_id` int(10) NOT NULL COMMENT '功能模块流水号',
  `grant_type` varchar(255) NOT NULL COMMENT '权限类型',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` int(10) NOT NULL COMMENT '创建人ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `aos_sys_module_role_ukey` (`role_id`,`module_id`,`grant_type`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='功能模块-角色关联表';

-- ----------------------------
-- Records of aos_role_module
-- ----------------------------
INSERT INTO `crm_role_module` VALUES ('393', '-1', '-1', '1', '2017-04-08 00:48:45', '-1');
INSERT INTO `crm_role_module` VALUES ('394', '-1', '26', '1', '2017-04-08 00:48:45', '-1');
INSERT INTO `crm_role_module` VALUES ('395', '-1', '27', '1', '2017-04-08 00:48:45', '-1');
INSERT INTO `crm_role_module` VALUES ('396', '-1', '38', '1', '2017-04-08 00:48:45', '-1');
INSERT INTO `crm_role_module` VALUES ('397', '-1', '45', '1', '2017-04-08 00:48:45', '-1');
INSERT INTO `crm_role_module` VALUES ('398', '-1', '46', '1', '2017-04-08 00:48:45', '-1');
INSERT INTO `crm_role_module` VALUES ('399', '-1', '47', '1', '2017-04-08 00:48:45', '-1');
INSERT INTO `crm_role_module` VALUES ('400', '-1', '49', '1', '2017-04-08 00:48:45', '-1');
INSERT INTO `crm_role_module` VALUES ('401', '-1', '50', '1', '2017-04-08 00:48:45', '-1');


-- ----------------------------
-- Table structure for aos_user
-- ----------------------------
DROP TABLE IF EXISTS `crm_user`;
CREATE TABLE `crm_user` (
  `id` int(10) NOT NULL COMMENT '流水号',
  `account` varchar(255) NOT NULL COMMENT '用户登录帐号',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `name` varchar(255) NOT NULL COMMENT '用户姓名',
  `sex` varchar(255) NOT NULL COMMENT '性别',
  `status` varchar(255) NOT NULL COMMENT '用户状态',
  `type` varchar(255) NOT NULL COMMENT '用户类型',
  `org_id` int(10) NOT NULL COMMENT '所属部门流水号',
  `email` varchar(255) DEFAULT NULL COMMENT '电子邮件',
  `mobile` varchar(255) DEFAULT NULL COMMENT '联系电话',
  `idno` varchar(255) DEFAULT NULL COMMENT '身份证号',
  `skin` varchar(255) NOT NULL COMMENT '用户界面皮肤',
  `biz_code` varchar(255) DEFAULT NULL COMMENT '业务对照码',
  `address` varchar(500) DEFAULT NULL COMMENT '联系地址',
  `remark` varchar(4000) DEFAULT NULL COMMENT '备注',
  `is_del` varchar(255) NOT NULL COMMENT '是否已删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` int(10) NOT NULL COMMENT '创建人ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户基本信息表';

-- ----------------------------
-- Records of aos_user
-- ----------------------------
INSERT INTO `crm_user` VALUES ('-1', 'root', 'a2c292420f2af5038fefd1bb63eeb736', '超级用户', '1', '1', '1', '-1', '', '', '', 'blue', '', '', '', '0', '2016-08-12 17:38:19', '-1');
INSERT INTO `crm_user` VALUES ('353', 'lilei', 'a2c292420f2af5038fefd1bb63eeb736', '李雷', '3', '1', '1', '74', null, null, null, 'blue', null, null, null, '0', '2017-03-27 18:20:28', '-1');

-- ----------------------------
-- Table structure for aos_user_role
-- ----------------------------
DROP TABLE IF EXISTS `crm_user_role`;
CREATE TABLE `crm_user_role` (
  `id` int(10) NOT NULL COMMENT '流水号',
  `user_id` int(10) NOT NULL COMMENT '用户流水号',
  `role_id` int(10) NOT NULL COMMENT '角色流水号',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` int(10) NOT NULL COMMENT '创建人ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `aos_sys_user_role_ukey` (`user_id`,`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-角色关联表';

-- ----------------------------
-- Records of aos_user_role
-- ----------------------------
INSERT INTO `crm_user_role` VALUES ('295', '-1', '-1', '2017-03-26 23:41:49', '-1');
INSERT INTO `crm_user_role` VALUES ('356', '353', '296', '2017-03-28 18:30:00', '-1');


-- ----------------------------
-- Table structure for demo_account
-- ----------------------------
DROP TABLE IF EXISTS `crm_custom`;
CREATE TABLE `crm_custom` (
  `id` int(10) NOT NULL COMMENT '流水号',
  `name` varchar(255) NOT NULL COMMENT '客户名称',
  `address` varchar(255) DEFAULT NULL COMMENT '客户地址',
  `custom_name` varchar(20) DEFAULT NULL COMMENT '接口人名称',
  `custom_sex` varchar(2) DEFAULT NULL COMMENT '接口人性别',
  `custom_birthday` date DEFAULT NULL COMMENT '接口人生日',
  `custom_age` int(255) DEFAULT NULL COMMENT '接口人年龄',
  `custom_id_no` varchar(255) DEFAULT NULL COMMENT '接口人身份证号',
  `custom_number` varchar(20) DEFAULT NULL COMMENT '接口人电话',
  `custom_org` varchar(255) DEFAULT NULL COMMENT '接口人所属机构',
  `custom_addr` varchar(255) DEFAULT NULL COMMENT '接口人地址',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` varchar(64) NOT NULL COMMENT '创建人ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户管理表';

-- ----------------------------
-- Table structure for demo_account
-- ----------------------------
DROP TABLE IF EXISTS `crm_custom_software`;
CREATE TABLE `crm_custom_software` (
  `id` int(10) NOT NULL COMMENT '流水号',
  `custom_id` int(10) NOT NULL COMMENT '客户流水号',
  `client_id` varchar(255) NOT NULL COMMENT '客户端标识',
  `client_type` varchar(10) NOT NULL COMMENT '客户端类型',
  `create_time` datetime NOT NULL COMMENT '客户端注册时间',
  `create_user_id` varchar(64) NOT NULL COMMENT '创建人ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='软件注册表';

-- ----------------------------
-- Table structure for demo_account
-- ----------------------------
DROP TABLE IF EXISTS `crm_project`;
CREATE TABLE `crm_project` (
  `id` int(10) NOT NULL COMMENT '流水号',
  `name` varchar(50) NOT NULL COMMENT '项目名',
  `comments` varchar(255) NOT NULL COMMENT '项目介绍',
  `engineer` varchar(20) NOT NULL COMMENT '项目负责人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` varchar(64) NOT NULL COMMENT '创建人ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='软件注册表';

-- ----------------------------
-- Table structure for demo_account
-- ----------------------------
DROP TABLE IF EXISTS `crm_project_implement`;
CREATE TABLE `crm_project_implement` (
  `id` int(10) NOT NULL COMMENT '流水号',
  `project_id` int(10) NOT NULL COMMENT '项目流水号',
  `custom_id` varchar(255) NOT NULL COMMENT '项目介绍',
  `implement_engineer` varchar(20) NOT NULL COMMENT '实施工程师',
  `implement_time` datetime NOT NULL COMMENT '实施时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` varchar(64) NOT NULL COMMENT '创建人ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目实施表';
























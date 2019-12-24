```

-- 用户系统金币发放管理
CREATE TABLE `wk_sys_gold_manage` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `user_id` varchar(32) NOT NULL DEFAULT '' COMMENT '用户编号',
  `phone` varchar(20) NOT NULL DEFAULT '' COMMENT '手机号',
  `operate_type` int(1) NOT NULL DEFAULT '0' COMMENT '操作类型：1-发放，2-扣除',
  `gold_amount` int(11) NOT NULL DEFAULT '0' COMMENT '金币数量',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `IDX_USER_ID` (`USER_ID`) USING BTREE,
  KEY `IDX_PHONE_NUM` (`phone`) USING BTREE,
  KEY `IDX_OPERATE_TYPE` (`OPERATE_TYPE`) USING BTREE,
  KEY `IDX_CREATE_TIME` (`CREATE_TIME`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户系统金币发放管理';


功能点开发时长评估：
功能点3: 2天；
功能点4,6,10 1天；
共3天



什么时候触发绑定关系？
   被邀请者关注之前确定绑定关系。


--绑定关系表：
drop table `qrcode_invite_relation`;
CREATE TABLE `qrcode_invite_relation` (
  `binding_relation_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `from_open_id` varchar(50) NOT NULL COMMENT '邀请人微信openId',
  `invited_open_id` varchar(50) NOT NULL COMMENT '被邀请人微信openId',
  `status` int(1) DEFAULT '1' COMMENT '绑定状态：1-绑定初始化（未认证），2-已认证',
  `award_amount` int(2) DEFAULT '0' COMMENT '累计奖励',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  `remark` varchar(100) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`binding_relation_id`),
  UNIQUE KEY `UNIQ_INVITED_OPEN_ID` (`invited_open_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='二维码邀请关注关联表';





-- 用户认证信息表
drop table `user_cert_info`;
CREATE TABLE `user_cert_info` (
  `user_id` varchar(32) NOT NULL COMMENT '用户编号',
  `phone_num` varchar(20) NOT NULL COMMENT '注册手机号',
  `real_name` varchar(50) DEFAULT '' COMMENT '真实姓名',
  `cert_code` varchar(20) DEFAULT '' COMMENT '身份证号',
  `company_name` varchar(50) DEFAULT '' COMMENT '公司全称',
  `company_type` varchar(20) DEFAULT '' COMMENT '公司类型',
  `front_card_url` varchar(250) NOT NULL DEFAULT '' COMMENT '身份证正面URL',
  `back_card_url` varchar(250) NOT NULL DEFAULT '' COMMENT '身份证反面URL',
  `hand_card_url` varchar(250) NOT NULL DEFAULT '' COMMENT '手持身份证URL',
  `state` int(1) DEFAULT '1' COMMENT '用户状态：1-待审核，2-认证通过，3-认证未通过',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `audit_man` varchar(20) NOT NULL DEFAULT '' COMMENT '审核人',
  `audit_time` datetime DEFAULT NULL COMMENT '审核时间',
  `remark` varchar(250) DEFAULT '' COMMENT '审核结果备注',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UNIQ_PHONE_NUM` (`phone_num`) USING BTREE,
  KEY `IDX_CREATETIME` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户认证信息表';

    ALTER TABLE `user_cert_info`
    ADD COLUMN `job_city_name` varchar(20) NOT NULL DEFAULT '' COMMENT '所在城市',
    ADD COLUMN `company_logo_url` varchar(250) NOT NULL DEFAULT '' COMMENT '公司logo合照',
    ADD COLUMN `business_card_url` varchar(250) NOT NULL DEFAULT '' COMMENT '工牌或名片';


  CREATE TABLE `ad_management_market` (
  `id` int(12)  NOT NULL AUTO_INCREMENT COMMENT '主键',
  `management_id`int(12)  NOT NULL DEFAULT '0' COMMENT '广告配置编号',
  `market` varchar(32) NOT NULL DEFAULT '0' COMMENT '市场渠道编号',
  PRIMARY KEY (`id`),
  KEY `market` (`market`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='广告表渠道关联表';

    CREATE TABLE `bottom_icon_market` (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `icon_id` int(10) NOT NULL DEFAULT '0' COMMENT 'icon主键编号',
  `market` varchar(32) NOT NULL DEFAULT '0' COMMENT '市场渠道编号',
  PRIMARY KEY (`id`),
  KEY `market` (`market`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

-- 积分账户表
drop table `integral_account`;
CREATE TABLE `integral_account` (
  `integel_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '积分账户编号',
  `user_id` varchar(32) NOT NULL COMMENT '用户编号',
  `balance` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '积分账户余额',
  `freezing_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '冻结积分',
  `withdrawable_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '可使用积分',
  `cumulative_income` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '累计收入',
  `cumulative_withdrawable` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '累计消耗',
  `state` int(1) NOT NULL DEFAULT '1' COMMENT '账户状态：1-正常，2-冻结',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `modify_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`integel_id`),
  UNIQUE KEY `idx_user_id` (`user_id`) USING BTREE COMMENT '用户编号索引'
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='积分账户表';


-- 积分流水表
drop table `integral_flow`;
CREATE TABLE `integral_flow` (
  `integel_flow_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '流水编号',
  `user_id` varchar(32) NOT NULL COMMENT '用户编号',
  `outer_order_id` varchar(50) DEFAULT NULL COMMENT '外部订单编号',
  `integel` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '变更积分',
  `source` int(1) NOT NULL DEFAULT '0' COMMENT '流水来源：0-系统赠送，1-注册，2-认证，3-抢单赠送，4-充值赠送，5-抢单消费，6-退回，7-邀请好友-实名认证',
  `exchange_type` int(1) NOT NULL DEFAULT '1' COMMENT '变更类型：1-入账、2-出账',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `remark` varchar(250) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`integel_flow_id`),
  KEY `idx_user_id` (`user_id`) USING BTREE COMMENT '用户编号索引'
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='积分流水表';


-- 金币账户表
drop table `gold_account`;
CREATE TABLE `gold_account` (
  `gold_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '金币账户编号',
  `user_id` varchar(32) NOT NULL COMMENT '用户编号',
  `balance` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '金币账户余额',
  `freezing_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '冻结积分',
  `withdrawable_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '可使用金币',
  `cumulative_income` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '累计收入',
  `cumulative_withdrawable` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '累计消耗',
  `state` int(1) NOT NULL DEFAULT '1' COMMENT '账户状态：1-正常，2-冻结',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `modify_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`gold_id`),
  UNIQUE KEY `idx_user_id` (`user_id`) USING BTREE COMMENT '用户编号索引'
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='金币账户表';

-- 金币流水表
drop table `gold_flow`;
CREATE TABLE `gold_flow` (
  `gold_flow_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '流水编号',
  `user_id` varchar(32) NOT NULL COMMENT '用户编号',
  `outer_order_id` varchar(50) NULL COMMENT '外部订单编号',
  `gold` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '变更金币',
  `source` int(1) NOT NULL DEFAULT '0' COMMENT '流水来源：0-其他，1-购买充值，2-抢单消费，3-退单返回，4-邀请好友-实名认证',
  `exchange_type` int(1) NOT NULL DEFAULT '1' COMMENT '变更类型：1-入账、2-出账',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `remark` varchar(250) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`gold_flow_id`),
  KEY `idx_user_id` (`user_id`) USING BTREE COMMENT '用户编号索引'
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='金币流水表';


-- 操作账户表
CREATE TABLE `operate_account` (
  `operate_id` int(12) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `user_id` varchar(32) NOT NULL COMMENT '用户编号',
  `phone_num` varchar(20) NOT NULL COMMENT '用户手机号',
  `account_type` int(1) NOT NULL COMMENT '账户类型：1-金币账户、2-积分账户',
  `gold_integel` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '变更金币或积分',
  `exchange_type` int(1) NOT NULL DEFAULT '1' COMMENT '变更类型：1-入账、2-出账',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `remark` varchar(250) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`operate_id`),
  KEY `IDX_USER_ID` (`user_id`) USING BTREE,
  KEY `IDX_PHONE_NUM` (`phone_num`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='操作账户表';


-- 充值订单表
drop table `recharge_order`;
CREATE TABLE `recharge_order` (
  `order_id` varchar(32) NOT NULL COMMENT '充值订单编号',
  `user_id` varchar(32) NOT NULL COMMENT '用户编号',
  `goods_id` varchar(32) NOT NULL COMMENT '商品编号',
  `account_type` int(1) NOT NULL COMMENT '充值账户：1-金币账户，2-积分账户',
  `outer_order_id` varchar(50) DEFAULT NULL COMMENT '外部订单编号',
  `pay_channel` int(1) DEFAULT '1' COMMENT '支付渠道：1-微信支付，2-其他渠道',
  `recharge_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '充值金额',
  `recharge_order_status` int(1) DEFAULT '1' COMMENT '充值订单状态：1-待支付，2-支付成功，3-支付失败，4-未知，5-订单已关闭',
  `order_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单生成时间',
  `order_pay_time` timestamp NULL DEFAULT NULL COMMENT '订单支付时间',
  `modify_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(100) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`order_id`),
  KEY `USER_ID` (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='充值订单表';


-- 抢单订单表(抢单)
drop table `application_order`;
CREATE TABLE `application_order` (
  `order_id` varchar(32) NOT NULL COMMENT '订单编号',
  `user_id` varchar(32) NOT NULL COMMENT '用户编号',
  `application_id` varchar(32) NOT NULL COMMENT '贷款客户申请单编号',
  `cost_amount` decimal(10,2) DEFAULT '0.00' COMMENT '申请单消耗金额',
  `cost_type` int(1) DEFAULT '0' COMMENT '消耗类型：1-金币，2-积分',
  `order_status` int(1) DEFAULT '1' COMMENT '订单状态：1-已支付，2-退单中，3-退单完成，4-已完成',
  `label` varchar(20) NOT NULL DEFAULT '' COMMENT '订单标签描述',
  `is_refund` int(1) NOT NULL DEFAULT '0' COMMENT '是否退过单：0-否，1-是',
  `refund_reason` varchar(200) DEFAULT NULL COMMENT '退单理由',
  `audit_man` varchar(20) NOT NULL DEFAULT '' COMMENT '审核人',
  `audit_time` datetime DEFAULT NULL COMMENT '审核时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  `remark` varchar(250) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`order_id`),
  KEY `IDX_APPLICATION_ID` (`application_id`) USING BTREE,
  KEY `IDX_CREATETIME` (`create_time`) USING BTREE,
  KEY `IDX_USER_ID` (`user_id`) USING BTREE,
  KEY `IDX_IS_REFUND` (`is_refund`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='申请订单表';

  ALTER TABLE `application_order`
    ADD COLUMN `original_amount` decimal(10,2) DEFAULT '0.00' COMMENT '申请单原金额',
    ADD COLUMN `discount` varchar(10) DEFAULT '1'  COMMENT '申请单折扣：1-不打折';
    update application_order set original_amount = cost_amount where original_amount = 0 and discount = 1;

--------------------------
-- 客户体系
--------------------------

-- 贷款客户信息表（申请单）
drop table `customer_apply_info`;
CREATE TABLE customer_apply_info (
  `application_id` varchar(32) NOT NULL COMMENT '贷款客户申请单编号',
  `app_application_id` varchar(32) NOT NULL COMMENT '贷款平台申请单编号',
  `customer_id` varchar(32) NOT NULL COMMENT '平台贷款客户编号',
  `app_id` varchar(32) NOT NULL COMMENT '贷款平台编号：1001-贷款管家,1002-爱米多,1003-来这花',
  `customer_name` varchar(32) NOT NULL COMMENT '贷款客户姓名',
  `gender` int(1) DEFAULT '0' COMMENT '性别：1-男，2-女',
  `age` int(2) DEFAULT NULL COMMENT '年龄',
  `phone_num` varchar(20) NOT NULL COMMENT '手机号',
  `id_card_no` varchar(20) DEFAULT '' COMMENT '身份证号码',
  `job_city_name` varchar(20) DEFAULT '' COMMENT '工作城市',
  `loan_amount` varchar(50) DEFAULT NULL COMMENT '贷款额度',
  `is_house` int(1) DEFAULT '2' COMMENT '是否有房：1-有，2-无',
  `is_car` int(1) DEFAULT '2' COMMENT '是否有车：1-有，2-无',
  `is_insurance` int(1) DEFAULT '2' COMMENT '是否有保单：1-有，2-无',
  `is_credit` int(1) DEFAULT '2' COMMENT '是否有信用卡：1-有，2-无',
  `is_social` int(1) DEFAULT '2' COMMENT '是否有社保：1-有，2-无',
  `is_house_fund` int(1) DEFAULT '2' COMMENT '是否有公积金：1-有，2-无',
  `grade` int(1) DEFAULT '0' COMMENT '用户评级：1-高档,2-低档,3-积分',
  `cost_amount` decimal(10,2) DEFAULT '0.00' COMMENT '申请单消耗金额',
  `cost_type` int(1) DEFAULT '0' COMMENT '消耗类型：1-金币，2-积分，3-折扣',
  `status` int(1) DEFAULT '1' COMMENT '申请单状态：1-初始化，2-待抢单，3-已抢单，4-已完成',
  `is_shelf_status` int(1) DEFAULT '1' COMMENT '上下架状态：1-上架，2-下架',
  `total_score` int(3) NOT NULL DEFAULT '0' COMMENT '规则计算总分',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT current_timestamp on update current_timestamp COMMENT '修改时间',
  `remark` varchar(100) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`application_id`),
  UNIQUE KEY `UNIQ_IDX_APP_APPLICATION_ID_APP_ID` (`app_application_id`,`app_id`) USING BTREE,
  KEY `IDX_CUSTOME_ID_APP_ID` (`customer_id`,`app_id`) USING BTREE,
  KEY `IDX_PHONE_NUM` (`phone_num`) USING BTREE,
  KEY `IDX_ID_CARD_NO` (`id_card_no`) USING BTREE,
  KEY `IDX_CREATETIME` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='贷款客户申请信息表';

ALTER TABLE `customer_apply_info`
ADD COLUMN `loan_date`  datetime NOT NULL COMMENT '贷款申请时间';
 -- 消耗类型
 ALTER TABLE `customer_apply_info`
 MODIFY COLUMN `cost_type` int(1) DEFAULT '0' COMMENT '消耗类型：1-金币，2-积分，3-折扣';


    ALTER TABLE `customer_apply_info`
    ADD COLUMN `loan_time` int(1) NOT NULL COMMENT '借款期限:1-1个月、2-3个月、3-6个月、4-9个月、5-12个月、6-24个月、7-24个月以上',
    ADD COLUMN `month_income` int(1) NOT NULL COMMENT '月收入：1-2000元以下、2-2000-5000元、3-5000-1万元、4-1万元以上',
    ADD COLUMN `use_loan` int(1) NOT NULL  COMMENT '借款用途：1-日常消费、2-购车、3-购房、4-教育培训、5-短期周转、6-其他',
    ADD COLUMN `education` int(1) NOT NULL  COMMENT '学历：1-专科以下、2-专科、3-本科及以上',
    ADD COLUMN `job_type` int(1) NOT NULL  COMMENT '职业类型：1-上班族、2-公务员、3-个体户、4-企业法人、5-自由职业',
    ADD COLUMN `marital_status` int(1) NOT NULL  COMMENT '婚姻状态：1-未婚、2-已婚、3-离异、4-复婚',
    ADD COLUMN `particulate_loan` int(1) DEFAULT '2' COMMENT '是否有微粒贷：1-有，2-无';

    
-- 操作账户表
CREATE TABLE `operate_account` (
  `operate_id` int(12) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `user_id` varchar(32) NOT NULL COMMENT '用户编号',
  `phone_num` varchar(20) NOT NULL COMMENT '用户手机号',
  'account_type'  varchar(32) NOT NULL  COMMENT '账户类型：1-金币账户，2-积分账户',
  `gold_integel` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '变更金币或积分',
  `exchange_type` int(1) NOT NULL DEFAULT '1' COMMENT '变更类型：1-入账、2-出账',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `remark` varchar(250) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`operate_id`),
  KEY `IDX_USER_ID` (`user_id`) USING BTREE,
  KEY `IDX_PHONE_NUM` (`phone_num`) USING BTREE,
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='操作账户表';



alter table operate_account
  ADD COLUMN  `user_id` varchar(32) NOT NULL DEFAULT '' COMMENT '用户编号',
  MODIFY COLUMN `phone_num` varchar(20) NOT NULL DEFAULT '' COMMENT '用户手机号',
  MODIFY COLUMN 'account_type' varchar(32) NOT NULL DEFAULT '' COMMENT '账户类型：1-金币账户，2-积分账户',
  MODIFY COLUMN `gold_integel` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '变更金额',
  MODIFY COLUMN `exchange_type` int(1) NOT NULL DEFAULT '0' COMMENT '变更类型：1-入账、2-出账';
alter table operate_account comment '拉新活动';



CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL DEFAULT '0' COMMENT '主键编号',
  `user_id` varchar(64) NOT NULL DEFAULT '' COMMENT '用户ID',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `account_type` int(11) NOT NULL DEFAULT '0' COMMENT '账号类型(1-QQ、2-微信)',
  `nick_name` varchar(32) NOT NULL DEFAULT '' COMMENT '昵称',
  `login_ip` varchar(32) NOT NULL DEFAULT '' COMMENT '登录IP', 
  `phone_num` varchar(20) NOT NULL DEFAULT '' COMMENT '绑定手机号', 
  `device_id` varchar(20) NOT NULL DEFAULT '' COMMENT '设备型号', 
  `avatar_address` varchar(512) NOT NULL DEFAULT '' COMMENT '头像地址',
  `cust_state` int(1) DEFAULT '2' COMMENT '用户状态（1=禁用，2=正常）',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `operate_id` varchar(32) NOT NULL DEFAULT '' COMMENT '操作人', 
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
  `last_login_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最近登录时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_userid_accounttype` (`user_id`,`account_type`)
) ENGINE=InnoDB  AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='客户表';


CREATE TABLE `customer` (
  `id` varchar(20) NOT NULL COMMENT '用户ID',
  `password` varchar(16) NOT NULL DEFAULT '' COMMENT '密码',
  `uid` int(11) NOT NULL COMMENT '靓号，长度8位，唯一',
  `phone` varchar(16) NOT NULL DEFAULT '' COMMENT '手机号',
  `registration_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `status` int(4) NOT NULL DEFAULT '1' COMMENT '状态（1-正常、2-封禁）',
  `gender` int(4) DEFAULT NULL COMMENT '性别（0-女，1-男）',
  `birthday` datetime DEFAULT NULL COMMENT '出生日期',
  `nickname` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '昵称',
  `location` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '所在地区',
  `avatar_url` varchar(512) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '头像URL',
  `device_id` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '设备ID',
  `interest_id_list` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '兴趣ID列表，多个以逗号隔开',
  `prohibit_type` tinyint(4) DEFAULT NULL COMMENT '封禁类型（1-封禁帐号，2-封禁设备）',
  `prohibit_time` datetime DEFAULT NULL COMMENT '封禁时间',
  `prohibit_duration` int(11) DEFAULT NULL COMMENT '封禁时长（-1为永久，单位为天）',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_idx_uid` (`uid`),
  UNIQUE KEY `unique_idx_phone` (`phone`),
  KEY `idx_status` (`status`),
  KEY `idx_cus_search` (`nickname`,`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';




DATE_SUB(now(),INTERVAL 14 DAY) 

	

-- 退单申请资料表
CREATE TABLE `refund_apply_info` (
  `refund_id` int(12) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `order_id` varchar(32) NOT NULL COMMENT '订单编号',
  `user_id` varchar(32) NOT NULL COMMENT '用户编号',
  `refund_photo_url` varchar(250) DEFAULT '' COMMENT '退单资料上传图片地址',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  `remark` varchar(250) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`refund_id`),
  KEY `IDX_ORDER_ID` (`order_id`) USING BTREE,
  KEY `IDX_USER_ID_CREATETIME` (`user_id`,`create_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='退单申请资料表';

drop table if exists personal_tailor;

-- 私人订制记录表
CREATE TABLE `personal_tailor` (
  `tailor_id` int(12) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `user_id` varchar(32) NOT NULL DEFAULT '' COMMENT '用户编号',
  `phone_num` varchar(20) NOT NULL DEFAULT '' COMMENT '用户手机号',
  `channel` varchar(32) NOT NULL DEFAULT '' COMMENT '来源渠道',
  `item` varchar(250) NOT NULL DEFAULT '0' COMMENT '项目',
  `sex` int(1) NOT NULL DEFAULT '0' COMMENT '性别：1-女，2-男',
  `age` int(1) NOT NULL DEFAULT '0' COMMENT '年龄：1：25以下，2：25-35，3：35-45,4：45以上',
  `city_name` varchar(32) NOT NULL DEFAULT '' COMMENT '期望面诊地区',
  `major_consider` int(1) NOT NULL DEFAULT '0' COMMENT '侧重考虑：1-劲爆低价，2-达人同款，3-优选名医',
  `operation_time` int(1) DEFAULT '0' COMMENT '手术时间:1：一个月内，2：三个月内，3：三个月以上',
  `remark` varchar(250) DEFAULT '' COMMENT '其他需求',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`tailor_id`),
  KEY `IDX_USER_ID` (`user_id`) USING BTREE,
  KEY `IDX_PHONE_NUM` (`phone_num`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='私人订制记录表';

-- 订制信息统计
CREATE TABLE `personal_statistics` (
  `user_id` varchar(32) NOT NULL DEFAULT '' COMMENT '用户编号',
  `phone_num` varchar(20) NOT NULL DEFAULT '' COMMENT '用户手机号',
  `channel` varchar(32) NOT NULL DEFAULT '' COMMENT '来源渠道',
  `last_commit_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次提交时间',
  PRIMARY KEY (`user_id`),
  KEY `IDX_PHONE_NUM` (`phone_num`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订制信息统计';

CREATE TABLE `sys_user` (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `user_id` varchar(32) NOT NULL DEFAULT '' COMMENT '用户编号',
  `nick_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '用户编号',
  `phone_num` varchar(20) NOT NULL DEFAULT '' COMMENT '用户手机号',
  `head_image_url` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '头像',
  `real_name` varchar(32) NOT NULL DEFAULT '' COMMENT '真实姓名',
  `password` varchar(32) NOT NULL DEFAULT '' COMMENT '密码',
  `sex` int(1) NOT NULL DEFAULT '0' COMMENT '性别1-男，2-女',
  `status` int(2) NOT NULL DEFAULT '0' COMMENT '状态1-正常，2-锁定',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_user_id` (`user_id`),
  KEY `idx_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';



CREATE TABLE `sys_user` (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `username` varchar(32) NOT NULL DEFAULT '' COMMENT '用户编号',
  `passwd` varchar(32) NOT NULL DEFAULT '' COMMENT '用户密码',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` varchar(1) NOT NULL DEFAULT '' COMMENT '状态1-正常，2-锁定',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';


CREATE TABLE T_USER (
   `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
   USERNAME VARCHAR2(20 BYTE) NOT NULL ,
   PASSWD VARCHAR2(128 BYTE) NOT NULL ,
   CREATE_TIME DATE NULL ,
   STATUS CHAR(1 BYTE) NOT NULL 
);
COMMENT ON COLUMN T_USER.USERNAME IS '用户名';
COMMENT ON COLUMN T_USER.PASSWD IS '密码';
COMMENT ON COLUMN T_USER.CREATE_TIME IS '创建时间';
COMMENT ON COLUMN T_USER.STATUS IS '是否有效 1：有效  0：锁定';
-- ----------------------------
-- Records of T_USER
-- ----------------------------
INSERT INTO T_USER VALUES ('2', 'test', '7a38c13ec5e9310aed731de58bbc4214', TO_DATE('2017-11-19 17:20:21', 'YYYY-MM-DD HH24:MI:SS'), '0');
INSERT INTO T_USER VALUES ('1', 'mrbird', '42ee25d1e43e9f57119a00d0a39e5250', TO_DATE('2017-11-19 10:52:48', 'YYYY-MM-DD HH24:MI:SS'), '1');
-- ----------------------------
-- Primary Key structure for table T_USER
-- ----------------------------
ALTER TABLE T_USER ADD PRIMARY KEY (ID);












```

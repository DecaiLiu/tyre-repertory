/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : lsx

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 13/02/2023 21:15:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dict
-- ----------------------------
DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '字典项key',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典项名称',
  `type` int(11) NOT NULL COMMENT '字典类型',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典类型描述',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_type_name`(`type`, `name`) USING BTREE COMMENT '类型与项唯一约束'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` bigint(20) NOT NULL,
  `status` bigint(2) NOT NULL COMMENT '订单状态（待发货，已发货，已签收，已拒收）',
  `order_type` bigint(2) NOT NULL COMMENT '订单类型（进货，出货）',
  `pay_status` bigint(2) NULL DEFAULT NULL COMMENT '支付状态（已支付，未支付）',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单描述',
  `receivable` decimal(10, 2) NULL DEFAULT NULL COMMENT '应收价',
  `real_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '实收价',
  `pay_at` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `order_at` datetime(0) NULL DEFAULT NULL COMMENT '下单时间',
  `create_at` datetime(0) NOT NULL COMMENT '创建时间',
  `update_at` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `deleted` bigint(2) UNSIGNED ZEROFILL NOT NULL COMMENT '是否删除(1：已删除，0：未删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`  (
  `id` bigint(20) NOT NULL COMMENT '订单id',
  `good_id` bigint(20) NOT NULL COMMENT '商品id',
  `good_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `good_year` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品年月',
  `good_num` int(11) NULL DEFAULT NULL COMMENT '商品数量',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品价格',
  `send_at` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `sign_at` datetime(0) NULL DEFAULT NULL COMMENT '签收时间',
  `pay_method` int(11) NULL DEFAULT NULL COMMENT '支付方式，参考字典表',
  `pay_at` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_way` bigint(20) NULL DEFAULT NULL COMMENT '配送方式（现场，急送，邮寄）',
  `send_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '配送地址',
  `waybill_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮寄运货单号',
  `customer_type` bigint(20) NULL DEFAULT NULL COMMENT '客户类型（散客，合作伙伴）',
  `customer_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户称呼',
  `customer_phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户联系电话',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_at` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_at` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单详情表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for repertory
-- ----------------------------
DROP TABLE IF EXISTS `repertory`;
CREATE TABLE `repertory`  (
  `id` bigint(20) NOT NULL COMMENT '库存id',
  `good_id` bigint(20) NOT NULL COMMENT '商品id，对应字典type=1时的ID',
  `good_batch_no` varchar(0) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品批次号',
  `good_product_date` date NULL DEFAULT NULL COMMENT '生产日期',
  `total_num` int(11) NULL DEFAULT NULL COMMENT '库存总量',
  `sold_num` int(11) NULL DEFAULT NULL COMMENT '已售数量',
  `residue_num` int(11) NULL DEFAULT NULL COMMENT '库存量',
  `create_at` datetime(0) NOT NULL COMMENT '记录创建时间',
  `update_at` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '记录更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '库存表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户流水号',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号-登陆名',
  `sex` int(1) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '性别(0:未知，1：男，2：女)',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登陆密码',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_user_phone`(`phone`) USING BTREE COMMENT '手机号唯一索引'
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

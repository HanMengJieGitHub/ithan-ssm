/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : ssm

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 13/05/2020 22:24:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phoneNum` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES (1, '张三', '小三', '18888888888', 'zs@163.com');

-- ----------------------------
-- Table structure for order_traveller
-- ----------------------------
DROP TABLE IF EXISTS `order_traveller`;
CREATE TABLE `order_traveller`  (
  `orderId` int(11) NOT NULL,
  `travellerId` int(11) NOT NULL,
  PRIMARY KEY (`orderId`, `travellerId`) USING BTREE,
  INDEX `travellerId`(`travellerId`) USING BTREE,
  CONSTRAINT `order_traveller_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `orders` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `order_traveller_ibfk_2` FOREIGN KEY (`travellerId`) REFERENCES `traveller` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_traveller
-- ----------------------------
INSERT INTO `order_traveller` VALUES (1, 1);
INSERT INTO `order_traveller` VALUES (6, 1);
INSERT INTO `order_traveller` VALUES (7, 1);
INSERT INTO `order_traveller` VALUES (8, 1);
INSERT INTO `order_traveller` VALUES (1, 2);
INSERT INTO `order_traveller` VALUES (2, 2);
INSERT INTO `order_traveller` VALUES (3, 2);
INSERT INTO `order_traveller` VALUES (4, 2);
INSERT INTO `order_traveller` VALUES (5, 2);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderNum` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `orderTime` timestamp(0) NULL DEFAULT NULL,
  `peopleCount` int(11) NULL DEFAULT NULL,
  `orderDesc` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `payType` int(11) NULL DEFAULT NULL,
  `orderStatus` int(11) NULL DEFAULT NULL,
  `productId` int(11) NULL DEFAULT NULL,
  `memberId` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `productId`(`productId`) USING BTREE,
  INDEX `memberId`(`memberId`) USING BTREE,
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`productId`) REFERENCES `product` (`productId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`memberId`) REFERENCES `member` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, 'ssm001', '2020-05-13 16:54:08', 2, '可以', 0, 1, 1, 1);
INSERT INTO `orders` VALUES (2, 'ssm002', '2020-04-30 16:56:31', 3, 'ok', 1, 1, 2, 1);
INSERT INTO `orders` VALUES (3, 'ssm003', '2020-05-04 16:56:57', 1, 'ok', 2, 1, 3, 1);
INSERT INTO `orders` VALUES (4, 'ssm004', '2020-05-02 16:58:23', 2, 'ok', 1, 1, 4, 1);
INSERT INTO `orders` VALUES (5, 'ssm005', '2020-05-01 16:58:52', 1, 'ok', 1, 1, 1, 1);
INSERT INTO `orders` VALUES (6, 'ssm006', '2020-05-01 16:59:31', 2, 'ok', 2, 1, 2, 1);
INSERT INTO `orders` VALUES (7, 'ssm007', '2020-05-08 17:00:16', 2, 'ok', 1, 1, 1, 1);
INSERT INTO `orders` VALUES (8, 'ssm008', '2020-05-06 17:01:02', 2, 'ok', 1, 1, 1, 1);

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permissionName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `url` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, 'user findAll', '/user/findAll.do');
INSERT INTO `permission` VALUES (2, 'user findById', '/user/findById.do');
INSERT INTO `permission` VALUES (4, 'trst', 'teest');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `productId` int(11) NOT NULL AUTO_INCREMENT,
  `productName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cityName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `DepartureTime` datetime(0) NULL DEFAULT NULL,
  `productPrice` double NULL DEFAULT NULL,
  `productDesc` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `productStatus` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`productId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, '北京三日游', '北京', '2018-10-10 10:10:00', 1200, '不错的旅行', 1);
INSERT INTO `product` VALUES (2, '上海五日游', '上海', '2018-10-10 10:10:00', 1800, '魔都我来了', 0);
INSERT INTO `product` VALUES (3, '北京三日游', '北京', '2018-10-10 10:10:00', 1200, '不错的旅行', 1);
INSERT INTO `product` VALUES (4, '广州一日游', '广州', '2020-05-20 02:15:00', 1000, '广州很不错', 1);
INSERT INTO `product` VALUES (5, '洛阳一日游', '洛阳', '2020-05-14 02:30:00', 1000, '洛阳不错', 1);
INSERT INTO `product` VALUES (6, '郑州一日游', '郑州', '2020-05-13 02:55:00', 1000, '郑州很美', 1);
INSERT INTO `product` VALUES (7, '郑州一日游', '郑州', '2020-05-13 02:55:00', 1000, '郑州很美', 1);
INSERT INTO `product` VALUES (8, '郑州一日游', '郑州', '2020-05-13 02:55:00', 1000, '郑州很美2', 1);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `roleDesc` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'ADMIN', 'vip');
INSERT INTO `role` VALUES (2, 'USER', 'vip');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `permissionId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`permissionId`, `roleId`) USING BTREE,
  INDEX `roleId`(`roleId`) USING BTREE,
  INDEX `permissionId`(`permissionId`) USING BTREE,
  CONSTRAINT `role_permission_ibfk_1` FOREIGN KEY (`permissionId`) REFERENCES `permission` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `role_permission_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES (1, 1);
INSERT INTO `role_permission` VALUES (2, 1);
INSERT INTO `role_permission` VALUES (4, 1);
INSERT INTO `role_permission` VALUES (1, 2);
INSERT INTO `role_permission` VALUES (2, 2);

-- ----------------------------
-- Table structure for sysLog
-- ----------------------------
DROP TABLE IF EXISTS `sysLog`;
CREATE TABLE `sysLog`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `visitTime` timestamp(0) NULL DEFAULT NULL,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `ip` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `url` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `executionTime` int(11) NULL DEFAULT NULL,
  `method` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sysLog
-- ----------------------------
INSERT INTO `sysLog` VALUES (1, '2020-05-13 14:13:11', 'han', '0:0:0:0:0:0:0:1', 'userfindAll.do', 24, '[类名]org.ithan.ssm.controller.UserController[方法名] findAll');
INSERT INTO `sysLog` VALUES (2, '2020-05-13 14:14:35', 'han', '127.0.0.1', 'sysLogfindAll.do', 16, '[类名]org.ithan.ssm.controller.SysLogController[方法名] findAll');
INSERT INTO `sysLog` VALUES (3, '2020-05-13 14:14:52', 'han', '127.0.0.1', '/productfindAll.do', 123, '[类名]org.ithan.ssm.controller.ProductController[方法名] findAll');
INSERT INTO `sysLog` VALUES (4, '2020-05-13 14:14:56', 'han', '127.0.0.1', 'sysLogfindAll.do', 3, '[类名]org.ithan.ssm.controller.SysLogController[方法名] findAll');
INSERT INTO `sysLog` VALUES (5, '2020-05-13 14:18:46', 'han', '127.0.0.1', 'sysLogfindAll.do', 16, '[类名]org.ithan.ssm.controller.SysLogController[方法名] findAll');
INSERT INTO `sysLog` VALUES (6, '2020-05-13 14:18:53', 'han', '127.0.0.1', 'sysLogfindAll.do', 5, '[类名]org.ithan.ssm.controller.SysLogController[方法名] findAll');

-- ----------------------------
-- Table structure for traveller
-- ----------------------------
DROP TABLE IF EXISTS `traveller`;
CREATE TABLE `traveller`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phoneNum` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `credentialsType` int(11) NULL DEFAULT NULL,
  `credentialsNum` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `travellerType` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of traveller
-- ----------------------------
INSERT INTO `traveller` VALUES (1, '张龙', '男', '13333333333', 0, '123456789009876543', 0);
INSERT INTO `traveller` VALUES (2, '张小龙', '男', '15555555555', 0, '987654321123456789', 1);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phoneNum` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'han@ithan.com', 'han', '$2a$10$nIw5byOTvY4pDFYuzzm2cuxifepRCHQ8a02A9ANGfEMkC3MC5m84K', '15225049220', 1);
INSERT INTO `users` VALUES (2, 'test@t.com', 'test', '$2a$10$nIw5byOTvY4pDFYuzzm2cuxifepRCHQ8a02A9ANGfEMkC3MC5m84K', '15236242222', 1);
INSERT INTO `users` VALUES (3, 'han2@han.com', 'han2', '$2a$10$u6nJxknqEVPhyq6OXbEv5.ApkqZtphR37AX213njPhY/JtXMpC2kq', '15222222222', 1);
INSERT INTO `users` VALUES (4, 'ttt@ttt.com', 'test2', '$2a$10$rLxHNEhgRMP.u0Apinmq/ujmMQR76GjEyTfe./I3KnUh7IhbHPOn6', '152222222222', 1);

-- ----------------------------
-- Table structure for users_role
-- ----------------------------
DROP TABLE IF EXISTS `users_role`;
CREATE TABLE `users_role`  (
  `userId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`userId`, `roleId`) USING BTREE,
  INDEX `roleId`(`roleId`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE,
  CONSTRAINT `users_role_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `users_role_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users_role
-- ----------------------------
INSERT INTO `users_role` VALUES (1, 1);
INSERT INTO `users_role` VALUES (2, 1);
INSERT INTO `users_role` VALUES (4, 1);
INSERT INTO `users_role` VALUES (1, 2);
INSERT INTO `users_role` VALUES (3, 2);
INSERT INTO `users_role` VALUES (4, 2);

SET FOREIGN_KEY_CHECKS = 1;

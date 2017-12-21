/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:23306
Source Database       : lagou

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-12-22 00:14:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for lagou_position_detail
-- ----------------------------
DROP TABLE IF EXISTS `lagou_position_detail`;
CREATE TABLE `lagou_position_detail` (
  `positionId` int(11) unsigned NOT NULL,
  `companyId` int(11) unsigned NOT NULL DEFAULT '0',
  `createTime` char(19) NOT NULL DEFAULT '',
  `city` varchar(5) NOT NULL DEFAULT '',
  `company` varchar(80) NOT NULL DEFAULT '',
  `education` varchar(5) NOT NULL DEFAULT '',
  `positionName` varchar(40) NOT NULL DEFAULT '',
  `positionAdvantage` varchar(50) NOT NULL DEFAULT '',
  `positionDescription` varchar(2000) NOT NULL DEFAULT '',
  `positionAddress` varchar(80) NOT NULL DEFAULT '',
  `positionLables` varchar(80) NOT NULL DEFAULT '',
  `positionNature` varchar(4) NOT NULL DEFAULT '',
  `firstType` varchar(20) NOT NULL DEFAULT '',
  `secondType` varchar(30) NOT NULL DEFAULT '',
  `salary` varchar(10) NOT NULL DEFAULT '',
  `workYear` varchar(10) NOT NULL DEFAULT '',
  PRIMARY KEY (`positionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='拉勾网职位详情表。';

/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:23306
Source Database       : lagou

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-12-15 20:55:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for lagou_position_info
-- ----------------------------
DROP TABLE IF EXISTS `lagou_position_info`;
CREATE TABLE `lagou_position_info` (
  `positionId` int(11) unsigned NOT NULL,
  `appShow` int(1) unsigned NOT NULL DEFAULT '0',
  `approve` int(1) unsigned NOT NULL DEFAULT '0',
  `adWord` int(1) unsigned NOT NULL DEFAULT '0',
  `companyId` int(11) unsigned NOT NULL DEFAULT '0',
  `createTime` char(19) NOT NULL DEFAULT '',
  `city` varchar(5) NOT NULL DEFAULT '',
  `businessZones` varchar(80) NOT NULL DEFAULT '',
  `companyFullName` varchar(80) NOT NULL DEFAULT '',
  `companyShortName` varchar(40) NOT NULL DEFAULT '',
  `companyLabelList` varchar(40) NOT NULL DEFAULT '',
  `companySize` varchar(14) NOT NULL DEFAULT '',
  `companyLogo` varchar(80) NOT NULL DEFAULT '',
  `deliver` int(1) unsigned NOT NULL DEFAULT '0',
  `district` varchar(5) NOT NULL DEFAULT '',
  `education` varchar(5) NOT NULL DEFAULT '',
  `explain_str` varchar(10) NOT NULL DEFAULT '',
  `formatCreateTime` varchar(20) NOT NULL DEFAULT '',
  `firstType` varchar(20) NOT NULL DEFAULT '',
  `financeStage` varchar(10) NOT NULL DEFAULT '',
  `gradeDescription` varchar(10) NOT NULL DEFAULT '',
  `jobNature` varchar(4) NOT NULL DEFAULT '',
  `industryField` varchar(20) NOT NULL DEFAULT '',
  `industryLables` varchar(50) NOT NULL DEFAULT '',
  `isSchoolJob` int(1) unsigned NOT NULL DEFAULT '0',
  `imState` varchar(20) NOT NULL DEFAULT '',
  `longitude` varchar(20) NOT NULL DEFAULT '',
  `latitude` varchar(20) NOT NULL DEFAULT '',
  `linestaion` varchar(300) NOT NULL DEFAULT '',
  `lastLogin` bigint(20) unsigned NOT NULL DEFAULT '0',
  `pcShow` int(1) unsigned NOT NULL DEFAULT '0',
  `positionName` varchar(40) NOT NULL DEFAULT '',
  `positionLables` varchar(80) NOT NULL DEFAULT '',
  `positionAdvantage` varchar(50) NOT NULL DEFAULT '',
  `promotionScoreExplain` varchar(10) NOT NULL DEFAULT '',
  `publisherId` int(11) unsigned NOT NULL DEFAULT '0',
  `plus` varchar(10) NOT NULL DEFAULT '',
  `processed` int(1) unsigned NOT NULL DEFAULT '0' COMMENT '数据是否已经被处理',
  `subwayline` varchar(20) NOT NULL DEFAULT '',
  `score` int(3) unsigned NOT NULL DEFAULT '0',
  `secondType` varchar(30) NOT NULL DEFAULT '',
  `salary` varchar(10) NOT NULL DEFAULT '',
  `stationname` varchar(10) NOT NULL DEFAULT '',
  `workYear` varchar(10) NOT NULL DEFAULT '',
  PRIMARY KEY (`positionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='拉勾网职位信息表。';

/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:23306
Source Database       : lagou_test

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-12-25 22:01:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for lagou_company_info
-- ----------------------------
DROP TABLE IF EXISTS `lagou_company_info`;
CREATE TABLE `lagou_company_info` (
  `companyId` int(11) unsigned NOT NULL,
  `companyFullName` varchar(80) NOT NULL DEFAULT '',
  `companyShortName` varchar(40) NOT NULL DEFAULT '',
  `companyLabelList` varchar(40) NOT NULL DEFAULT '',
  `companySize` varchar(14) NOT NULL DEFAULT '',
  `companyLogo` varchar(80) NOT NULL DEFAULT '',
  `companyHref` varchar(200) NOT NULL DEFAULT '',
  `district` varchar(5) NOT NULL DEFAULT '',
  `financeStage` varchar(10) NOT NULL DEFAULT '',
  `businessZones` varchar(80) NOT NULL DEFAULT '',
  `industryField` varchar(20) NOT NULL DEFAULT '',
  `industryLabels` varchar(50) NOT NULL DEFAULT '',
  `lineStation` varchar(300) NOT NULL DEFAULT '',
  `subwayLine` varchar(20) NOT NULL DEFAULT '',
  `stationName` varchar(10) NOT NULL DEFAULT '',
  PRIMARY KEY (`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='拉勾网公司信息表。';

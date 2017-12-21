/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:23306
Source Database       : lagou

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-12-22 00:14:15
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
  `companyHref` varchar(40) NOT NULL DEFAULT '',
  `district` varchar(5) NOT NULL DEFAULT '',
  `financeStage` varchar(10) NOT NULL DEFAULT '',
  `businessZones` varchar(80) NOT NULL DEFAULT '',
  `industryField` varchar(20) NOT NULL DEFAULT '',
  `industryLables` varchar(50) NOT NULL DEFAULT '',
  `linestaion` varchar(300) NOT NULL DEFAULT '',
  `subwayline` varchar(20) NOT NULL DEFAULT '',
  `stationname` varchar(10) NOT NULL DEFAULT '',
  PRIMARY KEY (`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='拉勾网公司信息表。';

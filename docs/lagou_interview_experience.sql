/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:23306
Source Database       : lagou

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-12-22 00:14:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for lagou_interview_experience
-- ----------------------------
DROP TABLE IF EXISTS `lagou_interview_experience`;
CREATE TABLE `lagou_interview_experience` (
  `id` int(11) unsigned NOT NULL,
  `companyId` int(11) unsigned NOT NULL DEFAULT '0',
  `positionId` int(11) unsigned NOT NULL,
  `companyScore` int(1) unsigned NOT NULL DEFAULT '0',
  `describeScore` int(1) unsigned NOT NULL DEFAULT '0',
  `interviewerScore` int(1) unsigned NOT NULL DEFAULT '0',
  `comprehensiveScore` int(1) unsigned NOT NULL DEFAULT '0',
  `myScore` int(1) unsigned NOT NULL DEFAULT '0',
  `content` varchar(80) NOT NULL DEFAULT '',
  `positionName` varchar(40) NOT NULL DEFAULT '',
  `positionType` varchar(20) NOT NULL DEFAULT '',
  `createTime` char(19) NOT NULL DEFAULT '',
  `usefulCount` int(10) unsigned NOT NULL DEFAULT '0',
  `tags` varchar(80) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='拉勾网面试评价表。';

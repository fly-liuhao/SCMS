/*
 Navicat MySQL Data Transfer

 Source Server         : 服务器MySQL
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : 101.200.47.217:3306
 Source Schema         : scms

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 22/09/2019 11:51:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes`  (
  `classid` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '班级编号',
  `majorid` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '专业编号',
  `classname` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '班级名称',
  `grade` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '所属年级',
  `classremark` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '班级备注',
  PRIMARY KEY (`classid`) USING BTREE,
  INDEX `FK_major_classes`(`majorid`) USING BTREE,
  CONSTRAINT `FK_major_classes` FOREIGN KEY (`majorid`) REFERENCES `major` (`majorid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '班级实体' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES ('1520521', '52', '15数媒一班', '2015', '男女比例还算正常的一个班');
INSERT INTO `classes` VALUES ('1520522', '52', '15数媒二班', '2015', '<p align=\"left\">这个班的都是学霸，特别爱学习</p>');
INSERT INTO `classes` VALUES ('1520531', '53', '15物工一班', '2015', '积极向上，热爱学习');
INSERT INTO `classes` VALUES ('1520532', '53', '15物工二班', '2015', '<p>积极向上，热爱学习</p>');
INSERT INTO `classes` VALUES ('1520541', '54', '15计科一班', '2015', '都是学霸~');
INSERT INTO `classes` VALUES ('1520542', '54', '15计科二班', '2015', '班里的学习分为也不是i很好，不如一班<br>');
INSERT INTO `classes` VALUES ('1520551', '55', '15网工一班', '2015', '他们会接网线');
INSERT INTO `classes` VALUES ('1520552', '55', '15网工二班', '2015', '毫无存在感的一个班');
INSERT INTO `classes` VALUES ('1520561', '56', '15软件一班', '2015', '大家上课一点也不积极');
INSERT INTO `classes` VALUES ('1520562', '56', '15软件二班', '2015', '作者所在的班级');
INSERT INTO `classes` VALUES ('1620221', '22', '16通信一班', '2016', '热该学习，热爱劳动！');
INSERT INTO `classes` VALUES ('1620521', '52', '16数媒一班', '2016', '男女比例还算正常的一个班');
INSERT INTO `classes` VALUES ('1620522', '52', '16数媒二班', '2016', '这个班的都是学霸，特别爱学习');
INSERT INTO `classes` VALUES ('1620531', '53', '16物工一班', '2016', '积极向上，热爱学习');
INSERT INTO `classes` VALUES ('1620532', '53', '16物工二班', '2016', '<p>积极向上，热爱学习</p>');
INSERT INTO `classes` VALUES ('1620541', '54', '16计科一班', '2016', '都是学霸~');
INSERT INTO `classes` VALUES ('1620542', '54', '16计科二班', '2016', '班里的学习分为也不是i很好，不如一班<br>');
INSERT INTO `classes` VALUES ('1620551', '55', '16网工一班', '2016', '他们会接网线');
INSERT INTO `classes` VALUES ('1620552', '55', '16网工二班', '2016', '毫无存在感的一个班');
INSERT INTO `classes` VALUES ('1620561', '56', '16软件一班', '2016', '大家上课一点也不积极');
INSERT INTO `classes` VALUES ('1620562', '56', '16软件二班', '2016', '作者所在的班级');
INSERT INTO `classes` VALUES ('1720521', '52', '17数媒一班', '2017', '男女比例还算正常的一个班');
INSERT INTO `classes` VALUES ('1720522', '52', '17数媒二班', '2017', '这个班的都是学霸，特别爱学习');
INSERT INTO `classes` VALUES ('1720531', '53', '17物工一班', '2017', '积极向上，热爱学习');
INSERT INTO `classes` VALUES ('1720532', '53', '17物工二班', '2017', '<p>积极向上，热爱学习</p>');
INSERT INTO `classes` VALUES ('1720541', '54', '17计科一班', '2017', '都是学霸~');
INSERT INTO `classes` VALUES ('1720542', '54', '17计科二班', '2017', '班里的学习分为也不是i很好，不如一班<br>');
INSERT INTO `classes` VALUES ('1720551', '55', '17网工一班', '2017', '他们会接网线');
INSERT INTO `classes` VALUES ('1720552', '55', '17网工二班', '2017', '毫无存在感的一个班');
INSERT INTO `classes` VALUES ('1720561', '56', '17软件一班', '2017', '大家上课一点也不积极');
INSERT INTO `classes` VALUES ('1720562', '56', '17软件二班', '2017', '作者所在的班级');
INSERT INTO `classes` VALUES ('1820521', '52', '18数媒一班', '2018', '男女比例还算正常的一个班');
INSERT INTO `classes` VALUES ('1820522', '52', '18数媒二班', '2018', '这个班的都是学霸，特别爱学习');
INSERT INTO `classes` VALUES ('1820531', '53', '18物工一班', '2018', '积极向上，热爱学习');
INSERT INTO `classes` VALUES ('1820532', '53', '18物工二班', '2018', '<p>积极向上，热爱学习</p>');
INSERT INTO `classes` VALUES ('1820541', '54', '18计科一班', '2018', '都是学霸~');
INSERT INTO `classes` VALUES ('1820542', '54', '18计科二班', '2018', '班里的学习分为也不是i很好，不如一班<br>');
INSERT INTO `classes` VALUES ('1820551', '55', '18网工一班', '2018', '他们会接网线');
INSERT INTO `classes` VALUES ('1820552', '55', '18网工二班', '2018', '毫无存在感的一个班');
INSERT INTO `classes` VALUES ('1820561', '56', '18软件一班', '2018', '大家上课一点也不积极');
INSERT INTO `classes` VALUES ('1820562', '56', '18软件二班', '2018', '作者所在的班级');
INSERT INTO `classes` VALUES ('1920521', '52', '19数媒一班', '2019', '男女比例还算正常的一个班');
INSERT INTO `classes` VALUES ('1920522', '52', '19数媒二班', '2019', '这个班的都是学霸，特别爱学习');
INSERT INTO `classes` VALUES ('1920531', '53', '19物工一班', '2019', '积极向上，热爱学习');
INSERT INTO `classes` VALUES ('1920532', '53', '19物工二班', '2019', '<p>积极向上，热爱学习</p>');
INSERT INTO `classes` VALUES ('1920541', '54', '19计科一班', '2019', '都是学霸~');
INSERT INTO `classes` VALUES ('1920542', '54', '19计科二班', '2019', '班里的学习分为也不是i很好，不如一班<br>');
INSERT INTO `classes` VALUES ('1920551', '55', '19网工一班', '2019', '他们会接网线');
INSERT INTO `classes` VALUES ('1920552', '55', '19网工二班', '2019', '毫无存在感的一个班');
INSERT INTO `classes` VALUES ('1920561', '56', '19软件一班', '2019', '大家上课一点也不积极');
INSERT INTO `classes` VALUES ('1920562', '56', '19软件二班', '2019', '作者所在的班级');

-- ----------------------------
-- Table structure for competition
-- ----------------------------
DROP TABLE IF EXISTS `competition`;
CREATE TABLE `competition`  (
  `competitionid` int(11) NOT NULL AUTO_INCREMENT COMMENT '赛事编号',
  `competitionname` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '赛事名称',
  `competitiondate` date NOT NULL COMMENT '赛事举办时间',
  `competitionlevel` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '赛事级别',
  `competitiontype` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '赛事类型',
  `competitiondescribe` varchar(1000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '赛事说明',
  PRIMARY KEY (`competitionid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '赛事实体' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of competition
-- ----------------------------
INSERT INTO `competition` VALUES (0, '重要数据', '2019-01-01', '重要数据', '重要数据', '重要数据');
INSERT INTO `competition` VALUES (1, '第八届软件杯大赛', '2019-01-01', '国家级', 'A类', '“中国软件杯”大学生软件设计大赛是一项面向中国在校学生的公益性赛事。大赛由国家工业和信息化部、教育部、江苏省人民政府共同主办，致力于正确引导我国在校学生积极参加软件科研活动，切实增强自我创新能力和实际动手能力，通过富有自由、开放、创新精神的软件类别设计大赛，为广大青年才俊提供一个脱颖而出的平台，为我国软件和信息技术服务业培养出更多高端、优秀的人才。');
INSERT INTO `competition` VALUES (2, '第十届蓝桥杯大赛', '2019-03-01', '国家级', 'B类', '为推动软件开发技术的发展，促进软件专业技术人才培养，向软件行业输送具有创新能力和实践能力的高端人才，提升高校毕业生的就业竞争力，全面推动行业发展及人才培养进程，工业和信息化部人才交流中心特举办“全国软件专业人才设计与创业大赛”，本赛包括个人赛和团队赛两个比赛项目，个人赛设置：1、C/C++程序设计（本科A组、本科B组、高职高专组）2、Java软件开发（本科A组、本科B组、高职高专组）3、嵌入式设计与开发（大学组、研究生组）4、单片机设计与开发（大学组）5、电子设计与开发（大学组），团队赛设置：软件创业赛一个科目组别。并且形成了立足行业，结合实际，实战演练，促进就业的特色。');
INSERT INTO `competition` VALUES (3, '互联网+大赛', '2019-08-01', '省级', 'B类', '首届中国“互联网+”大学生创新创业大赛，以“‘互联网+’成就梦想，创新创业开辟未来”为主题，由教育部与有关部委和吉林省人民政府共同主办。大赛旨在深化高等教育综合改革，激发大学生的创造力，培养造就“大众创业、万众创新”的生力军；推动赛事成果转化，促进“互联网+”新业态形成，服务经济提质增效升级；以创新引领创业、创业带动就业，推动高校毕业生更高质量创业就业。');
INSERT INTO `competition` VALUES (4, 'PAT', '2019-10-01', '国家级', 'A类', '浙江大学计算机程序设计能力考试（Programming Ability Test，简称PAT）是由浙江大学计算机科学与技术学院组织的统一考试。旨在培养和展现学生分析问题、解决问题和计算机程序设计的能力，科学评价计算机程序设计人才，并为企业选拔人才提供参考标准。');
INSERT INTO `competition` VALUES (5, 'ACM国际大学生程序设计竞赛', '2019-08-01', '国家级', 'A类', 'ACM国际大学生程序设计竞赛（英文全称：ACM International Collegiate Programming Contest（简称ACM-ICPC或ICPC））是由国际计算机协会（ACM）主办的，一项旨在展示大学生创新能力、团队精神和在压力下编写程序、分析和解决问题能力的年度竞赛。经过近40年的发展，ACM国际大学生程序设计竞赛已经发展成为全球最具影响力的大学生程序设计竞赛。赛事目前由方正集团赞助。');
INSERT INTO `competition` VALUES (30, '兴晋挑战杯', '2018-10-01', '校级', 'A类', '<div data-spm=\"content\"><div class=\"text\"><article class=\"article\" id=\"mp-editor\" style=\"text-align: left;\"><p>“挑战杯”全国大学生课外学术科技作品竞赛是由共青团中央、中国科协、教育部和全国学联、地方省级人民政府共同主办的全国性的大学生课外学术科技创业类竞赛，历年来皆由国内著名高校承办。“挑战杯”系列竞赛被誉为中国大学生学生科技创新创业的“奥林匹克”盛会，是目前国内大学生关注度最高的全国性竞赛，也是全国最具代表性、权威性、示范性、导向性的大学生竞赛。</p></article></div></div>');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `deptid` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '院系编号',
  `deptname` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '院系名称',
  `deptremark` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '院系备注',
  PRIMARY KEY (`deptid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '院系实体' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '机械工程系', '学校的重点专业所在系');
INSERT INTO `department` VALUES ('10', '外语系', NULL);
INSERT INTO `department` VALUES ('11', '设计与艺术系', NULL);
INSERT INTO `department` VALUES ('12', '法学系', NULL);
INSERT INTO `department` VALUES ('13', '体育系', NULL);
INSERT INTO `department` VALUES ('2', '电子工程系', NULL);
INSERT INTO `department` VALUES ('3', '自动化系', NULL);
INSERT INTO `department` VALUES ('4', '化学与化工系', NULL);
INSERT INTO `department` VALUES ('5', '计算机工程系', NULL);
INSERT INTO `department` VALUES ('6', '环境与安全工程系', NULL);
INSERT INTO `department` VALUES ('7', '材料工程系', NULL);
INSERT INTO `department` VALUES ('8', '理学系', NULL);
INSERT INTO `department` VALUES ('9', '经济与管理系', NULL);

-- ----------------------------
-- Table structure for loginlog
-- ----------------------------
DROP TABLE IF EXISTS `loginlog`;
CREATE TABLE `loginlog`  (
  `logid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志编号',
  `userid` decimal(8, 0) NOT NULL COMMENT '用户编号',
  `logintime` datetime(0) NOT NULL COMMENT '登陆时间',
  `loginsite` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '登陆地点',
  `loginip` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '登陆ip',
  `loginos` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '操作系统',
  `loginbrowser` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '浏览器',
  `loginremark` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '登陆备注',
  PRIMARY KEY (`logid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 245 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '登陆日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of loginlog
-- ----------------------------
INSERT INTO `loginlog` VALUES (4, 13, '2019-08-27 17:09:24', '山西省太原市', '218.26.97.250', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (6, 13, '2019-08-28 09:29:19', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (7, 18, '2019-08-28 12:30:11', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (8, 13, '2019-08-28 12:32:57', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (9, 13, '2019-08-28 12:39:02', '山西省太原市', '218.26.97.250', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (10, 13, '2019-08-28 12:39:52', '山西省太原市', '218.26.97.250', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (11, 13, '2019-09-07 08:50:19', '山西省太原市', '218.26.97.250', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (12, 13, '2019-09-07 09:15:15', '山西省太原市', '218.26.97.250', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (13, 13, '2019-09-07 10:54:27', '山西省太原市', '218.26.97.250', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (14, 13, '2019-09-08 08:25:52', '山西省太原市', '218.26.97.250', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (15, 13, '2019-09-08 08:50:05', '山西省太原市', '218.26.97.250', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (16, 13, '2019-09-08 08:54:39', '山西省太原市', '218.26.97.250', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (17, 13, '2019-09-08 08:56:24', '山西省太原市', '218.26.97.250', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (18, 13, '2019-09-08 08:58:51', '山西省太原市', '218.26.97.250', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (19, 13, '2019-09-08 09:23:01', '山西省太原市', '218.26.97.250', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (20, 13, '2019-09-08 10:15:25', '山西省太原市', '218.26.97.250', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (21, 13, '2019-09-08 11:17:37', '山西省太原市', '218.26.97.250', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (22, 13, '2019-09-08 11:22:35', '山西省太原市', '218.26.97.250', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (23, 13, '2019-09-08 11:53:08', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (24, 13, '2019-09-08 12:02:53', '山西省太原市', '218.26.97.250', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (25, 13, '2019-09-08 12:06:13', '山西省太原市', '218.26.97.250', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (26, 13, '2019-09-08 12:16:22', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (27, 13, '2019-09-08 18:18:48', '山西省太原市', '218.26.97.250', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (28, 13, '2019-09-08 18:43:32', '山西省太原市', '218.26.97.250', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (29, 13, '2019-09-08 18:53:29', '山西省太原市', '218.26.97.250', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (30, 13, '2019-09-08 18:53:29', '山西省太原市', '218.26.97.250', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (31, 13, '2019-09-14 12:17:35', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (32, 13, '2019-09-14 12:54:23', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (33, 13, '2019-09-14 15:08:11', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (34, 13, '2019-09-14 15:09:21', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (35, 13, '2019-09-14 15:36:58', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (36, 13, '2019-09-14 15:45:55', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (37, 13, '2019-09-14 15:47:51', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (38, 13, '2019-09-14 15:50:27', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (39, 18, '2019-09-14 15:51:09', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (40, 13, '2019-09-14 15:52:03', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (41, 13, '2019-09-14 15:55:07', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (42, 13, '2019-09-14 16:00:48', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (43, 13, '2019-09-14 16:05:54', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (44, 13, '2019-09-14 16:07:10', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (45, 17, '2019-09-14 16:07:56', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (46, 13, '2019-09-14 16:12:42', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (47, 17, '2019-09-14 16:13:25', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (48, 18, '2019-09-14 16:14:29', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (49, 13, '2019-09-14 16:39:23', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (50, 13, '2019-09-14 16:57:44', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (51, 13, '2019-09-14 18:27:11', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (52, 13, '2019-09-14 18:28:59', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (53, 13, '2019-09-14 18:31:34', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (54, 13, '2019-09-14 18:36:03', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (55, 13, '2019-09-14 18:36:57', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (56, 13, '2019-09-14 19:01:55', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (57, 13, '2019-09-14 19:06:18', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (58, 13, '2019-09-14 19:10:12', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (59, 13, '2019-09-14 19:14:51', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (60, 13, '2019-09-14 20:07:26', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (61, 13, '2019-09-14 20:12:20', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (62, 13, '2019-09-14 20:23:46', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (63, 13, '2019-09-14 20:26:24', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (64, 13, '2019-09-15 08:53:51', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (65, 13, '2019-09-15 09:21:26', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (66, 13, '2019-09-15 10:25:33', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (67, 13, '2019-09-15 11:32:07', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (69, 23, '2019-09-15 14:15:39', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (70, 23, '2019-09-15 15:30:16', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (71, 23, '2019-09-15 17:32:32', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (72, 23, '2019-09-16 10:23:20', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (73, 23, '2019-09-16 10:23:20', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (74, 23, '2019-09-16 10:27:30', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (76, 24, '2019-09-16 10:33:14', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (77, 24, '2019-09-16 10:33:45', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (78, 24, '2019-09-16 10:37:46', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (79, 24, '2019-09-16 11:42:25', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (80, 24, '2019-09-16 12:29:03', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (81, 24, '2019-09-16 12:38:57', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (82, 24, '2019-09-16 16:46:43', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (83, 24, '2019-09-16 16:47:28', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (84, 24, '2019-09-16 16:54:11', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (85, 24, '2019-09-16 16:54:31', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (86, 24, '2019-09-16 16:55:31', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (87, 24, '2019-09-16 16:56:26', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (88, 23, '2019-09-16 16:57:20', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (89, 24, '2019-09-16 16:58:14', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (90, 24, '2019-09-16 16:58:30', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (91, 24, '2019-09-16 16:59:00', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (92, 24, '2019-09-16 16:59:53', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (93, 24, '2019-09-16 17:04:03', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (94, 24, '2019-09-16 17:09:25', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (95, 24, '2019-09-16 17:12:47', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (96, 23, '2019-09-16 18:27:33', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (97, 24, '2019-09-16 18:48:48', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (98, 24, '2019-09-16 19:05:52', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (99, 24, '2019-09-16 19:06:14', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (100, 23, '2019-09-16 19:10:33', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (101, 23, '2019-09-16 19:12:00', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (102, 24, '2019-09-16 19:12:17', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (103, 24, '2019-09-16 22:11:12', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (104, 24, '2019-09-16 22:11:31', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (105, 24, '2019-09-17 08:30:28', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (106, 24, '2019-09-17 08:45:09', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (107, 24, '2019-09-17 08:48:38', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (108, 24, '2019-09-17 15:21:27', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (109, 24, '2019-09-17 15:32:39', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (110, 24, '2019-09-17 15:34:45', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (111, 24, '2019-09-17 15:37:18', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (112, 24, '2019-09-17 16:21:35', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (113, 24, '2019-09-17 16:24:02', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (114, 24, '2019-09-17 16:25:59', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (115, 24, '2019-09-17 16:27:33', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (116, 24, '2019-09-17 16:32:45', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (117, 23, '2019-09-17 16:42:18', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (118, 24, '2019-09-17 16:49:01', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (119, 24, '2019-09-17 16:50:03', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (120, 24, '2019-09-17 16:51:19', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (121, 24, '2019-09-17 16:53:43', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (122, 24, '2019-09-17 16:54:02', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (123, 24, '2019-09-17 16:55:55', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (124, 24, '2019-09-17 17:21:33', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (125, 24, '2019-09-17 17:23:30', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (126, 24, '2019-09-17 17:25:17', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (127, 24, '2019-09-17 17:28:42', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (128, 24, '2019-09-17 17:30:20', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (129, 24, '2019-09-17 17:34:18', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (130, 24, '2019-09-17 17:34:44', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (131, 24, '2019-09-17 18:09:42', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (132, 24, '2019-09-17 18:16:57', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (133, 24, '2019-09-17 18:17:33', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (134, 24, '2019-09-17 18:41:24', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (135, 24, '2019-09-17 18:42:09', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (136, 24, '2019-09-17 18:50:55', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (137, 24, '2019-09-17 18:58:08', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (138, 24, '2019-09-17 19:02:15', '山西省', '1.68.96.88', 'Android Mobile', 'Chrome Mobile', NULL);
INSERT INTO `loginlog` VALUES (139, 24, '2019-09-17 19:02:54', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (140, 24, '2019-09-17 19:10:38', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (141, 24, '2019-09-17 21:43:34', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (142, 24, '2019-09-17 21:51:13', '山西省', '1.68.96.88', 'Android Mobile', 'Chrome Mobile', NULL);
INSERT INTO `loginlog` VALUES (143, 24, '2019-09-17 21:54:25', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (144, 24, '2019-09-17 21:57:59', '上海市闵行区', '58.38.90.217', 'Android 7.x', 'Chrome Mobile', NULL);
INSERT INTO `loginlog` VALUES (145, 24, '2019-09-17 22:00:18', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (146, 24, '2019-09-17 23:24:03', '山西省太原市', '61.134.196.73', 'Android Mobile', 'Chrome Mobile', NULL);
INSERT INTO `loginlog` VALUES (147, 24, '2019-09-17 23:46:35', '山西省晋城市', '218.26.55.228', 'Android 8.x', 'Chrome Mobile', NULL);
INSERT INTO `loginlog` VALUES (148, 24, '2019-09-17 23:46:48', '山西省晋城市', '218.26.54.246', 'Android 8.x', 'Chrome Mobile', NULL);
INSERT INTO `loginlog` VALUES (149, 24, '2019-09-18 08:47:01', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (150, 24, '2019-09-18 08:48:13', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (151, 24, '2019-09-18 09:03:27', '山西省', '1.68.122.42', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (152, 24, '2019-09-18 09:17:03', '山西省', '1.68.122.42', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (153, 24, '2019-09-18 10:09:53', '山西省', '1.68.122.42', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (154, 24, '2019-09-18 10:37:39', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (155, 24, '2019-09-18 15:42:45', '山西省', '1.68.119.56', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (156, 24, '2019-09-18 17:11:40', '山西省', '223.11.54.186', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (157, 24, '2019-09-18 17:32:59', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (158, 24, '2019-09-18 17:33:53', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (159, 24, '2019-09-18 20:18:36', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (160, 24, '2019-09-18 21:41:51', '山西省', '223.11.167.58', 'Windows 10', 'Microsoft Edge', NULL);
INSERT INTO `loginlog` VALUES (162, 24, '2019-09-19 09:57:16', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (163, 24, '2019-09-19 10:39:01', '山西省太原市', '59.49.30.24', 'Android 8.x', 'Chrome Mobile', NULL);
INSERT INTO `loginlog` VALUES (164, 24, '2019-09-19 10:39:15', '山西省太原市', '59.49.30.24', 'Android 8.x', 'Chrome Mobile', NULL);
INSERT INTO `loginlog` VALUES (165, 24, '2019-09-19 10:39:31', '山西省太原市', '59.49.30.24', 'Android 8.x', 'Chrome Mobile', NULL);
INSERT INTO `loginlog` VALUES (166, 24, '2019-09-19 10:40:03', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (167, 24, '2019-09-19 10:42:27', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (168, 24, '2019-09-19 11:17:17', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (169, 24, '2019-09-19 11:18:29', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (170, 24, '2019-09-19 12:13:31', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (171, 24, '2019-09-19 12:42:15', '山西省', '223.11.50.4', 'Android Mobile', 'Chrome Mobile', NULL);
INSERT INTO `loginlog` VALUES (172, 24, '2019-09-19 12:44:23', 'CHINA', '117.136.90.40', 'iOS 11 (iPhone)', 'Apple WebKit', NULL);
INSERT INTO `loginlog` VALUES (173, 24, '2019-09-19 12:46:07', '山西省', '1.68.19.237', 'Android 8.x', 'Chrome Mobile', NULL);
INSERT INTO `loginlog` VALUES (174, 24, '2019-09-19 12:56:14', '山西省', '223.11.163.180', 'Android Mobile', 'Chrome Mobile', NULL);
INSERT INTO `loginlog` VALUES (175, 24, '2019-09-19 13:00:10', '山西省', '223.11.50.4', 'Windows 10', 'Chrome 58', NULL);
INSERT INTO `loginlog` VALUES (176, 24, '2019-09-19 13:08:25', '山西省晋城市', '218.26.55.90', 'Android Mobile', 'Chrome Mobile', NULL);
INSERT INTO `loginlog` VALUES (177, 24, '2019-09-19 13:52:43', '陕西省', '171.117.130.208', 'Android Mobile', 'Chrome Mobile', NULL);
INSERT INTO `loginlog` VALUES (178, 24, '2019-09-19 14:06:24', '山西省', '1.68.14.8', 'Android Mobile', 'Chrome Mobile', NULL);
INSERT INTO `loginlog` VALUES (179, 24, '2019-09-19 14:32:31', '山西省晋城市', '218.26.54.48', 'Android Mobile', 'Chrome Mobile', NULL);
INSERT INTO `loginlog` VALUES (180, 24, '2019-09-19 15:18:14', '山西省', '1.68.98.152', 'Android 7.x', 'Chrome Mobile', NULL);
INSERT INTO `loginlog` VALUES (181, 24, '2019-09-19 18:34:06', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (182, 24, '2019-09-19 18:55:26', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (183, 24, '2019-09-19 19:08:22', '山西省太原市', '59.49.30.24', 'Windows 10', 'Internet Explorer 11', NULL);
INSERT INTO `loginlog` VALUES (184, 23, '2019-09-19 19:17:37', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (185, 24, '2019-09-19 19:19:30', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (186, 24, '2019-09-19 19:25:46', '山西省太原市', '59.49.30.24', 'Windows 7', 'Internet Explorer 11', NULL);
INSERT INTO `loginlog` VALUES (187, 24, '2019-09-19 19:26:50', '山西省太原市', '59.49.30.24', 'Windows 10', 'Internet Explorer 11', NULL);
INSERT INTO `loginlog` VALUES (189, 23, '2019-09-19 19:48:09', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (190, 23, '2019-09-19 19:48:43', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (191, 26, '2019-09-19 19:50:01', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (192, 24, '2019-09-19 19:54:52', '山西省太原市', '59.49.30.24', 'Windows 10', 'Internet Explorer 11', NULL);
INSERT INTO `loginlog` VALUES (193, 24, '2019-09-19 20:03:34', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (194, 24, '2019-09-19 20:04:27', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (195, 24, '2019-09-19 20:05:25', '山西省太原市', '59.49.30.24', 'Windows 10', 'Microsoft Edge', NULL);
INSERT INTO `loginlog` VALUES (196, 24, '2019-09-19 20:08:04', '山西省太原市', '59.49.30.24', 'Windows 10', 'Internet Explorer 11', NULL);
INSERT INTO `loginlog` VALUES (197, 26, '2019-09-19 20:08:29', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (198, 24, '2019-09-19 20:08:40', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (199, 24, '2019-09-19 21:12:54', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (200, 24, '2019-09-19 21:30:18', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (201, 24, '2019-09-19 21:36:05', '山西省', '1.68.16.137', 'Android Mobile', 'Chrome Mobile', NULL);
INSERT INTO `loginlog` VALUES (202, 24, '2019-09-19 21:36:06', '山西省晋城市', '218.26.55.97', 'Android 8.x', 'Chrome Mobile', NULL);
INSERT INTO `loginlog` VALUES (203, 24, '2019-09-19 21:36:08', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (204, 24, '2019-09-19 21:36:09', '山西省晋城市', '218.26.55.79', 'Android Mobile', 'Chrome Mobile', NULL);
INSERT INTO `loginlog` VALUES (205, 24, '2019-09-19 21:36:15', '山西省太原市', '59.49.30.24', 'Windows 10', 'Internet Explorer 11', NULL);
INSERT INTO `loginlog` VALUES (206, 24, '2019-09-19 21:36:21', '山西省太原市', '59.49.30.24', 'Android Mobile', 'Chrome Mobile', NULL);
INSERT INTO `loginlog` VALUES (207, 24, '2019-09-19 21:36:23', '山西省太原市', '59.49.30.24', 'Windows 10', 'Internet Explorer 11', NULL);
INSERT INTO `loginlog` VALUES (208, 24, '2019-09-19 21:38:25', '山西省', '223.11.160.140', 'Android 8.x', 'Chrome Mobile', NULL);
INSERT INTO `loginlog` VALUES (209, 24, '2019-09-19 22:45:28', '山西省', '223.11.54.105', 'Windows 10', 'Internet Explorer 11', NULL);
INSERT INTO `loginlog` VALUES (210, 24, '2019-09-20 08:04:53', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (211, 24, '2019-09-20 08:24:57', '山西省太原市', '183.185.89.152', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (212, 24, '2019-09-20 10:25:09', '山西省太原市', '183.185.89.152', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (213, 24, '2019-09-20 16:46:22', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (214, 24, '2019-09-20 17:40:32', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (215, 24, '2019-09-20 17:48:13', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (216, 26, '2019-09-20 17:48:37', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (217, 24, '2019-09-20 17:50:10', '山西省太原市', '59.49.30.24', 'Windows 10', 'Opera', NULL);
INSERT INTO `loginlog` VALUES (218, 26, '2019-09-20 17:51:40', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (219, 24, '2019-09-20 17:52:31', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (220, 26, '2019-09-20 17:52:41', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (221, 26, '2019-09-20 17:53:11', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (222, 26, '2019-09-20 17:53:24', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (223, 24, '2019-09-20 17:53:40', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (224, 26, '2019-09-20 17:53:52', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (225, 26, '2019-09-20 17:54:15', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (226, 26, '2019-09-20 17:55:05', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (227, 24, '2019-09-20 17:55:21', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (228, 26, '2019-09-20 17:55:32', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (229, 24, '2019-09-20 22:23:42', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (230, 26, '2019-09-20 22:23:56', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (231, 26, '2019-09-20 22:24:06', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (232, 24, '2019-09-20 22:24:23', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (233, 24, '2019-09-20 22:24:53', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (234, 24, '2019-09-20 22:25:05', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (235, 24, '2019-09-20 22:25:17', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (236, 26, '2019-09-20 22:25:56', '山西省太原市', '59.49.30.24', 'Windows 10', 'Firefox', NULL);
INSERT INTO `loginlog` VALUES (237, 24, '2019-09-21 09:51:20', '山西省', '1.68.20.251', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (238, 24, '2019-09-21 14:56:44', 'CHINA', '117.136.90.46', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (239, 24, '2019-09-21 15:18:36', 'CHINA', '117.136.90.46', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (240, 24, '2019-09-21 16:03:45', '山西省晋城市', '218.26.55.83', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (241, 26, '2019-09-22 08:55:40', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (242, 27, '2019-09-22 08:55:53', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (243, 23, '2019-09-22 08:56:09', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (244, 27, '2019-09-22 08:56:36', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (245, 23, '2019-09-22 08:58:56', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (246, 24, '2019-09-22 09:53:36', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);
INSERT INTO `loginlog` VALUES (247, 24, '2019-09-22 10:49:08', '山西省太原市', '59.49.30.24', 'Windows 10', 'Chrome', NULL);

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major`  (
  `majorid` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '专业编号',
  `deptid` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '院系编号',
  `majorname` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '专业名称',
  `majorremark` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '专业备注',
  PRIMARY KEY (`majorid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '专业实体' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES ('11', '1', '机械设计制造及其自动化', NULL);
INSERT INTO `major` VALUES ('12', '1', '机械电子工程', NULL);
INSERT INTO `major` VALUES ('13', '1', '材料成型及控制工程', NULL);
INSERT INTO `major` VALUES ('14', '1', '汽车服务工程', NULL);
INSERT INTO `major` VALUES ('22', '2', '通信工程', NULL);
INSERT INTO `major` VALUES ('23', '2', '电子信息工程', NULL);
INSERT INTO `major` VALUES ('52', '5', '数字媒体技术', NULL);
INSERT INTO `major` VALUES ('53', '5', '物联网工程', '');
INSERT INTO `major` VALUES ('54', '5', '计算机科学与技术', NULL);
INSERT INTO `major` VALUES ('55', '5', '网络工程', NULL);
INSERT INTO `major` VALUES ('56', '5', '软件工程', '');

-- ----------------------------
-- Table structure for stu_team
-- ----------------------------
DROP TABLE IF EXISTS `stu_team`;
CREATE TABLE `stu_team`  (
  `stid` int(11) NOT NULL AUTO_INCREMENT,
  `stuid` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '学生编号',
  `teamid` int(11) NOT NULL COMMENT '小组编号',
  `sturole` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`stid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 179 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '学生_小组关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stu_team
-- ----------------------------
INSERT INTO `stu_team` VALUES (114, '162056224', 20, '组长');
INSERT INTO `stu_team` VALUES (115, '162054124', 20, '组员');
INSERT INTO `stu_team` VALUES (116, '162054125', 20, '组员');
INSERT INTO `stu_team` VALUES (117, '162052116', 20, '组员');
INSERT INTO `stu_team` VALUES (118, '162054125', 21, '组长');
INSERT INTO `stu_team` VALUES (119, '162056224', 21, '组员');
INSERT INTO `stu_team` VALUES (120, '162054138', 21, '组员');
INSERT INTO `stu_team` VALUES (121, '162056224', 22, '组长');
INSERT INTO `stu_team` VALUES (122, '162054141', 22, '组员');
INSERT INTO `stu_team` VALUES (123, '162056224', 23, '组员');
INSERT INTO `stu_team` VALUES (124, '162056233', 23, '组员');
INSERT INTO `stu_team` VALUES (125, '162056221', 23, '组员');
INSERT INTO `stu_team` VALUES (126, '162056125', 23, '组长');
INSERT INTO `stu_team` VALUES (127, '162054109', 20, '组员');
INSERT INTO `stu_team` VALUES (128, '162054103', 20, '组员');
INSERT INTO `stu_team` VALUES (129, '162054124', 24, '组员');
INSERT INTO `stu_team` VALUES (130, '162054109', 24, '组员');
INSERT INTO `stu_team` VALUES (131, '162054103', 24, '组员');
INSERT INTO `stu_team` VALUES (132, '162056201', 24, '组长');
INSERT INTO `stu_team` VALUES (133, '162056224', 25, '组员');
INSERT INTO `stu_team` VALUES (134, '162054218', 25, '组员');
INSERT INTO `stu_team` VALUES (135, '162054225', 25, '组员');
INSERT INTO `stu_team` VALUES (136, '162054202', 25, '组长');
INSERT INTO `stu_team` VALUES (138, '162052107', 26, '组长');
INSERT INTO `stu_team` VALUES (139, '162052138', 26, '组员');
INSERT INTO `stu_team` VALUES (140, '162052133', 26, '组员');
INSERT INTO `stu_team` VALUES (141, '162052115', 26, '组员');
INSERT INTO `stu_team` VALUES (142, '162052105', 27, '组长');
INSERT INTO `stu_team` VALUES (143, '162052133', 27, '组员');
INSERT INTO `stu_team` VALUES (144, '162055103', 28, '组员');
INSERT INTO `stu_team` VALUES (145, '162055123', 28, '组员');
INSERT INTO `stu_team` VALUES (146, '162055114', 28, '组长');
INSERT INTO `stu_team` VALUES (147, '162055128', 28, '组员');
INSERT INTO `stu_team` VALUES (148, '162055114', 29, '组长');
INSERT INTO `stu_team` VALUES (149, '162055215', 29, '组员');
INSERT INTO `stu_team` VALUES (150, '162054119', 29, '组员');
INSERT INTO `stu_team` VALUES (151, '162055317', 30, '组长');
INSERT INTO `stu_team` VALUES (152, '162055337', 30, '组员');
INSERT INTO `stu_team` VALUES (153, '162055338', 30, '组员');
INSERT INTO `stu_team` VALUES (154, '162055338', 31, '组员');
INSERT INTO `stu_team` VALUES (155, '162055322', 31, '组长');
INSERT INTO `stu_team` VALUES (156, '162055306', 31, '组员');
INSERT INTO `stu_team` VALUES (157, '162056224', 32, '组员');
INSERT INTO `stu_team` VALUES (158, '162054225', 32, '组员');
INSERT INTO `stu_team` VALUES (159, '162056201', 32, '组长');
INSERT INTO `stu_team` VALUES (160, '172056101', 33, '组员');
INSERT INTO `stu_team` VALUES (161, '172056102', 33, '组员');
INSERT INTO `stu_team` VALUES (162, '172056113', 33, '组员');
INSERT INTO `stu_team` VALUES (163, '172054129', 33, '组员');
INSERT INTO `stu_team` VALUES (164, '172054130', 33, '组长');
INSERT INTO `stu_team` VALUES (165, '172052108', 33, '组员');
INSERT INTO `stu_team` VALUES (166, '172056213', 34, '组员');
INSERT INTO `stu_team` VALUES (167, '172056217', 34, '组员');
INSERT INTO `stu_team` VALUES (168, '172056239', 34, '组长');
INSERT INTO `stu_team` VALUES (169, '172055229', 34, '组员');
INSERT INTO `stu_team` VALUES (170, '172055215', 34, '组员');
INSERT INTO `stu_team` VALUES (171, '182055228', 35, '组员');
INSERT INTO `stu_team` VALUES (172, '182055233', 35, '组员');
INSERT INTO `stu_team` VALUES (173, '182056211', 35, '组员');
INSERT INTO `stu_team` VALUES (174, '182056221', 35, '组员');
INSERT INTO `stu_team` VALUES (175, '182056222', 35, '组长');
INSERT INTO `stu_team` VALUES (176, '192056241', 36, '组员');
INSERT INTO `stu_team` VALUES (177, '172056239', 36, '组长');
INSERT INTO `stu_team` VALUES (178, '192056216', 36, '组员');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `stuid` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '学生编号',
  `classid` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '班级编号',
  `stuname` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '学生姓名',
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '性别',
  `mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '联系方式',
  PRIMARY KEY (`stuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '参赛学生实体' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('162052105', '1620521', '马紫暄', '女', '15395465855');
INSERT INTO `student` VALUES ('162052107', '1620521', '张彦平', '男', '16315486833');
INSERT INTO `student` VALUES ('162052115', '1620521', '刘璞', '男', '15586996466');
INSERT INTO `student` VALUES ('162052116', '1620521', '李盼雪', '女', '15635485795');
INSERT INTO `student` VALUES ('162052133', '1620521', '张琪', '女', '15364925788');
INSERT INTO `student` VALUES ('162052138', '1620521', '詹丰铭', '男', '15364986545');
INSERT INTO `student` VALUES ('162054103', '1620541', '王贇', '女', '15564963633');
INSERT INTO `student` VALUES ('162054109', '1620541', '姚雁婷', '女', '15694866533');
INSERT INTO `student` VALUES ('162054119', '1620541', '陈小姑', '女', '15364926966');
INSERT INTO `student` VALUES ('162054124', '1620541', '董玥秀', '女', '15364958458');
INSERT INTO `student` VALUES ('162054125', '1620541', '任云康', '男', '18836452578');
INSERT INTO `student` VALUES ('162054138', '1620541', '邓成刚', '男', '15364958546');
INSERT INTO `student` VALUES ('162054141', '1620541', '王振民', '男', '13836459555');
INSERT INTO `student` VALUES ('162054202', '1620542', '郭天航', '男', '15364996488');
INSERT INTO `student` VALUES ('162054218', '1620542', '毛涛', '男', '15364925433');
INSERT INTO `student` VALUES ('162054225', '1620542', '雷添权', '男', '13654963699');
INSERT INTO `student` VALUES ('162055103', '1620551', '韩军', '男', '15364958755');
INSERT INTO `student` VALUES ('162055114', '1620551', '王尚楠', '男', '15364925788');
INSERT INTO `student` VALUES ('162055123', '1620551', '董凯', '男', '13836445838');
INSERT INTO `student` VALUES ('162055128', '1620551', '苏志彬', '男', '15536493699');
INSERT INTO `student` VALUES ('162055215', '1620552', '梁苗', '女', '13635469633');
INSERT INTO `student` VALUES ('162055306', '1620532', '郭梦雪', '男', '18635486933');
INSERT INTO `student` VALUES ('162055317', '1620531', '白文宇', '男', '13579563644');
INSERT INTO `student` VALUES ('162055322', '1620531', '刘利强', '男', '18636485633');
INSERT INTO `student` VALUES ('162055337', '1820531', '周国良', '男', '13864566232');
INSERT INTO `student` VALUES ('162055338', '1620532', '龙承卿', '男', '13635645838');
INSERT INTO `student` VALUES ('162056125', '1620561', '李沛橦', '男', '13654659855');
INSERT INTO `student` VALUES ('162056201', '1620562', '赵婉婷', '男', '15364926499');
INSERT INTO `student` VALUES ('162056221', '1620562', '李帆', '男', '15869665466');
INSERT INTO `student` VALUES ('162056224', '1620562', '刘浩', '男', '15364925795');
INSERT INTO `student` VALUES ('162056233', '1620562', '吴雨泽', '男', '13836459566');
INSERT INTO `student` VALUES ('172052108', '1720521', '刘文雅', '男', '16335487697');
INSERT INTO `student` VALUES ('172054129', '1720541', '王安琪', '女', '13836954635');
INSERT INTO `student` VALUES ('172054130', '1720541', '周训斌', '男', '13695986933');
INSERT INTO `student` VALUES ('172055215', '1720552', '郭晨洋', '男', '15364925766');
INSERT INTO `student` VALUES ('172055229', '1720552', '周伟杰', '男', '15649533696');
INSERT INTO `student` VALUES ('172056101', '1720561', '许亚', '男', '16595448536');
INSERT INTO `student` VALUES ('172056102', '1720561', '孙世豪', '男', '13695483655');
INSERT INTO `student` VALUES ('172056113', '1720561', '赵海琴', '女', '15564953685');
INSERT INTO `student` VALUES ('172056213', '1720562', '唐涛', '男', '13615469578');
INSERT INTO `student` VALUES ('172056217', '1720562', '吕晶晶', '男', '15696354866');
INSERT INTO `student` VALUES ('172056239', '1720562', '贺煜曈', '男', '16395463586');
INSERT INTO `student` VALUES ('182055228', '1820552', '邹宇熙', '男', '16364958766');
INSERT INTO `student` VALUES ('182055233', '1820552', '戴文伟', '男', '19546385795');
INSERT INTO `student` VALUES ('182056211', '1820562', '王鑫淼', '男', '16335896488');
INSERT INTO `student` VALUES ('182056221', '1820562', '张馨方', '女', '16984563588');
INSERT INTO `student` VALUES ('182056222', '1820562', '石梦圆', '男', '13695884533');
INSERT INTO `student` VALUES ('192056216', '1920562', '李轲', '男', '15325699544');
INSERT INTO `student` VALUES ('192056241', '1920562', '卢妍青', '男', '16336996866');

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team`  (
  `teamid` int(11) NOT NULL AUTO_INCREMENT COMMENT '小组编号',
  `competitionid` int(11) NOT NULL COMMENT '赛事编号',
  `teamgroup` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '小组组别',
  `teamname` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '小组名称',
  `leader` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `adviser` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '指导老师',
  `registusername` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '录入人员姓名',
  `registdate` datetime(0) NOT NULL COMMENT '录入时间',
  `award` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '获奖情况',
  PRIMARY KEY (`teamid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '参赛小组实体' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of team
-- ----------------------------
INSERT INTO `team` VALUES (20, 5, 'ACM一组', 'Blue Dream', '刘浩', '刘忠晔，宋志祥', '刘浩', '2019-09-15 12:31:20', '优秀奖');
INSERT INTO `team` VALUES (21, 1, '软件杯一组', 'Move Code', '任云康', '张立凡', '刘浩', '2019-09-15 12:34:22', '特等奖');
INSERT INTO `team` VALUES (22, 4, 'PAT一组', 'Aster', '刘浩', '张升', '刘浩', '2019-09-15 12:39:12', '特等奖');
INSERT INTO `team` VALUES (23, 3, '互联网+一组', 'Hello World', '李沛橦', '张麟华', '刘浩', '2019-09-15 12:44:54', '优秀奖');
INSERT INTO `team` VALUES (24, 3, '互联网+二组', 'Hello World', '赵婉婷', '秦晓辉', '刘浩', '2019-09-15 13:03:17', '待定');
INSERT INTO `team` VALUES (25, 5, 'ACM二组', '我们队', '郭天航', '杨慧炯、韩燕丽', '刘浩', '2019-09-15 13:06:59', '二等奖');
INSERT INTO `team` VALUES (26, 3, '互联网+三组', '牛奶面包', '张彦平', '孔令德', '刘浩', '2019-09-15 14:19:51', '三等奖');
INSERT INTO `team` VALUES (27, 4, '熳天飞羽', 'PAT二组', '马紫暄', '宋志祥', '刘浩', '2019-09-15 14:22:30', '未获奖');
INSERT INTO `team` VALUES (28, 1, '软件杯二组', '404', '王尚楠', '吴智军', '刘浩', '2019-09-15 14:26:26', '一等奖');
INSERT INTO `team` VALUES (29, 2, '蓝桥杯一组', '一九零二一', '王尚楠', '宋志祥', '刘浩', '2019-09-15 14:29:34', '未获奖');
INSERT INTO `team` VALUES (30, 1, '软件杯四组', '布匹虾刺', '白文宇', '张升', '刘浩', '2019-09-15 14:32:53', '一等奖');
INSERT INTO `team` VALUES (31, 1, '软件杯五组', '听妈妈的话', '刘利强', '张麟华', '刘浩', '2019-09-15 14:35:25', '未获奖');
INSERT INTO `team` VALUES (32, 30, '兴晋挑战杯一组', '我们要获奖', '赵婉婷', '张麟华，张升', '测试用户', '2019-09-16 12:29:10', '优秀奖');
INSERT INTO `team` VALUES (33, 30, '兴晋挑战杯二组', '梦想自己主宰', '周训斌', '张麟华，王伟', '测试用户', '2019-09-17 17:47:45', '待定');
INSERT INTO `team` VALUES (34, 30, '兴晋挑战杯三组', 'OMG', '贺煜曈', '张升', '测试用户', '2019-09-17 17:55:29', '优秀奖');
INSERT INTO `team` VALUES (35, 3, '互联网+四组', 'SXG', '石梦圆', '王峥，张麟华', '测试用户', '2019-09-17 18:04:09', '特等奖');
INSERT INTO `team` VALUES (36, 5, 'ACM三组', '不差钱', '贺煜曈', '张升', '测试用户', '2019-09-17 18:07:16', '未获奖');
INSERT INTO `team` VALUES (37, 0, 'xxx', 'xxx', 'xxx', 'xxx', 'xxx', '2019-09-17 18:07:18', 'xxx');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `userrole` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '身份/角色',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '用户名',
  `userpwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '用户密码',
  `realname` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '真实姓名',
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `userremark` varchar(5000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户备注',
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '用户实体' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (23, '管理员', 'liuhao', 'f927c8e05b5a813908d42f26555e6a75', '刘浩', '1', '作者本人呐，超级管理员<img src=\"http://101.200.47.217:8080/SCMS/lib/layui-v2.5.4/images/face/13.gif\" alt=\"[偷笑]\"><br>');
INSERT INTO `user` VALUES (24, '管理员', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '测试用户', '1', '<p>[用户名：super，密码：123456]（测试用户）</p>');
INSERT INTO `user` VALUES (26, '普通用户', 'user', 'e10adc3949ba59abbe56e057f20f883e', '普通用户', '1', '[用户名：user，密码：123456]（普通用户）');
INSERT INTO `user` VALUES (27, '管理员', 'super', 'e10adc3949ba59abbe56e057f20f883e', '管理员', '1', '<p>[用户名：super，密码：123456]（管理员）</p>');

-- ----------------------------
-- View structure for scms_classinfo
-- ----------------------------
DROP VIEW IF EXISTS `scms_classinfo`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `scms_classinfo` AS select `c`.`grade` AS `grade`,`d`.`deptid` AS `deptid`,`d`.`deptname` AS `deptname`,`m`.`majorid` AS `majorid`,`m`.`majorname` AS `majorname`,`c`.`classid` AS `classid`,`c`.`classname` AS `classname`,`c`.`classremark` AS `classremark` from ((`classes` `c` join `major` `m` on((`c`.`majorid` = `m`.`majorid`))) join `department` `d` on((`m`.`deptid` = `d`.`deptid`)));

-- ----------------------------
-- View structure for scms_loginloginfo
-- ----------------------------
DROP VIEW IF EXISTS `scms_loginloginfo`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `scms_loginloginfo` AS select `loginlog`.`logid` AS `logid`,`loginlog`.`userid` AS `userid`,`loginlog`.`logintime` AS `logintime`,`loginlog`.`loginsite` AS `loginsite`,`loginlog`.`loginip` AS `loginip`,`loginlog`.`loginos` AS `loginos`,`loginlog`.`loginbrowser` AS `loginbrowser`,`loginlog`.`loginremark` AS `loginremark`,`user`.`realname` AS `realname`,`user`.`username` AS `username` from (`loginlog` join `user`) where (`loginlog`.`userid` = `user`.`userid`);

-- ----------------------------
-- View structure for scms_statinfo
-- ----------------------------
DROP VIEW IF EXISTS `scms_statinfo`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `scms_statinfo` AS select `student`.`stuname` AS `stuname`,`student`.`stuid` AS `stuid`,`classes`.`classid` AS `classid`,`classes`.`grade` AS `grade`,`major`.`majorname` AS `majorname`,`stu_team`.`sturole` AS `sturole`,`team`.`teamid` AS `teamid`,`team`.`teamname` AS `teamname`,`team`.`adviser` AS `adviser`,`team`.`award` AS `award`,`competition`.`competitionid` AS `competitionid`,`competition`.`competitionname` AS `competitionname`,`competition`.`competitiondate` AS `competitiondate`,`major`.`majorid` AS `majorid`,`classes`.`classname` AS `classname` from (((((`student` join (`classes` join `major` on((`classes`.`majorid` = `major`.`majorid`)))) join `department`) join `stu_team`) join `team`) join `competition`) where ((`student`.`classid` = `classes`.`classid`) and (`classes`.`majorid` = `major`.`majorid`) and (`major`.`deptid` = `department`.`deptid`) and (`student`.`stuid` = `stu_team`.`stuid`) and (`stu_team`.`teamid` = `team`.`teamid`) and (`team`.`competitionid` = `competition`.`competitionid`));

-- ----------------------------
-- View structure for scms_stu_competition
-- ----------------------------
DROP VIEW IF EXISTS `scms_stu_competition`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `scms_stu_competition` AS select `stu_team`.`stuid` AS `stuid`,`team`.`competitionid` AS `competitionid`,`stu_team`.`sturole` AS `sturole` from (`team` join `stu_team`) where (`stu_team`.`teamid` = `team`.`teamid`);

-- ----------------------------
-- View structure for scms_studentinfo
-- ----------------------------
DROP VIEW IF EXISTS `scms_studentinfo`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `scms_studentinfo` AS select `s`.`stuid` AS `stuid`,`s`.`stuname` AS `stuname`,`s`.`sex` AS `sex`,`s`.`mobile` AS `mobile`,`c`.`classid` AS `classid`,`c`.`classname` AS `classname`,`m`.`majorid` AS `majorid`,`m`.`majorname` AS `majorname`,`d`.`deptid` AS `deptid`,`d`.`deptname` AS `deptname`,`c`.`grade` AS `grade` from (((`student` `s` join `classes` `c` on((`s`.`classid` = `c`.`classid`))) join `major` `m` on((`c`.`majorid` = `m`.`majorid`))) join `department` `d` on((`m`.`deptid` = `d`.`deptid`)));

-- ----------------------------
-- View structure for scms_team_info
-- ----------------------------
DROP VIEW IF EXISTS `scms_team_info`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `scms_team_info` AS select `team`.`teamid` AS `teamid`,`team`.`teamgroup` AS `teamgroup`,`team`.`teamname` AS `teamname`,`team`.`leader` AS `leader`,`team`.`adviser` AS `adviser`,`team`.`registusername` AS `registusername`,`team`.`registdate` AS `registdate`,`team`.`award` AS `award`,`competition`.`competitionname` AS `competitionname` from (`team` join `competition`) where (`team`.`competitionid` = `competition`.`competitionid`);

-- ----------------------------
-- View structure for scms_competition_by_stuid
-- ----------------------------
DROP VIEW IF EXISTS `scms_competition_by_stuid`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `scms_competition_by_stuid` AS select `scms_stu_competition`.`stuid` AS `stuid`,`scms_stu_competition`.`competitionid` AS `competitionid`,`scms_stu_competition`.`sturole` AS `sturole`,`competition`.`competitionname` AS `competitionname`,`competition`.`competitiondate` AS `competitiondate`,`competition`.`competitionlevel` AS `competitionlevel`,`competition`.`competitiontype` AS `competitiontype`,`competition`.`competitiondescribe` AS `competitiondescribe` from (`scms_stu_competition` join `competition`) where (`scms_stu_competition`.`competitionid` = `competition`.`competitionid`);

SET FOREIGN_KEY_CHECKS = 1;

/*
Navicat MySQL Data Transfer

Source Server         : Admin
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : management

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-01-01 15:11:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `course_test`
-- ----------------------------
DROP TABLE IF EXISTS `course_test`;
CREATE TABLE `course_test` (
  `number` varchar(20) DEFAULT NULL,
  `学生` varchar(20) DEFAULT NULL,
  `课程名称` varchar(20) DEFAULT NULL,
  `成绩` int(3) DEFAULT NULL,
  `学分` int(3) unsigned DEFAULT NULL,
  `学时数` int(3) unsigned DEFAULT NULL,
  `教师` varchar(20) DEFAULT NULL,
  `教师编号` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_test
-- ----------------------------
INSERT INTO `course_test` VALUES ('2015220204002', 'haoyouab', '面向对象程序', '60', '2', '40', '陈峥', '200522001');
INSERT INTO `course_test` VALUES ('2015220204002', 'haoyouab', '计算机组成原理', '80', '2', '40', '李巧勤', '200522002');
INSERT INTO `course_test` VALUES ('2015220204001', 'snow', '计算机组成原理', '100', '2', '40', '李巧勤', '200522002');
INSERT INTO `course_test` VALUES ('2015220204002', 'haoyouab', '编译技术', '59', '2', '20', '周帆', '200522003');
INSERT INTO `course_test` VALUES ('2015220204001', 'snow', '面向对象程序', '100', '2', '40', '陈峥', '200522001');

-- ----------------------------
-- Table structure for `instructor`
-- ----------------------------
DROP TABLE IF EXISTS `instructor`;
CREATE TABLE `instructor` (
  `number` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `faculty` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of instructor
-- ----------------------------
INSERT INTO `instructor` VALUES ('122001', '周哥', '信息与软件工程学院');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `number` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `birthday` varchar(20) DEFAULT NULL,
  `faculty` varchar(20) DEFAULT NULL,
  `major` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('2015220204001', 'snow', 'female', '1997.10.05', '生命科学学院', '生命科学');
INSERT INTO `student` VALUES ('2015220204002', 'haoyouab', 'male', '1996.07.04', '信息与软件工程学院', '软件技术');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `number` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `faculty` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('200522001', '陈峥', '信息与软件工程学院');
INSERT INTO `teacher` VALUES ('200522002', '李巧勤', '信息与软件工程学院');
INSERT INTO `teacher` VALUES ('200522003', '周帆', '信息与软件工程学院');

-- ----------------------------
-- Table structure for `token`
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token` (
  `number` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `token` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of token
-- ----------------------------
INSERT INTO `token` VALUES ('2015220204002', '123', 'student');
INSERT INTO `token` VALUES ('2015220204001', '123', 'student');
INSERT INTO `token` VALUES ('200522001', '123', 'teacher');
INSERT INTO `token` VALUES ('200522002', '123', 'teacher');
INSERT INTO `token` VALUES ('122001', '123', 'instructor');
INSERT INTO `token` VALUES ('200522003', '123', 'teacher');

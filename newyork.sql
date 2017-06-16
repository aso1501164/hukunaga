-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2017 年 6 朁E16 日 03:55
-- サーバのバージョン： 10.1.10-MariaDB
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `newyork`
--

-- --------------------------------------------------------

--
-- テーブルの構造 `application`
--

CREATE TABLE `application` (
  `student_id` varchar(10) NOT NULL,
  `subject_id_1` varchar(10) NOT NULL,
  `subject_id_2` varchar(10) NOT NULL,
  `year` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `application`
--

INSERT INTO `application` (`student_id`, `subject_id_1`, `subject_id_2`, `year`) VALUES
('0001', '2001', '2002', 'H30'),
('0002', '2002', '2003', 'T10');

-- --------------------------------------------------------

--
-- テーブルの構造 `classification`
--

CREATE TABLE `classification` (
  `classification_id` varchar(15) NOT NULL,
  `classification_name` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `classification`
--

INSERT INTO `classification` (`classification_id`, `classification_name`) VALUES
('01', 'IT'),
('02', '英語'),
('03', 'コミュニケーション');

-- --------------------------------------------------------

--
-- テーブルの構造 `history`
--

CREATE TABLE `history` (
  `student_id` varchar(10) NOT NULL,
  `subject_id_1` varchar(10) NOT NULL,
  `subject_id_2` varchar(10) NOT NULL,
  `year` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `history`
--

INSERT INTO `history` (`student_id`, `subject_id_1`, `subject_id_2`, `year`) VALUES
('0001', '2001', '2002', 'H30');

-- --------------------------------------------------------

--
-- テーブルの構造 `manager`
--

CREATE TABLE `manager` (
  `manager_id` varchar(10) NOT NULL,
  `manager_name` varchar(15) NOT NULL,
  `password` varchar(10) NOT NULL,
  `permission` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `manager`
--

INSERT INTO `manager` (`manager_id`, `manager_name`, `password`, `permission`) VALUES
('1001', 'マイケル・サニーサイド', '0123', '1'),
('1002', 'グラン・マ', '01234', '0');

-- --------------------------------------------------------

--
-- テーブルの構造 `student`
--

CREATE TABLE `student` (
  `student_id` varchar(10) NOT NULL,
  `student_name` varchar(15) NOT NULL,
  `password` varchar(10) NOT NULL,
  `class_name` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `student`
--

INSERT INTO `student` (`student_id`, `student_name`, `password`, `class_name`) VALUES
('0001', '花田涼', '1234', '星組'),
('0002', '大神一郎', '12345', '花組');

-- --------------------------------------------------------

--
-- テーブルの構造 `subject`
--

CREATE TABLE `subject` (
  `subject_id` varchar(4) NOT NULL,
  `classification_id` varchar(15) NOT NULL,
  `subject_name` varchar(15) NOT NULL,
  `manager_id` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `subject`
--

INSERT INTO `subject` (`subject_id`, `classification_id`, `subject_name`, `manager_id`) VALUES
('2001', '01', 'プロジェクト開発演習', '1001'),
('2002', '02', '英会話', '1002'),
('2003', '03', 'イシュカン・コミュニケーション', '1002');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `application`
--
ALTER TABLE `application`
  ADD PRIMARY KEY (`student_id`),
  ADD KEY `subject_id_1` (`subject_id_1`,`subject_id_2`),
  ADD KEY `subject_id_2` (`subject_id_2`),
  ADD KEY `year` (`year`);

--
-- Indexes for table `classification`
--
ALTER TABLE `classification`
  ADD PRIMARY KEY (`classification_id`);

--
-- Indexes for table `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`student_id`,`year`),
  ADD KEY `subject_id_1` (`subject_id_1`,`subject_id_2`),
  ADD KEY `subject_id_2` (`subject_id_2`),
  ADD KEY `year` (`year`);

--
-- Indexes for table `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`manager_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`student_id`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`subject_id`),
  ADD KEY `manager_id` (`manager_id`),
  ADD KEY `manager_id_2` (`manager_id`),
  ADD KEY `manager_id_3` (`manager_id`),
  ADD KEY `classification_id` (`classification_id`);

--
-- ダンプしたテーブルの制約
--

--
-- テーブルの制約 `application`
--
ALTER TABLE `application`
  ADD CONSTRAINT `application_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`),
  ADD CONSTRAINT `application_ibfk_2` FOREIGN KEY (`subject_id_1`) REFERENCES `subject` (`subject_id`),
  ADD CONSTRAINT `application_ibfk_3` FOREIGN KEY (`subject_id_2`) REFERENCES `subject` (`subject_id`);

--
-- テーブルの制約 `history`
--
ALTER TABLE `history`
  ADD CONSTRAINT `history_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`),
  ADD CONSTRAINT `history_ibfk_2` FOREIGN KEY (`subject_id_1`) REFERENCES `subject` (`subject_id`),
  ADD CONSTRAINT `history_ibfk_3` FOREIGN KEY (`subject_id_2`) REFERENCES `subject` (`subject_id`),
  ADD CONSTRAINT `history_ibfk_4` FOREIGN KEY (`year`) REFERENCES `application` (`year`);

--
-- テーブルの制約 `subject`
--
ALTER TABLE `subject`
  ADD CONSTRAINT `subject_ibfk_1` FOREIGN KEY (`manager_id`) REFERENCES `manager` (`manager_id`),
  ADD CONSTRAINT `subject_ibfk_2` FOREIGN KEY (`classification_id`) REFERENCES `classification` (`classification_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

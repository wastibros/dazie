-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 01, 2020 at 06:37 PM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `student_tutor_ms`
--

-- --------------------------------------------------------

--
-- Table structure for table `grind`
--

CREATE TABLE `grind` (
  `grind_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  `location_id` int(11) DEFAULT NULL,
  `g_location` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `capacity` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `grind`
--

INSERT INTO `grind` (`grind_id`, `name`, `subject_id`, `location_id`, `g_location`, `date`, `time`, `price`, `capacity`) VALUES
(1, 'James', 1, 1, 'At the School', '5/5/20', '16:00', '€20', '12');

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `location_id` int(11) NOT NULL,
  `location` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`location_id`, `location`) VALUES
(1, 'Cork City'),
(2, 'Mallow');

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

CREATE TABLE `messages` (
  `id` int(11) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `sender` tinyint(4) NOT NULL,
  `message` varchar(1000) NOT NULL,
  `datetime` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `messages`
--

INSERT INTO `messages` (`id`, `teacher_id`, `student_id`, `sender`, `message`, `datetime`) VALUES
(1, 1, 1, 1, 'hello sir', '2020-02-28 07:16:19'),
(2, 1, 1, 0, 'yes, do you need help', '2020-02-28 07:16:19'),
(3, 1, 1, 0, 'new message', '2020-02-28 07:44:52'),
(4, 1, 1, 0, 'test message 3', '2020-02-28 07:45:14'),
(5, 1, 1, 0, 'test message obj', '2020-02-28 13:33:45'),
(6, 1, 1, 0, '$message', '2020-02-28 13:42:00'),
(7, 1, 1, 0, 'new message', '2020-02-28 13:43:57'),
(8, 1, 1, 0, 'abc', '2020-02-28 13:45:42'),
(9, 1, 1, 0, 'allok ', '2020-02-28 13:47:32'),
(10, 1, 1, 0, 'allok123', '2020-02-28 13:50:06'),
(11, 1, 1, 0, 'abc bbbbb', '2020-02-28 13:51:04'),
(12, 1, 1, 0, 'abbb', '2020-02-28 13:54:18'),
(13, 1, 1, 1, 'sdfghjkl', '2020-02-28 14:12:21'),
(14, 1, 1, 1, 'sdfghjkcvbl', '2020-02-28 14:12:29'),
(15, 1, 1, 0, 'ahsann', '2020-03-01 10:03:43'),
(16, 1, 1, 0, 'jee?', '2020-03-01 10:12:53'),
(17, 1, 3, 0, 'adfa', '2020-03-01 12:48:28'),
(18, 3, 3, 1, 'hello', '2020-03-01 15:34:13'),
(19, 3, 3, 0, 'hi', '2020-03-01 15:34:44'),
(20, 3, 3, 0, 'how are you bro?', '2020-03-01 15:35:43'),
(21, 3, 3, 1, 'i am completly fine what about you?', '2020-03-01 15:36:01'),
(22, 3, 3, 0, 'fine. bye. i dont want to chat with you', '2020-03-01 15:36:20'),
(23, 3, 1, 0, 'hi', '2020-03-01 15:57:41');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `std_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `location_id` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`std_id`, `name`, `email`, `description`, `location_id`, `password`) VALUES
(1, 'James Ryan', 'jryan24298@gmail.com', 'No comments', 1, '123'),
(2, 'Billy', '12345@gmail.com', '6 years exp.', 1, 'yes'),
(3, 'Ahsan ', 'mahsanprogrammer@gmail.com', 'English, Urdu, Mathematics', 1, '500359');

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `subject_id` int(11) NOT NULL,
  `subject` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`subject_id`, `subject`) VALUES
(1, 'Maths'),
(2, 'English'),
(3, 'Science');

-- --------------------------------------------------------

--
-- Table structure for table `tutor`
--

CREATE TABLE `tutor` (
  `tutor_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `availbility` varchar(255) DEFAULT NULL,
  `location_id` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tutor`
--

INSERT INTO `tutor` (`tutor_id`, `name`, `email`, `password`, `photo`, `availbility`, `location_id`, `description`) VALUES
(1, 'James Ryan', '116451436@umail.ucc.ie', '123', NULL, '5 hours', 2, 'no'),
(2, 'Johnny', 'johnny@gmail.com', '12345', NULL, '5 hours', 2, 'No'),
(3, 'Ahsan', 'ahsan@gmail.com', '500359', NULL, '', 1, 'BS Software engineering\r\n');

-- --------------------------------------------------------

--
-- Table structure for table `tutor_subject`
--

CREATE TABLE `tutor_subject` (
  `tutor_id` int(11) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tutor_subject`
--

INSERT INTO `tutor_subject` (`tutor_id`, `subject_id`) VALUES
(2, 1),
(2, 2),
(2, 3),
(3, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `grind`
--
ALTER TABLE `grind`
  ADD PRIMARY KEY (`grind_id`),
  ADD KEY `subject_id` (`subject_id`),
  ADD KEY `location_id` (`location_id`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`location_id`);

--
-- Indexes for table `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`std_id`),
  ADD KEY `location_id` (`location_id`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`subject_id`);

--
-- Indexes for table `tutor`
--
ALTER TABLE `tutor`
  ADD PRIMARY KEY (`tutor_id`),
  ADD KEY `location_id` (`location_id`);

--
-- Indexes for table `tutor_subject`
--
ALTER TABLE `tutor_subject`
  ADD KEY `subject_id` (`subject_id`),
  ADD KEY `tutor_id` (`tutor_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `grind`
--
ALTER TABLE `grind`
  MODIFY `grind_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `location`
--
ALTER TABLE `location`
  MODIFY `location_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `messages`
--
ALTER TABLE `messages`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `std_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `subject`
--
ALTER TABLE `subject`
  MODIFY `subject_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tutor`
--
ALTER TABLE `tutor`
  MODIFY `tutor_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `grind`
--
ALTER TABLE `grind`
  ADD CONSTRAINT `grind_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`),
  ADD CONSTRAINT `grind_ibfk_2` FOREIGN KEY (`location_id`) REFERENCES `location` (`location_id`);

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`location_id`) REFERENCES `location` (`location_id`);

--
-- Constraints for table `tutor`
--
ALTER TABLE `tutor`
  ADD CONSTRAINT `tutor_ibfk_1` FOREIGN KEY (`location_id`) REFERENCES `location` (`location_id`);

--
-- Constraints for table `tutor_subject`
--
ALTER TABLE `tutor_subject`
  ADD CONSTRAINT `tutor_subject_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`),
  ADD CONSTRAINT `tutor_subject_ibfk_2` FOREIGN KEY (`tutor_id`) REFERENCES `tutor` (`tutor_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

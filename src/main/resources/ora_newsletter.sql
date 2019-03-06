-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 16, 2018 at 03:39 PM
-- Server version: 5.7.9
-- PHP Version: 5.6.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ora_newsletter`
--

-- --------------------------------------------------------

--
-- Table structure for table `master_newsletter`
--

DROP TABLE IF EXISTS `master_newsletter`;
CREATE TABLE IF NOT EXISTS `master_newsletter` (
  `newsletter_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `language_id` bigint(20) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`newsletter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `master_subscriber`
--

DROP TABLE IF EXISTS `master_subscriber`;
CREATE TABLE IF NOT EXISTS `master_subscriber` (
  `sub_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sub_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `master_subscriber`
--

INSERT INTO `master_subscriber` (`sub_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `email_id`, `name`) VALUES
(1, 1, '2018-12-16 20:45:19', NULL, NULL, 'avirup.pal@gmail.com', 'Avirup Pal');

-- --------------------------------------------------------

--
-- Table structure for table `newsletter_vs_image`
--

DROP TABLE IF EXISTS `newsletter_vs_image`;
CREATE TABLE IF NOT EXISTS `newsletter_vs_image` (
  `nli_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `newsletter_id` bigint(20) NOT NULL,
  PRIMARY KEY (`nli_id`),
  KEY `FKmxx1bbgrqwhqg72u4jwx3t5iu` (`newsletter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `subscriber_vs_newsletter_log`
--

DROP TABLE IF EXISTS `subscriber_vs_newsletter_log`;
CREATE TABLE IF NOT EXISTS `subscriber_vs_newsletter_log` (
  `snl_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `newsletter_id` bigint(20) NOT NULL,
  `sub_id` bigint(20) NOT NULL,
  PRIMARY KEY (`snl_id`),
  KEY `FKnhb1ieqj6swihmx2b6a2hu3y4` (`newsletter_id`),
  KEY `FK5oav79jfhusrlyyt1fpnpbqb1` (`sub_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `newsletter_vs_image`
--
ALTER TABLE `newsletter_vs_image`
  ADD CONSTRAINT `FKmxx1bbgrqwhqg72u4jwx3t5iu` FOREIGN KEY (`newsletter_id`) REFERENCES `master_newsletter` (`newsletter_id`);

--
-- Constraints for table `subscriber_vs_newsletter_log`
--
ALTER TABLE `subscriber_vs_newsletter_log`
  ADD CONSTRAINT `FK5oav79jfhusrlyyt1fpnpbqb1` FOREIGN KEY (`sub_id`) REFERENCES `master_subscriber` (`sub_id`),
  ADD CONSTRAINT `FKnhb1ieqj6swihmx2b6a2hu3y4` FOREIGN KEY (`newsletter_id`) REFERENCES `master_newsletter` (`newsletter_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

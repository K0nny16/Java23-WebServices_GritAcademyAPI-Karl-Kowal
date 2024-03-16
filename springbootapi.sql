-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Värd: 127.0.0.1
-- Tid vid skapande: 16 mars 2024 kl 19:14
-- Serverversion: 10.4.32-MariaDB
-- PHP-version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Databas: `springbootapi`
--

-- --------------------------------------------------------

--
-- Tabellstruktur `courses`
--

CREATE TABLE `courses` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `YHP` int(11) DEFAULT NULL,
  `description` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumpning av Data i tabell `courses`
--

INSERT INTO `courses` (`id`, `name`, `YHP`, `description`) VALUES
(1, 'Matematik 101', 10, 'Introduktion till grundläggande matematiska begrepp och problemlösningsförmåga.'),
(2, 'Engelsk litteratur', 5, 'Översikt över engelsk litteratur från olika perioder och författare.'),
(3, 'Datavetenskap', 15, 'Grundläggande datavetenskap, inklusive algoritmer och programmering.'),
(4, 'Konsthistoria', 1, 'Utforskning av stora konströrelser och verk genom historien.'),
(5, 'Fysik 101', 20, 'Introduktion till klassisk mekanik, termodynamik och elektromagnetism.'),
(6, 'Biologins grunder', 15, 'Introduktion till cellbiologi, genetik och ekologi.'),
(7, 'Kemiens essenser', 10, 'Grundläggande principer inom kemi, inklusive atomär struktur och kemiska reaktioner.'),
(8, 'Psykologi 101', 5, 'Introduktion till grundläggande begrepp och teorier inom psykologi.'),
(9, 'Ekonomins grundläggande', 20, 'Introduktion till mikroekonomi och makroekonomi.'),
(10, 'Sociologins essenser', 10, 'Översikt över sociologiska begrepp, teorier och forskningsmetoder.');

-- --------------------------------------------------------

--
-- Tabellstruktur `students`
--

CREATE TABLE `students` (
  `id` int(11) NOT NULL,
  `fName` varchar(255) NOT NULL,
  `lName` varchar(255) NOT NULL,
  `town` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumpning av Data i tabell `students`
--

INSERT INTO `students` (`id`, `fName`, `lName`, `town`, `email`, `phone`, `username`, `password`) VALUES
(1, 'Anna', 'Andersson', 'Stockholm', 'anna.andersson@example.com', '0701234567', 'anna_a', 'password123'),
(2, 'Erik', 'Eriksson', 'Göteborg', 'erik.eriksson@example.com', '0739876543', 'erik_e', 'securepass'),
(3, 'Maria', 'Johansson', 'Malmö', 'maria.johansson@example.com', '0762468135', 'mariaj', 'p@ssw0rd'),
(4, 'Karl', 'Karlsson', 'Uppsala', 'karl.karlsson@example.com', '0723698521', 'karl_k', 'pass123'),
(5, 'Sara', 'Nilsson', 'Lund', 'sara.nilsson@example.com', '0712345678', 'sara_n', 'student123'),
(6, 'Anders', 'Persson', 'Linköping', 'anders.persson@example.com', '0709876543', 'andersp', 'password!'),
(7, 'Emma', 'Lindgren', 'Örebro', 'emma.lindgren@example.com', '0765432198', 'emmal', 'secure123'),
(8, 'Lisa', 'Svensson', 'Jönköping', 'lisa.svensson@example.com', '0731234567', 'lisa_s', 'pass1234'),
(9, 'Mikael', 'Gustafsson', 'Västerås', 'mikael.gustafsson@example.com', '0706543219', 'mika_g', 'studentpass'),
(10, 'Jenny', 'Berg', 'Norrköping', 'jenny.berg@example.com', '0729876543', 'jennyb', 'mypassword');

-- --------------------------------------------------------

--
-- Tabellstruktur `students_courses`
--

CREATE TABLE `students_courses` (
  `id` int(11) NOT NULL,
  `students_id` int(11) DEFAULT NULL,
  `courses_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumpning av Data i tabell `students_courses`
--

INSERT INTO `students_courses` (`id`, `students_id`, `courses_id`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(11, 4, 2),
(4, 4, 4),
(5, 5, 1),
(6, 6, 2),
(7, 7, 3),
(8, 8, 4),
(9, 9, 1),
(10, 10, 2);

--
-- Index för dumpade tabeller
--

--
-- Index för tabell `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`,`YHP`);

--
-- Index för tabell `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Index för tabell `students_courses`
--
ALTER TABLE `students_courses`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `students_id` (`students_id`,`courses_id`),
  ADD KEY `courses_id` (`courses_id`);

--
-- AUTO_INCREMENT för dumpade tabeller
--

--
-- AUTO_INCREMENT för tabell `courses`
--
ALTER TABLE `courses`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT för tabell `students`
--
ALTER TABLE `students`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT för tabell `students_courses`
--
ALTER TABLE `students_courses`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- Restriktioner för dumpade tabeller
--

--
-- Restriktioner för tabell `students_courses`
--
ALTER TABLE `students_courses`
  ADD CONSTRAINT `students_courses_ibfk_1` FOREIGN KEY (`students_id`) REFERENCES `students` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `students_courses_ibfk_2` FOREIGN KEY (`courses_id`) REFERENCES `courses` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

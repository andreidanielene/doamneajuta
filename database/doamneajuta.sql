-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 14, 2018 at 11:48 PM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `doamneajuta`
--

-- --------------------------------------------------------

--
-- Table structure for table `teams`
--

CREATE TABLE `teams` (
  `teamName` varchar(30) NOT NULL,
  `stadium` varchar(50) NOT NULL,
  `city` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `teams`
--

INSERT INTO `teams` (`teamName`, `stadium`, `city`) VALUES
('Juventus Turin', 'Juventus Stadium', 'Turin, Italy'),
('Cagliari Calcio', 'Sardegna Arena', 'Cagliari, Sardinia'),
('Hellas Verona FC', 'Stadio Marc\'Antonio Bentegodi', 'Verona, Veneto'),
('SSC Napoli', 'Stadio San Paolo', 'Naples, Campania'),
('Atalanta BC', 'Stadio Atleti Azzurri d\'Italia', 'Bergamo, Lombardy'),
('AS Roma', 'Stadio Olimpico', 'Rome'),
('Udinese Calcio', 'Stadio Friuli', 'Udine, Friuli-Venezia Giulia'),
('AC Chievo Verona', 'Stadio Marc\'Antonio Bentegodi', 'Verona, Veneto'),
('US Sassuolo Calcio', 'Mapei Stadium–Città del Tricolore', 'Sassuolo'),
('Genoa CFC', 'Stadio Luigi Ferraris', 'Genoa, Liguria'),
('UC Sampdoria', 'Stadio Luigi Ferraris', 'Genoa, Italy'),
('Benevento Calcio', 'Stadio Ciro Vigorito', 'Benevento, Campania'),
('SS Lazio', 'Stadio Olimpico', 'Rome'),
('SPAL Ferrara', 'Stadio Paolo Mazza', 'Ferrara, Emilia-Romagna'),
('FC Internazionale Milano', 'San Siro Stadium', 'Milan, Italy'),
('ACF Fiorentina', 'Stadio Artemio Franchi', 'Florence, Tuscany'),
('Bologna FC', 'Stadio Renato Dall\'Ara', 'Bologna, Emilia-Romagna'),
('Torino FC', 'Stadio Olimpico Grande Torino', 'Turin, Piedmont'),
('FC Crotone', 'Stadio Ezio Scida', 'Crotone, Calabria'),
('AC Milan', 'San Siro Stadium', 'Milan, Italy');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(30) NOT NULL,
  `password` varchar(16) NOT NULL,
  `fullName` varchar(32) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `town` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`, `fullName`, `phone`, `town`) VALUES
('test@doamneajuta.ro', 'test', 'Test User', '0744123456', 'Bucharest'),
('test@test.com', 'test', NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

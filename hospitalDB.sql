-- phpMyAdmin SQL Dump
-- version 4.4.15.7
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1:3306
-- Час створення: Вер 29 2016 р., 00:05
-- Версія сервера: 5.5.50
-- Версія PHP: 5.3.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База даних: `hospitalDB`
--

-- --------------------------------------------------------

--
-- Структура таблиці `Doctors`
--

CREATE TABLE IF NOT EXISTS `Doctors` (
  `Id` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Surname` varchar(100) NOT NULL,
  `Specialization` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Дамп даних таблиці `Doctors`
--

INSERT INTO `Doctors` (`Id`, `Name`, `Surname`, `Specialization`) VALUES
(1, 'Kate', 'Johnson', 'pediatr');

-- --------------------------------------------------------

--
-- Структура таблиці `RegistrationCards`
--

CREATE TABLE IF NOT EXISTS `RegistrationCards` (
  `Id` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Surname` varchar(100) NOT NULL,
  `DOB` date DEFAULT NULL,
  `Address` varchar(200) DEFAULT NULL,
  `Diagnosis` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблиці `VisitsJournal`
--

CREATE TABLE IF NOT EXISTS `VisitsJournal` (
  `Id` int(11) NOT NULL,
  `IdPatient` int(11) NOT NULL,
  `IdDoctor` int(11) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Індекси збережених таблиць
--

--
-- Індекси таблиці `Doctors`
--
ALTER TABLE `Doctors`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Id` (`Id`);

--
-- Індекси таблиці `RegistrationCards`
--
ALTER TABLE `RegistrationCards`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Id` (`Id`);

--
-- Індекси таблиці `VisitsJournal`
--
ALTER TABLE `VisitsJournal`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Id` (`Id`);

--
-- AUTO_INCREMENT для збережених таблиць
--

--
-- AUTO_INCREMENT для таблиці `Doctors`
--
ALTER TABLE `Doctors`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT для таблиці `RegistrationCards`
--
ALTER TABLE `RegistrationCards`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблиці `VisitsJournal`
--
ALTER TABLE `VisitsJournal`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

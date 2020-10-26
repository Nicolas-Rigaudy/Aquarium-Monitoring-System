-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : lun. 26 oct. 2020 à 14:05
-- Version du serveur :  10.3.25-MariaDB-0+deb10u1
-- Version de PHP : 7.3.19-1~deb10u1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `aquarium-monitoring`
--

-- --------------------------------------------------------

--
-- Structure de la table `luminosite`
--

CREATE TABLE `luminosite` (
  `id` int(11) NOT NULL,
  `timestamp` varchar(100) NOT NULL,
  `luminosite` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `luminosite`
--

INSERT INTO `luminosite` (`id`, `timestamp`, `luminosite`) VALUES
(1, '', 100),
(2, '', 100),
(3, '', 100),
(4, '30/09/2020/12:43:52', 100),
(5, '30/09/2020/18:14:30', 100),
(6, '30/09/2020/18:35:47', 0),
(7, '30/09/2020/18:36:04', 100),
(8, '30/09/2020/19:26:56', 100),
(9, '30/09/2020/19:27:04', 100),
(10, '30/09/2020/19:28:04', 100),
(11, '30/09/2020/19:30:03', 100),
(12, '30/09/2020/19:31:03', 100),
(13, '30/09/2020/19:32:03', 0),
(14, '30/09/2020/19:33:03', 100),
(15, '30/09/2020/19:33:29', 0),
(16, '30/09/2020/19:33:41', 0),
(17, '30/09/2020/19:34:03', 0),
(18, '30/09/2020/19:34:22', 0),
(19, '30/09/2020/19:35:03', 0),
(20, '30/09/2020/19:36:04', 0),
(21, '30/09/2020/19:37:22', 100),
(22, '30/09/2020/19:38:04', 100),
(23, '01/10/2020/15:46:04', 100),
(24, '01/10/2020/15:50:19', 100),
(25, '01/10/2020/15:50:22', 100),
(26, '01/10/2020/15:50:25', 100),
(27, '01/10/2020/15:50:27', 100),
(28, '01/10/2020/15:51:03', 100),
(29, '01/10/2020/15:52:04', 100),
(30, '01/10/2020/15:53:04', 100),
(31, '01/10/2020/15:54:04', 100),
(32, '01/10/2020/15:55:04', 100),
(33, '01/10/2020/15:56:04', 100),
(34, '01/10/2020/15:57:04', 100),
(35, '01/10/2020/15:58:04', 100),
(36, '01/10/2020/15:59:04', 100),
(37, '01/10/2020/16:01:04', 100),
(38, '01/10/2020/16:02:03', 100),
(39, '01/10/2020/16:03:04', 100),
(40, '01/10/2020/16:04:06', 100),
(41, '01/10/2020/19:34:26', 0);

-- --------------------------------------------------------

--
-- Structure de la table `temperature`
--

CREATE TABLE `temperature` (
  `id` int(11) NOT NULL,
  `timestamp` varchar(100) NOT NULL,
  `temperature` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `temperature`
--

INSERT INTO `temperature` (`id`, `timestamp`, `temperature`) VALUES
(1, '30/09/2020/12:34:50', 25),
(2, '30/09/2020/18:15:17', 22),
(3, '30/09/2020/18:35:02', 32),
(4, '30/09/2020/18:35:46', 22),
(5, '30/09/2020/18:36:03', 54),
(6, '30/09/2020/19:26:56', 22),
(7, '30/09/2020/19:27:04', 22),
(8, '30/09/2020/19:28:04', 54),
(9, '30/09/2020/19:29:04', 22),
(10, '30/09/2020/19:30:03', 22),
(11, '30/09/2020/19:31:03', 22),
(12, '30/09/2020/19:32:03', 22),
(13, '30/09/2020/19:33:03', 32),
(14, '30/09/2020/19:33:28', 22),
(15, '30/09/2020/19:33:40', 22),
(16, '30/09/2020/19:34:03', 32),
(17, '30/09/2020/19:34:21', 32),
(18, '30/09/2020/19:35:03', 32),
(19, '30/09/2020/19:36:03', 22),
(20, '30/09/2020/19:37:22', 22),
(21, '30/09/2020/19:38:03', 22),
(22, '01/10/2020/15:46:03', 26.812),
(23, '01/10/2020/15:50:18', 26.812),
(24, '01/10/2020/15:50:21', 26.812),
(25, '01/10/2020/15:50:24', 26.812),
(26, '01/10/2020/15:50:27', 26.812),
(27, '01/10/2020/15:51:03', 26.812),
(28, '01/10/2020/15:52:03', 26.812),
(29, '01/10/2020/15:53:03', 26.812),
(30, '01/10/2020/15:54:04', 26.812),
(31, '01/10/2020/15:55:04', 26.812),
(32, '01/10/2020/15:56:04', 26.875),
(33, '01/10/2020/15:57:03', 26.875),
(34, '01/10/2020/15:58:03', 26.875),
(35, '01/10/2020/15:59:03', 26.875),
(36, '01/10/2020/16:00:03', 26.875),
(37, '01/10/2020/16:01:04', 26.875),
(38, '01/10/2020/16:02:03', 26.875),
(39, '01/10/2020/16:03:03', 26.875),
(40, '01/10/2020/16:04:05', 26.875),
(41, '01/10/2020/19:34:26', 20.625);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `luminosite`
--
ALTER TABLE `luminosite`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `temperature`
--
ALTER TABLE `temperature`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `luminosite`
--
ALTER TABLE `luminosite`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT pour la table `temperature`
--
ALTER TABLE `temperature`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 07 avr. 2026 à 16:53
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `springjpa_relationship`
--

-- --------------------------------------------------------

--
-- Structure de la table `applicant`
--

CREATE TABLE `applicant` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `applicant`
--

INSERT INTO `applicant` (`id`, `name`, `email`, `phone`, `status`) VALUES
(1, 'Peter', 'bertin@gmail.com', '4182613537', 'pending'),
(2, 'Rambo2', 'asslrom@gmail.com', '5122649853', 'updating'),
(3, 'Anodol', 'metalonfge@gmail.com', '4182649256', 'pending'),
(4, 'NARCISSE', 'narcotrop@gmail.com', '5762843823', 'Working'),
(5, 'Jenabe', 'ciscodebordo@gtyz.com', '4823293823', 'Single');

-- --------------------------------------------------------

--
-- Structure de la table `applicantjob`
--

CREATE TABLE `applicantjob` (
  `id` int(11) NOT NULL,
  `applicant_id` int(11) NOT NULL,
  `job_id` int(11) NOT NULL,
  `date` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `applicantjob`
--

INSERT INTO `applicantjob` (`id`, `applicant_id`, `job_id`, `date`) VALUES
(4, 1, 1, '2026-04-07 05:21:40'),
(2, 1, 2, '2026-04-07 05:21:40'),
(20, 1, 3, NULL),
(5, 2, 1, '2026-04-07 05:21:40'),
(21, 2, 3, NULL),
(8, 3, 1, '2026-04-07 05:21:40'),
(10, 3, 2, '2026-04-07 05:21:40'),
(22, 3, 3, NULL),
(17, 4, 1, NULL),
(18, 4, 2, NULL),
(24, 4, 3, NULL),
(14, 5, 1, '2026-04-17 02:32:32'),
(15, 5, 2, '2026-04-23 02:33:03'),
(23, 5, 3, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `applications`
--

CREATE TABLE `applications` (
  `id` int(11) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `positon` varchar(50) DEFAULT NULL,
  `applicant_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `applications`
--

INSERT INTO `applications` (`id`, `status`, `positon`, `applicant_id`) VALUES
(1, 'Processing', 'Human resource office', 1),
(2, 'Processing', 'HR office', 2),
(3, 'DONE', 'PM office', 3),
(4, 'ALLMOST DONE', 'DIRECTORS office', 1),
(5, 'Pending signature', 'Bureau de la direction centrals', 2),
(6, 'Missing file', 'Secretary', 3),
(7, 'Done', 'Divion office', 2),
(8, 'INSPECTING', 'health and recovery', 2),
(9, 'Submision going on', 'Apacheur', 2),
(10, 'Traitement en cours', 'Intendance provinciale', 2),
(11, 'Traitement en cours', 'Bureau provinciale', 1);

-- --------------------------------------------------------

--
-- Structure de la table `job`
--

CREATE TABLE `job` (
  `id` int(11) NOT NULL,
  `title` varchar(50) NOT NULL,
  `description` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `job`
--

INSERT INTO `job` (`id`, `title`, `description`) VALUES
(1, 'Mecanic', 'Repairs cars'),
(2, 'Electricien', 'Fix any electricity problem'),
(3, 'Engineer', 'Works with brain');

-- --------------------------------------------------------

--
-- Structure de la table `resume`
--

CREATE TABLE `resume` (
  `id` int(11) NOT NULL,
  `content` varchar(80) DEFAULT NULL,
  `applicant_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `resume`
--

INSERT INTO `resume` (`id`, `content`, `applicant_id`) VALUES
(1, 'Demande d\'embauche', 2),
(2, 'Regroupement familial', 2),
(3, 'Regroupement familial', 1),
(4, 'Visa pour le canada', 1),
(5, 'Tranport urbain', 3),
(6, 'Demande de visa', 3),
(7, 'Recherche emploi', 3),
(8, 'Travaux termine', 3),
(9, 'Pret et bourse', 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `applicant`
--
ALTER TABLE `applicant`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `applicantjob`
--
ALTER TABLE `applicantjob`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `applicantjob_unique` (`applicant_id`,`job_id`,`date`),
  ADD KEY `job_id` (`job_id`);

--
-- Index pour la table `applications`
--
ALTER TABLE `applications`
  ADD PRIMARY KEY (`id`),
  ADD KEY `applications_ibfk_1` (`applicant_id`);

--
-- Index pour la table `job`
--
ALTER TABLE `job`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `resume`
--
ALTER TABLE `resume`
  ADD PRIMARY KEY (`id`),
  ADD KEY `resume_ibfk_1` (`applicant_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `applicant`
--
ALTER TABLE `applicant`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `applicantjob`
--
ALTER TABLE `applicantjob`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT pour la table `applications`
--
ALTER TABLE `applications`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT pour la table `job`
--
ALTER TABLE `job`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `resume`
--
ALTER TABLE `resume`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `applicantjob`
--
ALTER TABLE `applicantjob`
  ADD CONSTRAINT `applicantjob_ibfk_1` FOREIGN KEY (`applicant_id`) REFERENCES `applicant` (`id`),
  ADD CONSTRAINT `applicantjob_ibfk_2` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`);

--
-- Contraintes pour la table `applications`
--
ALTER TABLE `applications`
  ADD CONSTRAINT `applications_ibfk_1` FOREIGN KEY (`applicant_id`) REFERENCES `applicant` (`id`);

--
-- Contraintes pour la table `resume`
--
ALTER TABLE `resume`
  ADD CONSTRAINT `resume_ibfk_1` FOREIGN KEY (`applicant_id`) REFERENCES `applicant` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

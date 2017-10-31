-- phpMyAdmin SQL Dump
-- version 4.6.6deb4
-- https://www.phpmyadmin.net/
--
-- Client :  localhost:3306
-- Généré le :  Mar 31 Octobre 2017 à 15:01
-- Version du serveur :  5.7.20-0ubuntu0.17.04.1
-- Version de PHP :  7.0.22-0ubuntu0.17.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `regatteTest`
--

-- --------------------------------------------------------

--
-- Structure de la table `challenge`
--

CREATE TABLE `challenge` (
  `id` int(11) NOT NULL,
  `nom` varchar(256) NOT NULL,
  `mois_debut` varchar(256) NOT NULL,
  `mois_fin` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

CREATE TABLE `classe` (
  `id` int(11) NOT NULL,
  `nom` varchar(256) NOT NULL,
  `coefficient` float NOT NULL,
  `id_serie` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `club`
--

CREATE TABLE `club` (
  `id` int(11) NOT NULL,
  `nom` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `code`
--

CREATE TABLE `code` (
  `id` int(11) NOT NULL,
  `nom` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `comite`
--

CREATE TABLE `comite` (
  `id` int(11) NOT NULL,
  `nom` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `commissaire`
--

CREATE TABLE `commissaire` (
  `id` int(11) NOT NULL,
  `id_personne` int(11) NOT NULL,
  `id_comite` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `concurent`
--

CREATE TABLE `concurent` (
  `id` int(11) NOT NULL,
  `id_personne` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `course`
--

CREATE TABLE `course` (
  `id` int(11) NOT NULL,
  `numero_inscription_valide` mediumint(9) NOT NULL,
  `nombre_point` tinyint(4) NOT NULL,
  `temps_reel` time NOT NULL,
  `position` smallint(10) NOT NULL,
  `id_regatte` int(11) NOT NULL,
  `id_voilier` int(11) NOT NULL,
  `id_equipage` int(11) NOT NULL,
  `id_code` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `enregistrer`
--

CREATE TABLE `enregistrer` (
  `id` int(11) NOT NULL,
  `id_jury` int(11) NOT NULL,
  `id_regatte` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `equipage`
--

CREATE TABLE `equipage` (
  `id` int(11) NOT NULL,
  `nom` varchar(256) NOT NULL,
  `id_skypper` int(11) NOT NULL,
  `id_concurent` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `jury`
--

CREATE TABLE `jury` (
  `id` int(11) NOT NULL,
  `id_personne` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `membres`
--

CREATE TABLE `membres` (
  `id` int(11) NOT NULL,
  `pseudo` varchar(256) NOT NULL,
  `pwd` char(8) NOT NULL,
  `id_personne` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE `personne` (
  `id` int(11) NOT NULL,
  `nom` varchar(256) NOT NULL,
  `prenom` varchar(256) NOT NULL,
  `adresse` varchar(256) NOT NULL,
  `code_postal` varchar(256) NOT NULL,
  `ville` varchar(256) NOT NULL,
  `telephone` varchar(256) NOT NULL,
  `email` varchar(256) NOT NULL,
  `date_naissance` date NOT NULL,
  `affilie_FFV` tinyint(1) NOT NULL DEFAULT '0',
  `numero_licence` varchar(256) NOT NULL,
  `date_licence` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `personnel`
--

CREATE TABLE `personnel` (
  `id` int(11) NOT NULL,
  `status` varchar(256) NOT NULL,
  `id_personne` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `pointe`
--

CREATE TABLE `pointe` (
  `id` int(11) NOT NULL,
  `id_commissaire` int(11) NOT NULL,
  `id_regatte` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `proprietaire`
--

CREATE TABLE `proprietaire` (
  `id` int(11) NOT NULL,
  `id_personne` int(11) NOT NULL,
  `id_club` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `regatte`
--

CREATE TABLE `regatte` (
  `id` int(11) NOT NULL,
  `nom` varchar(256) NOT NULL,
  `lieu` varchar(256) NOT NULL,
  `numero_course` tinyint(4) NOT NULL,
  `distance` bigint(20) NOT NULL,
  `id_challenge` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `serie`
--

CREATE TABLE `serie` (
  `id` int(11) NOT NULL,
  `nom` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `skypper`
--

CREATE TABLE `skypper` (
  `id` int(11) NOT NULL,
  `id_personne` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `voilier`
--

CREATE TABLE `voilier` (
  `id` int(11) NOT NULL,
  `numero_voile` smallint(6) NOT NULL,
  `id_propietaire` int(11) NOT NULL,
  `id_classe` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `challenge`
--
ALTER TABLE `challenge`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `classe`
--
ALTER TABLE `classe`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_serie` (`id_serie`);

--
-- Index pour la table `club`
--
ALTER TABLE `club`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `code`
--
ALTER TABLE `code`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `comite`
--
ALTER TABLE `comite`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `commissaire`
--
ALTER TABLE `commissaire`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_personne` (`id_personne`),
  ADD KEY `id_comite` (`id_comite`);

--
-- Index pour la table `concurent`
--
ALTER TABLE `concurent`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_personne` (`id_personne`);

--
-- Index pour la table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_regatte` (`id_regatte`),
  ADD KEY `id_voilier` (`id_voilier`),
  ADD KEY `id_equipage` (`id_equipage`),
  ADD KEY `id_code` (`id_code`);

--
-- Index pour la table `enregistrer`
--
ALTER TABLE `enregistrer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_regatte` (`id_regatte`),
  ADD KEY `id_jury` (`id_jury`);

--
-- Index pour la table `equipage`
--
ALTER TABLE `equipage`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_skypper` (`id_skypper`),
  ADD KEY `id_concurent` (`id_concurent`);

--
-- Index pour la table `jury`
--
ALTER TABLE `jury`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_personne` (`id_personne`);

--
-- Index pour la table `membres`
--
ALTER TABLE `membres`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_personne` (`id_personne`);

--
-- Index pour la table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `personnel`
--
ALTER TABLE `personnel`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_personne` (`id_personne`);

--
-- Index pour la table `pointe`
--
ALTER TABLE `pointe`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_commissaire` (`id_commissaire`),
  ADD KEY `id_regatte` (`id_regatte`);

--
-- Index pour la table `proprietaire`
--
ALTER TABLE `proprietaire`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_personne` (`id_personne`),
  ADD KEY `id_club` (`id_club`);

--
-- Index pour la table `regatte`
--
ALTER TABLE `regatte`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_challenge` (`id_challenge`);

--
-- Index pour la table `serie`
--
ALTER TABLE `serie`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `skypper`
--
ALTER TABLE `skypper`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_personne` (`id_personne`);

--
-- Index pour la table `voilier`
--
ALTER TABLE `voilier`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_classe` (`id_classe`),
  ADD KEY `id_propietaire` (`id_propietaire`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `challenge`
--
ALTER TABLE `challenge`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `classe`
--
ALTER TABLE `classe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `club`
--
ALTER TABLE `club`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `code`
--
ALTER TABLE `code`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `comite`
--
ALTER TABLE `comite`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `commissaire`
--
ALTER TABLE `commissaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `concurent`
--
ALTER TABLE `concurent`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `course`
--
ALTER TABLE `course`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `enregistrer`
--
ALTER TABLE `enregistrer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `equipage`
--
ALTER TABLE `equipage`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `jury`
--
ALTER TABLE `jury`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `membres`
--
ALTER TABLE `membres`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `personne`
--
ALTER TABLE `personne`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `personnel`
--
ALTER TABLE `personnel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `pointe`
--
ALTER TABLE `pointe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `proprietaire`
--
ALTER TABLE `proprietaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `regatte`
--
ALTER TABLE `regatte`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `serie`
--
ALTER TABLE `serie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `skypper`
--
ALTER TABLE `skypper`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `voilier`
--
ALTER TABLE `voilier`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `classe`
--
ALTER TABLE `classe`
  ADD CONSTRAINT `classe_ibfk_1` FOREIGN KEY (`id_serie`) REFERENCES `serie` (`id`);

--
-- Contraintes pour la table `commissaire`
--
ALTER TABLE `commissaire`
  ADD CONSTRAINT `commissaire_ibfk_1` FOREIGN KEY (`id_personne`) REFERENCES `personne` (`id`),
  ADD CONSTRAINT `commissaire_ibfk_2` FOREIGN KEY (`id_comite`) REFERENCES `comite` (`id`);

--
-- Contraintes pour la table `concurent`
--
ALTER TABLE `concurent`
  ADD CONSTRAINT `concurent_ibfk_1` FOREIGN KEY (`id_personne`) REFERENCES `personne` (`id`);

--
-- Contraintes pour la table `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `course_ibfk_1` FOREIGN KEY (`id_regatte`) REFERENCES `regatte` (`id`),
  ADD CONSTRAINT `course_ibfk_2` FOREIGN KEY (`id_voilier`) REFERENCES `voilier` (`id`),
  ADD CONSTRAINT `course_ibfk_3` FOREIGN KEY (`id_equipage`) REFERENCES `equipage` (`id`),
  ADD CONSTRAINT `course_ibfk_4` FOREIGN KEY (`id_code`) REFERENCES `code` (`id`);

--
-- Contraintes pour la table `enregistrer`
--
ALTER TABLE `enregistrer`
  ADD CONSTRAINT `enregistrer_ibfk_1` FOREIGN KEY (`id_jury`) REFERENCES `jury` (`id`),
  ADD CONSTRAINT `enregistrer_ibfk_2` FOREIGN KEY (`id_regatte`) REFERENCES `regatte` (`id`);

--
-- Contraintes pour la table `equipage`
--
ALTER TABLE `equipage`
  ADD CONSTRAINT `equipage_ibfk_1` FOREIGN KEY (`id_skypper`) REFERENCES `skypper` (`id`),
  ADD CONSTRAINT `equipage_ibfk_2` FOREIGN KEY (`id_concurent`) REFERENCES `concurent` (`id`);

--
-- Contraintes pour la table `jury`
--
ALTER TABLE `jury`
  ADD CONSTRAINT `jury_ibfk_1` FOREIGN KEY (`id_personne`) REFERENCES `personne` (`id`);

--
-- Contraintes pour la table `membres`
--
ALTER TABLE `membres`
  ADD CONSTRAINT `membres_ibfk_1` FOREIGN KEY (`id_personne`) REFERENCES `personne` (`id`);

--
-- Contraintes pour la table `personnel`
--
ALTER TABLE `personnel`
  ADD CONSTRAINT `personnel_ibfk_1` FOREIGN KEY (`id_personne`) REFERENCES `personne` (`id`);

--
-- Contraintes pour la table `pointe`
--
ALTER TABLE `pointe`
  ADD CONSTRAINT `pointe_ibfk_1` FOREIGN KEY (`id_commissaire`) REFERENCES `commissaire` (`id`),
  ADD CONSTRAINT `pointe_ibfk_2` FOREIGN KEY (`id_regatte`) REFERENCES `regatte` (`id`);

--
-- Contraintes pour la table `proprietaire`
--
ALTER TABLE `proprietaire`
  ADD CONSTRAINT `proprietaire_ibfk_1` FOREIGN KEY (`id_personne`) REFERENCES `personne` (`id`),
  ADD CONSTRAINT `proprietaire_ibfk_2` FOREIGN KEY (`id_club`) REFERENCES `club` (`id`);

--
-- Contraintes pour la table `regatte`
--
ALTER TABLE `regatte`
  ADD CONSTRAINT `regatte_ibfk_1` FOREIGN KEY (`id_challenge`) REFERENCES `challenge` (`id`);

--
-- Contraintes pour la table `skypper`
--
ALTER TABLE `skypper`
  ADD CONSTRAINT `skypper_ibfk_1` FOREIGN KEY (`id_personne`) REFERENCES `personne` (`id`);

--
-- Contraintes pour la table `voilier`
--
ALTER TABLE `voilier`
  ADD CONSTRAINT `voilier_ibfk_1` FOREIGN KEY (`id_propietaire`) REFERENCES `proprietaire` (`id`),
  ADD CONSTRAINT `voilier_ibfk_2` FOREIGN KEY (`id_classe`) REFERENCES `classe` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

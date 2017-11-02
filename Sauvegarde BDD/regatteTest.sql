-- phpMyAdmin SQL Dump
-- version 4.6.6deb4
-- https://www.phpmyadmin.net/
--
-- Client :  localhost:3306
-- Généré le :  Jeu 02 Novembre 2017 à 09:08
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

DELIMITER $$
--
-- Procédures
--
CREATE DEFINER=`admin`@`localhost` PROCEDURE `Moyenne_des_distance_regate_pour_un_challenge` (IN `id_challenge` INT)  NO SQL
SELECT c.nom AS CHALLENGE, AVG(r.distance) AS MOYENNEDISTANCECOURU
FROM `challenge` c
INNER JOIN `regatte` r
ON c.id= r.id_challenge
GROUP BY c.nom$$

DELIMITER ;

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

--
-- Contenu de la table `challenge`
--

INSERT INTO `challenge` (`id`, `nom`, `mois_debut`, `mois_fin`) VALUES
(1, 'Ete', 'mai', 'septembre'),
(2, 'Hiver', 'novembre', 'mars');

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

--
-- Contenu de la table `classe`
--

INSERT INTO `classe` (`id`, `nom`, `coefficient`, `id_serie`) VALUES
(12, 'corsaire', 1.2, 1),
(13, 'surprise', 1.3, 1),
(14, '8 mètre', 1.1, 1),
(15, 'maraudeur', 1, 1),
(16, 'figaro', 2.1, 1),
(17, 'flying fifteen', 1.5, 2),
(18, 'soling', 0.5, 2),
(19, 'star', 0.8, 2),
(20, 'tempest', 0.9, 2),
(21, 'yngling', 1.1, 2),
(22, '5.5', 0.9, 2);

-- --------------------------------------------------------

--
-- Structure de la table `club`
--

CREATE TABLE `club` (
  `id` int(11) NOT NULL,
  `nom` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `club`
--

INSERT INTO `club` (`id`, `nom`) VALUES
(1, 'YC Val André'),
(2, 'YC Binic'),
(3, 'YC Le Lequé'),
(4, 'YC Saint Quay');

-- --------------------------------------------------------

--
-- Structure de la table `code`
--

CREATE TABLE `code` (
  `id` int(11) NOT NULL,
  `nom` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `code`
--

INSERT INTO `code` (`id`, `nom`) VALUES
(1, 'OK'),
(2, 'DNC'),
(3, 'DNS'),
(4, 'OCS'),
(5, 'ZFP'),
(6, 'BFD'),
(7, 'DNF'),
(8, 'RAF'),
(9, 'DSQ'),
(10, 'DNE et DGM');

-- --------------------------------------------------------

--
-- Structure de la table `comite`
--

CREATE TABLE `comite` (
  `id` int(11) NOT NULL,
  `nom` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `comite`
--

INSERT INTO `comite` (`id`, `nom`) VALUES
(1, 'Bretagne'),
(2, 'Normandie'),
(3, 'Ile de france');

-- --------------------------------------------------------

--
-- Structure de la table `commissaire`
--

CREATE TABLE `commissaire` (
  `id` int(11) NOT NULL,
  `id_personne` int(11) NOT NULL,
  `id_comite` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `commissaire`
--

INSERT INTO `commissaire` (`id`, `id_personne`, `id_comite`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `concurent`
--

CREATE TABLE `concurent` (
  `id` int(11) NOT NULL,
  `id_personne` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `concurent`
--

INSERT INTO `concurent` (`id`, `id_personne`) VALUES
(1, 3),
(2, 4),
(3, 5);

-- --------------------------------------------------------

--
-- Structure de la table `course`
--

CREATE TABLE `course` (
  `id` int(11) NOT NULL,
  `numero_inscription_valide` varchar(9) NOT NULL,
  `nombre_point` tinyint(4) NOT NULL,
  `temps_reel` time NOT NULL,
  `position` smallint(10) NOT NULL,
  `id_regatte` int(11) NOT NULL,
  `id_voilier` int(11) NOT NULL,
  `id_equipage` int(11) NOT NULL,
  `id_code` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `course`
--

INSERT INTO `course` (`id`, `numero_inscription_valide`, `nombre_point`, `temps_reel`, `position`, `id_regatte`, `id_voilier`, `id_equipage`, `id_code`) VALUES
(1, '142525R6', 3, '01:22:00', 3, 1, 1, 1, 1),
(2, '2584R6', 4, '02:50:00', 4, 1, 2, 2, 5);

-- --------------------------------------------------------

--
-- Structure de la table `enregistrer`
--

CREATE TABLE `enregistrer` (
  `id` int(11) NOT NULL,
  `id_jury` int(11) NOT NULL,
  `id_regatte` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `enregistrer`
--

INSERT INTO `enregistrer` (`id`, `id_jury`, `id_regatte`) VALUES
(1, 1, 1);

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

--
-- Contenu de la table `equipage`
--

INSERT INTO `equipage` (`id`, `nom`, `id_skypper`, `id_concurent`) VALUES
(1, 'team Val', 1, 1),
(2, 'team bi', 2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `jury`
--

CREATE TABLE `jury` (
  `id` int(11) NOT NULL,
  `id_personne` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `jury`
--

INSERT INTO `jury` (`id`, `id_personne`) VALUES
(1, 7);

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

--
-- Contenu de la table `membres`
--

INSERT INTO `membres` (`id`, `pseudo`, `pwd`, `id_personne`) VALUES
(1, 'secretaire', '1234', 6);

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
  `numero_licence` varchar(256) DEFAULT 'non licencié',
  `date_licence` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `personne`
--

INSERT INTO `personne` (`id`, `nom`, `prenom`, `adresse`, `code_postal`, `ville`, `telephone`, `email`, `date_naissance`, `affilie_FFV`, `numero_licence`, `date_licence`) VALUES
(1, 'Le Hegarat', 'Marcel', '1 rue des près', '29300', 'rédéné', '668443965', 'marcel@gmail.com', '1960-12-21', 1, '12548', '2017-01-22'),
(2, 'Martin', 'Marcel', 'le biberon', '52000', 'le rhum', '522555225', 'martin@gmail.com', '1952-08-05', 1, '56255', '2017-01-01'),
(3, 'Malmal', 'thibault', 'lestand', '56200', 'plouay', '645825962', 'MT@gmail.com', '1998-08-15', 1, '25852', '2017-02-02'),
(4, 'Kurszt', 'trash', 'palourde', '72000', 'le mans', '256759502', 'kursz@gmail.com', '2001-06-25', 1, '45874', '2017-01-03'),
(5, 'Kateau', 'arnaud', '15 bd leclerc', '22100', 'dinan', '685459625', 'arn@gmail.com', '1999-01-06', 1, '58652', '2017-01-04'),
(6, 'Morgane', 'clara', 'allé du strip', '95000', 'passy', '60000006', 'claramorgane@hotmail.com', '1978-04-04', 0, 'non licencié', NULL),
(7, 'Saquet', 'Bilbon', 'la compté', '74000', 'chamberry', '258569845', 'bilbon@gmail.com', '2002-02-15', 1, '58526', '2017-03-05'),
(8, 'Letroc', 'pierre', 'laroc', '58000', 'saint andré', '745855858', 'groas@gmail.com', '1956-01-22', 1, '85642', '2017-03-05'),
(9, 'De La montagne', 'Hubert', 'cote du chenil', '45000', 'orléans', '356825255', 'hub@gmail.com', '1995-05-31', 0, 'non licencié', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `personnel`
--

CREATE TABLE `personnel` (
  `id` int(11) NOT NULL,
  `status` varchar(256) NOT NULL,
  `id_personne` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `personnel`
--

INSERT INTO `personnel` (`id`, `status`, `id_personne`) VALUES
(1, 'secrétaire', 6);

-- --------------------------------------------------------

--
-- Structure de la table `pointe`
--

CREATE TABLE `pointe` (
  `id` int(11) NOT NULL,
  `id_commissaire` int(11) NOT NULL,
  `id_regatte` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `pointe`
--

INSERT INTO `pointe` (`id`, `id_commissaire`, `id_regatte`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `proprietaire`
--

CREATE TABLE `proprietaire` (
  `id` int(11) NOT NULL,
  `id_personne` int(11) NOT NULL,
  `id_club` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `proprietaire`
--

INSERT INTO `proprietaire` (`id`, `id_personne`, `id_club`) VALUES
(1, 2, 1),
(2, 9, 2);

-- --------------------------------------------------------

--
-- Structure de la table `regatte`
--

CREATE TABLE `regatte` (
  `id` int(11) NOT NULL,
  `nom` varchar(256) NOT NULL,
  `date` date NOT NULL,
  `lieu` varchar(256) NOT NULL,
  `numero_course` tinyint(4) NOT NULL,
  `distance` bigint(20) NOT NULL,
  `id_challenge` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `regatte`
--

INSERT INTO `regatte` (`id`, `nom`, `date`, `lieu`, `numero_course`, `distance`, `id_challenge`) VALUES
(1, 'bai de saint brieuc', '2017-09-15', 'saint-brieuc', 6, 5000, 2);

-- --------------------------------------------------------

--
-- Structure de la table `serie`
--

CREATE TABLE `serie` (
  `id` int(11) NOT NULL,
  `nom` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `serie`
--

INSERT INTO `serie` (`id`, `nom`) VALUES
(1, 'Habitable'),
(2, 'Quillards sport');

-- --------------------------------------------------------

--
-- Structure de la table `skypper`
--

CREATE TABLE `skypper` (
  `id` int(11) NOT NULL,
  `id_personne` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `skypper`
--

INSERT INTO `skypper` (`id`, `id_personne`) VALUES
(1, 2),
(2, 5);

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
-- Contenu de la table `voilier`
--

INSERT INTO `voilier` (`id`, `numero_voile`, `id_propietaire`, `id_classe`) VALUES
(1, 7, 1, 13),
(2, 199, 2, 16);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `classe`
--
ALTER TABLE `classe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT pour la table `club`
--
ALTER TABLE `club`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `code`
--
ALTER TABLE `code`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT pour la table `comite`
--
ALTER TABLE `comite`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `commissaire`
--
ALTER TABLE `commissaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `concurent`
--
ALTER TABLE `concurent`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `course`
--
ALTER TABLE `course`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `enregistrer`
--
ALTER TABLE `enregistrer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `equipage`
--
ALTER TABLE `equipage`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `jury`
--
ALTER TABLE `jury`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `membres`
--
ALTER TABLE `membres`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `personne`
--
ALTER TABLE `personne`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT pour la table `personnel`
--
ALTER TABLE `personnel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `pointe`
--
ALTER TABLE `pointe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `proprietaire`
--
ALTER TABLE `proprietaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `regatte`
--
ALTER TABLE `regatte`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `serie`
--
ALTER TABLE `serie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `skypper`
--
ALTER TABLE `skypper`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `voilier`
--
ALTER TABLE `voilier`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
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

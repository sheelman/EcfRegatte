#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: challenge
#------------------------------------------------------------

CREATE TABLE challenge(
        id         Int NOT NULL ,
        nom        Varchar (256) NOT NULL ,
        mois_debut Varchar (256) NOT NULL ,
        mois_fin   Varchar (256) NOT NULL ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: classe
#------------------------------------------------------------

CREATE TABLE classe(
        id          Int NOT NULL ,
        nom         Varchar (256) NOT NULL ,
        coefficient Float NOT NULL ,
        id_serie    Int NOT NULL ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: club
#------------------------------------------------------------

CREATE TABLE club(
        id  Int NOT NULL ,
        nom Varchar (256) NOT NULL ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: code
#------------------------------------------------------------

CREATE TABLE code(
        id  Int NOT NULL ,
        nom Varchar (256) NOT NULL ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: comite
#------------------------------------------------------------

CREATE TABLE comite(
        id  Int NOT NULL ,
        nom Varchar (256) NOT NULL ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: commissaire
#------------------------------------------------------------

CREATE TABLE commissaire(
        id          Int NOT NULL ,
        id_personne Int NOT NULL ,
        id_comite   Int NOT NULL ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: concurent
#------------------------------------------------------------

CREATE TABLE concurent(
        id          Int NOT NULL ,
        id_personne Int NOT NULL ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: course
#------------------------------------------------------------

CREATE TABLE course(
        id                        Int NOT NULL ,
        numero_inscription_valide Mediumint NOT NULL ,
        nombre_point              TinyINT NOT NULL ,
        temps_reel                Time NOT NULL ,
        position                  Smallint NOT NULL ,
        id_regatte                Int NOT NULL ,
        id_voilier                Int NOT NULL ,
        id_equipage               Int NOT NULL ,
        id_code                   Int NOT NULL ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: enregistrer
#------------------------------------------------------------

CREATE TABLE enregistrer(
        id         Int NOT NULL ,
        id_jury    Int NOT NULL ,
        id_regatte Int NOT NULL ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: equipage
#------------------------------------------------------------

CREATE TABLE equipage(
        id           Int NOT NULL ,
        nom          Varchar (256) NOT NULL ,
        id_skypper   Int NOT NULL ,
        id_concurent Int NOT NULL ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: jury
#------------------------------------------------------------

CREATE TABLE jury(
        id          Int NOT NULL ,
        id_personne Int NOT NULL ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: membres
#------------------------------------------------------------

CREATE TABLE membres(
        id          Int NOT NULL ,
        pseudo      Varchar (256) NOT NULL ,
        pwd         Char (8) NOT NULL ,
        id_personne Int NOT NULL ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: personne
#------------------------------------------------------------

CREATE TABLE personne(
        id             Int NOT NULL ,
        nom            Varchar (256) NOT NULL ,
        prenom         Varchar (256) NOT NULL ,
        adresse        Varchar (256) NOT NULL ,
        code_postal    Varchar (256) NOT NULL ,
        ville          Varchar (256) NOT NULL ,
        telephone      Varchar (256) NOT NULL ,
        email          Varchar (256) NOT NULL ,
        date_naissance Date NOT NULL ,
        affilie_FFV    Bool NOT NULL ,
        numero_licence Varchar (256) NOT NULL ,
        date_licence   Date NOT NULL ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: personnel
#------------------------------------------------------------

CREATE TABLE personnel(
        id          Int NOT NULL ,
        status      Varchar (256) NOT NULL ,
        id_personne Int NOT NULL ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: pointe
#------------------------------------------------------------

CREATE TABLE pointe(
        id             Int NOT NULL ,
        id_commissaire Int NOT NULL ,
        id_regatte     Int NOT NULL ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: proprietaire
#------------------------------------------------------------

CREATE TABLE proprietaire(
        id          Int NOT NULL ,
        id_personne Int NOT NULL ,
        id_club     Int NOT NULL ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: regatte
#------------------------------------------------------------

CREATE TABLE regatte(
        id            Int NOT NULL ,
        nom           Varchar (256) NOT NULL ,
        lieu          Varchar (256) NOT NULL ,
        numero_course TinyINT NOT NULL ,
        distance      BigInt NOT NULL ,
        id_challenge  Int NOT NULL ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: serie
#------------------------------------------------------------

CREATE TABLE serie(
        id  Int NOT NULL ,
        nom Varchar (256) NOT NULL ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: skypper
#------------------------------------------------------------

CREATE TABLE skypper(
        id          Int NOT NULL ,
        id_personne Int NOT NULL ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: voilier
#------------------------------------------------------------

CREATE TABLE voilier(
        id              Int NOT NULL ,
        numero_voile    Smallint NOT NULL ,
        id_proprietaire Int NOT NULL ,
        id_classe       Int NOT NULL ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;

ALTER TABLE classe ADD CONSTRAINT FK_classe_id_serie FOREIGN KEY (id_serie) REFERENCES serie(id);
ALTER TABLE commissaire ADD CONSTRAINT FK_commissaire_id_personne FOREIGN KEY (id_personne) REFERENCES personne(id);
ALTER TABLE commissaire ADD CONSTRAINT FK_commissaire_id_comite FOREIGN KEY (id_comite) REFERENCES comite(id);
ALTER TABLE concurent ADD CONSTRAINT FK_concurent_id_personne FOREIGN KEY (id_personne) REFERENCES personne(id);
ALTER TABLE course ADD CONSTRAINT FK_course_id_regatte FOREIGN KEY (id_regatte) REFERENCES regatte(id);
ALTER TABLE course ADD CONSTRAINT FK_course_id_voilier FOREIGN KEY (id_voilier) REFERENCES voilier(id);
ALTER TABLE course ADD CONSTRAINT FK_course_id_equipage FOREIGN KEY (id_equipage) REFERENCES equipage(id);
ALTER TABLE course ADD CONSTRAINT FK_course_id_code FOREIGN KEY (id_code) REFERENCES code(id);
ALTER TABLE enregistrer ADD CONSTRAINT FK_enregistrer_id_jury FOREIGN KEY (id_jury) REFERENCES jury(id);
ALTER TABLE enregistrer ADD CONSTRAINT FK_enregistrer_id_regatte FOREIGN KEY (id_regatte) REFERENCES regatte(id);
ALTER TABLE equipage ADD CONSTRAINT FK_equipage_id_skypper FOREIGN KEY (id_skypper) REFERENCES skypper(id);
ALTER TABLE equipage ADD CONSTRAINT FK_equipage_id_concurent FOREIGN KEY (id_concurent) REFERENCES concurent(id);
ALTER TABLE jury ADD CONSTRAINT FK_jury_id_personne FOREIGN KEY (id_personne) REFERENCES personne(id);
ALTER TABLE membres ADD CONSTRAINT FK_membres_id_personne FOREIGN KEY (id_personne) REFERENCES personne(id);
ALTER TABLE personnel ADD CONSTRAINT FK_personnel_id_personne FOREIGN KEY (id_personne) REFERENCES personne(id);
ALTER TABLE pointe ADD CONSTRAINT FK_pointe_id_commissaire FOREIGN KEY (id_commissaire) REFERENCES commissaire(id);
ALTER TABLE pointe ADD CONSTRAINT FK_pointe_id_regatte FOREIGN KEY (id_regatte) REFERENCES regatte(id);
ALTER TABLE proprietaire ADD CONSTRAINT FK_proprietaire_id_personne FOREIGN KEY (id_personne) REFERENCES personne(id);
ALTER TABLE proprietaire ADD CONSTRAINT FK_proprietaire_id_club FOREIGN KEY (id_club) REFERENCES club(id);
ALTER TABLE regatte ADD CONSTRAINT FK_regatte_id_challenge FOREIGN KEY (id_challenge) REFERENCES challenge(id);
ALTER TABLE skypper ADD CONSTRAINT FK_skypper_id_personne FOREIGN KEY (id_personne) REFERENCES personne(id);
ALTER TABLE voilier ADD CONSTRAINT FK_voilier_id_proprietaire FOREIGN KEY (id_proprietaire) REFERENCES proprietaire(id);
ALTER TABLE voilier ADD CONSTRAINT FK_voilier_id_classe FOREIGN KEY (id_classe) REFERENCES classe(id);

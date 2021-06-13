/*DROP TABLE IF EXISTS servant;
DROP TABLE IF EXISTS master;
CREATE TABLE servant
(
    id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
    nombre VARCHAR (255) NOT NULL,
    clase VARCHAR (255) NOT NULL,
    noblePhantasm VARCHAR (255) NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB;
CREATE TABLE asociacion
(
    id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
    nombre VARCHAR (255) NOT NULL,
    pais VARCHAR (255) NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE master
(
    id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
    nombre VARCHAR (255) NOT NULL,
    localidad VARCHAR (255) NOT NULL,
    servant_id BIGINT(20) UNSIGNED NOT NULL,
    asociacion_id BIGINT(20) UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT `fk_master_servant`
        FOREIGN KEY (servant_id) REFERENCES servant (id)
            ON DELETE RESTRICT
            ON UPDATE RESTRICT,
    CONSTRAINT `fk_master_asociacion`
        FOREIGN KEY (asociacion_id) REFERENCES asociacion (id)
            ON DELETE RESTRICT
            ON UPDATE RESTRICT
) ENGINE = InnoDB;*/

INSERT INTO asociacion (id, nombre, pais) VALUES (6000, 'Magos','Alemania');
INSERT INTO asociacion (id, nombre, pais) VALUES (5000, 'Asesinos', 'Japon');

INSERT INTO servant (id, nombre, clase, noblePhantasm) VALUES (3000, 'Arturia', 'Saber', 'Excalibur');
INSERT INTO servant (id, nombre, clase, noblePhantasm) VALUES (4000, 'Gilgamesh', 'Archer', 'Ea');

INSERT INTO master (id, nombre, localidad, servant_id, asociacion_id) VALUES (1000, 'Kiritsugu', 'Fuyuki', 3000, 6000);
INSERT INTO master (id, nombre, localidad, servant_id, asociacion_id) VALUES (2000, 'Tohsaka', 'Fuyuki', 4000, 5000);

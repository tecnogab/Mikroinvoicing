-- -----------------------------------------------------
-- Table `t_clients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `t_clients` (
  `idClient` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `dni` VARCHAR(8) NULL,
  `name` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  `dateup` DATE NULL,
  PRIMARY KEY (`idClient`),
  UNIQUE INDEX `idClient_UNIQUE` (`idClient` ASC));

-- -----------------------------------------------------
-- Table `t_ips`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `t_ips` (
  `idIP` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `ip` VARCHAR(15) NULL,
  `idClient` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idIP`),
  UNIQUE INDEX `idIP_UNIQUE` (`idIP` ASC),
  UNIQUE INDEX `fk_ips_clients_idx` (`idClient` ASC),
  CONSTRAINT `fk_ips_clients`
    FOREIGN KEY (`idClient`)
    REFERENCES `t_clients` (`idClient`)
    ON DELETE RESTRICT
	ON UPDATE CASCADE);

-- -----------------------------------------------------
-- Table `t_contacts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `t_contacts` (
  `idContact` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(256) NULL,
  `telephone` VARCHAR(45) NULL,
  `neighborhood` VARCHAR(256) NULL,
  `idClient` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idContact`),
  UNIQUE INDEX `idContact_UNIQUE` (`idContact` ASC),
  UNIQUE INDEX `fk_contacts_clients_idx` (`idClient` ASC),
  CONSTRAINT `fk_contacts_clients`
    FOREIGN KEY (`idClient`)
    REFERENCES `t_clients` (`idClient`)
    ON DELETE RESTRICT
	ON UPDATE CASCADE);
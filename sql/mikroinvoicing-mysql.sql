-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema segui263_mkinvoicing
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema segui263_mkinvoicing
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `segui263_mkinvoicing` DEFAULT CHARACTER SET utf8 ;
USE `segui263_mkinvoicing` ;

-- -----------------------------------------------------
-- Table `segui263_mkinvoicing`.`t_clients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `segui263_mkinvoicing`.`t_clients` (
  `id_client` INT NOT NULL AUTO_INCREMENT,
  `dni_cli` VARCHAR(8) NULL,
  `nombre_cli` VARCHAR(45) NULL,
  `apellido_cli` VARCHAR(45) NULL,
  `fecha_up_cli` DATETIME NULL,
  PRIMARY KEY (`id_client`),
  UNIQUE INDEX `id_client_UNIQUE` (`id_client` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `segui263_mkinvoicing`.`t_ips`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `segui263_mkinvoicing`.`t_ips` (
  `id_ip` INT NOT NULL AUTO_INCREMENT,
  `ipv4` INT UNSIGNED NULL,
  `ipv6` BINARY(16) NULL,
  `id_client` INT NOT NULL,
  PRIMARY KEY (`id_ip`),
  UNIQUE INDEX `id_ip_UNIQUE` (`id_ip` ASC),
  INDEX `fk_t_ips_t_clients_idx` (`id_client` ASC),
  CONSTRAINT `fk_t_ips_t_clients`
    FOREIGN KEY (`id_client`)
    REFERENCES `segui263_mkinvoicing`.`t_clients` (`id_client`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

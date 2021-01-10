-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bd_lorem
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bd_lorem
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bd_lorem` ;
USE `bd_lorem` ;

-- -----------------------------------------------------
-- Table `bd_lorem`.`risco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_lorem`.`risco` (
  `riscodigo` INT NOT NULL AUTO_INCREMENT,
  `risdescricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`riscodigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_lorem`.`projeto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_lorem`.`projeto` (
  `procodigo` INT NOT NULL AUTO_INCREMENT,
  `pronome` VARCHAR(100) NOT NULL,
  `prodtinicio` VARCHAR(10) NOT NULL,
  `prodttermino` VARCHAR(10) NOT NULL,
  `prostatus` VARCHAR(10) NULL,
  `proriscodigo` INT NOT NULL,
  PRIMARY KEY (`procodigo`, `proriscodigo`),
  INDEX `fk_projeto_risco_idx` (`proriscodigo` ASC),
  CONSTRAINT `fk_projeto_risco`
    FOREIGN KEY (`proriscodigo`)
    REFERENCES `bd_lorem`.`risco` (`riscodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_lorem`.`participante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_lorem`.`participante` (
  `parcodigo` INT NOT NULL AUTO_INCREMENT,
  `parnome` VARCHAR(100) NOT NULL,
  `parfuncao` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`parcodigo`))
ENGINE = InnoDB
COMMENT = 'desenvolvedor, designer, lider de projeto, \n';


-- -----------------------------------------------------
-- Table `bd_lorem`.`pprojeto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_lorem`.`pprojeto` (
  `ppr_parcodigo` INT NOT NULL,
  `ppr_procodigo` INT NOT NULL,
  PRIMARY KEY (`ppr_parcodigo`, `ppr_procodigo`),
  INDEX `fk_participante_has_projeto_projeto1_idx` (`ppr_procodigo` ASC),
  INDEX `fk_participante_has_projeto_participante1_idx` (`ppr_parcodigo` ASC),
  CONSTRAINT `fk_participante_has_projeto_participante1`
    FOREIGN KEY (`ppr_parcodigo`)
    REFERENCES `bd_lorem`.`participante` (`parcodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_participante_has_projeto_projeto1`
    FOREIGN KEY (`ppr_procodigo`)
    REFERENCES `bd_lorem`.`projeto` (`procodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema test
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema test
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `test` DEFAULT CHARACTER SET latin1 ;
USE `test` ;

-- -----------------------------------------------------
-- Table `test`.`author`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`author` (
  `idAuthor` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `Name` VARCHAR(100) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`idAuthor`)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `test`.`book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`book` (
  `idBook` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `Name` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `ISBN` INT(11) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`idBook`)  COMMENT '',
  UNIQUE INDEX `ISBN_UNIQUE` (`ISBN` ASC)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 39
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `test`.`book_author`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`book_author` (
  `idBook` INT(11) NOT NULL COMMENT '',
  `idAuthor` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`idBook`, `idAuthor`)  COMMENT '',
  INDEX `fk_Book_has_Author_Author1_idx` (`idAuthor` ASC)  COMMENT '',
  INDEX `fk_Book_has_Author_Book1_idx` (`idBook` ASC)  COMMENT '',
  CONSTRAINT `idAuthor_FK_author`
    FOREIGN KEY (`idAuthor`)
    REFERENCES `test`.`author` (`idAuthor`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `idBook_FK_book`
    FOREIGN KEY (`idBook`)
    REFERENCES `test`.`book` (`idBook`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `test`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`category` (
  `idCategory` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `Name` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`idCategory`)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `test`.`book_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`book_category` (
  `idBook` INT(11) NOT NULL COMMENT '',
  `idCategory` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`idBook`, `idCategory`)  COMMENT '',
  INDEX `fk_Book_has_Category_Category1_idx` (`idCategory` ASC)  COMMENT '',
  INDEX `fk_Book_has_Category_Book_idx` (`idBook` ASC)  COMMENT '',
  CONSTRAINT `idBook_FK`
    FOREIGN KEY (`idBook`)
    REFERENCES `test`.`book` (`idBook`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `idCategory_FK`
    FOREIGN KEY (`idCategory`)
    REFERENCES `test`.`category` (`idCategory`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

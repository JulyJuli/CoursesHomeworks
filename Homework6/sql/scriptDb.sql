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
AUTO_INCREMENT = 10
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
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `test`.`book_has_author`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`book_has_author` (
  `Book_idBook` INT(11) NOT NULL COMMENT '',
  `Author_idAuthor` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`Book_idBook`, `Author_idAuthor`)  COMMENT '',
  INDEX `fk_Book_has_Author_Author1_idx` (`Author_idAuthor` ASC)  COMMENT '',
  INDEX `fk_Book_has_Author_Book1_idx` (`Book_idBook` ASC)  COMMENT '',
  CONSTRAINT `idAuthor_FK_author`
    FOREIGN KEY (`Author_idAuthor`)
    REFERENCES `test`.`author` (`idAuthor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idBook_FK_book`
    FOREIGN KEY (`Book_idBook`)
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
-- Table `test`.`book_has_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`book_has_category` (
  `Book_idBook` INT(11) NOT NULL COMMENT '',
  `Category_idCategory` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`Book_idBook`, `Category_idCategory`)  COMMENT '',
  INDEX `fk_Book_has_Category_Category1_idx` (`Category_idCategory` ASC)  COMMENT '',
  INDEX `fk_Book_has_Category_Book_idx` (`Book_idBook` ASC)  COMMENT '',
  CONSTRAINT `idBook_FK`
    FOREIGN KEY (`Book_idBook`)
    REFERENCES `test`.`book` (`idBook`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `idCategory_FK`
    FOREIGN KEY (`Category_idCategory`)
    REFERENCES `test`.`category` (`idCategory`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

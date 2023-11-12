-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema memory_game
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema memory_game
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `memory_game` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
USE `memory_game` ;

-- -----------------------------------------------------
-- Table `memory_game`.`gamescores`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `memory_game`.`gamescores` ;

CREATE TABLE IF NOT EXISTS `memory_game`.`gamescores` (
  `score` INT(11) NOT NULL,
  `gamer_id` BIGINT(20) NULL DEFAULT NULL,
  `id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `memory_game`.`cell_images`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `memory_game`.`cell_images` ;

CREATE TABLE IF NOT EXISTS `memory_game`.`cell_images` (
  `gamescore_id` BIGINT(20) NOT NULL,
  `cell_image` VARCHAR(255) NOT NULL,
  INDEX `FK3mw60dexsp06hxjmr8ojpwl4t` (`gamescore_id` ASC) VISIBLE,
  CONSTRAINT `FK3mw60dexsp06hxjmr8ojpwl4t`
    FOREIGN KEY (`gamescore_id`)
    REFERENCES `memory_game`.`gamescores` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `memory_game`.`gamers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `memory_game`.`gamers` ;

CREATE TABLE IF NOT EXISTS `memory_game`.`gamers` (
  `id` BIGINT(20) NOT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `memory_game`.`gamers_seq`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `memory_game`.`gamers_seq` ;

CREATE TABLE IF NOT EXISTS `memory_game`.`gamers_seq` (
  `next_val` BIGINT(20) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `memory_game`.`gamescores_seq`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `memory_game`.`gamescores_seq` ;

CREATE TABLE IF NOT EXISTS `memory_game`.`gamescores_seq` (
  `next_val` BIGINT(20) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


CREATE USER 'dbuser'@'localhost' IDENTIFIED BY 'Wert@345Sdfg';
GRANT ALL PRIVILEGES ON memory_game.* TO 'dbuser'@'localhost';

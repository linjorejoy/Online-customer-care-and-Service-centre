-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema customer_care
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema customer_care
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `customer_care` DEFAULT CHARACTER SET utf8 ;
USE `customer_care` ;

-- -----------------------------------------------------
-- Table `customer_care`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `customer_care`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(15) NULL,
  `email_id` VARCHAR(45) NOT NULL,
  `date_of_birth` DATETIME NOT NULL,
  `gender` VARCHAR(10) NOT NULL,
  `password` VARCHAR(256) NOT NULL,
  `temp_password` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `customer_care`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `customer_care`.`admin` (
  `admin_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email_id` VARCHAR(45) NOT NULL,
  `password` VARCHAR(256) NOT NULL,
  `temp_password` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`admin_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `customer_care`.`analyst`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `customer_care`.`analyst` (
  `analyst_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(15) NOT NULL,
  `email_id` VARCHAR(45) NOT NULL,
  `date_of_birth` DATETIME NOT NULL,
  `gender` VARCHAR(45) NOT NULL,
  `support_level` VARCHAR(2) NOT NULL,
  `password` VARCHAR(256) NOT NULL,
  `temp_password` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`analyst_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `customer_care`.`complaint`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `customer_care`.`complaint` (
  `complaint_id` INT NOT NULL AUTO_INCREMENT,
  `complaint_user_id` INT NOT NULL DEFAULT 1000,
  `assigned_analyst_id` INT NOT NULL DEFAULT 1000,
  `category` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(15) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `date_of_complaint` DATETIME NOT NULL,
  `description` VARCHAR(1024) NOT NULL,
  `suggestions` VARCHAR(1024) NULL,
  PRIMARY KEY (`complaint_id`),
  INDEX `fk_complaint_user_idx` (`complaint_user_id` ASC) VISIBLE,
  INDEX `fk_complaint_analyst1_idx` (`assigned_analyst_id` ASC) VISIBLE,
  CONSTRAINT `fk_complaint_user`
    FOREIGN KEY (`complaint_user_id`)
    REFERENCES `customer_care`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_complaint_analyst1`
    FOREIGN KEY (`assigned_analyst_id`)
    REFERENCES `customer_care`.`analyst` (`analyst_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `customer_care`.`feedback_question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `customer_care`.`feedback_question` (
  `question_id` INT NOT NULL AUTO_INCREMENT,
  `question_description` VARCHAR(1024) NOT NULL,
  PRIMARY KEY (`question_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `customer_care`.`feedback`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `customer_care`.`feedback` (
  `feedback_id` INT NOT NULL AUTO_INCREMENT,
  `complaint_id` INT NOT NULL,
  `question_id` INT NOT NULL,
  `answer` VARCHAR(1024) NULL,
  PRIMARY KEY (`feedback_id`),
  INDEX `fk_responses_complaint1_idx` (`complaint_id` ASC) VISIBLE,
  INDEX `fk_responses_feedback_question_table1_idx` (`question_id` ASC) VISIBLE,
  CONSTRAINT `fk_responses_complaint1`
    FOREIGN KEY (`complaint_id`)
    REFERENCES `customer_care`.`complaint` (`complaint_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_responses_feedback_question_table1`
    FOREIGN KEY (`question_id`)
    REFERENCES `customer_care`.`feedback_question` (`question_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `customer_care`.`secret_questions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `customer_care`.`secret_questions` (
  `question_id` INT NOT NULL AUTO_INCREMENT,
  `question_description` VARCHAR(1024) NOT NULL,
  PRIMARY KEY (`question_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `customer_care`.`u_sq_questions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `customer_care`.`u_sq_questions` (
  `u_sq_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `question_id` INT NOT NULL,
  `answer` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`u_sq_id`),
  INDEX `fk_u_sq_questions_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_u_sq_questions_secret_questions1_idx` (`question_id` ASC) VISIBLE,
  CONSTRAINT `fk_u_sq_questions_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `customer_care`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_u_sq_questions_secret_questions1`
    FOREIGN KEY (`question_id`)
    REFERENCES `customer_care`.`secret_questions` (`question_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `customer_care`.`email_analyst`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `customer_care`.`email_analyst` (
  `email_id` INT NOT NULL AUTO_INCREMENT,
  `admin_id` INT NOT NULL,
  `analyst_id` INT NOT NULL,
  `sent_date` DATETIME NOT NULL,
  `received` TINYINT NOT NULL,
  `description` VARCHAR(1024) NOT NULL,
  PRIMARY KEY (`email_id`),
  INDEX `fk_email_analyst_admin1_idx` (`admin_id` ASC) VISIBLE,
  INDEX `fk_email_analyst_analyst1_idx` (`analyst_id` ASC) VISIBLE,
  CONSTRAINT `fk_email_analyst_admin1`
    FOREIGN KEY (`admin_id`)
    REFERENCES `customer_care`.`admin` (`admin_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_email_analyst_analyst1`
    FOREIGN KEY (`analyst_id`)
    REFERENCES `customer_care`.`analyst` (`analyst_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `customer_care`.`email_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `customer_care`.`email_user` (
  `email_id` INT NOT NULL AUTO_INCREMENT,
  `admin_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `sent_date` DATETIME NOT NULL,
  `received` TINYINT NOT NULL,
  `description` VARCHAR(1024) NOT NULL,
  PRIMARY KEY (`email_id`),
  INDEX `fk_email_user_admin1_idx` (`admin_id` ASC) VISIBLE,
  INDEX `fk_email_user_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_email_user_admin1`
    FOREIGN KEY (`admin_id`)
    REFERENCES `customer_care`.`admin` (`admin_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_email_user_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `customer_care`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
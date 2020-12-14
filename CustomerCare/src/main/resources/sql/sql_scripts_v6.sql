-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema customer_care_5
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema customer_care_5
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `customer_care_5` DEFAULT CHARACTER SET utf8 ;
USE `customer_care_5` ;

-- -----------------------------------------------------
-- Table `customer_care_5`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `customer_care_5`.`user` (
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
-- Table `customer_care_5`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `customer_care_5`.`admin` (
  `admin_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email_id` VARCHAR(45) NOT NULL,
  `password` VARCHAR(256) NOT NULL,
  `temp_password` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`admin_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `customer_care_5`.`analyst`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `customer_care_5`.`analyst` (
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
-- Table `customer_care_5`.`complaint`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `customer_care_5`.`complaint` (
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
    REFERENCES `customer_care_5`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_complaint_analyst1`
    FOREIGN KEY (`assigned_analyst_id`)
    REFERENCES `customer_care_5`.`analyst` (`analyst_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `customer_care_5`.`secret_questions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `customer_care_5`.`secret_questions` (
  `question_id` INT NOT NULL AUTO_INCREMENT,
  `question_description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`question_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `customer_care_5`.`u_sq_questions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `customer_care_5`.`u_sq_questions` (
  `u_sq_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `question_id` INT NOT NULL,
  `answer` VARCHAR(1024) NULL,
  PRIMARY KEY (`u_sq_id`),
  INDEX `fk_u_sq_questions_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_u_sq_questions_secret_questions1_idx` (`question_id` ASC) VISIBLE,
  CONSTRAINT `fk_u_sq_questions_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `customer_care_5`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_u_sq_questions_secret_questions1`
    FOREIGN KEY (`question_id`)
    REFERENCES `customer_care_5`.`secret_questions` (`question_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `customer_care_5`.`email_analyst`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `customer_care_5`.`email_analyst` (
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
    REFERENCES `customer_care_5`.`admin` (`admin_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_email_analyst_analyst1`
    FOREIGN KEY (`analyst_id`)
    REFERENCES `customer_care_5`.`analyst` (`analyst_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `customer_care_5`.`email_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `customer_care_5`.`email_user` (
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
    REFERENCES `customer_care_5`.`admin` (`admin_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_email_user_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `customer_care_5`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `customer_care_5`.`feedback_response`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `customer_care_5`.`feedback_response` (
  `feedback_response_id` INT NOT NULL AUTO_INCREMENT,
  `complaint_complaint_id` INT NOT NULL,
  `question` VARCHAR(1024) NULL,
  `answer` VARCHAR(1024) NULL,
  PRIMARY KEY (`feedback_response_id`),
  INDEX `fk_feedback_response_complaint1_idx` (`complaint_complaint_id` ASC) VISIBLE,
  CONSTRAINT `fk_feedback_response_complaint1`
    FOREIGN KEY (`complaint_complaint_id`)
    REFERENCES `customer_care_5`.`complaint` (`complaint_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `customer_care_5`.`login_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `customer_care_5`.`login_details` (
  `login_details_id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `roles` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`login_details_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `customer_care_5`.`a_sq_questions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `customer_care_5`.`a_sq_questions` (
  `a_sq_id` INT NOT NULL AUTO_INCREMENT,
  `analyst_id` INT NOT NULL,
  `question_id` INT NOT NULL,
  `answer` VARCHAR(1024) NULL,
  PRIMARY KEY (`a_sq_id`),
  INDEX `fk_a_sq_questions_analyst1_idx` (`analyst_id` ASC) VISIBLE,
  INDEX `fk_a_sq_questions_secret_questions1_idx` (`question_id` ASC) VISIBLE,
  CONSTRAINT `fk_a_sq_questions_analyst1`
    FOREIGN KEY (`analyst_id`)
    REFERENCES `customer_care_5`.`analyst` (`analyst_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_a_sq_questions_secret_questions1`
    FOREIGN KEY (`question_id`)
    REFERENCES `customer_care_5`.`secret_questions` (`question_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

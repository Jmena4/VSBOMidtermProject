-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema tutadvisordb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `tutadvisordb` ;

-- -----------------------------------------------------
-- Schema tutadvisordb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tutadvisordb` DEFAULT CHARACTER SET utf8 ;
USE `tutadvisordb` ;

-- -----------------------------------------------------
-- Table `address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `address` ;

CREATE TABLE IF NOT EXISTS `address` (
  `address_id` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(250) NULL,
  `street2` VARCHAR(250) NULL,
  `city` VARCHAR(100) NULL,
  `state` VARCHAR(50) NULL,
  `zip` VARCHAR(10) NULL,
  PRIMARY KEY (`address_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(100) NULL,
  `phone` VARCHAR(10) NULL,
  `address_id` INT(10) NULL,
  `picture_url` VARCHAR(1000) NULL,
  `user_name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `is_admin` TINYINT NOT NULL DEFAULT 0,
  `is_active` TINYINT NOT NULL,
  PRIMARY KEY (`user_id`),
  INDEX `address_id_idx` (`address_id` ASC),
  CONSTRAINT `fk_user_address_id`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`address_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skill_name`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `skill_name` ;

CREATE TABLE IF NOT EXISTS `skill_name` (
  `skill_name_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`skill_name_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skill_level`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `skill_level` ;

CREATE TABLE IF NOT EXISTS `skill_level` (
  `skill_level_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`skill_level_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `learnable_skill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `learnable_skill` ;

CREATE TABLE IF NOT EXISTS `learnable_skill` (
  `learnable_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `skill_name_id` INT NOT NULL,
  `skill_level_id` INT NOT NULL,
  `comment` VARCHAR(250) NULL,
  `is_active` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`learnable_id`),
  INDEX `user_id_idx` (`user_id` ASC),
  INDEX `skill_name_id_idx` (`skill_name_id` ASC),
  INDEX `skill_level_id_idx` (`skill_level_id` ASC),
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk _ls_skill_name_id`
    FOREIGN KEY (`skill_name_id`)
    REFERENCES `skill_name` (`skill_name_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ls_skill_level_id`
    FOREIGN KEY (`skill_level_id`)
    REFERENCES `skill_level` (`skill_level_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `teachable_skill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachable_skill` ;

CREATE TABLE IF NOT EXISTS `teachable_skill` (
  `teachable_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `skill_name_id` INT NOT NULL,
  `skill_level_id` INT NOT NULL,
  `comment` VARCHAR(250) NULL,
  `is_active` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`teachable_id`),
  INDEX `user_id_idx` (`user_id` ASC),
  INDEX `skill_name_id_idx` (`skill_name_id` ASC),
  INDEX `skill_level_id_idx` (`skill_level_id` ASC),
  CONSTRAINT `fk_ts_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ts_user_skill_name_id`
    FOREIGN KEY (`skill_name_id`)
    REFERENCES `skill_name` (`skill_name_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ts_skill_level_id`
    FOREIGN KEY (`skill_level_id`)
    REFERENCES `skill_level` (`skill_level_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proposal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proposal` ;

CREATE TABLE IF NOT EXISTS `proposal` (
  `proposal_id` INT NOT NULL AUTO_INCREMENT,
  `teacher_id` INT NOT NULL,
  `student_id` INT NULL,
  `learnable_id` INT NOT NULL,
  `teachable_id` INT NOT NULL,
  `date_time_created` DATETIME NULL,
  INDEX `learnable_id_idx` (`learnable_id` ASC),
  INDEX `teachable_id_idx` (`teachable_id` ASC),
  INDEX `student_id_idx` (`student_id` ASC),
  INDEX `teacher_id_idx` (`teacher_id` ASC),
  PRIMARY KEY (`proposal_id`),
  CONSTRAINT `fk_prop_learnable_id`
    FOREIGN KEY (`learnable_id`)
    REFERENCES `learnable_skill` (`learnable_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_prop_teachable_id`
    FOREIGN KEY (`teachable_id`)
    REFERENCES `teachable_skill` (`teachable_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_prop_student_id`
    FOREIGN KEY (`student_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_prop_teacher_id`
    FOREIGN KEY (`teacher_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proposal_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proposal_status` ;

CREATE TABLE IF NOT EXISTS `proposal_status` (
  `proposal_status_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`proposal_status_id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS tutuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'tutuser'@'localhost' IDENTIFIED BY 'tutword';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'tutuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `address`
-- -----------------------------------------------------
START TRANSACTION;
USE `tutadvisordb`;
INSERT INTO `address` (`address_id`, `street`, `street2`, `city`, `state`, `zip`) VALUES (1, '111 Test St', NULL, 'Starbase 11', 'ID', '89654');
INSERT INTO `address` (`address_id`, `street`, `street2`, `city`, `state`, `zip`) VALUES (2, '222 Test St', NULL, 'Starbase 11', 'ID', '89654');
INSERT INTO `address` (`address_id`, `street`, `street2`, `city`, `state`, `zip`) VALUES (3, '333 Test St', NULL, 'Starbase 11', 'ID', '89654');
INSERT INTO `address` (`address_id`, `street`, `street2`, `city`, `state`, `zip`) VALUES (4, 'Starbucks', '444 Test St', 'Walla-Walla', 'WA', '56987');
INSERT INTO `address` (`address_id`, `street`, `street2`, `city`, `state`, `zip`) VALUES (5, 'Twin Peaks', '8840 E. Arapahoe Rd', 'Centennial', 'CO', '80112');
INSERT INTO `address` (`address_id`, `street`, `street2`, `city`, `state`, `zip`) VALUES (6, 'Waterway Car Wash', '5290 DTC Blvd', 'Greenwood Village', 'CO', '80111');

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `tutadvisordb`;
INSERT INTO `user` (`user_id`, `first_name`, `last_name`, `email`, `phone`, `address_id`, `picture_url`, `user_name`, `password`, `is_admin`, `is_active`) VALUES (1, 'James', 'Kirk', 'james.t.kirk@ufop.net', '3347659876', 1, 'https://www.writeups.org/wp-content/uploads/James-Tiberius-Kirk-Star-Trek-William-Shatner.jpg', 'Jimmy', 'enterprise', 1, 1);
INSERT INTO `user` (`user_id`, `first_name`, `last_name`, `email`, `phone`, `address_id`, `picture_url`, `user_name`, `password`, `is_admin`, `is_active`) VALUES (2, 'Mr', 'Spock', 'spocker@ufop.net', '8764327890', 2, 'https://cdn1.thr.com/sites/default/files/imagecache/scale_crop_768_433/2018/02/star_trek_tv_spock_3_copy_-_h_2018.jpg', 'Spocker_The_Rocker', 'logical', 0, 1);
INSERT INTO `user` (`user_id`, `first_name`, `last_name`, `email`, `phone`, `address_id`, `picture_url`, `user_name`, `password`, `is_admin`, `is_active`) VALUES (3, 'Montgomery', 'Scott', 'scotty@ufop.net', '5676543456', 3, 'https://vignette.wikia.nocookie.net/liberapedia/images/2/23/20151030_062827.jpg/revision/latest?cb=20151030132845', 'Scotty', 'warpdrive', 0, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `skill_name`
-- -----------------------------------------------------
START TRANSACTION;
USE `tutadvisordb`;
INSERT INTO `skill_name` (`skill_name_id`, `name`) VALUES (1, 'Tribble Husbandry');
INSERT INTO `skill_name` (`skill_name_id`, `name`) VALUES (2, 'Expressing Feelings');
INSERT INTO `skill_name` (`skill_name_id`, `name`) VALUES (3, 'Fun With Phasers');

COMMIT;


-- -----------------------------------------------------
-- Data for table `skill_level`
-- -----------------------------------------------------
START TRANSACTION;
USE `tutadvisordb`;
INSERT INTO `skill_level` (`skill_level_id`, `name`) VALUES (1, 'No Experience');
INSERT INTO `skill_level` (`skill_level_id`, `name`) VALUES (2, 'Novice');
INSERT INTO `skill_level` (`skill_level_id`, `name`) VALUES (3, 'Intermediate');
INSERT INTO `skill_level` (`skill_level_id`, `name`) VALUES (4, 'Expert');
INSERT INTO `skill_level` (`skill_level_id`, `name`) VALUES (5, 'Master');

COMMIT;


-- -----------------------------------------------------
-- Data for table `learnable_skill`
-- -----------------------------------------------------
START TRANSACTION;
USE `tutadvisordb`;
INSERT INTO `learnable_skill` (`learnable_id`, `user_id`, `skill_name_id`, `skill_level_id`, `comment`, `is_active`) VALUES (1, 1, 3, 1, 'This will be more fun than licking cold door knobs!', DEFAULT);
INSERT INTO `learnable_skill` (`learnable_id`, `user_id`, `skill_name_id`, `skill_level_id`, `comment`, `is_active`) VALUES (2, 2, 1, 1, 'Can I feed them after midnight?', DEFAULT);
INSERT INTO `learnable_skill` (`learnable_id`, `user_id`, `skill_name_id`, `skill_level_id`, `comment`, `is_active`) VALUES (3, 3, 2, 1, 'I cried during Jerry McGuire', DEFAULT);

COMMIT;


-- -----------------------------------------------------
-- Data for table `teachable_skill`
-- -----------------------------------------------------
START TRANSACTION;
USE `tutadvisordb`;
INSERT INTO `teachable_skill` (`teachable_id`, `user_id`, `skill_name_id`, `skill_level_id`, `comment`, `is_active`) VALUES (1, 1, 1, 1, 'I grow my own', DEFAULT);
INSERT INTO `teachable_skill` (`teachable_id`, `user_id`, `skill_name_id`, `skill_level_id`, `comment`, `is_active`) VALUES (2, 2, 2, 2, 'So... illogical', DEFAULT);
INSERT INTO `teachable_skill` (`teachable_id`, `user_id`, `skill_name_id`, `skill_level_id`, `comment`, `is_active`) VALUES (3, 3, 3, 3, 'PhD from StarFleet Academy', DEFAULT);
INSERT INTO `teachable_skill` (`teachable_id`, `user_id`, `skill_name_id`, `skill_level_id`, `comment`, `is_active`) VALUES (4, 2, 3, 4, 'test?', DEFAULT);

COMMIT;


-- -----------------------------------------------------
-- Data for table `proposal`
-- -----------------------------------------------------
START TRANSACTION;
USE `tutadvisordb`;
INSERT INTO `proposal` (`proposal_id`, `teacher_id`, `student_id`, `learnable_id`, `teachable_id`, `date_time_created`) VALUES (1, 3, 1, 3, 3, '2019-03-15 23:08:00');
INSERT INTO `proposal` (`proposal_id`, `teacher_id`, `student_id`, `learnable_id`, `teachable_id`, `date_time_created`) VALUES (2, 2, 3, 2, 2, '2019-03-10 01:02:00');
INSERT INTO `proposal` (`proposal_id`, `teacher_id`, `student_id`, `learnable_id`, `teachable_id`, `date_time_created`) VALUES (3, 1, 2, 1, 1, '2019-03-13 15:15:00');

COMMIT;


-- -----------------------------------------------------
-- Data for table `proposal_status`
-- -----------------------------------------------------
START TRANSACTION;
USE `tutadvisordb`;
INSERT INTO `proposal_status` (`proposal_status_id`, `name`) VALUES (1, 'PENDING');
INSERT INTO `proposal_status` (`proposal_status_id`, `name`) VALUES (2, 'ACCEPTED');
INSERT INTO `proposal_status` (`proposal_status_id`, `name`) VALUES (3, 'DECLINED');
INSERT INTO `proposal_status` (`proposal_status_id`, `name`) VALUES (4, 'CANCELLED BY ADMIN');

COMMIT;


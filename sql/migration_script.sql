-- ----------------------------------------------------------------------------
-- MySQL Workbench Migration
-- Migrated Schemata: finsimulator
-- Source Schemata: finsimulator
-- Created: Mon Oct  9 09:13:39 2017
-- Workbench Version: 6.3.9
-- ----------------------------------------------------------------------------

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------------------------------------------------------
-- Schema finsimulator
-- ----------------------------------------------------------------------------
DROP SCHEMA IF EXISTS `finsimulator` ;
CREATE SCHEMA IF NOT EXISTS `finsimulator` ;

-- ----------------------------------------------------------------------------
-- Table finsimulator.accounts
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `finsimulator`.`accounts` (
  `account_Id` INT(11) NOT NULL,
  `name` VARCHAR(100) NULL DEFAULT NULL,
  `balance` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`account_Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
SET FOREIGN_KEY_CHECKS = 1;

D
ROP DATABASE IF EXISTS `library`;
CREATE DATABASE `library`; 
USE `library`;

SET NAMES utf8 ;
SET character_set_client = utf8mb4 ;

-- Accounts{account_id, person_id, username, hashed_password, priviledge_level, IsBlocked, Recovery Question, Recovery Answer}
CREATE TABLE `account`(
	`account_id` INT NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(32) UNIQUE,
	`full_name` VARCHAR(100) NOT NULL,
	`email` VARCHAR(60) NOT NULL,
	`phone_number` VARCHAR(15),
	`priviledge` ENUM("USER", "STAFF", "ADMIN") NOT NULL,
	`hashed_password` VARCHAR(514) NOT NULL, -- will use SHA512(2)
	`account_status` ENUM("ACTIVE", "CLOSED", "BLOCKED") DEFAULT "ACTIVE",
	`recovery_question` TEXT,
	`recovery_answer` VARCHAR(100),
	PRIMARY KEY(`account_id`)
)AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- BookCatergory{catergory_id, name}
CREATE TABLE IF NOT EXISTS `book_category`(
	`category_id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(32) NOT NULL,
	PRIMARY KEY(`category_id`)
);

-- Books{book_id, ISBN, book_category title, author, publisher, short_description, quantity, rack_number,}
CREATE TABLE `book`(
	`book_id` INT NOT NULL AUTO_INCREMENT,
	`ISBN` VARCHAR(32),
	`category_id` INT NOT NULL,
	`title` VARCHAR(100),
	`cover_image` BLOB,
	`author` VARCHAR(100) NOT NULL,
	`publisher` VARCHAR(100),
	`short_description` TEXT,
	`quantity` INT,
	`rack_number` INT,
	PRIMARY KEY(`book_id`),
	FOREIGN KEY (`category_id`) REFERENCES `book_category` (`category_id`)
);

-- BookIssues{issue_id, book_id, account_id, status, issue_date, issue_duration, due_date, overdue_fine, loan_status}
CREATE TABLE `book_issue`(
	`issue_id` INT NOT NULL AUTO_INCREMENT,
	`book_id` INT NOT NULL,
	`account_id` INT NOT NULL,
	`issue_status` ENUM("ACTIVE", "RETURNED", "OVERDUE"),
	`issue_date` DATE,
	`due_date` DATE,
	PRIMARY KEY(`issue_id`),
	FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`),
	FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`)
);

-- Notifications{notice_id, notice_title_, notice-text, notice_time}

CREATE TABLE `notification`(
	`notice_id` INT NOT NULL AUTO_INCREMENT,
	`account_id` INT NULL,
	`notice_title` VARCHAR(60),
	`notice_text`  TEXT,
	`notice_time` DATETIME,
	PRIMARY KEY(`notice_id`),
	FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`)
);

-- log{ date, type, user, text}

CREATE TABLE `log`(
	`log_id` INT NOT NULL AUTO_INCREMENT,
	`account_id` INT NULL,
	`log_time` DATETIME,
	`log_text`  TEXT,
	`log_type` ENUM("ERROR", "ACTIVITY"),
	PRIMARY KEY(`log_id`),
	FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`)
);
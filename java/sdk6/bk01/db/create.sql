DROP TABLE IF EXISTS `cat`;
CREATE TABLE `cat` (
  `name` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL
);

CREATE TABLE `report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `clsd` varchar(45) DEFAULT NULL,

  PRIMARY KEY (`id`)
);

CREATE TABLE `news_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `news_title` varchar(15) NOT NULL,
  `content` varchar(4) DEFAULT NULL,
  `happen_season` int(11) DEFAULT NULL,

  PRIMARY KEY (`id`)
);

CREATE TABLE `person_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,

  PRIMARY KEY (`id`)
);

CREATE TABLE `person2_tbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,

  PRIMARY KEY (`id`)
);

CREATE TABLE `person2_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,

  PRIMARY KEY (`id`)
);

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,

  PRIMARY KEY (`id`)
);


CREATE TABLE `country` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `country_name` varchar(50) DEFAULT NULL,
  `language` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `location` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `latitude` decimal(19,2) DEFAULT NULL,
  `location_name` varchar(50) DEFAULT NULL,
  `longitude` decimal(19,2) DEFAULT NULL,
  `country_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `country_id_fk` (`country_id`),
  CONSTRAINT `country_id_fk` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `user_group` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `location_id` int(10) NOT NULL,
  `user_group_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `location_id_fk` (`location_id`),
  KEY `user_group_id_fk` (`user_group_id`),
  CONSTRAINT `location_id_fk` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`),
  CONSTRAINT `user_group_id_fk` FOREIGN KEY (`user_group_id`) REFERENCES `user_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `sessions` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `date_closed` datetime DEFAULT NULL,
  `date_opened` datetime DEFAULT NULL,
  `user_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id_fk` (`user_id`),
  CONSTRAINT `user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `request` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `method` varchar(10) DEFAULT NULL,
  `params` tinytext,
  `url` varchar(100) DEFAULT NULL,
  `session_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `session_id_fk` (`session_id`),
  CONSTRAINT `session_id_fk` FOREIGN KEY (`session_id`) REFERENCES `sessions` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
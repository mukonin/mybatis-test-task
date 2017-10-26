CREATE TABLE `country` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `country_name` varchar(50) DEFAULT NULL,
  `language` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE `location` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `latitude` decimal(19,2) DEFAULT NULL,
  `location_name` varchar(50) DEFAULT NULL,
  `longitude` decimal(19,2) DEFAULT NULL,
  `country_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE `user_group` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE `users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `location_id` int(10) NOT NULL,
  `user_group_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`location_id`) REFERENCES `location` (`id`),
  FOREIGN KEY (`user_group_id`) REFERENCES `user_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE `sessions` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `date_closed` datetime DEFAULT NULL,
  `date_opened` datetime DEFAULT NULL,
  `user_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE `request` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `method` varchar(10) DEFAULT NULL,
  `params` tinytext,
  `url` varchar(100) DEFAULT NULL,
  `session_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`session_id`) REFERENCES `sessions` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
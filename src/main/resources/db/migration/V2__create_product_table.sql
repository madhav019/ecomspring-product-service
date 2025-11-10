CREATE TABLE
  `product` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `created_at` datetime(6) NOT NULL,
    `updated_at` datetime(6) NOT NULL,
    `brand` varchar(255) DEFAULT NULL,
    `color` varchar(255) DEFAULT NULL,
    `description` varchar(255) DEFAULT NULL,
    `discount` bigint DEFAULT NULL,
    `image` varchar(255) DEFAULT NULL,
    `model` varchar(255) DEFAULT NULL,
    `popular` bit(1) NOT NULL,
    `price` bigint DEFAULT NULL,
    `title` varchar(255) DEFAULT NULL,
    `category_id` bigint NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`),
    CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
  )
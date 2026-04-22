/*
-- Query: select * from product
LIMIT 0, 1000

-- Date: 2026-04-22 10:14
*/

CREATE TABLE `product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `stock` int NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

INSERT INTO `product` (`id`,`name`,`stock`,`price`) VALUES (1,'Laptop',36,75000.00);
INSERT INTO `product` (`id`,`name`,`stock`,`price`) VALUES (2,'Smart Phone',250,30000.00);
INSERT INTO `product` (`id`,`name`,`stock`,`price`) VALUES (3,'Head Phones',1000,700.00);
INSERT INTO `product` (`id`,`name`,`stock`,`price`) VALUES (4,'mouse',500,300.00);

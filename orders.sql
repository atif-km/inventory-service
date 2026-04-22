/*
-- Query: SELECT * FROM orders
LIMIT 0, 1000

-- Date: 2026-04-22 10:10
*/

CREATE TABLE `orders` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `product_id` bigint NOT NULL,
  `quantity` int NOT NULL,
  `status` varchar(30) NOT NULL,
  `order_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

INSERT INTO `orders` (`id`,`product_id`,`quantity`,`status`,`order_date`) VALUES (1,1,1,'PAYMENT_SUCCESS','2026-04-13 18:36:50');
INSERT INTO `orders` (`id`,`product_id`,`quantity`,`status`,`order_date`) VALUES (2,2,2,'PAYMENT_SUCCESS','2026-04-13 18:36:50');
INSERT INTO `orders` (`id`,`product_id`,`quantity`,`status`,`order_date`) VALUES (3,3,1,'PAYMENT_FAILED','2026-04-13 18:36:50');
INSERT INTO `orders` (`id`,`product_id`,`quantity`,`status`,`order_date`) VALUES (4,1,2,'SUCCESS','2026-04-14 03:01:10');
INSERT INTO `orders` (`id`,`product_id`,`quantity`,`status`,`order_date`) VALUES (5,1,2,'SUCCESS','2026-04-14 03:04:07');
INSERT INTO `orders` (`id`,`product_id`,`quantity`,`status`,`order_date`) VALUES (6,1,1,'PAYMENT_FAILED','2026-04-14 11:08:22');
INSERT INTO `orders` (`id`,`product_id`,`quantity`,`status`,`order_date`) VALUES (7,1,10,'PAYMENT_SUCCESS','2026-04-14 11:08:42');
INSERT INTO `orders` (`id`,`product_id`,`quantity`,`status`,`order_date`) VALUES (8,1,1,'PAYMENT_FAILED','2026-04-14 11:09:49');
INSERT INTO `orders` (`id`,`product_id`,`quantity`,`status`,`order_date`) VALUES (9,1,10,'PAYMENT_SUCCESS','2026-04-14 11:09:59');
INSERT INTO `orders` (`id`,`product_id`,`quantity`,`status`,`order_date`) VALUES (10,1,10,'PAYMENT_SUCCESS','2026-04-14 13:14:05');
INSERT INTO `orders` (`id`,`product_id`,`quantity`,`status`,`order_date`) VALUES (11,1,10,'PAYMENT_SUCCESS','2026-04-15 09:53:23');

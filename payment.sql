/*
-- Query: SELECT * FROM payment
LIMIT 0, 1000

-- Date: 2026-04-22 10:06
*/

CREATE TABLE `payment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `orderid` bigint NOT NULL,
  `status` varchar(100) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `payment_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

INSERT INTO `payment` (`id`,`orderid`,`status`,`amount`,`payment_date`) VALUES (1,1,'SUCCESS',75000.00,'2026-04-13 11:07:41');
INSERT INTO `payment` (`id`,`orderid`,`status`,`amount`,`payment_date`) VALUES (2,2,'SUCCESS',35000.00,'2026-04-13 11:07:41');
INSERT INTO `payment` (`id`,`orderid`,`status`,`amount`,`payment_date`) VALUES (3,3,'FAILED',2500.00,'2026-04-13 11:07:41');






DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
                         `user_id` int NOT NULL,
                         `username` varchar(45) DEFAULT NULL,
                         `password` varchar(64) DEFAULT NULL,
                         `role` varchar(45) DEFAULT NULL,
                         `enabled` tinyint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
LOCK TABLES `users` WRITE;
INSERT INTO `users` VALUES (1,'user','$2a$10$tb1/v0.lpEKlU7xas0LyMete1oIGbVfYAU0BofFLrFfWJcxq7nQDS','USER',1);
UNLOCK TABLES;
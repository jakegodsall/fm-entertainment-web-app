DROP DATABASE IF EXISTS fm_entertainment_db;
DROP USER IF EXISTS `admin_user`@`localhost`;

CREATE DATABASE fm_entertainment_db;
CREATE USER `admin_user`@`localhost` IDENTIFIED BY "password";
GRANT ALL PRIVILEGES ON fm_entertainment_db.* TO `admin_user`@`localhost`;
FLUSH PRIVILEGES;

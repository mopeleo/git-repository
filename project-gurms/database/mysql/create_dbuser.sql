
DROP DATABASE IF EXISTS gurmstest;

CREATE DATABASE IF NOT EXISTS gurmstest DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP USER IF EXISTS 'gurms';

CREATE USER 'gurms'@'%' IDENTIFIED BY 'gurms';

GRANT ALL PRIVILEGES ON gurmstest.* TO gurms;

FLUSH PRIVILEGES;
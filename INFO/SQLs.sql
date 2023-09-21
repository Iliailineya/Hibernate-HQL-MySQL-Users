
-- БАЗА ДАНИХ
-- Можливість створення БД з метою уникнення некваліфікованих
-- дій, краще залишити за розробником.
-- Тому такий функціонал у додатку не прописуємо.
-- Можемо створити БД через візуальний інструмент, наприклад,
-- MySQL Workbench.
CREATE DATABASE demo_db;

-- ТАБЛИЦІ
-- Можливість створення таблиць БД, з метою уникнення некваліфікованих
-- дій, краще залишити за розробником.
-- Тому такий функціонал у додатку не прописуємо.
-- Попередньо, необхідно спроектувати таблиці та їх зв'язки,
-- на основі сутностей реального світу.
-- Можемо створити таблиці БД через візуальний інструмент, наприклад,
-- MySQL Workbench.

CREATE TABLE IF NOT EXISTS users1
( id INTEGER NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(128) NOT NULL,
  last_name VARCHAR(128) NOT NULL,
  nickname VARCHAR(128) NOT NULL,
  phone VARCHAR(56) NOT NULL,
  email VARCHAR(128) NOT NULL,
  PRIMARY KEY (id)
);


-- HQL
INSERT INTO User1 (firstName, lastName, phone, email) VALUES (:firstName, :lastName, :phone, :email)
-- SQL
INSERT INTO users1 (first_name, last_name, phone, email) VALUES (:first_name, :last_name, :phone, :email)


-- HQL
FROM User1
-- SQL
SELECT * FROM users1


-- HQL
UPDATE User1 SET phone = :phone WHERE id = :id
-- SQL
UPDATE users1 SET phone = :phone WHERE id = :id


-- HQL
DELETE FROM User1 WHERE id = :id
-- SQL
DELETE FROM users1 WHERE id = :id;

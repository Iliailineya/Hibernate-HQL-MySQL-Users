
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

CREATE TABLE IF NOT EXISTS user
( id INTEGER NOT NULL AUTO_INCREMENT,
  user_name VARCHAR(128) NOT NULL,
  first_name VARCHAR(128) NOT NULL,
  last_name VARCHAR(128) NOT NULL,
  email VARCHAR(128) NOT NULL,
  PRIMARY KEY (id)
);

-- HQL
INSERT INTO User (user_name, firstName, lastName email) VALUES (:user_name, :firstName, :lastName, :email)

-- HQL
FROM User

-- HQL
UPDATE User SET user_name = :phone WHERE id = :id

-- HQL
DELETE FROM User WHERE id = :id
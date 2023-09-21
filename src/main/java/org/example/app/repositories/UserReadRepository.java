package org.example.app.repositories;

import org.example.app.entities.User;
import org.example.app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.List;

public class UserReadRepository {
    public List<User> readUsers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction;
            // Транзакція стартує
            transaction = session.beginTransaction();
            List<User> users =
                    session.createQuery("FROM User", User.class).list();
            // Транзакція виконується
            transaction.commit();
            return users;
        } catch (Exception e) {
            // Якщо помилка – повертаємо порожню колекцію
            return Collections.emptyList();
        }
    }
}


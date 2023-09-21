package org.example.app.repositories;

import org.example.app.entities.User1;
import org.example.app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.List;

public class UserReadRepository {

//    public List<User1> readUsers() {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            return session.createQuery("FROM User1", User1.class).list();
//        } catch (Exception e) {
//            // Якщо помилка – повертаємо порожню колекцію
//            return Collections.emptyList();
//        }
//    }

    public List<User1> readUsers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction;
            // Транзакція стартує
            transaction = session.beginTransaction();
            List<User1> user1s =
                    session.createQuery("FROM User1", User1.class).list();
            // Транзакція виконується
            transaction.commit();
            return user1s;
        } catch (Exception e) {
            // Якщо помилка – повертаємо порожню колекцію
            return Collections.emptyList();
        }
    }
}


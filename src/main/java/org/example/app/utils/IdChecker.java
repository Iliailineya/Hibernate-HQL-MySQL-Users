package org.example.app.utils;

import org.example.app.entities.User1;
import org.hibernate.Session;
import org.hibernate.query.Query;

// Клас-перевірка наявності id у БД
public class IdChecker {

    public static boolean isIdExists(User1 user1) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Перевірка наявності об'єкту за певним id
            user1 = session.get(User1.class, user1.getId());

            if (user1 != null) {
                Query<User1> query = session.createQuery("FROM User1", User1.class);
                query.setMaxResults(1);
                query.getResultList();
            }
            return user1 != null;
        }
    }
}

package org.example.app.repositories;

import org.example.app.entities.User1;
import org.example.app.utils.Constants;
import org.example.app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;

public class UserCreateRepository {

    public String createUser(User1 user1) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Транзакція стартує
            transaction = session.beginTransaction();

            String hql = "INSERT INTO User1 (firstName, lastName, nickname, phone, email) " +
                    "VALUES (:firstName, :lastName, :nickname, :phone, :email)";

            MutationQuery query = session.createMutationQuery(hql);
            query.setParameter("firstName", user1.getFirstName());
            query.setParameter("lastName", user1.getLastName());
            query.setParameter("nickname", user1.getLastName());
            query.setParameter("phone", user1.getPhone());
            query.setParameter("email", user1.getEmail());
            query.executeUpdate();

            // Транзакція виконується
            transaction.commit();
            return Constants.DATA_INSERT_MSG;
         } catch (Exception e) {
            try {
                if (transaction != null) {
                    transaction.rollback();
                }
            } catch (Exception rollbackException) {
                // Обработка исключения отката транзакции
                rollbackException.printStackTrace();
            }
            // Обработка исключения createUser
            e.printStackTrace();
            return e.getMessage();
        }
    }
}

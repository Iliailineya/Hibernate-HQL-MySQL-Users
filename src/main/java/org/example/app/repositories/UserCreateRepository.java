package org.example.app.repositories;

import org.example.app.entities.User;
import org.example.app.constants.Constants;
import org.example.app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;

public class UserCreateRepository {

    public String createUser(User user) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Транзакція стартує
            transaction = session.beginTransaction();

            String hql = "INSERT INTO User (userName, firstName, lastName, email) " +
                    "VALUES (:userName, :firstName, :lastName, :email)";

            MutationQuery query = session.createMutationQuery(hql);
            query.setParameter("userName", user.getUserName());
            query.setParameter("firstName", user.getFirstName());
            query.setParameter("lastName", user.getLastName());
            query.setParameter("email", user.getEmail());
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

package org.example.app.repositories;

import org.example.app.entities.User1;
import org.example.app.utils.Constants;
import org.example.app.utils.HibernateUtil;
import org.example.app.utils.IdChecker;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;

public class UserDeleteRepository {

    public String deleteUser(User1 user1) {
        // Перевіряємо наявність id в БД.
        // ТАК - працюємо з даними.
        // НІ - повідомлення про відсутність id.
        if (IdChecker.isIdExists(user1)) {
            return deleteUserById(user1);
        } else {
            return Constants.ID_NO_EXISTS_MSG;
        }
    }

    public String deleteUserById(User1 user1) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Транзакція стартує
            transaction = session.beginTransaction();

            // Видалення об'єкту
            user1 = session.get(User1.class, user1.getId());

            if (user1 != null) {
                String hql = "DELETE FROM User1 WHERE id = :id";
                MutationQuery query = session.createMutationQuery(hql);
                query.setParameter("id", user1.getId());
                query.executeUpdate();
            }
            // Транзакція виконується
            transaction.commit();
            return Constants.DATA_DELETE_MSG;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return e.getMessage();
        }
    }
}

package Module_7_4.dao;

import Module_7_4.datasource.MariaDBConnection;
import Module_7_4.entity.Transaction;
import jakarta.persistence.EntityManager;

public class TransactionDAO {
    private static final EntityManager entityManager = MariaDBConnection.getInstance();

    public static void addTransaction(Transaction transaction) {
        entityManager.getTransaction().begin();
        entityManager.persist(transaction);
        entityManager.getTransaction().commit();
    }
}

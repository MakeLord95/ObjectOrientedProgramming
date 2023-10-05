package Module_7_4.dao;

import Module_7_4.datasource.MariaDBConnection;
import Module_7_4.entity.Currency2;
import jakarta.persistence.EntityManager;

public class CurrencyDAO {
    private static final EntityManager entityManager = MariaDBConnection.getInstance();

    public static int getCurrencyCount() {
        return entityManager.createQuery("SELECT COUNT(c) FROM Currency c", Long.class).getSingleResult().intValue();
    }

    public static Currency2 getCurrency(int id) {
        return entityManager.find(Currency2.class, id);
    }

    public static double getRate(String abbreviation) {
        return entityManager.createQuery("SELECT c.exchangeRate FROM Currency c WHERE c.abbreviation = :abbreviation", Double.class)
                .setParameter("abbreviation", abbreviation)
                .getSingleResult();
    }

    public static void addCurrency(Currency2 currency) {
        entityManager.getTransaction().begin();
        entityManager.persist(currency);
        entityManager.getTransaction().commit();
    }

    public static Currency2 getCurrencyWithAbbreviation(String abbreviation) {
        return entityManager.createQuery("SELECT c FROM Currency2 c WHERE c.abbreviation = :abbreviation", Currency2.class)
                .setParameter("abbreviation", abbreviation)
                .getSingleResult();
    }
}

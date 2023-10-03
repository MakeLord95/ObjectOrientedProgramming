package Module_7_3.dao;

import Module_7_3.datasource.MariaDBConnection;
import Module_7_3.entity.Currency;
import jakarta.persistence.EntityManager;

public class CurrencyDAO {
    private static final EntityManager entityManager = MariaDBConnection.getInstance();

    public static int getCurrencyCount() {
        return entityManager.createQuery("SELECT COUNT(c) FROM Currency c", Long.class).getSingleResult().intValue();
    }

    public static Currency getCurrency(int id) {
        return entityManager.find(Currency.class, id);
    }

    public static double getRate(String abbreviation) {
        return entityManager.createQuery("SELECT c.exchangeRate FROM Currency c WHERE c.abbreviation = :abbreviation", Double.class)
                .setParameter("abbreviation", abbreviation)
                .getSingleResult();
    }
}

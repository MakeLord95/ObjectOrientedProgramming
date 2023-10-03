package ClassExamples.HibernateExample.datasource;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

public class MariaDBConn {
    private static EntityManagerFactory entityManagerFactory = null;
    private static EntityManager entityManager = null;

    public static EntityManager getInstance() {
        if (entityManager == null) {
            if (entityManagerFactory == null) {
                entityManagerFactory = Persistence.createEntityManagerFactory("CompanyMariaDBUnit");
            }
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }
}

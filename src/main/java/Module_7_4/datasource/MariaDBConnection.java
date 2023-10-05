package Module_7_4.datasource;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MariaDBConnection {
    private static EntityManagerFactory entityManagerFactory = null;
    private static EntityManager entityManager = null;

    public static EntityManager getInstance() {
        if (entityManager == null) {
            if (entityManagerFactory == null) {
                entityManagerFactory = Persistence.createEntityManagerFactory("Module_7_4");
            }
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }
}

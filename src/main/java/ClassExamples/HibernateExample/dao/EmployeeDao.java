package ClassExamples.HibernateExample.dao;

import ClassExamples.HibernateExample.entity.Employee;
import ClassExamples.HibernateExample.datasource.MariaDBConn;
import jakarta.persistence.EntityManager;

public class EmployeeDao {
    private final EntityManager entityManager = MariaDBConn.getInstance();

    public void addEmployee(Employee employee) {
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
    }

    public Employee findEmployee(int id) {
        return entityManager.find(Employee.class, id);
    }
}

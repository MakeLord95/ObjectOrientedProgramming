package ClassExamples.DBDemo.dao;

import ClassExamples.DBDemo.datasource.MariaDBConn;
import ClassExamples.DBDemo.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDao {
    private final Connection conn = MariaDBConn.getConnection();

    public Employee findEmployee(int id) {
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM employees WHERE id = ?;");

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String email = rs.getString("email");
                double salary = rs.getDouble("salary");
                id = rs.getInt("ID");

                return new Employee(lastName, firstName, email, salary, id);
            }
        } catch (Exception e) {
            System.out.println("Error finding employee.");
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void addEmployee(Employee employee) {
        try {
            PreparedStatement statement = conn.prepareStatement(
                    "INSERT INTO employees (firstName, lastName, email, salary) VALUES (?, ?, ?, ?);");

            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getEmail());
            statement.setDouble(4, employee.getSalary());

            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error adding employee.");
            System.out.println(e.getMessage());
        }
    }
}

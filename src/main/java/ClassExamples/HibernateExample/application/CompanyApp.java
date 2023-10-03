package ClassExamples.HibernateExample.application;

import ClassExamples.HibernateExample.dao.EmployeeDao;
import ClassExamples.HibernateExample.entity.Employee;

import java.util.Scanner;

public class CompanyApp {
    public static void main(String[] args) {
        EmployeeDao dao = new EmployeeDao();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();

        Employee employee = dao.findEmployee(id);
        System.out.println(employee);

        // Adding new employee to the database
        System.out.print("Enter employee first name: ");
        String firstName = scanner.next();

        System.out.print("Enter employee last name: ");
        String lastName = scanner.next();

        System.out.print("Enter employee email: ");
        String email = scanner.next();

        System.out.print("Enter employee salary: ");
        double salary = scanner.nextDouble();

        Employee newEmployee = new Employee(lastName, firstName, email, salary);
        dao.addEmployee(newEmployee);
    }
}

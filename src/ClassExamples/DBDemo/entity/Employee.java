package ClassExamples.DBDemo.entity;

public class Employee {
    private final String lastName;
    private final String firstName;
    private final String email;
    private final double salary;
    private final int id;

    public Employee(String lastName, String firstName, String email, double salary, int id) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.salary = salary;
        this.id = id;
    }

    public Employee(String lastName, String firstName, String email, double salary) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.salary = salary;
        id = 0;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%d, %s, %s, %s, %.2f", id, lastName, firstName, email, salary);
    }
}

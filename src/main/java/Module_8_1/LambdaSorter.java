package Module_8_1;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Arrays.sort;

class Person {
    private final String name;
    private final int age;
    private final String city;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return String.format("%s, %d, %s", name, age, city);
    }
}

public class LambdaSorter {
    public static void main(String[] args) {
        Person[] persons = {
                new Person("John", 20, "New York"),
                new Person("Pete", 18, "Boston"),
                new Person("Ann", 23, "Chicago"),
                new Person("Mary", 19, "New York"),
                new Person("Jane", 21, "Boston"),
                new Person("Tom", 20, "Chicago"),
                new Person("Kate", 18, "New York"),
                new Person("Jack", 22, "Boston"),
                new Person("Bill", 19, "Chicago"),
                new Person("Sue", 21, "New York"),
                new Person("Alex", 20, "Boston"),
                new Person("Don", 18, "Chicago")
        };

        System.out.println("Before sorting:");
        for (Person person : persons) {
            System.out.println(person);
        }

        System.out.println("\nAfter sorting by name:");
        sort(persons, Comparator.comparing(Person::getName));
        for (Person person : persons) {
            System.out.println(person);
        }

        System.out.println("\nAfter sorting by age:");
        sort(persons, Comparator.comparingInt(Person::getAge));
        for (Person person : persons) {
            System.out.println(person);
        }

        System.out.println("\nAfter filtering by city:");
        Person[] personsFromNewYork = Arrays.stream(persons)
                .filter(person -> person.getCity().equals("New York"))
                .toArray(Person[]::new);

        for (Person person : personsFromNewYork) {
            System.out.println(person);
        }
    }
}

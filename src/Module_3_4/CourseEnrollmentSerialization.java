package Module_3_4;

import java.io.*;

class Student implements Serializable {
    private final int id;
    private int age;
    private String name;
    private int nextID;

    public Student() {
        this.name = "";
        this.age = 0;
        this.id = 0;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = ++nextID;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d, ID: %d", name, age, id);
    }
}

class Course implements Serializable {
    private String courseCode;
    private String courseName;
    private String instructor;

    public Course() {
        this.courseCode = "";
        this.courseName = "";
        this.instructor = "";
    }

    public Course(String courseCode, String courseName, String instructor) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return String.format("Course code: %s, Course name: %s, Instructor: %s", courseCode, courseName, instructor);
    }
}

class Enrollment implements Serializable {
    private Student student;
    private Course course;
    private String enrollmentDate;

    public Enrollment() {
        this.student = null;
        this.course = null;
        this.enrollmentDate = "";
    }

    public Enrollment(Student student, Course course, String enrollmentDate) {
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public String toString() {
        return String.format("Student %s, Course: %s, Enrollment date: %s", student.getName(), course.getCourseName(), enrollmentDate);
    }
}

public class CourseEnrollmentSerialization {
    private final static String FILENAME = "enrollments.ser";

    public static void main(String[] args) {
        File f = new File(FILENAME);

        System.out.println("Writing objects to file");

        Student student = new Student("Matti", 27);
        Course course = new Course("12345", "Arts & Crafts", "Mikko");
        Enrollment enrollment = new Enrollment(student, course, "07.09.2023");

        try (FileOutputStream fileOutputStream = new FileOutputStream(FILENAME);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);) {

            objectOutputStream.writeObject(student);
            objectOutputStream.writeObject(course);
            objectOutputStream.writeObject(enrollment);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(2);
        }

        System.out.println("Reading objects from file");

        try (FileInputStream inputStream = new FileInputStream(FILENAME);
             ObjectInputStream objects = new ObjectInputStream(inputStream);
        ) {
            student = (Student) objects.readObject();
            course = (Course) objects.readObject();
            enrollment = (Enrollment) objects.readObject();

            System.out.println(student);
            System.out.println(course);
            System.out.println(enrollment);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}

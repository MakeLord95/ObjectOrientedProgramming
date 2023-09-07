package Module_3_4;

import java.io.File;
import java.io.Serializable;

class Student implements Serializable {
    private final int id;
    private int age;
    private String name;
    private int nextID;

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

        Student student = new Student("Matti", 27);
        Course course = new Course("12345", "Arts & Crafts", "Mikko");

        Enrollment enrollment = new Enrollment(student, course, "07.09.2023");


        System.out.printf("%s\n", enrollment);

    }
}
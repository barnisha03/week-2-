import java.util.ArrayList;
import java.util.List;

// Course class - associated with many students
class Course {
    private String courseName;
    private List<Student> enrolledStudents;

    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void showEnrolledStudents() {
        System.out.println("Students enrolled in " + courseName + ":");
        for (Student s : enrolledStudents) {
            System.out.println("- " + s.getName());
        }
    }
}

// Student class - associated with many courses
class Student {
    private String name;
    private List<Course> enrolledCourses;

    public Student(String name) {
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollInCourse(Course course) {
        enrolledCourses.add(course);
        course.enrollStudent(this); // Bidirectional association
    }

    public void showCourses() {
        System.out.println(name + " is enrolled in the following courses:");
        for (Course c : enrolledCourses) {
            System.out.println("- " + c.getCourseName());
        }
    }
}

// School class - aggregates Student objects
class School {
    private String schoolName;
    private List<Student> students;

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);  // Aggregation
    }

    public void showAllStudents() {
        System.out.println("Students in " + schoolName + ":");
        for (Student s : students) {
            System.out.println("- " + s.getName());
        }
    }
}

// Main class to demonstrate aggregation and association
public class SchoolCourseDemo {
    public static void main(String[] args) {
        // Create school
        School school = new School("Greenfield High");

        // Create students
        Student alice = new Student("Alice");
        Student bob = new Student("Bob");

        // Add students to school (aggregation)
        school.addStudent(alice);
        school.addStudent(bob);

        // Create courses
        Course math = new Course("Mathematics");
        Course science = new Course("Science");

        // Students enroll in courses (association)
        alice.enrollInCourse(math);
        alice.enrollInCourse(science);
        bob.enrollInCourse(science);

        // Display data
        school.showAllStudents();
        System.out.println();
        alice.showCourses();
        System.out.println();
        bob.showCourses();
        System.out.println();
        math.showEnrolledStudents();
        System.out.println();
        science.showEnrolledStudents();
    }
}

















import java.util.*;

class Course {
    String courseName;
    Professor professor;

    public Course(String name) {
        this.courseName = name;
    }

    public void assignProfessor(Professor p) {
        this.professor = p;
        System.out.println("Professor " + p.name + " assigned to " + courseName);
    }
}

class Student {
    String name;
    List<Course> courses = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public void enrollCourse(Course c) {
        courses.add(c);
        System.out.println(name + " enrolled in " + c.courseName);
    }

    public void viewCourses() {
        for (Course c : courses)
            System.out.println(name + " has enrolled in: " + c.courseName);
    }
}

class Professor {
    String name;

    public Professor(String name) {
        this.name = name;
    }
}

public class UniversitySystem {
    public static void main(String[] args) {
        Student s1 = new Student("Tom");
        Course c1 = new Course("Data Structures");
        Course c2 = new Course("AI");

        s1.enrollCourse(c1);
        s1.enrollCourse(c2);

        Professor p1 = new Professor("Dr. Watson");
        c1.assignProfessor(p1);

        s1.viewCourses();
    }
}





















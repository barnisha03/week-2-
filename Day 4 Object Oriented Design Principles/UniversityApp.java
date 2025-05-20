import java.util.*;

class Faculty {
    String name;

    public Faculty(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Faculty: " + name);
    }
}

class Department {
    String deptName;

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public void display() {
        System.out.println("Department: " + deptName);
    }
}

class University {
    String name;
    List<Department> departments = new ArrayList<>();
    List<Faculty> faculties = new ArrayList<>();

    public University(String name) {
        this.name = name;
    }

    public void addDepartment(Department d) {
        departments.add(d);
    }

    public void addFaculty(Faculty f) {
        faculties.add(f);
    }

    public void display() {
        System.out.println("University: " + name);
        for (Department d : departments) d.display();
        for (Faculty f : faculties) f.display();
    }

    public void closeUniversity() {
        departments.clear();
        System.out.println("University closed. All departments removed.");
    }
}

public class UniversityApp {
    public static void main(String[] args) {
        Faculty f1 = new Faculty("Dr. Smith");
        Faculty f2 = new Faculty("Prof. Alice");

        University u = new University("ABC University");
        u.addFaculty(f1);
        u.addFaculty(f2);
        u.addDepartment(new Department("Computer Science"));
        u.addDepartment(new Department("Physics"));

        u.display();
        u.closeUniversity();
        u.display();  // Departments cleared, faculties remain (aggregation)
    }
}


















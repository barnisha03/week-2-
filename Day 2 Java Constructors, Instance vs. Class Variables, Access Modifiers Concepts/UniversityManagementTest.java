class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Public methods to access private CGPA
    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
}

// Subclass to demonstrate access to protected member
class PostgraduateStudent extends Student {

    public PostgraduateStudent(int rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
    }

    public void display() {
        // Accessing protected member 'name' from superclass
        System.out.println("Name (protected): " + name);
        // Accessing public member
        System.out.println("Roll Number (public): " + rollNumber);
        // Cannot access private CGPA directly here
        System.out.println("CGPA (via getter): " + getCGPA());
    }
}

public class UniversityManagementTest {
    public static void main(String[] args) {
        PostgraduateStudent pgStudent = new PostgraduateStudent(101, "Alice", 9.1);
        pgStudent.display();

        pgStudent.setCGPA(9.3);
        System.out.println("Updated CGPA: " + pgStudent.getCGPA());
    }
}










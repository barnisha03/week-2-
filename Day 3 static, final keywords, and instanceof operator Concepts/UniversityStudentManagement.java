class Student {
    private static String universityName = "Global University";
    private static int totalStudents = 0;

    private final int rollNumber;
    private String name;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name; // this keyword
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    public void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("Name: " + name);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Grade: " + grade);
            System.out.println("University: " + universityName);
        }
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }
}

public class UniversityStudentManagement {
    public static void main(String[] args) {
        Student s1 = new Student("Alice", 101, "A");
        Student s2 = new Student("Bob", 102, "B");

        s1.displayStudentDetails();
        s2.displayStudentDetails();
        Student.displayTotalStudents();
    }
}












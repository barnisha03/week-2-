import java.util.*;

// Interface
interface Department {
    void assignDepartment(String departmentName);
    String getDepartmentDetails();
}

// Abstract class
abstract class Employee implements Department {
    private int employeeId;
    private String name;
    private double baseSalary;
    private String department;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Getters and Setters
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }

    @Override
    public String getDepartmentDetails() {
        return department;
    }

    // Abstract method
    public abstract double calculateSalary();

    // Concrete method
    public void displayDetails() {
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: $" + baseSalary);
        System.out.println("Department: " + department);
        System.out.println("Final Salary: $" + calculateSalary());
        System.out.println("----------------------------------");
    }
}

// Subclass: Full-time Employee
class FullTimeEmployee extends Employee {
    public FullTimeEmployee(int employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary(); // Fixed salary
    }
}

// Subclass: Part-time Employee
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int employeeId, String name, double hourlyRate, int hoursWorked) {
        super(employeeId, name, 0); // baseSalary not used directly
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

// Main class to test
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        FullTimeEmployee f1 = new FullTimeEmployee(101, "Alice", 50000);
        f1.assignDepartment("Engineering");

        PartTimeEmployee p1 = new PartTimeEmployee(102, "Bob", 200, 30);
        p1.assignDepartment("Support");

        employees.add(f1);
        employees.add(p1);

        // Polymorphism: processing employees using base class reference
        for (Employee emp : employees) {
            emp.displayDetails();
        }
    }
}


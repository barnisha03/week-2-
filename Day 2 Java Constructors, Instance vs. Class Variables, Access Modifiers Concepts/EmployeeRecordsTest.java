class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public method to modify salary
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

// Subclass to demonstrate access to public and protected members
class Manager extends Employee {

    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    public void display() {
        System.out.println("Employee ID (public): " + employeeID);
        System.out.println("Department (protected): " + department);
        System.out.println("Salary (via getter): " + getSalary());
    }
}

public class EmployeeRecordsTest {
    public static void main(String[] args) {
        Manager mgr = new Manager(501, "IT", 90000);
        mgr.display();

        mgr.setSalary(95000);
        System.out.println("Updated Salary: " + mgr.getSalary());
    }
}









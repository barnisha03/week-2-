import java.util.ArrayList;
import java.util.List;

// Employee class - exists only within Department
class Employee {
    private String name;
    private String role;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public void display() {
        System.out.println("Employee: " + name + ", Role: " + role);
    }
}

// Department class - exists only within Company
class Department {
    private String departmentName;
    private List<Employee> employees;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String name, String role) {
        employees.add(new Employee(name, role));
    }

    public void display() {
        System.out.println("Department: " + departmentName);
        for (Employee emp : employees) {
            emp.display();
        }
        System.out.println();
    }

    public void clear() {
        employees.clear();  // Remove all employees
    }
}

// Company class - owns Departments
class Company {
    private String companyName;
    private List<Department> departments;

    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    public Department addDepartment(String departmentName) {
        Department dept = new Department(departmentName);
        departments.add(dept);
        return dept;
    }

    public void display() {
        System.out.println("Company: " + companyName);
        for (Department dept : departments) {
            dept.display();
        }
    }

    public void shutdownCompany() {
        System.out.println("Shutting down company: " + companyName);
        for (Department dept : departments) {
            dept.clear();  // Clear all employees
        }
        departments.clear();  // Remove all departments
        System.out.println("All departments and employees removed.");
    }
}

// Main class to demonstrate composition
public class CompositionDemo {
    public static void main(String[] args) {
        Company company = new Company("TechCorp");

        Department hr = company.addDepartment("Human Resources");
        hr.addEmployee("Alice", "HR Manager");
        hr.addEmployee("Bob", "Recruiter");

        Department dev = company.addDepartment("Development");
        dev.addEmployee("Charlie", "Software Engineer");
        dev.addEmployee("David", "Backend Developer");

        company.display();

        // Demonstrate composition: destroy the company and its parts
        company.shutdownCompany();

        // Try displaying after shutdown
        System.out.println("\nAfter shutdown:");
        company.display();  // Should show no departments or employees
    }
}
















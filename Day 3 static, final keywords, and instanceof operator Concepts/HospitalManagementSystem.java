class Patient {
    private static String hospitalName = "City Hospital";
    private static int totalPatients = 0;

    private final int patientID;
    private String name;
    private int age;
    private String ailment;

    public Patient(String name, int age, String ailment, int patientID) {
        this.name = name; // this
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    public void displayPatientDetails() {
        if (this instanceof Patient) {
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
            System.out.println("Hospital: " + hospitalName);
        }
    }

    public static void getTotalPatients() {
        System.out.println("Total Patients: " + totalPatients);
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Patient p1 = new Patient("Alice", 30, "Flu", 1001);
        Patient p2 = new Patient("Bob", 45, "Fracture", 1002);

        p1.displayPatientDetails();
        p2.displayPatientDetails();

        Patient.getTotalPatients();
    }
}













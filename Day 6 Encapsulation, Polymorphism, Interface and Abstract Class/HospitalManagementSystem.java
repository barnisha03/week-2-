// Interface
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Abstract class
abstract class Patient implements MedicalRecord {
    private String patientId;
    private String name;
    private int age;
    private String diagnosis;
    private StringBuilder medicalHistory;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.medicalHistory = new StringBuilder();
    }

    // Encapsulation: Getters
    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    // Encapsulation: Setters
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId + ", Name: " + name + ", Age: " + age + ", Diagnosis: " + diagnosis);
    }

    // Abstract method
    public abstract double calculateBill();

    // Interface methods
    public void addRecord(String record) {
        medicalHistory.append(record).append("\n");
    }

    public void viewRecords() {
        System.out.println("Medical History:\n" + medicalHistory.toString());
    }
}

// InPatient subclass
class InPatient extends Patient {
    private int daysAdmitted;
    private double dailyRate;

    public InPatient(String patientId, String name, int age, int daysAdmitted, double dailyRate) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate + 1000; // Rs.1000 admission fee
    }
}

// OutPatient subclass
class OutPatient extends Patient {
    private int visits;
    private double consultationFee;

    public OutPatient(String patientId, String name, int age, int visits, double consultationFee) {
        super(patientId, name, age);
        this.visits = visits;
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return visits * consultationFee;
    }
}

// Main class to demonstrate polymorphism
public class HospitalManagementSystem {
    public static void main(String[] args) {
        Patient[] patients = new Patient[2];

        InPatient p1 = new InPatient("P001", "Alice", 45, 5, 2000);
        p1.setDiagnosis("Appendicitis");
        p1.addRecord("Admitted on 1st Jan. Surgery on 2nd Jan.");
        p1.addRecord("Discharged on 6th Jan.");
        patients[0] = p1;

        OutPatient p2 = new OutPatient("P002", "Bob", 30, 3, 500);
        p2.setDiagnosis("Cold & Fever");
        p2.addRecord("Visited on 5th, 6th and 8th Jan.");
        patients[1] = p2;

        // Polymorphic processing
        for (Patient patient : patients) {
            patient.getPatientDetails();
            patient.viewRecords();
            System.out.println("Total Bill: Rs." + patient.calculateBill());
            System.out.println();
        }
    }
}





import java.util.*;

class Patient {
    String name;

    public Patient(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Patient: " + name);
    }
}

class Doctor {
    String name;

    public Doctor(String name) {
        this.name = name;
    }

    public void consult(Patient p) {
        System.out.println("Doctor " + name + " is consulting patient " + p.name);
    }
}

class Hospital {
    List<Doctor> doctors = new ArrayList<>();
    List<Patient> patients = new ArrayList<>();

    public void addDoctor(Doctor d) {
        doctors.add(d);
    }

    public void addPatient(Patient p) {
        patients.add(p);
    }

    public void display() {
        for (Doctor d : doctors) d.consult(patients.get(0));  // Sample interaction
    }
}

public class HospitalApp {
    public static void main(String[] args) {
        Doctor d1 = new Doctor("Dr. John");
        Doctor d2 = new Doctor("Dr. Lisa");

        Patient p1 = new Patient("Tom");
        Patient p2 = new Patient("Jerry");

        Hospital h = new Hospital();
        h.addDoctor(d1);
        h.addDoctor(d2);
        h.addPatient(p1);
        h.addPatient(p2);

        h.display();  // Simulate consultations
    }
}



















class Vehicle {
    private static double registrationFee = 100.0;

    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;

    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName; // this keyword
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    public void displayVehicleDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Owner: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
        }
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Registration fee updated to $" + registrationFee);
    }
}

public class VehicleRegistrationSystem {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Alice", "Car", "REG123");
        Vehicle v2 = new Vehicle("Bob", "Motorcycle", "REG456");

        v1.displayVehicleDetails();
        v2.displayVehicleDetails();

        Vehicle.updateRegistrationFee(120);
        v1.displayVehicleDetails();
    }
}













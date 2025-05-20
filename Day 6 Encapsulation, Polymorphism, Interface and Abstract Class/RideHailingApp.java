// Interface
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Abstract class
abstract class Vehicle implements GPS {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Encapsulation: Getters
    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate/km: " + ratePerKm);
    }

    // Abstract method
    public abstract double calculateFare(double distance);

    // GPS interface methods
    public String getCurrentLocation() {
        return currentLocation;
    }

    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

// Subclass: Car
class Car extends Vehicle {
    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 50; // base charge Rs.50
    }
}

// Subclass: Bike
class Bike extends Vehicle {
    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm(); // no base charge
    }
}

// Subclass: Auto
class Auto extends Vehicle {
    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 20; // base charge Rs.20
    }
}

// Main class
public class RideHailingApp {
    public static void main(String[] args) {
        Vehicle[] rides = new Vehicle[3];

        rides[0] = new Car("CAR101", "Ravi", 15.0);
        rides[1] = new Bike("BIKE202", "Kiran", 8.0);
        rides[2] = new Auto("AUTO303", "Manoj", 10.0);

        double distance = 10.0; // example distance in km

        for (Vehicle ride : rides) {
            ride.getVehicleDetails();
            ride.updateLocation("Central Station");
            System.out.println("Current Location: " + ride.getCurrentLocation());
            System.out.println("Fare for " + distance + " km: Rs." + ride.calculateFare(distance));
            System.out.println();
        }
    }
}







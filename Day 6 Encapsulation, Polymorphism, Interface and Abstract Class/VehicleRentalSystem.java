interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

abstract class RentalVehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public RentalVehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public abstract double calculateRentalCost(int days);

    public double getRentalRate() {
        return rentalRate;
    }

    public String getType() {
        return type;
    }
}

class Car extends RentalVehicle implements Insurable {
    public Car(String vehicleNumber, double rate) {
        super(vehicleNumber, "Car", rate);
    }

    public double calculateRentalCost(int days) {
        return days * getRentalRate();
    }

    public double calculateInsurance() {
        return 2000;
    }

    public String getInsuranceDetails() {
        return "Standard car insurance";
    }
}

class Bike extends RentalVehicle implements Insurable {
    public Bike(String vehicleNumber, double rate) {
        super(vehicleNumber, "Bike", rate);
    }

    public double calculateRentalCost(int days) {
        return days * getRentalRate();
    }

    public double calculateInsurance() {
        return 500;
    }

    public String getInsuranceDetails() {
        return "Two-wheeler insurance";
    }
}

class Truck extends RentalVehicle implements Insurable {
    public Truck(String vehicleNumber, double rate) {
        super(vehicleNumber, "Truck", rate);
    }

    public double calculateRentalCost(int days) {
        return days * getRentalRate() + 1000; // extra handling charge
    }

    public double calculateInsurance() {
        return 5000;
    }

    public String getInsuranceDetails() {
        return "Heavy vehicle insurance";
    }
}

// Main Class
public class VehicleRentalSystem {
    public static void main(String[] args) {
        RentalVehicle[] vehicles = {
            new Car("KA01AB1234", 1000),
            new Bike("KA02XY5678", 300),
            new Truck("KA03TR9090", 2000)
        };

        for (RentalVehicle v : vehicles) {
            double rent = v.calculateRentalCost(3);
            double insurance = ((Insurable) v).calculateInsurance();

            System.out.println("Vehicle: " + v.getType());
            System.out.println("Rental Cost for 3 days: ₹" + rent);
            System.out.println("Insurance: ₹" + insurance);
            System.out.println("-------------------------");
        }
    }
}




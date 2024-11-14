package vehiclerentasystem;

public class Vehicles {
    private String vehicleID;
    private String registrationNumber;
    private String make;
    private String model;
    private double rentalRate;
    private String vehicleType;
    private String vehicleStatus;

    // Constructor
    public Vehicles(String vehicleID, String registrationNumber, String make, double rentalRate) {
        this.vehicleID = vehicleID;
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.model = model;
        this.rentalRate = rentalRate;
        this.vehicleType = vehicleType;
        this.vehicleStatus = vehicleStatus;
    }

    Vehicles(String v123, String abC123, String toyota, String corolla, double d, String car, String available) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getters and setters
    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    @Override
    public String toString() {
        return "Vehicle [Vehicle ID=" + vehicleID + ", Registration Number=" + registrationNumber + ", Make=" + make + ", Model=" + model +
               ", Rental Rate=" + rentalRate + ", Vehicle Type=" + vehicleType + ", Vehicle Status=" + vehicleStatus + "]";
    }

    // Method to display user choices
    public static void displayUserVehicleChoices() {
        System.out.println("Please choose one of the following options:");
        System.out.println("1. View vehicle details");
        System.out.println("2. Check vehicle availability");
        System.out.println("3. Rent a vehicle");
        System.out.println("4. Return a vehicle");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }
    
    
}

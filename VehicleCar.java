package vehiclerentasystem;

public class VehicleCar extends Vehicles {
    private String carModel;
    private String carDescription;
    private String plateNumber;
    private int carCapacity; // number of passengers
    private double carPrice; // price per day

    // Constructor
    public VehicleCar(String vehicleID, String registrationNumber, String make, String model, double rentalRate, String available) {
        super(vehicleID, registrationNumber, make, rentalRate);
        this.carModel = carModel;
        this.carDescription = carDescription;
        this.plateNumber = plateNumber;
        this.carCapacity = carCapacity;
        this.carPrice = carPrice;
    }

    // Getters and setters
    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarDescription() {
        return carDescription;
    }

    public void setCarDescription(String carDescription) {
        this.carDescription = carDescription;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getCarCapacity() {
        return carCapacity;
    }

    public void setCarCapacity(int carCapacity) {
        this.carCapacity = carCapacity;
    }

    public double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(double carPrice) {
        this.carPrice = carPrice;
    }

    @Override
    public String toString() {
        return super.toString() + ", Car Model=" + carModel + ", Car Description=" + carDescription +
               ", Plate Number=" + plateNumber + ", Car Capacity=" + carCapacity + ", Car Price=" + carPrice + "]";
    }
}



package vehiclerentasystem;

public class VehicleTruck  extends Vehicles {
    private double loadCapacity; // in tons
    private int numOfAxles;

    // Constructor
    public VehicleTruck(String vehicleID, String registrationNumber, String make, double rentalRate, String model, double loadCapacity) {
         super(vehicleID, registrationNumber, make, rentalRate);
        this.loadCapacity = loadCapacity;
        this.numOfAxles = numOfAxles;
    }

    // Getters and setters
    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public int getNumOfAxles() {
        return numOfAxles;
    }

    public void setNumOfAxles(int numOfAxles) {
        this.numOfAxles = numOfAxles;
    }

    @Override
    public String toString() {
        return super.toString() + ", Load Capacity=" + loadCapacity + " tons, Number of Axles=" + numOfAxles + "]";
    }
}


package vehiclerentasystem;

public class VehicleMotor extends Vehicles {
    private double engineDisplacement; // in cc

    // Constructor
    public VehicleMotor(String vehicleID, String registrationNumber, String make, double rentalRate, String model, boolean vehicleStatus) {
        super(vehicleID, registrationNumber, make, rentalRate);
        this.engineDisplacement = engineDisplacement;
    }

    // Getter and setter
    public double getEngineDisplacement() {
        return engineDisplacement;
    }

    public void setEngineDisplacement(double engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
    }

    @Override
    public String toString() {
        return super.toString() + ", Engine Displacement=" + engineDisplacement + " cc]";
    }
}


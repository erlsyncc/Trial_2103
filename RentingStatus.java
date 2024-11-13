
package vehiclerentasystem;


public class RentingStatus {
    private String status;

    // Constructor that sets the initial status (default is "Available")
    public RentingStatus() {
        this.status = "Available";
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String newStatus) {
        this.status = newStatus;
    }

    public void rentOut() {
        if (!status.equals("Rented")) {
            this.status = "Rented";
        } else {
            System.out.println("The item is already rented.");
        }
    }

    public void returnItem() {
        if (!status.equals("Returned")) {
            this.status = "Returned";
        } else {
            System.out.println("The item has already been returned.");
        }
    }

    public void makeAvailable() {
        if (!status.equals("Available")) {
            this.status = "Available";
        } else {
            System.out.println("The item is already available.");
        }
    }

    public boolean isAvailable() {
        return status.equals("Available");
    }

    // Optional: Display status (not necessarily needed, but can be useful for debugging)
    public void displayStatus() {
        System.out.println("Current Renting Status: " + status);
    }
}


package vehiclerentasystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RentalForm {
    private String formId;
    private String clientId;
    private String vehicleId;
    private String rentalDate;
    private String returnDate;
    private double rentalCost;
    private String rentalStatus;

    // Constructor
    public RentalForm(String formId, String clientId, String vehicleId, String rentalDate, String returnDate, double rentalCost, String rentalStatus) {
        this.formId = formId;
        this.clientId = clientId;
        this.vehicleId = vehicleId;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.rentalCost = rentalCost;
        this.rentalStatus = rentalStatus;
    }

    // Method to create a rental form
    public void createRentalForm(String clientId, String vehicleId, String rentalDate, String returnDate) {
        this.formId = generateFormId();
        this.clientId = clientId;
        this.vehicleId = vehicleId;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        int rentalDays = calculateRentalDays(rentalDate, returnDate);
        this.rentalCost = calculateRentalCost(vehicleId, rentalDays);
        this.rentalStatus = "Created";
        
        displayFormStep("create");
    }

    // Method to update a rental form's rental and return dates
    public void updateRentalForm(String formId, String newRentalDate, String newReturnDate) {
        if (this.formId.equals(formId) && !"Finalized".equals(this.rentalStatus)) {
            this.rentalDate = newRentalDate;
            this.returnDate = newReturnDate;
            int rentalDays = calculateRentalDays(newRentalDate, newReturnDate);
            this.rentalCost = calculateRentalCost(vehicleId, rentalDays);
            displayFormStep("update");
        } else {
            System.out.println("Cannot update rental form. Either form ID does not match or rental is already finalized.");
        }
    }

    // Method to cancel a rental form
    public void cancelRentalForm(String formId) {
        if (this.formId.equals(formId) && !"Finalized".equals(this.rentalStatus)) {
            this.rentalStatus = "Cancelled";
            displayFormStep("cancel");
        } else {
            System.out.println("Cannot cancel rental form. Either form ID does not match or rental is already finalized.");
        }
    }

    // Method to calculate rental cost based on rental days and vehicle rate
    public double calculateRentalCost(String vehicleId, int rentalDays) {
        double dailyRate = getDailyRate(vehicleId); // Assume a method to get rate based on vehicle ID
        return dailyRate * rentalDays;
    }

    // Method to finalize a rental form
    public void finalizeRentalForm(String formId) {
        if (this.formId.equals(formId) && "Created".equals(this.rentalStatus)) {
            this.rentalStatus = "Finalized";
            displayFormStep("finalize");
        } else {
            System.out.println("Cannot finalize rental form. Either form ID does not match or rental is already cancelled/finalized.");
        }
    }

    // Switch-based display method for different form actions
    private void displayFormStep(String action) {
        switch (action.toLowerCase()) {
            case "create":
                System.out.println("Rental Form Created:");
                System.out.println("Form ID: " + formId);
                System.out.println("Client ID: " + clientId);
                System.out.println("Vehicle ID: " + vehicleId);
                System.out.println("Rental Date: " + rentalDate);
                System.out.println("Return Date: " + returnDate);
                System.out.println("Rental Cost: $" + rentalCost);
                System.out.println("Status: " + rentalStatus);
                break;
                
            case "update":
                System.out.println("Rental Form Updated:");
                System.out.println("Form ID: " + formId);
                System.out.println("New Rental Date: " + rentalDate);
                System.out.println("New Return Date: " + returnDate);
                System.out.println("Updated Rental Cost: $" + rentalCost);
                System.out.println("Status: " + rentalStatus);
                break;
                
            case "cancel":
                System.out.println("Rental Form Cancelled:");
                System.out.println("Form ID: " + formId);
                System.out.println("Status: " + rentalStatus);
                break;
                
            case "finalize":
                System.out.println("Rental Form Finalized:");
                System.out.println("Form ID: " + formId);
                System.out.println("Total Cost: $" + rentalCost);
                System.out.println("Status: " + rentalStatus);
                break;
                
            default:
                System.out.println("Unknown action.");
                break;
        }
    }

    // Helper method to generate a unique form ID
    private String generateFormId() {
        return "RF-" + System.currentTimeMillis();
    }

    // Helper method to calculate rental days from dates
    private int calculateRentalDays(String rentalDate, String returnDate) {
        LocalDate start = LocalDate.parse(rentalDate);
        LocalDate end = LocalDate.parse(returnDate);
        return (int) ChronoUnit.DAYS.between(start, end);
    }

    // Placeholder method to get the daily rate for a vehicle
    private double getDailyRate(String vehicleId) {
        return 100.0; // Example daily rate, replace with actual logic
    }
}

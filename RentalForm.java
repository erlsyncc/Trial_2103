
package vehiclerentasystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

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
        
        System.out.println("Rental form created with ID: " + formId);
        System.out.println("Rental days: " + rentalDays);
        System.out.println("Rental cost: $" + rentalCost);
    }
    
    
    public void updateRentalForm(String newRentalDate, String newReturnDate, String newReturnDate1) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter rental form ID to update: ");
        String inputFormId = scanner.next();
        
        if (this.formId.equals(inputFormId) && !"Finalized".equals(this.rentalStatus)) {
            this.rentalDate = newRentalDate;
            this.returnDate = newReturnDate;
            int rentalDays = calculateRentalDays(newRentalDate, newReturnDate);
            this.rentalCost = calculateRentalCost(vehicleId, rentalDays);
            System.out.println("Rental form updated.");
        } else {
            System.out.println("Cannot update rental form. Either form ID does not match or rental is already finalized.");
        }
    }

    // Method to cancel a rental form
    public void cancelRentalForm() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter rental form ID to cancel: ");
        String inputFormId = scanner.next();
        
        if (this.formId.equals(inputFormId) && !"Finalized".equals(this.rentalStatus)) {
            this.rentalStatus = "Cancelled";
            System.out.println("Rental form cancelled.");
        } else {
            System.out.println("Cannot cancel rental form. Either form ID does not match or rental is already finalized.");
        }
    }


    // Method to calculate rental cost
    public double calculateRentalCost(String vehicleId, int rentalDays) {
        double dailyRate = getDailyRate(vehicleId); // Assume a method to get rate based on vehicle ID
        return dailyRate * rentalDays;
    }


    // Method to finalize a rental form
    public void finalizeRentalForm(String formId) {
        if (this.formId.equals(formId) && "Created".equals(this.rentalStatus)) {
            this.rentalStatus = "Finalized";
            System.out.println("Rental form finalized.");
        } else {
            System.out.println("Cannot finalize rental form. Either form ID does not match or rental is already cancelled/finalized.");
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

    void cancelRentalForm(String rF001) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}




package vehiclerentasystem;
import java.time.LocalDate;

public class rentingStatus {
    private String userId;
    private String userName;
    private String rentalFormId;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private String paymentStatus;
    private double rentalCost;
    private boolean isCancelled;

    // Constructor to initialize rental status
    public rentingStatus (String userId, String userName, String rentalFormId, LocalDate rentalDate, LocalDate returnDate, String paymentStatus, double rentalCost) {
        this.userId = userId;
        this.userName = userName;
        this.rentalFormId = rentalFormId;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.paymentStatus = paymentStatus;
        this.rentalCost = rentalCost;
        this.isCancelled = false; // By default, the booking is not cancelled
    }

    // Method to display rental status details
    public void displayRentalDetails() {
        System.out.println("User Name: " + userName);
        System.out.println("User ID: " + userId);
        System.out.println("Rental Form ID: " + rentalFormId);
        System.out.println("Rental Start Date: " + rentalDate);
        System.out.println("Rental End Date: " + returnDate);
        System.out.println("Payment Status: " + paymentStatus);
        System.out.println("Rental Cost: $" + rentalCost);
        System.out.println("Booking Status: " + (isCancelled ? "Cancelled" : "Active"));
    }

    // Method to cancel the booking
    public void cancelBooking() {
        if (!isCancelled) {
            isCancelled = true;
            paymentStatus = "Refunded"; // Update as needed if refund processing is handled elsewhere
            System.out.println("Booking for " + userName + " has been cancelled.");
        } else {
            System.out.println("This booking is already cancelled.");
        }
    }

    // Method to display a receipt
    public void displayReceipt() {
        if (!isCancelled) {
            System.out.println("----- Receipt -----");
            System.out.println("User Name: " + userName);
            System.out.println("User ID: " + userId);
            System.out.println("Rental Form ID: " + rentalFormId);
            System.out.println("Rental Start Date: " + rentalDate);
            System.out.println("Rental End Date: " + returnDate);
            System.out.println("Total Cost: $" + rentalCost);
            System.out.println("Payment Status: " + paymentStatus);
            System.out.println("-------------------");
        } else {
            System.out.println("Receipt cannot be displayed. The booking has been cancelled.");
        }
    }

    // Getters and Setters (if needed)
    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getRentalFormId() {
        return rentalFormId;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public boolean isCancelled() {
        return isCancelled;
    }
}

package vehiclerentasystem;

import java.time.LocalDate;

// Base Payment class
public abstract class Payments {
    protected String paymentId;
    protected String formId;
    protected double amountDue;
    protected double amountPaid;
    protected String paymentDate;
    protected String paymentStatus;

    // Constructor
    public Payments(String formId, double amountDue) {
        this.paymentId = generatePaymentId();
        this.formId = formId;
        this.amountDue = amountDue;
        this.amountPaid = 0.0;
        this.paymentDate = null;
        this.paymentStatus = "Pending";
    }

    // Abstract method 
    public abstract void makePayment();

    // Helper method to generate a unique payment ID
    private String generatePaymentId() {
        return "PMT-" + System.currentTimeMillis();
    }
    
    // Method to display payment details
    protected void displayPaymentInfo() {
        System.out.println("Payment ID: " + paymentId);
        System.out.println("Rental Form ID: " + formId);
        System.out.println("Amount Due: $" + amountDue);
        System.out.println("Amount Paid: $" + amountPaid);
        System.out.println("Payment Date: " + paymentDate);
        System.out.println("Payment Status: " + paymentStatus);
    }
}

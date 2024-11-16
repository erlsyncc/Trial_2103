package vehiclerentasystem;

import java.time.LocalDate;
import java.util.Scanner;

public class PayCredit extends Payments {
    private String cardNumber;
    private String cardHolderName;
    private String expirationDate;
    
    public PayCredit (String formId, double amountDue) {
        super(formId, amountDue);
    }

    @Override
    public void makePayment() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter credit card number: ");
        cardNumber = scanner.nextLine();
        
        System.out.print("Enter cardholder name: ");
        cardHolderName = scanner.nextLine();
        
        System.out.print("Enter expiration date (MM/YY): ");
        expirationDate = scanner.nextLine();

        System.out.print("Enter payment amount: $");
        double paymentAmount = scanner.nextDouble();
        
        processPayment(paymentAmount);
    }

    private void processPayment(double paymentAmount) {
        if (paymentAmount >= amountDue) {
            amountPaid = amountDue;
            amountDue = 0.0;
            paymentStatus = "Completed";
            paymentDate = LocalDate.now().toString();
        } else {
            amountPaid += paymentAmount;
            amountDue -= paymentAmount;
            paymentStatus = "Partial Payment";
            paymentDate = LocalDate.now().toString();
        }

        displayPaymentInfo();
    }
}


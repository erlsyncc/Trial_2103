
package vehiclerentasystem;

import java.time.LocalDate;
import java.util.Scanner;

public class PayCash extends Payments {

    public PayCash (String formId, double amountDue) {
        super(formId, amountDue);
    }

    @Override
    public void makePayment() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter payment amount in cash: $");
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

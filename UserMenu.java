
package vehiclerentasystem;
import java.util.Scanner;

public class UserMenu {

    private Scanner scanner = new Scanner(System.in);

    public void displayUserMenu() {
        int userChoice = 0;
        
        while (userChoice != 5) {
            System.out.println("\nUser Menu:");
            System.out.println("1. Input Client Information");
            System.out.println("2. Create Rental Form");
            System.out.println("3. View Rental Status");
            System.out.println("4. View Available Vehicles");
            System.out.println("5. Exit");

            System.out.print("Please choose an option (1-5): ");
            userChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (userChoice) {
                case 1:
                    inputClientDetails();
                    break;
                case 2:
                    createRentalForm();
                    break;
                case 3:
                    viewRentalStatus();
                    break;
                case 4:
                    viewAvailableVehicles();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to input client information
    private void inputClientDetails() {
        Client_Input client = new Client_Input();
        client.inputClientDetails();

        // Display the entered client information
        System.out.println("\nClient Information:");
        System.out.println(client);
    }
    
    // Method to create a rental form
    private void createRentalForm() {
        System.out.println("\nCreating Rental Form...");
        // Assuming client info is already entered
        System.out.print("Enter rental start date (YYYY-MM-DD): ");
        String rentalDate = scanner.nextLine();
        System.out.print("Enter return date (YYYY-MM-DD): ");
        String returnDate = scanner.nextLine();

        // Assuming client ID is hardcoded here, but you would pull this from the Client_Input object
        RentalForm rental = new RentalForm("RF-001", "Client123", "VH-456", rentalDate, returnDate, 0.0, "Pending");
        rental.createRentalForm("Client123", "VH-456", rentalDate, returnDate);
    }

    // Method to view rental status
    private void viewRentalStatus() {
        System.out.println("\nViewing Rental Status...");
        // You would need to check the status of a rental form here, let's assume we pull it up by ID
        System.out.print("Enter rental form ID to view status: ");
        String formId = scanner.nextLine();

        // Example rental status
        System.out.println("Rental Form ID: " + formId);
        System.out.println("Status: Pending"); // Replace this with actual status check logic
    }

    // Method to view available vehicles
    private void viewAvailableVehicles() {
        System.out.println("\nAvailable Vehicles:");
        System.out.println("Vehicle ID: VH-001 | Model: Sedan | Status: Available");
        System.out.println("Vehicle ID: VH-002 | Model: SUV | Status: Available");
        System.out.println("Vehicle ID: VH-003 | Model: Truck | Status: Unavailable");
        // Add logic to show actual available vehicles
    }
}
    

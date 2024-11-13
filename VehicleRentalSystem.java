package vehiclerentasystem;

import java.util.Scanner;

public class VehicleRentalSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user to input their role (Admin or User)
        System.out.println("Enter your role (Admin/User):");
        String role = scanner.nextLine().trim().toLowerCase();

        if (role.equals("admin")) {
            // Admin section
            System.out.println("Welcome, Admin!");
            AdminMenu.displayMenu(); // Display the Admin Menu options
        } else if (role.equals("user")) {
            // User section: Create an instance of UserMenu and display its menu
            UserMenu userMenu = new UserMenu();
            userMenu.displayUserMenu();  // Display User Menu and process actions
        } else {
            System.out.println("Invalid role. Please enter 'Admin' or 'User'.");
        }

        // Close the scanner to avoid resource leakage
        scanner.close();
    }
}

package vehiclerentasystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleInventory {
    private static List<Vehicles> vehiclesList = new ArrayList<>();  // In-memory database for vehicles
    private static Scanner scanner = new Scanner(System.in);

    public static void displayMenu() {
        int choice;
        do {
            System.out.println("\nVehicle Inventory:");
            System.out.println("1. Show Available Vehicles");
            System.out.println("2. Add New Vehicle");
            System.out.println("3. Update Vehicle");
            System.out.println("4. Delete Vehicle");
            System.out.println("5. Show All Vehicles");
            System.out.println("6. Back to Main Menu");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    showAvailableVehicles();
                    break;
                case 2:
                    addNewVehicle();
                    break;
                case 3:
                    updateVehicle();
                    break;
                case 4:
                    deleteVehicle();
                    break;
                case 5:
                    showAllVehicles();
                    break;
                case 6:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 6);
    }

    // Method to show all available vehicles
    public static void showAvailableVehicles() {
        if (vehiclesList.isEmpty()) {
            System.out.println("No available vehicles in the inventory.");
        } else {
            System.out.println("Available Vehicles:");
            for (Vehicles vehicle : vehiclesList) {
                System.out.println(vehicle);
            }
        }
    }

    // Helper method to add a new vehicle
    private static void addNewVehicle() {
        System.out.print("Enter Vehicle Type (Car, Truck, Van, Motor, SUV): ");
        String vehicleType = scanner.nextLine().toLowerCase();

        System.out.print("Enter Vehicle ID: ");
        String vehicleID = scanner.nextLine();
        System.out.print("Enter Vehicle Make: ");
        String make = scanner.nextLine();
        System.out.print("Enter Vehicle Model: ");
        String model = scanner.nextLine();
        System.out.print("Enter Vehicle Rental Rate: ");
        double rentalRate = scanner.nextDouble();
        scanner.nextLine(); // Consume newline after double input

        Vehicles newVehicle = null;

        switch (vehicleType) {
            case "car":
                newVehicle = new VehicleCar(vehicleID, make, model, "Available", rentalRate, "Available");
                break;
            case "truck":
                System.out.print("Enter Load Capacity (in tons): ");
                double loadCapacity = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                newVehicle = new VehicleTruck(vehicleID, make, model, "Available", rentalRate, loadCapacity);
                break;
            case "van":
                System.out.print("Enter Seating Capacity: ");
                int seatingCapacity = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                newVehicle = new VehicleVan(vehicleID, make, model, rentalRate, "Available", seatingCapacity);
                break;
            case "motor":
                System.out.print("Has Sidecar? (true/false): ");
                boolean hasSideCar = scanner.nextBoolean();
                scanner.nextLine(); // Consume newline
                newVehicle = new VehicleMotor(vehicleID, make, model, "Available", rentalRate, hasSideCar);
                break;
            case "suv":
                System.out.print("Is Four-Wheel Drive? (true/false): ");
                boolean isFourWheelDrive = scanner.nextBoolean();
                scanner.nextLine(); // Consume newline
                newVehicle = new VehicleSuv( vehicleID, make, model, "Available", rentalRate, isFourWheelDrive);
                break;
            default:
                System.out.println("Invalid vehicle type.");
                return;
        }

        vehiclesList.add(newVehicle);
        System.out.println("Vehicle added successfully: " + newVehicle);
    }

    // Helper method to update a vehicle
    private static void updateVehicle() {
        System.out.print("Enter Vehicle ID to update: ");
        String vehicleID = scanner.nextLine();

        Vehicles vehicleToUpdate = findVehicleByID(vehicleID);
        if (vehicleToUpdate != null) {
            System.out.print("Enter New Vehicle Make: ");
            String newMake = scanner.nextLine();
            System.out.print("Enter New Vehicle Model: ");
            String newModel = scanner.nextLine();
            System.out.print("Enter New Vehicle Rental Rate: ");
            double newRentalRate = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            vehicleToUpdate.setMake(newMake);
            vehicleToUpdate.setModel(newModel);
            vehicleToUpdate.setRentalRate(newRentalRate);

            System.out.println("Vehicle updated successfully: " + vehicleToUpdate);
        } else {
            System.out.println("Vehicle with ID " + vehicleID + " not found.");
        }
    }

    // Helper method to delete a vehicle
    private static void deleteVehicle() {
        System.out.print("Enter Vehicle ID to delete: ");
        String vehicleID = scanner.nextLine();

        Vehicles vehicleToDelete = findVehicleByID(vehicleID);
        if (vehicleToDelete != null) {
            vehiclesList.remove(vehicleToDelete);
            System.out.println("Vehicle deleted successfully: " + vehicleToDelete);
        } else {
            System.out.println("Vehicle with ID " + vehicleID + " not found.");
        }
    }

    // Helper method to find a vehicle by ID
    private static Vehicles findVehicleByID(String vehicleID) {
        for (Vehicles vehicle : vehiclesList) {
            if (vehicle.getRegistrationNumber().equals(vehicleID)) {
                return vehicle;
            }
        }
        return null;  // Return null if vehicle not found
    }

    // Method to show all vehicles
    private static void showAllVehicles() {
        if (vehiclesList.isEmpty()) {
            System.out.println("No vehicles in the inventory.");
        } else {
            System.out.println("All vehicles in the inventory:");
            for (Vehicles vehicle : vehiclesList) {
                System.out.println(vehicle);
            }
        }
    }
}

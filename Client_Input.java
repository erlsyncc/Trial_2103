package vehiclerentasystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client_Input {
    private String clientID;
    private String clientName;
    private String clientAddress;
    private String clientContact;
    private String clientEmail;
    private String rentingStatus;

    // Constructor for the Client class
    Client_Input() {
        this.clientID = clientID;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.clientContact = clientContact;
        this.clientEmail = clientEmail;
        this.rentingStatus = rentingStatus;
    }


    // Getters and Setters
    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getClientContact() {
        return clientContact;
    }

    public void setClientContact(String clientContact) {
        this.clientContact = clientContact;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getRentingStatus() {
        return rentingStatus;
    }

    public void setRentingStatus(String rentingStatus) {
        this.rentingStatus = rentingStatus;
    }

    @Override
    public String toString() {
        return "Client ID: " + clientID +
                "\nName: " + clientName +
                "\nAddress: " + clientAddress +
                "\nContact: " + clientContact +
                "\nEmail: " + clientEmail +
                "\nRenting Status: " + rentingStatus + "\n";
    }

    // List to store all clients
    private List<Client_Input> clients = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Method to show all clients
    public void showClientList() {
        if (clients.isEmpty()) {
            System.out.println("No clients found.");
        } else {
            System.out.println("Client List:");
            for (Client_Input client : clients) {
                System.out.println(client.toString());
            }
        }
    }

    // Method to add a new client
    public void addClient(String clientID, String clientName, String clientAddress, String clientContact, String clientEmail, String rentingStatus) {
        if (findClientByID(clientID) != null) {
            System.out.println("Client with ID " + clientID + " already exists.");
        } else {
            Client_Input newClient = new Client_Input();
            clients.add(newClient);
            System.out.println("Client added successfully.");
        }
    }

    // Method to update client information
    public void updateClient(String clientID, String newName, String newAddress, String newContact, String newEmail, String newRentingStatus) {
        Client_Input client = findClientByID(clientID);
        if (client != null) {
            client.setClientName(newName);
            client.setClientAddress(newAddress);
            client.setClientContact(newContact);
            client.setClientEmail(newEmail);
            client.setRentingStatus(newRentingStatus);
            System.out.println("Client information updated successfully.");
        } else {
            System.out.println("Client with ID " + clientID + " not found.");
        }
    }

    // Method to delete a client
    public void deleteClient(String clientID) {
        Client_Input client = findClientByID(clientID);
        if (client != null) {
            clients.remove(client);
            System.out.println("Client deleted successfully.");
        } else {
            System.out.println("Client with ID " + clientID + " not found.");
        }
    }

    // Helper method to find a client by their ID
    private Client_Input findClientByID(String clientID) {
        for (Client_Input client : clients) {
            if (client.getClientID().equals(clientID)) {
                return client;
            }
        }
        return null; // Return null if client not found
    }

    // Method to input client details from the user
    public void inputClientDetails() {
        // Prompt the user for client information
        System.out.print("Enter Client ID: ");
        String clientID = scanner.nextLine();

        System.out.print("Enter Client Name: ");
        String clientName = scanner.nextLine();

        System.out.print("Enter Client Address: ");
        String clientAddress = scanner.nextLine();

        System.out.print("Enter Client Contact: ");
        String clientContact = scanner.nextLine();

        System.out.print("Enter Client Email: ");
        String clientEmail = scanner.nextLine();

        System.out.print("Enter Renting Status (e.g., Available, Rented): ");
        String rentingStatus = scanner.nextLine();

        // Add the new client to the list
        addClient(clientID, clientName, clientAddress, clientContact, clientEmail, rentingStatus);
    }

    // Non-static method
    public void manageVehicleRentalActions() {
        Vehicles vehicle1 = new Vehicles("V123", "ABC123", "Toyota", "Corolla", 50.0, "Car", "Available");
        Vehicles vehicle2 = new Vehicles("V124", "XYZ456", "Honda", "Civic", 60.0, "Car", "Available");

        // Loop to handle user interactions
        while (true) {
            Vehicles.displayUserVehicleChoices();  // This must be an instance method, or call it appropriately
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    System.out.println("Viewing vehicle details...");
                    System.out.println(vehicle1.toString());
                    System.out.println(vehicle2.toString());
                    break;
                case 2:
                    System.out.println("Checking vehicle availability...");
                    System.out.println("Vehicle 1: " + vehicle1.getVehicleStatus());
                    System.out.println("Vehicle 2: " + vehicle2.getVehicleStatus());
                    break;
                case 3:
                    System.out.println("Renting a vehicle...");
                    System.out.print("Enter vehicle ID: ");
                    String vehicleId = scanner.nextLine();
                    System.out.print("Enter rental date (yyyy-mm-dd): ");
                    String rentalDate = scanner.nextLine();
                    System.out.print("Enter return date (yyyy-mm-dd): ");
                    String returnDate = scanner.nextLine();
                    System.out.println("Vehicle rented successfully.");
                    break;
                case 4:
                    System.out.println("Returning a vehicle...");
                    // Code to return a vehicle goes here
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;  // Exit the loop and return from the method
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }
}

